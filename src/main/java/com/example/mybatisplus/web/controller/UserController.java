package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.model.domain.Users;
import com.example.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController  {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Users user =  userService.getById(id);
        return JsonResponse.success(user);
    }

    /**
     * 描述：用户登录
     *
     */
    @RequestMapping(path = "/login")
    @ResponseBody
    public JsonResponse login(String username, String password){
        System.out.println(username+password);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        wrapper.eq("password",password);
        Users user = userService.getOne(wrapper);

        return JsonResponse.success(user);
    }



    /**
     * 描述：根据Id删除
     *
     */
    @GetMapping(path = "/delete", params = "id")
    @ResponseBody
    public JsonResponse deleteById(Integer id) throws Exception {
        userService.removeById(id);
        System.out.println(userService.toString());
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAdmin(@PathVariable("id") Integer  id, Users user) throws Exception {
        user.setUserid(id);
        userService.updateById(user);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建user
     *
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Users user) throws Exception {
        userService.save(user);
        return JsonResponse.success(null);
    }
    @RequestMapping("/list")
    @ResponseBody
    public JsonResponse list(Model model,
                             @RequestParam(required = false,defaultValue = "0") Integer pageNo,
                             @RequestParam(required = false,defaultValue = "10")Integer pageSize){
        Page<Users> page = userService.page(new Page<>(pageNo, pageSize));

        return JsonResponse.success(page);
    }

    @RequestMapping("/deleteByIds")
    @ResponseBody
    public JsonResponse deleteByIds(@RequestParam("ids[]") List<Integer> ids){
        userService.removeByIds(ids);
        return JsonResponse.success( null);
    }
}
