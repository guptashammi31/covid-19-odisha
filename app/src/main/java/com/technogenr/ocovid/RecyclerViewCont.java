package com.technogenr.ocovid;

/**
 * Created by HP on 02-06-2018.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by AndroidJSon.com on 6/18/2017.
 */

public class RecyclerViewCont extends RecyclerView.Adapter<RecyclerViewCont.ViewHolder> {

    Context context;
    List<hospitalDetails> MainImageUploadInfoList;

    public RecyclerViewCont(Context context, List<hospitalDetails> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_hospital_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        hospitalDetails UploadInfo = MainImageUploadInfoList.get(position);

        holder.imageNameTextView.setText(UploadInfo.getImageName());
        holder.exp.setText(UploadInfo.getexp());
        holder.avail.setText(UploadInfo.getAvail());
        holder.price.setText(UploadInfo.getPrice());

        //Loading image from Glide library.
      Glide.with(context).load(UploadInfo.getImageURL()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener  {

        public ImageView imageView;
        public TextView imageNameTextView;
        public TextView exp;
        public TextView avail;
        public TextView price;
        public TextView number;
        public Button call;
        final Context contextt = itemView.getContext();
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);

             call=(Button) itemView.findViewById(R.id.call);


            imageNameTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView);
            exp = (TextView) itemView.findViewById(R.id.exp);
            avail = (TextView) itemView.findViewById(R.id.avail);
            price = (TextView) itemView.findViewById(R.id.price);
           // appointment=(Button) itemView.findViewById(R.id.appoint);

            call.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {


            String dprice = MainImageUploadInfoList.get(getAdapterPosition()).getMob();

          Intent i=new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+dprice));

            contextt.startActivity(i);



        }}
}