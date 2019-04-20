# JwtDemo
# 项目说明
1. 首先在数据库中建立一个名为jwt的数据库
2. 该项目实现了JWT拦截功能，目标拦截地址可在JwtAuthenticationFilter的isProtectedUrl里面设置，可直接使用它来做基于SpringBoot的jwt拦截
3. 不在isProtectedUrl里的地址不做JWT拦截

# how to use
1. 在login的url中登录获取token
2. 在/api/路径下的接口做权限拦截，如未获取到Token则返回401
3. 发Http请求需要在请求体写json，header中装Token的key-value中的key是: Authorization
