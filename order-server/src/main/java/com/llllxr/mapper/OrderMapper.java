package com.llllxr.mapper;

import com.llllxr.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    @Select("select * from orders where id = #{id}")
    Order find(Integer id);
}
