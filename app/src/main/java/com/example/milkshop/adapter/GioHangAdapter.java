package com.example.milkshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.milkshop.Interface.ImageClickListenner;
import com.example.milkshop.R;
import com.example.milkshop.model.GioHang;

import java.text.DecimalFormat;
import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.MyViewHolder> {
    Context context;
    List<GioHang> gioHangList;

    public GioHangAdapter(Context context, List<GioHang> array) {
        this.context = context;
        this.gioHangList = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_giohang,
                parent,
                false
        );
        return new GioHangAdapter.MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GioHang gioHang = gioHangList.get(position);
        holder.tensp.setText(gioHang.getTensp().trim());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        String price = decimalFormat.format(gioHang.getGiasp()) + "₫";
        holder.giasp.setText(price);
        String soluong = gioHang.getSoluong() + "";
        holder.soluong.setText(soluong);
        Glide.with(context).load(gioHang.getHinhanh()).into(holder.hinhanh);
        holder.setListenner(new ImageClickListenner() {
            @Override
            public void onImageClick(View view, int pos, int giatri) {
                if (giatri == 1){
                    if (gioHangList.get(pos).getSoluong()>0){
                        int soluongmoi = gioHangList.get(pos).getSoluong()-1;
                        gioHangList.get(pos).setSoluong(soluongmoi);
                    }
                }else if (giatri == 2){
                    if (gioHangList.get(pos).getSoluong()>=0){
                        int soluongmoi = gioHangList.get(pos).getSoluong()+1;
                        gioHangList.get(pos).setSoluong(soluongmoi);
                    }
                }
                holder.soluong.setText(gioHangList.get(pos).getSoluong()+" ");
                long gia = gioHangList.get(pos).getSoluong()*gioHangList.get(pos).getGiasp();
                holder.giasp.setText(decimalFormat.format(gia));
            }
        });
    }

    @Override
    public int getItemCount() {
        return gioHangList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView hinhanh, imgtru, imgcong;
        TextView tensp, giasp, soluong;
        ImageClickListenner listenner;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhanh = itemView.findViewById(R.id.item_giohang_hinhanh);
            tensp = itemView.findViewById(R.id.item_giohang_tensp);
            giasp = itemView.findViewById(R.id.item_giohang_giasp);
            soluong = itemView.findViewById(R.id.item_giohang_soluong);
            imgtru = itemView.findViewById((R.id.item_giohang_tru));
            imgcong = itemView.findViewById((R.id.item_giohang_cong));
            //event click
            imgcong.setOnClickListener(this);
            imgtru.setOnClickListener(this);
        }

        public void setListenner(ImageClickListenner listenner) {
            this.listenner = listenner;
        }

        @Override
        public void onClick(View view) {
            if (view == imgtru){
                listenner.onImageClick(view, getAdapterPosition(),1);
                //1 tru
            }else if (view == imgcong){
                listenner.onImageClick(view, getAdapterPosition(),2);
                //2 cong
            }
        }
    }
}
