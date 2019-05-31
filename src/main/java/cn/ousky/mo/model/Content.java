package cn.ousky.mo.model;

import com.alibaba.fastjson.JSONObject;

public class Content {
    private String title;
    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("content", content);
        return json.toJSONString();
    }
}
