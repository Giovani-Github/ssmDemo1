# 项目简介

   SSM框架整合练习项目
   来自《2017-7黑马49期web》

# 项目总结

#### 1. 项目搭建

   + 错误1：找不到`DataSource` `2018年7月10日12:58:51`

     ```
      严重: Exception sending context initialized event to listener instance of class org.springframework.web.context.ContextLoaderListener
      org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'transactionManager' defined in file [F:\IdeaProjects\ssmDemo1\out\artifacts\ssmDemo1_war_exploded\WEB-INF\classes\spring\applicationContext-trans.xml]: Cannot resolve reference to bean 'dataSource' while setting bean property 'dataSource'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'dataSource' is defined
     ```

> 由于`spirng`是使用分离配置文件的方式进行搭建，所以需要在`web.xml`里面需要进行配置加载

```web.xml
       <!-- 配置spring -->
       <context-param>
           <param-name>contextConfigLocation</param-name>
           <param-value>classpath:spring/applicationContext-*.xml</param-value>
       </context-param>

       <!-- 配置监听器加载spirng-->
       <listener>
           <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
       </listener>
```

> 但是因为 `applicationContext-dao.xml` 在创建的时候，少了`.xml`
>
> 所以导致找不到`applicationContext-dao.xml`，最终引起`错误1`

 #### 2. 项目编写：实现页面查询条件初始化 

   + 错误2：在`com.giovani.crm.controller.CustomerController`层，无法注入`com.giovani.crm.service.BaseDictService` `2018年7月10日16:35:49`

        ```错误2
        严重: StandardWrapper.Throwable
        
         org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'customercom.giovani.crm.controller.CustomerController': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: private com.giovani.crm.service.com.giovani.crm.service.BaseDictService com.giovani.crm.com.giovani.crm.controller.CustomerController.Customercom.giovani.crm.controller.CustomerController.com.giovani.crm.service.BaseDictService; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.giovani.crm.service.com.giovani.crm.service.BaseDictService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
        
        ```

        > 由于 `@Autowired` 注解是根据类型注入，不是根据名称注入。所以他在找 `com.giovani.crm.service.BaseDictService` 的时候会根据他的类型，找到他的实现类进行注入

        > 但是因为 `com.giovani.crm.service.BaseDictService` 的实现类 `com.giovani.crm.service.impl.BaseDictServiceImpl` 没有加上 `@Service` 注解，导致 `com.giovani.crm.controller.CustomerController` 无法注入 `com.giovani.crm.service.BaseDictService` 从而引发 `错误2`

#### 3. 静态页面显示不正常
   + 错误3：加入静态资源(html/css/js)后，页面显示不正常
      ![Aaron Swartz](https://raw.githubusercontent.com/Giovani-Github/Giovani-resource/master/markdown-resource/2018-07-20_163507.png)



####  4.encodingFilter报错

需加入 `tomcat/lib/servlte-api.jar`

