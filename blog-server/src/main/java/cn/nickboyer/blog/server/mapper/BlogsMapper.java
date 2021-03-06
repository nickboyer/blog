/*
 * Copyright 2015 nickboyer.cn All rights reserved
 *
 * @author Kang.Y
 *
 * @mail
 *
 * @createtime 2018年1月3日 下午12:07:48
 */
package cn.nickboyer.blog.server.mapper;

import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Tags;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Kang.Y
 * @title
 * @description
 * @since JDK1.8
 */
@Mapper
public interface BlogsMapper {

    /**
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月3日 下午12:12:51
     */
    @Select("select id,header,create_time,category_id,category_name,watch,intro from blogs order by id desc")
    List<Blogs> selectList();

    /**
     * @param id
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月4日 下午1:16:14
     */
    @Select("select * from blogs where id = #{id}")
    Blogs selectById(String id);

    /**
     * @param id
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月4日 下午3:59:22
     */
    @Select("select a.id,a.name from tags a,blog_tag_relation b where a.id = b.tag_id and b.blog_id = #{id}")
    List<Tags> selectTagsById(String id);

    /**
     * @param id
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月4日 下午10:17:36
     */
    @Select("select id,header from blogs where id > #{id} order by id asc limit 1")
    Blogs selectPrev(String id);

    /**
     * @param id
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月4日 下午10:17:41
     */
    @Select("select id,header from blogs where id < #{id} order by id desc limit 1")
    Blogs selectNext(String id);

    /**
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月5日 下午1:21:34
     */
    @Select("select count(1) from blogs")
    int count();

    /**
     * @param id
     * @authz Kang.Y
     * @createtime 2018年1月5日 下午1:41:39
     */
    @Update("update blogs set watch = watch + 1 where id = #{id}")
    void updateWatch(String id);

    /**
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月5日 下午9:17:57
     */
    @Select("select id,header,create_time,update_time from blogs order by id desc")
    List<Blogs> selectArchives();

    /**
     * @param id
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月7日 下午4:17:39
     */
    @Select("select id,header,create_time,update_time from blogs where category_id = #{id} order by id desc")
    List<Blogs> selectListByCategoryId(String id);

    /**
     * 新增
     *
     * @param blog
     */
    @Insert("insert into blogs (header,intro,content,category_id,category_name,create_time) values(#{header},#{intro},#{content},#{categoryId},#{categoryName},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Blogs blog);

    /**
     * 更新
     *
     * @param blogs
     */
    @Update("update blogs set header = #{header},intro = #{intro},content = #{content},category_id = #{categoryId},category_name = #{categoryName} where id = #{id}")
    void update(Blogs blogs);
}
