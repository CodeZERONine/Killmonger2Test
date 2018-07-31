package org.akshanshgusain.killmonger2test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterHorizontal extends RecyclerView.Adapter<AdapterHorizontal.ViewHolderH>{
     private ArrayList<SingleHorizontal> mDataObjects=new ArrayList<>();

    public AdapterHorizontal(ArrayList<SingleHorizontal> mDataObjects) {
        this.mDataObjects = mDataObjects;
    }

    @NonNull
    @Override
    public ViewHolderH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_horizontal_row,parent,false);
        ViewHolderH vhh=new ViewHolderH(view);
        return vhh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderH holder, int position) {
                    holder.imageView.setImageResource(mDataObjects.get(position).getmImgaeView());
                    holder.textview.setText(mDataObjects.get(position).getmTextView());
    }

    @Override
    public int getItemCount() {
        return mDataObjects.size();
    }

    //View Holder Class
    public class ViewHolderH extends RecyclerView.ViewHolder{
                    ImageView imageView;
                    TextView textview;
        public ViewHolderH(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.bannar);
            textview=(TextView)itemView.findViewById(R.id.description);

        }
    }
}
