package com.bytedance.movies.bean;

/**
 * @Classname Root
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/11 23:35
 */
public class Root {
    private Data data;

    private Extra extra;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public Extra getExtra() {
        return this.extra;
    }
}

