package com.kl.klshop.service;

import com.kl.klshop.request.Request;

/**
 * @Auther: dalele
 * @Date: 2019/4/20 22:51
 * @Description:请求异步执行的service
 */
public interface RequestAsyncProcessService {
    void process(Request request);
}
