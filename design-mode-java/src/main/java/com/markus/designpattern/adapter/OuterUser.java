package com.markus.designpattern.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: markus
 * @date: 2022/7/17 2:11 PM
 * @Description: 外包用户信息实现类-被适配者
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class OuterUser implements IOuterUser {
    @Override
    public Map<String, String> getUserBaseInfo() {
        HashMap<String, String> baseInfoMap = new HashMap<>();

        baseInfoMap.put("userName", "这个员工叫做孙悟空");
        baseInfoMap.put("mobileNumber", "这个员工电话是...");
        return baseInfoMap;
    }

    @Override
    public Map<String, String> getUserOfficeInfo() {
        HashMap<String, String> userOfficeInfo = new HashMap<>();

        userOfficeInfo.put("jobPosition", "这个员工职位是...");
        userOfficeInfo.put("officeTellNumber", "这个员工的办公室电话是...");
        return userOfficeInfo;
    }

    @Override
    public Map<String, String> getUserHomeInfo() {
        HashMap<String, String> userHomeInfo = new HashMap<>();

        userHomeInfo.put("homeTellNumber", "这个员工家庭电话是...");
        userHomeInfo.put("homeAddress", "这个员工家庭地址是...");
        return userHomeInfo;
    }
}
