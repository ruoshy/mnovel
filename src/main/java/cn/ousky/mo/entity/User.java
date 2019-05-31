package cn.ousky.mo.entity;

import com.alibaba.fastjson.JSONObject;


public class User {
    private int id;
    private String user;
    private String password;
    private String name;
    private int read_ticket;
    private int free_ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRead_ticket() {
        return read_ticket;
    }

    public void setRead_ticket(int read_ticket) {
        this.read_ticket = read_ticket;
    }

    public int getFree_ticket() {
        return free_ticket;
    }

    public void setFree_ticket(int free_ticket) {
        this.free_ticket = free_ticket;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("user", user);
        //json.put("password", password);
        json.put("name", name);
        json.put("read_ticket", read_ticket);
        json.put("free_ticket", free_ticket);
        return json.toJSONString();
    }
}
