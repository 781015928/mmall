package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by aimld on 2017/9/22.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse<String> selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username,String question,String answer);

    ServerResponse<String> forgerResetPassword(String username,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(User user,String passwordOld ,String passwordNew);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInfomation(Integer userId);
}
