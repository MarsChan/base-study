package pers.marscheng.rpc;

import java.util.HashMap;
import java.util.Map;

/**
 * 隐式上下文参数
 *
 * @author: marscheng
 * @date: 2019-06-11 10:01 PM
 */
public class KKBContext {
    private static ThreadLocal<KKBContext> SERVER = new ThreadLocal<>();

    private static ThreadLocal<KKBContext> client = new ThreadLocal<>();

    private  final Map<String,String> attachments = new HashMap<>();




}
