<?php
    include "connect.php";
    // Dung POST khong hien thi tren localhost thong thuong, 
    // su dung ARC https://install.advancedrestclient.com/install hoac https://jsonlint.com/ de test
    $page = $_POST['page']; 
    $total = 5; // Can lay 5 san pham tren 1 trang
    $pos = ($page - 1) * $total; // Trang 0 lay 5 san pham, trang 1 lay tu san pham thu 6
    $loai = $_POST['loai'];

    $query = 'SELECT * FROM `sanpham` WHERE `loai`= '.$loai.' LIMIT '.$page.','.$total.'';
    $data = mysqli_query($conn, $query);
    $result = array();
    while ($row = mysqli_fetch_assoc($data)){
        $result[] = ($row);
    }
    if (!empty($result)){
        $arr = [
            'success' => true,
            'message' => "thanh cong",
            'result' => $result
        ];  
    }else{
        $arr =[
            'success' => false,
            'message' => "khong thanh cong",
            'result'=> $result
        ];
    }
    print_r(json_encode($arr));
?>