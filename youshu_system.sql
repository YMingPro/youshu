/*
 Navicat Premium Data Transfer

 Source Server         : 115.29.239.199_3306
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 115.29.239.199:3306
 Source Schema         : youshu_system

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 08/01/2020 16:01:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `Book_ISBN` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Book_Name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Book_Author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Book_Publisher` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Book_Price` decimal(8, 2) NOT NULL,
  `Book_Info` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Book_Stock` int(11) NOT NULL,
  `Book_Picture1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Book_Picture2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Book_ISBN`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('9787559434937', '《一生自在》', '季羡林', '江苏凤凰文艺出版社', 55.50, '季羡林的自在智慧（金庸、贾平凹、白岩松、林青霞极力推崇）', 90, 'http://img3m5.ddimg.cn/63/31/27909945-1_w_7.jpg', 'http://img51.ddimg.cn/99999990057321161.jpg');
INSERT INTO `book` VALUES ('9787559436658', '《悲喜自渡》', '季羡林', '江苏凤凰文艺出版社', 21.00, '季羡林的孤独智慧（TFboys王源认同的生活态度）', 89, 'http://img3m6.ddimg.cn/98/21/27922256-1_u_3.jpg', 'http://img56.ddimg.cn/99999990055455836.jpg');
INSERT INTO `book` VALUES ('9787559817815', '《书店日记》', '肖恩·白塞尔', '广西师范大学出版社', 62.40, '英国超人气毒舌店主的开店日记。 在书店工作，你需要一个圣人的耐心。', 96, 'http://img3m4.ddimg.cn/2/19/27920774-1_u_3.jpg', 'http://img55.ddimg.cn/99999990071353285.jpg');
INSERT INTO `book` VALUES ('9787559631886', '《北京女子图鉴》', '王欣', '北京联合出版有限公司', 32.40, '（季播电影正在优酷热映中，反裤衩阵地同名小说抢先读。@反裤衩阵地/王欣 重磅作品）', 95, 'http://img3m1.ddimg.cn/58/15/27892021-1_w_6.jpg', 'http://img54.ddimg.cn/99999990049573254.jpg');
INSERT INTO `book` VALUES ('9787201088945', '《皮囊》', '蔡崇达', '天津人民出版社', 24.70, '（350万册纪念版。直面人生的终极问题，刻在骨头里的故事，容纳一个个既失去家乡又未到达远方的生命。感动千万读者的国民读本）', 98, 'http://img3m1.ddimg.cn/3/6/27872661-1_w_13.jpg', 'http://img51.ddimg.cn/99999990032625991.jpg');
INSERT INTO `book` VALUES ('9787514357806', '《丰子恺愿你一生清澈明朗》', '丰子恺', '现代出版社', 19.90, '在复杂的世界里,做一个简单的人。人生真正的美好在于：你有一颗澄明的心。只有让自己内心富有充盈，才能从容抵御世间所有的不安与喧嚣，成就自己美好的人生！林清玄，朱自清，郁达夫，巴金、叶圣陶倾情推荐！', 93, 'http://img3m6.ddimg.cn/87/8/24240336-1_w_3.jpg', 'http://img56.ddimg.cn/99999990001343276.jpg');
INSERT INTO `book` VALUES ('9787544296274', '《夏天、烟火和我的尸体》', '（日）乙一 ', '南海出版公司', 22.50, '夏天、烟火和我的尸体（乙一16岁惊世成名作，高口碑暗黑杰作，获第6届JUMP小说大奖）', 98, 'http://img3m6.ddimg.cn/28/30/27941986-1_w_3.jpg', 'http://img58.ddimg.cn/99999990070562408.jpg');
INSERT INTO `book` VALUES ('9787559620125', '《天才在左 疯子在右》', '高铭', '北京联合出版有限公司', 46.30, '(2018全新完整版)上市以来持续霸榜，累计销量破500万册！高圆圆、陈乔恩、李宇春、胡歌、刘昊然盛情推荐！女神、男神都在看的传奇畅销书！借疯子的策略，唤醒你未知的灵魂！看高智商疯子如何调戏和“羞辱”正常人！', 98, 'http://img3m2.ddimg.cn/96/32/25285092-1_w_4.jpg', 'http://img57.ddimg.cn/99999990003026937.jpg');
INSERT INTO `book` VALUES ('9787540356798', '《唐宋文举要》', '高步瀛', '崇文书局', 199.00, '（全三册 布面精装+护封）youshu独家首发古典文学案头书，程千帆说，没有读过《唐宋文举要》的人大概是很少的。据民国直隶书局初刊本精细整理，时隔二十年升级再版，全面恢复曾国藩评点；繁体竖排，双行夹注，全式标点。', 99, 'http://img3m8.ddimg.cn/60/20/28471668-1_w_19.jpg', 'http://img59.ddimg.cn/99999990074298229.jpg');
INSERT INTO `book` VALUES ('9787539998312', '《小王子》', '安托万.德.圣埃克苏佩里', '江苏文艺出版社', 18.00, '参考兰登书屋、企鹅出版社等经典英译本，全英文外教美式朗读音频，配原版高清插图，附赠《词汇注解》手册', 97, 'http://img3m6.ddimg.cn/3/14/25102146-1_w_3.jpg', 'http://img57.ddimg.cn/99999990003662177.jpg');
INSERT INTO `book` VALUES ('9787569921557', '《呼啸山庄》', '艾米丽，勃朗特', '北京时代华文书局', 17.00, '英文原版 世界经典文学名著畅销小说课外读物 振宇书虫', 99, 'http://img3m4.ddimg.cn/49/7/25309894-1_x_6.jpg', 'http://img54.ddimg.cn/99999990061906194.jpg');
INSERT INTO `book` VALUES ('9787517077121', '《假如给我三天光明》', '海伦·凯勒', '水利水电出版社', 14.80, '英汉对照注释·听读版 含朗读音频 中英文对照 原版 世界名著—昂秀书虫赠送朗读音频+书签！扫二维码免费听音频 世界经典文学双语系列 英汉对照注释版听读版', 99, 'http://img3m2.ddimg.cn/69/7/27890052-1_w_2.jpg', 'http://img51.ddimg.cn/99999990035254521.jpg');
INSERT INTO `book` VALUES ('9787508658346', '《二手时间》', 'S.A.阿列克谢耶维奇', '中信出版社', 55.00, '该书分为两个部分：“启示录的慰藉”和“空虚的迷惑”。作者在第一部分中提到参与者的讲述引起了她强烈的共鸣，她找到了与之心心相印的苏维埃人。作者在第二部分中记录了苏联解体后民众在生活上的艰难困苦”等。', 96, 'https://img.alicdn.com/imgextra/i2/TB1euW2PVXXXXavXFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg', 'https://img.alicdn.com/imgextra/i4/2938395088/TB25I7LgwxlpuFjSszgXXcJdpXa_!!2938395088.jpg');
INSERT INTO `book` VALUES ('9787210075073', '《罗曼蒂克消亡史》', '程耳', '江西人民出版社', 36.00, '程耳的小说如同他的电影，循环推进，起落得当，总要人怀着好奇与疑惑，绝难一览无余。他通过冷静自律又舒缓细腻的叙述，连接往昔与现在，抖落隐秘--人类的存在就是一部消亡史，那些浪漫的，需要被重新打量，那些经得起打量的荒诞，才最浪漫。', 99, 'https://img.alicdn.com/imgextra/i2/TB18u7sPVXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg', 'https://img.alicdn.com/imgextra/i4/2938395088/TB2RwmSiylnpuFjSZFgXXbi7FXa_!!2938395088.jpg');
INSERT INTO `book` VALUES ('9787545912050', '《微小的命运》', '李静睿', '鹭江出版社', 36.00, '李静睿，出生于四川自贡，南京大学新闻系毕业，曾做八年法律记者，现专业写作。出版有短篇小说集《小城故事》、随笔集《愿你的道路漫长》、长篇小说《小镇姑娘》。', 99, 'https://img.alicdn.com/imgextra/i1/TB11J7CPVXXXXbTXXXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg', 'https://img.alicdn.com/imgextra/i4/2938395088/TB25I7LgwxlpuFjSszgXXcJdpXa_!!2938395088.jpg');
INSERT INTO `book` VALUES ('9787569931693', '《游牧民的世界史》', '杉山正明', '北京时代华文书局', 35.00, '《游牧民的世界史》（精装修订，《忽必烈的挑战》《疾驰的草原征服者：辽西夏金元》作者杉山正明重磅之作权威作者：日本研究草原民族与蒙古历史的首席专家；一种创见：游牧民是挑起“国家”的中坚力量，支撑了欧亚大陆历史发展；梁文道、腾讯文化、新周刊、新京报推荐', 99, 'http://img3m7.ddimg.cn/96/2/28481307-1_x_3.jpg', 'http://img59.ddimg.cn/99999990090117849.jpg');
INSERT INTO `book` VALUES ('9787520203418', '《DK科学历史百科全书》', '英国DK公司', '中国大百科全书出版社', 129.00, 'DK科学历史百科全书（一本关于科学发现和发明历史的终极视觉指南） \r\n \r\n一本关于科学发现和发明历史的终极视觉指南， 逐年跟随科学的故事，对主要科学理论和概念附以丰富插图的时间轴与详细文字解释。 以真正的全球视野将来自世界各地的科学故事汇集在一起。', 99, 'http://img3m9.ddimg.cn/17/36/27892079-1_x_2.jpg', 'http://img58.ddimg.cn/99999990037410418.jpg');
INSERT INTO `book` VALUES ('9787308161459', '《丝绸之路：一部全新的世界史》', '彼得·弗兰科潘', '浙江大学出版社', 64.00, ' 丝绸之路：一部全新的世界史（关心一带一路，必读丝绸之路） \r\n \r\n第十二届文津奖推荐图书！央视10分钟重磅推荐！《人民日报》4度推荐！新浪年度十大好书！牛津大学教授揭示“一带一路”倡议逻辑！第十二届文津图书奖推荐书目！豆瓣2016年度十大历史好书！读客熊猫君出品', 99, 'http://img3m0.ddimg.cn/32/5/24017630-1_x_16.jpg', 'http://img54.ddimg.cn/99999990077245544.jpg');
INSERT INTO `book` VALUES ('9787559417794', '《美国秩序的根基 》', '拉塞尔·柯克，张大军', '江苏凤凰文艺出版社', 69.00, '美国秩序的根基 \r\n \r\n从三千年西方文明史中归纳美国的精神根基/ 深入理解美国文明这一人类历史上的独特现象', 99, 'http://img3m5.ddimg.cn/80/8/25301015-2_x_5.jpg', 'http://img56.ddimg.cn/99999990003220886.jpg');
INSERT INTO `book` VALUES ('9787531579977', '《卖花小鹿》', '屠再华', '辽宁少年儿童出版社', 12.10, '卖花小鹿（手绘插图，教育部统编《语文》推荐阅读，与教材无缝对接） \r\n \r\n浙江省文学类“五个一工程”奖、文化部第三届蒲公英奖优秀作品奖和银奖得主屠再华经典童话集，献给孩子们的生动童话故事。教育部统编语文教材拓展阅读书目，适合2-5年级小学生阅读，舒朗排版，大字护眼，阅读不累', 99, 'http://img3m0.ddimg.cn/7/14/28492900-1_x_3.jpg', 'http://img56.ddimg.cn/99999990090137026.jpg');
INSERT INTO `book` VALUES ('9787531579970', '《成语》', '夏东海', '台海出版社', 14.30, '学成语 明事理 天地宽 八千里 小学生分级达标趣味阅读 基础教育*教学成果一等奖“小学语文课内海量阅读教学研究与实践”项目组、中国陶行知研究会“中小学课内海量阅读与核心素养培养研究”课题组联袂推荐 ', 99, 'http://img3m2.ddimg.cn/6/22/28495572-1_x_3.jpg', 'http://img56.ddimg.cn/99999990091366836.jpg');
INSERT INTO `book` VALUES ('9787201088822', '《人性的弱点》', '戴尔·卡耐基 ', '天津人民出版社', 16.00, '译自1937年初版，还原卡耐基38篇原始手稿，特别收录市面罕见的《创造奇迹的信》及《幸福家庭生活的七个法则》，全球第二大畅销书，销量仅次于《圣经》。被视为社交心理和沟通技巧的至高宝典。', 99, 'http://img3m0.ddimg.cn/23/18/23566280-1_x_4.jpg', 'http://img53.ddimg.cn/99999990003664403.jpg');
INSERT INTO `book` VALUES ('9787565650338', '《 1001英语单词大书》', 'DSNC新课标研究小组', '首都师范大学出版社', 34.30, '1001英语单词大书：单词大书里的蓝宝书 \r\n \r\n小升初单词库！历时三年创意打磨。涵盖小学英语新课标词汇、人教教材常考单词词组、英国小学高频词，给孩子需要的超一千单词库。附赠伦敦少年合唱团音频。英国皇家名校校长审定英语特级教师推荐(双螺旋童书馆)', 99, 'http://img3m1.ddimg.cn/30/19/28480251-1_x_6.jpg', 'http://img3m2.ddimg.cn/11/33/27951572-1_l_5.jpg');
INSERT INTO `book` VALUES ('9787505747500', '《栎树的囚徒》', '蒋韵 ', '中国友谊出版公司', 17.90, '栎树的囚徒（当当全国独家500本签名版随机发售 蒋韵自选集） \r\n \r\n女性大河小说，女性漂流的咏叹曲，美丽忧伤的家族故事。当代文坛重量级女作家蒋韵精品长篇处女作，附赠精美书签', 99, 'http://img3m5.ddimg.cn/35/1/28473425-1_x_3.jpg', 'http://img55.ddimg.cn/99999990089707485.jpg');
INSERT INTO `book` VALUES ('123123', 'asas', 'asdas', 'sada', 1.00, 'dasda', 12, NULL, NULL);
INSERT INTO `book` VALUES ('12345678888', 'asdasdasdasd', 'asdasd', 'asdasd', 12.00, 'asdasd', 45, NULL, NULL);
INSERT INTO `book` VALUES ('001323243234', '今天的日子', '群去问二', '阿萨德', 234.00, '阿萨德阿斯达速度', 23, '/youshu_System/imgs/1578354716.jpg', NULL);
INSERT INTO `book` VALUES ('2342342342', '今天的', '奥术大师多', '阿萨德', 1231.00, '阿萨德', 1231, NULL, NULL);
INSERT INTO `book` VALUES ('2423423234', '今天的', '的爱上', '啊啊啊啊', 12.00, '奥术大师大所多', 123, NULL, NULL);
INSERT INTO `book` VALUES ('23423423423', '奥术大师的啊', '阿萨德阿萨德', '阿萨德', 12.00, '阿萨德阿萨德', 1231, NULL, NULL);
INSERT INTO `book` VALUES ('9787302517597', 'Java从入门到精通去', '明日科技是', '清华大学出版社啊', 34.50, '这是一本好书', 77, NULL, NULL);
INSERT INTO `book` VALUES ('9787115281609', '锋利的jQuery', '单东林//张晓菲//魏然', ' 人民邮电出版社', 21.00, '《锋利的jQuery(第2版)》适合所有对jQuery技术感兴趣的Web设计者和前端开发人员阅读和参考。', 100, NULL, NULL);
INSERT INTO `book` VALUES ('21231231', '阿薩去asd', '阿薩但是a', 'a是啊是', 12.00, 'a 實打實阿薩', 123, NULL, NULL);
INSERT INTO `book` VALUES ('0011223344', '0011223344', '0011223344', '0011223344', 12.00, '001122334423', 23, NULL, NULL);

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module`  (
  `module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `module_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('loginTime', '2020-01-08 14:56:28');
INSERT INTO `module` VALUES ('loginTimeTemp', '2020-01-08 15:10:07');
INSERT INTO `module` VALUES ('totalvisit', '140');
INSERT INTO `module` VALUES ('dayvisit', '10');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `Order_NO` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `User_Id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Book_ISBN` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Order_Number` int(11) NOT NULL,
  `Order_Time` datetime(0) NOT NULL,
  `Order_Out` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Order_Return` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Logistics_No` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Order_Gotime` datetime(0) NULL DEFAULT NULL,
  `Order_Evaluate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Order_Evaltime` datetime(0) NULL DEFAULT NULL,
  `Receiver_Name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Receiver_Phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Receiver_Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Book_ISBN`, `Order_NO`) USING BTREE,
  INDEX `User_Id`(`User_Id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('10030', '12', '9787539998312', 2, '2020-01-04 13:09:51', '已发货', 'false', '773022673154468', '2020-01-08 14:11:22', NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10028', '12', '9787539998312', 2, '2020-01-03 19:16:29', '已取消', 'false', '858858', '2020-01-03 19:17:17', NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10026', '12', '9787514357806', 1, '2020-01-03 19:06:29', '已取消', 'false', '9879789897', '2020-01-05 13:12:51', NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10023', '12', '9787559817815', 1, '2020-01-03 15:25:12', '已评价', 'false', '787877', '2020-01-03 18:14:42', NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10025', '33', '9787539998312', 1, '2020-01-03 18:17:19', '已发货', 'false', '15615412', '2020-01-03 18:17:51', NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10025', '12', '9787559436658', 1, '2020-01-03 16:43:59', '已收货', 'false', '7878', '2020-01-03 17:40:54', NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10024', '12', '9787559436658', 1, '2020-01-03 17:06:51', '已评价', 'false', NULL, NULL, NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10024', '12', '9787514357806', 1, '2020-01-03 17:29:26', '已取消', 'false', '78789789789', '2020-01-03 18:14:52', 'hahha', '2020-01-08 08:29:23', 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10031', '12', '9787559436658', 4, '2020-01-07 11:02:02', '未发货', 'false', NULL, NULL, NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10031', '12', '9787514357806', 2, '2020-01-07 11:02:02', '未发货', 'false', NULL, NULL, NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10031', '12', '9787559631886', 1, '2020-01-07 11:02:02', '未发货', 'false', NULL, NULL, NULL, NULL, 'cc', '11111111111', 'cccccc');
INSERT INTO `orders` VALUES ('10032', '12', '9787559631886', 1, '2020-01-08 08:27:42', '未发货', 'false', NULL, NULL, NULL, NULL, 'cc', '11111111111', 'cccccc');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `ISBN` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `Path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `tip` int(2) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('0011223344', 'img/upload/1578391962876f9683f1c-7b40-4407-9ce5-703bd3cc204b.jpg', 1);
INSERT INTO `picture` VALUES ('0011223344', 'img/upload/1578391962877a45f34c7-c8c2-4f3b-818d-104063e8c198.jpg', 2);
INSERT INTO `picture` VALUES ('21231231', 'img/upload/1578392601192206ce54f-d205-4782-ba6a-d2a39b3ecbae.jpg', 1);
INSERT INTO `picture` VALUES ('9787302517597', 'img/upload/15784671774337c4fa69f-2c06-4344-a842-b490ed707592.jpg', 1);
INSERT INTO `picture` VALUES ('9787302517597', 'img/upload/15784671774360519911d-f745-4c06-8df0-1a98248aaf19.jpg', 2);

-- ----------------------------
-- Table structure for receiver
-- ----------------------------
DROP TABLE IF EXISTS `receiver`;
CREATE TABLE `receiver`  (
  `Receiver_Name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Receiver_Phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Receiver_Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `User_Id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Receiver_Address`, `Receiver_Name`, `Receiver_Phone`, `User_Id`) USING BTREE,
  INDEX `User_Id`(`User_Id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of receiver
-- ----------------------------
INSERT INTO `receiver` VALUES ('1', '1', '1', '12');
INSERT INTO `receiver` VALUES ('11111', '1111111111', '111111111111', '01a');
INSERT INTO `receiver` VALUES ('1111', '11111111111', '1111111111111', '01a');
INSERT INTO `receiver` VALUES ('11111', '11111111111', '1111111111111', '01a');
INSERT INTO `receiver` VALUES ('aaaa', '11111111111', '1111133333', '01a');
INSERT INTO `receiver` VALUES ('cc', '111111111', '154', '12');
INSERT INTO `receiver` VALUES ('2', '22', '2', '12');
INSERT INTO `receiver` VALUES ('12', '12345676432', 'ç', '12');
INSERT INTO `receiver` VALUES ('tt', '11111111111', 'gg', '12');
INSERT INTO `receiver` VALUES ('hhh', '10086      ', 'guangdongsheng', '1234');
INSERT INTO `receiver` VALUES ('aa', '11111111111', 'hh', '12');
INSERT INTO `receiver` VALUES ('cc', '11111111111', '地址', '12');
INSERT INTO `receiver` VALUES ('aaa', '11111111111', '地址 17', '12');
INSERT INTO `receiver` VALUES ('刘备', '15478954632', '地址2', '02a');
INSERT INTO `receiver` VALUES ('诸葛亮', '15496321548', '地址3', '01a');
INSERT INTO `receiver` VALUES ('孙权', '13954625481', '地址4', '04a');
INSERT INTO `receiver` VALUES ('关羽', '18963254875', '地址5', '05a');
INSERT INTO `receiver` VALUES ('张飞', '13564589784', '地址6', '06a');
INSERT INTO `receiver` VALUES ('赵云', '15935784852', '地址7', '07a');
INSERT INTO `receiver` VALUES ('乐进', '13245615241', '地址8', '08a');
INSERT INTO `receiver` VALUES ('曹仁', '13524789654', '地址9', '09a');
INSERT INTO `receiver` VALUES ('老大', '13800', '实打实的', '1234');
INSERT INTO `receiver` VALUES ('曹操', '13564879521', '广东省东莞市寮步镇文昌路一号', '01a');
INSERT INTO `receiver` VALUES ('曹操', '13564879521', '广东省东莞市寮步镇文昌路一号', '03a');

-- ----------------------------
-- Table structure for temporar
-- ----------------------------
DROP TABLE IF EXISTS `temporar`;
CREATE TABLE `temporar`  (
  `User_Id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Book_ISBN` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Temporar_Number` int(11) NOT NULL,
  PRIMARY KEY (`Book_ISBN`, `User_Id`) USING BTREE,
  INDEX `User_Id`(`User_Id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of temporar
-- ----------------------------
INSERT INTO `temporar` VALUES ('1234', '123456789', 2);
INSERT INTO `temporar` VALUES ('01a', '9787208061644', 2);
INSERT INTO `temporar` VALUES ('02a', '9876540144852', 2);
INSERT INTO `temporar` VALUES ('01a', '9851475632014', 1);
INSERT INTO `temporar` VALUES ('03a', '9632587412548', 1);
INSERT INTO `temporar` VALUES ('04a', '9877456358974', 2);
INSERT INTO `temporar` VALUES ('04a', '9876540144852', 1);
INSERT INTO `temporar` VALUES ('05a', '9632587412589', 1);
INSERT INTO `temporar` VALUES ('06a', '9632587412589', 2);
INSERT INTO `temporar` VALUES ('07a', '9637412584578', 1);
INSERT INTO `temporar` VALUES ('08a', '9632587412548', 10);
INSERT INTO `temporar` VALUES ('12', '9851475632014', 1);
INSERT INTO `temporar` VALUES ('12', '9787208061644', 1);
INSERT INTO `temporar` VALUES ('null', '9787517077121', 1);
INSERT INTO `temporar` VALUES ('33', '9787559436658', 1);
INSERT INTO `temporar` VALUES ('12', '9787559631886', 1);
INSERT INTO `temporar` VALUES ('null', '9787559436658', 1);
INSERT INTO `temporar` VALUES ('12', '9787559434937', 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `User_Id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `User_Pw` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `User_Sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Nick` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`User_Id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('10086', '10086', '女', 'Penguin', '2020-01-08');
INSERT INTO `users` VALUES ('01a', '01a', '女', '01', '2020-01-03');
INSERT INTO `users` VALUES ('02a', '02a', '男', '02a', '2020-01-02');
INSERT INTO `users` VALUES ('03a', '03a', '男', '03a', '2020-01-02');
INSERT INTO `users` VALUES ('04a', '04a', '男', '04a', '2020-01-02');
INSERT INTO `users` VALUES ('05a', '05a', '男', '05a', '2020-01-01');
INSERT INTO `users` VALUES ('06a', '06a', '男', '06a', '2019-12-31');
INSERT INTO `users` VALUES ('07a', '07a', '男', '07a', '2019-12-31');
INSERT INTO `users` VALUES ('08a', '08a', '男', '08a', '2019-12-31');
INSERT INTO `users` VALUES ('09a', '09a', '男', '09a', '2019-12-30');
INSERT INTO `users` VALUES ('10a', '10a', '男', '10a', '2019-12-30');
INSERT INTO `users` VALUES ('f', 'f', '女', 'ffff', '2019-12-29');
INSERT INTO `users` VALUES ('a', 'a', '女', 'aaaaa', '2019-12-28');
INSERT INTO `users` VALUES ('123', '123', '女', '222', '2019-12-27');
INSERT INTO `users` VALUES ('3', '3', '女', '3', '2019-12-26');
INSERT INTO `users` VALUES ('12', '12', '女', 'twelve', '2019-12-25');
INSERT INTO `users` VALUES ('33', '33', '女', '333333', '2020-01-08');

-- ----------------------------
-- Table structure for visitcount
-- ----------------------------
DROP TABLE IF EXISTS `visitcount`;
CREATE TABLE `visitcount`  (
  `riqi` date NULL DEFAULT '0000-00-00',
  `counter` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of visitcount
-- ----------------------------
INSERT INTO `visitcount` VALUES ('2020-01-07', 33);
INSERT INTO `visitcount` VALUES ('2020-01-06', 22);
INSERT INTO `visitcount` VALUES ('2020-01-05', 20);
INSERT INTO `visitcount` VALUES ('2020-01-04', 15);
INSERT INTO `visitcount` VALUES ('2020-01-03', 25);
INSERT INTO `visitcount` VALUES ('2020-01-02', 17);
INSERT INTO `visitcount` VALUES ('2020-01-01', 24);

-- ----------------------------
-- View structure for v_adminevaluate
-- ----------------------------
DROP VIEW IF EXISTS `v_adminevaluate`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_adminevaluate` AS select `orders`.`Order_NO` AS `Order_NO`,`orders`.`Book_ISBN` AS `Book_ISBN`,`orders`.`Order_Evaluate` AS `Order_evaluate`,`orders`.`Order_Evaltime` AS `Order_Evaltime` from `orders` where (`orders`.`Order_Evaluate` is not null);

-- ----------------------------
-- View structure for v_adminorder
-- ----------------------------
DROP VIEW IF EXISTS `v_adminorder`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_adminorder` AS select distinct `orders`.`Order_NO` AS `Order_NO`,`orders`.`User_Id` AS `User_Id`,`book`.`Book_Name` AS `Book_Name`,`orders`.`Book_ISBN` AS `Book_ISBN`,round((10 + (`book`.`Book_Price` * `orders`.`Order_Number`)),2) AS `Total`,concat(`orders`.`Receiver_Name`,' ',`orders`.`Receiver_Phone`,' ',`orders`.`Receiver_Address`) AS `Address`,`orders`.`Logistics_No` AS `Logistics_No`,(case when (`orders`.`Order_Return` = 'true') then '退货中' when (`orders`.`Order_Return` = 'false') then `orders`.`Order_Out` end) AS `Status`,`orders`.`Order_Time` AS `Order_Time` from (`orders` join `book`) where (`orders`.`Book_ISBN` = `book`.`Book_ISBN`);

-- ----------------------------
-- View structure for v_adminsales
-- ----------------------------
DROP VIEW IF EXISTS `v_adminsales`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_adminsales` AS select sum(`v_adminorder`.`Total`) AS `Amount` from `v_adminorder`;

-- ----------------------------
-- View structure for v_count
-- ----------------------------
DROP VIEW IF EXISTS `v_count`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_count` AS select distinct (select count(0) from `book`) AS `book`,(select count(0) from `orders`) AS `orders`,(select count(0) from `users`) AS `users` from ((`book` join `orders`) join `users`);

-- ----------------------------
-- View structure for v_usercart
-- ----------------------------
DROP VIEW IF EXISTS `v_usercart`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_usercart` AS select `temporar`.`User_Id` AS `User_Id`,`temporar`.`Book_ISBN` AS `Book_ISBN`,`book`.`Book_Name` AS `Book_Name`,`book`.`Book_Price` AS `Book_Price`,`temporar`.`Temporar_Number` AS `Temporar_Number`,round((`book`.`Book_Price` * `temporar`.`Temporar_Number`),2) AS `Total` from ((`book` join `temporar`) join `users`) where ((`book`.`Book_ISBN` = `temporar`.`Book_ISBN`) and (`temporar`.`User_Id` = `users`.`User_Id`));

-- ----------------------------
-- View structure for v_userevaluate
-- ----------------------------
DROP VIEW IF EXISTS `v_userevaluate`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_userevaluate` AS select `orders`.`Order_NO` AS `Order_NO`,`orders`.`Book_ISBN` AS `Book_ISBN`,`orders`.`Order_Evaluate` AS `Order_evaluate`,`orders`.`Order_Evaltime` AS `Order_Evaltime` from `orders` where (`orders`.`Order_Evaluate` is not null);

-- ----------------------------
-- View structure for v_userorder
-- ----------------------------
DROP VIEW IF EXISTS `v_userorder`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_userorder` AS select distinct `orders`.`Order_NO` AS `Order_NO`,`orders`.`User_Id` AS `User_Id`,`orders`.`Book_ISBN` AS `Book_ISBN`,`book`.`Book_Name` AS `Book_Name`,`book`.`Book_Price` AS `Book_Price`,`orders`.`Order_Number` AS `Order_Number`,`orders`.`Order_Time` AS `Order_Time`,`orders`.`Order_Time` AS `Pay_Time`,`orders`.`Order_Gotime` AS `Order_Gotime`,`orders`.`Logistics_No` AS `Logistics_No`,(case when (`orders`.`Order_Return` = 'true') then '退货中' when (`orders`.`Order_Return` = 'false') then `orders`.`Order_Out` end) AS `Status`,10 AS `Charge`,round((10 + (`book`.`Book_Price` * `orders`.`Order_Number`)),2) AS `Total`,concat(`orders`.`Receiver_Name`,' ',`orders`.`Receiver_Phone`,' ',`orders`.`Receiver_Address`) AS `Address` from (`orders` join `book`) where (`orders`.`Book_ISBN` = `book`.`Book_ISBN`) order by `orders`.`Order_NO`;

-- ----------------------------
-- Procedure structure for visit_insert
-- ----------------------------
DROP PROCEDURE IF EXISTS `visit_insert`;
delimiter ;;
CREATE PROCEDURE `visit_insert`()
BEGIN
  declare cdn int ;
  select module_value into @cdn from module where module_name='dayvisit';
  INSERT INTO visitcount VALUES(now(), @cdn);
  update module set module_value=0 where module_name='dayvisit';
  DELETE from visitcount where to_days(NOW()) - TO_DAYS(riqi) >7 ;
END
;;
delimiter ;

-- ----------------------------
-- Event structure for task
-- ----------------------------
DROP EVENT IF EXISTS `task`;
delimiter ;;
CREATE EVENT `task`
ON SCHEDULE
EVERY '1' DAY STARTS '2020-01-08 08:05:48'
DO call visit_insert()
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
