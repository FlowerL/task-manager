CREATE TABLE `sdk_user` (
`sdk_user_id`  int(11) NOT NULL AUTO_INCREMENT ,
`create_user_id`  int(11) NULL DEFAULT NULL ,
`app_key`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`app_secret`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT '0000-00-00 00:00:00' ,
`last_update_time`  datetime NULL DEFAULT '0000-00-00 00:00:00' ,
`expire_time`  datetime NULL DEFAULT '0000-00-00 00:00:00' ,
`valid`  tinyint(4) NULL DEFAULT 1 ,
PRIMARY KEY (`sdk_user_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
ROW_FORMAT=DYNAMIC
;