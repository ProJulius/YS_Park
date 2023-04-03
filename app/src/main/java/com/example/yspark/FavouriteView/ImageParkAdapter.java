package com.example.yspark.FavouriteView;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yspark.ContactView.ContactFragment;
import com.example.yspark.R;
import com.example.yspark.View.MainActivity;

import java.util.List;

public class ImageParkAdapter extends RecyclerView.Adapter<ImageParkAdapter.ViewHolder> {
    private final Context context;
    private List<ImagePark> mListImagePark;
    private ISendImageListener callBack;
    public interface ISendImageListener{
        void sendImageId(int idText, int idImage);
    }
    public ImageParkAdapter(List<ImagePark> mListImagePark, Context context, ISendImageListener listener) {
        this.mListImagePark = mListImagePark;
        this.context = context;
        this.callBack=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImagePark imagePark = mListImagePark.get(position);
        if(imagePark == null){
            return;
        }
        holder.txtPark.setImageResource(imagePark.getTextId());
        holder.imgPark.setImageResource(imagePark.getResourceId());
        holder.txtImage.setText(imagePark.getName());
        holder.txtId.setText(imagePark.getId());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.sendImageId(mListImagePark.get(holder.getBindingAdapterPosition()).getTextId(),mListImagePark.get(holder.getBindingAdapterPosition()).getResourceId());
            }
        });
    }



    @Override
    public int getItemCount() {
        if(mListImagePark != null) {
            return mListImagePark.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView layoutItem;
        private ImageView imgPark, txtPark;
        private TextView txtId, txtImage;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imgPark = itemView.findViewById(R.id.image_park);
            txtPark = itemView.findViewById(R.id.text_park);
            txtId = itemView.findViewById(R.id.id_image);
            txtImage = itemView.findViewById(R.id.txt_image);

        }
    }
}
