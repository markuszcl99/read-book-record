package com.markus.designpattern.adapter;

/**
 * @author: markus
 * @date: 2022/7/17 2:03 PM
 * @Description: 用户信息接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface IUserInfo {
    String getUserName();

    String getHomeAddress();

    String getMobileNumber();

    String getOfficeTellNumber();

    String getJobPosition();

    String getHomeTellNumber();
}
