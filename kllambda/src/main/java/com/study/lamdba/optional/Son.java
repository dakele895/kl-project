package com.study.lamdba.optional;

/**
 * @Auther: dalele
 * @Date: 2019/8/28 23:12
 * @Description:
 */
public class Son {

    private String name;

    public Son() {
        super();
    }
    public Son(String name) {
        super();
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Son [name=" + name + "]";
    }

}
