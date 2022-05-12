-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2022 at 07:00 AM
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
(1, 'Sữa tươi tiệt trùng có đường TH True Milk 110ml', '8000', 'https://www.thmilk.vn/wp-content/uploads/2019/11/UHT-110-CD-457x396.png', 'Sữa tươi tiệt trùng nguyên chất TH True Milk giúp cả gia đình tận hưởng trọn vẹn dưỡng chất tự nhiên từ sữa tươi mà không còn lo lắng các vấn đề về sức khoẻ khi sử dụng nhiều đường trong chế độ dinh dưỡng hàng ngày. \r\n\r\nĐẶC ĐIỂM NỔI BẬT:\r\n- Nguồn sữa tươi, sạch nguyên chất từ trang trại TH cùng công nghệ hiện đại \r\n- Mang đến sự đảm bảo tinh tuý thiên nhiên được giữ vẹn nguyên trong từng giọt sữa \r\n- Không chất bảo quản, phụ gia - Bao bì hiện đại, nhỏ gọn dễ dàng mang theo bên người. Dung tích 110ml phù hợp với nhu cầu sử dụng của cá nhân và cả gia đình \r\n\r\nTHÀNH PHẦN: \r\nSữa hoàn toàn từ sữa bò tươi (96%), đường (3,8%), hỗn hợp chất nhũ hoá và chất ổn định (E 471, E 407, E412)\r\n\r\nHƯỚNG DẪN SỬ DỤNG: \r\nSử dụng ngay sau khi mở Ngon hơn khi uống lạnh \r\n\r\nCÁCH BẢO QUẢN:\r\n- Xếp dỡ nhẹ nhàng, không chất cao quá 13 hoặc 14 lớp (vui lòng xem chi tiết trên bao bì thực tế) \r\n- Bảo quản nơi khô ráo và thoáng mát, tránh côn trùng gặm nhấm \r\n- Bao bì dễ bị tổn thương gây hư hỏng đến sản phẩm bên trong \r\n\r\nXuất xứ: Việt Nam \r\nNơi sản xuất: Việt Nam \r\nNgày sản xuất: 2/12/2021 0:00 \r\nHạn sử dụng: 2/6/2023 0:00 \r\nNhà sản xuất: CÔNG TY CỔ PHẦN CHUỖI THỰC PHẨM TH \r\nĐịa chỉ nhà sản xuất: Số 166, Đường Nguyễn Thái Học, Phường Quang Trung, TP. Vinh, Tỉnh Nghệ An', 1),
(2, 'Sữa Hạt và Nghệ TH True Nut 180ml', '14000', 'https://www.thmilk.vn/wp-content/uploads/2020/09/NUT-hat-va-nghe-800.png', 'Sữa hạt mắc ca TH True Nut có hương vị thơm ngon thiên nhiên giữa sữa tươi sạch của trang trại TH, hạt Óc Chó, hạt Mắc Ca và vị ngọt tự nhiên từ quả Chà Là. Sữa hạt mắc ca mang lại nhiều dưỡng chất tốt hơn cho sức khỏe cả gia đình. Với thiết kế bao bì nhỏ gọn, bạn dễ dàng tận hưởng vị ngon bất tận của TH True Nut ở mọi nơi.\r\n\r\nĐẶC ĐIỂM NỔI BẬT:\r\n- Sự kết hợp sáng tạo hoàn toàn từ thiên nhiên giữa sữa tươi sạch của trang trại TH, hạt Óc Chó, hạt Mắc Ca và vị ngọt tự nhiên từ quả Chà Là, tốt hơn cho sức khỏe cả gia đình.\r\n- Vị thanh ngọt tự nhiên từ quả Chà Là - với vị ngọt tự nhiên, hàm lượng béo và chỉ số đường huyết thấp, đồng thời giàu selen, kali, sắt và chất chống oxi hóa.\r\n- Thành phần Curcumin trong nghệ có tác dụng chống oxy hóa, giúp làm chậm quá trình lão hóa, duy trì vẻ đẹp tươi trẻ. \r\n- Ngoài ra giúp giải độc và bảo vệ gan, cho làn da khỏe mạnh; tính năng kháng viêm giúp cải thiện tình trạng da mụn, chống viêm da.\r\n- Lợi ích của hạt Óc chó, hạt Mắc ca: Omega-3,6,9 và các vitamin, khoáng chất trong hạt óc chó, hạt mắc ca rất tốt cho sức khoẻ tổng thể.\r\n\r\nTHÀNH PHẦN:\r\nDịch hạt óc chó và mắc ca (50%), sữa bò tươi, dịch yến mạch, chà là (5%), chất ổn định (418, 471, 410), chiết xuất nghệ (0,06%). KHÔNG sử dụng chất bảo quản.\r\n\r\nHƯỚNG DẪN SỬ DỤNG:\r\n- Ngon hơn khi uống lạnh. Lắc đều trước khi sử dụng\r\n- Sử dụng ngay sau khi mở\r\n\r\nCÁCH BẢO QUẢN:\r\nBảo quản nơi khô ráo và thoáng mát\r\n\r\nXuất xứ: Việt Nam\r\nNơi sản xuất: Việt Nam\r\nNgày sản xuất: 25/10/2021 12:00 AM\r\nHạn sử dụng: 25/07/2023 12:00 AM\r\nNhà sản xuất: CÔNG TY CỔ PHẦN CHUỖI THỰC PHẨM TH\r\nĐịa chỉ nhà sản xuất: Số 166, Đường Nguyễn Thái Học, Phường Quang Trung, TP. Vinh, Tỉnh Nghệ An', 1),
(3, 'Sữa đậu nành Fami Nguyên chất ít đường 200ml', '6000', 'https://product.hstatic.net/200000352097/product/sp_1927_754edde89fe24a79a4c6d7494cb939cd_grande.jpg', 'Sữa đậu nành Fami chứa nhiều protein, chất xơ, vitamin và chất khoáng có lợi cho sức khỏe. Sản phẩm cung cấp dưỡng chất thiết yếu và giúp tăng cường sức đề kháng, hệ cơ xương và làm đẹp da, giúp cho gia đình bạn sức khỏe và niềm vui thưởng thức mỗi ngày\r\n\r\nĐẶC ĐIỂM NỔI BẬT:\r\n- Sữa đậu nành Fami được làm từ 100% đậu nành hạt chọn lọc, không biến đổi Gen (Non - GMO).\r\n- Được sản xuất theo dây chuyền công nghệ hiện đại\r\n- Được bổ sung thêm 25% lượng đạm giúp sữa có hương vị  đậu nành đậm đà, thơm ngon.\r\n\r\nHƯỚNG DẪN SỬ DỤNG:\r\n- Dùng uống trực tiếp, ngon hơn khi uống lạnh.\r\n- Lắc đều trước khi sử dụng.\r\n\r\nBẢO QUẢN:\r\n- Để nơi khô ráo, thoáng mát.\r\n- Tránh ánh nắng trực tiếp.\r\n\r\nHẠN SỬ DỤNG: \r\n06 tháng kể từ ngày sản xuất\r\n\r\nXuất xứ: Việt Nam', 1),
(4, 'Sữa bột Anlene Gold Movepro 3X Vani 1,2 Kg', '435000', 'https://salt.tikicdn.com/cache/400x400/ts/product/a4/30/71/657f5569b786070b7fa5f1f64e7793e8.jpg', 'SỮA ANLENE GOLD HƯƠNG VANI dành cho người lớn tuổi (từ 40 tuổi trở lên) với CÔNG THỨC CẢI TIẾN MOVEPRO chứa hàm lượng cao Đạm, Canxi, Collagen,  các loại Vitamin (B, C, D) &  Khoáng chất (Magiê, Kẽm), giúp duy trì hệ vận động Cơ-Xương-Khớp khỏe mạnh, linh hoạt!\r\n\r\n03 LỢI ÍCH VƯỢT TRỘI TRONG MỖI LY SỮA ANLENE GOLD: \r\n+ CƠ KHỎE: \r\nSữa Anlene Gold chứa Đạm, Magiê, Vitamin B, Vitamin D có vai trò thiết yếu với việc duy trì mật độ cơ. Cơ khỏe mạnh giúp hỗ trợ sự vận động thêm nhanh nhẹn & linh hoạt. \r\n+ XƯƠNG CHẮC:\r\nCanxi, Vitamin D, Magiê, Kẽm rất quan trọng trong việc duy trì mật độ xương. Hệ xương chắc khỏe là nền tảng vững chắc để nâng đỡ cho các cơ quan và hoạt động của cơ thể.\r\n+ KHỚP LINH HOẠT:\r\nVitamin C hỗ trợ sự hình thành collagen – thành phần quan trọng giúp sụn khớp khỏe mạnh, từ đó hỗ trợ vận động linh hoạt. \r\nUống 02 ly sữa Anlene mỗi ngày để thoải mái vận động và làm những điều mình thích!\r\n\r\nHƯỚNG DẪN SỬ DỤNG: \r\nCho 04 muỗng sữa Anlene (khoảng 35g) vào 200 ml nước chín (sữa sẽ ngon hơn nếu pha nước ấm) và khuấy đều. \r\nĐối với người lần đầu tiên uống sữa, để tránh hiện tượng không dung nạp Lactose – thành phần tự nhiên của sữa, nên uống sau bữa ăn và bắt đầu bằng một lượng nhỏ 50 ml, sau đó tăng dần lên 200 ml trong vòng 2 tuần. \r\n***Thông tin cảnh báo: Không dùng sản phẩm khi đã hết hạn sử dụng. Sản phẩm có chứa sữa, collagen chiết xuất từ cá và sản phẩm từ đậu nành\r\n\r\nHạn sử dụng: 18 tháng \r\nSản phẩm này không phải là thuốc và không có tác dụng thay thế thuốc chữa bệnh', 2),
(5, 'Sữa bột Pediasure Vani 1,6 Kg', '959000', 'https://www.moby.com.vn/data/bt5/sua-pediasure-16kg-huong-vani-1-10-tuoi-1635138743.jpg', 'PediaSure với nguồn dinh dưỡng đầy đủ và cân bằng với 37 dưỡng chất thiết yếu giúp bé tăng trưởng rõ rệt chỉ sau 9 tuần: Chiều cao, cân nặng và sức đề kháng. \r\nPediaSure có chứa: \r\n- 3 nguồn đạm, canxi và Vitamin D giúp cân bằng và duy trì liên tục axit amin thiết yếu để phát triển cơ và xương.\r\n- Arginin gia tăng số lượng và hoàn thiện các tế bào ở đĩa sụn giúp xương phát triển.\r\n- Vitamin K2 tự nhiên giúp tăng cường vận chuyển canxi giúp tăng khối lượng và cho xương chắc khỏe. \r\n- Prebiotic, probiotic và selenium và kẽm giúp hấp thụ và tăng cường sức đề kháng tốt hơn. \r\nĐối tượng sử dụng: trẻ biếng ăn từ 1-10 tuổi.  \r\n\r\nCách pha 1 ly PediaSure chuẩn: Cho 190ml nước chín nguội vào ly, vừa từ từ cho vào 5 muỗng gạt ngang vừa khuấy đều cho đến khi bột tan hết.\r\n\r\nBảo quản: Bảo quản hộp chưa mở ở nhiệt độ phòng. Hộp đã mở phải được đậy kín và bảo quản ở nơi khô mát (nhưng không cho vào tủ lạnh) và sử dụng trong vòng 3 tuần. PediaSure vừa pha phải được dùng ngay hay đậy kín, cho vào tủ lạnh và dùng trong vòng 24 giờ. \r\n\r\nLưu ý: \r\n- Không dùng cho trẻ bị bệnh Galactosemia. \r\n- Không dùng cho trẻ dưới 1 tuổi, trừ khi được bác sĩ chỉ định. \r\n- Tham khảo bác sĩ/chuyên viên dinh dưỡng về nhu cầu dinh dưỡng cụ thể của con bạn\r\n- Không dùng nuôi ăn qua đường tĩnh mạch. \r\n\r\nHạn sử dụng: 24 tháng kể từ ngày sản xuất. \r\nSản xuất tại Singapore.\r\nNhập khẩu và phân phối:\r\nCông ty TNHH DINH DƯỠNG 3A (Việt Nam) \r\n\r\n*Sản phẩm không phải là thuốc và không có tác dụng thay thế thuốc chữa bệnh.\r\n**Bao bì có thể thay đổi theo từng đợt hàng.', 2),
(6, 'Sữa đặc có đường Ông Thọ lon 380g', '24000', 'https://cdn.tgdd.vn/Products/Images/2526/77412/bhx/sua-dac-co-duong-ong-tho-do-lon-380g-201911071548119343.jpg', 'Sữa đặc Ông Thọ với vị thơm ngon, sánh đặc, là bí quyết giúp mẹ có những món ăn ngon, chăm sóc cho cả gia đình. Sữa đặc có đường Ông Thọ đỏ lon 380g có độ béo và ngậy, pha sữa sẽ làm sữa dậy mùi\r\nLoại sản phẩm: Sữa đặc có đường\r\nTrọng lượng: 380g\r\nThành phần: Đường tinh luyện, nước, sữa bột, dầu thực vật, chất béo sữa,...\r\nHương vị: Ngọt đậm đà\r\nĐộ đạm: 4.8g/100g\r\nThích hợp: Pha cà phê, xay sinh tố, làm sữa chua, bánh flan...\r\nThương hiệu: Ông Thọ (Việt Nam)\r\nSản xuất: Việt Nam\r\n \r\nHướng dẫn sử dụng:\r\n- Sử dụng ngay sau khi mở lon.\r\n- Pha một phần sữa với 3 phần nước ấm để uống hoặc pha cùng cà phê, ăn cùng bánh mì,...', 3),
(7, 'Sữa đặc có đường Ngôi sao Phương Nam Xanh lá lon 380g', '19600', 'https://cdn.tgdd.vn/Products/Images/2526/77411/bhx/sd-nspn-xanh-la-lon-380g-2-org.jpg', 'Kem đặc có đường Ngôi sao Phương Nam xanh lá đậm đà đặc sánh, mang lại hương vị hài hòa, thơm béo, dùng để pha sữa, chấm bánh mì,.. thơm ngon tuyệt vời. Kem đặc có đường Ngôi sao Phương Nam xanh lá lon 380g bí quyết cho món cà phê thơm ngon\r\nLoại sản phẩm: Kem đặc có đường\r\nTrọng lượng: 380g\r\nThành phần: Đường, nước, dầu thực vật, sữa bột , Whey bột,...\r\nHương vị: Ngọt vừa\r\nĐộ đạm: 2.7g/100g\r\nThích hợp: Pha cà phê, xay sinh tố, làm sữa chua, bánh flan...\r\nThương hiệu: Ngôi sao Phương Nam (Việt Nam)\r\nSản xuất: Việt Nam', 3),
(8, 'Sữa Milo nước hộp 180ml', '7000', 'https://www.nestlemilo.com.vn/sites/default/files/2021-10/front-5.png', 'Sản phẩm sữa uống lúa mạch thơm ngon, giàu canxi và protein giúp cho cơ thể luôn phát triển toàn diện, sữa lúa mạch Milo được các bé cực yêu thích. Thức uống lúa mạch uống liền Milo hộp 180ml hộp dễ dàng bảo quản, dễ mang đi mọi nơi, sữa thơm ngon\r\nHương vị Cacao\r\nPhù hợp Trẻ trên 6 tuổi\r\nThành phần Nước, sữa bột tách kem, đường, chiết xuất từ lúa mạch, bột cacao,...\r\nTrọng lượng/ Thể tích 180ml\r\nThương hiệu Milo\r\nSản xuất Việt Nam\r\n\r\nHướng dẫn sử dụng:\r\nDùng uống trực tiếp.\r\nLắc đều trước khi uống.\r\nNgon hơn khi uống lạnh.\r\nBảo quản: để nơi khô ráo, thoáng mát. tránh ánh nắng trực tiếp.', 1),
(9, 'Sữa Đặc Có Đường NutiMilk Hộp 380Gr', '23000', 'https://cf.shopee.vn/file/70c53c697d265ea6d0ff4d69a243e2a7', 'Creamer đặc Sữa Pha Chế có đường Nutimilk đáp ứng nhu cầu đa dạng của tất cả mọi người, là công thức tuyệt hảo không thể thiếu trong nhiều món ngon hằng ngày:\r\n\r\n- Bí quyết để pha ly cà phê sữa đậm đà sành điệu.\r\n- Thành phần không để thiếu cho những chiếc bánh flan sánh mịn, béo ngậy.- Thêm sữa đặc Nuti cho ly sinh tố thêm thơm ngon, bổ dưỡng.\r\n- Nguyên liệu không thể thiếu cho ly trà sữa hấp dẫn, ly kem tươi hay hũ rau câu mát lạnh ngày hè.\r\n\r\nSữa đặc Nuti còn là nguyên liệu đặc trưng để cho ra đời những viên kẹo sữa ngọt ngào, hay những chiếc bánh ngọt ngon tuyệt mang phong cách Á-Âu như pudding, bánh tart, bánh su kem.Được sản xuất trên dây chuyền hiện đại của Malaysia dưới sự giám sát chất lượng của các chuyên gia NutiFood.\r\n\r\n*Hướng dẫn sử dụng:\r\n- Dùng trực tiếp hoặc để pha chế các món ăn thức uống khác.\r\n- Bảo quản nơi khô ráo, thoáng mát. Sau khi mở hộp nên bảo quản trong tủ lạnh và sử dụng hết trong 3 ngày.', 3),
(10, 'Sữa Tươi Tiệt Trùng Dutch Lady Cô Gái Hà Lan Hương Dâu 180ml', '7000', 'https://suachobeyeu.vn/upload/images/sua-tuoi-co-gai-ha-lan-vi-dau-hop-180ml-1.jpg', 'Sữa tươi Cô Gái Hà Lan với tiêu chuẩn Hà Lan an toàn hơn 11 lần so với chuẩn cơ bản\n• Sữa tươi an toàn, tươi ngon và chất lượng\n• Được làm từ nguồn nguyên liệu chọn lọc nghiêm ngặt, trải qua quy trình sản xuất và kiểm soát chất lượng theo tiêu chuẩn được quốc tế công nhận, với kinh nghiệm đúc kết hơn 145 năm qua. \n- Thành phần: Sữa tươi 100%, không sử dụng chất bảo quản, không màu hóa học\n- Cách sử dụng: Lắc đều trước khi uống. Ngon hơn khi uống lạnh. Sử dụng cho 1 lần uống\n- Cách bảo quản: Bảo quản nơi khô ráo và thoáng mát\nXuất xứ: Việt Nam\nHSD: Xem trên bao bì\n\n*Bao bì thay đổi tùy vào mỗi đợt nhập hàng', 1),
(11, 'Sữa Tươi Thanh Trùng Nguyên Chất 450ml', '21000', 'https://www.dalatmilk.vn/wp-content/uploads/2020/04/STTT-450ml_KD-2-min.png', 'Sữa Tươi Thanh Trùng Dalatmilk\r\nHoàn toàn từ sữa tươi cao nguyên!\r\nSữa Tươi Thanh Trùng Dalatmilk chế biến từ 100% sữa bò tươi từ cao nguyên Lâm Đồng, nơi có điều kiện khí hậu trung bình từ 15 °C – 25 °C với độ cao trên 1000 m, phù hợp để cho ra nguồn sữa giàu dinh dưỡng, tinh khiết với chất lượng đồng nhất\r\nCông nghệ thanh trùng ở nhiệt độ thấp lưu giữ tối đa giá trị dinh dưỡng và hương vị thơm ngon tự nhiên của sữa tươi nguyên chất.\r\nSữa Tươi Thanh Trùng Dalatmilk với đầy đủ các dưỡng chất tự nhiên từ sữa bò tươi, cần thiết đáp ứng cho nhu cầu phát triển hàng ngày của cơ thể.\r\nBảo quản: Luôn bảo quản lạnh ở nhiệt độ từ 2 oC – 6 oC\r\nHạn sử dụng: 12 ngày kể từ ngày sản xuất in trên bao bì', 1),
(12, 'Sữa Bột Friso Gold 4 850g (2-6 tuổi)', '509000', 'https://media.shoptretho.com.vn/upload/image/product/20210401/sua-friso-gold-850g-so-4-2.jpg', 'Sữa Bột Frisolac Gold 4 - Giai Đoạn 1 là sản phẩm dinh dưỡng công thức dành cho trẻ từ 2-6 tuổi\r\n- Frisolac Gold 4 cung cấp đa vi chất dinh dưỡng vitamin A, C, E và các chất khoáng selen, kẽm, 5 loại nucleotit và chất xơ GOS giúp hỗ trợ sức khỏe đường ruột của trẻ, và DHA, AA hỗ trợ phát triển trí não.\r\n- Dễ dàng tiêu hoá, hấp thu: Nguồn sữa NOVAS chất lượng giúp tạo ra các phân tử đạm nhỏ tự nhiên, có cấu trúc mềm nhẹ, hấp thu nhanh và dễ dàng tiêu hóa. Chất xơ GOS thúc đẩy sự phát triển của lợi khuẩn, hỗ trợ đường ruột non nớt của bé.\r\n- Tăng cường miễn dịch: Kẽm và Nucleotide hỗ trợ sức đề kháng, giúp bé luôn mạnh khoẻ.\r\n- Tăng trưởng cơ thở và não bộ: Selen, Kẽm, DHA và vitamin D là các dưỡng chất quan trọng trong sự hỗ trợ sự tăng trưởng toàn diện của bé.\r\n- CÔNG NGHỆ LOCKNUTRI - Bảo Toàn Dưỡng Chất Thiên Nhiên Giúp Bé Yêu Dễ Dàng Tiêu Hoá: Hệ tiêu hóa của bé còn rất non nớt, nên dưỡng chất thiên nhiên sẽ giúp bé dễ dàng tiêu hóa. Hiểu được điều này, Friso với quy trình xử lý ở nhiệt độ thấp, bảo toàn dưỡng chất thiên nhiên không bị biến tính, giúp dạ dày non nớt của bé tiêu hóa dễ dàng hơn.\r\n\r\nHƯỚNG DẪN SỬ DỤNG \r\n- Luôn giữ nơi pha chế sạch sẽ và ngăn nắp. \r\n- Đun sôi các dụng cụ pha chế ít nhất 3 phút, một lần mỗi ngày. \r\n- Luôn giữ muỗng lường bột ở bên trong lon được khô ráo và sạch sẽ. \r\n- Đóng kín lon sản phẩm bằng nắp nhựa. \r\n- Bảo quản nơi khô ráo, thoáng mát. \r\n- Sử dụng trong vòng 4 tuần sau khi mở nắp lon.', 2),
(13, 'Sữa Tươi Tiệt Trùng Có Đường 220ml', '7500', 'https://www.dalatmilk.vn/wp-content/uploads/2020/04/FINO-Co-Duong-1-1.png', 'Sữa Tươi Tiệt Trùng Dalatmilk\r\nHoàn Toàn Tự Nhiên\r\nTiên phong mô hình hợp tác xã công nghệ cao đồng hành cùng nông dân chăn nuôi bò sữa, Dalatmilk tự hào ra mắt bộ sản phẩm Sữa tươi tiệt trùng được sản xuất từ sữa tươi của những vùng chăn nuôi bò sữa nổi tiếng với chất lượng đồng nhất theo chuẩn Dalatmilk và sử dụng nguyên liệu hoàn toàn tự nhiên. Sữa tươi tiệt trùng Dalatmilk đa dạng về hương vị và chủng loại, mang đến hương vị thơm ngon và cung cấp nguồn dưỡng chất tự nhiên thiết yếu cho sức khỏe cả gia đình.\r\nBảo quản nơi khô ráo, thoáng mát.\r\nHạn sử dụng: 6 tháng kể từ ngày sản xuất\r\n \r\n\r\nƯu điểm nổi bật của sản phẩm:\r\nHoàn toàn tự nhiên\r\nSữa tươi tiệt trùng Dalatmilk hoàn toàn tự nhiên được sản xuất từ sữa tươi của những vùng chăn nuôi bò sữa nổi tiếng, không sử dụng chất bảo quản hoặc nguyên liệu tổng hợp.\r\nỨng dụng công nghệ cao cho chất lượng sữa đồng nhất chuẩn Dalatmilk\r\nTiên phong triển khai thí điểm mô hình hợp tác xã áp dụng công nghệ cao đến nông hộ chăn nuôi, Dalatmilk đang từng bước giúp người nông dân tạo ra ly sữa tươi chuẩn hóa. Bằng cách lắp đặt chíp đeo điện tử, tình trạng của bò được theo dõi và cập nhật kịp thời thông qua máy tính hoặc điện thoại thông minh. Nhờ đó, người nông dân nhận được những cảnh bảo sớm về tình trạng sức khỏe của bò như bệnh viêm vú; tình trạng động dục,… để đưa ra những giải pháp cần thiết.\r\nAn tâm chăm sóc sức khỏe cho cả gia đình với một sản phẩm hoàn toàn từ tự nhiên\r\nSữa tươi tự nhiên là thực phẩm bổ sung dinh dưỡng quan trọng cho con nguời ở mọi lứa tuổi. Sữa được coi một trong những thực phẩm hoàn hảo nhất vì chứa đầy đủ các yếu tố của một chế độ dinh dưỡng cân bằng. Sữa tươi tiệt trùng Dalatmilk đa dạng về hương vị và chủng loại, mang đến hương vị thơm ngon và cung cấp nguồn dưỡng chất tự nhiên thiết yếu cho sức khỏe cả gia đình.', 1),
(14, 'Sữa Tươi Tiệt Trùng Không Đường 220ml', '7500', 'https://www.dalatmilk.vn/wp-content/uploads/2020/04/Dalatmilk-UHT-FINO-vi-tu-nhien1000x1000.png', 'Sữa Tươi Tiệt Trùng Dalatmilk\r\nHoàn Toàn Tự Nhiên\r\nTiên phong mô hình hợp tác xã công nghệ cao đồng hành cùng nông dân chăn nuôi bò sữa, Dalatmilk tự hào ra mắt bộ sản phẩm Sữa tươi tiệt trùng được sản xuất từ sữa tươi của những vùng chăn nuôi bò sữa nổi tiếng với chất lượng đồng nhất theo chuẩn Dalatmilk và sử dụng nguyên liệu hoàn toàn tự nhiên. Sữa tươi tiệt trùng Dalatmilk đa dạng về hương vị và chủng loại, mang đến hương vị thơm ngon và cung cấp nguồn dưỡng chất tự nhiên thiết yếu cho sức khỏe cả gia đình.\r\nBảo quản nơi khô ráo, thoáng mát.\r\nHạn sử dụng: 6 tháng kể từ ngày sản xuất\r\n \r\n\r\nƯu điểm nổi bật của sản phẩm:\r\n\r\nHoàn toàn tự nhiên\r\nSữa tươi tiệt trùng Dalatmilk hoàn toàn tự nhiên được sản xuất từ sữa tươi của những vùng chăn nuôi bò sữa nổi tiếng, không sử dụng chất bảo quản hoặc nguyên liệu tổng hợp.\r\nỨng dụng công nghệ cao cho chất lượng sữa đồng nhất chuẩn Dalatmilk\r\nTiên phong triển khai thí điểm mô hình hợp tác xã áp dụng công nghệ cao đến nông hộ chăn nuôi, Dalatmilk đang từng bước giúp người nông dân tạo ra ly sữa tươi chuẩn hóa. Bằng cách lắp đặt chíp đeo điện tử, tình trạng của bò được theo dõi và cập nhật kịp thời thông qua máy tính hoặc điện thoại thông minh. Nhờ đó, người nông dân nhận được những cảnh bảo sớm về tình trạng sức khỏe của bò như bệnh viêm vú; tình trạng động dục,… để đưa ra những giải pháp cần thiết.\r\nAn tâm chăm sóc sức khỏe cho cả gia đình với một sản phẩm hoàn toàn từ tự nhiên\r\nSữa tươi tự nhiên là thực phẩm bổ sung dinh dưỡng quan trọng cho con nguời ở mọi lứa tuổi. Sữa được coi một trong những thực phẩm hoàn hảo nhất vì chứa đầy đủ các yếu tố của một chế độ dinh dưỡng cân bằng. Sữa tươi tiệt trùng Dalatmilk đa dạng về hương vị và chủng loại, mang đến hương vị thơm ngon và cung cấp nguồn dưỡng chất tự nhiên thiết yếu cho sức khỏe cả gia đình.', 1),
(15, 'Sữa Tươi Tiệt Trùng Ít Đường 180ml', '7750', 'https://www.dalatmilk.vn/wp-content/uploads/2020/04/Dalatmilk_SL180-ID-2-min.png', 'Sữa Tươi Tiệt Trùng Dalatmilk\r\nHoàn Toàn Tự Nhiên\r\nTiên phong mô hình hợp tác xã công nghệ cao đồng hành cùng nông dân chăn nuôi bò sữa, Dalatmilk tự hào ra mắt bộ sản phẩm Sữa tươi tiệt trùng được sản xuất từ sữa tươi của những vùng chăn nuôi bò sữa nổi tiếng với chất lượng đồng nhất theo chuẩn Dalatmilk và sử dụng nguyên liệu hoàn toàn tự nhiên. Sữa tươi tiệt trùng Dalatmilk đa dạng về hương vị và chủng loại, mang đến hương vị thơm ngon và cung cấp nguồn dưỡng chất tự nhiên thiết yếu cho sức khỏe cả gia đình.\r\nBảo quản nơi khô ráo, thoáng mát.\r\nHạn sử dụng: 6 tháng kể từ ngày sản xuất\r\n \r\n\r\nƯu điểm nổi bật của sản phẩm:\r\n\r\nHoàn toàn tự nhiên\r\nSữa tươi tiệt trùng Dalatmilk hoàn toàn tự nhiên được sản xuất từ sữa tươi của những vùng chăn nuôi bò sữa nổi tiếng, không sử dụng chất bảo quản hoặc nguyên liệu tổng hợp.\r\nỨng dụng công nghệ cao cho chất lượng sữa đồng nhất chuẩn Dalatmilk\r\nTiên phong triển khai thí điểm mô hình hợp tác xã áp dụng công nghệ cao đến nông hộ chăn nuôi, Dalatmilk đang từng bước giúp người nông dân tạo ra ly sữa tươi chuẩn hóa. Bằng cách lắp đặt chíp đeo điện tử, tình trạng của bò được theo dõi và cập nhật kịp thời thông qua máy tính hoặc điện thoại thông minh. Nhờ đó, người nông dân nhận được những cảnh bảo sớm về tình trạng sức khỏe của bò như bệnh viêm vú; tình trạng động dục,… để đưa ra những giải pháp cần thiết.\r\nAn tâm chăm sóc sức khỏe cho cả gia đình với một sản phẩm hoàn toàn từ tự nhiên\r\nSữa tươi tự nhiên là thực phẩm bổ sung dinh dưỡng quan trọng cho con nguời ở mọi lứa tuổi. Sữa được coi một trong những thực phẩm hoàn hảo nhất vì chứa đầy đủ các yếu tố của một chế độ dinh dưỡng cân bằng. Sữa tươi tiệt trùng Dalatmilk đa dạng về hương vị và chủng loại, mang đến hương vị thơm ngon và cung cấp nguồn dưỡng chất tự nhiên thiết yếu cho sức khỏe cả gia đình.', 1),
(16, 'Sữa bột Aptakid New Zealand hộp thiếc 900g', '1208000', 'https://cf.shopee.vn/file/2e22ae3ff851b46730ad65bb6d6c3054', 'Sản phẩm Aptakid New Zealand MỚI (900gr) với bộ dưỡng chất Synbiotic* cùng những dưỡng chất quan trọng giúp đáp ứng nhu cầu dinh dưỡng theo sự phát triển nhanh chóng của trẻ trong những năm tháng đầu đời\r\n\r\nĐặc điểm nổi bật\r\n- Được nhập khẩu từ New Zealand\r\n- Dựa trên 40 năm nghiên cứu  về dinh dưỡng đầu đời cho trẻ, Danone ra mắt sản phẩm Aptakid NEW ZEALAND dành cho bé trên 2 tuổi:\r\n\r\n• Bộ dưỡng chất Synbiotic được cấp bằng sáng chế* là sự kết hợp độc đáo giữa Prebiotic GOS/FOS 9:1 và Probiotic B.breve M-16V giúp hỗ trợ hệ miễn dịch\r\n\r\n• Canxi và Vitamin D3 giúp răng và xương khỏe mạnh\r\n\r\n• DHA tốt cho sự phát triển của não bộ\r\n\r\n• 16 Vitamin và khoáng chất giúp trẻ phát triển bình thường và khỏe.\r\n\r\nLưu ý sử dụng và bảo quản\r\n• Sử dụng trước thời hạn in trên đáy bao bì\r\n\r\n• Sử dụng hết trong vòng 3 tuần\r\n\r\n• Bảo quản sản phẩm ở nơi khô ráo thoáng mát trước và sau khi mở hộp, hạn chế để sản phẩm tiếp xúc với không khí.', 2),
(17, 'Sữa Bột Nestle NAN ORGANIC Số 1 - Hộp 900gr', '519000', 'https://cf.shopee.vn/file/f8f7b06cf91998bca84eb36b551c16b8', 'Sản phẩm dinh dưỡng công thức Nestlé® NAN® ORGANIC 1 900g với công thức từ Thụy Sỹ, sản xuất bởi Wyeth Nutritionals (Singapore) Pte. Ltd. \r\n- Nhập khẩu chính hãng bởi Nestlé Việt Nam\r\n- Sản phẩm dinh dưỡng công thức cho trẻ dưới 2 tuổi\r\n\r\nMô tả sản phẩm\r\nSản phẩm dinh dưỡng công thức Nestlé NAN Organic 1 900G là sản phẩm dinh dưỡng công thức hữu cơ dành cho trẻ từ 0 đến 6 tháng. Nestlé NAN Organic 1 với các thành phần* đáp ứng tiêu chuẩn hữu cơ khắt khe của NASAA, cơ quan chứng nhận hữu cơ của Úc. Những thành phần có nguồn gốc từ những trang trại mà những con bò được tiếp cận với không khí trong lành và ăn các thức ăn hữu cơ. Nestlé NAN Organic 1 cung cấp cho trẻ các chất dinh dưỡng hỗ trợ cho sự phát triển khỏe mạnh về thể chất và trí não\r\n(*) sữa tách béo, lactose, đạm whey\r\nCách pha chế: \r\n1. Rửa sạch tay trước khi pha Nestlé® NAN® ORGANIC 1 cho trẻ. \r\n2. Rửa cốc và nắp đậy cho đến khi không còn bợn bẩn. \r\n3. Đun sôi cốc và nắp đậy trong 5 phút. Đậy nắp kín cho đến khi sử dụng\r\n4. Đun sôi nước trong 5 phút, để nguội bớt. \r\n5. Tham khảo bảng hướng dẫn cách pha, rót chính xác lượng nước ấm cần dùng vào cốc đã được luộc.\r\n6. Chỉ dùng muỗng lường trong hộp và gạt ngang muỗng lường vào mép/ gờ của thành hộp.\r\n7. Tham khảo bảng hướng dẫn cách pha, thêm chính xác số lượng muỗng lường (gạt ngang) tương ứng với độ tuổi của trẻ. \r\n8. Sau khi dùng, đặt muỗng lường trên giá treo bên trong hộp.\r\n9. Đậy nắp và lắc hoặc khuấy cho đều đến khi bột được hòa tan hoàn toàn và cho trẻ uống liền. Không giữ lại phần thừa nếu trẻ không uống hết.\r\n10. Cách bảo quản: đậy kín nắp hộ sau mỗi lần sử dụng và bảo quản nơi khô ráo. Nên sử dụng trong vòng 3 tuần sau khi mở hộp \r\n\r\nCách bảo quản: Đậy kín nắp hộp sau mỗi lần sử dụng và bảo quản nơi khô ráo. Nên sử dụng trong vòng 3 tuần sau khi mở hộp.\r\n\r\nHạn sử dụng: 24 tháng', 2),
(18, 'Sữa bột Similac 4 Dinh Dưỡng 5G Mới', '975000', 'https://cf.shopee.vn/file/1e128caed12d82b9ba3ebee4ce29c442', 'Similac® 4 mới dùng bổ sung dinh dưỡng cho chế độ ăn hàng ngày của trẻ 2-6 tuổi. Hệ dưỡng chất Prodi-GTM giúp trẻ phát triển tốt não bộ, tăng cường sức đề kháng và hệ tiêu hóa khỏe mạnh.\r\n\r\nHỆ DƯỠNG CHẤT PRODI-GTM GIÚP PHÁT TRIỂN NÃO BỘ\r\n\r\nBổ sung Gangliosides: là một thành phần chất béo quan trọng của màng tế bào thần kinh trong não bộ giúp hỗ trợ phát triển nhận thức ở trẻ.\r\n\r\nBộ 3 dưỡng chất vàng: lutein, vitamin E tự nhiên, DHA, cùng với AA, omega 3, omega 6, taurin và cholin giúp trẻ phát triển tốt não bộ.\r\n\r\nHệ chất béo đặc biệt không chứa dầu cọ‡ giúp tăng cường hấp thu các dưỡng chất quan trọng cho não bộ (DHA và AA).\r\n\r\nSimilac® là công thức đầu tiên trên thế giới bổ sung HMOs.#\r\n\r\n# Theo công bố của Mintel Consulting dựa trên cơ sở dữ liệu lớn nhất thế giới về giới thiệu sản phẩm mới.\r\n\r\nHƯỚNG DẪN PHA CHẾ VÀ SỬ DỤNG: Similac® 4 khi pha với nước sẽ được một thức uống dinh dưỡng để hoàn thiện chế độ ăn hàng ngày của trẻ. Rửa tay và dụng cụ thật sạch trước khi pha. Vệ sinh tốt, sử dụng và bảo quản đúng cách rất quan trọng khi bạn chuẩn bị pha Similac® 4 cho trẻ. Đun kỹ nước cho sôi, sau đó để nguội. Lường bằng muỗng đính kèm trong hộp sau đó dùng dao sạch gạt ngang. 1 muỗng Similac® 4 được pha với 60 ml (2 fl oz) nước đun sôi để nguội. Khuấy đều cho hòa tan hoàn toàn. Nếu pha nhiều hơn một lần dùng thì lượng pha dư phải được bảo quản trong tủ lạnh ở 2-4OC và chỉ dùng trong vòng 24 giờ. Khi cho trẻ uống, phải dùng trong vòng 1 giờ, đổ bỏ phần còn thừa.\r\n\r\nHẠN SỬ DỤNG: 2 năm\r\n\r\nBẢO QUẢN: Bảo quản hộp chưa mở nắp ở nhiệt độ phòng. Hộp đã mở nắp nên sử dụng trong vòng 3 tuần. Đậy nắp kín và bảo quản nơi khô mát (không để trong tủ lạnh).', 2),
(19, 'Sữa đặc có đường Ông Thọ Đỏ hộp 40g', '5000', 'https://cdn.tgdd.vn/Products/Images/2526/85167/bhx/sd-ong-tho-do-vi-40g-2-org.jpg', 'Sữa đặc Ông Thọ với vị thơm ngon, sánh đặc, là bí quyết giúp mẹ có những món ăn ngon, chăm sóc cho cả gia đình. Sữa đặc có đường Ông Thọ đỏ hộp 40g vị béo ngọt, đậm đà mà ai cũng thích, dùng chấm bánh mì, pha cà phê đều được, hộp nhỏ gọn vô cùng\r\nLoại sản phẩm Sữa đặc có đường\r\nTrọng lượng 40g\r\nThành phần Đường, dầu thực vật, đường Lactose, nước,...\r\nHương vị Ngọt đậm đà\r\nĐộ đạm 4.8g/100g\r\nThích hợp Pha cà phê\r\nThương hiệu Ông Thọ (Việt Nam)\r\nSản xuất Việt Nam\r\nHướng dẫn sử dụng: \r\nDùng để pha uống, làm sinh tố, bánh ngọt, đồ tráng miệng hoặc chấm với bánh mì. \r\nBảo quản: \r\n\r\nĐậy kín nắp sau khi khui.\r\nBảo quản lạnh sau khi mở nắp, nên sử dụng hết trong vòng 3 ngày.\r\nĐể nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp.', 3),
(20, 'Sữa đặc có đường Dutch Lady Nguyên kem lon 380g', '28000', 'https://cdn.tgdd.vn/Products/Images/2526/83920/bhx/sua-dac-co-duong-dutch-lady-nguyen-kem-lon-380g-202105221108382263.jpg', 'Sữa đặc, kem đặc có đường Dutch Lady giúp món ăn được tăng thêm vị ngon, mỗi giọt sữa đặc, kem đặc giúp món ăn dậy mùi, béo, ngon không cưỡng được. Sữa đặc có đường Dutch Lady Nguyên kem lon 380g đóng lon dễ bảo quản\r\nLoại sản phẩm Sữa đặc có đường\r\nTrọng lượng 380g\r\nThành phần Đường, nước, dầu thực vật, maltodextrin, bột whey, bột sữa gầy, bột bơ sữa, lactose, Vitamin A, D3 và B1,...\r\nHương vị Ngọt đậm đà\r\nĐộ đạm 6.97g/100g\r\nThương hiệu Dutch Lady ()\r\nSản xuất Việt Nam\r\n\r\nHướng dẫn sử dụng:\r\nCó thể sử dụng để pha uống, chấm bánh mì, hoặc chế biến thành thức uống và các món tráng miệng thơm ngon.\r\nKhông dùng cho trẻ em dưới 1 tuổi.\r\n\r\nBảo quản:\r\nBảo quản nơi khô ráo và thoáng mát.\r\nSử dụng trong vòng 4 ngày sau khi mở nắp lon.', 3),
(21, 'Sữa bột Abbott Grow 3+ 900g', '450000', 'https://concung.com/2019/06/25421-50071-large_mobile/abbott-grow-3-g-power-1-2-tuoi-900g.jpg', 'Abbott GROW GOLD 3+ với hệ dưỡng chất tiên tiến G Power+ giàu dưỡng chất và protein chất lượng cao, đủ 9 acid amin thiết yếu, giúp bé từ 3 tuổi trở lên phát triển tốt về thể chất và trí tuệ \r\nBổ sung dưỡng chất cho chế độ ăn hằng ngày, giúp trẻ phát triển tốt chiều cao, não bộ và tăng cường sức đề kháng. \r\n- Giàu vitamin D, Canxi và Phốt pho. Tỷ lệ Canxi/Phốt pho theo các khuyến nghị của Hoa Kỳ(1) cùng với Protein chất lượng cao giàu Lysin hỗ trợ hấp thu Canxi cho xương chắc khỏe và giúp phát triển chiều cao của trẻ. \r\n- Bổ sung DHA, Taurin, Cholin, sắt, kẽm, i ốt và đồng, giúp phát triển tốt não bộ và thị giác. Tryptophan giúp hỗ trợ dẫn truyền thần kinh. \r\n- Bổ sung chất xơ (Inulin và FOS) giúp hệ tiêu hóa khỏe mạnh. Các chất chống oxy hóa (vitamin A, C, E) giúp tăng cường sức đề kháng \r\nCách sử dụng:Rửa sạch tay trước khi pha. Để có 200ml Abbott GROW GOLD 3+ cho 175ml nước chín để nguội vào ly (khoảng 370C), từ từ cho vào ly 3 muỗng gạt ngang (36g) bột Abbott GROW GOLD 3+ (muỗng có sẵn trong hộp), khuấy cho tan đều. Uống ngay sau khi pha. Nếu không uống ngay, nên đậy kín cho vào tủ lạnh và dùng trong vòng 24 giờ \r\nCách bảo quản: Bảo quản hộp chưa mở ở nhiệt độ phòng. Sau khi mở nắp cần sử dụng hết trong vòng 3 tuần. Đậy nắp kín sau mỗi lần sử dụng, để nơi khô mát (không cho vào tủ lạnh) \r\n\r\nHạn sử dụng: 720 ngày từ ngày sản xuất \r\n\r\nSản xuất tại Singapore \r\nAbbott là thương hiệu sữa thuộc công ty Abbot Nutrition của Mỹ, chuyên sản phẩm dinh dưỡng dành cho trẻ em, người lớn tuổi, là một trong những thương hiệu được tin cậy nhất trên thế giới. \r\nAbbott sở hữu nhiều dòng sản phẩm đa dạng như: Ensure, Similac, Glucerna, Grow, Pediasure...Trong suốt gần một thế kỷ, Abbott đã trở thành một phần không thể thiếu của cộng đồng để mang đến cuộc sống khỏe mạnh. Phương châm toàn diện của các sản phẩm Abbott là phục vụ cuộc sống – toàn tâm với nhu cầu chăm sóc sức khỏe từ trẻ em đến người lớn tuổi. \r\n\r\n*Sản phẩm không phải là thuốc và không có tác dụng thay thế thuốc chữa bệnh. \r\n**Bao bì có thể thay đổi theo từng đợt hàng..', 2),
(22, 'Sữa tiệt trùng socola Nestlé 180ml', '8000', 'https://cdn.tgdd.vn/Products/Images/2386/252209/bhx/thung-48-hop-sua-tiet-trung-socola-nestle-180ml-202110071443383030.jpg', 'Sữa tươi tiệt trùng với công thức NutriStrong, mỗi hộp sữa tươi Nestle cung cấp đến 25% nhu cầu canxi mỗi ngày & các dưỡng chất thiết yếu như Vitamin D, A, B3, B6, B8, B9, chất đạm... cho xương chắc khỏe. Thùng 48 hộp sữa tiệt trùng socola Nestlé 180ml hương vị thơm ngon, bé nào cũng mê\r\nLoại sữa Sữa tiệt trùng socola\r\nDung tích 180ml\r\nPhù hợp với Trẻ từ 1 tuổi trở lên\r\nThành phần Sữa - milk 89% (nước, sữa bột, chất béo sữa), đường, dầu thực vật, bột ca cao, calci phosphat tự nhiên từ sữa (from milk), chất ổn định (471, 466, 460(i), 407), hương sô cô la Thụy Sĩ giống tự nhiên, các vitamin (B3, A, B9, D, B8, B6)\r\nBảo quản Bảo quản sản phẩm nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp.\r\nLưu ý Không dùng cho trẻ dưới 1 tuổi. Sản phẩm cho 1 lần sử dụng\r\nThương hiệu Nestlé (Thụy Sỹ)\r\nSản xuất tại Việt Nam', 1),
(23, 'Kem đặc có đường Lamosa lon 1kg', '42000', 'https://cdn.tgdd.vn/Products/Images/2526/221061/bhx/kem-dac-co-duong-lamosa-lon-1kg-202005111050426513.jpg', 'Là sản phẩm kem đặc được sản xuất tại Malaysia, kem đặc có đường Lamosa được làm từ váng sữa, nên bạn sẽ dễ dàng cảm nhận được độ ngậy, béo trong từng giọt kem đặc, giúp món ăn của bạn được thơm ngon hơn nhiều lần. Kem đặc có đường Lamosa lon 1kg hộp lớn tiện dùng\r\nLoại sản phẩm Kem đặc có đường\r\nTrọng lượng 1kg\r\nThành phần Đường kính, nước, sữa bột, dầu thực vật (dầu cọ), chất ổn định (E145, E339(i), E407), vitamin (B1, A, D3)\r\nHương vị Ngọt đậm đà\r\nThích hợp Pha cà phê, làm sữa chua, bánh flan..., xay sinh tố\r\nThương hiệu Lamosa (Việt Nam)\r\nSản xuất Malaysia', 3),
(24, 'Kem đặc có đường Trường Sinh lon 380g', '18600', 'https://cdn.tgdd.vn/Products/Images/2526/87245/bhx/sd-truong-sinh-trang-lon-380g-2-org.jpg', 'Kem đặc Trường Sinh với vị ngọt đậm đà, độ sánh mịn phù hợp với mọi nhu cầu sử dụng. Kem đặc mang lại vị ngon-ngọt-béo thơm ngon, hấp dẫn. Kem đặc có đường Trường Sinh lon 380g thơm ngon, đóng lon tiện dùng\r\nLoại sản phẩm Kem đặc có đường\r\nTrọng lượng 380g\r\nThành phần Đường, nước, bột sữa, dầu cá giàu DHA,...\r\nHương vị Ngọt dịu, béo\r\nĐộ đạm 2.7g/100g\r\nThích hợp Pha cà phê, làm sữa chua, bánh flan...\r\nThương hiệu Trường Sinh (Việt Nam)\r\nSản xuất Việt Nam\r\n\r\nHướng dẫn sử dụng:\r\nDùng pha chế thức uống, ăn với bánh mì, làm sữa chua...\r\nPha 1 phần sản phẩm vào trong 3 phần nước ấm đã đun sôi.\r\nKhông dùng cho trẻ dưới 1 tuổi.\r\nNên sử dụng trong vòng 4 ngày sau khi mở nắp lon.\r\n\r\nBảo quản:\r\nNơi khô ráo, thoáng mát.\r\nSau khi mở hộp, nên đậy kín và bảo quản trong tủ lạnh.', 3),
(25, 'Sữa bột dành cho người bị tiểu đường Glucerna Abbott 400g', '405000', 'https://suabottot.com/wp-content/uploads/2020/10/sua-abbott-glucerna-400g.jpg', 'Sữa Glucerna mới với công thức cải tiến giúp kiểm soát tốt đường huyết trong 4 giờ, hỗ trợ tích cực cho người bệnh tiểu đường, đái tháo đường.\r\n\r\nHướng dẫn sử dụng: Để pha 1 ly 237 ml, cho 200 ml nước chín để nguội vào ly. Vừa từ từ cho vào ly 5 muỗng gạt ngang (muỗng có sẵn trong hộp) trương đương 52,1g bột Glucerna, vừa khuấy đều cho đến khi bột tan hết.\r\n* Hướng dẫn bảo quản: Hộp đã mở phải được dậy kín, giữ ở nơi khô mát nhưng KHÔNG được để trong tủ lạnh. Khi đã mở hộp, sử dụng tối đa trong vòng 3 tuần. Glucerna đã pha nên dùng ngay hoặc đậy kín, giữ lạnh và dùng trong vòng 24 giờ.\r\n* Lưu ý quan trọng: Glucerna được dùng để bổ sung dinh dưỡng cho bệnh nhân đái tháo đường và tiền đái tháo đường. Sử dụng dưới sự giám sát y tế. Không dùng cho trẻ em dưới 13 tuổi trừ khi có chỉ định của thầy thuốc hoặc chuyên viên y tế.\r\nHạn sử dụng : 2 năm tính từ ngày sản xuất\r\n* Thực phẩm không phải thuốc, không có tác dụng thay thế thuốc chữa bệnh.\r\n* Nuôi ăn qua ống thông: Theo hướng dẫn của bác sĩ/ chuyên gia về dinh dưỡng. Khi bắt đầu nuôi ăn qua ống thông, phải điều chỉnh lưu lượng, thể tích và độ pha loãng tùy thuộc vào tình trạng và sự dung nạp của người bệnh. Lưu ý đề phòng sự nhiễm khuẩn trong quá trình chuẩn bị và nuôi ăn qua ống thông. Không dùng cho người bệnh galactosemia. KHÔNG DÙNG QUA ĐƯỜNG TĨNH MẠCH.', 2);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;