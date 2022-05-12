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
import com.example.milkshop.adapter.SpTheoLoaiAdapter;
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

public class SpTheoLoaiActivity extends AppCompatActivity {
    Toolbar toolbarSpTheoLoai;
    RecyclerView recyclerViewSpTheoLoai;
    CompositeDisposable compositeDisposable;
    ApiBanHang apiBanHang;
    int page;
    int loai;
    List<SanPham> sanPhamList;
    SpTheoLoaiAdapter spTheoLoaiAdapter;
    LinearLayoutManager linearLayoutManager;
    Handler handler;
    boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addControls();
        ActionToolBar();
        getData(page);
        addEvents();
    }

    private void addControls() {
        compositeDisposable = new CompositeDisposable();
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        page = 1;
        loai = getIntent().getIntExtra("loai", 1);
        switch (loai) {
            case 1:
                setContentView(R.layout.activity_sua_tuoi);
                recyclerViewSpTheoLoai = findViewById((R.id.recycleview_suatuoi));
                break;
            case 2:
                setContentView(R.layout.activity_sua_bot);
                recyclerViewSpTheoLoai = findViewById((R.id.recycleview_suabot));
                break;
            case 3:
                setContentView(R.layout.activity_sua_dac);
                recyclerViewSpTheoLoai = findViewById((R.id.recycleview_suadac));
                break;
        }
        toolbarSpTheoLoai = findViewById(R.id.toolbar_sptheoloai);
        linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerViewSpTheoLoai.setLayoutManager(linearLayoutManager);
        recyclerViewSpTheoLoai.setHasFixedSize(true);
        sanPhamList = new ArrayList<>();
        handler = new Handler();
        isLoading = false;
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarSpTheoLoai);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarSpTheoLoai.setNavigationOnClickListener(view -> finish());
    }

    private void getData(int page) {
        compositeDisposable.add(apiBanHang.getSpTheoLoai(page, loai)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamModel -> {
                            if (sanPhamModel.isSuccess()) {
                                if (spTheoLoaiAdapter == null) { // Không có data
                                    sanPhamList = sanPhamModel.getResult();
                                    spTheoLoaiAdapter = new SpTheoLoaiAdapter(getApplicationContext(), sanPhamList);
                                    recyclerViewSpTheoLoai.setAdapter(spTheoLoaiAdapter);
                                } else { // Đã có data
                                    int pos = sanPhamList.size() - 1;
                                    int addAmount = sanPhamModel.getResult().size();
                                    for (int i = 0; i < addAmount; ++i) {
                                        sanPhamList.add(sanPhamModel.getResult().get(i));
                                    }
                                    spTheoLoaiAdapter.notifyItemRangeInserted(pos, addAmount);
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
        recyclerViewSpTheoLoai.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isLoading) {
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == sanPhamList.size() - 1) {
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
                sanPhamList.add(null);
                spTheoLoaiAdapter.notifyItemInserted(sanPhamList.size() - 1);
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sanPhamList.remove(sanPhamList.size() - 1);
                spTheoLoaiAdapter.notifyItemRemoved(sanPhamList.size() - 1);
                page += 1;
                getData(page);
                spTheoLoaiAdapter.notifyDataSetChanged();
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
