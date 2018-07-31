package org.akshanshgusain.killmonger2test;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleHorizontal {
          private int mImgaeView;
          private String mTextView;

    public SingleHorizontal(int mImgaeView, String mTextView) {
        this.mImgaeView = mImgaeView;
        this.mTextView = mTextView;
    }

    public int getmImgaeView() {
        return mImgaeView;
    }

    public void setmImgaeView(int mImgaeView) {
        this.mImgaeView = mImgaeView;
    }

    public String getmTextView() {
        return mTextView;
    }

    public void setmTextView(String mTextView) {
        this.mTextView = mTextView;
    }
}
