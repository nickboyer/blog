package cn.nickboyer.blog.admin.cloud;

import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Categories;
import cn.nickboyer.blog.entry.Tags;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "blog-server")
@RequestMapping("/blogs")
public interface IBlogsService {


    /**
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月4日 下午4:47:36
     */
    @RequestMapping("/tag")
    List<Tags> findTags();

    /**
     * 通过blogid获取所有关联标签
     * @param id
     * @return
     */
    @RequestMapping("/tags")
    List<Tags> findTagsById(@RequestParam("id") String id);

    /**
     * @return
     * @authz Kang.Y
     * @createtime 2018年1月7日 下午3:47:26
     */
    @RequestMapping("/category")
    List<Categories> findCategories();

    /**
     * @param blogs
     */
    @RequestMapping("/save")
    void blogSave(@RequestBody(required = false) Blogs blogs);

    /**
     * 查看详情
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    Blogs findDetail(@RequestParam("id") String id);
}
