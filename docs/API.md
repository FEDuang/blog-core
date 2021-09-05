# API Reference

za102博客项目的API文档。用于前后端对接。

## 博客管理后台 blog-admin

### 账号 Account

#### 登录 login

```http
    POST /api/account/login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `account` | `string` | **必填**.  用户名 |
| `password` | `string` | **必填**.  密码 |

#### 注销 logout

```http
    POST /api/account/logout
```

| Parameter | Type     | Description       |
| :-------- | :------- | :---------------- |
| `account` | `string` | **必填**.  用户名 |

#### add(num1, num2)

  Takes two numbers and returns the sum.

