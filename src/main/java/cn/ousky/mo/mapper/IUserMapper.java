package cn.ousky.mo.mapper;

import cn.ousky.mo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IUserMapper {

    /**
     * 注册账号
     *
     * @param user 用户信息
     * @return 1|0
     */
    @Insert("insert into `user`(user,password,name)" +
            "values(#{user},#{password},#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int register(User user);

    /**
     * 修改密码
     *
     * @param user 用户信息
     * @return 1|0
     */
    @Update("update `user` set password=#{password} where user=#{user}")
    int updatePassword(User user);

    /**
     * 查询账户
     *
     * @param user 用户信息
     * @return 用户账户信息
     */
    @Select("select * from `user` where user=#{user} and password=#{password}")
    User queryCount(User user);
}
