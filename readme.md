

**产品介绍**

1. **起因**

走上开发道路已经有段年头了,一直以来,遇到问题,总是做伸手党,非常感谢广大码友的无私奉献,能够让我们在遇到问题时,能找到解决的方法.每人都奉献一点,码农幸福一点.

某些原因,我要在家待上二年,正好把我上班期间的所学和思考予以实现,奉献出来,做个引子,欢迎大家指导,讨论.本框架99%由我个人完成,每行代都手工敲出来,完全开源,欢迎码友们提意见,不断完善此框架,讨论组QQ群号：点击链接加入群聊【一起讨论--熬烈】：https://jq.qq.com/?_wv=1027&k=m7WCvDJr

2. **这是什么:**

最终的目标是一个低代码框架,当然现在离目标还有点距离,近期目标,干私活框架.

目前它可以作为后台管理系统的基础框架.已实现的内容包括:菜单管理,角色管理,组织管理,权限管理,人员管理,流程管理, 方案设计,界面设计,查询设计,首页等功能.但这些功能并不是我分享的重点,重点是设计这些功能的思想,能不能走得通,走得远,想和码友们讨论.

希望通过后期插件模块的不断积累，使此框架不断加强，完善，丰富。

3. **特点:**

- 基于数据模型
- 前后端联动
- 界面到功能全设计
- 插件(模块)式开发
- 更适合后端人员开发的前端开发方式
4. **简单功能生成:**

   简单数据的增、删、改、查、联动，可以通过下步骤完成。

   a:  数据库中建立表结构

   b: 方案管理中引用此表,设置约束,公式及表间关系

   c:  设计界面

   d: 设计页面

   e: 增加菜单及按钮

   g: 授权

5. **注意事项:**

正是由于此为个人作品,所以在考虑应用到私活时,要慎重,因为我没有时间对些框架做详细的测试.如果有机会的话,我会以此框架来做几个私活,再稳定和完善一下此框架.

6. **模块说明**
系统分为前后端二大类，前端模块都带有front的后缀，后缀前面的和后端模块基本是对应的.除核心外,其它功能都以插件化的形式开发,只需要依赖核心模块.
> aolie_core,aolie_front 为核心模块
> aolie_wf,aolie_wf_front 工作流插件，基于flowable6.5.0,并简单集成了流程编辑器
> aolie_monitor,aolie_monitor_front 系统监控插件， 监控系统状态，并显示图形化信息
> aolie_query,aolie_query_front 综合查询插件. 基于数据模型的设计,从不同维度展现数据.
> aolie_backapp,aolie_frontapp 集成模块.并没有逻辑,只是将使用的模块集成为一个工程,以发布.

7. **快速开始**
   

**开发方式:**
 >>
   后端：
   - 恢复数据库（数据库文件由Mysql 的mysqldump命令导出）。
   - 下载依赖的工程，注意上述的依赖关系。修改最外层的工程文件 aolie.propertis 配置数据库连接。
   - Maven install到本地仓库。
   - 启动springboot.
   >>
   前端：
   - 需要搭建一个包管理私服，推荐使用verdaccio。使用方法请百度。
   - 下载依赖的工程，被依赖的工程需要先发布到私服上.
   - 如果后端的端口不是http://localhost:8080 ，则需要修改配置文件 config.json，指定后端的服务地址。
  
**部署方式：**
  - 下载本工程的三个文件。后端包：app-0.0.1-SNAPSHOT-exec.jar，前端包：front.zip，数据库文件：dbback.zip（数据库文件由Mysql 的mysqldump命令导出）;
  - 后端包直接运行 java -jar app-0.0.1-SNAPSHOT-exec.jar;
  - 前端包，可以放入窗口中运行，如tomcat。
  如果后端不是在端口8080上，请修改前端的配置文件config.json
  
  
  ```管理员用户/密码：admin/1```
  
  **界面预览**
首页
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/home.png)
方案设计
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/schema.png)
界面设计
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/uidesign.png)
页面设计
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/pagedesign.png)
权限管理
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/right.png)
菜单管理
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/menu.png)
报表定义
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/querydesign.png)
报表查询
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/query.png)
流程定义
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/flowable.png)
三表联动
![Image text](https://github.com/blueskylong/aolie_illustrate/blob/master/images/demo.png)
