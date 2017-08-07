# 租户LDAP登录客户端二次开发文档
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
  * [CASLoginOperService接口说明](#CASLoginOperService接口说明)
  * [JAVA SPI说明](#JAVA SPI说明)

---

# 目标
以ldap信息登录租户，并且将数据同步到租户。

# <span id="2"/>技能要求
需要二次开发人员了解以下知识：  

1. 需要掌握JAVA的SPI开发的基本知识，[参考资料](#5.2)。
2. 需要了解租户的用户添加（会提供默认实现类）。


# <span id="3"/>步骤
  
租户提供LDAP接口类(uyun.bird.tenant.service.LDAPLoginOperService)，二次开发人员根据实际情况进行修改。

> 1. 在disconf的tenant.properties中添加配置文件 [详见具体操作](#4.1)
> 2. 从git上下载租户单点登录样例工程 [详见具体操作](#4.2)
> 3. 根据实际情况修改CASLoginOperService接口的实现类 [详见具体操作](#4.3)
> 4. 将修改后的工程打成jar包，引入租户。[详见具体操作](#4.4)


# <span id="4"/>具体操作

## <span id="4.1"/>配置管理

**在disconf的tenant.properties文件中根据实际情况修改如下选项，如不存在，请新建：**

```
#单点登录选项（ldap、cas）tenant.sso.type=ldap#ldap的连接地址LDAPUrl=LDAP://10.1.241.92:389/ # Base DN根节点LDAPBasedn=dc=mydomain,dc=org#域、组织LDAPDomain=ou=people
```

## <span id="4.2"/>下载工程
二次开发人员需要通过从git下载样例工程，[git下载地址](https://git.uyunsoft.cn/earth/tenantsso.git)。  




## <span id="4.3"/>修改实现类

1. 修改里面ldap-impl模块下面的LDAPLoginOperServiceImpl.java代码，如有需要新建分支。  
2. 默认已提供一个实现类，二次开发人员需根据实际的ldap用户信息验证，修改ldapValidation方法，方法具体功能如下:  
   + 根据登录接口传入的用户账号和密码去ldap库验证是否有效
   + ldap库中获取用户的其他必要信息，并封装成租户的用户类返回其它方法的实现可参考默认实现类。
3. 如果重新实现了接口，需要修改spi配置文件resources/META-INF /services/uyun.bird.tenant.service.LDAPLoginOperService文件，该文件内容为实现类的名称。 

**<font size=3 color='red' face="黑体">方法的实现可参考默认实现类(LDAPLoginOperService.java 和 LDAPLoginOperServiceImpl.java)</font>。**  
<font size=3 color='red' face="黑体">
该类内可能需要自行实现的需求：
> 1. **默认的实现类中有几处扩展和注释的代码，开发人员可根据情况修改。**  
> 2. **由于三方账号的密码的加密方式,所以租户这边ldap登录的时候是以明文形式提交的,需要工程根据现场情况,进行加密处理**

</font>

## <span id="4.4"/>工程打包以及引入租户

1. 将代码实现后的工程打成jar包。
2. **将jar包，拷入租户生产环境的<font size=4 color='red' face="黑体"> /opt/tenantssolib </font>目录下。**
3. 需要重新启动租户后生效。



# <span id="5"/>其他说明

## <span id="5.1"/> LDAPLoginOperService接口说明
```
public User getSignInUser(Login login);说明：从LDAP验证获取的用户实现类，因仅仅包含最简单必要的参数，这里需要补全一下其他的参数（可以参考默认实现类）
```
```
public User ldapValidation(String userName, String password);
说明：验证LDAP用户数据，如果验证成功，则返回用户登录查询的用户对象，否则返回null
```

```
public void insertNewUser(User user);说明：创建新用户（LDAP验证成功后发现租户数据库中不存在）
```

## <span id="5.2"/>JAVA SPI说明
有关spi的概念与使用请参考KB:[JAVA SPI](http://kb.uyunsoft.cn/kb/pages/viewpage.action?pageId=27820857)


