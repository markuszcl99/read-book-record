package com.markus.designpattern.chain.scene_one;

/**
 * @author: markus
 * @date: 2023/3/16 10:14 AM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Women implements IWoman {
    /**
     * 模拟女性类别
     * 1--未出嫁
     * 2--出嫁
     * 3--夫死
     */
    private final int type;
    private final String request;

    public Women(int type, String request) {
        this.type = type;

        switch (type) {
            case 1:
                this.request = "女儿想要请求：" + request;
                break;
            case 2:
                this.request = "妻子想要请求：" + request;
                break;
            case 3:
                this.request = "母亲想要请求：" + request;
                break;
            default:
                this.request = request;
        }
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getRequest() {
        return request;
    }
}
