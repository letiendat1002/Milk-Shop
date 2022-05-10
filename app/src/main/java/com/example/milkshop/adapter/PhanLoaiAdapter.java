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
import com.example.milkshop.R;
import com.example.milkshop.model.SanPham;

import java.text.DecimalFormat;
import java.util.List;

public class PhanLoaiAdapter extends RecyclerView.Adapter<PhanLoaiAdapter.MyViewHolder> {
    Context context;
    List<SanPham> array;

    public PhanLoaiAdapter(Context context, List<SanPham> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_phanloai,
                parent,
                false
        );
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SanPham sanPham = array.get(position);
        holder.tensp.setText(sanPham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        String price = decimalFormat.format(Double.parseDouble(sanPham.getGiasp())) + "đ";
        holder.giasp.setText(price);
        holder.mota.setText(sanPham.getMota());
        Glide.with(context).load(sanPham.getHinhanh()).into(holder.hinhanh);

    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tensp, giasp, mota;
        ImageView hinhanh;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tensp = itemView.findViewById(R.id.itemphanloai_ten);
            giasp = itemView.findViewById(R.id.itemphanloai_gia);
            mota = itemView.findViewById(R.id.itemphanloai_mota);
            hinhanh = itemView.findViewById(R.id.itemphanloai_image);
        }
    }
}
