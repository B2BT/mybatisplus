package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.model.domain.Ordertable;
import com.example.mybatisplus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Ordertable ordertable =  orderService.getById(id);
        return JsonResponse.success(ordertable);
    }


    /**
     * 描述：根据Id删除
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Integer id) throws Exception {
        orderService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAdmin(@PathVariable("id") Integer  id, Ordertable ordertable) throws Exception {
        ordertable.setOrderid(id);
        orderService.updateById(ordertable);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建Admin
     *
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Ordertable ordertable) throws Exception {
        orderService.save(ordertable);
        return JsonResponse.success(null);
    }
    @RequestMapping("/list")
    @ResponseBody
    public JsonResponse list(Model model,
                             @RequestParam(required = false,defaultValue = "1") Integer pageNo,
                             @RequestParam(required = false,defaultValue = "5")Integer pageSize){
        Page<Ordertable> page = orderService.page(new Page<>(pageNo, pageSize));

        return JsonResponse.success(page);
    }

    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonResponse deleteByIds(@RequestParam("ids[]") List<Integer> ids){
        orderService.removeByIds(ids);
        return JsonResponse.success( null);
    }
}
