CREATE TABLE t_patient (
   pk_patient_id int(11) NOT NULL AUTO_INCREMENT,
   blood_group varchar(45) DEFAULT NULL,
   weight int(11) DEFAULT NULL,
   is_active tinyint(4) DEFAULT 1,
   created_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   updated_date timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   fk_user_id int(11) NOT NULL,
   PRIMARY KEY (pk_patient_id),

   CONSTRAINT fk_t_patient_t_user_details1 FOREIGN KEY (fk_user_id) REFERENCES t_user_details (pk_user_id)
 ) ;