package com.example.milkshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
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
    TextView tensp, giasp, mota;
    Button btnThem;
    ImageView imgHinhAnh;
    Spinner spinner;
    Toolbar toolbar;
    SanPham sanPham;
    NotificationBadge badge;
    FrameLayout frame_icon_giohang;


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
        tensp = findViewById(R.id.tvTenSp_chitiet);
        giasp = findViewById(R.id.tvGiaSp_chitiet);
        mota = findViewById(R.id.tvMoTa_chitiet);
        spinner = findViewById(R.id.spinner_chitiet);
        btnThem = findViewById(R.id.btnAddToCart_chitiet);
        imgHinhAnh = findViewById(R.id.ivHinhAnh_chitiet);
        toolbar = findViewById(R.id.toolbar);
        badge = findViewById(R.id.menu_sl);
        frame_icon_giohang = findViewById(R.id.frame_icon_giohang);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    private void addData() {
        if (Utils.gioHangList != null) {
            int totalItems = 0;
            for (int i = 0; i < Utils.gioHangList.size(); i++){
                totalItems += Utils.gioHangList.get(i).getSoluong();
            }
            badge.setText(String.valueOf(totalItems));
        }
        sanPham = (SanPham) getIntent().getSerializableExtra("chitiet");
        tensp.setText(sanPham.getTensp().trim());
        mota.setText(sanPham.getMota().trim());
        Glide.with(getApplicationContext()).load(sanPham.getHinhanh()).into(imgHinhAnh);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        String price = decimalFormat.format(Double.parseDouble(sanPham.getGiasp())) + "₫";
        giasp.setText(price);
        Integer[] itemSpinner = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                itemSpinner
        );
        spinner.setAdapter(spinnerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.gioHangList != null) {
            int totalItems = 0;
            for (int i = 0; i < Utils.gioHangList.size(); i++){
                totalItems += Utils.gioHangList.get(i).getSoluong();
            }
            badge.setText(String.valueOf(totalItems));
        }
    }

    private void addEvents() {
        btnThem.setOnClickListener(view -> themGioHang());
        frame_icon_giohang.setOnClickListener(view -> startActivity(new Intent(
                getApplicationContext(),
                GioHangActivity.class)
        ));
    }

    private void themGioHang() {
        if (Utils.gioHangList.size() > 0) {
            boolean flag = false;
            int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
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
            int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
            long gia = Long.parseLong(sanPham.getGiasp()) * soluong;
            GioHang gioHang = new GioHang();
            gioHang.setGiasp(gia);
            gioHang.setSoluong(soluong);
            gioHang.setId(sanPham.getId());
            gioHang.setTensp(sanPham.getTensp());
            gioHang.setHinhanh(sanPham.getHinhanh());
            Utils.gioHangList.add(gioHang);
        }

        int totalItems = 0;
        for (int i = 0; i < Utils.gioHangList.size(); ++i) {
            totalItems += Utils.gioHangList.get(i).getSoluong();
        }
        badge.setText(String.valueOf(totalItems));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}