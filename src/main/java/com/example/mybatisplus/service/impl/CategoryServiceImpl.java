package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Category;
import com.example.mybatisplus.mapper.CategoryMapper;
import com.example.mybatisplus.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-04-21
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
