package com.study.lamdba.optional;

/**
 * @Auther: dalele
 * @Date: 2019/8/28 23:11
 * @Description:
 */
public class Father {
    private Son son;

    public Father() {
        super();
    }
    public Father(Son son) {
        super();
        this.son = son;
    }
    public Son getSon() {
        return son;
    }
    public void setSon(Son son) {
        this.son = son;
    }

    @Override
    public String toString() {
        return "Father [son=" + son + "]";
    }

}
