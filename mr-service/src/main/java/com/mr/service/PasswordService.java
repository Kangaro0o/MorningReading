package com.mr.service;

import java.util.Date;

/**
 * @author LiuWen
 * @date 2019-12-18 21:01
 */
public interface PasswordService {
    /**
     * 密码是否匹配
     */
    boolean validate(String password, String today);
}
