# 参考链接
https://blog.csdn.net/m0_52861684/article/details/134341738
https://blog.csdn.net/qq_29519041/article/details/85238270

# DB script
```
CREATE DATABASE cloudDemo
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

  use cloudDemo;
  
CREATE TABLE USER (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(20) NOT NULL,
phone VARCHAR(15) NOT NULL,
address VARCHAR(50) NOT NULL
);

INSERT INTO USER VALUES (1, "栈老师不回家", 13299075426, "山西省大同市");
INSERT INTO USER(NAME, phone, address) VALUES ("肖恩", 18834267011, "山西省太原市");
INSERT INTO USER(NAME, phone, address) VALUES ("李华", 12481076533, "山西省运城市");

CREATE TABLE orders (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(30) NOT NULL,
price INT NOT NULL,
user_id INT NOT NULL REFERENCES USER(id)
);

INSERT INTO orders VALUES (1, "可乐鸡翅", 32, 1);
INSERT INTO orders(NAME, price, user_id) VALUES("冰镇啤酒", 12, 1);
INSERT INTO orders(NAME, price, user_id) VALUES("草莓冰激凌", 8, 2);
INSERT INTO orders(NAME, price, user_id) VALUES("狼牙土豆", 10, 3);
```