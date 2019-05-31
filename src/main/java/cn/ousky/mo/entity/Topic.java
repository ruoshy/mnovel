package cn.ousky.mo.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class Topic {
    private int id;
    private int book_id;
    private int user_id;
    private String content;
    private Date date;
    private int parent_topic_id;
    private int fabulous;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getParent_topic_id() {
        return parent_topic_id;
    }

    public void setParent_topic_id(int parent_topic_id) {
        this.parent_topic_id = parent_topic_id;
    }

    public int getFabulous() {
        return fabulous;
    }

    public void setFabulous(int fabulous) {
        this.fabulous = fabulous;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("book_id", book_id);
        json.put("user_id", user_id);
        json.put("content", content);
        json.put("date", date);
        json.put("parent_topic_id", parent_topic_id);
        json.put("fabulous", fabulous);
        json.put("user", user);
        return json.toJSONString();
    }
}
