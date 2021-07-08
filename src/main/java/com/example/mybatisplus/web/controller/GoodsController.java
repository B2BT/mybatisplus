package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.model.domain.Goods;
import com.example.mybatisplus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Goods goods =  goodsService.getById(id);
        return JsonResponse.success(goods);
    }


    /**
     * 描述：根据Id删除
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Integer id) throws Exception {
        goodsService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAdmin(@PathVariable("id") Integer  id, Goods goods) throws Exception {
        goods.setGoodsid(id);
        goodsService.updateById(goods);
        return JsonResponse.success(null);
    }


    /**
     * 描述:商品分页显示
     *
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Goods goods) throws Exception {
        goodsService.save(goods);
        return JsonResponse.success(null);
    }
    @RequestMapping("/list")
    @ResponseBody
    public JsonResponse list(Model model,
                             @RequestParam(required = false,defaultValue = "1") Integer pageNo,
                             @RequestParam(required = false,defaultValue = "5")Integer pageSize){
        Page<Goods> page = goodsService.page(new Page<>(pageNo, pageSize));

        return JsonResponse.success(page);
    }

    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonResponse deleteByIds(@RequestParam("ids[]") List<Integer> ids){
        goodsService.removeByIds(ids);
        return JsonResponse.success( null);
    }
}
