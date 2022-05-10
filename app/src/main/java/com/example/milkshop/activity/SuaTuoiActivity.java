package com.example.milkshop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.milkshop.R;
import com.example.milkshop.adapter.PhanLoaiAdapter;
import com.example.milkshop.model.SanPham;
import com.example.milkshop.retrofit.ApiBanHang;
import com.example.milkshop.retrofit.RetrofitClient;
import com.example.milkshop.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SuaTuoiActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanHang apiBanHang;
    int page = 1;
    int loai;
    List<SanPham> mangsanpham;
    PhanLoaiAdapter phanLoaiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_tuoi);
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        loai = getIntent().getIntExtra("loai", 1);
        addControls();
        ActionToolBar();
        getData();
    }

    private void addControls() {
        toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById((R.id.recycleview_suatuoi));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mangsanpham = new ArrayList<>();
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void getData() {
        compositeDisposable.add(apiBanHang.getPhanLoai(page, loai)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamModel -> {
                            if (sanPhamModel.isSuccess()){
                                mangsanpham = sanPhamModel.getResult();
                                phanLoaiAdapter = new PhanLoaiAdapter(getApplicationContext(), mangsanpham);
                                recyclerView.setAdapter(phanLoaiAdapter);
                            }
                        },
                        throwable -> Toast.makeText(
                                getApplicationContext(),
                                "Không kết nối được với server\n" + throwable.getMessage(),
                                Toast.LENGTH_LONG
                        ).show()
                ));
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}