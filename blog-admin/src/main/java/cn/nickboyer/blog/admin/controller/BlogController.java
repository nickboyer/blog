package cn.nickboyer.blog.admin.controller;

import cn.nickboyer.blog.admin.cloud.IBlogsService;
import cn.nickboyer.blog.biz.BizException;
import cn.nickboyer.blog.common.Assert;
import cn.nickboyer.blog.common.Const;
import cn.nickboyer.blog.common.Result;
import cn.nickboyer.blog.common.ResultCode;
import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Categories;
import cn.nickboyer.blog.entry.Tags;
import cn.nickboyer.blog.util.SftpUtil;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class BlogController {

    @Autowired
    private IBlogsService blogsService;

    @RequestMapping("/add")
    public ModelAndView toAdd(ModelAndView mv, HttpServletRequest request) {

        // 参数获取
        String id = request.getParameter("id");
        Blogs detail = null;
        List<Integer> lists = new ArrayList<>();
        if (StringUtils.isNotEmpty(id)) {
            //获取blogs
            detail = blogsService.findDetail(id);

            // 获取关联的标签
            List<Tags> blogTags = blogsService.findTagsById(id);
            for (Tags t : blogTags) {
                lists.add(t.getId());
            }
        }
        // 获取所有的标签
        List<Tags> tags = blogsService.findTags();

        // 获取所有的分类
        List<Categories> categories = blogsService.findCategories();

        mv.addObject("blog", detail);
        mv.addObject("tags", tags);
        mv.addObject("blogTags", lists);
        mv.addObject("categories", categories);
        mv.setViewName("blog_add");
        return mv;
    }

    /**
     * 图片上传接口
     *
     * @param request
     * @return
     * @throws BizException
     * @throws IOException
     * @throws SftpException
     * @throws JSchException
     */
    @RequestMapping("/blog/img/save")
    @ResponseBody
    public Object imgSave(HttpServletRequest request) throws BizException, IOException, SftpException, JSchException {

        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;

        String type = mRequest.getParameter("type");
        MultipartFile file = mRequest.getFile("file");// 文件
        Assert.notNull(type, ResultCode.ER9998, ResultCode.ER9998_MSG);
        Assert.notNull(file, ResultCode.ER9998, ResultCode.ER9998_MSG);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String fix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
        SftpUtil.upload(file.getInputStream(), type + "/" + uuid + fix);
        Result<String> result = new Result();
        result.setT(Const.NICKBOYER_LOCATION + uuid + fix);

        return result;
    }

    @RequestMapping("/blog/add/save")
    @ResponseBody
    public Object blogSave(HttpServletRequest request) {
        String id = request.getParameter("id");
        String header = request.getParameter("header");
        String[] tags = request.getParameterValues("tags");
        String categoryId = request.getParameter("categoryId");
        String intro = request.getParameter("intro");
        String content = request.getParameter("content");
        Blogs blog = new Blogs();
        blog.setId(StringUtils.isEmpty(id) ? null : Integer.valueOf(id));
        blog.setHeader(header);
        blog.setCategoryId(Integer.valueOf(categoryId));
        blog.setIntroStr(intro);
        blog.setContentStr(content);
        if (tags != null) {

            List<String> strings = Arrays.asList(tags);
            List<Tags> tagList = new ArrayList<>();
            Tags tag = null;
            for (String s : strings) {
                tag = new Tags();
                tag.setId(Integer.valueOf(s));
                tagList.add(tag);
            }

            blog.setTags(tagList);
        }
        blogsService.blogSave(blog);
        Result<String> result = new Result();
        return result;
    }
}
