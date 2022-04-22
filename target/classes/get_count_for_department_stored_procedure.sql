DELIMITER $$
DROP PROCEDURE IF EXISTS `get_count_for_department`$$
CREATE  PROCEDURE `get_count_for_department`(IN the_department VARCHAR(64),OUT the_count INT)
BEGIN
   select count(*) INTO the_count  from employees where department=the_department;
   
END$$
DELIMITER ;