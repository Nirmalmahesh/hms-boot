CREATE TABLE `t_record` (
   `pk_patient_doctor_id` int(11) NOT NULL AUTO_INCREMENT,
   `is_active` tinyint(4) DEFAULT 1,
   `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `fk_patient_id` int(11) NOT NULL,
   `fk_doctor_id` int(11) NOT NULL,
   `desease` varchar(45) DEFAULT NULL,
   PRIMARY KEY (`pk_patient_doctor_id`),
   CONSTRAINT `fk_t_patient_doctor_mapping_t_doctor1` FOREIGN KEY (`fk_doctor_id`) REFERENCES `t_doctor` (`pk_doctor_id`),
   CONSTRAINT `fk_t_patient_doctor_mapping_t_patient1` FOREIGN KEY (`fk_patient_id`) REFERENCES `t_patient` (`pk_patient_id`)
 ) ;