package com.example.milkshop.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.milkshop.R;
import com.example.milkshop.adapter.LoaiSpAdapter;
import com.example.milkshop.adapter.SanPhamAdapter;
import com.example.milkshop.model.LoaiSp;
import com.example.milkshop.model.SanPham;
import com.example.milkshop.retrofit.ApiBanHang;
import com.example.milkshop.retrofit.RetrofitClient;
import com.example.milkshop.utils.Utils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerViewHome;
    NavigationView navigationView;
    ListView listViewHome;
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    // Category
    LoaiSpAdapter loaiSpAdapter;
    List<LoaiSp> mangloaisp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanHang apiBanHang;
    // Product
    List<SanPham> mangsanpham;
    SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        addControls();
        addEvents();
        ActionBar();
        if (isConnected(this)) {
            ActionViewFlipper();
            getLoaiSanPham();
            getSanPham();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Thiết bị không có internet. Vui lòng kiểm tra lại!",
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    private void getSanPham() {
        compositeDisposable.add(apiBanHang.getSanPham()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamModel -> {
                            if (sanPhamModel.isSuccess()) {
                                mangsanpham = sanPhamModel.getResult();
                                sanPhamAdapter = new SanPhamAdapter(getApplicationContext(), mangsanpham);
                                recyclerViewHome.setAdapter(sanPhamAdapter);
                            }
                        },
                        throwable -> Toast.makeText(
                                getApplicationContext(),
                                "Không kết nối được với server\n" + throwable.getMessage(),
                                Toast.LENGTH_LONG
                        ).show()
                ));
    }

    private void getLoaiSanPham() {
        compositeDisposable.add(apiBanHang.getLoaiSp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        loaiSpModel -> {
                            if (loaiSpModel.isSuccess()) {
                                mangloaisp = loaiSpModel.getResult();
                                loaiSpAdapter = new LoaiSpAdapter(getApplicationContext(), mangloaisp);
                                listViewHome.setAdapter(loaiSpAdapter);
                            }
                        },
                        throwable -> Toast.makeText(
                                getApplicationContext(),
                                "Không kết nối được với server\n" + throwable.getMessage(),
                                Toast.LENGTH_LONG
                        ).show()
                ));
    }

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://img.freepik.com/free-vector/milk-splash-banner_87720-2006.jpg");
        mangquangcao.add("https://www.vinamilk.com.vn/sua-tuoi-vinamilk/wp-content/uploads/2021/05/VNM_Green-Farm_Banner_1920x914_2_en.jpg");
        mangquangcao.add("https://www.thmilk.vn/wp-content/uploads/2021/09/Website.jpg");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
    }

    private void addControls() {
        toolbar = findViewById(R.id.toolbarhome);

        recyclerViewHome = findViewById(R.id.recycleview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewHome.setLayoutManager(layoutManager);
        recyclerViewHome.setHasFixedSize(true);

        navigationView = findViewById(R.id.navigationview);
        listViewHome = findViewById(R.id.listviewhome);
        drawerLayout = findViewById(R.id.drawerlayout);
        viewFlipper = findViewById(R.id.viewFlipper);
        // Khoi tao list
        mangloaisp = new ArrayList<>();
        mangsanpham = new ArrayList<>();
        if (Utils.manggiohang == null) {
            Utils.manggiohang = new ArrayList<>();
        }
    }

    // Kiem tra thiet bi co ket noi internet khong? Wifi + Mobile data
    private boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE
        );
        NetworkInfo activeNetwork = null;
        if (connectivityManager != null) {
            activeNetwork = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetwork != null;
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    private void addEvents() {
        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;
                    case 1: // Sua Tuoi
                        Intent suatuoi = new Intent(getApplicationContext(), PhanLoaiActivity.class);
                        suatuoi.putExtra("loai", 1);
                        startActivity(suatuoi);
                        break;
                    case 2: // Sua Bot
                        Intent suabot = new Intent(getApplicationContext(), PhanLoaiActivity.class);
                        suabot.putExtra("loai", 2);
                        startActivity(suabot);
                        break;
                    case 3: // Sua Dac
                        Intent suadac = new Intent(getApplicationContext(), PhanLoaiActivity.class);
                        suadac.putExtra("loai", 3);
                        startActivity(suadac);
                        break;
                    case 4:
                        String hotline = "tel:" + "19006666";
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(hotline)));
                        break;
                }
            }
        });
    }
}