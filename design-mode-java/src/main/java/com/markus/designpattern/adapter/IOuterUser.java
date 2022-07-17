package com.markus.designpattern.adapter;

import java.util.Map;

/**
 * @author: markus
 * @date: 2022/7/17 2:07 PM
 * @Description: 外包用户接口
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public interface IOuterUser {
    Map<String,String> getUserBaseInfo();
    Map<String,String> getUserOfficeInfo();
    Map<String,String> getUserHomeInfo();
}
