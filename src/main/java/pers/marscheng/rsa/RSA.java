//package pers.marscheng.rsa;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import java.io.BufferedReader;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.security.KeyFactory;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.Signature;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.Base64;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * RSA 非对称加密算法
// */
//public class RSA {
//    private static final String[] TRANSFORMATIONS = {"RSA/ECB/PKCS1Padding", "RSA/ECB/OAEPWithSHA-1AndMGF1Padding", "RSA/ECB/OAEPWithSHA-256AndMGF1Padding"};
//
//    /**
//     * 生成一对base64编码的RSA公私钥，公钥采用X.509格式，私钥采用PKCS8格式
//     *
//     * @param length 密钥长度，单位比特，长度支持最少1024 bits，安全和性能角度考虑建议采用2048 bits
//     * @return 一对RSA公私钥，[public_key, private_key]
//     * @throws IllegalArgumentException 密钥长度少于1024 bits
//     */
//    public static String[] generateKeyPair(int length) {
//        if (length < 1024) throw new IllegalArgumentException("length must be at least 1024 bits");
//        try {
//            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
//            kpg.initialize(length);
//            KeyPair kp = kpg.generateKeyPair();
//            return new String[]{Base64.getEncoder().encodeToString(kp.getPublic().getEncoded()), Base64.getEncoder().encodeToString(kp.getPrivate().getEncoded())};
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 生成包含一对PEM编码的RSA公私钥并导出到指定路径，公钥采用X.509格式，私钥采用PKCS8格式
//     *
//     * @param length         密钥长度，单位比特，长度支持最少1024 bits，安全和性能角度考虑建议采用2048 bits
//     * @param publicKeyPath  公钥导出路径
//     * @param privateKeyPath 私钥导出路径
//     * @throws IllegalArgumentException 密钥长度少于1024 bits
//     * @throws IOException              文件保存错误
//     */
//    public static void generateKeyPairThenExport(int length, String publicKeyPath, String privateKeyPath) throws IOException {
//        String[] pair = generateKeyPair(length);
//        try (OutputStream pub = new FileOutputStream(publicKeyPath);
//             OutputStream pri = new FileOutputStream(privateKeyPath)) {
//            pub.write(convertPublicKeyToPEMFormat(pair[0]).getBytes());
//            pri.write(convertPrivateKeyToPEMFormat(pair[1]).getBytes());
//        }
//    }
//
//    /**
//     * 转换成PEM编码的RSA公私钥，头尾添加标识符，每64个字符回车
//     *
//     * @param keys 一对base64编码的RSA公私钥，[public_key, private_key]
//     * @return PEM编码的RSA公私钥，[public_key, private_key]
//     */
//    public static String[] convertKeysToPEMFormat(String[] keys) {
//        return new String[]{convertPublicKeyToPEMFormat(keys[0]), convertPrivateKeyToPEMFormat(keys[1])};
//    }
//
//    /**
//     * 转换成PEM编码的RSA公钥，头尾添加标识符，每64个字符回车
//     *
//     * @param key base64编码的RSA公钥
//     * @return PEM编码的RSA公钥
//     */
//    public static String convertPublicKeyToPEMFormat(String key) {
//        return wrap(key, "PUBLIC");
//    }
//
//    /**
//     * 转换成PEM编码的私钥，头尾添加标识符，每64个字符回车
//     *
//     * @param key base64编码的RSA私钥
//     * @return PEM编码的RSA私钥
//     */
//    public static String convertPrivateKeyToPEMFormat(String key) {
//        return wrap(key, "PRIVATE");
//    }
//
//    private static String wrap(String key, String type) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("-----BEGIN %s KEY-----\n", type));
//        for (int i = 0; i <= key.length(); i += 64) {
//            sb.append(key, i, Math.min(i + 64, key.length()));
//            sb.append("\n");
//        }
//        sb.append(String.format("-----END %s KEY-----\n", type));
//        return sb.toString();
//    }
//
//    /**
//     * 构造线程安全的RSA公钥对象，用此方法避免重复创建对象
//     *
//     * @param publicKey 采用X.509封装格式base64或PEM编码的RSA公钥字符串
//     * @return RSA公钥对象
//     * @throws CipherException 密钥内容非法
//     */
//    public static RSAPublicKey getPublicKey(String publicKey) throws CipherException {
//        return getPublicKey(reserveBody(publicKey).getBytes());
//    }
//
//    private static String reserveBody(String key) {
//        return Stream.of(key.split("\n")).filter(s -> !s.startsWith("-")).collect(Collectors.joining("\n"));
//    }
//
//    /**
//     * 构造线程安全的RSA公钥对象，用此方法避免重复创建对象
//     *
//     * @param publicKeyPath 采用X.509封装格式base64或PEM编码的RSA公钥文件路径
//     * @return RSA公钥对象
//     * @throws IOException     读取公钥文件异常
//     * @throws CipherException 密钥内容非法
//     */
//    public static RSAPublicKey getPublicKeyFromFile(String publicKeyPath) throws CipherException, IOException {
//        return getPublicKey(readLines(publicKeyPath).getBytes());
//    }
//
//    private static RSAPublicKey getPublicKey(byte[] publicKey) throws CipherException {
//        try {
//            byte[] buffer = Base64.getMimeDecoder().decode(publicKey);
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
//            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
//        } catch (Exception e) {
//            throw new CipherException(e);
//        }
//    }
//
//    private static String readLines(String path) throws IOException {
//        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8)) {
//            StringBuilder sb = new StringBuilder();
//            for (; ; ) {
//                String line = reader.readLine();
//                if (line == null) break;
//                if (line.startsWith("-")) continue;
//                sb.append(line).append("\n");
//            }
//            return sb.toString();
//        }
//    }
//
//    /**
//     * 构造线程安全的RSA私钥对象，用此方法避免重复创建对象
//     *
//     * @param privateKey 采用PKCS8封装格式base64或PEM编码的RSA私钥字符串
//     * @return RSA私钥对象
//     * @throws CipherException 密钥内容非法
//     */
//    public static RSAPrivateKey getPrivateKey(String privateKey) throws CipherException {
//        return getPrivateKey(reserveBody(privateKey).getBytes());
//    }
//
//    /**
//     * 构造线程安全的RSA私钥对象，用此方法避免重复创建对象
//     *
//     * @param privateKeyPath 采用PKCS8封装格式base64或PEM编码的RSA私钥文件路径
//     * @return RSA私钥对象
//     * @throws IOException     读取私钥文件异常
//     * @throws CipherException 密钥内容非法
//     */
//    public static RSAPrivateKey getPrivateKeyFromFile(String privateKeyPath) throws CipherException, IOException {
//        return getPrivateKey(readLines(privateKeyPath).getBytes());
//    }
//
//    private static RSAPrivateKey getPrivateKey(byte[] privateKey) throws CipherException {
//        try {
//            byte[] buffer = Base64.getMimeDecoder().decode(privateKey);
//            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
//        } catch (Exception e) {
//            throw new CipherException(e);
//        }
//    }
//
//    /**
//     * 对byte数组做签名
//     *
//     * @param mode       签名模式
//     * @param input      待签名byte数组
//     * @param privateKey 采用PKCS8封装格式base64或PEM编码的RSA私钥字符串
//     * @return 签名结果
//     * @throws CipherException 签名错误
//     */
//    public static byte[] sign(Mode mode, byte[] input, String privateKey) throws CipherException {
//        return sign(mode, input, getPrivateKey(privateKey));
//    }
//
//    /**
//     * 对byte数组做签名
//     *
//     * @param mode       签名模式
//     * @param input      待签名byte数组
//     * @param privateKey RSA私钥
//     * @return 签名结果
//     * @throws CipherException 签名错误
//     */
//    public static byte[] sign(Mode mode, byte[] input, RSAPrivateKey privateKey) throws CipherException {
//        try {
//            Signature signature = Signature.getInstance(mode.name());
//            signature.initSign(privateKey);
//            signature.update(input);
//            return signature.sign();
//        } catch (Exception e) {
//            throw new CipherException(e);
//        }
//    }
//
//    /**
//     * 对字符串做签名返回base64编码签名字符串
//     *
//     * @param mode       签名模式
//     * @param input      待签名字符串
//     * @param privateKey 采用PKCS8封装格式base64或PEM编码的RSA私钥字符串
//     * @return base64编码签名字符串
//     * @throws CipherException 签名错误
//     */
//    public static String sign(Mode mode, String input, String privateKey) throws CipherException {
//        return sign(mode, input, getPrivateKey(privateKey));
//    }
//
//    /**
//     * 对字符串做签名返回base64编码签名字符串
//     *
//     * @param mode       签名模式
//     * @param input      待签名字符串
//     * @param privateKey RSA私钥
//     * @return base64编码签名字符串
//     * @throws CipherException 签名错误
//     */
//    public static String sign(Mode mode, String input, RSAPrivateKey privateKey) throws CipherException {
//        return Base64.getEncoder().encodeToString(sign(mode, input.getBytes(), privateKey));
//    }
//
//    /**
//     * 对签名byte数组做验签
//     *
//     * @param mode      签名模式
//     * @param input     待验签的原始byte数组
//     * @param sign      待验签的签名byte数组
//     * @param publicKey 采用X.509封装格式base64或PEM编码的RSA公钥字符串
//     * @return 验签成功返回true，失败返回false
//     * @throws CipherException 验签错误
//     */
//    public static boolean verify(Mode mode, byte[] input, byte[] sign, String publicKey) throws CipherException {
//        return verify(mode, input, sign, getPublicKey(publicKey));
//    }
//
//    /**
//     * 对签名byte数组做验签
//     *
//     * @param mode      签名模式
//     * @param input     待验签的原始byte数组
//     * @param sign      待验签的签名byte数组
//     * @param publicKey RSA公钥
//     * @return 验签成功返回true，失败返回false
//     * @throws CipherException 验签错误
//     */
//    public static boolean verify(Mode mode, byte[] input, byte[] sign, RSAPublicKey publicKey) throws CipherException {
//        try {
//            Signature signature = Signature.getInstance(mode.name());
//            signature.initVerify(publicKey);
//            signature.update(input);
//            return signature.verify(sign);
//        } catch (Exception e) {
//            throw new CipherException(e);
//        }
//    }
//
//    /**
//     * 对base64编码签名字符串做验签
//     *
//     * @param mode      签名模式
//     * @param input     待验签的原始字符串
//     * @param sign      待验签的base64编码签名字符串
//     * @param publicKey 采用X.509封装格式base64或PEM编码的RSA公钥字符串
//     * @return 验签成功返回true，失败返回false
//     * @throws CipherException 验签错误
//     */
//    public static boolean verify(Mode mode, String input, String sign, String publicKey) throws CipherException {
//        return verify(mode, input, sign, getPublicKey(publicKey));
//    }
//
//    /**
//     * 对base64编码签名字符串做验签
//     *
//     * @param mode      签名模式
//     * @param input     待验签的原始byte数组
//     * @param sign      待验签的base64编码签名字符串
//     * @param publicKey RSA公钥
//     * @return 验签成功返回true，失败返回false
//     * @throws CipherException 验签错误
//     */
//    public static boolean verify(Mode mode, String input, String sign, RSAPublicKey publicKey) throws CipherException {
//        return verify(mode, input.getBytes(), Base64.getMimeDecoder().decode(sign), publicKey);
//    }
//
//    /**
//     * 加密byte数组
//     *
//     * @param input     待加密byte数组
//     * @param publicKey 采用X.509封装格式base64或PEM编码的RSA公钥字符串
//     * @return 加密结果
//     * @throws CipherException 密钥内容非法或加密错误
//     */
//    public static byte[] encrypt(byte[] input, String publicKey) throws CipherException {
//        return encrypt(input, getPublicKey(publicKey));
//    }
//
//    /**
//     * 加密byte数组
//     *
//     * @param input     待加密byte数组
//     * @param publicKey RSA公钥
//     * @return 加密结果
//     * @throws CipherException 密钥内容非法或加密错误
//     */
//    public static byte[] encrypt(byte[] input, RSAPublicKey publicKey) throws CipherException {
//        try {
//            Cipher cipher = Cipher.getInstance("RSA");
//            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//            return cipher.doFinal(input);
//        } catch (Exception e) {
//            throw new CipherException(e);
//        }
//    }
//
//    /**
//     * 加密字符串返回base64编码字符串
//     *
//     * @param input     待加密byte数组
//     * @param publicKey 采用X.509封装格式base64或PEM编码的RSA公钥字符串
//     * @return 加密后base64编码字符串
//     * @throws CipherException 密钥内容非法或加密错误
//     */
//    public static String encrypt(String input, String publicKey) throws CipherException {
//        return encrypt(input, getPublicKey(publicKey));
//    }
//
//    /**
//     * 加密字符串返回base64编码字符串
//     *
//     * @param input     待加密byte数组
//     * @param publicKey RSA公钥
//     * @return 加密后base64编码字符串
//     * @throws CipherException 密钥内容非法或加密错误
//     */
//    public static String encrypt(String input, RSAPublicKey publicKey) throws CipherException {
//        return Base64.getEncoder().encodeToString(encrypt(input.getBytes(), publicKey));
//    }
//
//    /**
//     * 解密byte数组
//     *
//     * @param input      待解密byte数组
//     * @param privateKey 采用PKCS8封装格式base64或PEM编码的RSA私钥字符串
//     * @return 解密结果
//     * @throws CipherException 密钥内容非法或解密错误
//     */
//    public static byte[] decrypt(byte[] input, String privateKey) throws CipherException {
//        return decrypt(input, getPrivateKey(privateKey));
//    }
//
//    /**
//     * 解密byte数组
//     *
//     * @param input      待解密byte数组
//     * @param privateKey RSA私钥
//     * @return 解密结果
//     * @throws CipherException 密钥内容非法或解密错误
//     */
//    public static byte[] decrypt(byte[] input, RSAPrivateKey privateKey) throws CipherException {
//        for (String transformation : TRANSFORMATIONS) {
//            try {
//                return decrypt(transformation, input, privateKey);
//            } catch (BadPaddingException ignore) {
//            } catch (Exception e) {
//                throw new CipherException(e);
//            }
//        }
//        throw new CipherException("BadPaddingException");
//    }
//
//    private static byte[] decrypt(String transformation, byte[] input, RSAPrivateKey privateKey) throws Exception {
//        Cipher cipher = Cipher.getInstance(transformation);
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);
//        return cipher.doFinal(input);
//    }
//
//    /**
//     * 解密base64编码字符串
//     *
//     * @param input      待解密base64编码字符串
//     * @param privateKey 采用PKCS8封装格式base64或PEM编码的RSA私钥字符串
//     * @return 解密后字符串
//     * @throws CipherException 密钥内容非法或解密错误
//     */
//    public static String decrypt(String input, String privateKey) throws CipherException {
//        return decrypt(input, getPrivateKey(privateKey));
//    }
//
//    /**
//     * 解密base64编码字符串
//     *
//     * @param input      待解密base64编码字符串
//     * @param privateKey RSA私钥
//     * @return 解密后字符串
//     * @throws CipherException 密钥内容非法或解密错误
//     */
//    public static String decrypt(String input, RSAPrivateKey privateKey) throws CipherException {
//        return new String(decrypt(Base64.getMimeDecoder().decode(input), privateKey));
//    }
//
//    /**
//     * 签名模式
//     */
//    public enum Mode {
//        NONEwithRSA,
//        MD2withRSA,
//        MD5withRSA,
//        SHA1withRSA,
//        SHA224withRSA,
//        SHA256withRSA,
//        SHA384withRSA,
//        SHA512withRSA
//    }
//}
