package pers.marscheng.lazy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-09-17 13:54
 **/

public class StringRemove {

    public static String oldStr = " zhongguogongshangyinhang(\"中国工商银行\",\"中国工商银行\",\"102\",\"102100099996\"),\n" +
            "    zhongguonongyeyinhang(\"中国农业银行股份有限公司\",\"中国农业银行\",\"103\",\"103100000026\"),\n" +
            "    zhongguoyinhang(\"中国银行总行\",\"中国银行\",\"104\",\"104100000004\"),\n" +
            "    zhongguojiansheyinhang(\"中国建设银行股份有限公司总行\",\"中国建设银行\",\"105\",\"105100000017\"),\n" +
            "    jiaotongyinhang(\"交通银行\",\"交通银行\",\"301\",\"301290000007\"),\n" +
            "    zhongxinyinhang(\"中信银行股份有限公司\",\"中信银行\",\"302\",\"302100011000\"),\n" +
            "    zhongguoguangdayinhang(\"中国光大银行\",\"中国光大银行\",\"303\",\"303100000006\"),\n" +
            "    huaxiayinhang(\"华夏银行股份有限公司总行\",\"华夏银行\",\"304\",\"304100040000\"),\n" +
            "    zhongguominshengyinhang(\"中国民生银行\",\"中国民生银行\",\"305\",\"305100000013\"),\n" +
            "    guangfayinhanggufenyouxiangongsi(\"广发银行股份有限公司\",\"广发银行股份有限公司\",\"306\",\"306581000003\"),\n" +
            "    pinganyinhang(\"平安银行\",\"平安银行\",\"307\",\"307584007998\"),\n" +
            "    zhaoshangyinhang(\"招商银行股份有限公司\",\"招商银行\",\"308\",\"308584000013\"),\n" +
            "    xingyeyinhang(\"兴业银行总行\",\"兴业银行\",\"309\",\"309391000011\"),\n" +
            "    shanghaipudongfazhanyinhang(\"上海浦东发展银行\",\"上海浦东发展银行\",\"310\",\"310290000013\"),\n" +
            "    beijingyinhang(\"北京银行\",\"北京银行\",\"313\",\"313100000013\"),\n" +
            "    tianjinyinhang(\"天津银行股份有限公司\",\"天津银行\",\"313\",\"313110000017\"),\n" +
            "    hebeiyinhanggufenyouxiangongsi(\"河北银行股份有限公司\",\"河北银行股份有限公司\",\"313\",\"313121006888\"),\n" +
            "    tangshanyinhang(\"唐山银行股份有限公司\",\"唐山银行\",\"313\",\"313124000018\"),\n" +
            "    qinhuangdaoyinhang(\"秦皇岛银行股份有限公司\",\"秦皇岛银行\",\"313\",\"313126001022\"),\n" +
            "    handanyinhang(\"邯郸银行股份有限公司\",\"邯郸银行\",\"313\",\"313127000013\"),\n" +
            "    xingtaiyinhang(\"邢台银行股份有限公司\",\"邢台银行\",\"313\",\"313131000016\"),\n" +
            "    baodingyinhang(\"保定银行股份有限公司\",\"保定银行\",\"313\",\"313134000011\"),\n" +
            "    zhangjiakoushishangyeyinhang(\"张家口银行股份有限公司\",\"张家口市商业银行\",\"313\",\"313138000019\"),\n" +
            "    chengdeyinhang(\"承德银行股份有限公司\",\"承德银行\",\"313\",\"313141052422\"),\n" +
            "    cangzhouyinhang(\"沧州银行\",\"沧州银行\",\"313\",\"313143005157\"),\n" +
            "    langfangyinhang(\"廊坊银行股份有限公司\",\"廊坊银行\",\"313\",\"313146000019\"),\n" +
            "    hengshuiyinhang(\"衡水银行股份有限公司\",\"衡水银行\",\"313\",\"313148053964\"),\n" +
            "    jinshangyinhangwangshangyinhang(\"晋商银行股份有限公司\",\"晋商银行网上银行\",\"313\",\"313161000017\"),\n" +
            "    yangquanshishangyeyinhang(\"阳泉市商业银行股份有限公司\",\"阳泉市商业银行\",\"313\",\"313163000004\"),\n" +
            "    zhangzhiyinhang(\"长治银行\",\"长治银行\",\"313\",\"313164000006\"),\n" +
            "    jinchengyinhang(\"晋城银行\",\"晋城银行\",\"313\",\"313168000003\"),\n" +
            "    jinzhongyinhang(\"晋中银行\",\"晋中银行\",\"313\",\"313175000011\"),\n" +
            "    neimengguyinhang(\"内蒙古银行\",\"内蒙古银行\",\"313\",\"313191000011\"),\n" +
            "    baoshangyinhanggufenyouxiangongsi(\"包商银行股份有限公司\",\"包商银行股份有限公司\",\"313\",\"313192000013\"),\n" +
            "    wuhaiyinhang(\"乌海银行股份有限公司\",\"乌海银行\",\"313\",\"313193057846\"),\n" +
            "    eerduosiyinhang(\"鄂尔多斯银行股份有限公司\",\"鄂尔多斯银行\",\"313\",\"313205057830\"),\n" +
            "    shengjingyinhang(\"盛京银行清算中心\",\"盛京银行\",\"313\",\"313221030008\"),\n" +
            "    dalianyinhang(\"大连银行\",\"大连银行\",\"313\",\"313222080002\"),\n" +
            "    anshanshishangyeyinhang(\"鞍山市商业银行\",\"鞍山市商业银行\",\"313\",\"313223007007\"),\n" +
            "    fushunyinhang(\"抚顺银行股份有限公司清算中心\",\"抚顺银行\",\"313\",\"313224000015\"),\n" +
            "    dandongyinhangqingsuanzhongxin(\"丹东银行清算中心\",\"丹东银行清算中心\",\"313\",\"313226009000\"),\n" +
            "    jinzhouyinhang(\"锦州银行\",\"锦州银行\",\"313\",\"313227000012\"),\n" +
            "    huludaoyinhang(\"葫芦岛银行股份有限公司\",\"葫芦岛银行\",\"313\",\"313227600018\"),\n" +
            "    yingkouyinhang(\"营口银行股份有限公司资金清算中心\",\"营口银行\",\"313\",\"313228000276\"),\n" +
            "    yingkouyanhaiyinhanggufenyouxiangongsi(\"营口沿海银行股份有限公司\",\"营口沿海银行股份有限公司\",\"313\",\"313228060009\"),\n" +
            "    fuxinyinhangjiesuanzhongxin(\"阜新银行结算中心\",\"阜新银行结算中心\",\"313\",\"313229000008\"),\n" +
            "    liaoyangyinhanggufenyouxiangongsi(\"辽阳银行\",\"辽阳银行股份有限公司\",\"313\",\"313231000013\"),\n" +
            "    chaoyangyinhang(\"朝阳银行股份有限公司\",\"朝阳银行\",\"313\",\"313234001089\"),\n" +
            "    jilinyinhang(\"吉林银行\",\"吉林银行\",\"313\",\"313241066661\"),\n" +
            "    haerbinyinhangjiesuanzhongxin(\"哈尔滨银行结算中心\",\"哈尔滨银行结算中心\",\"313\",\"313261000018\"),\n" +
            "    longjiangyinhang(\"龙江银行股份有限公司\",\"龙江银行\",\"313\",\"313261099913\"),\n" +
            "    nanjingyinhang(\"南京银行股份有限公司\",\"南京银行\",\"313\",\"313301008887\"),\n" +
            "    jiangsuyinhanggufenyouxiangongsi(\"江苏银行股份有限公司\",\"江苏银行股份有限公司\",\"313\",\"313301099999\"),\n" +
            "    suzhouyinhang(\"苏州银行股份有限公司\",\"苏州银行\",\"313\",\"313305066661\"),\n" +
            "    jiangsuzhangjiangshanghang(\"江苏长江商业银行\",\"江苏长江商行\",\"313\",\"313312300018\"),\n" +
            "    hangzhouyinhang(\"杭州银行股份有限公司\",\"杭州银行\",\"313\",\"313331000014\"),\n" +
            "    ningbodonghaiyinhang(\"宁波东海银行股份有限公司\",\"宁波东海银行\",\"313\",\"313332040018\"),\n" +
            "    ningboyinhang(\"宁波银行股份有限公司\",\"宁波银行\",\"313\",\"313332082914\"),\n" +
            "    ningbotongshangyinhanggufenyouxiangongsi(\"宁波通商银行股份有限公司\",\"宁波通商银行股份有限公司\",\"313\",\"313332090019\"),\n" +
            "    wenzhouyinhang(\"温州银行股份有限公司\",\"温州银行\",\"313\",\"313333007331\"),\n" +
            "    jiaxingyinhangqingsuanzhongxin(\"嘉兴银行股份有限公司清算中心(不对外办理业务）\",\"嘉兴银行清算中心\",\"313\",\"313335081005\"),\n" +
            "    huzhouyinhang(\"湖州银行股份有限公司\",\"湖州银行\",\"313\",\"313336071575\"),\n" +
            "    shaoxingyinhang(\"绍兴银行股份有限公司营业部\",\"绍兴银行\",\"313\",\"313337009004\"),\n" +
            "    jinhuayinhanggufenyouxiangongsi(\"金华银行股份有限公司\",\"金华银行股份有限公司\",\"313\",\"313338009688\"),\n" +
            "    zhejiangchouzhoushangyeyinhang(\"浙江稠州商业银行\",\"浙江稠州商业银行\",\"313\",\"313338707013\"),\n" +
            "    taizhouyinhang(\"台州银行股份有限公司\",\"台州银行\",\"313\",\"313345001665\"),\n" +
            "    zhejiangtailongshangyeyinhang(\"浙江泰隆商业银行\",\"浙江泰隆商业银行\",\"313\",\"313345010019\"),\n" +
            "    zhejiangmintaishangyeyinhang(\"浙江民泰商业银行\",\"浙江民泰商业银行\",\"313\",\"313345400010\"),\n" +
            "    fujianhaixiayinhang(\"福建海峡银行股份有限公司\",\"福建海峡银行\",\"313\",\"313391080007\"),\n" +
            "    shamenyinhang(\"厦门银行股份有限公司\",\"厦门银行\",\"313\",\"313393080005\"),\n" +
            "    quanzhouyinhang(\"泉州银行股份有限公司\",\"泉州银行\",\"313\",\"313397075189\"),\n" +
            "    nanchangyinhang(\"江西银行股份有限公司\",\"南昌银行\",\"313\",\"313421087506\"),\n" +
            "    jiujiangyinhanggufenyouxiangongsi(\"九江银行股份有限公司\",\"九江银行股份有限公司\",\"313\",\"313424076706\"),\n" +
            "    ganzhouyinhang(\"赣州银行股份有限公司\",\"赣州银行\",\"313\",\"313428076517\"),\n" +
            "    shangraoyinhang(\"上饶银行\",\"上饶银行\",\"313\",\"313433076801\"),\n" +
            "    qiluyinhang(\"齐鲁银行\",\"齐鲁银行\",\"313\",\"313451000019\"),\n" +
            "    qingdaoyinhang(\"青岛银行\",\"青岛银行\",\"313\",\"313452060150\"),\n" +
            "    qishangyinhang(\"齐商银行\",\"齐商银行\",\"313\",\"313453001017\"),\n" +
            "    zaozhuangyinhang(\"枣庄银行股份有限公司\",\"枣庄银行\",\"313\",\"313454000016\"),\n" +
            "    dongyingyinhang(\"东营银行股份有限公司\",\"东营银行\",\"313\",\"313455000018\"),\n" +
            "    yantaiyinhang(\"烟台银行股份有限公司\",\"烟台银行\",\"313\",\"313456000108\"),\n" +
            "    weifangyinhang(\"潍坊银行\",\"潍坊银行\",\"313\",\"313458000013\"),\n" +
            "    jiningyinhang(\"济宁银行股份有限公司\",\"济宁银行\",\"313\",\"313461000012\"),\n" +
            "    taianyinhang(\"泰安银行股份有限公司\",\"泰安银行\",\"313\",\"313463000993\"),\n" +
            "    laishangyinhang(\"莱商银行\",\"莱商银行\",\"313\",\"313463400019\"),\n" +
            "    weihaishishangyeyinhang(\"威海市商业银行\",\"威海市商业银行\",\"313\",\"313465000010\"),\n" +
            "    dezhouyinhang(\"德州银行股份有限公司\",\"德州银行\",\"313\",\"313468000015\"),\n" +
            "    linshangyinhang(\"临商银行股份有限公司\",\"临商银行\",\"313\",\"313473070018\"),\n" +
            "    rizhaoyinhang(\"日照银行股份有限公司\",\"日照银行\",\"313\",\"313473200011\"),\n" +
            "    zhengzhouyinhang(\"郑州银行\",\"郑州银行\",\"313\",\"313491000232\"),\n" +
            "    zhongyuanyinhang(\"中原银行股份有限公司\",\"中原银行\",\"313\",\"313491099996\"),\n" +
            "    kaifengshishangyeyinhang(\"中原银行股份有限公司开封分行\",\"开封市商业银行\",\"313\",\"313492070005\"),\n" +
            "    luoyangyinhang(\"洛阳银行股份有限公司\",\"洛阳银行\",\"313\",\"313493080539\"),\n" +
            "    pingdingshanyinhang(\"平顶山银行股份有限公司\",\"平顶山银行\",\"313\",\"313495081900\"),\n" +
            "    jiaozuozhonglvyinhang(\"焦作中旅银行股份有限公司\",\"焦作中旅银行\",\"313\",\"313501080608\"),\n" +
            "    luoheshishangyeyinhang(\"中原银行股份有限公司漯河分行\",\"漯河市商业银行\",\"313\",\"313504000010\"),\n" +
            "    shangqiushishangyeyinhang(\"中原银行股份有限公司商丘分行\",\"商丘市商业银行\",\"313\",\"313506082510\"),\n" +
            "    hankouyinhang(\"汉口银行资金清算中心\",\"汉口银行\",\"313\",\"313521000011\"),\n" +
            "    hubeiyinhang(\"湖北银行股份有限公司\",\"湖北银行\",\"313\",\"313521006000\"),\n" +
            "    huarongxiangjiangyinhang(\"华融湘江银行股份有限公司\",\"华融湘江银行\",\"313\",\"313551070008\"),\n" +
            "    zhangshayinhang(\"长沙银行股份有限公司\",\"长沙银行\",\"313\",\"313551088886\"),\n" +
            "    guangzhouyinhang(\"广州银行\",\"广州银行\",\"313\",\"313581003284\"),\n" +
            "    zhuhaihuarunyinhangqingsuanzhongxin(\"珠海华润银行股份有限公司清算中心\",\"珠海华润银行清算中心\",\"313\",\"313585000990\"),\n" +
            "    guangdonghuaxingyinhang(\"广东华兴银行股份有限公司\",\"广东华兴银行\",\"313\",\"313586000006\"),\n" +
            "    guangdongnanyueyinhanggufenyouxiangongsi(\"广东南粤银行股份有限公司\",\"广东南粤银行股份有限公司\",\"313\",\"313591001001\"),\n" +
            "    dongguanyinhang(\"东莞银行股份有限公司\",\"东莞银行\",\"313\",\"313602088017\"),\n" +
            "    guangxibeibuwanyinhang(\"广西北部湾银行\",\"广西北部湾银行\",\"313\",\"313611001018\"),\n" +
            "    liuzhouyinhang(\"柳州银行股份有限公司清算中心\",\"柳州银行\",\"313\",\"313614000012\"),\n" +
            "    guilinyinhanggufenyouxiangongsi(\"桂林银行股份有限公司\",\"桂林银行股份有限公司\",\"313\",\"313617000018\"),\n" +
            "    hainanyinhanggufenyouxiangongsi(\"海南银行股份有限公司\",\"海南银行股份有限公司\",\"313\",\"313641099995\"),\n" +
            "    chengdouyinhang(\"成都银行\",\"成都银行\",\"313\",\"313651099999\"),\n" +
            "    zhongqingyinhanggufenyouxiangongsi(\"重庆银行\",\"重庆银行股份有限公司\",\"313\",\"313653000013\"),\n" +
            "    zigongshishangyeyinhangqingsuanzhongxin(\"自贡银行股份有限公司\",\"自贡市商业银行清算中心\",\"313\",\"313655091983\"),\n" +
            "    panzhihuashishangyeyinhang(\"攀枝花市商业银行\",\"攀枝花市商业银行\",\"313\",\"313656000019\"),\n" +
            "    luzhouyinhang(\"泸州银行股份有限公司\",\"泸州银行\",\"313\",\"313657092617\"),\n" +
            "    deyangyinhang(\"长城华西银行股份有限公司\",\"德阳银行\",\"313\",\"313658000014\"),\n" +
            "    mianyangshishangyeyinhang(\"绵阳市商业银行股份有限公司\",\"绵阳市商业银行\",\"313\",\"313659000016\"),\n" +
            "    suiningshanghang(\"遂宁银行股份有限公司\",\"遂宁商行\",\"313\",\"313662000015\"),\n" +
            "    leshanshishangyeyinhang(\"乐山市商业银行\",\"乐山市商业银行\",\"313\",\"313665092924\"),\n" +
            "    yibinshishangyeyinhang(\"宜宾市商业银行\",\"宜宾市商业银行\",\"313\",\"313671000017\"),\n" +
            "    sichuantianfuyinhang(\"四川天府银行股份有限公司\",\"四川天府银行\",\"313\",\"313673093259\"),\n" +
            "    dazhouyinhang(\"达州银行股份有限公司\",\"达州银行\",\"313\",\"313675090019\"),\n" +
            "    liangshanzhoushangyeyinhang(\"凉山州商业银行\",\"凉山州商业银行\",\"313\",\"313684093748\"),\n" +
            "    guiyangyinhang(\"贵阳市商业银行\",\"贵阳银行\",\"313\",\"313701098010\"),\n" +
            "    guizhouyinhang(\"贵州银行股份有限公司\",\"贵州银行\",\"313\",\"313701099012\"),\n" +
            "    fudianyinhang(\"富滇银行股份有限公司运营管理部\",\"富滇银行\",\"313\",\"313731010015\"),\n" +
            "    qujingshishangyeyinhang(\"曲靖市商业银行\",\"曲靖市商业银行\",\"313\",\"313736000019\"),\n" +
            "    yuxishishangyeyinhang(\"云南红塔银行股份有限公司\",\"玉溪市商业银行\",\"313\",\"313741095715\"),\n" +
            "    xizangyinhang(\"西藏银行股份有限公司\",\"西藏银行\",\"313\",\"313770000016\"),\n" +
            "    xianyinhang(\"西安银行股份有限公司\",\"西安银行\",\"313\",\"313791000015\"),\n" +
            "    zhanganyinhang(\"长安银行股份有限公司\",\"长安银行\",\"313\",\"313791030003\"),\n" +
            "    lanzhouyinhanggufenyouxiangongsi(\"兰州银行股份有限公司\",\"兰州银行股份有限公司\",\"313\",\"313821001016\"),\n" +
            "    gansuyinhang(\"甘肃银行股份有限公司\",\"甘肃银行\",\"313\",\"313821050016\"),\n" +
            "    qinghaiyinhang(\"青海银行股份有限公司营业部\",\"青海银行\",\"313\",\"313851000018\"),\n" +
            "    ningxiayinhang(\"宁夏银行股份有限公司\",\"宁夏银行\",\"313\",\"313871000007\"),\n" +
            "    shizuishanyinhang(\"石嘴山银行股份有限公司\",\"石嘴山银行\",\"313\",\"313872097457\"),\n" +
            "    wulumuqiyinhang(\"乌鲁木齐银行清算中心\",\"乌鲁木齐银行\",\"313\",\"313881000002\"),\n" +
            "    xinjiangyinhanggufenyouxiangongsi(\"新疆银行股份有限公司\",\"新疆银行股份有限公司\",\"313\",\"313881088887\"),\n" +
            "    kunlunyinhang(\"昆仑银行股份有限公司\",\"昆仑银行\",\"313\",\"313882000012\"),\n" +
            "    xinjianghuiheyinhangqingsuanxing(\"新疆汇和银行股份有限公司（清算行）\",\"新疆汇和银行（清算行）\",\"313\",\"313898100016\"),\n" +
            "    tianjinbinhainongcunshangyeyinhanggufenyouxiangongsi(\"天津滨海农村商业银行股份有限公司\",\"天津滨海农村商业银行股份有限公司\",\"314\",\"314110000011\"),\n" +
            "    daliannongcunshangyeyinhang(\"大连农村商业银行\",\"大连农村商业银行\",\"314\",\"314222001893\"),\n" +
            "    wuxinongcunshangyeyinhang(\"无锡农村商业银行股份有限公司（不对外）\",\"无锡农村商业银行\",\"314\",\"314302066666\"),\n" +
            "    jiangyinnongshangyinhang(\"江苏江阴农村商业银行股份有限公司\",\"江阴农商银行\",\"314\",\"314302200018\"),\n" +
            "    jiangnannongcunshangyeyinhang(\"江苏江南农村商业银行股份有限公司(不对外)\",\"江南农村商业银行\",\"314\",\"314304099999\"),\n" +
            "    taicangnongshanghang(\"太仓农村商业银行\",\"太仓农商行\",\"314\",\"314305106644\"),\n" +
            "    kunshannongcunshangyeyinhang(\"昆山农村商业银行\",\"昆山农村商业银行\",\"314\",\"314305206650\"),\n" +
            "    suzhounongcunshangyeyinhang(\"苏州农村商业银行清算中心\",\"苏州农村商业银行\",\"314\",\"314305400015\"),\n" +
            "    changshunongcunshangyeyinhang(\"江苏常熟农村商业银行股份有限公司清算中心\",\"常熟农村商业银行\",\"314\",\"314305506621\"),\n" +
            "    zhangjiagangnongcunshangyeyinhang(\"张家港农村商业银行\",\"张家港农村商业银行\",\"314\",\"314305670002\"),\n" +
            "    guangzhounongcunshangyeyinhang(\"广州农村商业银行股份有限公司\",\"广州农村商业银行\",\"314\",\"314581000011\"),\n" +
            "    shundenongcunshangyeyinhang(\"佛山顺德农村商业银行股份有限公司\",\"顺德农村商业银行\",\"314\",\"314588000016\"),\n" +
            "    haikoulianhenongcunshangyeyinhang(\"海口联合农村商业银行股份有限公司\",\"海口联合农村商业银行\",\"314\",\"314641000014\"),\n" +
            "    chengdounongcunshangyeyinhanggufenyouxiangongsi(\"成都农商银行\",\"成都农村商业银行股份有限公司\",\"314\",\"314651000000\"),\n" +
            "    zhongqingnongcunshangyeyinhang(\"重庆农村商业银行股份有限公司\",\"重庆农村商业银行\",\"314\",\"314653000011\"),\n" +
            "    hengfengyinhang(\"恒丰银行\",\"恒丰银行\",\"315\",\"315456000105\"),\n" +
            "    zheshangyinhang(\"浙商银行\",\"浙商银行\",\"316\",\"316331000018\"),\n" +
            "    tianjinnongshangyinhang(\"天津农村商业银行股份有限公司\",\"天津农商银行\",\"314\",\"317110010019\"),\n" +
            "    bohaiyinhang(\"渤海银行股份有限公司\",\"渤海银行\",\"318\",\"318110000014\"),\n" +
            "    huishangyinhang(\"徽商银行股份有限公司\",\"徽商银行\",\"319\",\"319361000013\"),\n" +
            "    beijingshunyiyinzuocunzhenyinhang(\"北京顺义银座村镇银行股份有限公司\",\"北京顺义银座村镇银行\",\"320\",\"313345001665\"),\n" +
            "    beijingchangpingbaoshangcunzhenyinhanggufenyouxiangongsi(\"北京昌平包商村镇银行股份有限公司\",\"北京昌平包商村镇银行股份有限公司\",\"320\",\"313192000013\"),\n" +
            "    beijinghuairourongxingcunzhenyinhang(\"北京怀柔融兴村镇银行有限责任公司\",\"北京怀柔融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    tianjinhuamingcunzhenyinhanggufenyouxiangongsi(\"天津华明村镇银行股份有限公司\",\"天津华明村镇银行股份有限公司\",\"320\",\"309391000011\"),\n" +
            "    tianjinjinnancunzhenyinhanggufenyouxiangongsi(\"天津津南村镇银行股份有限公司\",\"天津津南村镇银行股份有限公司\",\"320\",\"313192000013\"),\n" +
            "    tianjinjinghaixinhuacunzhenyinhanggufenyouxiangongsi(\"天津静海新华村镇银行股份有限公司\",\"天津静海新华村镇银行股份有限公司\",\"320\",\"309391000011\"),\n" +
            "    tianjinninghecunzhenyinhanggufenyouxiangongsi(\"天津宁河村镇银行股份有限公司\",\"天津宁河村镇银行股份有限公司\",\"320\",\"309391000011\"),\n" +
            "    hejianronghuicunzhenyinhangyouxianzerengongsi(\"河间融惠村镇银行有限责任公司\",\"河间融惠村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    cangzhouyanshanxinhuacunzhenyinhanggufenyouxiangongsi(\"沧州盐山新华村镇银行股份有限公司\",\"沧州盐山新华村镇银行股份有限公司\",\"320\",\"309391000011\"),\n" +
            "    cangzhouhaixingxinhuacunzhenyinhanggufenyouxiangongsi(\"沧州海兴新华村镇银行股份有限公司\",\"沧州海兴新华村镇银行股份有限公司\",\"320\",\"309391000011\"),\n" +
            "    qingxuhuimincunzhenyinhangyouxianzerengongsi(\"清徐惠民村镇银行有限责任公司\",\"清徐惠民村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    neimengguhelingeerbaoshangcunzhenyinhangyouxianzerengongsi(\"内蒙古和林格尔包商村镇银行有限责任公司\",\"内蒙古和林格尔包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    guyangbaoshangcunzhenyinhanggufenyouxiangongsi(\"固阳包商村镇银行股份有限公司\",\"固阳包商村镇银行股份有限公司\",\"320\",\"313192000013\"),\n" +
            "    chifengshihongshanyulongcunzhenyinhangyouxianzerengongsi(\"赤峰市红山玉龙村镇银行有限责任公司\",\"赤峰市红山玉龙村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    chifengshiyuanbaoshanyulongcunzhenyinhangyouxianzerengongsi(\"赤峰市元宝山玉龙村镇银行有限责任公司\",\"赤峰市元宝山玉龙村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    kalaqinyulongcunzhenyinhangyouxianzerengongsi(\"喀喇沁玉龙村镇银行有限责任公司\",\"喀喇沁玉龙村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    ningchengbaoshangcunzhenyinhangyouxianzerengongsi(\"宁城包商村镇银行有限责任公司\",\"宁城包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    molidawabaoshangcunzhenyinhangyouxianzerengongsi(\"莫力达瓦包商村镇银行有限责任公司\",\"莫力达瓦包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    ewenkebaoshangcunzhenyinhangyouxianzerengongsi(\"鄂温克包商村镇银行有限责任公司\",\"鄂温克包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    xinganmengkeerqinbaoshangcunzhenyinhangyouxiangongsi(\"兴安盟科尔沁包商村镇银行有限公司\",\"兴安盟科尔沁包商村镇银行有限公司\",\"320\",\"313192000013\"),\n" +
            "    xiwuzhumuqinbaoshanghuifengcunzhenyinhangyouxianzerengongsi(\"西乌珠穆沁包商惠丰村镇银行有限责任公司\",\"西乌珠穆沁包商惠丰村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    wulanchabushijiningbaoshangcunzhenyinhangyouxianzerengongsi(\"乌兰察布市集宁包商村镇银行有限责任公司\",\"乌兰察布市集宁包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    huadebaoshangcunzhenyinhangyouxianzerengongsi(\"化德包商村镇银行有限责任公司\",\"化德包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    daerhanmaominganlianheqibaoshangcunzhenyinhanggufenyouxiangong(\"达尔罕茂明安联合旗包商村镇银行股份有限公司\",\"达尔罕茂明安联合旗包商村镇银行股份有限公\",\"320\",\"313192000013\"),\n" +
            "    zhungeerqibaoshangcunzhenyinhangyouxianzerengongsi(\"准格尔旗包商村镇银行有限责任公司\",\"准格尔旗包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    wushenqibaoshangcunzhenyinhangyouxianzerengongsi(\"乌审旗包商村镇银行有限责任公司\",\"乌审旗包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    dalianjinzhoulianfengcunzhenyinhanggufenyouxiangongsi(\"大连金州联丰村镇银行股份有限公司\",\"大连金州联丰村镇银行股份有限公司\",\"320\",\"313192000013\"),\n" +
            "    dawahengfengcunzhenyinhang(\"大洼恒丰村镇银行股份有限公司\",\"大洼恒丰村镇银行\",\"320\",\"309391000011\"),\n" +
            "    jiutailongjiacunzhenyinhanggufenyouxiangongsi(\"九台龙嘉村镇银行股份有限公司\",\"九台龙嘉村镇银行股份有限公司\",\"320\",\"313192000013\"),\n" +
            "    zhangchunchaoyangheruncunzhenyinhanggufenyouxiangongsi(\"长春朝阳和润村镇银行股份有限公司\",\"长春朝阳和润村镇银行股份有限公司\",\"320\",\"314588000016\"),\n" +
            "    yushurongxingcunzhenyinhang(\"榆树融兴村镇银行\",\"榆树融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    bayanrongxingcunzhenyinhang(\"巴彦融兴村镇银行有限责任公司\",\"巴彦融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    yanshourongxingcunzhenyinhang(\"延寿融兴村镇银行有限责任公司\",\"延寿融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    neherongxingcunzhenyinhangyouxianzerengongsi(\"讷河融兴村镇银行有限责任公司\",\"讷河融兴村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    baiquanrongxingcunzhenyinhang(\"拜泉融兴村镇银行有限责任公司\",\"拜泉融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    huananrongxingcunzhenyinhangyouxianzerengongsi(\"桦南融兴村镇银行有限责任公司\",\"桦南融兴村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    huachuanrongxingcunzhenyinhang(\"桦川融兴村镇银行有限责任公司\",\"桦川融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    ninganrongxingcunzhenyinhangyouxianzerengongsi(\"宁安融兴村镇银行有限责任公司\",\"宁安融兴村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    shanghaiminxingshangyincunzhenyinhanggufenyouxiangongsi(\"上海闵行上银村镇银行股份有限公司\",\"上海闵行上银村镇银行股份有限公司\",\"320\",\"309391000011\"),\n" +
            "    jiangsuhuishanmintaicunzhenyinhang(\"江苏惠山民泰村镇银行股份有限公司\",\"江苏惠山民泰村镇银行\",\"320\",\"313345400010\"),\n" +
            "    jiangsunantongrugaobaoshangcunzhenyinhanggufenyouxiangongsi(\"江苏南通如皋包商村镇银行股份有限公司\",\"江苏南通如皋包商村镇银行股份有限公司\",\"320\",\"313192000013\"),\n" +
            "    jiangsurudongrongxingcunzhenyinhang(\"江苏如东融兴村镇银行有限责任公司\",\"江苏如东融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    jiangsujinhumintaicunzhenyinhang(\"江苏金湖民泰村镇银行股份有限公司\",\"江苏金湖民泰村镇银行\",\"320\",\"313345400010\"),\n" +
            "    jiangsuhanjiangmintaicunzhenyinhang(\"江苏邗江民泰村镇银行股份有限公司\",\"江苏邗江民泰村镇银行\",\"320\",\"313345400010\"),\n" +
            "    jiangsuyizhengbaoshangcunzhenyinhangyouxianzerengongsi(\"江苏仪征包商村镇银行有限责任公司\",\"江苏仪征包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    ningbohaishuguomincunzhenyinhang(\"宁波市海曙国民村镇银行有限责任公司\",\"宁波海曙国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    xiangshanguomincunzhenyinhang(\"象山国民村镇银行股份有限公司\",\"象山国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    zhejiangtongxiangmintaicunzhenyinhang(\"浙江桐乡民泰村镇银行股份有限公司\",\"浙江桐乡民泰村镇银行\",\"320\",\"313345400010\"),\n" +
            "    zhejiangjingningyinzuocunzhenyinhang(\"浙江景宁银座村镇银行股份有限公司\",\"浙江景宁银座村镇银行\",\"320\",\"313345001665\"),\n" +
            "    zhejianglongquanmintaicunzhenyinhang(\"浙江龙泉民泰村镇银行股份有限公司\",\"浙江龙泉民泰村镇银行\",\"320\",\"313345400010\"),\n" +
            "    zhejiangsanmenyinzuocunzhenyinhang(\"浙江三门银座村镇银行股份有限公司\",\"浙江三门银座村镇银行\",\"320\",\"313345001665\"),\n" +
            "    nanchangchangdongjiuyincunzhenyinhanggufenyouxiangongsi(\"南昌昌东九银村镇银行股份有限公司\",\"南昌昌东九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    anyirongxingcunzhenyinhang(\"安义融兴村镇银行有限责任公司\",\"安义融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    jingdezhenchangjiangjiuyincunzhenyinhanggufenyouxiangongsi(\"景德镇昌江九银村镇银行股份有限公司\",\"景德镇昌江九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    lepingrongxingcunzhenyinhang(\"乐平融兴村镇银行有限责任公司\",\"乐平融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    ruichangjiuyincunzhenyinhanggufenyouxiangongsi(\"瑞昌九银村镇银行股份有限公司\",\"瑞昌九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    xiushuijiuyincunzhenyinhangyouxianzerengongsi(\"修水九银村镇银行有限责任公司\",\"修水九银村镇银行有限责任公司\",\"320\",\"313424076706\"),\n" +
            "    lushanjiuyinyishucunzhenyinhanggufenyouxiangongsi(\"庐山九银艺术村镇银行股份有限公司\",\"庐山九银艺术村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    douchangjiuyincunzhenyinhanggufenyouxiangongsi(\"都昌九银村镇银行股份有限公司\",\"都昌九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    hukoujiuyincunzhenyinhanggufenyouxiangongsi(\"湖口九银村镇银行股份有限公司\",\"湖口九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    pengzejiuyincunzhenyinhanggufenyouxiangongsi(\"彭泽九银村镇银行股份有限公司\",\"彭泽九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    fenyijiuyincunzhenyinhanggufenyouxiangongsi(\"分宜九银村镇银行股份有限公司\",\"分宜九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    guixijiuyincunzhenyinhanggufenyouxiangongsi(\"贵溪九银村镇银行股份有限公司\",\"贵溪九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    jiangxiganzhouyinzuocunzhenyinhang(\"江西赣州银座村镇银行股份有限公司\",\"江西赣州银座村镇银行\",\"320\",\"313345001665\"),\n" +
            "    jiangxiruijinguangdacunzhenyinhanggufenyouxiangongsi(\"江西瑞金光大村镇银行股份有限公司\",\"江西瑞金光大村镇银行股份有限公司\",\"320\",\"309391000011\"),\n" +
            "    fengxinjiuyincunzhenyinhanggufenyouxiangongsi(\"奉新九银村镇银行股份有限公司\",\"奉新九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    jinganjiuyincunzhenyinhanggufenyouxiangongsi(\"靖安九银村镇银行股份有限公司\",\"靖安九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    tonggujiuyincunzhenyinhanggufenyouxiangongsi(\"铜鼓九银村镇银行股份有限公司\",\"铜鼓九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    jinggangshanjiuyincunzhenyinhangyouxianzerengongsi(\"井冈山九银村镇银行有限责任公司\",\"井冈山九银村镇银行有限责任公司\",\"320\",\"313424076706\"),\n" +
            "    chongrenjiuyincunzhenyinhanggufenyouxiangongsi(\"崇仁九银村镇银行股份有限公司\",\"崇仁九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    zixijiuyincunzhenyinhanggufenyouxiangongsi(\"资溪九银村镇银行股份有限公司\",\"资溪九银村镇银行股份有限公司\",\"320\",\"313424076706\"),\n" +
            "    dongyinglaishangcunzhenyinhanggufenyouxiangongsi(\"东营莱商村镇银行股份有限公司\",\"东营莱商村镇银行股份有限公司\",\"320\",\"313463400019\"),\n" +
            "    juanchengbaoshangcunzhenyinhangyouxianzerengongsi(\"鄄城包商村镇银行有限责任公司\",\"鄄城包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    yanshirongxingcunzhenyinhang(\"偃师融兴村镇银行有限责任公司\",\"偃师融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    xinanrongxingcunzhenyinhang(\"新安融兴村镇银行有限责任公司\",\"新安融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    zhanggexuanyuancunzhenyinhang(\"长葛轩辕村镇银行有限责任公司\",\"长葛轩辕村镇银行\",\"320\",\"320503100013\"),\n" +
            "    luoheshiyanchengbaoshangcunzhenyinhangyouxianzerengongsi(\"漯河市郾城包商村镇银行有限责任公司\",\"漯河市郾城包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    nanyangcunzhenyinhang(\"南阳村镇银行股份有限公司\",\"南阳村镇银行\",\"320\",\"309391000011\"),\n" +
            "    hubeijingmenduodaobaoshangcunzhenyinhanggufenyouxiangongsi(\"湖北荆门掇刀包商村镇银行股份有限公司\",\"湖北荆门掇刀包商村镇银行股份有限公司\",\"320\",\"313192000013\"),\n" +
            "    yingchengrongxingcunzhenyinhang(\"应城融兴村镇银行有限责任公司\",\"应城融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    honghurongxingcunzhenyinhang(\"洪湖融兴村镇银行有限责任公司\",\"洪湖融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    zhuzhouxianrongxingcunzhenyinhang(\"株洲县融兴村镇银行有限责任公司\",\"株洲县融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    leiyangrongxingcunzhenyinhang(\"耒阳融兴村镇银行有限责任公司\",\"耒阳融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    wugangbaoshangcunzhenyinhangyouxianzerengongsi(\"武冈包商村镇银行有限责任公司\",\"武冈包商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    guangzhoubaiyunmintaicunzhenyinhang(\"广州白云民泰村镇银行股份有限公司\",\"广州白云民泰村镇银行\",\"320\",\"313345400010\"),\n" +
            "    shenzhenbaoanrongxingcunzhenyinhang(\"深圳宝安融兴村镇银行有限责任公司\",\"深圳宝安融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    shenzhenfutianyinzuocunzhenyinhang(\"深圳福田银座村镇银行股份有限公司\",\"深圳福田银座村镇银行\",\"320\",\"313345001665\"),\n" +
            "    shenzhennanshanbaoshengcunzhenyinhang(\"深圳南山宝生村镇银行股份有限公司\",\"深圳南山宝生村镇银行\",\"320\",\"313493080539\"),\n" +
            "    shenzhenbaoanguiyincunzhenyinhang(\"深圳宝安桂银村镇银行股份有限公司\",\"深圳宝安桂银村镇银行\",\"320\",\"313617000018\"),\n" +
            "    zhuhainanpingcunzhenyinhanggufenyouxiangongsi(\"珠海南屏村镇银行股份有限公司\",\"珠海南屏村镇银行股份有限公司\",\"320\",\"313192000013\"),\n" +
            "    foshangaomingshunyincunzhenyinhanggufenyouxiangongsi(\"佛山高明顺银村镇银行股份有限公司\",\"佛山高明顺银村镇银行股份有限公司\",\"320\",\"314588000016\"),\n" +
            "    guangxishanglinguomincunzhenyinhang(\"广西上林国民村镇银行有限责任公司\",\"广西上林国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    nanningjiangnanguomincunzhenyinhang(\"南宁江南国民村镇银行股份有限公司\",\"南宁江南国民村镇银行\",\"320\",\"309391000011\"),\n" +
            "    guilinguomincunzhenyinhang(\"桂林国民村镇银行有限责任公司\",\"桂林国民村镇银行\",\"320\",\"309391000011\"),\n" +
            "    guangxiyinhaiguomincunzhenyinhang(\"广西银海国民村镇银行有限责任公司\",\"广西银海国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    hepuguomincunzhenyinhang(\"合浦国民村镇银行有限责任公司\",\"合浦国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    pingguoguomincunzhenyinhang(\"平果国民村镇银行有限责任公司\",\"平果国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    guangxiqinzhouqinnanguomincunzhenyinhang(\"广西钦州市钦南国民村镇银行有限责任公司\",\"广西钦州钦南国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    guangxipubeiguomincunzhenyinhang(\"广西浦北国民村镇银行有限责任公司\",\"广西浦北国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    fangchenggangfangchengguomincunzhenyinhang(\"防城港防城国民村镇银行有限责任公司\",\"防城港防城国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    dongxingguomincunzhenyinhang(\"东兴国民村镇银行有限责任公司\",\"东兴国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    hainanbaotingrongxingcunzhenyinhang(\"海南保亭融兴村镇银行有限责任公司\",\"海南保亭融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    qionglaiguomincunzhenyinhangyouxianzerengongsi(\"邛崃国民村镇银行有限责任公司\",\"邛崃国民村镇银行有限责任公司\",\"320\",\"402332010004\"),\n" +
            "    xindouguichengcunzhenyinhangyouxianzerengongsi(\"新都桂城村镇银行有限责任公司\",\"新都桂城村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    chengdouqingbaijiangrongxingcunzhenyinhangyouxianzerengongsi(\"成都青白江融兴村镇银行有限责任公司\",\"成都青白江融兴村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    zhongqingyubeiyinzuocunzhenyinhang(\"重庆渝北银座村镇银行有限责任公司\",\"重庆渝北银座村镇银行\",\"320\",\"313345001665\"),\n" +
            "    zhongqingjiulongpomintaicunzhenyinhang(\"重庆九龙坡民泰村镇银行股份有限公司\",\"重庆九龙坡民泰村镇银行\",\"320\",\"313345400010\"),\n" +
            "    zhongqingshishapingbarongxingcunzhenyinhang(\"重庆市沙坪坝融兴村镇银行有限责任公司\",\"重庆市沙坪坝融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    zhongqingshidadukourongxingcunzhenyinhang(\"重庆市大渡口融兴村镇银行有限责任公司\",\"重庆市大渡口融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    zhongjiangrongxingcunzhenyinhangyouxianzerengongsi(\"中江融兴村镇银行有限责任公司\",\"中江融兴村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    guangyuanshibaoshangguimincunzhenyinhangyouxianzerengongsi(\"广元市包商贵民村镇银行有限责任公司\",\"广元市包商贵民村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    suininganjurongxingcunzhenyinhang(\"遂宁安居融兴村镇银行有限责任公司\",\"遂宁安居融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    wulongrongxingcunzhenyinhang(\"武隆融兴村镇银行有限责任公司\",\"武隆融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    langzhongrongxingcunzhenyinhangyouxianzerengongsi(\"阆中融兴村镇银行有限责任公司\",\"阆中融兴村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    zhongqingqianjiangyinzuocunzhenyinhang(\"重庆黔江银座村镇银行股份有限公司\",\"重庆黔江银座村镇银行\",\"320\",\"313345001665\"),\n" +
            "    zhongqingshiyouyangrongxingcunzhenyinhang(\"重庆市酉阳融兴村镇银行有限责任公司\",\"重庆市酉阳融兴村镇银行\",\"320\",\"313261000018\"),\n" +
            "    zhongqingpengshuimintaicunzhenyinhang(\"重庆彭水民泰村镇银行股份有限公司\",\"重庆彭水民泰村镇银行\",\"320\",\"313345400010\"),\n" +
            "    xifengbaoshangqianlongcunzhenyinhangyouxianzerengongsi(\"息烽包商黔隆村镇银行有限责任公司\",\"息烽包商黔隆村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    guiyanghuaxijianshecunzhenyinhangyouxianzerengongsi(\"贵阳花溪建设村镇银行有限责任公司\",\"贵阳花溪建设村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    zunyizhangzhengcunzhenyinhang(\"遵义新蒲长征村镇银行股份有限公司\",\"遵义长征村镇银行\",\"320\",\"309391000011\"),\n" +
            "    bijiefazhancunzhenyinhangyouxianzerengongsi(\"毕节发展村镇银行有限责任公司\",\"毕节发展村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    huininghuishicunzhenyinhang(\"会宁会师村镇银行有限责任公司\",\"会宁会师村镇银行\",\"320\",\"313261000018\"),\n" +
            "    tianshuimaijirongxingcunzhenyinhangyouxianzerengongsi(\"天水麦积融兴村镇银行有限责任公司\",\"天水麦积融兴村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    pingliangkongtongrongxingcunzhenyinhangyouxianzerengongsi(\"平凉崆峒融兴村镇银行有限责任公司\",\"平凉崆峒融兴村镇银行有限责任公司\",\"320\",\"313261000018\"),\n" +
            "    ningxiahelanhuishangcunzhenyinhangyouxianzerengongsi(\"宁夏贺兰回商村镇银行有限责任公司\",\"宁夏贺兰回商村镇银行有限责任公司\",\"320\",\"313192000013\"),\n" +
            "    xinjianglvzhouguomincunzhenyinhang(\"新疆绿洲国民村镇银行有限责任公司\",\"新疆绿洲国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    kelamayijinlongguomincunzhenyinhang(\"克拉玛依金龙国民村镇银行有限责任公司\",\"克拉玛依金龙国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    hamihongxingguomincunzhenyinhang(\"哈密红星国民村镇银行有限责任公司\",\"哈密红星国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    beitunguomincunzhenyinhang(\"北屯国民村镇银行有限责任公司\",\"北屯国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    changjiguomincunzhenyinhang(\"昌吉国民村镇银行有限责任公司\",\"昌吉国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    wujiaquguomincunzhenyinhang(\"五家渠国民村镇银行有限责任公司\",\"五家渠国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    boleguomincunzhenyinhang(\"博乐国民村镇银行有限责任公司\",\"博乐国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    kucheguomincunzhenyinhang(\"库车国民村镇银行有限责任公司\",\"库车国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    yiliguomincunzhenyinhang(\"伊犁国民村镇银行有限责任公司\",\"伊犁国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    kuitunguomincunzhenyinhang(\"奎屯国民村镇银行有限责任公司\",\"奎屯国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    shiheziguomincunzhenyinhang(\"石河子国民村镇银行有限责任公司\",\"石河子国民村镇银行\",\"320\",\"402332010004\"),\n" +
            "    zhongqingsanxiayinhang(\"重庆三峡银行股份有限公司\",\"重庆三峡银行\",\"321\",\"321667090019\"),\n" +
            "    shanghainongshangyinhang(\"上海农村商业银行\",\"上海农商银行\",\"322\",\"322290000011\"),\n" +
            "    beijingzhongguancunyinhang(\"北京中关村银行股份有限公司\",\"北京中关村银行\",\"323\",\"323100000012\"),\n" +
            "    jilinyilianyinhang(\"吉林亿联银行股份有限公司\",\"吉林亿联银行\",\"323\",\"323241000016\"),\n" +
            "    huaruiyinhang(\"上海华瑞银行\",\"华瑞银行\",\"323\",\"323290000016\"),\n" +
            "    suningyinhang(\"江苏苏宁银行股份有限公司\",\"苏宁银行\",\"323\",\"309391000011\"),\n" +
            "    zhejiangwangshangyinhang(\"浙江网商银行股份有限公司\",\"浙江网商银行\",\"323\",\"323331000001\"),\n" +
            "    wenzhouminshangyinhanggufenyouxiangongsi(\"温州民商银行股份有限公司\",\"温州民商银行股份有限公司\",\"323\",\"323333000013\"),\n" +
            "    anhuixinanyinhanggufenyouxiangongsi(\"安徽新安银行股份有限公司\",\"安徽新安银行股份有限公司\",\"323\",\"309391000011\"),\n" +
            "    huatongyinhang(\"福建华通银行股份有限公司\",\"华通银行\",\"323\",\"323391060018\"),\n" +
            "    wuhanzhongbangyinhanggufenyouxiangongsi(\"武汉众邦银行股份有限公司\",\"武汉众邦银行股份有限公司\",\"323\",\"323521012066\"),\n" +
            "    hunansanxiangyinhang(\"湖南三湘银行股份有限公司\",\"湖南三湘银行\",\"323\",\"323551000015\"),\n" +
            "    shenzhenqianhaiweizhongyinhang(\"深圳前海微众银行股份有限公司\",\"深圳前海微众银行\",\"323\",\"323584000888\"),\n" +
            "    meizhoukeshangyinhang(\"梅州客商银行股份有限公司\",\"梅州客商银行\",\"323\",\"309391000011\"),\n" +
            "    sichuanxinwangyinhang(\"四川新网银行股份有限公司\",\"四川新网银行\",\"323\",\"323651066666\"),\n" +
            "    zhongqingfuminyinhang(\"重庆富民银行股份有限公司\",\"重庆富民银行\",\"323\",\"323653010015\"),\n" +
            "    shanghaiyinhang(\"上海银行股份有限公司\",\"上海银行\",\"325\",\"325290000012\"),\n" +
            "    zhongxinbaixinyinhang(\"中信百信银行\",\"中信百信银行\",\"326\",\"326100010008\"),\n" +
            "    beijingnongcunshangyeyinhang(\"北京农村商业银行股份有限公司\",\"北京农村商业银行\",\"314\",\"402100000018\"),\n" +
            "    hebeishengnongcunxinyonglianshe(\"河北省农村信用社联合社(不办理转汇）\",\"河北省农村信用联社\",\"402\",\"402121000009\"),\n" +
            "    zizhiqulianshe(\"内蒙古自治区农村信用社联合社\",\"自治区联社\",\"402\",\"402191009992\"),\n" +
            "    liaoningshengnongcunxinyongshelianhesheyunyingguanlibu(\"辽宁省农村信用社联合社运营管理部\",\"辽宁省农村信用社联合社运营管理部\",\"402\",\"402221010013\"),\n" +
            "    jilinnongcunxinyongshe(\"吉林省农村信用社联合社（不办理转汇业务）\",\"吉林农村信用社\",\"402\",\"402241000015\"),\n" +
            "    jiangsushengnongcunxinyongshelianheshe(\"江苏省农村信用社联合社\",\"江苏省农村信用社联合社\",\"402\",\"402301099998\"),\n" +
            "    zhejiangshengnongcunxinyongshe(\"浙江省农村信用社联合社\",\"浙江省农村信用社\",\"402\",\"402331000007\"),\n" +
            "    yinzhouyinhang(\"宁波鄞州农村商业银行股份有限公司(鄞州银行)\",\"鄞州银行\",\"314\",\"402332010004\"),\n" +
            "    anhuishengnongcunxinyongshelianheshe(\"安徽省农村信用联社资金清算中心\",\"安徽省农村信用社联合社\",\"402\",\"402361018886\"),\n" +
            "    fujianshengnongcunxinyongshe(\"福建省农村信用社联合社\",\"福建省农村信用社\",\"402\",\"402391000068\"),\n" +
            "    jiangxishengnongcunxinyongshelianheshe(\"江西省农村信用社联合社\",\"江西省农村信用社联合社\",\"402\",\"402421099990\"),\n" +
            "    shandongshengnonglianshe(\"山东省农村信用社联合社\",\"山东省农联社\",\"402\",\"402451000010\"),\n" +
            "    henanshengnongxinlianshe(\"河南省农村信用社联合社\",\"河南省农信联社\",\"402\",\"402491000026\"),\n" +
            "    hubeinongxin(\"湖北省农村信用社联合社结算中心\",\"湖北农信\",\"402\",\"402521000032\"),\n" +
            "    wuhannongcunshangyeyinhang(\"武汉农村商业银行股份有限公司\",\"武汉农村商业银行\",\"314\",\"402521090019\"),\n" +
            "    hunanshengnongcunxinyongshe(\"湖南省农村信用社联合社\",\"湖南省农村信用社\",\"402\",\"402551080008\"),\n" +
            "    guangdongshengnongxin(\"广东省农村信用社联合社\",\"广东省农信\",\"402\",\"402581090008\"),\n" +
            "    shenzhennongshangxing(\"深圳农村商业银行股份有限公司\",\"深圳农商行\",\"314\",\"402584009991\"),\n" +
            "    dongguannongcunshangyeyinhang(\"东莞农村商业银行股份有限公司\",\"东莞农村商业银行\",\"314\",\"402602000018\"),\n" +
            "    guangxinongcunxinyongshehezuoyinhang(\"广西壮族自治区农村信用社联合社\",\"广西农村信用社（合作银行）\",\"402\",\"402611099974\"),\n" +
            "    hainanshengnongcunxinyongshe(\"海南省农村信用社联合社资金清算中心\",\"海南省农村信用社\",\"402\",\"402641000014\"),\n" +
            "    sichuanshenglianshe(\"四川省农村信用社联合社\",\"四川省联社\",\"402\",\"402651020006\"),\n" +
            "    guizhoushengnongcunxinyongshelianheshe(\"贵州省农村信用社联合社\",\"贵州省农村信用社联合社\",\"402\",\"402701002999\"),\n" +
            "    yunnanshengnongcunxinyongshe(\"云南省农村信用社联合社\",\"云南省农村信用社\",\"402\",\"402731057238\"),\n" +
            "    shanxixinhe(\"陕西省农村信用社联合社资金清算中心\",\"陕西信合\",\"402\",\"402791000010\"),\n" +
            "    gansushengnongcunxinyongshelianheshe(\"甘肃省农村合作金融结算服务中心\",\"甘肃省农村信用社联合社\",\"402\",\"402821000015\"),\n" +
            "    shengliansheqingsuanzhongxin(\"青海省农村信用社资金清算中心\",\"省联社清算中心\",\"402\",\"402851000016\"),\n" +
            "    huanghenongcunshangyeyinhang(\"宁夏黄河农村商业银行股份有限公司\",\"黄河农村商业银行\",\"314\",\"402871099996\"),\n" +
            "    zhongguoyouzhengchuxuyinhang(\"中国邮政储蓄银行有限责任公司\",\"中国邮政储蓄银行\",\"403\",\"403100000004\"),\n" +
            "    huifengyinhangzhongguoyouxiangongsishanghaifenxing(\"汇丰银行(中国)有限公司上海分行\",\"汇丰银行(中国)有限公司上海分行\",\"501\",\"501290000012\"),\n" +
            "    dongyayinhangzhongguoyouxiangongsi(\"东亚银行（中国）有限公司\",\"东亚银行（中国）有限公司\",\"502\",\"502290000006\"),\n" +
            "    hengshengyinhang(\"恒生银行(中国)有限公司上海分行\",\"恒生银行\",\"504\",\"504290005116\"),\n" +
            "    huaqiyinhang(\"花旗银行(中国)有限公司\",\"花旗银行\",\"531\",\"531290088881\"),\n" +
            "    youliyinhang(\"友利银行(中国)有限公司\",\"友利银行\",\"593\",\"593100000020\"),\n" +
            "    xinhanyinhangzhongguo(\"新韩银行（中国）有限公司\",\"新韩银行中国\",\"595\",\"595100000007\"),\n" +
            "    qiyeyinhang(\"企业银行（中国）有限公司\",\"企业银行\",\"596\",\"596110000013\"),\n" +
            "    hanyayinhang(\"韩亚银行（中国）有限公司\",\"韩亚银行\",\"597\",\"597100000014\"),\n" +
            "    zhadayinhangzhongguoyouxiangongsishanghaifenxing(\"渣打银行（中国）有限公司上海分行\",\"渣打银行（中国）有限公司上海分行\",\"671\",\"671290000017\"),\n" +
            "    zhongdeyinhang(\"中德住房储蓄银行\",\"中德银行\",\"717\",\"717110000010\"),\n" +
            "    shamenguojiyinhang(\"厦门国际银行股份有限公司\",\"厦门国际银行\",\"781\",\"781393010011\"),\n" +
            "    fubanghuayiyinhang(\"富邦华一银行有限公司\",\"富邦华一银行\",\"787\",\"787290000019\")";


    public static String filter = "工商银行\n" +
            "农业银行\n" +
            "中国银行\n" +
            "建设银行\n" +
            "交通银行\n" +
            "中信银行\n" +
            "光大银行\n" +
            "华夏银行\n" +
            "民生银行\n" +
            "广发银行\n" +
            "平安银行\n" +
            "招商银行\n" +
            "兴业银行\n" +
            "浦发银行\n" +
            "天津银行\n" +
            "河北银行\n" +
            "秦皇岛银行\n" +
            "邯郸银行\n" +
            "张家口银行\n" +
            "沧州银行\n" +
            "廊坊银行\n" +
            "晋商银行\n" +
            "晋城银行\n" +
            "晋中银行\n" +
            "包商银行\n" +
            "乌海银行\n" +
            "鄂尔多斯银行\n" +
            "盛京银行\n" +
            "大连银行\n" +
            "鞍山银行\n" +
            "抚顺银行\n" +
            "辽阳银行\n" +
            "哈尔滨银行\n" +
            "南京银行\n" +
            "江苏银行\n" +
            "苏州银行\n" +
            "杭州银行\n" +
            "宁波银行\n" +
            "绍兴银行\n" +
            "浙江稠州商业银行\n" +
            "台州银行\n" +
            "浙江泰隆商业银行\n" +
            "浙江民泰商业银行\n" +
            "福建海峡银行\n" +
            "泉州银行\n" +
            "江西银行\n" +
            "九江银行\n" +
            "赣州银行\n" +
            "齐鲁银行\n" +
            "青岛银行\n" +
            "东营银行\n" +
            "德州银行\n" +
            "临商银行\n" +
            "郑州银行\n" +
            "洛阳银行\n" +
            "汉口银行\n" +
            "华融湘江银行\n" +
            "长沙银行\n" +
            "广州银行\n" +
            "华润银行\n" +
            "广东华兴银行\n" +
            "广东南粤银行\n" +
            "东莞银行\n" +
            "桂林银行\n" +
            "重庆银行\n" +
            "攀枝花市商业银行\n" +
            "长城华西银行\n" +
            "四川天府银行\n" +
            "贵阳银行\n" +
            "贵州银行\n" +
            "曲靖市商业银行\n" +
            "甘肃银行\n" +
            "石嘴山银行\n" +
            "江阴农村商业银行\n" +
            "江南农村商业银行\n" +
            "太仓农村商业银行\n" +
            "吴江农村商业银行\n" +
            "常熟农商银行\n" +
            "张家港农村商业银行\n" +
            "广州农商银行\n" +
            "顺德农村商业银行\n" +
            "成都农商银行\n" +
            "重庆农村商业银行\n" +
            "恒丰银行\n" +
            "浙商银行\n" +
            "天津农村商业银行\n" +
            "渤海银行\n" +
            "徽商银行\n" +
            "上海农商银行\n" +
            "上海银行\n" +
            "北京农村商业银行\n" +
            "河北省农村信用社\n" +
            "山西省农村信用社\n" +
            "内蒙古农村信用社\n" +
            "辽宁省农村信用社\n" +
            "黑龙江省农村信用社\n" +
            "江苏省农村信用社\n" +
            "浙江农村信用社\n" +
            "鄞州农村合作银行\n" +
            "安徽省农村信用社\n" +
            "福建省农村信用社\n" +
            "江西农村信用社\n" +
            "山东农信\n" +
            "河南省农村信用社\n" +
            "湖北农村信用社\n" +
            "武汉农村商业银行\n" +
            "湖南省农村信用社\n" +
            "广东省农村信用社\n" +
            "深圳农村商业银行\n" +
            "东莞农村商业银行\n" +
            "广西农村信用社\n" +
            "海南省农村信用社\n" +
            "四川农村信用社\n" +
            "贵州省农村信用社\n" +
            "云南省农村信用社\n" +
            "陕西省农村信用社\n" +
            "甘肃省农村信用社\n" +
            "新疆农村信用社\n" +
            "邮储银行\n";

    public static void main(String[] args) {
        String[] oldList = oldStr.split("\n");
        String[] filterList = filter.split("\n");
        StringBuilder sb =new StringBuilder();
        StringBuilder miss = new StringBuilder();
        boolean hit = false;
        for(String filter:filterList){
            hit=false;
            for(String old:oldList){
                if(old.contains(filter)){
                    String[] oldspitlist  = old.split("\"");

                    sb.append(oldspitlist[1]+","+oldspitlist[3]+"\n");
                    hit = true;
                    break;
                }
            }
            if(!hit){
                miss.append(filter+"\n");
            }
        }

        System.out.println("命中数组：\n"+sb.toString());
        System.out.println("未命中数组：\n"+miss.toString());

    }
}
