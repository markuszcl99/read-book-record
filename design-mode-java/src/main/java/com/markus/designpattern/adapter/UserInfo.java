package com.markus.designpattern.adapter;

/**
 * @author: markus
 * @date: 2022/7/17 2:05 PM
 * @Description: 用户信息实现类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class UserInfo implements IUserInfo{

    @Override
    public String getUserName() {
        System.out.println("这里是员工的姓名....");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("这里是员工的家庭住址...");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("这里是员工的手机号...");
        return null;
    }

    @Override
    public String getOfficeTellNumber() {
        System.out.println("这里是员工的办公室电话号...");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("这里是员工的职位描述...");
        return null;
    }

    @Override
    public String getHomeTellNumber() {
        System.out.println("这里是员工的家庭号码...");
        return null;
    }
}
