CREATE TABLE `task_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`create_time`  datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ,
`last_update_time`  datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '订单最新修改时间' ,
`user_info_id`  int(11) NOT NULL ,
`task_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time`  int(11) NULL DEFAULT NULL ,
`time_unit`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'todo' COMMENT '\"done\"——已完成；\"todo\"未完成' ,
PRIMARY KEY (`id`),
INDEX `user_info_id` (`user_info_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=8
ROW_FORMAT=DYNAMIC
;