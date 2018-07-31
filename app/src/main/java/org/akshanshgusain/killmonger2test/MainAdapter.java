package org.akshanshgusain.killmonger2test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.akshanshgusain.killmonger2test.*;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

import static org.akshanshgusain.killmonger2test.MainActivity.getBannerData;
import static org.akshanshgusain.killmonger2test.MainActivity.getVerticalData;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
          private ArrayList<Object> mObjectList=new ArrayList<>();
          private Context mContext;
          //Constants Integers Value
         private static final int HORIZONTAL=1;
         private static final int VERTICAL=2;
         private static final int BANNER=3;

         //Constructor
    public MainAdapter(ArrayList<Object> mObjectList, Context mContext) {
        this.mObjectList = mObjectList;
        this.mContext = mContext;
    }
    //ItemView Type
    @Override
    public int getItemViewType(int position) {
                     if(mObjectList.get(position) instanceof SingleVertical)
                           return VERTICAL;
                     if(mObjectList.get(position) instanceof SingleHorizontal)
                         return HORIZONTAL;
                     if(mObjectList.get(position) instanceof SingleBanner)
                         return BANNER;
                     else
                         return -1;
                     }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mLayoutInflater=LayoutInflater.from(parent.getContext());
         RecyclerView.ViewHolder vh;
                   switch(viewType){
                       case HORIZONTAL:
                           view=mLayoutInflater.inflate(R.layout.horizontal,parent,false);
                           vh=new ViewHolderHorizontal(view);
                           return vh;
                       case VERTICAL:
                           view = mLayoutInflater.inflate(R.layout.vertical,parent,false);
                           vh=new ViewHolderVertical(view);
                           return vh;
                       case BANNER:
                           view= mLayoutInflater.inflate(R.layout.banner_slider,parent,false);
                           vh=new ViewHolderBanner(view);
                           return vh;
                       default :HORIZONTAL:  view = mLayoutInflater.inflate(R.layout.single_vertical_row,parent,false);
                             vh=new ViewHolderVertical(view);
                             return vh;
                   }
    }//end of OnCreate View Holder

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                          if(holder.getItemViewType()==HORIZONTAL)
                                     horizontalView((ViewHolderHorizontal)holder);
                          else if(holder.getItemViewType()==VERTICAL)
                                 verticalView((ViewHolderVertical)holder);
                          else if(holder.getItemViewType()==BANNER)
                                  bannerView((ViewHolderBanner)holder);
    }

    private void bannerView(ViewHolderBanner holder) {
        holder.mPager.setAdapter(new BannerViewPagerAdapter(mContext,getBannerData()));
        holder.mIndicator.setViewPager(holder.mPager);
        BannerSliderInit tempObj=new BannerSliderInit(holder.mPager);
        tempObj.init();
    }

    private void verticalView(ViewHolderVertical holder) {
        AdapterVertical adapter1 = new AdapterVertical(getVerticalData());
        holder.mRecyclerViewV.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false));
        holder.mRecyclerViewV.setAdapter(adapter1);
    }

    private void horizontalView(ViewHolderHorizontal holder) {
       AdapterHorizontal adapter= new AdapterHorizontal(MainActivity.getHorizontalData());
       holder.mRecyclerViewH.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,false));
       holder.mRecyclerViewH.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return mObjectList.size();
    }


    //ViewHolder Classes
    public class ViewHolderVertical extends RecyclerView.ViewHolder{
            RecyclerView mRecyclerViewV;
        public ViewHolderVertical(View itemView) {
            super(itemView);
            mRecyclerViewV=(RecyclerView) itemView.findViewById(R.id.vertical_recyclerView);
        }
    }
    public class ViewHolderHorizontal extends RecyclerView.ViewHolder{
         RecyclerView mRecyclerViewH;
        public ViewHolderHorizontal(View itemView) {
            super(itemView);
            mRecyclerViewH=(RecyclerView) itemView.findViewById(R.id.horizontal_recyclerView);
        }
    }
    public class ViewHolderBanner extends RecyclerView.ViewHolder{
            public   ViewPager mPager;
            public CircleIndicator mIndicator;
        public ViewHolderBanner(View itemView) {
            super(itemView);
            mPager=(ViewPager)itemView.findViewById(R.id.banner_viewpager);
            mIndicator=(CircleIndicator)itemView.findViewById(R.id.banner_indicator);
        }
    }
}
