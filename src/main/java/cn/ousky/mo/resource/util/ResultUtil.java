package cn.ousky.mo.resource.util;

import cn.ousky.mo.model.Messagem;
import org.springframework.stereotype.Component;

@Component
public class ResultUtil {
    public Messagem getMessage(String msg, int code) {
        Messagem msgm = new Messagem();
        msgm.setMsg(msg);
        msgm.setCode(code);
        return msgm;
    }
}
