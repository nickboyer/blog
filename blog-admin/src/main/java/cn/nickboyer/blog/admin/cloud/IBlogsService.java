package cn.nickboyer.blog.admin.cloud;

import cn.nickboyer.blog.entry.Categories;
import cn.nickboyer.blog.entry.Tags;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "blog-server")
@RequestMapping("/blogs")
public interface IBlogsService {


    /**
     * @return
     *
     * @authz Kang.Y
     * @createtime 2018年1月4日 下午4:47:36
     */
    @RequestMapping("/tag")
    List<Tags> findTags();


    /**
     * @return
     *
     * @authz Kang.Y
     * @createtime 2018年1月7日 下午3:47:26
     */
    @RequestMapping("/category")
    List<Categories> findCategories();
}
