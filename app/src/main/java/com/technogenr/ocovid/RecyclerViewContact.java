package com.technogenr.ocovid;

/**
 * Created by HP on 02-06-2018.
 */

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by AndroidJSon.com on 6/18/2017.
 */

public class RecyclerViewContact extends RecyclerView.Adapter<RecyclerViewContact.ViewHolder> {

    Context context;
    List<ImageUploadInfo> MainImageUploadInfoList;

    public RecyclerViewContact(Context context, List<ImageUploadInfo> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_images, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageUploadInfo UploadInfo = MainImageUploadInfoList.get(position);


        holder.area.setText(UploadInfo.getArea());
        holder.number.setText(UploadInfo.getNumber());

        //Loading image from Glide library.


    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener  {

        public ImageView imageView;
        public TextView imageNameTextView;
        public TextView exp;
        public TextView area;
        public TextView number;

        final Context contextt = itemView.getContext();
        public ViewHolder(View itemView) {
            super(itemView);


            area = (TextView) itemView.findViewById(R.id.areaa);
            number = (TextView) itemView.findViewById(R.id.numberr);

            //call.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

//
//            String dprice = MainImageUploadInfoList.get(getAdapterPosition()).getMob();
//
//          Intent i=new Intent(Intent.ACTION_DIAL);
//            i.setData(Uri.parse("tel:"+dprice));
//
//            contextt.startActivity(i);



        }}
}