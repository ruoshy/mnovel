package cn.ousky.mo.mapper;

import cn.ousky.mo.entity.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Topic表Mapper
 */
@Mapper
public interface ITopicMapper {

    /**
     * 与user表连接匹配book_id字段记录
     *
     * @param book_id book表字段Id
     * @return List<Topic>
     */
    @Select("<script>" +
            "select topic.*,`user`.name,`user`.`user`" +
            "from topic,`user` " +
            "where topic.user_id=`user`.id and " +
            "book_id=#{book_id} " +
            "<if test='size != 0'>" +
            "limit #{ofset},#{size}" +
            "</if>" +
            "</script>")
    @Results({
            @Result(property = "user.user", column = "user"),
            @Result(property = "user.name", column = "name")
    })
    List<Topic> findBookById(int book_id, int ofset, int size);


    /**
     * 插入评论
     *
     * @param topic 评论信息
     * @return 1|0
     */
    @Insert("insert into topic(book_id,user_id,Content,date,parent_topic_id) " +
            "values(#{book_id},#{user_id},#{content},#{date},#{parent_topic_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertTopic(Topic topic);
}
