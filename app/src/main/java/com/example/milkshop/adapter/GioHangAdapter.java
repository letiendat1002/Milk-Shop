package com.example.milkshop.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.milkshop.Interface.ImageClickListener;
import com.example.milkshop.R;
import com.example.milkshop.model.EventBus.EmptyCartEvent;
import com.example.milkshop.model.EventBus.TinhTongEvent;
import com.example.milkshop.model.GioHang;
import com.example.milkshop.utils.Utils;

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;
import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.MyViewHolder> {
    private static final int SUBTRACT = 1;
    private static final int ADD = 2;
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
        String formattedPrice = decimalFormat.format(gioHang.getGiasp()) + "₫";
        holder.giasp.setText(formattedPrice);
        String soluong = gioHang.getSoluong() + "";
        holder.soluong.setText(soluong);
        Glide.with(context).load(gioHang.getHinhanh()).into(holder.hinhanh);
        holder.setListener(new ImageClickListener() {
            @Override
            public void onImageClick(View view, int pos, int value) {
                if (value == SUBTRACT) {
                    if (gioHangList.get(pos).getSoluong() > 1) {
                        int soluongmoi = gioHangList.get(pos).getSoluong() - 1;
                        gioHangList.get(pos).setSoluong(soluongmoi);
                        String amount = gioHangList.get(pos).getSoluong() + "";
                        holder.soluong.setText(amount);

                        long gia = gioHangList.get(pos).getSoluong() * gioHangList.get(pos).getGiasp();
                        String formattedPrice = decimalFormat.format(gia) + "₫";
                        holder.giasp.setText(formattedPrice);
                        EventBus.getDefault().postSticky(new TinhTongEvent());
                    }
                    else if (gioHangList.get(pos).getSoluong() == 1) {
                        createDeleteConfirmDialog(view, pos);
                    }
                } else if (value == ADD) {
                    if (gioHangList.get(pos).getSoluong() >= 0) {
                        int soluongmoi = gioHangList.get(pos).getSoluong() + 1;
                        gioHangList.get(pos).setSoluong(soluongmoi);
                    }
                    String amount = gioHangList.get(pos).getSoluong() + "";
                    holder.soluong.setText(amount);

                    long gia = gioHangList.get(pos).getSoluong() * gioHangList.get(pos).getGiasp();
                    String formattedPrice = decimalFormat.format(gia) + "₫";
                    holder.giasp.setText(formattedPrice);
                    EventBus.getDefault().postSticky(new TinhTongEvent());
                }
            }

            private void createDeleteConfirmDialog(View view, int pos) {
                Dialog deleteConfirmDialog = new Dialog(view.getContext());
                deleteConfirmDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                deleteConfirmDialog.setContentView(R.layout.dialog_delete_product);
                TextView tvYes = deleteConfirmDialog.findViewById(R.id.tvYes);
                TextView tvNo = deleteConfirmDialog.findViewById(R.id.tvNo);

                tvYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Utils.gioHangList.remove(pos);
                        notifyDataSetChanged();
                        EventBus.getDefault().postSticky(new TinhTongEvent());
                        EventBus.getDefault().postSticky(new EmptyCartEvent());
                        deleteConfirmDialog.dismiss();
                    }
                });

                tvNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteConfirmDialog.dismiss();
                    }
                });

                deleteConfirmDialog.setCancelable(true);
                deleteConfirmDialog.show();
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
        ImageClickListener listener;

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

        public void setListener(ImageClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            if (view == imgtru) {
                listener.onImageClick(view, getAdapterPosition(), SUBTRACT);
            } else if (view == imgcong) {
                listener.onImageClick(view, getAdapterPosition(), ADD);
            }
        }
    }
}
