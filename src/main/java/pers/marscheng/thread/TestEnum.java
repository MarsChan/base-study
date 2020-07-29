package pers.marscheng.thread;

/**
 * @program: base-study
 * @description: 测试枚举
 * @author: Marscheng
 * @create: 2020-07-27 14:33
 **/

public enum TestEnum {
    ENUM1("1","枚举1");

    private String code;
    private String name;

    TestEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}
