package com.jaeger.ninegridimgdemo.entity;

import java.util.List;

/**
 * Created by Jaeger on 16/2/24.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */
public class Post {
    private String mContent;
    private List<String> mImgUrlList;

    public Post() {
    }

    public Post(String content, List<String> imgUrlList) {
        mContent = content;
        mImgUrlList = imgUrlList;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public List<String> getImgUrlList() {
        return mImgUrlList;
    }

    public void setImgUrlList(List<String> imgUrlList) {
        mImgUrlList = imgUrlList;
    }
}
