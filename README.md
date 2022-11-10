# MILK SHOP

## I. TỔNG QUAN

Milk Shop được lên ý tưởng dựa trên hai app là Tiki và Rino.

<p align="center">
    <img width="50%" src="https://i.ibb.co/NyLzVtc/tiki.png" alt="Tiki"/>
</p>

<p align="center">
  <img width="50%" src="https://i.ibb.co/w7DVg6P/rino.png" alt="Rino"/>
</p>

<p align="justify"> Tiki ban đầu chỉ bán một loại mặt hàng liên quan tới sách cũng giống như Milk Shop hiện tại chỉ bán một loại mặt hàng là bơ sữa. Còn Rino là một app bách hoá online còn mới trên thị trường nhưng có đặc điểm là nhà phân phối, cung cấp dịch vụ duy nhất trên nền tảng và có giao diện khá thân thiện với người dùng. </p>

<p align="justify"> Milk Shop là sự kết hợp giữa các ý tưởng trên của cả hai app Rino và Tiki, một ứng dụng chuyên cung cấp các sản phẩm bơ sữa bởi một nhà phân phối duy nhất.</p>

## II. GIAO DIỆN ỨNG DỤNG

- _Logo ứng dụng_

  <img src="https://i.ibb.co/8zsMkzw/logo.png" alt="Logo"/>

- _Màn hình loading khi vào ứng dụng_

  <img width="30%" src="https://i.ibb.co/HqbZ8L9/loading.png" alt="Loading Screen"/>

- _Giao diện trang chủ_
  
  <img width="30%" src="https://i.ibb.co/SN81qpW/home-page.png" alt="Home Page"/>

- _Giao diện chi tiết sản phẩm_
  
  <img width="30%" src="https://i.ibb.co/Dp1vfJ5/product.png" alt="Product Detail"/>

- _Giao diện giỏ hàng_

  <img width="30%" src="https://i.ibb.co/VJt9XdF/shopping-cart.png" alt="Shopping Cart"/>

- _Giao diện thanh toán_
  
  <img width="30%" src="https://i.ibb.co/6866j4p/payment-1.png" alt="Payment 1"/> 
  
  <img width="30%" src="https://i.ibb.co/vY24Q8k/payment-2.png" alt="Payment 2"/>

- _Giao diện xem đơn hàng_
  
  <img width="30%" src="https://i.ibb.co/2cW2xyr/my-purchases.png" alt="My Purchases"/>

## III. CÔNG NGHỆ VÀ THƯ VIỆN HỖ TRỢ

### Công nghệ sử dụng

- **Ngôn ngữ:** Java, PHP, SQL
- Sử dụng phpMyAdmin để quản trị MySQL Database ở localhost.

### Thư viện hỗ trợ

- **Glide** : Hỗ trợ load ảnh.

- **Notification Badge** : Hiển thị thay đổi số lượng sản phẩm trong giỏ hàng.

- **EventBus** : Hỗ trợ giao tiếp gửi nhận các components giữa các Activity, Fragment, … khác nhau.

- **Retrofit** : Hỗ trợ giao thức HTTP để kết nối, lấy dữ liệu từ database về, convert dữ liệu từ dạng json thành java object, hoặc ngược lại.

- **RxJava** : Hỗ trợ xử lý dữ liệu bất đồng bộ.

## IV. HƯỚNG PHÁT TRIỂN TIẾP THEO

- _Cải thiện thêm UX/UI._
- _Bổ sung số lượng tồn kho cho sản phẩm để giới hạn số lượng đặt hàng._
- _Chức năng đăng nhập, đăng ký, quản lý tài khoản user._
- _Lưu trữ thông tin giỏ hàng của từng user trong database._
- _Quản lý thông tin giỏ hàng và quản lý đơn hàng của khách hàng._
- _Tạo app quản lý riêng cho admin._
- _Thông báo Notification ở app user, gửi nhận Notification giữa app quản lý và app user._
- ...

**[⬆ Lên đầu trang](#milk-shop)**
