DROP DATABASE za_blog;
CREATE DATABASE za_blog;
use za_blog;

DROP table if EXISTS account;
CREATE TABLE account(
                        uid INTEGER PRIMARY KEY AUTO_INCREMENT,
                        username VARCHAR(32) NOT NULL,
                        password VARCHAR(64) NOT NULL,
                        created_time DATETIME
) ;

DROP table if EXISTS urtable;
CREATE TABLE urtable(
                        urid INTEGER PRIMARY KEY AUTO_INCREMENT,
                        rid VARCHAR(16) NOT NULL,
                        uid INTEGER NOT NULL
);

DROP table if EXISTS article;
CREATE TABLE article(
                        article_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                        article_content TEXT NOT NULL,
                        article_created_time DATE NOT NULL,
                        article_title VARCHAR(64) NOT NULL,
                        article_thumbnail VARCHAR(64) NOT NULL
) ;

DROP table if EXISTS ArticleTag;
CREATE TABLE ArticleTag(
                           tag_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                           tag_name VARCHAR(32) NOT NULL
) ;

DROP table if EXISTS article_tag_group;
CREATE TABLE article_tag_group(
                                  id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                  article_id INTEGER NOT NULL,
                                  tag_id INTEGER NOT NULL,
                                  FOREIGN KEY (article_id) REFERENCES article (article_id),
                                  FOREIGN KEY (tag_id) REFERENCES article_tag(tag_id)
) DEFAULT CHARSET = utf8;

-- 账户角色添加
INSERT INTO `account`(
    username,
    password,
    created_time
)
VALUES(
          'admin',
          '9652db973cb687482dc069124ef78b505ea4aac0108c3fff606e317588401e71',
          '2021-06-12'
      );

INSERT INTO `account`(
    username,
    password,
    created_time
)
VALUES(
          'root',
          '643a936718fc9b2d3de7dbbf31e2024d5b06d565d299c9a34e42bc57e1425284',
          '2021-06-12'
      );

INSERT INTO `urtable`(uid, rid)
VALUES(1, 'admin');
INSERT INTO `urtable`(uid, rid)
VALUES(2, 'admin');
