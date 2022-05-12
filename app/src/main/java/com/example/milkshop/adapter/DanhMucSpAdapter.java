package com.example.milkshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.milkshop.R;
import com.example.milkshop.model.DanhMucSp;

import java.util.List;

public class DanhMucSpAdapter extends BaseAdapter {
    Context context;
    List<DanhMucSp> danhMucSpList;

    public DanhMucSpAdapter(Context context, List<DanhMucSp> array) {
        this.context = context;
        this.danhMucSpList = array;
    }

    @Override
    public int getCount() {
        return danhMucSpList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_danhmucsp, null);
            viewHolder.hinhanh = view.findViewById(R.id.item_danhmucsp_hinhanh);
            viewHolder.tensp = view.findViewById(R.id.item_danhmucsp_tensp);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tensp.setText(danhMucSpList.get(i).getTensp());
        Glide.with(context).load(danhMucSpList.get(i).getHinhanh()).into(viewHolder.hinhanh);
        return view;
    }

    public static class ViewHolder {
        ImageView hinhanh;
        TextView tensp;
    }
}
