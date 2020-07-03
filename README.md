# ray

#### 使用springboot+mybatisplus+dubbo的分布式敏捷开发框架

- 注：数据库分库分表使用依赖为
````
<dependency>
    <groupId>org.apache.shardingsphere</groupId>
    <artifactId>shardingsphere-jdbc-spring-boot-starter</artifactId>
    <version>${shardingsphere.version}</version>
</dependency>
````
- 1.0分支数据库分库分表使用依赖为
````
<dependency>
    <groupId>io.shardingsphere</groupId>
    <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
    <version>${shardingsphere.version}</version>
</dependency>
````

#### 功能说明
基于springboot+mybatisplus+dubbo的分布式敏捷开发项目，包含以下功能：
- 1.一键生成entity,dao,service,serviceImpl,controller,同时service满足dubbo配置，可供其他项目调用
- 2.基于docker-compose的mysql主从一键化搭建，结构为一主两从和一主一从共五个数据库
- 3.自定义yml文件对称加密
- 4.基于sharding-jdbc-spring-boot-starter的分库分表,读写分离和TransactionType.LOCAL类型的分布式事务


#### 后端技术:
技术 | 名称 | 官网
----|------|----
Spring Framework | 容器  | [http://projects.spring.io/spring-framework/](http://projects.spring.io/spring-framework/)
SpringMVC | MVC框架  | [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc)
Spring Boot | spring快速开发 | [http://shiro.apache.org/](http://shiro.apache.org/)
MyBatis Plus | ORM框架  | [https://mp.baomidou.com/](https://mp.baomidou.com/)
MyBatis Plus Generator | 代码生成  | [https://mybatis.plus/guide/generator.html](https://mybatis.plus/guide/generator.html)
Apache ShardingSphere | 分布式关系型数据库中间件  | [https://shardingsphere.apache.org/](https://shardingsphere.apache.org/)
Druid | 数据库连接池  | [https://github.com/alibaba/druid](https://github.com/alibaba/druid)
freemarker| 模板引擎  | [https://freemarker.apache.org/](https://freemarker.apache.org/)
ZooKeeper | 分布式协调服务  | [http://zookeeper.apache.org/](http://zookeeper.apache.org/)
Dubbo | 分布式服务框架  | [http://dubbo.io/](http://dubbo.io/)
Swagger2 | 接口测试框架  | [http://swagger.io/](http://swagger.io/)
Maven | 项目构建管理  | [http://maven.apache.org/](http://maven.apache.org/)
