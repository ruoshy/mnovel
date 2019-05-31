package cn.ousky.mo.seriver;

import cn.ousky.mo.entity.Book;
import cn.ousky.mo.entity.Topic;
import cn.ousky.mo.entity.User;
import cn.ousky.mo.mapper.ITopicMapper;
import cn.ousky.mo.mapper.IUserMapper;
import cn.ousky.mo.model.Messagem;
import cn.ousky.mo.resource.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserSeriver {
    private static final Logger Log = LoggerFactory.getLogger(UserSeriver.class);

    @Resource
    private JavaMailSender mailSender; //邮件发送器

    @Resource
    private RedisTemplate<String, Object> redisTemplate; //redis模板

    @Resource
    private IUserMapper userMapper;

    @Resource
    private ITopicMapper topicMapper;

    @Resource
    private ResultUtil resultUtil;

    public User login(User rser) {
        User user = userMapper.queryCount(rser);
        if (user == null)
            return rser;
        return user;
    }

    public Messagem register(User rser, String code) {
        String rcode = redisTemplate.opsForValue().get(rser.getUser()) + "";
        int mcode = 0;
        try {
            if (code.equals(rcode)) {   // 效验验证码
                redisTemplate.delete(rser.getUser());   // 删除redis验证码
                userMapper.register(rser);     // 注册
                mcode = 1;
            }
        } catch (Exception e) {
            Log.error("注册失败:", e);
        }
        return resultUtil.getMessage(mcode == 1 ? "注册成功" : "验证码错误", mcode);
    }

    public Messagem updatePassword(User rser, String code) {
        String rcode = redisTemplate.opsForValue().get(rser.getUser()) + "";
        int mcode = 0;
        if (code.equals(rcode))     // 效验验证码
            if (userMapper.updatePassword(rser) == 1)    // 更新密码
                mcode = 1;
        return resultUtil.getMessage(mcode == 1 ? "找回密码成功" : "验证码错误", mcode);
    }

    public Messagem insertTopic(Topic topic) {
        int mcode = topicMapper.insertTopic(topic);
        return resultUtil.getMessage(mcode == 1 ? "插入成功" : "插入失败", mcode);
    }

    public List<Topic> findTopicByBookId(int id, int ofset, int size) {
        int dSize = size > 15 ? 15 : size;
        return topicMapper.findBookById(id, ofset, dSize);
    }

    public Messagem sendEmail(String user) {
        // 生成验证码
        int code = (int) (Math.random() * 8999 + 1000);
        // 写入验证码存在3分钟
        redisTemplate.opsForValue().set(user, code, 3, TimeUnit.MINUTES);
        SimpleMailMessage smessage = new SimpleMailMessage();
        smessage.setFrom("2018115248@qq.com");
        smessage.setTo(user);
        smessage.setSubject("验证码");
        smessage.setText("验证码:" + code);
        int mcode = 1;
        try {
            mailSender.send(smessage); //发送短信
        } catch (Exception e) {
            mcode = 0;
            Log.error("发送邮件失败:", e);
        }
        return resultUtil.getMessage(mcode == 1 ? "发送成功" : "发送失败", mcode);
    }

}
