/*
Navicat MySQL Data Transfer

Source Server         : KieuOanh_MySQL
Source Server Version : 100134
Source Host           : localhost:3306
Source Database       : da_java

Target Server Type    : MYSQL
Target Server Version : 100134
File Encoding         : 65001

Date: 2019-03-24 16:23:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hoadon
-- ----------------------------
DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE `hoadon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maHoaDon` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `makhachHang` int(11) DEFAULT NULL,
  `maSach` int(11) DEFAULT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `ngayLap` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_HD_KH` (`makhachHang`),
  KEY `maSach` (`maSach`),
  KEY `maHoaDon` (`maHoaDon`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hoadon
-- ----------------------------
INSERT INTO `hoadon` VALUES ('1', 'HD001', '1', '1', '3', '20/3/2019');
INSERT INTO `hoadon` VALUES ('2', 'HD002', '1', '1', '10', '23/3/2019');

-- ----------------------------
-- Table structure for khachhang
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diaChi` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soDienThoai` int(10) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tienNo` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khachhang
-- ----------------------------
INSERT INTO `khachhang` VALUES ('1', 'Nguyễn Văn A', 'Q5, TP HCM', '12345678', 'A@gmail.com', '1230');

-- ----------------------------
-- Table structure for loainguoidung
-- ----------------------------
DROP TABLE IF EXISTS `loainguoidung`;
CREATE TABLE `loainguoidung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenLoaiNguoiDung` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of loainguoidung
-- ----------------------------
INSERT INTO `loainguoidung` VALUES ('1', 'Admin');
INSERT INTO `loainguoidung` VALUES ('2', 'Thu Ngân');
INSERT INTO `loainguoidung` VALUES ('3', 'Thủ Kho');

-- ----------------------------
-- Table structure for nhapsach
-- ----------------------------
DROP TABLE IF EXISTS `nhapsach`;
CREATE TABLE `nhapsach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ngayNhap` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `maSach` int(11) DEFAULT NULL,
  `soLuongTon` int(11) DEFAULT NULL,
  `soLuongNhap` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_NS_S` (`maSach`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhapsach
-- ----------------------------
INSERT INTO `nhapsach` VALUES ('1', '23/3/2019', '1', '0', '15');

-- ----------------------------
-- Table structure for quydinh
-- ----------------------------
DROP TABLE IF EXISTS `quydinh`;
CREATE TABLE `quydinh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nhaptoithieu` int(11) DEFAULT NULL,
  `tonToiThieuNhap` int(11) DEFAULT NULL,
  `tonToiThieuBan` int(11) DEFAULT NULL,
  `tienNoToiDa` decimal(11,0) DEFAULT NULL,
  `hieuLuc` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of quydinh
-- ----------------------------

-- ----------------------------
-- Table structure for sach
-- ----------------------------
DROP TABLE IF EXISTS `sach`;
CREATE TABLE `sach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenSach` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `theLoai` int(11) DEFAULT NULL,
  `tacGia` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `donGia` decimal(11,0) DEFAULT NULL,
  `soLuong` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SACH_THELOAI` (`theLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sach
-- ----------------------------
INSERT INTO `sach` VALUES ('1', 'Tôi thấy hoa vàng trên cỏ xanh', '1', 'Nguyễn Nhật á', '50', '2');

-- ----------------------------
-- Table structure for taikhoan
-- ----------------------------
DROP TABLE IF EXISTS `taikhoan`;
CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenDangNhap` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `matKhau` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loaiNguoiDung` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `loaiNguoiDung` (`loaiNguoiDung`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of taikhoan
-- ----------------------------
INSERT INTO `taikhoan` VALUES ('1', 'Nguyễn Thị Kiều Oanh', '1234567', '1');
INSERT INTO `taikhoan` VALUES ('2', 'Võ Thị Ngọc Giàu', '1234567', '1');
INSERT INTO `taikhoan` VALUES ('3', 'Nguyễn Văn A', '1234', '2');
INSERT INTO `taikhoan` VALUES ('4', 'Lê Văn Lan', '1234', '3');

-- ----------------------------
-- Table structure for theloai
-- ----------------------------
DROP TABLE IF EXISTS `theloai`;
CREATE TABLE `theloai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenTheLoai` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of theloai
-- ----------------------------
INSERT INTO `theloai` VALUES ('1', 'Tiểu Thuyết');
INSERT INTO `theloai` VALUES ('2', 'Khoa Học Viễn Tưởng');
INSERT INTO `theloai` VALUES ('3', 'Truyện Tranh');
INSERT INTO `theloai` VALUES ('4', 'Lịch sử');
INSERT INTO `theloai` VALUES ('5', 'Khoa Học');

-- ----------------------------
-- Table structure for thutien
-- ----------------------------
DROP TABLE IF EXISTS `thutien`;
CREATE TABLE `thutien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maHoaDon` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tienMua` decimal(11,0) DEFAULT NULL,
  `tienThu` decimal(11,0) DEFAULT NULL,
  `noCu` decimal(11,0) DEFAULT NULL,
  `ngayThu` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_THUTIEN_HD` (`maHoaDon`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of thutien
-- ----------------------------
INSERT INTO `thutien` VALUES ('1', 'HD001', '50', '60', '10', '23/3/2019');
SET FOREIGN_KEY_CHECKS=1;
