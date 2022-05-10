package com.example.milkshop.retrofit;

import com.example.milkshop.model.LoaiSpModel;
import com.example.milkshop.model.SanPhamModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiBanHang {
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getsanpham.php")
    Observable<SanPhamModel> getSanPham();
}
