## logging-manager-ui配置

默认加载日志ui，启动应用后，可通过访问如下地址访问在线日志管理

    http://{host}:{ip}/q/logging-manager-ui/

开启api接口

    ## Logger Manager API
    quarkus.logging-manager.openapi.included=true

配置访问角色（前提是要配置相应角色）

    quarkus.http.auth.policy.admin-access.roles-allowed=admin
    quarkus.http.auth.permission.roles1.paths=/loggers
    quarkus.http.auth.permission.roles1.policy=admin-access