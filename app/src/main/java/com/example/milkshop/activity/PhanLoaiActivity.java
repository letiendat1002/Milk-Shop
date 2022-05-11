package com.example.milkshop.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class PhanLoaiActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable;
    ApiBanHang apiBanHang;
    int page;
    int loai;
    List<SanPham> mangsanpham;
    PhanLoaiAdapter phanLoaiAdapter;
    LinearLayoutManager linearLayoutManager;
    Handler handler;
    boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loai = getIntent().getIntExtra("loai", 1);
        switch (loai) {
            case 1:
                setContentView(R.layout.activity_sua_tuoi);
                recyclerView = findViewById((R.id.recycleview_suatuoi));
                break;
            case 2:
                setContentView(R.layout.activity_sua_bot);
                recyclerView = findViewById((R.id.recycleview_suabot));
                break;
            case 3:
                setContentView(R.layout.activity_sua_dac);
                recyclerView = findViewById((R.id.recycleview_suadac));
                break;
        }
        addControls();
        ActionToolBar();
        getData(page);
        addEvents();
    }

    private void addControls() {
        compositeDisposable = new CompositeDisposable();
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        page = 1;
        toolbar = findViewById(R.id.toolbar);

        linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        mangsanpham = new ArrayList<>();

        handler = new Handler();
        isLoading = false;
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void getData(int page) {
        compositeDisposable.add(apiBanHang.getPhanLoai(page, loai)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamModel -> {
                            if (sanPhamModel.isSuccess()) {
                                if (phanLoaiAdapter == null) { // Không có data
                                    mangsanpham = sanPhamModel.getResult();
                                    phanLoaiAdapter = new PhanLoaiAdapter(getApplicationContext(), mangsanpham);
                                    recyclerView.setAdapter(phanLoaiAdapter);
                                } else { // Đã có data
                                    int pos = mangsanpham.size() - 1;
                                    int addAmount = sanPhamModel.getResult().size();
                                    for (int i = 0; i < addAmount; ++i) {
                                        mangsanpham.add(sanPhamModel.getResult().get(i));
                                    }
                                    phanLoaiAdapter.notifyItemRangeInserted(pos, addAmount);
                                }
                            } else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "No More Product Available",
                                        Toast.LENGTH_SHORT).show();
                                isLoading = true;
                            }
                        },
                        throwable -> Toast.makeText(
                                getApplicationContext(),
                                "Không kết nối được với server\n" + throwable.getMessage(),
                                Toast.LENGTH_LONG
                        ).show()
                ));
    }

    private void addEvents() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isLoading) {
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == mangsanpham.size() - 1) {
                        isLoading = true;
                        loadMore();
                    }
                }
            }
        });
    }

    private void loadMore() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                // add null
                mangsanpham.add(null);
                phanLoaiAdapter.notifyItemInserted(mangsanpham.size() - 1);
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mangsanpham.remove(mangsanpham.size() - 1);
                phanLoaiAdapter.notifyItemRemoved(mangsanpham.size() - 1);
                page += 1;
                getData(page);
                phanLoaiAdapter.notifyDataSetChanged();
                isLoading = false;
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}
