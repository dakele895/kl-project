package com.study.lamdba.optional;

import java.util.Optional;

/**
 * @Auther: dalele
 * @Date: 2019/8/28 23:12
 * @Description:
 */
public class Father2 {

    private Optional<Son> son =
//保证OPtional类不为空
            Optional.empty();
    public Father2() {
        super();
    }
    public Father2(Optional<Son> son) {
        super();
        this.son = son;
    }

    public Optional<Son> getSon() {
        return son;
    }
    public void setSon(Optional<Son> son) {
        this.son = son;
    }



    @Override
    public String toString() {
        return "Father2 [son=" + son + "]";
    }
}
