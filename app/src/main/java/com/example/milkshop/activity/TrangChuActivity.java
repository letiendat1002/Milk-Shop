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
import android.widget.FrameLayout;
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
import com.example.milkshop.adapter.DanhMucSpAdapter;
import com.example.milkshop.adapter.SanPhamAdapter;
import com.example.milkshop.model.DanhMucSp;
import com.example.milkshop.model.SanPham;
import com.example.milkshop.retrofit.ApiBanHang;
import com.example.milkshop.retrofit.RetrofitClient;
import com.example.milkshop.utils.Utils;
import com.google.android.material.navigation.NavigationView;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TrangChuActivity extends AppCompatActivity {
    Toolbar toolbarHome;
    RecyclerView recyclerViewHome;
    NavigationView navigationViewHome;
    ListView listViewHome;
    DrawerLayout drawerLayoutHome;
    ViewFlipper viewFlipperHome;
    CompositeDisposable compositeDisposable;
    ApiBanHang apiBanHang;
    // Category
    DanhMucSpAdapter danhMucSpAdapter;
    List<DanhMucSp> danhMucSpList;
    // Product
    List<SanPham> sanPhamList;
    SanPhamAdapter sanPhamAdapter;
    NotificationBadge badgeHome;
    FrameLayout frameLayoutIconGioHangHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        addControls();
        addEvents();
        ActionBar();
        if (isConnected(this)) {
            ActionViewFlipper();
            getDanhMucSanPham();
            getSanPham();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Thiết bị không có internet. Vui lòng kiểm tra lại!",
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    private void addControls() {
        compositeDisposable = new CompositeDisposable();
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        toolbarHome = findViewById(R.id.toolbar_home);

        recyclerViewHome = findViewById(R.id.recyclerview_home);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewHome.setLayoutManager(layoutManager);
        recyclerViewHome.setHasFixedSize(true);

        navigationViewHome = findViewById(R.id.navigationview_home);
        listViewHome = findViewById(R.id.listview_home);
        drawerLayoutHome = findViewById(R.id.drawerlayout_home);
        viewFlipperHome = findViewById(R.id.viewFlipper_home);

        danhMucSpList = new ArrayList<>();
        sanPhamList = new ArrayList<>();

        badgeHome = findViewById(R.id.badge_home);
        frameLayoutIconGioHangHome = findViewById(R.id.frame_icon_giohang_home);

        if (Utils.gioHangList == null) {
            Utils.gioHangList = new ArrayList<>();
        } else {
            int totalItems = 0;
            for (int i = 0; i < Utils.gioHangList.size(); ++i) {
                totalItems += Utils.gioHangList.get(i).getSoluong();
            }
            badgeHome.setText(String.valueOf(totalItems));
        }
    }


    private void addEvents() {
        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: // Trang Chu
                        startActivity(new Intent(getApplicationContext(), TrangChuActivity.class));
                        break;
                    case 1: // Sua Tuoi
                        Intent suatuoi = new Intent(getApplicationContext(), SpTheoLoaiActivity.class);
                        suatuoi.putExtra("loai", 1);
                        startActivity(suatuoi);
                        break;
                    case 2: // Sua Bot
                        Intent suabot = new Intent(getApplicationContext(), SpTheoLoaiActivity.class);
                        suabot.putExtra("loai", 2);
                        startActivity(suabot);
                        break;
                    case 3: // Sua Dac
                        Intent suadac = new Intent(getApplicationContext(), SpTheoLoaiActivity.class);
                        suadac.putExtra("loai", 3);
                        startActivity(suadac);
                        break;
                    case 4: // Lien He
                        String hotline = "tel:" + "19006666";
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(hotline)));
                        break;
                }
            }
        });

        frameLayoutIconGioHangHome.setOnClickListener(view -> startActivity(new Intent(
                getApplicationContext(),
                GioHangActivity.class
        )));
    }

    private void ActionBar() {
        setSupportActionBar(toolbarHome);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarHome.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbarHome.setNavigationOnClickListener(view -> drawerLayoutHome.openDrawer(GravityCompat.START));
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

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://img.freepik.com/free-vector/milk-splash-banner_87720-2006.jpg");
        mangquangcao.add("https://www.vinamilk.com.vn/sua-tuoi-vinamilk/wp-content/uploads/2021/05/VNM_Green-Farm_Banner_1920x914_2_en.jpg");
        mangquangcao.add("https://www.thmilk.vn/wp-content/uploads/2021/09/Website.jpg");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperHome.addView(imageView);
        }
        viewFlipperHome.setFlipInterval(5000);
        viewFlipperHome.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipperHome.setInAnimation(slide_in);
        viewFlipperHome.setOutAnimation(slide_out);
    }

    private void getDanhMucSanPham() {
        compositeDisposable.add(apiBanHang.getDanhMucSp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        danhMucSpModel -> {
                            if (danhMucSpModel.isSuccess()) {
                                danhMucSpList = danhMucSpModel.getResult();
                                danhMucSpAdapter = new DanhMucSpAdapter(getApplicationContext(), danhMucSpList);
                                listViewHome.setAdapter(danhMucSpAdapter);
                            }
                        },
                        throwable -> Toast.makeText(
                                getApplicationContext(),
                                "Không kết nối được với server\n" + throwable.getMessage(),
                                Toast.LENGTH_LONG
                        ).show()
                ));
    }

    private void getSanPham() {
        compositeDisposable.add(apiBanHang.getSanPham()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamModel -> {
                            if (sanPhamModel.isSuccess()) {
                                sanPhamList = sanPhamModel.getResult();
                                sanPhamAdapter = new SanPhamAdapter(getApplicationContext(), sanPhamList);
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

    @Override
    protected void onResume() {
        super.onResume();
        int totalItems = 0;
        for (int i = 0; i < Utils.gioHangList.size(); ++i) {
            totalItems += Utils.gioHangList.get(i).getSoluong();
        }
        badgeHome.setText(String.valueOf(totalItems));
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}
