package com.example.yspark.MapView;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.yspark.FavouriteView.ImagePark;
import com.example.yspark.R;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {

    PhotoView ptv;
    private List<Image> mListImage = new ArrayList<>();
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);


        ptv = view.findViewById(R.id.photo_view);
        Bundle bundle = new Bundle();

        ptv.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
                x *= 100;
                y *= 100;
                Boolean check = false;
                if((x >= 63.6 && x <= 72.2) && (y >= 0 && y <= 4.5)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_01);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Bãi đỗ xe");
                    check = true;
                }else if((x >= 50.5 && x <= 56) && (y >= 0 && y <= 4)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_02);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Khu đất lối vào");
                    check = true;
                }else if((x >= 6.5 && x <= 16) && (y >= 2.5 && y <= 7.5)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_03);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Sân nghỉ");
                    check = true;
                }else if((x >= 20.5 && x <= 26) && (y >= 3 && y <= 7)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_04);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Vườn mê cung");
                    check = true;
                }else if((x >= 1.5 && x <= 6.5) && (y >= 7.6 && y <= 11.8)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_05);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Đình cô đơn");
                    check = true;
                }else if((x >= 5.3 && x <= 10.3) && (y >= 13.5 && y <= 17.5)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_06);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Khu tập thể dục");
                    check = true;
                }else if((x >= 0 && x <= 13) && (y >= 22 && y <= 26.3)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_07);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Khu vực trung tâm");
                    check = true;
                }else if((x >= 3 && x <= 7.5) && (y >= 29 && y <= 33)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_08);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Nhà hoang");
                    check = true;
                }else if((x >= 4.5 && x <= 9.5) && (y >= 35 && y <= 39.4)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_09);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Bãi đất trống 1");
                    check = true;
                }else if((x >= 19.5 && x <= 24.5) && (y >= 38.4 && y <= 42.2)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_10);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Ngã ba 1");
                    check = true;
                }else if((x >= 33.5 && x <= 42) && (y >= 38.5 && y <= 44.5)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_11);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Đình nghỉ");
                    check = true;
                }else if((x >= 2.5 && x <= 7.5) && (y >= 46.3 && y <= 50.5)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_12);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Bãi đất trống 2");
                    check = true;
                }else if((x >= 0 && x <= 9.5) && (y >= 58 && y <= 63)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_13);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Sân khấu âm nhạc");
                    check = true;
                }else if((x >= 2 && x <= 7) && (y >= 66.5 && y <= 70.7)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_14);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Bãi đất trống 3");
                    check = true;
                }else if((x >= 14.2 && x <= 19.7) && (y >= 77 && y <= 81.3)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_15);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Chòi ngắm cảnh");
                    check = true;
                }else if((x >= 10.8 && x <= 23) && (y >= 90.5 && y <= 97.5)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_16);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Cầu đỏ");
                    check = true;
                }else if((x >= 36.5 && x <= 50) && (y >= 92.5 && y <= 97.5)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_17);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Đình lớn");
                    check = true;
                }else if((x >= 73.5 && x <= 78.5) && (y >= 68.6 && y <= 72.8)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_18);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Khu vô dụng");
                    check = true;
                }else if((x >= 77.5 && x <= 81.5) && (y >= 57 && y <= 64.5)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_19);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Cầu trắng");
                    check = true;
                }else if((x >= 69 && x <= 75) && (y >= 47 && y <= 52)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_20);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Công viên chó");
                    check = true;
                }else if((x >= 57 && x <= 72) && (y >= 38.1 && y <= 42.4)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_21);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Ngã ba 2");
                    check = true;
                }else if((x >= 64 && x <= 72.2) && (y >= 24 && y <= 28.7)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_22);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Bãi đỗ xe ô tô");
                    check = true;
                }else if((x >= 87 && x <= 92) && (y >= 7 && y <= 11.1)){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ys_park_image_23);
                    bundle.putParcelable("imageLocation", bitmap);
                    bundle.putString("nameLocation", "Khu bảo vệ");
                    check = true;
                }

                if(check){
                    Fragment informationMapFragment = new InformationMapFragment();
                    informationMapFragment.setArguments(bundle);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.animation_fade_in, R.anim.animation_fade_out);
                    fragmentTransaction.replace(R.id.map_fragment, informationMapFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}