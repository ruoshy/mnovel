package cn.ousky.mo.mapper;

import cn.ousky.mo.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Book表Mapper
 */
@Mapper
public interface IBookMapper {
    /**
     * 匹配id字段记录
     *
     * @param id 字段Id
     * @return Book
     */
    @Select("select * from book where id=#{id}")
    Book findById(int id);

    /**
     * 模糊匹配Name字段记录
     *
     * @param name  字段Name
     * @param start 页位置
     * @param size  每页数量
     * @return List<Book>
     */
    @Select("select book.*,type.`name` tname from book,type " +
            "where book.type_id=type.id and " +
            "book.name like concat('%',#{name},'%') " +
            "limit #{start},#{size}")
    @Results({
            @Result(property = "type.name", column = "tname")
    })
    List<Book> likeName(String name, int start, int size);


    /**
     * 与type表连接匹配type_id字段记录
     *
     * @param type_id 字段type_id
     * @param start   页位置
     * @param size    每页数量
     * @return List<Book>
     */
    @Select("select book.*,type.`name` tname from book,type " +
            "where book.type_id=type.id and " +
            "book.type_id=#{type_id} " +
            "limit #{start},#{size}")
    @Results({
            @Result(property = "type.name", column = "tname")
    })
    List<Book> findByTypeId(int type_id, int start, int size);


    /**
     * 按日期顺序获取book记录
     *
     * @param start 页位置
     * @param size  每页数量
     * @return List<Book>
     */
    @Select("select book.*,type.`name` tname from book,type " +
            "where book.type_id=type.id " +
            "order by date desc " +
            "limit #{start},#{size}")
    @Results({
            @Result(property = "type.name", column = "tname")
    })
    List<Book> findByNewBook(int start, int size);


    /**
     * 匹配state字段记录
     *
     * @param state 状态
     * @param start 页位置
     * @param size  每页数量
     * @return List<Book>
     */
    @Select("select book.*,type.`name` tname from book,type " +
            "where book.type_id=type.id and " +
            "book.state=#{state} " +
            "order by date desc " +
            "limit #{start},#{size}")
    @Results({
            @Result(property = "type.name", column = "tname")
    })
    List<Book> findOverBook(int state, int start, int size);
}
