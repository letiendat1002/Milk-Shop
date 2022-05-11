package com.example.milkshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

public class PhanLoaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_DATA = 0;
    public static final int VIEW_TYPE_LOADING = 1;
    Context context;
    List<SanPham> array;

    public PhanLoaiAdapter(Context context, List<SanPham> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_DATA) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_phanloai,
                    parent,
                    false
            );
            return new MyViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_loading,
                    parent,
                    false
            );
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            SanPham sanPham = array.get(position);
            myViewHolder.tensp.setText(sanPham.getTensp().trim());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            String price = decimalFormat.format(Double.parseDouble(sanPham.getGiasp())) + "đ";
            myViewHolder.giasp.setText(price);
            myViewHolder.mota.setText(sanPham.getMota().trim());
            Glide.with(context).load(sanPham.getHinhanh()).into(myViewHolder.hinhanh);
            myViewHolder.setItemClickListener(new ItemClickListener() {
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
        } else {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return array.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_DATA;
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public static class LoadingViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressbar);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tensp, giasp, mota;
        ImageView hinhanh;
        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tensp = itemView.findViewById(R.id.itemphanloai_ten);
            giasp = itemView.findViewById(R.id.itemphanloai_gia);
            mota = itemView.findViewById(R.id.itemphanloai_mota);
            hinhanh = itemView.findViewById(R.id.itemphanloai_image);
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
