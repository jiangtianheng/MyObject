/*
Navicat MySQL Data Transfer

Source Server         : 211.155.80.82(4307)
Source Server Version : 50619
Source Host           : 211.155.80.82:4307
Source Database       : overseahots

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2015-05-08 20:49:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for o_app
-- ----------------------------
DROP TABLE IF EXISTS `o_app`;
CREATE TABLE `o_app` (
  `id` bigint(20) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `pkg` varchar(40) DEFAULT NULL,
  `apk` varchar(128) DEFAULT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `point` int(10) DEFAULT '6',
  `req` varchar(64) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  `ecountry` varchar(10) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_app
-- ----------------------------
INSERT INTO `o_app` VALUES ('0', 'video decoders', 'video decoders', 'com.android.dp', 'http://dphw-cdn.b0.upaiyun.com/ipa/20150429054727593.apk', 'http://dphw-cdn.b0.upaiyun.com/images/20150429060554000.jpg', '5', 'install and opens', null, 'CN', '0', '2015-05-08 20:00:14', '2015-05-08 20:00:14');

-- ----------------------------
-- Table structure for o_config
-- ----------------------------
DROP TABLE IF EXISTS `o_config`;
CREATE TABLE `o_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admob_key` varchar(64) DEFAULT NULL,
  `tapjoy_key` varchar(64) DEFAULT NULL,
  `supersnoic_key` varchar(64) DEFAULT NULL,
  `ad_interval` int(10) DEFAULT NULL,
  `show_admob` int(10) DEFAULT NULL,
  `show_tapjoy` int(10) DEFAULT NULL,
  `show_supersnoic` int(10) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_config
-- ----------------------------
INSERT INTO `o_config` VALUES ('1', 'admob_key', 'tapjoy_key', 'supersnoic_key', '60', '1', '1', '1', '0', '2015-05-08 19:48:09', '2015-05-08 19:48:09');

-- ----------------------------
-- Table structure for o_country
-- ----------------------------
DROP TABLE IF EXISTS `o_country`;
CREATE TABLE `o_country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mcc` varchar(10) NOT NULL,
  `mnc` varchar(10) NOT NULL,
  `country` varchar(10) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `unitname` varchar(20) DEFAULT NULL,
  `unitename` varchar(20) DEFAULT NULL,
  `timezone` varchar(20) DEFAULT NULL,
  `ccode` varchar(10) DEFAULT NULL,
  `language` varchar(10) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `localname` varchar(40) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_index` (`country`),
  KEY `mcc_index` (`mcc`)
) ENGINE=MyISAM AUTO_INCREMENT=161 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_country
-- ----------------------------
INSERT INTO `o_country` VALUES ('1', '460', '', 'CN', 'CNY', '人民币', 'CNY', 'UTC+8', '+86', 'zh', '中华人民共和国', 'People s Republic of China', null, '东亚');
INSERT INTO `o_country` VALUES ('2', '440', '', 'JP', 'JPY', '日元', 'JPY', 'UTC+9', '+81', 'ja', '日本国', 'Japan', null, '东亚');
INSERT INTO `o_country` VALUES ('3', '467', '', 'KP', 'KPW', '朝鲜圆', 'KPW', 'UTC+9', '+850', 'ko', '朝鲜民主主义人民共和国', 'Democratic Peoples Republic of Korea', null, '东亚');
INSERT INTO `o_country` VALUES ('4', '450', '', 'KR', 'KRW', '韩元', 'KRW', 'UTC+9', '+82', 'ko', '大韩民国', 'Republic of Korea', null, '东亚');
INSERT INTO `o_country` VALUES ('5', '428', '', 'MN', 'MNT', '图格里克', 'MNT', 'UTC+8', '+976', 'mn', '蒙古国', 'Mongolia', null, '东亚');
INSERT INTO `o_country` VALUES ('6', '454', '', 'HK', 'HKD', '港币', 'HKD', 'UTC+8', '+00852', 'zh', '中华人民共和国香港特别行政区', 'Hong Kong Special Administrative Region of the Peo', null, '东亚');
INSERT INTO `o_country` VALUES ('7', '455', '', 'MO', 'MOP', '澳门币', 'MOP', 'UTC+8', '+853', 'zh', '中华人民共和国澳门特别行政区', 'Macau', null, '东亚');
INSERT INTO `o_country` VALUES ('8', '466', '', 'TW', 'TWD', '新台币', 'NT$', 'UTC+8', '+886', 'zh', '台湾省', 'Taiwan Province', null, '东亚');
INSERT INTO `o_country` VALUES ('9', '452', '', 'VN', 'VND', '越南盾', 'VND', 'UTC+7', '+84', 'vi', '越南社会主义共和国', 'Socialist Republic of Vietnam', null, '东南亚');
INSERT INTO `o_country` VALUES ('10', '520', '', 'TH', 'THB', '泰铢', 'THB', 'UTC+7', '+66', 'th', '泰王国', 'Kingdom of Thailand', null, '东南亚');
INSERT INTO `o_country` VALUES ('11', '502', '', 'MY', 'MYR', '令吉', 'MYR', 'UTC+8', '+60', 'ms', '马来西亚', 'Malaysia', null, '东南亚');
INSERT INTO `o_country` VALUES ('12', '510', '', 'ID', 'IDR', '印尼盾', 'IDR', 'UTC+8', '+62', 'id', '印度尼西亚共和国', 'The Republic of Indonesia', null, '东南亚');
INSERT INTO `o_country` VALUES ('13', '515', '', 'PH', 'PHP', '菲律宾比索', 'PHP', 'UTC+8', '+63', 'tl', '菲律宾共和国', 'Republic of the Philippines', null, '东南亚');
INSERT INTO `o_country` VALUES ('14', '525', '', 'SG', 'SGD', '新加坡元', 'SGD', 'UTC+8', '+65', 'en', '新加坡共和国', 'Republic of Singapore', null, '东南亚');
INSERT INTO `o_country` VALUES ('15', '457', '', 'LA', 'LAK ', '基普', 'LAK ', 'UTC+7', '+856', 'lo', '老挝人民民主共和国', 'Lao People s Democratic Republic', null, '东南亚');
INSERT INTO `o_country` VALUES ('16', '528', '', 'BN', 'BND', '文莱元', 'BND', 'UTC+8', '+673', 'ms', '文莱达鲁萨兰国', 'Brunei', null, '东南亚');
INSERT INTO `o_country` VALUES ('17', '456', '', 'KH', 'KHR', '瑞尔', 'KHR', 'UTC+7', '+855', 'km', '柬埔寨王国', 'Kingdom of Cambodia', null, '东南亚');
INSERT INTO `o_country` VALUES ('18', '414', '', 'MM', 'MMK', '缅元', 'MMK', 'UTC+6:30', '+95', 'my', '缅甸联邦共和国', 'Republic of the Union of Myanmar', null, '东南亚');
INSERT INTO `o_country` VALUES ('19', '514', '', 'TL', 'IDR', '印尼盾', 'IDR', 'UTC+9', '+670', 'pt', '东帝汶民主共和国', 'DEMOCRATIC REPUBLIC OF TIMOR-LESTE', null, '东南亚');
INSERT INTO `o_country` VALUES ('20', '470', '', 'BD', 'BDT', '塔卡', 'BDT', 'UTC+6', '+880', 'en', '孟加拉人民共和国', 'People s Republic of Bangladesh', null, '南亚');
INSERT INTO `o_country` VALUES ('21', '402', '', 'BT', 'BTN', '努扎姆', 'BTN', 'UTC+6', '+975', 'dz', '不丹王国', 'Kingdom of Bhutan', null, '南亚');
INSERT INTO `o_country` VALUES ('22', '404', '', 'IN', 'INR', '印度卢比', 'Rs', 'UTC+5:30', '+91', 'en', '印度共和国', 'Republic of India', null, '南亚');
INSERT INTO `o_country` VALUES ('23', '405', '', 'IN', 'INR', '印度卢比', 'Rs', 'UTC+5:30', '+91', 'en', '印度共和国', 'Republic of India', null, '南亚');
INSERT INTO `o_country` VALUES ('24', '472', '', 'MV', 'MVR', '拉菲亚', 'MVR', 'UTC+5', '+960', 'dv', '马尔代夫共和国', 'The Republic of Maldives', null, '南亚');
INSERT INTO `o_country` VALUES ('25', '429', '', 'NP', 'NPR', '尼泊尔卢比', 'NPR', 'UTC+5:45', '+977', 'ne', '尼泊尔联邦民主共和国', 'Federal Democratic Republic of Nepal', null, '南亚');
INSERT INTO `o_country` VALUES ('26', '413', '', 'LK', 'LKR', '斯里兰卡卢比', 'LKR', 'UTC+5:30', '+94', 'si', '斯里兰卡民主社会主义共和国', 'The Democratic Socialist Republic of Sri Lanka', null, '南亚');
INSERT INTO `o_country` VALUES ('27', '410', '', 'PK', 'PKR', '巴基斯坦卢比', 'Rs', 'UTC+5', '+92', 'ur', '巴基斯坦伊斯兰共和国', 'the Islamic Republic of Pakistan', null, '南亚');
INSERT INTO `o_country` VALUES ('28', '712', '', 'CR', 'CRC', '哥斯达黎加科朗', 'CRC', 'UTC-6', '+506', 'es', '哥斯达黎加共和国', 'Republic of Costa Rica', null, '北美');
INSERT INTO `o_country` VALUES ('29', '310', '', 'US', 'USD', '美元', 'USD', 'UTC-6', '+001', 'en', '美利坚合众国', 'The United States of America', null, '北美');
INSERT INTO `o_country` VALUES ('30', '311', '', 'US', 'USD', '美元', 'USD', 'UTC-6', '+001', 'en', '美利坚合众国', 'The United States of America', null, '北美');
INSERT INTO `o_country` VALUES ('31', '316', '', 'US', 'USD', '美元', 'USD', 'UTC-6', '+001', 'en', '美利坚合众国', 'The United States of America', null, '北美');
INSERT INTO `o_country` VALUES ('32', '302', '', 'CA', 'CAD', '加拿大元', 'CAD', 'UTC-5', '+1', 'en', '加拿大', 'Canada', null, '北美');
INSERT INTO `o_country` VALUES ('33', '332', '', 'MX', 'MXN', '墨西哥比索', 'MXN', 'UTC-6', '+52', 'es', '墨西哥合众国', 'The?United States of Mexico', null, '北美');
INSERT INTO `o_country` VALUES ('34', '708', '', 'HN', 'HNL', '伦皮拉', 'HNL', 'UTC-6', '+504', 'es', '洪都拉斯共和国', 'Republic of Honduras', null, '北美');
INSERT INTO `o_country` VALUES ('35', '704', '', 'GT', 'GTQ', '格查尔', 'GTQ', 'UTC-6', '+502', 'es', '危地马拉共和国', 'The Republic of Guatemala', null, '北美');
INSERT INTO `o_country` VALUES ('36', '368', '', 'CU', 'CUP', '古巴比索', 'CUP', 'UTC-5', '+53', 'es', '古巴共和国', 'The Republic of Cuba', null, '北美');
INSERT INTO `o_country` VALUES ('37', '364', '', 'BS', 'BSD', '巴哈马元', 'BSD', 'UTC-5', '+1-242', 'en', '巴哈马国', 'The Commonwealth of The Bahamas', null, '北美');
INSERT INTO `o_country` VALUES ('38', '714', '', 'PA', 'PAB', '巴波亚', 'PAB', 'UTC-6', '+507', 'es', '巴拿马共和国', 'The Republic of Panama', null, '北美');
INSERT INTO `o_country` VALUES ('39', '338', '', 'JM', 'JMD', '牙买加元', 'JMD', 'UTC-5', '+1-876', 'en', '牙买加', 'Jamaica', null, '北美');
INSERT INTO `o_country` VALUES ('40', '372', '', 'HT', 'HTG', '古德', 'HTG', 'UTC-5', '+509', 'fr', '海地共和国', 'The Republic of Haiti', null, '北美');
INSERT INTO `o_country` VALUES ('41', '702', '', 'BZ', 'BZD', '伯利兹元', 'BZD', 'UTC-6', '+501', 'en', '伯利兹', 'Belize', null, '北美');
INSERT INTO `o_country` VALUES ('42', '342', '', 'BB', 'BBD', '巴巴多斯元', 'BBD', 'UTC-4', '+1-246', 'en', '巴巴多斯', 'Barbados', null, '北美');
INSERT INTO `o_country` VALUES ('43', '352', '', 'GD', 'XCD', '东加勒比元', 'XCD', 'UTC-4', '+1-473', 'en', '格林纳达', 'Grenada', null, '北美');
INSERT INTO `o_country` VALUES ('44', '710', '', 'NI', 'NIO', '科多巴', 'NIO', 'UTC-6', '+505', 'es', '尼加拉瓜共和国', 'The Republic of Nicaragua', null, '北美');
INSERT INTO `o_country` VALUES ('45', '366', '', 'DM', 'XCD', '东加勒比元', 'XCD', 'UTC-4', '+1767', 'en', '多米尼克国', 'The Commonwealth of Dominica', null, '北美');
INSERT INTO `o_country` VALUES ('46', '370', '', 'DO', 'DOP', '多米尼加比索', 'DOP', 'UTC-4', '+1849', 'es', '多米尼加共和国', 'The Dominican Republic', null, '北美');
INSERT INTO `o_country` VALUES ('47', '374', '', 'TT', 'TTD', '特立尼达和多巴哥元', 'TTD', 'UTC-4', '+1-868', 'en', '特立尼达和多巴哥共和国', 'Republic of Trinidad and Tobago', null, '北美');
INSERT INTO `o_country` VALUES ('48', '330', '', 'PR', 'USD', '美元', 'USD', 'UTC-5', '+1-787，+1-', 'es', '波多黎各自由邦', 'The Commonwealth of Puerto Rico', null, '北美');
INSERT INTO `o_country` VALUES ('49', '722', '', 'AR', 'ARS', '阿根廷比索', 'ARS', 'UTC-3', '+54', 'es', '阿根廷共和国', 'The Republic of Argentina', null, '南美');
INSERT INTO `o_country` VALUES ('50', '724', '', 'BR', 'BRL', '雷亚尔', 'BRL', 'UTC-3', '+55', 'pt', '巴西联邦共和国', 'The Federative Republic of Brazil', null, '南美');
INSERT INTO `o_country` VALUES ('51', '736', '', 'BO', 'BOB', '玻利维亚诺', 'BOB', 'UTC-4', '+591', 'es', '多民族玻利维亚国', 'The Multinational States of Bolivia', null, '南美');
INSERT INTO `o_country` VALUES ('52', '730', '', 'CL', 'CLP', '智利比索', 'CLP', 'UTC-4', '+56', 'es', '智利共和国', 'Republic of Chile', null, '南美');
INSERT INTO `o_country` VALUES ('53', '732', '', 'CO', 'COP', '哥伦比亚比索', 'COP', 'UTC-5', '+57', 'es', '哥伦比亚共和国', 'The Republic of Colombia', null, '南美');
INSERT INTO `o_country` VALUES ('54', '740', '', 'EC', 'USD', '美元', 'USD', 'UTC-5', '+593', 'es', '厄瓜多尔共和国', 'The Republic of Ecuador', null, '南美');
INSERT INTO `o_country` VALUES ('55', '738', '', 'GY', 'GYD', '圭亚那元', 'GYD', 'UTC-4', '+592', 'en', '圭亚那共和国', 'The Republic of Guyana', null, '南美');
INSERT INTO `o_country` VALUES ('56', '744', '', 'PY', 'PYG', '瓜拉尼', 'PYG', 'UTC-4', '+595', 'es', '巴拉圭共和国', 'The Republic of Paraguay', null, '南美');
INSERT INTO `o_country` VALUES ('57', '716', '', 'PE', 'PEN', '新索尔', 'PEN', 'UTC-5', '+51', 'es', '秘鲁共和国', 'The Republic of Peru', null, '南美');
INSERT INTO `o_country` VALUES ('58', '746', '', 'SR', 'SRD', '苏里南元', 'SRD', 'UTC-3', '+597', 'nl', '苏里南共和国', 'The Republic of Suriname', null, '南美');
INSERT INTO `o_country` VALUES ('59', '748', '', 'UY', 'UYU', '乌拉圭比索', 'UYU', 'UTC-3', '+598', 'es', '乌拉圭东岸共和国', 'The Oriental Republic of Uruguay', null, '南美');
INSERT INTO `o_country` VALUES ('60', '734', '', 'VE', 'VEF', '玻利瓦尔', 'BsF.', 'UTC-4:30', '+58', 'es', '委内瑞拉玻利瓦尔共和国', 'Bolivarian Republic of Venezuela', null, '南美');
INSERT INTO `o_country` VALUES ('61', '602', '', 'EG', 'EGP', '埃及镑', 'EGP', 'UTC+2', '+20', 'ar', '阿拉伯埃及共和国', 'The Arab Republic of Egypt', null, '北非');
INSERT INTO `o_country` VALUES ('62', '634', '', 'SD', 'SDG', '苏丹镑', 'SDG', 'UTC+3', '+249', 'ar', '苏丹共和国', 'The Republic of Sudan', null, '北非');
INSERT INTO `o_country` VALUES ('63', '606', '', 'LY', 'LYD', '利比亚第纳尔', 'LYD', 'UTC+2', '+218', 'ar', '利比亚国', 'State of Libya', null, '北非');
INSERT INTO `o_country` VALUES ('64', '605', '', 'TN', 'TND', '突尼斯第纳尔', 'TND', 'UTC+1', '+216', 'ar', '突尼斯共和国', 'The Republic of Tunisia', null, '北非');
INSERT INTO `o_country` VALUES ('65', '603', '', 'DZ', 'DZD', '阿尔及利亚第纳尔', 'DZD', 'UTC+1', '+213', 'ar', '阿尔及利亚民主人民共和国', 'People s Democratic Republic of Algeria', null, '北非');
INSERT INTO `o_country` VALUES ('66', '604', '', 'MA', 'MAD', '摩洛哥迪拉姆', 'MAD', 'UTC+0', '+212', 'ar', '摩洛哥王国', 'The Kingdom of Morocco', null, '北非');
INSERT INTO `o_country` VALUES ('67', '609', '', 'MR', 'MRO', '毛里塔尼亚乌吉亚', 'MRO', 'UTC+0', '+222', 'ar', '毛里塔尼亚伊斯兰共和国', 'The Islamic Republic of Mauritania', null, '西非');
INSERT INTO `o_country` VALUES ('68', '608', '', 'SN', 'XOF', '西非法郎', 'XOF', 'UTC+0', '+221', 'fa', '塞内加尔共和国', 'the Republic of Senegal', null, '西非');
INSERT INTO `o_country` VALUES ('69', '607', '', 'GM', 'GMD', '达拉西', 'GMD', 'UTC+0', '+220', 'en', '冈比亚共和国', 'The Republic of the Gambia', null, '西非');
INSERT INTO `o_country` VALUES ('70', '610', '', 'ML', 'XOF', '西非法郎', 'XOF', 'UTC+1', '+223', 'fa', '马里共和国', 'The Republic of Mali', null, '西非');
INSERT INTO `o_country` VALUES ('71', '613', '', 'BF', 'XOF', '西非法郎', 'XOF', 'UTC+0', '+226', 'fa', '布基纳法索', 'Burkina Faso', null, '西非');
INSERT INTO `o_country` VALUES ('72', '611', '', 'GN', 'GNF', '几内亚法郎', 'GNF', 'UTC+1', '+224', 'fa', '几内亚共和国', 'The Republic of Guinea', null, '西非');
INSERT INTO `o_country` VALUES ('73', '632', '', 'GW', 'XOF', '西非法郎', 'XOF', 'UTC+0', '+245', 'pt', '几内亚比绍共和国', 'The Republic of Guinea-Bissau', null, '西非');
INSERT INTO `o_country` VALUES ('74', '625', '', 'CV', 'CVE', '埃斯库多', 'CVE', 'UTC-1', '+238', 'pt', '佛得角共和国', 'The Republic of Cape Verde', null, '西非');
INSERT INTO `o_country` VALUES ('75', '619', '', 'SL', 'SLL', '利昂', 'SLL', 'UTC+0', '+232', 'en', '塞拉利昂共和国', 'The Republic of Sierra Leone', null, '西非');
INSERT INTO `o_country` VALUES ('76', '618', '', 'LR', 'LRD', '利比里亚元', 'LRD', 'UTC+0', '+231', 'en', '利比里亚共和国', 'The Republic of Liberia', null, '西非');
INSERT INTO `o_country` VALUES ('77', '612', '', 'CI', 'XOF', '西非法郎', 'XOF', 'UTC+1', '00225', 'fa', '科特迪瓦共和国', 'Ivory Coast', null, '西非');
INSERT INTO `o_country` VALUES ('78', '620', '', 'GH', 'GHC', '塞地', 'GHC', 'UTC+0', '+233', 'en', '加纳共和国', 'The Republic of Ghana', null, '西非');
INSERT INTO `o_country` VALUES ('79', '615', '', 'TG', 'XOF', '西非法郎', 'XOF', 'UTC+1', '+228', 'fa', '多哥共和国', 'The Republic of Togo, La Republique Togolaise', null, '西非');
INSERT INTO `o_country` VALUES ('80', '616', '', 'BJ', 'XOF', '西非法郎', 'XOF', 'UTC+2', '+229', 'fa', '贝宁共和国', 'The Republic of Benin', null, '西非');
INSERT INTO `o_country` VALUES ('81', '614', '', 'NE', 'XOF', '西非法郎', 'XOF', 'UTC+1', '00227', 'fa', '尼日尔共和国', 'The Republic of Niger', null, '西非');
INSERT INTO `o_country` VALUES ('82', '621', '', 'NG', 'NGN', '奈拉', 'NGN', 'UTC+1', '+234', 'en', '尼日利亚联邦共和国', 'Federal Republic of Nigeria', null, '西非');
INSERT INTO `o_country` VALUES ('83', '636', '', 'ET', 'ETB', '埃塞俄比亚比尔', 'ETB', 'UTC+3', '+251', 'am', '埃塞俄比亚联邦民主共和国', 'The Federal Democratic Republic of Ethiopia', null, '东非');
INSERT INTO `o_country` VALUES ('84', '639', '', 'KE', 'KES', '肯尼亚先令', 'Kshs', 'UTC+3', '+254', 'sw', '肯尼亚共和国', 'The Republic of Kenya', null, '东非');
INSERT INTO `o_country` VALUES ('85', '640', '', 'TZ', 'TZS', '坦桑尼亚先令', 'TZS', 'UTC+3', '+255', 'sw', '坦桑尼亚联合共和国', 'The United Republic of Tanzania', null, '东非');
INSERT INTO `o_country` VALUES ('86', '641', '', 'UG', 'UGX', '乌干达先令', 'UGX', 'UTC+3', '+256', 'en', '乌干达共和国', 'The Republic of Uganda', null, '东非');
INSERT INTO `o_country` VALUES ('87', '635', '', 'RW', 'RWF', '卢旺达法郎', 'RWF', 'UTC+2', '+250', 'en', '卢旺达共和国', 'The Republic of Rwanda', null, '东非');
INSERT INTO `o_country` VALUES ('88', '633', '', 'SC', 'SCR', '塞舌尔卢比', 'SCR', 'UTC+4', '+248', 'fa', '塞舌尔共和国', 'Republic of Seychelles', null, '东非');
INSERT INTO `o_country` VALUES ('89', '638', '', 'DJ', 'DJF', '吉布提法郎', 'DJF', 'UTC+3', '+253', 'fa', '吉布提共和国', 'The Republic of Djibouti', null, '东非');
INSERT INTO `o_country` VALUES ('90', '637', '', 'SO', 'SOS', '索马里先令', 'SOS', 'UTC+3', '+252', 'ar', '索马里联邦共和国', 'The Somalia Democratic Republic', null, '东非');
INSERT INTO `o_country` VALUES ('91', '657', '', 'ER', 'ERN', '纳克法', 'ERN', 'UTC+3', '+291', 'ar', '厄立特里亚国', 'The Commonwealth of eritrea', null, '东非');
INSERT INTO `o_country` VALUES ('92', '622', '', 'TD', 'XAF', '中非法郎', 'XAF', 'UTC+1', '+235', 'fa', '乍得共和国', 'The Republic of Chad', null, '中非');
INSERT INTO `o_country` VALUES ('93', '623', '', 'CF', 'XAF', '中非法郎', 'XAF', 'UTC+1', '+236', 'fa', '中非共和国', 'The Central African Republic', null, '中非');
INSERT INTO `o_country` VALUES ('94', '624', '', 'CM', 'XAF', '中非法郎', 'XAF', 'UTC+1', '+237', 'fa', '喀麦隆共和国', 'Republic of Cameroon', null, '中非');
INSERT INTO `o_country` VALUES ('95', '627', '', 'GQ', 'XAF', '中非法郎', 'XAF', 'UTC+1', '+240', 'es', '赤道几内亚共和国', 'The Republic of Equatorial Guinea', null, '中非');
INSERT INTO `o_country` VALUES ('96', '628', '', 'GA', 'XAF', '中非法郎', 'XAF', 'UTC+1', '+241', 'fa', '加蓬共和国', 'The Gabonese Republic', null, '中非');
INSERT INTO `o_country` VALUES ('97', '629', '', 'CG', 'XAF', '中非法郎', 'XAF', 'UTC+2', '+242', 'fa', '刚果共和国', 'Republic of the Congo', null, '中非');
INSERT INTO `o_country` VALUES ('98', '630', '', 'CD', 'CDF', '刚果法郎', 'CDF', 'UTC+2', '+243', 'fa', '刚果民主共和国', 'Democratic Republic of the Congo', null, '中非');
INSERT INTO `o_country` VALUES ('99', '645', '', 'ZM', 'ZMW', '克瓦查', 'ZMW', 'UTC+2', '+260', 'en', '赞比亚共和国', 'The Republic of Zambia', null, '南非');
INSERT INTO `o_country` VALUES ('100', '631', '', 'AO', 'AOA', '宽扎', 'AOA', 'UTC+1', '+244', 'pt', '安哥拉共和国', 'The Republic of Angola', null, '南非');
INSERT INTO `o_country` VALUES ('101', '648', '', 'ZW', 'USD', '美元', 'USD', 'UTC+2', '+263', 'en', '津巴布韦共和国', 'Republic of Zimbabwe', null, '南非');
INSERT INTO `o_country` VALUES ('102', '655', '', 'ZA', 'ZAR', '兰特', 'ZAR', 'UTC+3', '+27', 'en', '南非共和国', 'The Republic of South Africa', null, '南非');
INSERT INTO `o_country` VALUES ('103', '617', '', 'MU', 'MUR', '毛里求斯卢比', 'MUR', 'UTC+4', '+230', 'en', '毛里求斯共和国', 'The Republic of Mauritius', null, '南非');
INSERT INTO `o_country` VALUES ('104', '649', '', 'NA', 'NAD', '纳米比亚元', 'NAD', 'UTC+2', '+264', 'en', '纳米比亚共和国', 'The Republic of Namibia', null, '南非');
INSERT INTO `o_country` VALUES ('105', '643', '', 'MZ', 'MZN', '梅蒂卡尔', 'MZN', 'UTC+2', '+258', 'pt', '莫桑比克共和国', 'The Republic of Mozambique', null, '南非');
INSERT INTO `o_country` VALUES ('106', '650', '', 'MW', 'MWK', '马拉维克瓦查', 'MWK', 'UTC+3', '+265', 'en', '马拉维共和国', 'The Republic of Malawi', null, '南非');
INSERT INTO `o_country` VALUES ('107', '653', '', 'SZ', 'SZL', '里兰吉尼', 'SZL', 'UTC+2', '+268', 'en', '斯威士兰王国', 'The Kingdom of Swaziland', null, '南非');
INSERT INTO `o_country` VALUES ('108', '646', '', 'MG', 'MGA', '阿里亚里', 'MGA', 'UTC+3', '+261', 'fa', '马达加斯加共和国', 'Madagascar', null, '南非');
INSERT INTO `o_country` VALUES ('109', '654', '', 'KM', 'KMF', '科摩罗法郎', 'KMF', 'UTC+3', '+269', 'fa', '科摩罗联盟', 'Union of Comoros', null, '南非');
INSERT INTO `o_country` VALUES ('110', '651', '', 'LS', 'LSL', '洛蒂', 'LSL', 'UTC+2', '+266', 'en', '莱索托王国', 'The Kingdom of Lesotho', null, '南非');
INSERT INTO `o_country` VALUES ('111', '240', '', 'SE', 'SEK', '瑞典克朗', 'SEK', 'UTC +1', '+46', 'sv', '瑞典王国', 'The Kingdom of Sweden', null, '北欧');
INSERT INTO `o_country` VALUES ('112', '244', '', 'FI', 'EUR', '欧元', 'EUR', 'UTC+2', '+358', 'fi', '芬兰共和国', 'The Republic of Finland', null, '北欧');
INSERT INTO `o_country` VALUES ('113', '242', '', 'NO', 'NOK', '挪威克朗', 'NOK', 'UTC+1', '+47', 'nb', '挪威王国', 'The Kingdom of Norway，Kongeriket Norge', null, '北欧');
INSERT INTO `o_country` VALUES ('114', '238', '', 'DK', 'DKK', '丹麦克朗', 'DKK', 'UTC+1', '+45', 'da', '丹麦王国', 'The Kingdom of Denmark', null, '北欧');
INSERT INTO `o_country` VALUES ('115', '274', '', 'IS', 'ISK', '冰岛克朗', 'ISK', 'UTC+0', '+354', 'is', '冰岛共和国', 'The Republic of Iceland', null, '北欧');
INSERT INTO `o_country` VALUES ('116', '234', '', 'UK', 'GBP', '英镑', 'GBP', 'UTC+0', '+44', 'en', '大不列颠及北爱尔兰联合王国', 'The United Kingdom of Great Britain and Northern I', null, '西欧');
INSERT INTO `o_country` VALUES ('117', '235', '', 'UK', 'GBP', '英镑', 'GBP', 'UTC+0', '+44', 'en', '大不列颠及北爱尔兰联合王国', 'The United Kingdom of Great Britain and Northern I', null, '西欧');
INSERT INTO `o_country` VALUES ('118', '272', '', 'IE', 'EUR', '欧元', 'EUR', 'UTC+0', '+353', 'en', '爱尔兰共和国', 'The Republic of Ireland', null, '西欧');
INSERT INTO `o_country` VALUES ('119', '204', '', 'NL', 'EUR', '欧元', 'EUR', 'UTC+1', '+31', 'nl', '尼德兰王国', 'The Kingdom of Netherlands', null, '西欧');
INSERT INTO `o_country` VALUES ('120', '206', '', 'BE', 'EUR', '欧元', 'EUR', 'UTC+1', '+32', 'nl', '比利时王国', 'The Kingdom Of Belgium', null, '西欧');
INSERT INTO `o_country` VALUES ('121', '270', '', 'LU', 'EUR', '欧元', 'EUR', 'UTC+1', '+352', 'fa', '卢森堡大公国', 'The Grand Duchy of Luxembourg', null, '西欧');
INSERT INTO `o_country` VALUES ('122', '208', '', 'FR', 'EUR', '欧元', 'EUR', 'UTC+1', '+33', 'fa', '法兰西共和国', 'The Republic of France', null, '西欧');
INSERT INTO `o_country` VALUES ('123', '234', '', 'FR', 'EUR', '欧元', 'EUR', 'UTC+1', '+33', 'fa', '法兰西共和国', 'The Republic of France', null, '西欧');
INSERT INTO `o_country` VALUES ('124', '212', '', 'MC', 'EUR', '欧元', 'EUR', 'UTC+1', '+377', 'fa', '摩纳哥亲王国', 'The Principality of Monaco', null, '西欧');
INSERT INTO `o_country` VALUES ('125', '250', '', 'RU', 'RUB', '卢布', 'RUB', 'UTC+3', '+7', 'ru', '俄罗斯联邦', 'Russian Federation', null, '东欧');
INSERT INTO `o_country` VALUES ('126', '248', '', 'EE', 'EUR', '欧元', 'EUR', 'UTC+2', '+372', 'et', '爱沙尼亚共和国', 'Republic of Estonia', null, '东欧');
INSERT INTO `o_country` VALUES ('127', '247', '', 'LV', 'EUR', '欧元', 'EUR', 'UTC+2', '+371', 'lv', '拉脱维亚共和国', 'Republic of Latvia', null, '东欧');
INSERT INTO `o_country` VALUES ('128', '246', '', 'LT', 'LTL', '立特', 'LTL', 'UTC+2', '+370', 'it', '立陶宛共和国', 'The Republic of Lithuania', null, '东欧');
INSERT INTO `o_country` VALUES ('129', '255', '', 'UA', 'UAH', '格里夫尼亚', 'UAH', 'UTC+2', '+380', 'uk', '乌克兰', 'Ukraine', null, '东欧');
INSERT INTO `o_country` VALUES ('130', '257', '', 'BY', 'BYR', '白俄罗斯卢布', 'BYR', 'UTC+2', '+375', 'ru', '白俄罗斯共和国', 'The Republic of Belarus', null, '东欧');
INSERT INTO `o_country` VALUES ('131', '259', '', 'MD', 'MDL', '摩尔多瓦列伊', 'MDL', 'UTC+2', '+373', 'ro', '摩尔多瓦共和国', 'The Republic of Moldova', null, '东欧');
INSERT INTO `o_country` VALUES ('132', '260', '', 'PL', 'PLN', '兹罗提', 'PLN', 'UTC+1', '+48', 'pl', '波兰共和国', 'The Republic of Poland', null, '中欧');
INSERT INTO `o_country` VALUES ('133', '262', '', 'DE', 'EUR', '欧元', 'EUR', 'UTC+1', '+49', 'de', '德意志联邦共和国', 'The Federal Republic of Germany', null, '中欧');
INSERT INTO `o_country` VALUES ('134', '228', '', 'CH', 'CHF', '瑞士法郎', 'CHF', 'UTC+1', '+41', 'de', '瑞士联邦', 'Swiss Confederation', null, '中欧');
INSERT INTO `o_country` VALUES ('135', '232', '', 'AT', 'EUR', '欧元', 'EUR', 'UTC+1', '+43', 'de', '奥地利共和国', 'The Republic Of Austria', null, '中欧');
INSERT INTO `o_country` VALUES ('136', '216', '', 'HU', 'HUF', '匈牙利福林', 'HUF', 'UTC+1', '+36', 'hu', '匈牙利', 'Hungary', null, '中欧');
INSERT INTO `o_country` VALUES ('137', '230', '', 'CZ', 'CZK', '捷克克朗', 'CZK', 'UTC+1', '+420', 'cs', '捷克共和国', 'The Czech Republic', null, '中欧');
INSERT INTO `o_country` VALUES ('138', '231', '', 'SK', 'EUR', '欧元', 'EUR', 'UTC+1', '+421', 'sk', '斯洛伐克共和国', 'The Slovak Republic', null, '中欧');
INSERT INTO `o_country` VALUES ('139', '295', '', 'LI', 'CHF', '瑞士法郎', 'CHF', 'UTC+1', '+423', 'de', '列支敦士登公国', 'Principality of Liechtenstein', null, '中欧');
INSERT INTO `o_country` VALUES ('140', '214', '', 'ES', 'EUR', '欧元', 'EUR', 'UTC+1', '+34', 'es', '西班牙王国', 'The Kingdom of Spain', null, '南欧');
INSERT INTO `o_country` VALUES ('141', '268', '', 'PT', 'EUR', '欧元', 'EUR', 'UTC+0', '+351', 'pt', '葡萄牙共和国', 'Portugal,the Portuguese Republic', null, '南欧');
INSERT INTO `o_country` VALUES ('142', '222', '', 'IT', 'EUR', '欧元', 'EUR', 'UTC+1', '+39', 'it', '意大利共和国', 'The Republic of Italy', null, '南欧');
INSERT INTO `o_country` VALUES ('143', '226', '', 'RO', 'RON', '罗马尼亚列伊', 'RON', 'UTC+2', '+40', 'ro', '罗马尼亚', 'Romania', null, '南欧');
INSERT INTO `o_country` VALUES ('144', '284', '', 'BG', 'BGN', '列弗', 'BGN', 'UTC+2', '+359', 'bg', '保加利亚共和国', 'The Republic of Bulgaria', null, '南欧');
INSERT INTO `o_country` VALUES ('145', '220', '', 'RS', 'RSD', '塞尔维亚第纳尔', 'RSD', 'UTC+2', '+381', 'sr', '塞尔维亚共和国', 'The Republic of Serbia', null, '南欧');
INSERT INTO `o_country` VALUES ('146', '219', '', 'HR', 'HRK', '库钠', 'KN', 'UTC+1', '+385', 'hr', '克罗地亚共和国', 'The Republic of Croatia', null, '南欧');
INSERT INTO `o_country` VALUES ('147', '293', '', 'SI', 'EUR', '欧元', 'EUR', 'UTC+1', '+386', 'sl', '斯洛文尼亚共和国', 'The Republic of Slovenia', null, '南欧');
INSERT INTO `o_country` VALUES ('148', '202', '', 'GR', 'EUR', '欧元', 'EUR', 'UTC+2', '+30', 'el', '希腊共和国', 'The Hellenic Republic', null, '南欧');
INSERT INTO `o_country` VALUES ('149', '276', '', 'AL', 'ALL', '列克', 'ALL', 'UTC+1', '+355', 'sq', '阿尔巴尼亚共和国', 'The Republic of Albania', null, '南欧');
INSERT INTO `o_country` VALUES ('150', '297', '', 'ME', 'EUR', '欧元', 'EUR', 'UTC+1', '+382', 'sr', '黑山共和国', 'The Republic of Montenegro', null, '南欧');
INSERT INTO `o_country` VALUES ('151', '294', '', 'MK', 'MKD', '代纳尔', 'MKD', 'UTC+1', '+389', 'mk', '马其顿共和国', 'The Republic of Macedonia', null, '南欧');
INSERT INTO `o_country` VALUES ('152', '292', '', 'SM', 'EUR', '欧元', 'EUR', 'UTC+1', '+378', 'it', '圣马力诺共和国', 'The Republic of San Marino', null, '南欧');
INSERT INTO `o_country` VALUES ('153', '278', '', 'MT', 'EUR', '欧元', 'EUR', 'UTC+1', '+356', 'en', '马耳他共和国', 'Republic of Malta', null, '南欧');
INSERT INTO `o_country` VALUES ('154', '213', '', 'AD', 'EUR', '欧元', 'EUR', 'UTC+1', '+376', 'bg', '安道尔公国', 'The Principality of Andorra', null, '南欧');
INSERT INTO `o_country` VALUES ('155', '417', '', 'SY', 'SYP', '叙利亚镑', 'SYP', 'UTC+3', '+963', 'ar', '叙利亚', 'Syrian Arab Republic', null, '中东');
INSERT INTO `o_country` VALUES ('156', '418', '', 'IQ', 'IQD', '伊拉克第纳尔', 'IQD', 'UTC+3', '+964', 'ar', '伊拉克', 'The Republic of Iraq', '', '中东');
INSERT INTO `o_country` VALUES ('157', '425', '', 'IL', 'ILS', '新谢克尔', 'ILS', 'UTC+2', '+972', 'ar', '以色列', 'Israel', '', '中东');
INSERT INTO `o_country` VALUES ('158', '424', '', 'AE', 'AED', '阿联酋迪拉姆', 'AED', 'UTC+4', '+971', 'ar', '阿联酋', 'United Arab Emirates', null, '中东');
INSERT INTO `o_country` VALUES ('159', '286', '', 'TR', 'TRY', '新土耳其里拉', 'TRY', 'UTC+2', '+90', 'tr', '土耳其', 'Turkey', null, '中亚');
INSERT INTO `o_country` VALUES ('160', '334', '', 'MX', 'MXN', '墨西哥比索', 'MXN', 'UTC+6', '+52', 'en', '墨西哥', 'Mexico', null, '北美');

-- ----------------------------
-- Table structure for o_device
-- ----------------------------
DROP TABLE IF EXISTS `o_device`;
CREATE TABLE `o_device` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `devid` varchar(40) NOT NULL,
  `channel` varchar(40) DEFAULT NULL,
  `mcc` varchar(10) DEFAULT NULL,
  `mnc` varchar(10) DEFAULT NULL,
  `imsi` varchar(30) DEFAULT NULL,
  `imei` varchar(30) DEFAULT NULL,
  `mac` varchar(20) DEFAULT NULL,
  `android_id` varchar(40) DEFAULT NULL,
  `language` varchar(20) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  `network` int(10) DEFAULT NULL,
  `root` int(11) DEFAULT NULL,
  `model` varchar(30) DEFAULT NULL,
  `cpu` varchar(40) DEFAULT NULL,
  `os_ver` varchar(20) DEFAULT NULL,
  `resolution` varchar(20) DEFAULT NULL,
  `appid` varchar(20) DEFAULT NULL,
  `pkg` varchar(40) DEFAULT NULL,
  `sign` varchar(40) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_device
-- ----------------------------

-- ----------------------------
-- Table structure for o_movies
-- ----------------------------
DROP TABLE IF EXISTS `o_movies`;
CREATE TABLE `o_movies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(10) DEFAULT '0',
  `title` varchar(40) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `small_icon` varchar(128) DEFAULT NULL,
  `main_icon` varchar(128) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  `area` varchar(10) DEFAULT NULL,
  `visit` int(10) DEFAULT NULL,
  `low_point` int(10) DEFAULT NULL,
  `high_point` int(10) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `bt` varchar(128) DEFAULT NULL,
  `video` varchar(128) DEFAULT NULL,
  `video2` varchar(128) DEFAULT NULL,
  `score` int(10) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_movies
-- ----------------------------
INSERT INTO `o_movies` VALUES ('1', '0', '職場での女性', 'Director:ああむ\r\nScreenwriter:亚々梦\r\nStarring:亜佐美Release time:2015-03-18Story\r\nThe company a female subordinate to promotion the evening with my back to the home, watched her slowly undressed...', 'http://dphw-cdn.b0.upaiyun.com/images/1426667924317.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426667916922.jpg', 'asia', 'asia', '4374', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/_nysCFY0-lU\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/32.torrent', null, null, null, '0', '2015-05-08 20:39:12', '2015-05-08 20:39:12');
INSERT INTO `o_movies` VALUES ('2', '0', 'happy before married', 'Director:あっと\r\nScreenwriter:あすま\r\nStarring:衣绪斗Release time:2015-03-18Story\r\nLast night the bride before marriage, and chose two men...', 'http://dphw-cdn.b0.upaiyun.com/images/1426668622825.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426668611121.jpg', 'Asia', 'Asia', '6357', '15', '20', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/qzZM2lnH0gI\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/34.torrent', null, null, null, '0', '2015-05-08 20:39:12', '2015-05-08 20:39:12');
INSERT INTO `o_movies` VALUES ('3', '0', 'A female,two male', 'Director:Anil\r\nScreenwriter:DSouza\r\nStarring:BhagyaRelease time:2015-03-30Story\r\nBoyfriend about his brother to watch the game at home. . .', 'http://dphw-cdn.b0.upaiyun.com/images/1427714755379.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427714739852.jpg', 'india', 'india', '8711', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/XCK5Z0GXRBU\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/59.torrent', null, null, null, '0', '2015-05-08 20:39:12', '2015-05-08 20:39:12');
INSERT INTO `o_movies` VALUES ('4', '0', '人妻の包帯の誘惑', 'Director:あそ\r\nScreenwriter:あさよう\r\nStarring:あすまRelease time:2015-03-18Story\r\nWife at home wearing red bandage installed seduced me, almost can not hold.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426682105830.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426682089037.jpg', '亚洲', '亚洲', '7299', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/PVXx3vrS-vo\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/50.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('5', '0', 'girl of next door', 'Director:Gautem\r\nScreenwriter:Mukesh\r\nStarring:ChaitraRelease time:2015-03-30Story\r\nFemale student next door like listening to music, her family did not close the door on this day.', 'http://dphw-cdn.b0.upaiyun.com/images/1427719306132.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427719292601.jpg', 'india', 'india', '5233', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/5Tkz1jFjvNk\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/70.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('6', '0', '背後から男っぽいフィ（混血）', 'Director:安佐人\r\nScreenwriter:あきや\r\nStarring:秋芳やRelease time:2015-03-18Story\r\nThe beauty of the shower is a man to take off his clothes, can not hold the marital infidelity.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426683025183.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426683015481.png', 'Asia', 'Asia', '5233', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/ZzLP9Iwml8M\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/53.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('7', '0', 'Sunshine girl', 'Director:Van\r\nScreenwriter:Ultraman\r\nStarring:EricaRelease time:2015-03-30Story\r\nFemale students in the class laughed very sunny today, she was very fierce at home', 'http://dphw-cdn.b0.upaiyun.com/images/1427718082845.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427718057840.jpg', '欧美', '欧美', '5233', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/aTUSmHqokCA\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/64.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('8', '0', 'Black Beauty', 'Director:Jonathan\r\nScreenwriter:Steve\r\nStarring:LaurenRelease time:2015-03-30Story\r\nGirls have chocolate color, with bright eyes were so looking at me. .', 'http://dphw-cdn.b0.upaiyun.com/images/1427718785802.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427718743319.jpg', '欧美', '欧美', '6744', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/BbidqH3ORFY\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/67.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('9', '0', 'black silk sister', 'Director:Zack\r\nScreenwriter:Zack\r\nStarring:MiriamRelease time:2015-03-30Story\r\nSister looked like a star, but she prefers to wear uniforms.', 'http://dphw-cdn.b0.upaiyun.com/images/1427719649859.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427719635728.jpg', '欧美', '欧美', '4799', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/1J8QR_Mubqs\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/72.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('10', '0', 'stunning beauty', 'Director:Sunil\r\nScreenwriter:Sunil\r\nStarring:SoniaRelease time:2015-03-30Story\r\nBig breasted beauty lying in bed looking at me, let me. .', 'http://dphw-cdn.b0.upaiyun.com/images/1427719101216.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427719069364.jpg', 'india', 'india', '6931', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/qUZ3beeeTeo\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/69.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('11', '1', 'bathing girl ', 'Director:Leonard\r\nScreenwriter:Rex\r\nStarring:BellaRelease time:2015-03-30Story\r\nToday bought his wife likes to wear black silk, watching her writhing body tease.', 'http://dphw-cdn.b0.upaiyun.com/images/1428407945448.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427882443586.jpg', 'india', 'india', '3112', '8', '10', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/vmvHNOarhO0\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/58.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('12', '1', 'Black silk wife', 'Director:Jayaraman\r\nScreenwriter:D\'Souza\r\nStarring:JhadavRelease time:2015-03-30Story\r\nYoung girl lying in their own balcony, watching my desire. . .\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1428407752520.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427883062113.jpg', 'Asia', 'Asia', '3444', '8', '10', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/Iky4ZAC0zv4\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/56.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('13', '1', 'Bed temptation', 'Director:Van\r\nScreenwriter:Ronald\r\nStarring:DaisyRelease time:2015-03-30Story\r\nInvite a girl riding a bicycle, and later together with the one.', 'http://dphw-cdn.b0.upaiyun.com/images/1428407847749.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427883654836.jpg', 'Asia', 'Asia', '2989', '8', '10', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/p_9MRKOg-YE\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/62.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('14', '1', 'Blonde outdoor', 'Director:Van\r\nScreenwriter:Steve\r\nStarring:AlyssaRelease time:2015-03-30Story\r\nSexy blonde lying on the grass to let me plug..\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1427713278911.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427713302918.jpg', 'US', 'US', '6890', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/YTyc0sCZkrk\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/55.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('15', '1', '職場での女性', 'Director:ああむ\r\nScreenwriter:亚々梦\r\nStarring:亜佐美Release time:2015-03-18Story\r\nThe company a female subordinate to promotion the evening with my back to the home, watched her slowly undressed...', 'http://dphw-cdn.b0.upaiyun.com/images/1426667924317.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426667916922.jpg', 'asia', 'asia', '4374', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/_nysCFY0-lU\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/32.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('16', '1', '人妻の包帯の誘惑', 'Director:あそ\r\nScreenwriter:あさよう\r\nStarring:あすまRelease time:2015-03-18Story\r\nWife at home wearing red bandage installed seduced me, almost can not hold.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426682105830.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426682089037.jpg', '亚洲', '亚洲', '7299', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/PVXx3vrS-vo\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/50.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('17', '1', 'From her request', 'Director:Wesley\r\nScreenwriter:Leonard\r\nStarring:LillianRelease time:2015-03-30Story\r\nThe girls took off their clothes, leaning against the wall. .', 'http://dphw-cdn.b0.upaiyun.com/images/1427718953917.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427718942937.jpg', '欧美', '欧美', '7062', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/N2PGss2CISg\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/68.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('18', '1', 'happy before married', 'Director:あっと\r\nScreenwriter:あすま\r\nStarring:衣绪斗Release time:2015-03-18Story\r\nLast night the bride before marriage, and chose two men...', 'http://dphw-cdn.b0.upaiyun.com/images/1426668622825.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426668611121.jpg', 'Asia', 'Asia', '6357', '15', '20', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/qzZM2lnH0gI\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/34.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('19', '1', '背後から男っぽいフィ（混血）', 'Director:安佐人\r\nScreenwriter:あきや\r\nStarring:秋芳やRelease time:2015-03-18Story\r\nThe beauty of the shower is a man to take off his clothes, can not hold the marital infidelity.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426683025183.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426683015481.png', 'Asia', 'Asia', '5233', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/ZzLP9Iwml8M\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/53.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('20', '1', 'Black Beauty', 'Director:Jonathan\r\nScreenwriter:Steve\r\nStarring:LaurenRelease time:2015-03-30Story\r\nGirls have chocolate color, with bright eyes were so looking at me. .', 'http://dphw-cdn.b0.upaiyun.com/images/1427718785802.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427718743319.jpg', '欧美', '欧美', '6744', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/BbidqH3ORFY\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/67.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('21', '1', 'Lonely?girl', 'Director:仧縯\r\nScreenwriter:じゅ 安寿\r\nStarring:え 育恵Release time:2014-12-11Story\r\nWife often told me apart, come home every time he is very enthusiastic, dressed in a black silk to seduce me.', 'http://dphw-cdn.b0.upaiyun.com/images/1426281013436.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426281006506.png', 'Asia', 'Asia', '7399', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/_jZkH1qpth4\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/31.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('22', '1', 'black silk sister', 'Director:Zack\r\nScreenwriter:Zack\r\nStarring:MiriamRelease time:2015-03-30Story\r\nSister looked like a star, but she prefers to wear uniforms.', 'http://dphw-cdn.b0.upaiyun.com/images/1427719649859.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427719635728.jpg', '欧美', '欧美', '4799', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/1J8QR_Mubqs\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/72.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('23', '1', 'girl of next door', 'Director:Gautem\r\nScreenwriter:Mukesh\r\nStarring:ChaitraRelease time:2015-03-30Story\r\nFemale student next door like listening to music, her family did not close the door on this day.', 'http://dphw-cdn.b0.upaiyun.com/images/1427719306132.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427719292601.jpg', 'india', 'india', '5233', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/5Tkz1jFjvNk\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/70.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('24', '1', 'A female,two male', 'Director:Anil\r\nScreenwriter:D\'Souza\r\nStarring:BhagyaRelease time:2015-03-30Story\r\nBoyfriend about his brother to watch the game at home. . .', 'http://dphw-cdn.b0.upaiyun.com/images/1427714755379.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427714739852.jpg', 'india', 'india', '8711', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/XCK5Z0GXRBU\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/59.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('25', '1', 'オフィス女の渇望', 'Director:あっと\r\nScreenwriter:育歩\r\nStarring:以雅Release time:2015-03-18Story\r\nThe company female employees desire is inserted, is very cool in the bed.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426681885706.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426681882654.jpg', '亚洲', '亚洲', '6088', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/pKH-n5LWARA\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/49.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('26', '1', 'On the sofa', 'Director:Phoebe\r\nScreenwriter:Nick\r\nStarring:BeataRelease time:2015-03-30Story\r\nWife likes having sex on the sofa, two people will come today.', 'http://dphw-cdn.b0.upaiyun.com/images/1427714001961.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427713976714.jpg', 'india', 'india', '5434', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/QdscXbWwKt0\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/57.torrent', null, null, null, '0', '2015-05-08 20:39:13', '2015-05-08 20:39:13');
INSERT INTO `o_movies` VALUES ('27', '1', '妻は黒糸透視色っぽい', 'Director:厚\r\nScreenwriter:あすま\r\nStarring:绫晴Release time:2015-03-18Story\r\nInstall lay down on the sofa and let me use the perspective of newlywed wife wearing black, wild eyes.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426682769530.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426682761562.jpg', '亚洲', '亚洲', '7133', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/tsFKmve0C0A\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/52.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('28', '1', 'Office?experience', 'Director:Roger\r\nScreenwriter:Gino\r\nStarring:OpheliaRelease time:2015-03-18Story\r\nFemale boss like subordinates for their own services, especially when working.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426681706155.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426681696670.jpg', '欧美', '欧美', '3649', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/QQcJRO5qSSA\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/48.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('29', '1', '姉の着の誘惑', 'Director:あそ\r\nScreenwriter:あさよう\r\nStarring:あすまRelease time:2015-03-18Story\r\nSister has a good figure, often wearing very little clothing to and fro...', 'http://dphw-cdn.b0.upaiyun.com/images/1426675117342.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426675109445.jpg', '亚洲', '亚洲', '5966', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/TehgvcXa4oA\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/41.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('30', '1', 'stunning beauty', 'Director:Sunil\r\nScreenwriter:Sunil\r\nStarring:SoniaRelease time:2015-03-30Story\r\nBig breasted beauty lying in bed looking at me, let me. .', 'http://dphw-cdn.b0.upaiyun.com/images/1427719101216.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427719069364.jpg', 'india', 'india', '6931', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/qUZ3beeeTeo\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/69.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('31', '1', 'Sunshine girl', 'Director:Van\r\nScreenwriter:Ultraman\r\nStarring:EricaRelease time:2015-03-30Story\r\nFemale students in the class laughed very sunny today, she was very fierce at home', 'http://dphw-cdn.b0.upaiyun.com/images/1427718082845.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427718057840.jpg', '欧美', '欧美', '5233', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/aTUSmHqokCA\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/64.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('32', '1', '狂気の女子寮', 'Director:佐々木\r\nScreenwriter:亜希子\r\nStarring:メアリースー蘇Release time:2015-03-18Story\r\nThe girl was brought to their dormitory, very active off up his own clothes.', 'http://dphw-cdn.b0.upaiyun.com/images/1426667018436.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426667011741.jpg', '亚洲', '亚洲', '6876', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/K5xhzOMQGz8\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/30.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('33', '1', 'insert cocked ass', 'Director:Vincent\r\nScreenwriter:Vincent\r\nStarring:JocelynRelease time:2015-03-30Story\r\nShe lifted the skirt, so I inserted from behind. .', 'http://dphw-cdn.b0.upaiyun.com/images/1427718505995.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427718476239.jpg', '欧美', '欧美', '4387', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/bM9QvtYN7WM\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/66.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('34', '1', 'Uniform Temptation', 'Director:Mohammed\r\nScreenwriter:Mohammed\r\nStarring:UmaRelease time:2015-03-30Story\r\nAfter his wife dressed in uniform, look younger, how can let go of her.', 'http://dphw-cdn.b0.upaiyun.com/images/1427719492149.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427719474635.jpg', '欧美', '欧美', '6275', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/B4JKVodow0E\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/71.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('35', '1', 'Female colleagues', 'Director:Raj\r\nScreenwriter:Raj\r\nStarring:MeeraRelease time:2015-03-30Story\r\nnull', 'http://dphw-cdn.b0.upaiyun.com/images/1427720269804.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427720242302.jpg', 'india', 'india', '2948', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/BY4oWhohy2A\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/75.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('36', '1', 'Best Sexy Maid', 'Director:John\r\nScreenwriter:Henry.Yang\r\nStarring:AudreyRelease time:2015-03-18Story\r\nThe family maid have sexy ass and charming eyes, the best is never refuse...', 'http://dphw-cdn.b0.upaiyun.com/images/1426666268487.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426666260340.jpg', '欧美', '欧美', '5976', '20', '22', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/lWNt2dbspnE\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/28.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('37', '1', '清純少女ない純情、SM好き', 'Director:あっと\r\nScreenwriter:育歩\r\nStarring:以雅Release time:2015-03-18Story\r\nThe beautiful young girl pure usually like binding sex, love SM..', 'http://dphw-cdn.b0.upaiyun.com/images/1426666639845.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426666632622.jpg', '亚洲', '亚洲', '6277', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/OaFX5AAfaVM\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/29.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('38', '1', '春風が吹く開スカート', 'Director:竹内こ \r\nScreenwriter:桥本あさか\r\nStarring:あさか 浅香Release time:2015-03-18Story\r\nOn the road, the wind blew open a girl\'s skirt, was crossing the boys saw.', 'http://dphw-cdn.b0.upaiyun.com/images/1426672394448.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426672387125.jpg', '亚洲', '亚洲', '3490', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/4tXz8zxdNfs\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/37.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('39', '1', 'Leather girl love SM', 'Director:麦斯\r\nScreenwriter:扎维斯\r\nStarring:克里斯汀娜Release time:2015-03-18Story\r\nThe brunette like wearing a fur coat and a man playing SM, tall and very good...', 'http://dphw-cdn.b0.upaiyun.com/images/1426675800387.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426675788931.jpg', '欧美', '欧美', '3011', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/GMc2FomXV3w\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/43.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('40', '1', '美女在公園デート', 'Director:蓝譲\r\nScreenwriter:あいく\r\nStarring:み 佐野 Release time:2015-03-18Story\r\nA woman have a picnic in the open, was a man saw, dragged to a remote place.', 'http://dphw-cdn.b0.upaiyun.com/images/1426669002250.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426668992850.jpg', '亚洲', '亚洲', '4378', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/e0Qcr61V_-Y\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/35.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('41', '1', 'yellow skirt girl', 'Director:Phoebe\r\nScreenwriter:Zachary\r\nStarring:GraceRelease time:2015-03-30Story\r\nWife likes to masturbate, but I like to look at her. . .', 'http://dphw-cdn.b0.upaiyun.com/images/1427718363043.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427718305541.jpg', '欧美', '欧美', '4344', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/lANV4GF7r6E\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/65.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('42', '1', '清純女子風呂戯れ', 'Director:あそ\r\nScreenwriter:育歩\r\nStarring:あさようRelease time:2015-03-18Story\r\nWith pure women\'s going to hot springs, she charmed eyes and red swimsuit makes me very excited.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426682247732.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426682238627.jpg', '亚洲', '亚洲', '4377', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/upyUs6Ab7EQ\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/51.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('43', '1', '熟睡中の女露半', 'Director:つこ 温子\r\nScreenwriter:あいじょう\r\nStarring:安昙 Release time:2015-03-14Story\r\nNext door young married woman thought for a long time. Finally found one day in a chance to enter his house, the whole are very fit me.', 'http://dphw-cdn.b0.upaiyun.com/images/1426301582900.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426301569889.jpg', '亚洲', '日韩地区', '8624', '20', '20', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/lSM4mXlFS8U\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/27.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('44', '1', '办公室世淫乱派对', 'Director:大卫\r\nScreenwriter:大卫\r\nStarring:米卡丽  薇娃Release time:2015-03-18Story\r\nFemale boss called a female subordinate and male subordinates in love together, and later joined the...', 'http://dphw-cdn.b0.upaiyun.com/images/1426668308100.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426668296132.jpg', 'US', 'US', '3927', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/eKxEBo1HR1Q\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/33.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('45', '1', '海滩デート特別企画', 'Director:志野\r\nScreenwriter:厳基\r\nStarring:ますみ 益美Release time:2015-03-18Story\r\nOn the beach playing very happy, nightfall..', 'http://dphw-cdn.b0.upaiyun.com/images/1426675422165.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426675413276.jpg', '亚洲', '亚洲', '3446', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/TXxjtZbLwK4\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/42.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('46', '1', 'desire to kiss', 'Director:Rex\r\nScreenwriter:Jonathan\r\nStarring:CathyRelease time:2015-03-30Story\r\nWoman with a sexy mouth Kiss my body today. . .', 'http://dphw-cdn.b0.upaiyun.com/images/1427717446884.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427717379077.jpg', '欧美', '欧美', '3347', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/1eWWhJ6T-LA\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/61.torrent', null, null, null, '0', '2015-05-08 20:39:14', '2015-05-08 20:39:14');
INSERT INTO `o_movies` VALUES ('47', '1', '隣の美人の洗澡', 'Director:やよい 弥生\r\nScreenwriter:やよい 弥生\r\nStarring:せつみ 鳕美 Release time:2015-03-18Story\r\nThe woman next door take a shower of the time forgot to close the door, sneaked in and found this scene..', 'http://dphw-cdn.b0.upaiyun.com/images/1426667628089.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426667621043.jpg', '亚洲', '亚洲', '5522', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/dGLiVE_a6Mc\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/31.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('48', '1', '着暴露の小秘書', 'Director:いちた一太\r\nScreenwriter:みあ \r\nStarring:せつみ花Release time:2015-03-18Story\r\nSweet female secretary like wearing the uniform, today she is wearing a nurse outfit.', 'http://dphw-cdn.b0.upaiyun.com/images/1426673775686.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426673767402.jpg', '亚洲', '亚洲', '3979', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sTQleXrZ18Y\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/39.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('49', '1', '妹はお風呂に入って', 'Director:安佐人\r\nScreenwriter:あきや\r\nStarring:秋芳やRelease time:2015-03-18Story\r\nTake a shower when my sister couldn\'t help stole a glance, then face is red..', 'http://dphw-cdn.b0.upaiyun.com/images/1426676571421.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426676564647.jpg', '亚洲', '亚洲', '5011', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/h4jwZ1aOvao\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/45.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('50', '1', 'Plump towards to me', 'Director:Bharat\r\nScreenwriter:Jagdish\r\nStarring:PriyaRelease time:2015-03-30Story\r\nToday, to call a prostitute, her hips mast is really let me food for thought. . .', 'http://dphw-cdn.b0.upaiyun.com/images/1427717909511.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427717820106.jpg', 'india', 'india', '4011', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/-3YJpnwZySw\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/63.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('51', '1', '家庭の女教師のいじめ', 'Director:厳基\r\nScreenwriter:いわい祝\r\nStarring:ことの 琴乃Release time:2015-03-14Story\r\nMom please an Asian family teacher told me to study Japanese, beautiful young she do my legs to seduce me.', 'http://dphw-cdn.b0.upaiyun.com/images/1426301158533.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426301152829.jpg', '亚洲', '亚洲', '2314', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/0tTLK7FrMe0\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/25.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('52', '1', '夏の野外刺激の浴衣デート', 'Director:勲海\r\nScreenwriter:み 鶫 \r\nStarring:玉绪ちRelease time:2015-03-18Story\r\nFemale friends wearing wet clothes on the balcony to seduce, I take her to the wall.', 'http://dphw-cdn.b0.upaiyun.com/images/1426672743852.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426672734400.jpg', 'asia', 'asia', '3175', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/WGTRpT1_uU8\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/38.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('53', '1', '办公室女奴', 'Director:なあさ 南朝\r\nScreenwriter:なあさ 南朝\r\nStarring:しいな 椎名Release time:2015-03-18Story\r\nThe female staff are the boss found in stealing the company information, suffered a severe punishment...', 'http://dphw-cdn.b0.upaiyun.com/images/1426671966727.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426671961278.jpg', '亚洲', '亚洲', '1453', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/R-4DWnz3MiA\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/36.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('54', '1', '校花公演後男子生徒は包囲されて', 'Director:あや 亜矢\r\nScreenwriter:あやな \r\nStarring:か 绫香Release time:2015-03-10Story\r\nDay school held a grand performance, the class have a female students also performed, clothing is very sexy, it caused a lot of male students attention.', 'http://dphw-cdn.b0.upaiyun.com/images/1426280788057.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280774008.jpg', 'Asia', 'Asia', '0', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/1Alwg8PU7rY\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/17.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('55', '1', 'Red Temptation', 'Director:Rahul\r\nScreenwriter:Mohammed\r\nStarring:GayathriRelease time:2015-03-30Story\r\nGirlfriend a red dress let me spurting nose. . .', 'http://dphw-cdn.b0.upaiyun.com/images/1427719820758.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1427719798674.jpg', 'india', 'india', '4011', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/MtNj0HMFO-I\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/73.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('56', '1', '女子大生のバレンタイ', 'Director:いろう\r\nScreenwriter:亜宇琉\r\nStarring:彩子Release time:2015-03-10Story\r\nFemale university students to enjoy a better life, with a lot of people happened relationship.', 'http://dphw-cdn.b0.upaiyun.com/images/1426281009114.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426281004489.png', 'Asia', 'Asia', '0', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/iZVAgdO7mzc\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/22.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('57', '1', '両女秘書上司とルール全行程流出', 'Director:の 绫乃\r\nScreenwriter:颯希真衣\r\nStarring:あゆこ   鮎子Release time:2015-03-05Story\r\nTwo young female secretary, promotion and salary raise together in order to have sex with me.', 'http://dphw-cdn.b0.upaiyun.com/images/1426281197883.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426281192074.jpg', 'Asia', 'Asia', '6763', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/Ck-AzXNFIoc\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/23.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('58', '1', 'seaside girls', 'Director:岸育造\r\nScreenwriter:菖蒲\r\nStarring:あり 有/亚理Release time:2014-02-20Story\r\nHis girlfriend to buy a new suit crazy on the beach running, I couldn\'t take him down to the ground...', 'http://dphw-cdn.b0.upaiyun.com/images/1426280495663.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280488122.jpg', 'Asia', 'Asia', '2770', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/bM9QvtYN7WM\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/45.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('59', '1', '美しい少女の初体験', 'Director:厚\r\nScreenwriter:あすま\r\nStarring:绫晴Release time:2015-02-26Story\r\n18 years old girl\'s first experience of sex, young body has not yet fully developed.', 'http://dphw-cdn.b0.upaiyun.com/images/1426280683106.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280679510.jpg', 'Asia', 'Asia', '4225', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/uDgw3_UTawU\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/48.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('60', '1', '楽しみの寂しい女を探して', 'Director:麻哉\r\nScreenwriter:育歩\r\nStarring:あさようRelease time:2015-01-07Story\r\nThe woman next door often wearing a sexy pajamas sitting in bed, smoking to alleviate loneliness...', 'http://dphw-cdn.b0.upaiyun.com/images/1426280821941.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280817447.jpg', 'Asia', 'Asia', '234', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/bM9QvtYN7WM\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/49.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('61', '1', '妖艶女子一同放縦', 'Director:温太\r\nScreenwriter:彩世\r\nStarring:衣绪斗 あきよしRelease time:2015-03-18Story\r\nThree beautiful glamour girl together, crazy to play games.', 'http://dphw-cdn.b0.upaiyun.com/images/1426676307575.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426676300638.jpg', '亚洲', '亚洲', '4359', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/n6HW7WadQok\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/44.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('62', '1', '失恋した女子慰めを求めます', 'Director:タカラ映 \r\nScreenwriter:九十九究太 \r\nStarring:おり 伊织 Release time:2014-12-12Story\r\nA lovelorn woman seeking comfort, upper and lower customers also induced...', 'http://dphw-cdn.b0.upaiyun.com/images/1426280674544.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280655179.jpg', 'Asia', 'Asia', '3376', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/kRmEporNVAo\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/52.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('63', '1', 'The?female same-sex?', 'Director:Adrian\r\nScreenwriter:Edward\r\nStarring:Karida  JudyRelease time:2015-03-18Story\r\nTwo a lesbian love to wear stockings to communicate, fetish serious.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426681352241.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426681342849.jpg', '欧美', '欧美', '3421', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/T1lHD5bpBpg\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/46.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('64', '1', '美女校花どの体験', 'Director:あそ\r\nScreenwriter:あすま\r\nStarring:伊武希Release time:2015-03-13Story\r\nThere are two female students in a common class, don\'t love learning, every exam, happiness will come.', 'http://dphw-cdn.b0.upaiyun.com/images/1426280827290.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280824227.jpg', 'Asia', 'Asia', '7233', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/hh2t0THCO4Q\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/50.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('65', '1', 'Lesbian\'s experience', 'Director:Joseph\r\nScreenwriter:David\r\nStarring:Eva?AdaRelease time:2015-03-13Story\r\nLesbian sex like wearing a fur coat, smooth body... Hardening', 'http://dphw-cdn.b0.upaiyun.com/images/1426280512808.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280509723.jpg', 'United Sta', 'United Sta', '5470', '16', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/B4JKVodow0E\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/51.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('66', '1', 'Sister customers', 'Director:岛一\r\nScreenwriter:ずみ 泉\r\nStarring:つみ 逸美Release time:2014-11-28Story\r\nGuest a little sister at home, summer wear sexy Bikini run, saw the expansion of blood vessels.', 'http://dphw-cdn.b0.upaiyun.com/images/1426280629822.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280626077.jpg', 'Asia', 'Asia', '3704', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/N2PGss2CISg\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/56.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('67', '1', '美模的野外诱惑', 'Director:Koves Ki\r\nScreenwriter:Sarah Tova\r\nStarring:Aava TaylorRelease time:2015-03-13Story\r\nElegant models were enchanting writhing body outside, full of silently conveyed tenderness eyes..', 'http://dphw-cdn.b0.upaiyun.com/images/1426280742909.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280739137.jpg', 'Europe', 'Europe', '3276', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/MtNj0HMFO-I\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/52.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('68', '1', '巨人超可愛いバニーSG', 'Director:三木\r\nScreenwriter:苍辉あおき\r\nStarring:栄美子Release time:2015-03-13Story\r\nCute girlfriend usually very well behaved, in bed often wear stockings temptation, also like to wear different uniforms.', 'http://dphw-cdn.b0.upaiyun.com/images/1426280826013.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426280822754.png', 'Asia', 'Asia', '1735', '20', '25', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/2S2RM0NxPmQ\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.ym.com/57.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('69', '1', 'After school', 'Director:新名\r\nScreenwriter:新名\r\nStarring:ふみ 富美Release time:2015-03-18Story\r\nLike Li Fumei for a long time, the day after class, while no one in the class took her and hugged..', 'http://dphw-cdn.b0.upaiyun.com/images/1426674619640.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426674612949.jpg', 'Asia', 'Asia', '1450', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/DpZ9beEu4rI\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/40.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
INSERT INTO `o_movies` VALUES ('70', '1', 'Female students?love', 'Director:Elvis\r\nScreenwriter:Bruce\r\nStarring:Madeline  LuluRelease time:2015-03-18Story\r\nTwo female college students after class in the hotel to touch each other.\r\n', 'http://dphw-cdn.b0.upaiyun.com/images/1426681535769.jpg', 'http://dphw-cdn.b0.upaiyun.com/images/1426681539329.jpg', '欧美', '欧美', '2845', '20', '24', '<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/_JYH96CN-2o\" frameborder=\"0\" allowfullscreen></iframe>', 'http://www.fucker.com/47.torrent', null, null, null, '0', '2015-05-08 20:39:15', '2015-05-08 20:39:15');
