package cn.ousky.mo.controller;

import cn.ousky.mo.entity.Topic;
import cn.ousky.mo.entity.User;
import cn.ousky.mo.model.Messagem;
import cn.ousky.mo.seriver.UserSeriver;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserSeriver userSeriver;

    /**
     * 发送验证码到邮箱
     *
     * @param user 账户名(邮箱)
     * @return Messagem
     */
    @RequestMapping("/email")
    public Messagem sendEmail(@RequestParam("user") String user) {
        return userSeriver.sendEmail(user);
    }

    /**
     * 登录
     *
     * @param user     账户名(邮箱)
     * @param password 密码
     * @return User
     */
    @RequestMapping("/login")
    public String login(@RequestParam("user") String user,
                        @RequestParam("password") String password) {
        // 查找用户个人账户信息
        User rser = new User();
        rser.setUser(user);
        rser.setPassword(password);

        return userSeriver.login(rser).toString();
    }

    /**
     * 用户注册
     *
     * @param user     账户名(邮箱)
     * @param password 密码
     * @param name     用户名
     * @param code     验证码
     * @return Messagem
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Messagem register(@RequestParam("user") String user,
                             @RequestParam("password") String password,
                             @RequestParam("name") String name,
                             @RequestParam("code") String code) {
        User rser = new User();
        rser.setUser(user);
        rser.setPassword(password);
        rser.setName(name);

        return userSeriver.register(rser, code);
    }

    /**
     * 修改密码
     *
     * @param user     账户名(邮箱)
     * @param password 密码
     * @param code     验证码
     * @return messagem
     */
    @RequestMapping(value = "/udpwd", method = RequestMethod.POST)
    public Messagem updatePassword(@RequestParam("user") String user,
                                 @RequestParam("password") String password,
                                 @RequestParam("code") String code) {
        User rser = new User();
        rser.setUser(user);
        rser.setPassword(password);

        return userSeriver.updatePassword(rser, code);
    }

    /**
     * 插入评论
     *
     * @param bookId       作品id
     * @param parenTopicId 父评id
     * @param userId       用户id
     * @param content      评论内容
     * @return Messagem
     */
    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public Messagem insertTopic(@RequestParam("bid") int bookId,
                              @RequestParam("ui") int userId,
                              @RequestParam("ct") String content,
                              @RequestParam(value = "ptid", required = false, defaultValue = "0") int parenTopicId) {
        Topic topic = new Topic();
        topic.setBook_id(bookId);
        topic.setParent_topic_id(parenTopicId);
        topic.setUser_id(userId);
        topic.setContent(content);
        Date date = new Date();
        topic.setDate(date);

        return userSeriver.insertTopic(topic);
    }

    /**
     * 获取指定作品评论信息
     *
     * @param bookId 作品id
     * @param ofset  评论开始位置
     * @param size   长度
     * @return List<Topic>
     */
    @RequestMapping("/fid/{bookId}")
    public List<Topic> findTopicByBookId(@PathVariable("bookId") int bookId,
                                         @RequestParam(name = "ofset", required = false, defaultValue = "0") int ofset,
                                         @RequestParam(name = "size", required = false, defaultValue = "4") int size) {
        return userSeriver.findTopicByBookId(bookId, ofset, size);
    }
}
