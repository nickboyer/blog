package cn.nickboyer.blog.admin.controller;

import cn.nickboyer.blog.admin.cloud.IBlogsService;
import cn.nickboyer.blog.entry.Categories;
import cn.nickboyer.blog.entry.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogsService blogsService;

    @RequestMapping("/blog/add")
    public ModelAndView toAdd(ModelAndView mv, HttpServletRequest request){

        // 获取所有的标签
        List<Tags> tags = blogsService.findTags();

        // 获取所有的分类
        List<Categories> categories = blogsService.findCategories();

        mv.addObject("tags",tags);
        mv.addObject("categories",categories);
        mv.setViewName("blog_add");
        return mv;
    }
}
