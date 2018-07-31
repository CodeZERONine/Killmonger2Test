package org.akshanshgusain.killmonger2test;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class  BannerViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<SingleBanner> imageURLS;

    BannerViewPagerAdapter(Context context, ArrayList<SingleBanner> imageURLS) {
        this.mContext = context;
        this.imageURLS = imageURLS;
    }

    @Override
    public int getCount() {
        return imageURLS.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        ImageView imageView = new ImageView(mContext);
        RequestOptions requestOptions=new RequestOptions().placeholder(R.drawable.placeholder).error(R.drawable.errordrawable);

        Glide.with(mContext).load(imageURLS.get(position).getmImage()).apply(requestOptions).into(imageView);
        container.addView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     Toast.makeText(mContext, "position:"+position , Toast.LENGTH_SHORT).show();
                }
        });
        return imageView;
    }//End of instantitateItem


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
