package com.example.milkshop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milkshop.R;
import com.example.milkshop.adapter.GioHangAdapter;
import com.example.milkshop.model.EventBus.EmptyCartEvent;
import com.example.milkshop.model.EventBus.TinhTongEvent;
import com.example.milkshop.utils.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
import java.util.Objects;

public class GioHangActivity extends AppCompatActivity {
    TextView emptyCart, tvTongTienGioHang;
    Toolbar toolbarGioHang;
    RecyclerView recyclerViewGioHang;
    Button btnDatHangGioHang;
    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        addControls();
        ActionToolBar();
        tinhTongTien();
    }

    private void addControls() {
        emptyCart = findViewById(R.id.emptyCart_giohang);
        tvTongTienGioHang = findViewById(R.id.tvTongTien_giohang);
        toolbarGioHang = findViewById(R.id.toolbar_giohang);
        recyclerViewGioHang = findViewById(R.id.recyclerview_giohang);
        btnDatHangGioHang = findViewById(R.id.btnDatHang_giohang);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewGioHang.setLayoutManager(layoutManager);
        recyclerViewGioHang.setHasFixedSize(true);

        if (Utils.gioHangList.size() == 0) {
            emptyCart.setVisibility(View.VISIBLE);
        } else {
            gioHangAdapter = new GioHangAdapter(getApplicationContext(), Utils.gioHangList);
            recyclerViewGioHang.setAdapter(gioHangAdapter);
        }
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarGioHang);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarGioHang.setNavigationOnClickListener(view -> finish());
    }

    private void tinhTongTien() {
        long tongtiensp = 0;
        for (int i = 0; i < Utils.gioHangList.size(); i++) {
            tongtiensp += (Utils.gioHangList.get(i).getGiasp() * Utils.gioHangList.get(i).getSoluong());
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        String formattedPrice = decimalFormat.format(tongtiensp) + "₫";
        tvTongTienGioHang.setText(formattedPrice);

    }

    private void setEmptyCart() {
        emptyCart.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void eventTinhTien(TinhTongEvent event) {
        if (event != null)
            tinhTongTien();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void eventEmptyCart(EmptyCartEvent event) {
        if (event != null)
            setEmptyCart();
    }
}