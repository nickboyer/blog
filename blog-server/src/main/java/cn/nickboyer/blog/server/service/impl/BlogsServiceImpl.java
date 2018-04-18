/*
 * Copyright 2015 nickboyer.cn All rights reserved
 *
 * @author Kang.Y
 *
 * @mail
 *
 * @createtime 2018年1月3日 下午12:06:11
 */
package cn.nickboyer.blog.server.service.impl;

import cn.nickboyer.blog.common.Page;
import cn.nickboyer.blog.entry.*;
import cn.nickboyer.blog.server.mapper.BlogsMapper;
import cn.nickboyer.blog.server.mapper.CategoriesMapper;
import cn.nickboyer.blog.server.mapper.TagsMapper;
import cn.nickboyer.blog.server.service.BaseService;
import cn.nickboyer.blog.server.service.IBlogsService;
import cn.nickboyer.blog.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kang.Y
 * @title
 * @description
 * @since JDK1.8
 */
@Service
public class BlogsServiceImpl extends BaseService implements IBlogsService {

    @Autowired
    private BlogsMapper blogsMapper;
    @Autowired
    private TagsMapper tagsMapper;
    @Autowired
    private CategoriesMapper categoriesMapper;

    /**
     * （no Javadoc）
     *
     * @see cn.nickboyer.blog.api.service.IBlogsService#findList(cn.nickboyer.blog.api.entry.Blogs, java.lang.String, java.lang.String)
     */
    @Override
    public Page<Blogs> findList(Blogs blogs, String pageNum, String pageSize) {

        com.github.pagehelper.Page<Blogs> page = PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize), true);
        blogsMapper.selectList();
        return new Page<Blogs>(page);
    }

    /**
     * （no Javadoc）
     *
     * @see cn.nickboyer.blog.server.service.IBlogsService#findDetail(java.lang.String)
     */
    @Override
    public Blogs findDetail(String id) {
        // 获取详情
        Blogs blog = blogsMapper.selectById(id);
        // 获取上一个，下一个
        Blogs prev = blogsMapper.selectPrev(id);
        blog.setPrev(prev);
        Blogs next = blogsMapper.selectNext(id);
        blog.setNext(next);
        // 获取关联标签
        List<Tags> tags = blogsMapper.selectTagsById(id);
        blog.setTags(tags);
        // 阅读次数
        blogsMapper.updateWatch(id);
        return blog;
    }

    /**
     * （no Javadoc）
     *
     * @see cn.nickboyer.blog.server.service.IBlogsService#findTags()
     */
    @Override
    public List<Tags> findTags() {
        return tagsMapper.selectAll();
    }

    /**
     * （no Javadoc）
     *
     * @see cn.nickboyer.blog.server.service.IBlogsService#findTag(java.lang.String)
     */
    @Override
    public Tags findTag(String id) {
        Tags tag = tagsMapper.selectById(id);
        tag.setArchives(getArchives(tagsMapper.selectBlogsByTagId(id)));
        return tag;
    }

    /*
     * （非 Javadoc）
     *
     * @see cn.nickboyer.blog.server.service.IBlogsService#findArchives()
     */
    @Override
    public List<Archives> findArchives() {
        return getArchives(blogsMapper.selectArchives());

    }

    /**
     * @param blogs
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月7日 下午5:08:23
     */
    private List<Archives> getArchives(List<Blogs> blogs) {
        List<Archives> list = new ArrayList<>();
        Archives archives = null;
        List<Blogs> sames = null;
        String time = null;
        for (Blogs blog : blogs) {
            String createTime = DateUtil.toYYYY_MM(blog.getCreateTime());
            if (!createTime.equals(time)) {
                if (StringUtils.isNotEmpty(time)) {
                    list.add(archives);
                }
                time = createTime;
                sames = new ArrayList<>();
                archives = new Archives(time, sames);
            }
            sames.add(blog);
        }
        list.add(archives);
        return list;
    }

    /*
     * （非 Javadoc）
     *
     * @see cn.nickboyer.blog.server.service.IBlogsService#findCategories()
     */
    @Override
    public List<Categories> findCategories() {
        return categoriesMapper.selectAll();
    }

    /*
     * （非 Javadoc）
     *
     * @see cn.nickboyer.blog.server.service.IBlogsService#findCategory(java.lang.String)
     */
    @Override
    public Categories findCategory(String id) {
        Categories category = categoriesMapper.selectById(id);
        List<Blogs> blogs = blogsMapper.selectListByCategoryId(id);
        category.setArchives(getArchives(blogs));
        return category;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void blogSave(Blogs blogs) {
        Categories categories = categoriesMapper.selectById(blogs.getCategoryId() + "");
        blogs.setCategoryName(categories.getName());
        blogs.setCreateTime(new Date());

        if (blogs.getId() == null) {
            blogsMapper.insert(blogs);
        }else {
            blogsMapper.update(blogs);
            tagsMapper.deleteRelation(blogs.getId());
        }
        if (blogs.getTags() != null) {

            List<BlogTagRelation> list = new ArrayList<>();
            BlogTagRelation btr = null;
            for (Tags tag : blogs.getTags()) {
                btr = new BlogTagRelation();
                btr.setBlogId(blogs.getId() + "");
                btr.setTagId(tag.getId() + "");
                list.add(btr);
            }
            tagsMapper.insertRelation(list);
        }
    }

    @Override
    public List<Tags> findTagsById(String id) {

        return blogsMapper.selectTagsById(id);
    }

}
