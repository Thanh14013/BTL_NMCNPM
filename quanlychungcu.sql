-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 30, 2024 lúc 10:25 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlychungcu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hokhau`
--

CREATE TABLE `hokhau` (
  `mahokhau` int(11) NOT NULL,
  `sothanhvien` int(11) NOT NULL,
  `diachi` varchar(100) NOT NULL,
  `machuho` int(11) NOT NULL,
  `tenchuho` varchar(50) NOT NULL,
  `dientich` double NOT NULL,
  `sloto` int(11) NOT NULL,
  `slxemay` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hokhau`
--

INSERT INTO `hokhau` (`mahokhau`, `sothanhvien`, `diachi`, `machuho`, `tenchuho`, `dientich`, `sloto`, `slxemay`) VALUES
(1, 3, 'P110', 0, 'Bùi Thị J', 52, 1, 1),
(2, 3, 'P101', 1, 'Nguyễn Văn A', 55.5, 1, 1),
(3, 4, 'P102', 2, 'Lê Thị B', 70, 2, 2),
(4, 2, 'P103', 3, 'Phạm Văn C', 40, 1, 0),
(5, 3, 'P104', 4, 'Trần Thị D', 55.5, 1, 1),
(6, 2, 'P105', 5, 'Hoàng Văn E', 45, 1, 1),
(7, 4, 'P106', 6, 'Đỗ Thị F', 60, 2, 2),
(8, 3, 'P107', 7, 'Ngô Văn G', 52, 1, 0),
(9, 4, 'P108', 8, 'Vũ Thị H', 75, 2, 2),
(10, 2, 'P109', 9, 'Phan Văn I', 35.5, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hokhau_khoanphi`
--

CREATE TABLE `hokhau_khoanphi` (
  `mahokhau` int(11) NOT NULL,
  `makhoanphi` int(11) NOT NULL,
  `sotien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hokhau_khoanphi`
--

INSERT INTO `hokhau_khoanphi` (`mahokhau`, `makhoanphi`, `sotien`) VALUES
(1, 1, 260000),
(1, 2, 364000),
(1, 3, 0),
(1, 4, 70000),
(1, 5, 1200000),
(1, 6, 0),
(2, 1, 277500),
(2, 2, 388500),
(2, 3, 0),
(2, 4, 70000),
(2, 5, 1200000),
(2, 6, 0),
(3, 1, 350000),
(3, 2, 490000),
(3, 3, 0),
(3, 4, 140000),
(3, 5, 2400000),
(3, 6, 0),
(4, 1, 200000),
(4, 2, 280000),
(4, 3, 0),
(4, 4, 0),
(4, 5, 1200000),
(4, 6, 0),
(5, 1, 277500),
(5, 2, 388500),
(5, 3, 0),
(5, 4, 70000),
(5, 5, 1200000),
(5, 6, 0),
(6, 1, 225000),
(6, 2, 315000),
(6, 3, 0),
(6, 4, 70000),
(6, 5, 1200000),
(6, 6, 0),
(7, 1, 300000),
(7, 2, 420000),
(7, 3, 0),
(7, 4, 140000),
(7, 5, 2400000),
(7, 6, 0),
(8, 1, 260000),
(8, 2, 364000),
(8, 3, 0),
(8, 4, 0),
(8, 5, 1200000),
(8, 6, 0),
(9, 1, 375000),
(9, 2, 525000),
(9, 3, 0),
(9, 4, 140000),
(9, 5, 2400000),
(9, 6, 0),
(10, 1, 177500),
(10, 2, 248500),
(10, 3, 0),
(10, 4, 0),
(10, 5, 1200000),
(10, 6, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoanphi`
--

CREATE TABLE `khoanphi` (
  `makhoanphi` int(11) NOT NULL,
  `tenkhoanphi` varchar(50) NOT NULL,
  `sotien` double NOT NULL,
  `loaikhoanphi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khoanphi`
--

INSERT INTO `khoanphi` (`makhoanphi`, `tenkhoanphi`, `sotien`, `loaikhoanphi`) VALUES
(1, 'Dịch vụ chung cư', 5000, 'Bắt buộc'),
(2, 'Quản lý chung cư', 7000, 'Bắt buộc'),
(3, 'Tình nguyện', 0, 'Tự nguyện'),
(4, 'Gửi xe máy', 70000, 'Bắt buộc'),
(5, 'Gửi ô tô', 1200000, 'Bắt buộc'),
(6, 'Tiện ích hàng tháng', 0, 'Bắt buộc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lichsu`
--

CREATE TABLE `lichsu` (
  `mahokhau` int(11) NOT NULL,
  `tennguoidong` varchar(100) NOT NULL,
  `ngaydong` date NOT NULL,
  `sotien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `lichsu`
--

INSERT INTO `lichsu` (`mahokhau`, `tennguoidong`, `ngaydong`, `sotien`) VALUES
(2, 'Nguyen Vu Thanh', '2024-12-30', 1),
(4, 'Nguyen Hoang Chien', '2024-12-30', 1),
(6, 'Nguyen Vu Thanh', '2024-12-30', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhankhau`
--

CREATE TABLE `nhankhau` (
  `manhankhau` int(11) NOT NULL,
  `hoten` varchar(100) NOT NULL,
  `ngaysinh` date NOT NULL,
  `CMND` varchar(50) NOT NULL,
  `SĐT` varchar(20) NOT NULL,
  `mahokhau` int(11) NOT NULL,
  `tinhtrang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhankhau`
--

INSERT INTO `nhankhau` (`manhankhau`, `hoten`, `ngaysinh`, `CMND`, `SĐT`, `mahokhau`, `tinhtrang`) VALUES
(1, 'Nguyễn Văn A1', '1990-05-01', '0123456789', '0912345678', 1, 'Đang sinh sống'),
(2, 'Nguyễn Văn A2', '1995-09-15', '1123456789', '0923456789', 1, 'Tạm trú'),
(3, 'Nguyễn Văn A3', '2000-11-20', '2123456789', '0934567890', 1, 'Tạm vắng'),
(4, 'Lê Thị B1', '1985-03-12', '3123456789', '0945678901', 2, 'Đang sinh sống'),
(5, 'Lê Thị B2', '1993-07-25', '4123456789', '0956789012', 2, 'Tạm trú'),
(6, 'Lê Thị B3', '1998-02-18', '5123456789', '0967890123', 2, 'Đang sinh sống'),
(7, 'Lê Thị B4', '2002-12-05', '6123456789', '0978901234', 2, 'Tạm vắng'),
(8, 'Phạm Văn C1', '1991-06-08', '7123456789', '0989012345', 3, 'Tạm trú'),
(9, 'Phạm Văn C2', '1996-10-30', '8123456789', '0990123456', 3, 'Đang sinh sống'),
(10, 'Trần Thị D1', '1988-04-21', '9123456789', '0911234567', 4, 'Đang sinh sống'),
(11, 'Trần Thị D2', '1994-08-11', '0132456789', '0922345678', 4, 'Tạm trú'),
(12, 'Trần Thị D3', '2001-01-15', '1132456789', '0933456789', 4, 'Tạm vắng'),
(13, 'Hoàng Văn E1', '1989-02-17', '2132456789', '0944567890', 5, 'Đang sinh sống'),
(14, 'Hoàng Văn E2', '1997-05-29', '3132456789', '0955678901', 5, 'Tạm trú'),
(15, 'Đỗ Thị F1', '1992-03-13', '4132456789', '0966789012', 6, 'Tạm vắng'),
(16, 'Đỗ Thị F2', '1999-09-07', '5132456789', '0977890123', 6, 'Đang sinh sống'),
(17, 'Đỗ Thị F3', '2003-07-23', '6132456789', '0988901234', 6, 'Tạm trú'),
(18, 'Đỗ Thị F4', '2005-06-14', '7132456789', '0999012345', 6, 'Đang sinh sống'),
(19, 'Ngô Văn G1', '1990-08-25', '8132456789', '0910123456', 7, 'Tạm vắng'),
(20, 'Ngô Văn G2', '1995-01-11', '9132456789', '0921234567', 7, 'Đang sinh sống'),
(21, 'Ngô Văn G3', '1998-03-22', '0143456789', '0932345678', 7, 'Tạm trú'),
(22, 'Vũ Thị H1', '1987-12-01', '1143456789', '0943456789', 8, 'Đang sinh sống'),
(23, 'Vũ Thị H2', '1992-05-08', '2143456789', '0954567890', 8, 'Tạm trú'),
(24, 'Vũ Thị H3', '2004-08-17', '3143456789', '0965678901', 8, 'Đang sinh sống'),
(25, 'Vũ Thị H4', '2006-10-09', '4143456789', '0976789012', 8, 'Tạm vắng'),
(26, 'Phan Văn I1', '1986-06-30', '5143456789', '0987890123', 9, 'Tạm trú'),
(27, 'Phan Văn I2', '1999-02-19', '6143456789', '0998901234', 9, 'Đang sinh sống'),
(28, 'Bùi Thị J1', '1984-07-13', '7143456789', '0919012345', 10, 'Tạm vắng'),
(29, 'Bùi Thị J2', '1997-11-26', '8143456789', '0920123456', 10, 'Đang sinh sống'),
(30, 'Bùi Thị J3', '2002-01-01', '9143456789', '0931234567', 10, 'Tạm trú');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `hoten` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`username`, `password`, `hoten`, `email`) VALUES
('thanh123', '123', 'nguyen vu thanh', 'thanh14704@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongke`
--

CREATE TABLE `thongke` (
  `mahokhau` int(11) NOT NULL,
  `tenchuho` varchar(50) NOT NULL,
  `tongsotien` double NOT NULL,
  `conlai` double NOT NULL,
  `tungay` date NOT NULL,
  `dengay` date NOT NULL,
  `tinhtrang` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `thongke`
--

INSERT INTO `thongke` (`mahokhau`, `tenchuho`, `tongsotien`, `conlai`, `tungay`, `dengay`, `tinhtrang`) VALUES
(1, 'Bùi Thị J', 1894000, 2066895, '2024-12-02', '2024-12-24', 'Chưa Thanh Toán'),
(2, 'Nguyễn Văn A', 1936000, 2011530, '2024-12-02', '2024-12-24', 'Thanh Toán 1 Phần'),
(3, 'Lê Thị B', 3380000, 3489272, '2024-12-02', '2024-12-24', 'Chưa Thanh Toán'),
(4, 'Phạm Văn C', 1680000, 1906399, '2024-12-02', '2024-12-24', 'Thanh Toán 1 Phần'),
(5, 'Trần Thị D', 1936000, 2084158, '2024-12-02', '2024-12-24', 'Chưa Thanh Toán'),
(6, 'Hoàng Văn E', 1810000, 1917415, '2024-12-02', '2024-12-24', 'Đã Thanh Toán'),
(7, 'Đỗ Thị F', 3260000, 3397478, '2024-12-02', '2024-12-24', 'Chưa Thanh Toán'),
(8, 'Ngô Văn G', 1824000, 1999352, '2024-12-02', '2024-12-24', 'Chưa Thanh Toán'),
(9, 'Vũ Thị H', 3440000, 3564388, '2024-12-02', '2024-12-24', 'Chưa Thanh Toán'),
(10, 'Phan Văn I', 1626000, 1741217, '2024-12-02', '2024-12-24', 'Chưa Thanh Toán');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  ADD PRIMARY KEY (`mahokhau`);

--
-- Chỉ mục cho bảng `khoanphi`
--
ALTER TABLE `khoanphi`
  ADD PRIMARY KEY (`makhoanphi`);

--
-- Chỉ mục cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  ADD PRIMARY KEY (`manhankhau`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `thongke`
--
ALTER TABLE `thongke`
  ADD PRIMARY KEY (`mahokhau`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  MODIFY `manhankhau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
