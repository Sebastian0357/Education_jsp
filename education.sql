/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : education

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2024-01-14 02:44:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admintable
-- ----------------------------
DROP TABLE IF EXISTS `admintable`;
CREATE TABLE `admintable` (
  `uname` varchar(255) NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admintable
-- ----------------------------
INSERT INTO `admintable` VALUES ('wt', '123456');

-- ----------------------------
-- Table structure for citytable
-- ----------------------------
DROP TABLE IF EXISTS `citytable`;
CREATE TABLE `citytable` (
  `cityname` varchar(30) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `base` text,
  PRIMARY KEY (`cityname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of citytable
-- ----------------------------
INSERT INTO `citytable` VALUES ('上海', 'image/上海.jpg', '国歌展示馆 上海浦东开发开放主题展馆 上海光源科学研究平台 第一次全国代表大会会址纪念馆 上海龙华烈士陵园 宋庆龄陵园 上海博物馆 “南京路上好八连”事迹展览馆 海军上海博览馆');
INSERT INTO `citytable` VALUES ('北京', 'image/北京.jpg', '铁道兵纪念馆 中国法院博物馆 中国海关博物馆 中国妇女儿童博物馆 中国华侨历史博物馆 宋庆龄同志故居 北京新文化运动纪念馆 北京正负电子对撞机实验室 中国印刷博物馆 北京李大钊故居');
INSERT INTO `citytable` VALUES ('吉林', 'image/吉林.jpg', '长白山老黑河遗址 延边革命烈士陵园 中车长客股份公司高速动车组制造中心 “四保临江”烈士陵园 杨靖宇烈士陵园 四平战役纪念馆 暨四平烈士陵园 白山抗日纪念地 吉林市革命烈士陵园');
INSERT INTO `citytable` VALUES ('天津', 'image/天津.jpg', '天津觉悟社纪念馆 天津市烈士陵园 平津战役纪念馆 天津电力科技博物馆 周恩来邓颖超纪念馆 天津盘山烈士陵园 天津自然博物馆 天津博物馆');
INSERT INTO `citytable` VALUES ('安徽', 'image/安徽.jpg', '王家坝闸 国家同步辐射实验室 渡江战役纪念馆 新四军军部旧址纪念馆 及皖南事变烈士陵园 淮海战役双堆集烈士陵园 安徽省博物馆 金寨革命烈士陵园 渡江战役总前委旧址纪念馆 合肥蜀山烈士陵园');
INSERT INTO `citytable` VALUES ('山东', 'image/山东.jpg', '大青山胜利突围纪念馆 中日甲午战争博物馆 莱芜战役纪念馆 孔子故居 山东省博物馆 孔繁森纪念馆 中国人民解放军海军博物馆 地雷战纪念馆 台儿庄大战纪念馆 济南革命烈士陵园 华东革命烈士陵园 铁道游击队纪念园 冀鲁豫边区革命纪念馆');
INSERT INTO `citytable` VALUES ('山西', 'image/山西.jpg', '八路军太行纪念馆 太原解放纪念馆 平型关战役遗址“百团大战”纪念馆 麻田八路军总部纪念馆 刘胡兰纪念馆 黄崖洞革命纪念地');
INSERT INTO `citytable` VALUES ('河北', 'image/河北.jpg', '董存瑞烈士陵园 晋冀鲁豫烈士陵园 华北军区烈士陵园 马本斋纪念馆 潘家峪惨案纪念馆 山海关长城博物馆 河北省博物馆 冀南烈士陵园 唐山抗震纪念馆 沙石峪陈列馆');
INSERT INTO `citytable` VALUES ('河南', 'image/河南.jpg', '中国文字博物馆 八路军驻洛办事处纪念馆 王大湾会议会址纪念馆 愚公移山精神展览馆 郑州二七纪念馆 中国中铁装备集团 郑州盾构总装车间 刘邓大军渡黄河纪念馆 中国一拖东方红农耕博物馆');
INSERT INTO `citytable` VALUES ('辽宁', 'image/辽宁.jpg', '辽宁东北抗日义勇军纪念馆 辽沈战役纪念馆 葫芦岛市塔山烈士陵园 沈阳审判日本战犯法庭旧址 陈列馆抚顺雷锋纪念馆 沈阳“九一八”事变博物馆 旅顺万忠墓纪念馆 抗美援朝纪念馆 沈阳抗美援朝烈士陵园 黑山阻击战烈士陵园 关向应故居纪念馆 抚顺战犯管理所旧址陈列馆 平顶山惨案遗址纪念馆');
INSERT INTO `citytable` VALUES ('重庆', 'image/重庆.jpg', '重庆三峡移民纪念馆 重庆红岩革命纪念馆 刘邓大军挺进大西南司令部旧址 邱少云烈士纪念馆 重庆特园民主党派历史陈列 聂荣臻元帅陈列馆 重庆歌乐山革命烈士陵园 赵世炎烈士故居 刘伯承同志纪念馆');
INSERT INTO `citytable` VALUES ('黑龙江', 'image/黑龙江.jpg', '齐齐哈尔江桥抗战纪念地 侵华日军731细菌部队罪证陈列馆 北大荒开发建设纪念馆 中国一重展览馆 东北烈士纪念馆 铁人王进喜纪念馆 缓挥历史陈列馆 哈尔滨烈士陵园 马骏纪念馆');

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `uname` varchar(30) NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `brithday` date DEFAULT NULL,
  `organization` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uname`),
  KEY `uname` (`uname`,`pwd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES ('Jack', '123456', '男', 'w13694105330@163.com', '精于心，简于行，成于细节。', '2003-05-07', '大连外国语大学', '13694105330', '20231223163616193.jpg');
INSERT INTO `usertable` VALUES ('Rose', '123456', '女', 'w13694105330@163.com', '精于心，简于行，成于细节。', '2003-05-07', '大连外国语大学', '13694105330', '20231223172348263.jpg');
