package cn.ousky.mo.model;

import com.alibaba.fastjson.JSONObject;

public class Messagem {
    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("code", code);
        return json.toJSONString();
    }
}
