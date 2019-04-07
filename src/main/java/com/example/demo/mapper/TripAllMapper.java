package com.example.demo.mapper;

import com.example.demo.entity.TripAll;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface TripAllMapper {
    @Select("select * from tripall where tripallid = #{id}")
    TripAll getTripAllById(Integer id);
    @Insert("insert into tripall(tripallname,tripallcreatedate) values(#{name},#{date})")
    Integer insertSingleTrip(String name, Date date);
    @Select("select * from tripall where tripallcreatedate = #{date} and tripallname = #{name} and tripalldelete = 0 ")
    TripAll getTripAllByNameAndDate(String name, Date date);
    @Select("select * from tripall where tripallname = #{name} and tripalldelete = 0 ")
    TripAll getTripAllByName(String name);
    @Update("UPDATE tripall set tripalldelete = 1 where tripallid = #{id}")
    Integer deleteTripById(Integer id);
}
