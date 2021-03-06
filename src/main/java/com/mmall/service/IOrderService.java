package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

/**
 * Created by aimld on 2017/10/8.
 */
public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String,String> params);

    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);
}
