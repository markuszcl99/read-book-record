package com.markus.designpattern.adapter;

/**
 * @author: markus
 * @date: 2022/7/17 2:27 PM
 * @Description: 客户端--调用用户信息者
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class Client {
    public static void main(String[] args) {
        IUserInfo userInfo = new UserInfo();
        System.out.println("--------------正式员工信息--------------");
        userInfo.getHomeAddress();
        userInfo.getUserName();
        userInfo.getHomeTellNumber();
        userInfo.getJobPosition();
        userInfo.getMobileNumber();
        userInfo.getOfficeTellNumber();
        System.out.println("--------------------------------------");
        IUserInfo outUserInfo = new OuterUserInfo();
        System.out.println("--------------外包员工信息--------------");
        outUserInfo.getHomeAddress();
        outUserInfo.getUserName();
        outUserInfo.getHomeTellNumber();
        outUserInfo.getJobPosition();
        outUserInfo.getMobileNumber();
        outUserInfo.getOfficeTellNumber();
        System.out.println("--------------------------------------");
    }
}
