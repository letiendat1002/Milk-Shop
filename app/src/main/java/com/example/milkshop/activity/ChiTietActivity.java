package com.example.milkshop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.milkshop.R;
import com.example.milkshop.model.GioHang;
import com.example.milkshop.model.SanPham;
import com.example.milkshop.utils.Utils;
import com.nex3z.notificationbadge.NotificationBadge;

import java.text.DecimalFormat;
import java.util.Objects;

import okhttp3.internal.Util;

public class ChiTietActivity extends AppCompatActivity {
    TextView tensp ,giasp, mota;
    Button btnthem;
    ImageView imghinhanh;
    Spinner spinner;
    Toolbar toolbar;
    SanPham sanPham;
    NotificationBadge badge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        initView();
        ActionToolBar();
        IntiData();
        intiControl();
    }

    private void intiControl() {
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themGioHang();

            }
        });
    }


    private void themGioHang() {
        if(Utils.manggiohang.size()>0){
            boolean flag = false;
            int soluong =Integer.parseInt(spinner.getSelectedItem().toString());
            for(int i = 0 ;i<Utils.manggiohang.size();i++){
                if(Utils.manggiohang.get(i).getIdsp()== sanPham.getId()){
                    Utils.manggiohang.get(i).setSoluong(soluong+Utils.manggiohang.get(i).getSoluong());
                    long gia = Long.parseLong(sanPham.getGiasp())* Utils.manggiohang.get(i).getSoluong();
                    Utils.manggiohang.get(i).setGiasp(gia);
                    flag=true;
                }
            }
            if(flag ==false){
                long gia = Long.parseLong(sanPham.getGiasp())*soluong;
                GioHang gioHang = new GioHang();
                gioHang.setGiasp(gia);
                gioHang.setSoluong(soluong);
                gioHang.setGiasp(gia);
                gioHang.setIdsp(sanPham.getId());
                gioHang.setTensp(sanPham.getTensp());
                gioHang.setHinhsp(sanPham.getHinhanh());
                Utils.manggiohang.add(gioHang);

            }

        }else{
            int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
            long gia = Long.parseLong(sanPham.getGiasp())*soluong;
            GioHang gioHang = new GioHang();
            gioHang.setGiasp(gia);
            gioHang.setSoluong(soluong);
            gioHang.setGiasp(gia);
            gioHang.setIdsp(sanPham.getId());
            gioHang.setTensp(sanPham.getTensp());
            gioHang.setHinhsp(sanPham.getHinhanh());
            Utils.manggiohang.add(gioHang);

        }
        badge.setText(String.valueOf(Utils.manggiohang.size()));
    }

    private void IntiData() {
        SanPham sanPham = (SanPham) getIntent().getSerializableExtra("chitiet");
        tensp.setText(sanPham.getTensp());
        mota.setText(sanPham.getMota());
        Glide.with(getApplicationContext()).load(sanPham.getHinhanh()).into(imghinhanh);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        giasp.setText("Giá :" +decimalFormat.format(Double.parseDouble(sanPham.getGiasp())) + "đ");
        Integer[] so = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> adapterspin =  new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,so);
        spinner.setAdapter(adapterspin);
    }

    private void initView() {
        tensp = findViewById(R.id.txttensp);
        giasp = findViewById(R.id.txtgiasp);
        mota = findViewById(R.id.txtmotachitiet);
        spinner = findViewById(R.id.spinner);
        btnthem = findViewById(R.id.btnthemvaogiohang);
        imghinhanh = findViewById(R.id.imgchitiet);
        toolbar = findViewById(R.id.toolbar);
        badge =findViewById(R.id.menu_sl);
        if(Utils.manggiohang != null){
            badge.setText(String.valueOf(Utils.manggiohang.size()));
        }
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationContentDescription(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        };
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}