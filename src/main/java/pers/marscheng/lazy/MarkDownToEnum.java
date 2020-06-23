package pers.marscheng.lazy;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @program: base-study
 * @description: markdown转枚举
 * @author: Marscheng
 * @create: 2020-06-23 15:34
 **/

public class MarkDownToEnum {

    public static void main(String[] args) {
        //1、获取文件输入流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("E:\\公司资料\\重要文档\\大额行号.xlsx");
            //2、获取Excel工作簿对象
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //3、得到Excel工作表对象
            XSSFSheet sheetAt = workbook.getSheetAt(0);

            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            // UPPERCASE：大写  (ZHONG)  
            // LOWERCASE：小写  (zhong)  
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // WITHOUT_TONE：无音标  (zhong)  
        // WITH_TONE_NUMBER：1-4数字表示英标  (zhong4)  
        // WITH_TONE_MARK：直接用音标符（必须WITH_U_UNICODE否则异常）  (zhòng)  
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // WITH_V：用v表示ü  (nv)  
        // WITH_U_AND_COLON：用"u:"表示ü  (nu:)  
        // WITH_U_UNICODE：直接用ü (nü)  
            format.setVCharType(HanyuPinyinVCharType.WITH_V);

            for (Row row : sheetAt) {
                if (row.getRowNum() == 0) {
                    continue;
                }


                String fullName = row.getCell(1).getStringCellValue();
                String name = row.getCell(2).getStringCellValue();
                StringBuilder enumName =new StringBuilder();
                for(char c:name.toCharArray()){
                    String[] result = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    if(result!=null) {
                        enumName.append(result[0]);
                    }
                }
                String bankCode = row.getCell(3).getStringCellValue();
                String cnapsBranchId = row.getCell(4).getStringCellValue();
                if (row.getRowNum() == sheetAt.getLastRowNum()) {
                    contentToTxt("E:\\result.txt", enumName.toString() + "(\"" + fullName + "\"," + "\"" + name + "\"," + "\"" + bankCode + "\"," + "\"" + cnapsBranchId + "\");");
                } else {
                    contentToTxt("E:\\result.txt", enumName.toString() + "(\"" + fullName + "\"," + "\"" + name + "\"," + "\"" + bankCode + "\"," + "\"" + cnapsBranchId + "\"),");
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
    }


    public static void contentToTxt(String filePath, String content) {
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(f, true));
            output.write(content + "\n");
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
