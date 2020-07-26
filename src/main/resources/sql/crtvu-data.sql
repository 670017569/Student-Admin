

use crtvu;
-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES (2, 'Java程序设计', 2, 38, 1, 1, 3);
INSERT INTO `course` VALUES (3, '编译原理', 2, 28, 1, 1, 3);
INSERT INTO `course` VALUES (21, '数据结构与算法', 2, 48, 1, 2, 3);
INSERT INTO `course` VALUES (27, 'Java程序设计', 2, 58, 1, 2, 4);
INSERT INTO `course` VALUES (29, '线性代数', 3, 48, 1, 1, 3);
COMMIT;

-- ----------------------------
-- Records of techLevel
-- ----------------------------
BEGIN;
INSERT INTO `techLevel` VALUES (1, '教授');
INSERT INTO `techLevel` VALUES (2, '副教授');
INSERT INTO `techLevel` VALUES (3, '讲师');
INSERT INTO `techLevel` VALUES (4, '助教');
INSERT INTO `techLevel` VALUES (5, '高级教师');
COMMIT;


-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin', '123456', '陈曦', NULL, '1', '2020-07-12', 3, NULL, 1);
INSERT INTO `user` VALUES (2, 'root', '123456', '何璐斌', NULL, '0', '2020-07-12', 2, NULL, 1);
INSERT INTO `user` VALUES (3, '100001', '123456', '黄媛媛', NULL, '1', '2020-07-12', 3, NULL, 1);
INSERT INTO `user` VALUES (4, '100002', '123456', '汤强', NULL, '1', '2020-07-12', 3, NULL, 1);
INSERT INTO `user` VALUES (11, '201633090121', '123456', '周功浩', '615312153@qq.com', '1', '2020-07-12', NULL, 112, 1);
INSERT INTO `user` VALUES (12, '201633090122', '123456', '王云泽', '615312153@qq.com', '0', '2020-07-12', NULL, 32, 1);
INSERT INTO `user` VALUES (13, '201633090123', '123456', '周功浩', '67025615@qq.com', '1', '1970-01-01', NULL, 31, 1);
INSERT INTO `user` VALUES (22, '201633090124', '123456', '周浩', '615312153@qq.com', '1', '2020-07-12', NULL, 31, 1);
INSERT INTO `user` VALUES (29, '201633090125', '123456', '王云泽', '65461231@qq.com', '1', '2020-07-03', NULL, 31, 1);
INSERT INTO `user` VALUES (39, '201633090130', '123456', '周浩', '12365123@qq.com', '0', '1997-06-04', NULL, 33, 1);
INSERT INTO `user` VALUES (40, '201633090131', '123456', '张三', '12365123@qq.com', '1', '2020-07-03', NULL, 31, 1);
INSERT INTO `user` VALUES (42, '201633090132', '123456', '张三', '12365123@qq.com', '1', '2020-07-09', NULL, 31, 1);
INSERT INTO `user` VALUES (44, '100003', '123456', '王五', NULL, '1', '2020-07-02', 2, NULL, 1);
INSERT INTO `user` VALUES (47, '201633090135', '456123', '张三', '12365123@qq.com', '1', '2020-07-10', NULL, 31, 1);
INSERT INTO `user` VALUES (49, '100004', '123456', '张三', NULL, '1', '2020-07-09', 1, NULL, 1);
COMMIT;


-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (1, 3);
INSERT INTO `user_role` VALUES (2, 3);
INSERT INTO `user_role` VALUES (3, 2);
INSERT INTO `user_role` VALUES (4, 2);
INSERT INTO `user_role` VALUES (11, 1);
INSERT INTO `user_role` VALUES (12, 1);
INSERT INTO `user_role` VALUES (13, 1);
INSERT INTO `user_role` VALUES (22, 1);
INSERT INTO `user_role` VALUES (29, 1);
INSERT INTO `user_role` VALUES (39, 1);
INSERT INTO `user_role` VALUES (40, 1);
INSERT INTO `user_role` VALUES (42, 1);
INSERT INTO `user_role` VALUES (44, 2);
INSERT INTO `user_role` VALUES (47, 1);
INSERT INTO `user_role` VALUES (49, 2);
COMMIT;
-- ----------------------------
-- Records of courseType
-- ----------------------------
BEGIN;
INSERT INTO `courseType` VALUES (1, '必修课');
INSERT INTO `courseType` VALUES (2, '选修课');
INSERT INTO `courseType` VALUES (3, '公共选修课');
COMMIT;


-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (13, 0, '计算机与通信工程学院');
INSERT INTO `department` VALUES (14, 0, '水利工程学院');
INSERT INTO `department` VALUES (15, 0, '电气工程学院');
INSERT INTO `department` VALUES (16, 0, '设计与艺术学院');
INSERT INTO `department` VALUES (17, 0, '外国语学院');
INSERT INTO `department` VALUES (18, 0, '交通学院');
INSERT INTO `department` VALUES (19, 0, '土木工程学院');
INSERT INTO `department` VALUES (20, 0, '数学与统计学院');
INSERT INTO `department` VALUES (21, 13, '软件工程');
INSERT INTO `department` VALUES (22, 13, '网络工程');
INSERT INTO `department` VALUES (23, 13, '计算机科学与技术');
INSERT INTO `department` VALUES (24, 13, '大数据');
INSERT INTO `department` VALUES (25, 13, '通信工程');
INSERT INTO `department` VALUES (26, 14, '海岸工程');
INSERT INTO `department` VALUES (27, 14, '水利水电工程');
INSERT INTO `department` VALUES (28, 14, '水文与水资源工程');
INSERT INTO `department` VALUES (29, 14, '给排水科学与工程');
INSERT INTO `department` VALUES (30, 14, '船舶与海洋工程');
INSERT INTO `department` VALUES (31, 21, '1601');
INSERT INTO `department` VALUES (32, 21, '1602');
INSERT INTO `department` VALUES (33, 21, '1603');
INSERT INTO `department` VALUES (34, 21, '1604');
INSERT INTO `department` VALUES (35, 21, '1701');
INSERT INTO `department` VALUES (36, 21, '1702');
INSERT INTO `department` VALUES (37, 21, '1703');
INSERT INTO `department` VALUES (38, 21, '1704');
INSERT INTO `department` VALUES (39, 21, '1801');
INSERT INTO `department` VALUES (40, 21, '1802');
INSERT INTO `department` VALUES (41, 21, '1803');
INSERT INTO `department` VALUES (42, 21, '1804');
INSERT INTO `department` VALUES (43, 21, '1901');
INSERT INTO `department` VALUES (44, 21, '1902');
INSERT INTO `department` VALUES (45, 21, '1903');
INSERT INTO `department` VALUES (46, 21, '1904');
INSERT INTO `department` VALUES (48, 22, '1601');
INSERT INTO `department` VALUES (49, 22, '1602');
INSERT INTO `department` VALUES (50, 22, '1603');
INSERT INTO `department` VALUES (51, 22, '1604');
INSERT INTO `department` VALUES (52, 22, '1701');
INSERT INTO `department` VALUES (53, 22, '1702');
INSERT INTO `department` VALUES (54, 22, '1703');
INSERT INTO `department` VALUES (55, 22, '1704');
INSERT INTO `department` VALUES (56, 22, '1801');
INSERT INTO `department` VALUES (57, 22, '1802');
INSERT INTO `department` VALUES (58, 22, '1803');
INSERT INTO `department` VALUES (59, 22, '1804');
INSERT INTO `department` VALUES (60, 22, '1901');
INSERT INTO `department` VALUES (61, 22, '1902');
INSERT INTO `department` VALUES (62, 22, '1903');
INSERT INTO `department` VALUES (63, 22, '1904');
INSERT INTO `department` VALUES (64, 23, '1601');
INSERT INTO `department` VALUES (65, 23, '1602');
INSERT INTO `department` VALUES (66, 23, '1603');
INSERT INTO `department` VALUES (67, 23, '1604');
INSERT INTO `department` VALUES (68, 23, '1701');
INSERT INTO `department` VALUES (69, 23, '1702');
INSERT INTO `department` VALUES (70, 23, '1703');
INSERT INTO `department` VALUES (71, 23, '1704');
INSERT INTO `department` VALUES (72, 23, '1801');
INSERT INTO `department` VALUES (73, 23, '1802');
INSERT INTO `department` VALUES (74, 23, '1803');
INSERT INTO `department` VALUES (75, 23, '1804');
INSERT INTO `department` VALUES (76, 23, '1901');
INSERT INTO `department` VALUES (77, 23, '1902');
INSERT INTO `department` VALUES (78, 23, '1903');
INSERT INTO `department` VALUES (79, 23, '1904');
INSERT INTO `department` VALUES (80, 24, '1601');
INSERT INTO `department` VALUES (81, 24, '1602');
INSERT INTO `department` VALUES (82, 24, '1603');
INSERT INTO `department` VALUES (83, 24, '1604');
INSERT INTO `department` VALUES (84, 24, '1701');
INSERT INTO `department` VALUES (85, 24, '1702');
INSERT INTO `department` VALUES (86, 24, '1703');
INSERT INTO `department` VALUES (87, 24, '1704');
INSERT INTO `department` VALUES (88, 24, '1801');
INSERT INTO `department` VALUES (89, 24, '1802');
INSERT INTO `department` VALUES (90, 24, '1803');
INSERT INTO `department` VALUES (91, 24, '1804');
INSERT INTO `department` VALUES (92, 24, '1901');
INSERT INTO `department` VALUES (93, 24, '1902');
INSERT INTO `department` VALUES (94, 24, '1903');
INSERT INTO `department` VALUES (95, 24, '1904');
INSERT INTO `department` VALUES (96, 25, '1601');
INSERT INTO `department` VALUES (97, 25, '1602');
INSERT INTO `department` VALUES (98, 25, '1603');
INSERT INTO `department` VALUES (99, 25, '1604');
INSERT INTO `department` VALUES (100, 25, '1701');
INSERT INTO `department` VALUES (101, 25, '1702');
INSERT INTO `department` VALUES (102, 25, '1703');
INSERT INTO `department` VALUES (103, 25, '1704');
INSERT INTO `department` VALUES (104, 25, '1801');
INSERT INTO `department` VALUES (105, 25, '1802');
INSERT INTO `department` VALUES (106, 25, '1803');
INSERT INTO `department` VALUES (107, 25, '1804');
INSERT INTO `department` VALUES (108, 25, '1901');
INSERT INTO `department` VALUES (109, 25, '1902');
INSERT INTO `department` VALUES (110, 25, '1903');
INSERT INTO `department` VALUES (111, 25, '1904');
INSERT INTO `department` VALUES (112, 26, '1601');
INSERT INTO `department` VALUES (113, 26, '1602');
INSERT INTO `department` VALUES (114, 26, '1603');
INSERT INTO `department` VALUES (115, 26, '1604');
INSERT INTO `department` VALUES (116, 26, '1701');
INSERT INTO `department` VALUES (117, 26, '1702');
INSERT INTO `department` VALUES (118, 26, '1703');
INSERT INTO `department` VALUES (119, 26, '1704');
INSERT INTO `department` VALUES (120, 26, '1801');
INSERT INTO `department` VALUES (121, 26, '1802');
INSERT INTO `department` VALUES (122, 26, '1803');
INSERT INTO `department` VALUES (123, 26, '1804');
INSERT INTO `department` VALUES (124, 26, '1901');
INSERT INTO `department` VALUES (125, 26, '1902');
INSERT INTO `department` VALUES (126, 26, '1903');
INSERT INTO `department` VALUES (127, 26, '1904');
INSERT INTO `department` VALUES (128, 27, '1601');
INSERT INTO `department` VALUES (129, 27, '1602');
INSERT INTO `department` VALUES (130, 27, '1603');
INSERT INTO `department` VALUES (131, 27, '1604');
INSERT INTO `department` VALUES (132, 27, '1701');
INSERT INTO `department` VALUES (133, 27, '1702');
INSERT INTO `department` VALUES (134, 27, '1703');
INSERT INTO `department` VALUES (135, 27, '1704');
INSERT INTO `department` VALUES (136, 27, '1801');
INSERT INTO `department` VALUES (137, 27, '1802');
INSERT INTO `department` VALUES (138, 27, '1803');
INSERT INTO `department` VALUES (139, 27, '1804');
INSERT INTO `department` VALUES (140, 27, '1901');
INSERT INTO `department` VALUES (141, 27, '1902');
INSERT INTO `department` VALUES (142, 27, '1903');
INSERT INTO `department` VALUES (143, 27, '1904');
INSERT INTO `department` VALUES (144, 28, '1601');
INSERT INTO `department` VALUES (145, 28, '1602');
INSERT INTO `department` VALUES (146, 28, '1603');
INSERT INTO `department` VALUES (147, 28, '1604');
INSERT INTO `department` VALUES (148, 28, '1701');
INSERT INTO `department` VALUES (149, 28, '1702');
INSERT INTO `department` VALUES (150, 28, '1703');
INSERT INTO `department` VALUES (151, 28, '1704');
INSERT INTO `department` VALUES (152, 28, '1801');
INSERT INTO `department` VALUES (153, 28, '1802');
INSERT INTO `department` VALUES (154, 28, '1803');
INSERT INTO `department` VALUES (155, 28, '1804');
INSERT INTO `department` VALUES (156, 28, '1901');
INSERT INTO `department` VALUES (157, 28, '1902');
INSERT INTO `department` VALUES (158, 28, '1903');
INSERT INTO `department` VALUES (159, 28, '1904');
INSERT INTO `department` VALUES (160, 29, '1601');
INSERT INTO `department` VALUES (161, 29, '1602');
INSERT INTO `department` VALUES (162, 29, '1603');
INSERT INTO `department` VALUES (163, 29, '1604');
INSERT INTO `department` VALUES (164, 29, '1701');
INSERT INTO `department` VALUES (165, 29, '1702');
INSERT INTO `department` VALUES (166, 29, '1703');
INSERT INTO `department` VALUES (167, 29, '1704');
INSERT INTO `department` VALUES (168, 29, '1801');
INSERT INTO `department` VALUES (169, 29, '1802');
INSERT INTO `department` VALUES (170, 29, '1803');
INSERT INTO `department` VALUES (171, 29, '1804');
INSERT INTO `department` VALUES (172, 29, '1901');
INSERT INTO `department` VALUES (173, 29, '1902');
INSERT INTO `department` VALUES (174, 29, '1903');
INSERT INTO `department` VALUES (175, 29, '1904');
INSERT INTO `department` VALUES (176, 30, '1601');
INSERT INTO `department` VALUES (177, 30, '1602');
INSERT INTO `department` VALUES (178, 30, '1603');
INSERT INTO `department` VALUES (179, 30, '1604');
INSERT INTO `department` VALUES (180, 30, '1701');
INSERT INTO `department` VALUES (181, 30, '1702');
INSERT INTO `department` VALUES (182, 30, '1703');
INSERT INTO `department` VALUES (183, 30, '1704');
INSERT INTO `department` VALUES (184, 30, '1801');
INSERT INTO `department` VALUES (185, 30, '1802');
INSERT INTO `department` VALUES (186, 30, '1803');
INSERT INTO `department` VALUES (187, 30, '1804');
INSERT INTO `department` VALUES (188, 30, '1901');
INSERT INTO `department` VALUES (189, 30, '1902');
INSERT INTO `department` VALUES (190, 30, '1903');
INSERT INTO `department` VALUES (191, 30, '1904');
INSERT INTO `department` VALUES (195, 15, '电气工程及其自动化');
INSERT INTO `department` VALUES (196, 15, '自动化');
INSERT INTO `department` VALUES (197, 195, '1801');
INSERT INTO `department` VALUES (198, 195, '1802');
INSERT INTO `department` VALUES (199, 195, '1803');
INSERT INTO `department` VALUES (200, 195, '1804');
INSERT INTO `department` VALUES (201, 195, '1601');
INSERT INTO `department` VALUES (202, 195, '1602');
INSERT INTO `department` VALUES (203, 195, '1603');
INSERT INTO `department` VALUES (204, 195, '1604');
COMMIT;

-- ----------------------------
-- Records of exam
-- ----------------------------
BEGIN;
INSERT INTO `exam` VALUES (3, 3, '工三A102', 1, '2020-07-17', '14:00:00', '15:30:00');
INSERT INTO `exam` VALUES (7, 27, '综合教学楼A103', 2, '2020-07-30', '14:30:00', '16:30:00');
INSERT INTO `exam` VALUES (12, 2, '综合教学楼A103', 1, '2020-07-07', '14:00:00', '16:00:00');
COMMIT;


-- ----------------------------
-- Records of perms
-- ----------------------------
BEGIN;
INSERT INTO `perms` VALUES (2, 'stu:add');
INSERT INTO `perms` VALUES (3, 'stu:delete');
INSERT INTO `perms` VALUES (4, 'stu:update');
INSERT INTO `perms` VALUES (5, 'stu:view');
COMMIT;


-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'student');
INSERT INTO `role` VALUES (2, 'teacher');
INSERT INTO `role` VALUES (3, 'admin');
INSERT INTO `role` VALUES (4, 'root');
COMMIT;


-- ----------------------------
-- Records of role_perms
-- ----------------------------
BEGIN;
INSERT INTO `role_perms` VALUES (2, 2);
INSERT INTO `role_perms` VALUES (2, 3);
INSERT INTO `role_perms` VALUES (2, 4);
INSERT INTO `role_perms` VALUES (2, 5);
COMMIT;


-- ----------------------------
-- Records of stu_course
-- ----------------------------
BEGIN;
INSERT INTO `stu_course` VALUES (11, 3, 89);
INSERT INTO `stu_course` VALUES (11, 2, NULL);
INSERT INTO `stu_course` VALUES (11, 21, 89);
INSERT INTO `stu_course` VALUES (13, 2, NULL);
INSERT INTO `stu_course` VALUES (13, 3, 89);
INSERT INTO `stu_course` VALUES (13, 21, 89);
INSERT INTO `stu_course` VALUES (22, 2, NULL);
INSERT INTO `stu_course` VALUES (22, 3, 89);
INSERT INTO `stu_course` VALUES (12, 3, 89);
INSERT INTO `stu_course` VALUES (12, 21, 89);
INSERT INTO `stu_course` VALUES (12, 2, NULL);
INSERT INTO `stu_course` VALUES (12, 27, NULL);
INSERT INTO `stu_course` VALUES (42, 3, 88);
INSERT INTO `stu_course` VALUES (42, 2, NULL);
COMMIT;



