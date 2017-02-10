package com.example.vikrant.ilovezappos;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Vikrant on 2/8/2017.
 */

public class DataBinder {
    private DataBinder() {
        //NO-OP
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    @BindingAdapter("strikeText")
    public static void setStrike(TextView text, String te) {
        text.setPaintFlags(text.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        text.setText(te);
    }
}
