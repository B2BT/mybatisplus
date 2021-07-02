package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.CategoryService;
import com.example.mybatisplus.model.domain.Category;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-04-21
 * @version v1.0
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger( CategoryController.class );

    @Autowired
    private CategoryService categoryService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Category  category =  categoryService.getById(id);
        return JsonResponse.success(category);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        categoryService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateCategory(@PathVariable("id") Long  id,Category  category) throws Exception {
        //category.setId(id);
        categoryService.updateById(category);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Category
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Category  category) throws Exception {
        categoryService.save(category);
        return JsonResponse.success(null);
    }
}

