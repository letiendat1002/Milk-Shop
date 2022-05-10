-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2022 at 04:16 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dataonline`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `tensanpham`, `hinhanh`) VALUES
(1, 'Trang chủ', 'https://ngochieu.name.vn/img/home.png'),
(2, 'Sữa tươi', 'https://tieudung.vn/upload_images/images/2021/12/14/sua-tuoi.jpg'),
(3, 'Sữa bột', 'https://5.imimg.com/data5/XZ/XO/XH/SELLER-67095120/amul-milk-powder-500x500.jpg'),
(4, 'Sữa đặc', 'https://static.toiimg.com/thumb/53222548.cms?imgsize=214293&width=800&height=800'),
(5, 'Liên hệ', 'https://ngochieu.name.vn/img/contact.png');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensp` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `giasp` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8_unicode_ci NOT NULL,
  `mota` text COLLATE utf8_unicode_ci NOT NULL,
  `loai` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensp`, `giasp`, `hinhanh`, `mota`, `loai`) VALUES
(1, 'Sữa tươi tiệt trùng có đường TH True Milk 110ml', '8000', 'https://www.thmilk.vn/wp-content/uploads/2019/11/UHT-110-CD-457x396.png', 'THÔNG TIN: \r\nSữa tươi tiệt trùng nguyên chất TH True Milk giúp cả gia đình tận hưởng trọn vẹn dưỡng chất tự nhiên từ sữa tươi mà không còn lo lắng các vấn đề về sức khoẻ khi sử dụng nhiều đường trong chế độ dinh dưỡng hàng ngày. \r\n\r\nĐẶC ĐIỂM NỔI BẬT:\r\n- Nguồn sữa tươi, sạch nguyên chất từ trang trại TH cùng công nghệ hiện đại \r\n- Mang đến sự đảm bảo tinh tuý thiên nhiên được giữ vẹn nguyên trong từng giọt sữa \r\n- Không chất bảo quản, phụ gia - Bao bì hiện đại, nhỏ gọn dễ dàng mang theo bên người. Dung tích 110ml phù hợp với nhu cầu sử dụng của cá nhân và cả gia đình \r\n\r\nTHÀNH PHẦN: \r\nSữa hoàn toàn từ sữa bò tươi (96%), đường (3,8%), hỗn hợp chất nhũ hoá và chất ổn định (E 471, E 407, E412)\r\n\r\nHƯỚNG DẪN SỬ DỤNG: \r\nSử dụng ngay sau khi mở Ngon hơn khi uống lạnh \r\n\r\nCÁCH BẢO QUẢN:\r\n- Xếp dỡ nhẹ nhàng, không chất cao quá 13 hoặc 14 lớp (vui lòng xem chi tiết trên bao bì thực tế) \r\n- Bảo quản nơi khô ráo và thoáng mát, tránh côn trùng gặm nhấm \r\n- Bao bì dễ bị tổn thương gây hư hỏng đến sản phẩm bên trong \r\n\r\nXuất xứ: Việt Nam \r\nNơi sản xuất: Việt Nam \r\nNgày sản xuất: 2/12/2021 0:00 \r\nHạn sử dụng: 2/6/2023 0:00 \r\nNhà sản xuất: CÔNG TY CỔ PHẦN CHUỖI THỰC PHẨM TH \r\nĐịa chỉ nhà sản xuất: Số 166, Đường Nguyễn Thái Học, Phường Quang Trung, TP. Vinh, Tỉnh Nghệ An', 1),
(2, 'Sữa Hạt và Nghệ TH True Nut 180ml', '14000', 'https://www.thmilk.vn/wp-content/uploads/2020/09/NUT-hat-va-nghe-800.png', 'THÔNG TIN: \r\nSữa hạt mắc ca TH True Nut có hương vị thơm ngon thiên nhiên giữa sữa tươi sạch của trang trại TH, hạt Óc Chó, hạt Mắc Ca và vị ngọt tự nhiên từ quả Chà Là. Sữa hạt mắc ca mang lại nhiều dưỡng chất tốt hơn cho sức khỏe cả gia đình. Với thiết kế bao bì nhỏ gọn, bạn dễ dàng tận hưởng vị ngon bất tận của TH True Nut ở mọi nơi.\r\n\r\nĐẶC ĐIỂM NỔI BẬT:\r\n- Sự kết hợp sáng tạo hoàn toàn từ thiên nhiên giữa sữa tươi sạch của trang trại TH, hạt Óc Chó, hạt Mắc Ca và vị ngọt tự nhiên từ quả Chà Là, tốt hơn cho sức khỏe cả gia đình.\r\n- Vị thanh ngọt tự nhiên từ quả Chà Là - với vị ngọt tự nhiên, hàm lượng béo và chỉ số đường huyết thấp, đồng thời giàu selen, kali, sắt và chất chống oxi hóa.\r\n- Thành phần Curcumin trong nghệ có tác dụng chống oxy hóa, giúp làm chậm quá trình lão hóa, duy trì vẻ đẹp tươi trẻ. \r\n- Ngoài ra giúp giải độc và bảo vệ gan, cho làn da khỏe mạnh; tính năng kháng viêm giúp cải thiện tình trạng da mụn, chống viêm da.\r\n- Lợi ích của hạt Óc chó, hạt Mắc ca: Omega-3,6,9 và các vitamin, khoáng chất trong hạt óc chó, hạt mắc ca rất tốt cho sức khoẻ tổng thể.\r\n\r\nTHÀNH PHẦN:\r\nDịch hạt óc chó và mắc ca (50%), sữa bò tươi, dịch yến mạch, chà là (5%), chất ổn định (418, 471, 410), chiết xuất nghệ (0,06%). KHÔNG sử dụng chất bảo quản.\r\n\r\nHƯỚNG DẪN SỬ DỤNG:\r\n- Ngon hơn khi uống lạnh. Lắc đều trước khi sử dụng\r\n- Sử dụng ngay sau khi mở\r\n\r\nCÁCH BẢO QUẢN:\r\nBảo quản nơi khô ráo và thoáng mát\r\n\r\nXuất xứ: Việt Nam\r\nNơi sản xuất: Việt Nam\r\nNgày sản xuất: 25/10/2021 12:00 AM\r\nHạn sử dụng: 25/07/2023 12:00 AM\r\nNhà sản xuất: CÔNG TY CỔ PHẦN CHUỖI THỰC PHẨM TH\r\nĐịa chỉ nhà sản xuất: Số 166, Đường Nguyễn Thái Học, Phường Quang Trung, TP. Vinh, Tỉnh Nghệ An', 1),
(3, 'Sữa đậu nành Fami Nguyên chất ít đường 200ml', '6000', 'https://product.hstatic.net/200000352097/product/sp_1927_754edde89fe24a79a4c6d7494cb939cd_grande.jpg', 'THÔNG TIN:\r\n- Sữa đậu nành chứa nhiều protein, chất xơ, vitamin và chất khoáng có lợi cho sức khỏe.\r\n- Sản phẩm bổ sung và giúp tăng cường sức đề kháng, hệ cơ xương và làm đẹp da.\r\n- Sữa đậu nành Fami sánh mịn, thơm ngon, cung cấp dưỡng chất thiết yếu cho gia đình bạn sức khỏe và niềm vui thưởng thức mỗi ngày\r\n\r\nĐẶC ĐIỂM NỔI BẬT:\r\n- Sữa đậu nành Fami được làm từ 100% đậu nành hạt chọn lọc, không biến đổi Gen (Non - GMO).\r\n- Được sản xuất theo dây chuyền công nghệ hiện đại\r\n- Được bổ sung thêm 25% lượng đạm giúp sữa có hương vị  đậu nành đậm đà, thơm ngon.\r\n\r\nHƯỚNG DẪN SỬ DỤNG:\r\n- Dùng uống trực tiếp, ngon hơn khi uống lạnh.\r\n- Lắc đều trước khi sử dụng.\r\n\r\nBẢO QUẢN\r\n- Để nơi khô ráo, thoáng mát.\r\n- Tránh ánh nắng trực tiếp.\r\n\r\nHẠN SỬ DỤNG: \r\n06 tháng kể từ ngày sản xuất\r\n\r\nXuất xứ: Việt Nam', 1),
(4, 'Sữa bột Anlene Gold Movepro 3X Vani 1,2 Kg', '435000', 'https://salt.tikicdn.com/cache/400x400/ts/product/a4/30/71/657f5569b786070b7fa5f1f64e7793e8.jpg', 'SỮA ANLENE GOLD HƯƠNG VANI: \r\nSản phẩm sữa cho người lớn tuổi (từ 40 tuổi trở lên) với CÔNG THỨC CẢI TIẾN MOVEPRO chứa hàm lượng cao Đạm, Canxi, Collagen,  các loại Vitamin (B, C, D) &  Khoáng chất (Magiê, Kẽm), giúp duy trì hệ vận động Cơ-Xương-Khớp khỏe mạnh, linh hoạt!\r\n03 LỢI ÍCH VƯỢT TRỘI TRONG MỖI LY SỮA ANLENE GOLD: \r\nCƠ KHỎE: \r\nSữa Anlene Gold chứa Đạm, Magiê, Vitamin B, Vitamin D có vai trò thiết yếu với việc duy trì mật độ cơ. Cơ khỏe mạnh giúp hỗ trợ sự vận động thêm nhanh nhẹn & linh hoạt. \r\nXƯƠNG CHẮC: \r\nCanxi, Vitamin D, Magiê, Kẽm rất quan trọng trong việc duy trì mật độ xương. Hệ xương chắc khỏe là nền tảng vững chắc để nâng đỡ cho các cơ quan và hoạt động của cơ thể.\r\nKHỚP LINH HOẠT: \r\nVitamin C hỗ trợ sự hình thành collagen – thành phần quan trọng giúp sụn khớp khỏe mạnh, từ đó hỗ trợ vận động linh hoạt. \r\nUống 02 ly sữa Anlene mỗi ngày để thoải mái vận động và làm những điều mình thích!\r\nSản phẩm có đa dạng hương vị để bạn lựa chọn và thay đổi tùy theo sở thích: \r\nSữa Anlene Gold Hương Vani\r\nSữa Anlene Gold Vị Sô-cô-la\r\nSữa Anlene Gold Vị Cà-phê\r\n\r\nHƯỚNG DẪN SỬ DỤNG: \r\nCho 04 muỗng sữa Anlene (khoảng 35g) vào 200 ml nước chín (sữa sẽ ngon hơn nếu pha nước ấm) và khuấy đều. \r\nĐối với người lần đầu tiên uống sữa, để tránh hiện tượng không dung nạp Lactose – thành phần tự nhiên của sữa, nên uống sau bữa ăn và bắt đầu bằng một lượng nhỏ 50 ml, sau đó tăng dần lên 200 ml trong vòng 2 tuần. \r\n***Thông tin cảnh báo: Không dùng sản phẩm khi đã hết hạn sử dụng. Sản phẩm có chứa sữa, collagen chiết xuất từ cá và sản phẩm từ đậu nành\r\n\r\nHạn sử dụng: 18 tháng \r\nSản phẩm này không phải là thuốc và không có tác dụng thay thế thuốc chữa bệnh', 2),
(5, 'Sữa bột Pediasure Vani 1,6 Kg', '959000', 'https://www.moby.com.vn/data/bt5/sua-pediasure-16kg-huong-vani-1-10-tuoi-1635138743.jpg', 'PediaSure với nguồn dinh dưỡng đầy đủ và cân bằng với 37 dưỡng chất thiết yếu giúp bé tăng trưởng rõ rệt chỉ sau 9 tuần: Chiều cao, cân nặng và sức đề kháng. \r\nPediaSure có chứa: \r\n- 3 nguồn đạm, canxi và Vitamin D giúp cân bằng và duy trì liên tục axit amin thiết yếu để phát triển cơ và xương.\r\n- Arginin gia tăng số lượng và hoàn thiện các tế bào ở đĩa sụn giúp xương phát triển.\r\n- Vitamin K2 tự nhiên giúp tăng cường vận chuyển canxi giúp tăng khối lượng và cho xương chắc khỏe. \r\n- Prebiotic, probiotic và selenium và kẽm giúp hấp thụ và tăng cường sức đề kháng tốt hơn. \r\nĐối tượng sử dụng: trẻ biếng ăn từ 1-10 tuổi.  \r\n\r\nCách pha 1 ly PediaSure chuẩn: Cho 190ml nước chín nguội vào ly, vừa từ từ cho vào 5 muỗng gạt ngang vừa khuấy đều cho đến khi bột tan hết.\r\n\r\nBảo quản: Bảo quản hộp chưa mở ở nhiệt độ phòng. Hộp đã mở phải được đậy kín và bảo quản ở nơi khô mát (nhưng không cho vào tủ lạnh) và sử dụng trong vòng 3 tuần. PediaSure vừa pha phải được dùng ngay hay đậy kín, cho vào tủ lạnh và dùng trong vòng 24 giờ. \r\n\r\nLưu ý: \r\n- Không dùng cho trẻ bị bệnh Galactosemia. \r\n- Không dùng cho trẻ dưới 1 tuổi, trừ khi được bác sĩ chỉ định. \r\n- Tham khảo bác sĩ/chuyên viên dinh dưỡng về nhu cầu dinh dưỡng cụ thể của con bạn\r\n- Không dùng nuôi ăn qua đường tĩnh mạch. \r\n\r\nHạn sử dụng: 24 tháng kể từ ngày sản xuất. \r\nSản xuất tại Singapore.\r\nNhập khẩu và phân phối:\r\nCông ty TNHH DINH DƯỠNG 3A (Việt Nam) \r\n\r\n*Sản phẩm không phải là thuốc và không có tác dụng thay thế thuốc chữa bệnh.\r\n**Bao bì có thể thay đổi theo từng đợt hàng.', 2),
(6, 'Sữa đặc có đường Ông Thọ lon 380g', '24000', 'https://cdn.tgdd.vn/Products/Images/2526/77412/bhx/sua-dac-co-duong-ong-tho-do-lon-380g-201911071548119343.jpg', 'Sữa đặc Ông Thọ với vị thơm ngon, sánh đặc, là bí quyết giúp mẹ có những món ăn ngon, chăm sóc cho cả gia đình. Sữa đặc có đường Ông Thọ đỏ lon 380g có độ béo và ngậy, pha sữa sẽ làm sữa dậy mùi\r\nLoại sản phẩm: Sữa đặc có đường\r\nTrọng lượng: 380g\r\nThành phần: Đường tinh luyện, nước, sữa bột, dầu thực vật, chất béo sữa,...\r\nHương vị: Ngọt đậm đà\r\nĐộ đạm: 4.8g/100g\r\nThích hợp: Pha cà phê, xay sinh tố, làm sữa chua, bánh flan...\r\nThương hiệu: Ông Thọ (Việt Nam)\r\nSản xuất: Việt Nam\r\n \r\nHướng dẫn sử dụng:\r\n- Sử dụng ngay sau khi mở lon.\r\n- Pha một phần sữa với 3 phần nước ấm để uống hoặc pha cùng cà phê, ăn cùng bánh mì,...', 3),
(7, 'Sữa đặc có đường Ngôi sao Phương Nam Xanh lá lon 380g', '19600', 'https://cdn.tgdd.vn/Products/Images/2526/77411/bhx/sd-nspn-xanh-la-lon-380g-2-org.jpg', 'Kem đặc có đường Ngôi sao Phương Nam xanh lá đậm đà đặc sánh, mang lại hương vị hài hòa, thơm béo, dùng để pha sữa, chấm bánh mì,.. thơm ngon tuyệt vời. Kem đặc có đường Ngôi sao Phương Nam xanh lá lon 380g bí quyết cho món cà phê thơm ngon\r\nLoại sản phẩm: Kem đặc có đường\r\nTrọng lượng: 380g\r\nThành phần: Đường, nước, dầu thực vật, sữa bột , Whey bột,...\r\nHương vị: Ngọt vừa\r\nĐộ đạm: 2.7g/100g\r\nThích hợp: Pha cà phê, xay sinh tố, làm sữa chua, bánh flan...\r\nThương hiệu: Ngôi sao Phương Nam (Việt Nam)\r\nSản xuất: Việt Nam', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
