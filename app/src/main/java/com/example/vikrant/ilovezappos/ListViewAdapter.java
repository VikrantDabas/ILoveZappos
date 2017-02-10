package com.example.vikrant.ilovezappos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Vikrant on 2/9/2017.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Product> mDataSource;

    public ListViewAdapter(Context context, ArrayList<Product> items) {
        Context mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.list_entry, parent, false);
        TextView brandTextView = (TextView) rowView.findViewById(R.id.list_title);
        TextView nameTextView = (TextView) rowView.findViewById(R.id.list_desc);
        ImageView thumbnailImageView = (ImageView) rowView.findViewById(R.id.list_avatar);
        Product product = (Product) getItem(position);
        brandTextView.setText(product.getBrandName());
        nameTextView.setText(product.getProductName());
        Glide.with(thumbnailImageView.getContext()).load(product.getThumbnailImageUrl()).into(thumbnailImageView);
        return rowView;
    }
}
