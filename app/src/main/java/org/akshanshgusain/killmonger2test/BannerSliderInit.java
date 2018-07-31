package org.akshanshgusain.killmonger2test;

import android.os.Handler;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.akshanshgusain.killmonger2test.MainActivity;

public class BannerSliderInit {
    private  int currentPage=0;
     ArrayList<String> imageUrls=new ArrayList<>();
    private  ViewPager mPager;

    public BannerSliderInit(ViewPager mPager) {
        this.mPager=mPager;
    }
    public BannerSliderInit(){

        }

    public void init() {
        final Handler handler = new Handler();
        final Runnable mRun = new Runnable() {
            public void run() {
                if (currentPage ==MainActivity.getBannerData().size() ) {
                    currentPage = 0;
             }
                mPager.setCurrentItem(currentPage++, true);

            }
        };
        Timer mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(mRun);
            }
        },0000,1000);
    }

//     ArrayList<String> initList() {
//    imageUrls.add("https://cnet1.cbsistatic.com/img/QGxaseKchcCH_sPqcCGVSbOMhHI=/936x527/2018/02/21/d84d9703-3428-46b5-885e-8297ef901f51/09-samsung-galaxy-s9-and-s9-plus.jpg");
//    imageUrls.add( "https://cnet4.cbsistatic.com/img/KnuL1WDed3sanatLbE4YDddJGVg=/2017/10/31/312b3b6e-59b7-499a-aea4-9bc5f9721a21/iphone-x-54.jpg");
//    imageUrls.add("https://www.samsung.com/global/galaxy/gear-s3/images/buy-now_banner_gear-s3.png");
//    imageUrls.add("https://pixel.nymag.com/imgs/daily/selectall/2017/09/20/20-apple-watch.w710.h473.jpg");
//    return imageUrls;
//}
}
