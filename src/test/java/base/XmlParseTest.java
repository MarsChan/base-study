package base;

import org.junit.Test;
import pers.marscheng.base.XmlParse;

/**
 * @program: xmlparse
 * @description: xml解析工具测试类
 * @author: Marscheng
 * @create: 2020-11-05 19:28
 **/

public class XmlParseTest {

    @Test
    public void testCheckFormat2(){
        String testXml1 = "<></>";
        System.out.println(testXml1 + ":"+ XmlParse.checkFormat(testXml1));

        testXml1 = "<a>";
        System.out.println(testXml1 + ":" + XmlParse.checkFormat(testXml1));

        testXml1 = "<a><b></a></b>";
        System.out.println(testXml1 + ":"+ XmlParse.checkFormat(testXml1));

        testXml1 = "<a> < /a>";
        System.out.println(testXml1 + ":"+ XmlParse.checkFormat(testXml1));

        testXml1 = "<a>text<b>other text</b></a>";
        System.out.println(testXml1 + ":"+ XmlParse.checkFormat(testXml1));

        testXml1 = "<a>text<b>other text</a></b>";
        System.out.println(testXml1 + ":"+ XmlParse.checkFormat(testXml1));

        testXml1 = "<a>text<b>other /text</b></a>";
        System.out.println(testXml1 + ":"+ XmlParse.checkFormat(testXml1));

    }
}
