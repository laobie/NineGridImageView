package com.jaeger.ninegridimageview;

import android.content.Context;
import android.widget.ImageView;
import java.util.List;

/**
 * Created by Jaeger on 2016/12/29.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */

public interface ItemImageClickListener<T> {
    void onItemImageClick(Context context, ImageView imageView, int index, List<T> list);
}
