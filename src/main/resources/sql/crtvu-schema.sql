SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


DROP DATABASE IF EXISTS crtvu;
CREATE DATABASE crtvu;
use crtvu;


-- ----------------------------
-- Table structure for courseType
-- ----------------------------
DROP TABLE IF EXISTS `courseType`;
CREATE TABLE `courseType` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(18) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for perms
-- ----------------------------
DROP TABLE IF EXISTS `perms`;
CREATE TABLE `perms` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `perms` varchar(12) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `role` varchar(8) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_perms
-- ----------------------------
DROP TABLE IF EXISTS `role_perms`;
CREATE TABLE `role_perms` (
                              `role_id` int NOT NULL,
                              `perms_id` int NOT NULL,
                              PRIMARY KEY (`role_id`,`perms_id`),
                              KEY `FK_PERMS` (`perms_id`),
                              CONSTRAINT `FK_PERMS` FOREIGN KEY (`perms_id`) REFERENCES `perms` (`id`),
                              CONSTRAINT `FK_ROLE_PERMS` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for techLevel
-- ----------------------------
DROP TABLE IF EXISTS `techLevel`;
CREATE TABLE `techLevel` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `level` varchar(12) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `uid` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(12) NOT NULL,
                        `password` varchar(20) NOT NULL DEFAULT '123456',
                        `name` varchar(8) NOT NULL,
                        `email` varchar(18) DEFAULT NULL,
                        `gender` varchar(2) DEFAULT '0',
                        `birth` date DEFAULT NULL,
                        `level_id` int DEFAULT NULL,
                        `dpt_id` int DEFAULT NULL,
                        `status` tinyint NOT NULL DEFAULT '1',
                        PRIMARY KEY (`uid`),
                        UNIQUE KEY `username` (`username`),
                        KEY `level_id` (`level_id`),
                        KEY `user_department_id_fk` (`dpt_id`),
                        CONSTRAINT `level_id` FOREIGN KEY (`level_id`) REFERENCES `techLevel` (`id`),
                        CONSTRAINT `user_department_id_fk` FOREIGN KEY (`dpt_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
                             `uid` int NOT NULL,
                             `role_id` int NOT NULL,
                             KEY `user_role_role_id_fk` (`role_id`),
                             KEY `user_role_user_uid_fk` (`uid`),
                             CONSTRAINT `user_role_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
                             CONSTRAINT `user_role_user_uid_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(16) NOT NULL,
                          `credit` float NOT NULL,
                          `hours` int DEFAULT NULL,
                          `status` tinyint(1) NOT NULL DEFAULT '0',
                          `type_id` int DEFAULT NULL,
                          `uid` int DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `uid` (`uid`),
                          KEY `type_id` (`type_id`),
                          KEY `course_name` (`name`) USING BTREE,
                          CONSTRAINT `course_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
                          CONSTRAINT `course_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `courseType` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '部门',
  `parent_id` int DEFAULT NULL COMMENT '上级部门编号',
  `name` varchar(20) NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `address` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `methods` int NOT NULL,
  `exam_date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exam_course_id_fk` (`course_id`),
  CONSTRAINT `exam_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for stu_course
-- ----------------------------
DROP TABLE IF EXISTS `stu_course`;
CREATE TABLE `stu_course` (
                              `uid` int NOT NULL,
                              `course_id` int NOT NULL,
                              `score` int DEFAULT NULL,
                              KEY `FK_USER` (`uid`),
                              KEY `FK_COURSE` (`course_id`),
                              CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
                              CONSTRAINT `FK_USER` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Function structure for getParentList
-- ----------------------------
#开启函数支持
set global log_bin_trust_function_creators=TRUE;

DROP FUNCTION IF EXISTS `getParentList`;
delimiter ;;
CREATE FUNCTION `crtvu`.`getParentList`(rootId varchar(100))
 RETURNS varchar(1000) CHARSET utf8 COLLATE utf8_bin
BEGIN
    DECLARE parentId varchar(100) default '';
    DECLARE str varchar(1000) default '';
    declare parentName varchar(100) default '';
    WHILE rootId is not null  do
            SET parentId =(SELECT parent_id FROM department WHERE id = rootId);
            SET parentName =(SELECT name FROM department WHERE id = rootId);
            IF parentId is not null THEN
                SET str = concat(parentName,' ',str);
                SET rootId = parentId;
            ELSE
                SET rootId = parentId;
            END IF;
        END WHILE;
    return str;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table course
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_stu_course_before_course`;
delimiter ;;
CREATE TRIGGER `delete_stu_course_before_course` BEFORE DELETE ON `course` FOR EACH ROW begin
    delete from stu_course where stu_course.course_id = OLD.id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table course
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_exam_before_course`;
delimiter ;;
CREATE TRIGGER `delete_exam_before_course` BEFORE DELETE ON `course` FOR EACH ROW begin
    delete from stu_course where course_id = OLD.id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_role_before_user`;
delimiter ;;
CREATE TRIGGER `delete_role_before_user` BEFORE DELETE ON `user` FOR EACH ROW begin
    delete from user_role where user_role.uid = OLD.uid;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
DROP TRIGGER IF EXISTS `add_role_after_user`;
delimiter ;;
CREATE TRIGGER `add_role_after_user` AFTER INSERT ON `user` FOR EACH ROW begin
            if (NEW.level_id is not NULL)then
                insert into user_role values (NEW.uid,2);
                else
                insert into user_role values (NEW.uid,1);
            end if;
           end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
