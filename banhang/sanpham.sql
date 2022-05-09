-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 09, 2022 lúc 10:49 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dataonline`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `hinhanh`) VALUES
(1, 'Physiolac', 'https://media.bibomart.com.vn/resize.1170x-/media/catalog/product/h/t/httpsmedia.bibomart.netubbmproduct201608092122sua-physiolac-so-1-400g-100835_1.jpg'),
(2, 'PediaSure', 'https://vn-live-01.slatic.net/p/7b2357baf7b9e90fcc55b90cba3d0750.jpg'),
(3, 'Dielac Alpha', 'http://product.hstatic.net/1000074072/product/step_1_900g_81f39d09632f48cba2da4bcc49a436b0_grande.jpg'),
(4, 'Aptamil', 'https://cdn.kidsplaza.vn/media/wysiwyg/product/suabotchobe/sua-aptamil-duc-so-1-hop-800g-nutricia-1.jpg'),
(5, 'Nan Optipro', 'https://tuoithobencon.vn/wp-content/uploads/2020/06/sua-nan-nga-so-1-800g-300x300.jpg'),
(6, 'Glucerna', 'https://trungtamthuoc.com/images/item/Sua_abbott_glucerna.jpg'),
(7, 'Ông Thọ', 'https://gamek.mediacdn.vn/thumb_w/640/133514250583805952/2021/1/15/sua-ong-tho-co-may-loai-va-chung-khac-nhau-the-nao-201909180806182023-16106999719951549650709.jpg'),
(8, 'Vinamilk 180ml', 'https://cdn.tgdd.vn/Products/Images/2386/80604/bhx/loc-4-hop-sua-tuoi-it-duong-vinamilk-100-sua-tuoi-180ml-202104140025452343.jpg'),
(9, 'Vinamilk 110ml', 'https://cdn.tgdd.vn/Products/Images/2386/80481/bhx/loc-4-hop-sua-tuoi-co-duong-vinamilk-100-sua-tuoi-110ml-202104111619235389.jpg'),
(10, 'Cô Gái Hà Lan', 'https://minhcaumart.vn/media/com_eshop/products/8934841321104.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
