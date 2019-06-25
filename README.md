# lin-cms-java

> lin-cms 的 java 版实现基于 spring boot 和 mybatis

## 设计哲学

**简单，易用**

- PO：是 Persistant Object（持久化对象）的缩写，用于表示数据库中的一条记录映射成
  的 java 对象，PO 仅仅用于表示数据，没有任何数据操作。通常遵循 Java Bean 的规范
  ，拥有 getter/setter 方法。

- DAO：是 Data Access Object 的缩写，用于表示一个数据访问对象。使用 DAO 访问数据
  库，包括增改删查等操作，与 PO 一起使用。DAO 一般在持久层，完全 1 封装数据库操
  作，对外暴露的方法使得上层应用不需要关注数据库相关的任何信息。

- VO：（本质上是 Controller 和 View 层交互）是 View Object 的缩写，用于一个与前
  端进行交互的对象。那可以使用 PO 传递数据吗？实际上，这里的 VO 只包含前端需要展
  示的数据即可，对于前端不需要的数据，比如数据库创建和修改的时间等字段，出于减少
  传输数据量大小和保护数据库结构不外泄的目的，不应该在 VO 中体现出来，通常遵守
  Java Bean 规范，拥有 getter/setter 方法。

- DTO：（本质是经过处理的 PO 对象，可能增加或减少 PO 的属性）是 Data Transfer
  Object 的缩写，用于表示一个数据传输对象。DTO 通常用于不同服务或服务不同分层之
  间的数据传输。，DTO 和 VO 概念相似，并且通常情况下字段也基本一致。但是 DTO 和
  VO 又有一些不同，这个不同是设计理念上的。（敲黑板，划重点）DTO 代表服务层需要
  接收的数据和返回的数据，而 VO 代表展示层需要显示的数据。DTO 通常遵循 Java Bean
  的规范，拥有 getter/setter 方法。

- BO：是 Business Object（业务对象）的缩写，将业务逻辑封装为一个对象，这个对象包
  括一个或者多个其他的对象。比如一个简历，有教育经历、工作经历、社会关系等等。
  我们可以把教育经历对应一个 PO，工作经历对应一个 PO，社会关系对应一个 PO。建立
  一个对应简历的 BO 对象处理简历，每个 BO 包含这些 PO。 这样处理业务逻辑时，我们
  就可以针对 BO 去处理。

- POJO：是 Plain Ordinary Java Object（普通 java 对象）的缩写，表示一个简单的
  java 对象，上面说的 PO、VO、DTO、BO 都是典型的 POJO，而 DAO 一般不是 POJO，只
  提供一些调用方法。

## 状态

**正在抓紧实现，占坑中...**
