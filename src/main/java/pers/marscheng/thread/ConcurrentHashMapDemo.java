package pers.marscheng.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: base-study
 * @description: 测试
 * @author: MarsCheng
 * @create: 2018-12-04 16:00
 **/
public class ConcurrentHashMapDemo {
    public static void main(String[] args){
        Map<String, String> map = new ConcurrentHashMap<>();
        //map.computeIfAbsent("AaAa",
        //        (String key) -> {
        //            map.put("BBBB", "value");
        //            return "value";
        //        });
        map.put("1","hh");

    }
}
