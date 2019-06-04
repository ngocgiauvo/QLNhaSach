-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 02, 2019 at 01:25 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlnhasach`
--

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE IF NOT EXISTS `hoadon` (
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`id`, `maHoaDon`, `makhachHang`, `maSach`, `soLuong`, `ngayLap`) VALUES
(1, 'HD001', 1, 1, 3, '20/3/2019'),
(2, 'HD002', 1, 1, 10, '23/3/2019'),
(3, 'HD20190526114505', 1, 1, 1, '20190526'),
(4, 'HD20190526114855', 1, 1, 6, '20190527'),
(5, 'HD20190527121302', 1, 1, 1, '20190527'),
(6, 'HD20190527121302', 1, 1, 1, '20190527'),
(7, 'HD20190530031153', 1, 2, 10, '20190530');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diaChi` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soDienThoai` int(10) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tienNo` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`id`, `hoTen`, `diaChi`, `soDienThoai`, `email`, `tienNo`) VALUES
(1, 'Vo Thi Ngoc Giau', 'Nguyen Cu Trinh, Q.1', 12345678, 'ngocgiau18tqdn@gmail.com', '9000'),
(2, 'Nguyen Thi Kieu Oanh', 'Q5', 3139892, 'oanh@gmail.com', '30000'),
(3, 'Nguyen Van A', 'Tokyo', 1298494923, 'iwantgotojp@gmail.com', '0');

-- --------------------------------------------------------

--
-- Table structure for table `loainguoidung`
--

DROP TABLE IF EXISTS `loainguoidung`;
CREATE TABLE IF NOT EXISTS `loainguoidung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenLoaiNguoiDung` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loainguoidung`
--

INSERT INTO `loainguoidung` (`id`, `tenLoaiNguoiDung`) VALUES
(1, 'Admin'),
(2, 'Thu Ngân'),
(3, 'Thủ Kho');

-- --------------------------------------------------------

--
-- Table structure for table `nhapsach`
--

DROP TABLE IF EXISTS `nhapsach`;
CREATE TABLE IF NOT EXISTS `nhapsach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ngayNhap` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `maSach` int(11) DEFAULT NULL,
  `soLuongTon` int(11) DEFAULT NULL,
  `soLuongNhap` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_NS_S` (`maSach`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhapsach`
--

INSERT INTO `nhapsach` (`id`, `ngayNhap`, `maSach`, `soLuongTon`, `soLuongNhap`) VALUES
(3, '20190625', 1, 0, 150),
(4, '20190525', 1, 150, 150),
(5, '20190530', 2, 100, 150);

-- --------------------------------------------------------

--
-- Table structure for table `quydinh`
--

DROP TABLE IF EXISTS `quydinh`;
CREATE TABLE IF NOT EXISTS `quydinh` (
  `id` int(11) NOT NULL,
  `tenQuyDinh` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiDung` int(11) DEFAULT NULL,
  `hieuLuc` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `quydinh`
--

INSERT INTO `quydinh` (`id`, `tenQuyDinh`, `noiDung`, `hieuLuc`) VALUES
(1, 'nhap_toi_thieu', 150, 1),
(2, 'ton_toi_thieu_nhap', 300, 1),
(3, 'tien_no_toi_da', 20000, 1),
(4, 'ton_toi_thieu_ban', 20, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
CREATE TABLE IF NOT EXISTS `sach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenSach` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `theLoai` int(11) DEFAULT NULL,
  `tacGia` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `donGia` decimal(11,0) DEFAULT NULL,
  `soLuong` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SACH_THELOAI` (`theLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`id`, `tenSach`, `theLoai`, `tacGia`, `donGia`, `soLuong`) VALUES
(1, 'Toi thay hoa vang tren co xanh', 1, 'Nguyen Nhat Anh', '5000', 292),
(2, 'Tam quoc dien nghia', 2, 'La Quan Trung', '9000', 240);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenDangNhap` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `matKhau` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loaiNguoiDung` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `loaiNguoiDung` (`loaiNguoiDung`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `tenDangNhap`, `matKhau`, `loaiNguoiDung`) VALUES
(1, 'Nguyễn Thị Kiều Oanh', '1234567', 1),
(2, 'Võ Thị Ngọc Giàu', '1234567', 1),
(3, 'Nguyễn Văn A', '1234', 2),
(4, 'Lê Văn Lan', '1234', 3);

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

DROP TABLE IF EXISTS `theloai`;
CREATE TABLE IF NOT EXISTS `theloai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenTheLoai` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`id`, `tenTheLoai`) VALUES
(1, 'Tieu Thuyet'),
(2, 'Khoa Hoc Vien Tuong'),
(3, 'Truyen Tranh'),
(4, 'Lich Su'),
(5, 'Khoa Hoc');

-- --------------------------------------------------------

--
-- Table structure for table `thutien`
--

DROP TABLE IF EXISTS `thutien`;
CREATE TABLE IF NOT EXISTS `thutien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maKH` int(11) DEFAULT NULL,
  `tienThu` decimal(11,0) DEFAULT NULL,
  `ngayThu` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `thutien`
--

INSERT INTO `thutien` (`id`, `maKH`, `tienThu`, `ngayThu`) VALUES
(1, 1, '1000', '20190528');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
