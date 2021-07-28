## 插件开发

这里所谓的插件，可以表述为可插拔的模块，就是在模块的基础增加一些插件管理，增加功能，不影响现有功能。理想的情况下，希望使用者，开发一些通用的模块，贡献出来，与大家共享，形成一个小生态。这也是此框架是否能生存下去的重要方面。
插件需要实现IPlug接口，并须要通过@Plug注册：
```java
/**
    * @author xxl
    * 插件接口
    * @version V1.0
    * @date 2021/7/6 13:28
    **/
   public interface IPlus {
       /**
        * 取得插件信息
        *
        * @return
        */
       PlugDto getPlugInfo();
   
       /**
        * 安装
        *
        * @return
        */
       boolean install();
   
       /**
        * 卸载
        *
        * @return
        */
       boolean uninstall();
   
       /**
        * 升级
        *
        * @return
        */
       boolean update();
   
       /**
        * 最新版本
        *
        * @return
        */
       String getNewVersion();
   
       /**
        * 检查当前系统配置问题
        *
        * @return
        */
       String check();
   
       /**
        * 修复
        *
        * @return
        */
       String repair();
   
       /**
        * 更新插件状态,如启用和停用
        */
       void updatePlug();
   
   }
```
插件自身需要提供安装，卸载，更新，修复等能力。
系统中目前以插件的形式开发三个模块：流程管理、综合查询、系统运行监控。
> 由于时间问题，这些插件的安装和卸载脚本还没有制作

### 一、 流程管理
工作流程管理，基于flowable6.5.0开发，增加了流程管理，业务表对流程二个功能，另外，在受流程管理的表格上，增加了流程状态列。

因为考虑到独立性，所以流程的信息，并不是保存在业务表里，而是单独创建一张流程审核表，记录业务表中数据行与流程的关系。

增加了流程管理，也相当于一种权限的管理，这里通过增加数据操作的拦截器，实现流程权限的过滤，是否可以操作的判断。


1. 流程管理
流程管理包括了流程的增加，编辑，查看，部署。系统集成了flowable的前端维护工程flowable-ui-modeler，为了使用方便，将流程编辑界面整合到对话框中。修改流程中的用户和角色的数据来源。
![流程管理](https://github.com/blueskylong/aolie_illustrate/blob/master/images/wf/wfManage.png)
![流程编辑](https://github.com/blueskylong/aolie_illustrate/blob/master/images/wf/edit.png)
2. 业务表对流程
此功能的目的是，将数据表与业务流程挂钩，以确定业务需要走的流程。业务表来自方案里的数据表。一张表最多只能挂接一个流程。
![业务表对流程](https://github.com/blueskylong/aolie_illustrate/blob/master/images/wf/totable.png)
3. 增加前端流程状态的显示。
此功能是通过查询表格对应的数据表，是否挂接过流程的方式来确定，是否增加流程状态虚拟列。包含自动查询数据时，是否拼接流程状态的数据。为表格增加提交，退回，查看流程操作的支持。
![流程查看](https://github.com/blueskylong/aolie_illustrate/blob/master/images/wf/view.png)

### 二、综合查询
综合查询，是一个定义查询表的功能，充分利用了模型定义的便利。综合查询可以快速定义针对一数据表的明细查询，分组汇总查询和自动扩展查询。

在数据表中，列分为二类，一类是设置了“引用”的枚举列，一类是普通列可以作为度量列，其中枚举列可以作为表格的横向扩展和纵向扩展的要素，枚举和度量列都可以作为最终的统计数值。

如下的数据表：

城市，级别和行业都是枚举列,我们将城市、级别作为纵向扩展，其中城市在前，级别一后，将行业作为横向扩展，行业下统计数据1的和。另外，还增加了明细和明细1列，用于显示明细信息时的补充列。
查询出的数据展示如下：
![流程查看](https://github.com/blueskylong/aolie_illustrate/blob/master/images/query/result.png)

可以为查询添加一个过滤条件表单，即在界面设计器中，生成一个此数据表的表单，在查询设计中，关联此表单即可，查询时，表格上部会出现表单供用户输入。


### 三、系统运行监控
运行监控是通过增加拦截器，收集系统的运行资料。增加了一张用于记录运行日志的表。由于记录操作时，可能数据量会比较大，所以采用了线程池来进行保存的任务，采用spring的计划任务，定时收集在线人数情况。
运行监控的数据，应用在系统的首页上，系统首页的组织形式是分块插槽式的，本模块，将不同的采集数据，生成Echarts图表注册到首页的插槽里。
首页运行如下图：
![流程查看](https://github.com/blueskylong/aolie_illustrate/blob/master/images/home.png)


插件开发是这个框架的生命线，只有框架是远远不够的，需要集合大家的力量，开发、贡献通用的插件，才是这个开源项目生命的源泉。








