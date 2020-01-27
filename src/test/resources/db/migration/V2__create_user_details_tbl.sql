CREATE TABLE `t_user_details` (
   pk_user_id int(11) NOT NULL AUTO_INCREMENT,
   username varchar(45) NOT NULL,
   password varchar(45) NOT NULL,
   firstname varchar(45) DEFAULT NULL,
   lastname varchar(45) DEFAULT NULL,
   is_active tinyint(4) DEFAULT 1,
   created_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   updated_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   fk_role_id int(11) NOT NULL,
   city varchar(45) DEFAULT NULL,
   state varchar(45) DEFAULT NULL,
   phone_number varchar(45) DEFAULT NULL,
   PRIMARY KEY (pk_user_id),
   UNIQUE KEY username_UNIQUE (username),

   CONSTRAINT fk_t_user_details_t_role_tbl FOREIGN KEY (fk_role_id) REFERENCES t_role (pk_role_id)
 ) ;