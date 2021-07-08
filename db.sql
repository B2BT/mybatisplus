CREATE DATABASE eshop;
USE eshop;
CREATE TABLE users(
                      userid INT NOT NULL AUTO_INCREMENT  COMMENT '用户id' ,
                      username VARCHAR(32)    COMMENT '用户名' ,
                      phone VARCHAR(32)    COMMENT '手机号' ,
                      PASSWORD VARCHAR(32)    COMMENT '密码' ,
                      PRIMARY KEY (userid)
) COMMENT = '用户表 ';

INSERT INTO users(username,phone,PASSWORD) VALUES("test",1234567891,"1234");


CREATE TABLE goods(
                      goodsid INT NOT NULL AUTO_INCREMENT  COMMENT '商品id' ,
                      goodsname VARCHAR(32)    COMMENT '商品名' ,
                      info VARCHAR(1024)    COMMENT '商品信息' ,
                      price DECIMAL(32,10)    COMMENT '商品价格' ,
                      shopid INT    COMMENT '商品所属卖家id' ,
                      goodspic VARCHAR(3072)    COMMENT '图片链接' ,
                      PRIMARY KEY (goodsid)
) COMMENT = '商品表 ';

INSERT INTO goods(goodsname,info,price,shopid,goodspic) VALUES("华为盒子","华为电视盒子",349,1001,"img/index/banner_big.jpg");
INSERT INTO goods(goodsname,info,price,shopid,goodspic) VALUES("荣耀6 plus","荣耀6Plus搭载八核麒麟925芯片，支持LTE Cat6，同样内置了i3协处理器，可以记录用户的运动",2899,1002,"img/index/adv1.jpg");
INSERT INTO goods(goodsname,info,price,shopid,goodspic) VALUES("华为p7","陶瓷板",2588,1001,"img/index/adv2.jpg");
INSERT INTO goods(goodsname,info,price,shopid,goodspic) VALUES("荣耀盒子","298",298,1002,"img/index/adv_l1.jpg");
INSERT INTO goods(goodsname,info,price,shopid,goodspic) VALUES("荣耀畅玩4x"," ",1599,1002,"img/index/adv3.jpg");
INSERT INTO goods(goodsname,info,price,shopid,goodspic) VALUES("荣耀6套餐版"," ",349,1002,"img/index/adv4.jpg");

CREATE TABLE shop(
                     shopid INT(10) NOT NULL AUTO_INCREMENT  COMMENT '卖家id' ,
                     shopusername VARCHAR(32)    COMMENT '卖家用户名' ,
                     PASSWORD VARCHAR(32)    COMMENT '卖家密码' ,
                     PRIMARY KEY (shopid)
) COMMENT = '卖家表  ';

CREATE TABLE ordertable(
                           orderid INT(10) NOT NULL AUTO_INCREMENT  COMMENT '订单编号' ,
                           ordertime DATETIME    COMMENT '创建日期' ,
                           userid INT(10)    COMMENT '用户id' ,
                           goodsid INT(10)    COMMENT '商品id' ,
                           ispay INT(10)    COMMENT '是否下单' ,
                           PRIMARY KEY (orderid)
) COMMENT = '订单表  ';