package com.markus.designpattern.adapter;

/**
 * @author: markus
 * @date: 2022/7/17 2:21 PM
 * @Description: 将外包用户信息接入当前系统-（类）适配器
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class OuterUserInfo extends OuterUser implements IUserInfo{
    @Override
    public String getUserName() {
        System.out.println(super.getUserBaseInfo().get("userName"));
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println(super.getUserHomeInfo().get("homeAddress"));
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println(super.getUserBaseInfo().get("mobileNumber"));
        return null;
    }

    @Override
    public String getOfficeTellNumber() {
        System.out.println(super.getUserOfficeInfo().get("officeTellNumber"));
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println(super.getUserOfficeInfo().get("jobPosition"));
        return null;
    }

    @Override
    public String getHomeTellNumber() {
        System.out.println(super.getUserHomeInfo().get("homeTellNumber"));
        return null;
    }
}
