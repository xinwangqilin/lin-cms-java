# demo


**打包**

```bash
mvn clean package  -Dmaven.test.skip=true
```

**启动**

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar --server.port=8888 --spring.profiles.active=prod
```


```
SpringBoot 开发电商CMS服务端（Lin-CMS-Java）
SpringBoot便捷开发模式(自动装备与自动配置)
Lin CMS架构模式
标准业务分层REST开发规范
前后端分离模式下的权限方案
自定义validator校验器
自定义logback配置
多环境配置文件
自定义骚气banner
统一异常处理，统一返回结果规范
fastjson默认json序列化方案
fastjson前端参数名转换
druid数据库连接池集成
JWT令牌发放与校验
前端权限都是假权限，服务端权限才是核心
自定义认证和授权拦截器
自定义Http请求记录拦截器
CMS服务端权限管理与注解守卫函数
CMS用户日志记录功能
MyBatis与MyBatis Plus
MyBatis Plus自定义分页
MyBatis Plus逻辑删除(软删除)拦截器
MyBatis Plus一键生成controller,service,mapper,model
Lin CMS扩展开发
Lin CMS文件上传系统

首页轮播图的展示与管理
多级分类的展示与管理
商品品牌的展示与管理
首页主题的展示与管理
首页六宫格的展示与管理
活动(页)的展示与管理
优惠卷折扣解决方案
活动页、分类、优惠卷的联动展示与管理
标准SPU与SKU的解决方案
规格的展示与管理
SPU、SKU、规格的联动展示与管理
小程序用户数据展示
用户订单数据展示
```


## 优化

更改分页返回结果

更改数组返回结果

数组和分页未找到数据，皆返回200，单个数据未找到返回404


## 数据统计与展示

周期性活跃用户

周期性订单数量，金额总量

今日支付金额，周期性支付金额

用户数量统计，区域划分

待补充。。。

将开源的page返回改下

datetime(3)

activity and others ....

*图片丢在第二列，hover之后显示全称，文字hover，太长省略

*tabbar fixed *

表格层次，表格10个 - 

订单状态，筛选，状态切换，UNPAID和CANCELED，已发货，已完成的改变，添加超时异常

图表的颜色

无折扣，第一个框禁用

spu 测试

refresh_token是否失效

按照code.md同步异常类即可

username nickname

page,count,items,total,total_page

jackson 

多级权限