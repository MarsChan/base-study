package pers.marscheng.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-07-27 18:45
 **/

public class Test {
    public static void main(String[] args) {
        testMap();
    }

    public static void testMap(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> mapped = numbers.stream().map(x->x*2).collect(Collectors.toList());
        mapped.forEach(System.out::println);
    }
}
