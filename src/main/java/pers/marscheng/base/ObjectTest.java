package pers.marscheng.base;

/**
 * 测试Object类
 *
 * @author: marscheng
 * @date: 2019-02-08 11:06 AM
 */
public class ObjectTest implements Cloneable{
    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ObjectTest{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args){
        ObjectTest test = new ObjectTest();
        test.setAge("28");
        test.setName("Mars");
        try {

            ObjectTest copy = (ObjectTest) test.clone();
            //打印出的hash值不同,说明不是同一个对象
            System.out.println(test.hashCode());
            System.out.println(copy.hashCode());
            //只是复制类的内容
            System.out.println(copy.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
