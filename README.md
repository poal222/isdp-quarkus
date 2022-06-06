# Isdp cloud 开发框架 


本开发框架不追求大而全，只追求好用能用，全面拥抱quarkus项目<https://quarkus.io/> 

## 项目结构
    -----core 核心包，主要是存储变量等内容
    -----common 暂时没用
    -----file 提供文件上传下载功能
    -----web-reactive 拥抱反应式编程，提供基础的CRUD操作模式
    -----eip 企业信息平台，提供安全、机构、区域等最基础的功能

## 短期目标
    1、activeRecord模式
    2、eip 租户设计
    3、eip组织机构设计
    4、eip员工、岗位、组织、用户关系
    5、提供员工入职，离职，离岗，调岗等关键流程设计
    7、提供前端UI
    8、提供定时任务