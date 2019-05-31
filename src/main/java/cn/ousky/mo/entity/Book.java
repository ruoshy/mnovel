package cn.ousky.mo.entity;

import com.alibaba.fastjson.JSONObject;

public class Book {
    private int id;
    private String name;
    private String author;
    private int type_id;
    private String date;
    private String last_chapter;
    private String free_range;
    private String introduct;
    private int state;
    private String cover;
    private String wallpaper;

    private Type type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLast_chapter() {
        return last_chapter;
    }

    public void setLast_chapter(String last_chapter) {
        this.last_chapter = last_chapter;
    }

    public String getFree_range() {
        return free_range;
    }

    public void setFree_range(String free_range) {
        this.free_range = free_range;
    }

    public String getIntroduct() {
        return introduct;
    }

    public void setIntroduct(String introduct) {
        this.introduct = introduct;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(String wallpaper) {
        this.wallpaper = wallpaper;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", name);
        json.put("author", author);
        json.put("date", date);
        json.put("last_chapter", last_chapter);
        json.put("introduct", introduct);
        json.put("state", state);
        json.put("cover", cover);
        json.put("wallpaper", wallpaper);
        json.put("type", type);
        return json.toJSONString();
    }
}
