DROP DATABASE starry_blog;
CREATE DATABASE starry_blog;
use starry_blog;
DROP table if EXISTS account;
CREATE TABLE account(
  uid INTEGER PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(32) NOT NULL,
  password VARCHAR(64) NOT NULL,
  created_time DATETIME
) DEFAULT CHARSET = utf8;
DROP table if EXISTS urtable;
CREATE TABLE urtable(
  urid INTEGER PRIMARY KEY AUTO_INCREMENT,
  rid VARCHAR(16) NOT NULL,
  uid INTEGER NOT NULL
) DEFAULT CHARSET = utf8;
DROP table if EXISTS article_tag;
CREATE TABLE article_tag(
  tag_id INTEGER PRIMARY KEY,
  tag_name VARCHAR(32) NOT NULL
) DEFAULT CHARSET = utf8;
DROP table if EXISTS article;
CREATE TABLE article(
  article_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  article_content TEXT NOT NULL,
  article_created_time DATE NOT NULL,
  article_title VARCHAR(64) NOT NULL,
  article_thumbnail VARCHAR(64) NOT NULL
) DEFAULT CHARSET = utf8;
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
    realname,
    idnumber,
    unit,
    created_time
  )
VALUES(
    'stu01',
    'b6507d2be5757779818ba86862273d16e8ea7a7a046d30904c52f4b9b730154b',
    '张北京',
    '17010123456',
    '软件工程一班',
    '2017-08-01'
  );
INSERT INTO `account`(
    username,
    password,
    realname,
    idnumber,
    unit,
    created_time
  )
VALUES(
    'stu02',
    '053b11c9d0ee86203fcc28da5f23e4e1d6818ee2c6000e3fdb9bbef092b984a4',
    '张三',
    '17020223456',
    '软件工程一班',
    '2017-08-01'
  );
INSERT INTO `account`(
    username,
    password,
    realname,
    idnumber,
    unit,
    created_time
  )
VALUES(
    'stu03',
    '31011cd2bf17f9abf8a3b19d662137bc99e1ac51c5c8b0ce60f97fc1c43dee6c',
    '李随东',
    '11214674529',
    '计算机科学与技术一班',
    '2017-08-01'
  );
INSERT INTO `account`(
    username,
    password,
    realname,
    idnumber,
    unit,
    created_time
  )
VALUES(
    'stu04',
    '8d738688f173484726e4f1aa5c1f58aa5f45b5d214e436f1cf93141a88c171f9',
    '川建国',
    '11893265996',
    '网络工程一班',
    '2017-08-01'
  );
INSERT INTO `account`(
    username,
    password,
    realname,
    idnumber,
    unit,
    created_time
  )
VALUES(
    'stu05',
    'e42371d93cfd91e2b0e648fe3de4dfdc9a02882fd1123948334c7a4c8545f47c',
    '拜中华',
    '18205822893',
    '数字媒体与技术一班',
    '2017-08-01'
  );
INSERT INTO `account`(
    username,
    password,
    realname,
    idnumber,
    unit,
    created_time
  )
VALUES(
    'tea01',
    '441367e070dcfb8caccbb184c6738bf1dbd6b93eb4a70744134ca296560eae7f',
    '李四',
    '17030323456',
    '计算机学院',
    '2017-08-01'
  );
INSERT INTO `account`(
    username,
    password,
    realname,
    idnumber,
    unit,
    created_time
  )
VALUES(
    'tea02',
    '4b591a87990bd5b73c50c9928892b34d09447097a94a5a2a626bed121af1f8b8',
    '王5',
    '17040423456',
    '计算机学院',
    '2017-08-01'
  );
INSERT INTO `account`(
    username,
    password,
    realname,
    idnumber,
    unit,
    created_time
  )
VALUES(
    '123',
    'bd679681d237175686994fa05091c73701047610d48fd20a228bc4d348c608ee',
    '柯南',
    '18337876993',
    '计算机学院',
    '2017-08-01'
  );
INSERT INTO `urtable`(rid, uid)
VALUES('1', '1');
INSERT INTO `urtable`(rid, uid)
VALUES('1', '2');
INSERT INTO `urtable`(rid, uid)
VALUES('1', '3');
INSERT INTO `urtable`(rid, uid)
VALUES('1', '4');
INSERT INTO `urtable`(rid, uid)
VALUES('1', '5');
INSERT INTO `urtable`(rid, uid)
VALUES('2', '6');
INSERT INTO `urtable`(rid, uid)
VALUES('2', '7');
INSERT INTO `urtable`(rid, uid)
VALUES('2', '8');