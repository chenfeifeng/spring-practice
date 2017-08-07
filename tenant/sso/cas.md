# 租户CAS单点登录客户端二次开发文档
---
* [目标](#目标)
* [技能要求](#技能要求)
* [步骤](#步骤)
* [具体操作](#具体操作)
  * [配置管理](#配置管理)
  * [下载工程](#下载工程)
  * [修改实现类](#修改实现类)
  * [工程打包以及引入租户](#工程打包以及引入租户)
* [其他说明](#其他说明)

---

# 目标
为了实现CAS单点功能。（在第三方产品登录的时候也进行租户的登录认证。）


# 技能要求
需要二次开发人员了解以下知识：  

1. 需要掌握CAS基本使用知识
2. 需要掌握JAVA的SPI开发的基本知识,[参考资料](http://kb.uyunsoft.cn/kb/pages/viewpage.action?pageId=27820857)。
3. 需要了解租户的用户添加（会提供默认实现类）


# 步骤
  
租户提供CAS接口类(uyun.bird.tenant.service.CASLoginOperService)，二次开发人员根据实际情况进行修改。

> 1. 在disconf的tenant.properties中添加配置文件 [详见具体操作](#配置管理)
> 2. 从git上下载租户单点登录样例工程 [详见具体操作](#下载工程)
> 3. 根据实际情况修改CASLoginOperService接口的实现类 [详见具体操作](#修改实现类)
> 4. 将修改后的工程打成jar包，引入租户。[详见具体操作](#工程打包以及引入租户)


# 具体操作

## 配置管理

**在disconf的tenant.properties文件中根据实际情况修改如下选项，如不存在，请新建：**

```
#单点登录选项（可选cas、ldap）tenant.sso.type=cas
#根据实际情况配置cas验证服务器地址casServerLoginUrl=https://testcas.com/cas/login#根据实际情况配置租户应用的域名和端口serverName=https://tenant.testcas.com:7600#根据实际情况配置CAS提供的 service ticket 或 proxy ticket 验证服务的 URLcasServerUrlPrefix=https://testcas.com/cas#根据实际情况配置单点登出地址casLogoutUrl=https://testcas.com/cas/logout
```

## 下载工程
二次开发人员需要通过从git下载样例工程，[git下载地址](https://git.uyunsoft.cn/earth/tenantsso.git)。  




## 修改实现类

1. 修改里面cas-impl模块下面的CASLoginOperServiceImpl.java代码，如有需要新建分支。  
2. 默认已提供一个实现类，开发人员需根据实际cas服务器返回的数据，修改getLoggedInUser方法的处理。  
   该方法功能是从cas服务器返回的HttpServletRequest请求包裹中，获取所需的用户信息，并封装成租户的用户类返回。 
3. 如果重新实现了接口，需要修改spi配置文件resources/META-INF /services/uyun.bird.tenant.service.CASLoginOperService文件，该文件内容为实现类的名称。 

**方法的实现可参考默认实现类(CASLoginOperService.java 和 CASLoginOperServiceImpl.java)。**  

**默认的实现类中有几处扩展和注释的代码，开发人员可根据情况修改。**  
该类内可能需要自行实现的需求：

1. 用户首次登陆部分信息同步到租户（根据CAS解析后的实际字段）。
2. 用户后续登陆更新租户这边的对应信息（根据CAS解析后的实际字段）。
3. 用户首次登陆时候添加产品权限（根据实际情况，ps：登陆租户手动添加产品权限还是默认的首次登陆赋予）。



## 工程打包以及引入租户

1. 将代码实现后的工程打成jar包。
2. **将jar包，拷入租户生产环境的/opt/tenantssolib目录下。**
3. 需要重新启动租户后生效。



# 其他说明

## CASLoginOperService接口说明
```
public void valiOrLoginWithCreateIfNone(HttpServletRequest request, HttpServletResponse response);说明：验证登录，如果是新用户同时将自动创建新用户
``````
public User getLoggedInUser (HttpServletRequest request);说明：解析CAS数据，返回用户登录查询的用户对象
```
```
public void insertNewUser(User casuser);说明：创建新用户（单点后发现租户数据库中不存在）
```
```
public void setUserLoggedInfo(User user, HttpServletRequest request, HttpServletResponse response);说明：设置用户登录状态
```

## JAVASPI
有关spi的概念与使用请参考KB:[JAVA SPI](http://kb.uyunsoft.cn/kb/pages/viewpage.action?pageId=27820857)


