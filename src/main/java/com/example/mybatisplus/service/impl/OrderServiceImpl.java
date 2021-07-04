package com.example.mybatisplus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.mapper.OrderMapper;
import com.example.mybatisplus.model.domain.Ordertable;
import com.example.mybatisplus.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Ordertable> implements OrderService {
}
