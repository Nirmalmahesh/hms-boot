 CREATE TABLE t_role (
   pk_role_id int(11) NOT NULL AUTO_INCREMENT,
   role_name varchar(45) DEFAULT NULL,
   is_active tinyint(4) DEFAULT 1,
   created_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   updated_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (pk_role_id)
 ) ;