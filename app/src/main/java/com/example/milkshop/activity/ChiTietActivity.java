package com.example.milkshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.milkshop.R;
import com.example.milkshop.model.GioHang;
import com.example.milkshop.model.SanPham;
import com.example.milkshop.utils.Utils;
import com.nex3z.notificationbadge.NotificationBadge;

import java.text.DecimalFormat;
import java.util.Objects;

public class ChiTietActivity extends AppCompatActivity {
    TextView tvTenSpChiTiet, tvGiaSpChiTiet, tvMoTaChiTiet, tvSoLuongChiTiet;
    Button btnAddToCartChiTiet;
    ImageView ivHinhAnhChiTiet, ivTruChiTiet, ivCongChiTiet;
    Toolbar toolbarChiTiet;
    SanPham sanPham;
    NotificationBadge badgeChiTiet;
    FrameLayout frameLayoutIconGioHangChiTiet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        addControls();
        ActionToolBar();
        addData();
        addEvents();
    }

    private void addControls() {
        tvTenSpChiTiet = findViewById(R.id.tvTenSp_chitiet);
        tvGiaSpChiTiet = findViewById(R.id.tvGiaSp_chitiet);
        tvMoTaChiTiet = findViewById(R.id.tvMoTa_chitiet);
        tvSoLuongChiTiet = findViewById(R.id.tvSoLuong_chitiet);
        btnAddToCartChiTiet = findViewById(R.id.btnAddToCart_chitiet);
        ivHinhAnhChiTiet = findViewById(R.id.ivHinhAnh_chitiet);
        ivTruChiTiet = findViewById(R.id.ivTru_chitiet);
        ivCongChiTiet = findViewById(R.id.ivCong_chitiet);
        toolbarChiTiet = findViewById(R.id.toolbar_chitiet);
        badgeChiTiet = findViewById(R.id.badge_chitiet);
        frameLayoutIconGioHangChiTiet = findViewById(R.id.frame_icon_giohang_chitiet);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarChiTiet);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarChiTiet.setNavigationOnClickListener(view -> finish());
    }

    private void addData() {
        if (Utils.gioHangList != null) {
            int totalItems = 0;
            for (int i = 0; i < Utils.gioHangList.size(); i++) {
                totalItems += Utils.gioHangList.get(i).getSoluong();
            }
            badgeChiTiet.setText(String.valueOf(totalItems));
        }
        sanPham = (SanPham) getIntent().getSerializableExtra("chitiet");
        tvTenSpChiTiet.setText(sanPham.getTensp().trim());
        tvMoTaChiTiet.setText(sanPham.getMota().trim());
        Glide.with(getApplicationContext()).load(sanPham.getHinhanh()).into(ivHinhAnhChiTiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        String price = decimalFormat.format(Double.parseDouble(sanPham.getGiasp())) + "₫";
        tvGiaSpChiTiet.setText(price);
    }

    private void addEvents() {
        btnAddToCartChiTiet.setOnClickListener(view -> themGioHang());
        frameLayoutIconGioHangChiTiet.setOnClickListener(view -> startActivity(new Intent(
                getApplicationContext(),
                GioHangActivity.class)
        ));

        ivTruChiTiet.setOnClickListener(view -> {
            int amount = Integer.parseInt(tvSoLuongChiTiet.getText().toString());
            if (amount == 1)
                ivTruChiTiet.setClickable(false);
            tvSoLuongChiTiet.setText(String.valueOf(amount - 1));
        });

        ivCongChiTiet.setOnClickListener(view -> {
            int amount = Integer.parseInt(tvSoLuongChiTiet.getText().toString());
            if (amount == 0)
                ivTruChiTiet.setClickable(true);
            tvSoLuongChiTiet.setText(String.valueOf(amount + 1));
        });
    }

    private void themGioHang() {
        if (Utils.gioHangList.size() > 0) {
            boolean flag = false;
            int soluong = Integer.parseInt(tvSoLuongChiTiet.getText().toString());
            for (int i = 0; i < Utils.gioHangList.size(); i++) {
                if (Utils.gioHangList.get(i).getId() == sanPham.getId()) {
                    Utils.gioHangList.get(i).setSoluong(soluong + Utils.gioHangList.get(i).getSoluong());
                    long gia = Long.parseLong(sanPham.getGiasp()) * Utils.gioHangList.get(i).getSoluong();
                    Utils.gioHangList.get(i).setGiasp(gia);
                    flag = true;
                }
            }
            if (!flag) {
                long gia = Long.parseLong(sanPham.getGiasp()) * soluong;
                GioHang gioHang = new GioHang();
                gioHang.setGiasp(gia);
                gioHang.setSoluong(soluong);
                gioHang.setGiasp(gia);
                gioHang.setId(sanPham.getId());
                gioHang.setTensp(sanPham.getTensp());
                gioHang.setHinhanh(sanPham.getHinhanh());
                Utils.gioHangList.add(gioHang);

            }

        } else {
            int soluong = Integer.parseInt(tvSoLuongChiTiet.getText().toString());
            long gia = Long.parseLong(sanPham.getGiasp()) * soluong;
            GioHang gioHang = new GioHang();
            gioHang.setGiasp(gia);
            gioHang.setSoluong(soluong);
            gioHang.setId(sanPham.getId());
            gioHang.setTensp(sanPham.getTensp());
            gioHang.setHinhanh(sanPham.getHinhanh());
            Utils.gioHangList.add(gioHang);
        }

        // Update Badge
        int totalItems = 0;
        for (int i = 0; i < Utils.gioHangList.size(); ++i) {
            totalItems += Utils.gioHangList.get(i).getSoluong();
        }
        badgeChiTiet.setText(String.valueOf(totalItems));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.gioHangList != null) {
            int totalItems = 0;
            for (int i = 0; i < Utils.gioHangList.size(); i++) {
                totalItems += Utils.gioHangList.get(i).getSoluong();
            }
            badgeChiTiet.setText(String.valueOf(totalItems));
        }
    }
}