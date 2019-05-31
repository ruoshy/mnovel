package cn.ousky.mo.mapper;

import cn.ousky.mo.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * Type表Mapper
 */
@Mapper
public interface ITypeMapper {

    @Select("select * from type where id=#{id}")
    Type findById(int id);

}
