package org.akshanshgusain.killmonger2test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.SingleLineTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterVertical extends RecyclerView.Adapter<AdapterVertical.ViewHolderV>{
   private ArrayList<SingleVertical> mDataObjects=new ArrayList<>();

    public AdapterVertical(ArrayList<SingleVertical> mDataObjects) {
        this.mDataObjects = mDataObjects;
    }

    @NonNull
    @Override
    public ViewHolderV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_vertical_row,parent,false);
        ViewHolderV vhv=new ViewHolderV(view);
        return vhv;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderV holder, int position) {
        holder.imageView.setImageResource(mDataObjects.get(position).getmImageView());
        holder.textView.setText(mDataObjects.get(position).getmTextView());

    }

    @Override
    public int getItemCount() {
        return mDataObjects.size();
    }

    //View HOlder Class
    public class ViewHolderV extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public ViewHolderV(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.vertical_imageView);
            textView=itemView.findViewById(R.id.vertical_textView);
        }
    }
}
