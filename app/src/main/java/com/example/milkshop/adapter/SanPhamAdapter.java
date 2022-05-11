package com.example.milkshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.milkshop.Interface.ItemClickListener;
import com.example.milkshop.R;
import com.example.milkshop.activity.ChiTietActivity;
import com.example.milkshop.model.SanPham;

import java.text.DecimalFormat;
import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.MyViewHolder> {
    Context context;
    List<SanPham> array;

    public SanPhamAdapter(Context context, List<SanPham> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_sanpham,
                parent,
                false
        );
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SanPham sanPham = array.get(position);
        holder.txtTen.setText(sanPham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        String price = decimalFormat.format(Double.parseDouble(sanPham.getGiasp())) + "đ";
        holder.txtGia.setText(price);
        Glide.with(context).load(sanPham.getHinhanh()).into(holder.imgHinhAnh);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (!isLongClick) {
                    Intent intent = new Intent(context, ChiTietActivity.class);
                    intent.putExtra("chitiet", sanPham);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtGia, txtTen;
        ImageView imgHinhAnh;
        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtGia = itemView.findViewById(R.id.itemsp_gia);
            txtTen = itemView.findViewById(R.id.itemsp_ten);
            imgHinhAnh = itemView.findViewById(R.id.itemsp_image);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), false);
        }
    }
}
