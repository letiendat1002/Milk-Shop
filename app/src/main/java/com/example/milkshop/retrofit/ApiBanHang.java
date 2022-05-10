package com.example.milkshop.retrofit;

import com.example.milkshop.model.LoaiSpModel;
import com.example.milkshop.model.SanPhamModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBanHang {
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getsanpham.php")
    Observable<SanPhamModel> getSanPham();

    @POST("chitiet.php")
    @FormUrlEncoded
    Observable<SanPhamModel> getPhanLoai(
            @Field("page") int page,
            @Field("loai") int loai
    );
}
