package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.model.domain.Ordertable;
import com.example.mybatisplus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
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
     * 创建表单
     */
    @RequestMapping(path = "/makeorder")
    @ResponseBody
    public JsonResponse makeorder(int uid,int gid) {
        Ordertable ordertable = new Ordertable();
        ordertable.setUserid(uid);
        ordertable.setGoodsid(gid);
        ordertable.setOrdertime(new Date());
        ordertable.setIspay(0);
        orderService.save(ordertable);
        return JsonResponse.success(ordertable);
    }
    /**
     * 根据用户id查询订单
     */
    @RequestMapping(path = "/findorder")
    @ResponseBody
    public JsonResponse findorder(int uid, int ispay) {
        Map<String,Object> map = new HashMap<>();
        map.put("userid",uid);
        map.put("ispay",ispay);
        List<Ordertable> usersid = orderService.listByMap(map);
        System.out.println(usersid.toArray());
        return JsonResponse.success(usersid);
    }


    /**
     * 描述：根据订单Id删除
     *
     */
    @RequestMapping(path = "/delete")
    @ResponseBody
    public Boolean login(int oid){
        boolean b = orderService.removeById(oid);
        if(b==true){
            System.out.println("订单号为"+oid +"的订单被删除");
        }
        return b;
    }

    /**
     * 描述：下订单，修改订单状态
     *
     */
    @RequestMapping(path = "/pay")
    @ResponseBody
    public Boolean pay(int oid){
        Ordertable ordertable = new Ordertable();
        ordertable.setOrderid(oid);
        ordertable.setIspay(1);
        boolean b = orderService.updateById(ordertable);
        if(b==true){
            System.out.println("订单号为"+oid +"的订单被删除");
        }
        return b;
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
     * 描述:查看订单
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
