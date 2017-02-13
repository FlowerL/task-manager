CREATE TABLE `user_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`create_time`  datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ,
`last_update_time`  datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '订单最新修改时间' ,
`username`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2
ROW_FORMAT=DYNAMIC
;