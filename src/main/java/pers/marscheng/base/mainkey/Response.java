package pers.marscheng.base.mainkey;

/**
 * @version 1.0
 * @className Response
 * @description
 * @author: marscheng
 * @date: 2020-06-27 8:24 PM
 */
public class Response<T> {
    public static <T> Response<T> writeSuccess(String text){
        return writeSuccess(text,null);
    }

    public static <T> Response<T> writeSuccess(Object data){
        return writeSuccess(null,data);
    }

    private static <T> Response<T> writeSuccess(String text, Object o) {
        return null;
    }

    public static void main(String[] args) {
        Object domain = null;
        Response.writeSuccess(null);
        //Response.writeSuccess(domain);
    }
}
