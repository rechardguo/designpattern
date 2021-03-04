# eshop
Java架构师训练营的大型电商项目

# 我的记录

## todo list
- [x] 111_基于原型模式和享元模式完成不同分层POJO之间的数据拷贝

- [x] 121_结合模板方法模式、命令模式、工厂方法模式开发库存管理功能

- [X] 133_基于中介者模式异步通知调度中心更新库存

- [x] 134_基于观察者模式获取调度中心的异步处理结果

- [X] 146_开发类目管理模块以及对原型模式完善深度克隆功能

- [x] 152_基于优化后的组合模式与访问者模式完成删除类目功能

3.3
- [ ] 161_基于策略模式与抽象工厂模式完成订单价格计算功能

1. 满减
2. 多买
3. 赠品促销

3.4

- [ ] 164_基于访问者模式完成权限控制模块的代码编写

- [ ] 165_基于享元模式实现权限数据的缓存与刷新

- [ ] 172_基于构造器模式完成销售出库单创建的代码编写

- [ ] 189_基于访问者模式完成类目属性继承功能的实现

3.5
- [ ] 190_基于状态模式完成商品管理模块的状态流转逻辑封装

- [ ] 205_基于设计模式完成会员等级积分更新模块 

- [ ] 239_基于策略模式完成物流中心的运费计算模块的开发

- [ ] 243_结合模板方法模式对订单中心的状态模式进行优化

3.6
- [ ] 250_基于解释器模式与组合模式重构规则解析代码
- [ ] 251_基于装饰模式重构订单状态管理器和订单操作日志
- [ ] 252_基于适配器模式重构文件操作API接口
- [ ] 253_基于迭代器模式重构离线存储数据恢复代码
- [ ] 255_基于代理模式完成物流中心剩余功能的开发

3.7
- [ ] 270_275基于阿里编码规范eclipse插件进行静态代码扫描
- [ ] 276_基于maven corbertura插件生成单元测试覆盖率报告
- [ ] 277_基于码云Pull Request完成code review
- [ ] 278_285 基于develop分支和多环境配置完成集成测试 






## 业务
> 设计模式使用必须得要了解业务的基础上来使用，这里简单了记录了各个业务点

- inventory和wms有什么区别？

理解: inventory 就是纯粹的数量 而wms需要考虑到和库存的货架相关
当然也包括了库存。

- 



## 设计模式

### 克隆模式

让自己clone自己

### 享元模式
beancopier 不需要每个类都每次需要clone的时候都重新new一个出来
而是通过缓存来获取的

### 观察者模式+备忘录模式 
----
观察者模式需要用到的Java类

- java.util.Observable

able一般可能...的单词后缀，Observable就是可以被观察的，程序中的被观察者类，需要继承这个类。

- java.util.Observer

　这个是观察者，是接口。程序中的观察者类，需要实现这个接口中的update()方法。

---
客户创建订单 -》通知库存中心，“提交订单”事件发生了
InventoryServiceImpl.java
更新自己的库存
发送异步消息到内存队列通知仓储系统
  goodsStockUpdateQueue.put(message);
// 监听异步处理结果
//将messageid 封装成一个observable对象，并将1个observer注册进去
goodsStockUpdateManager.observe(message.getId());  


schedule 调度中心 
ScheduleStockUpdateMessageConsumer 
 从goodsStockUpdateQueue获取消息，消费后通知库存中心（observer）


观察者模式+备忘录模式的图可看大型电商.drawio里的
tab-观察者模式和备忘录模式


### 命令模式+工厂模式+模板方法

库存的几大操作如下：

- 客户创建订单后库存的改变
- 客户支付订单后库存的改变
- 客户订单取消后库存的改变
- 采购入库库存的改变
- 客户退货后库存的改变
 
这些操作都有一些通用的操作，

1. 更新商品的销售库存
2. 更新商品的锁定库存
3. 更新商品的已销售库存
4. 更新商品的库存状态
5. updateGmtModified()
6. 实际执行更新商品库存的操作

所以对StockUpdater有一个abstractStockUpdater,
abstractStockUpdater里定义了模板方法，让1,2,3成为模板
抽象方法给不同的具体操作类来实现


为啥还需要工厂方法,而不是直接使用具体的stockUpdater呢？

>因为如果直接使用的话
需要将一些各个渠道的数据封装好放到StockUpdater,各个渠道的数据并
不一致，放到具体的controller里话就会显得controller类很臃肿

这个确实做的很不错，但需要在自己的工作里来写估计还需要费点心思。



### 访问者模式
auth模块里的权限查询,权限移除,权限关联
- com.zhss.eshop.auth.service.impl.QueryAuthorizedPriorityOperation
- com.zhss.eshop.auth.service.impl.RelatedCheckPriorityOperation
- com.zhss.eshop.auth.service.impl.RemovePriorityOperation

我自己写的访问者是用来替换json的占位符操作。
例如
有占位符的json如下
```json
{
ref:${userInfoRes.ref},
account:[{id:${userInfoRes.accts[0].id},{id:${userInfoRes.accts[1].id}]
}
```
userInfoRes的json

```json
{
  "ref": "123",
  "accts":[{"id": 1,"name": "acct1"},{"id":2,"name": "acct2"}]
}
```

## 测试

仿照ShoppingCartControllerTest 我写了
ShoppingCartItemControllerTest

主要是mockito的使用，如何模拟抛出异常
```java
 doThrow(new Exception()).when(shoppingCartItemService)
                .updatePurchaseQuantity(cartItemId,q);
```
 
springboot的测试的几个annotation

- @SpringBootTest
- @RunWith(SpringRunner.class) 
- @WebMvcTest只会扫描您定义的控制器和MVC基础设施。

[springboot 官方test参考文档](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-testing-spring-boot-applications)



## domain

- vo valueObject 发给前台的
- dto datObject transfer Object 一般是do的转换对象
- do dataObject  一般是数据库查出的对象


## 业务理解


### 库存主要业务
销售库存：100

锁定库存：10

已销售库存：2

实际库存=锁定库存+销售库存： 110

采购入库：增加销售库存

客户下订单未支付：减销售库存，增加锁定库存

客户下订单未支付取消: 增销售库存，减锁定库存

客户订单支付：减锁定库存，增销售库存

客户退货入库： 减已销售库存，增销售库存

**使用命令模式**


### wms
和仓库相关

仓库里有货架，货架有编号,例如A-01-01(A排第1个货架第1层)
A-01-02(A排第1个货架第2层)

采购订单：n个订单项

订单项：skuid 数量

入库后：货品放在哪个货架有多少件，货品是哪个订单

表：

- 货位
- 采购订单
- 采购订单项
- 商品库存
- 货位库存
- 采购入库单关联的上架条目表


### 商品价格计算

calculateOrderPrice 计算订单的价格
订单的价格分成3部分
1.总价格
2.折扣价格
3.运费

```java
// 订单 dto类
class OrderInfoDTO{
  List <OrderItemDTO> items; // 订单项 dto类
}
```
从OderInfoDTO里 根据OrderItemDTO 从促销中心找到促销活动
PromotionActivityDTO ，促销活动分成以下的5类

满减促销
单品促销
多买优惠
满赠促销
赠品促销

以上又可细分成成2类

折扣减免 DiscountOrderPriceCalculatorFactory
-    满减促销
-    单品促销
-    多买优惠
-    满赠促销
    
赠品促销  GiftOrderPriceCalculatorFactory








