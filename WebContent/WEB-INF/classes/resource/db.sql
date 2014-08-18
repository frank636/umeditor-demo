

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `content` blob,
  `time` date DEFAULT NULL,
  `ip` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF-8;

