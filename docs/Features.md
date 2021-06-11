# Features

项目功能需求说明文档

## 文章主体 Article

### 功能需求

- 数据
  - [ ] 发布日期 created_time
  - [ ] 编辑日期 edit_time
  - [ ] 文章标题 article_title
  - [ ] 文章内容 article_md `markdown格式`
  - [ ] 文章头图 article_thumbnail `url`
  - [ ] 文章标签 article_tags `详见下方说明`

- 功能
  - [ ] 文章编辑
  - [ ] 文章评论
  - [ ] 文章点击量
  - [ ] 文章点击量过了多少阀值(可配置)可收到邮件通知⏰
  - [ ] 文章收到评论可收到邮件通知

### 详细说明

- 数据
  - 文章标签：一个文章可以包含1-5个不同的标签 (default 未归档)，需要一个接口查询所有的标签以及标签下面的文章数量
  - 文章内容：采用markdown格式，数据库存raw markdown，交由前端进行解析，榨取客户端的算力（
  - 文章头图：文章头图格式只支持png或者jpeg格式，尺寸啥的就给前端那边做指定吧。
  - 发布日期：标准unix时间戳
  - 编辑日期：标准unix时间戳
- 功能
  - 文章编辑：文章支持编辑，显示最后编辑日期
  - 文章评论：暂定

## 文章列表

### 功能需求

- 数据 (list)
  - [ ] 标题 article_title
  - [ ] 发布日期 created_time
  - [ ] 头图 article_thumbnail
  - [ ] 文章概要 article_summary
  - [ ] 文章标签 article_tags

- 功能
  - [ ] 文章查询

### 详细说明

- 数据
  - 文章概要：暂定为文章内容的前50个字符

- 功能
  - 文章查询：查询范围为标题和文章内容
