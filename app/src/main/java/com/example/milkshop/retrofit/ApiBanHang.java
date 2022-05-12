package com.example.milkshop.retrofit;

import com.example.milkshop.model.DanhMucSpModel;
import com.example.milkshop.model.SanPhamModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBanHang {
    @GET("getdanhmucsp.php")
    Observable<DanhMucSpModel> getDanhMucSp();

    @GET("getsanpham.php")
    Observable<SanPhamModel> getSanPham();

    @POST("getsptheoloai.php")
    @FormUrlEncoded
    Observable<SanPhamModel> getSpTheoLoai(
            @Field("page") int page,
            @Field("loai") int loai
    );
}
