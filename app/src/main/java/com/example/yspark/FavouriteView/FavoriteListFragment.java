package com.example.yspark.FavouriteView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yspark.R;
import com.example.yspark.View.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class FavoriteListFragment extends Fragment {
    private RecyclerView rcvImage;
    private View view;
    private MainActivity mainActivity;
    public FavoriteListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorite_list, container, false);

        mainActivity = (MainActivity) getActivity();

        rcvImage = view.findViewById(R.id.rcv_image);
        rcvImage.setHasFixedSize(true);
        rcvImage.setItemViewCacheSize(23);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        rcvImage.setLayoutManager(linearLayoutManager);

        ImageParkAdapter imageParkAdapter = new ImageParkAdapter(getListImagePark(), getContext(),
                new ImageParkAdapter.ISendImageListener() {
                    @Override
                    public void sendImageId(int txtId, int imgId) {
//                        DialogImageFragment.newInstance(id).show(getChildFragmentManager(),null);

                        Bundle bundle = new Bundle();
                        bundle.putInt("textResId", txtId);
                        bundle.putInt("imageResId", imgId);

                        DialogImageFragment dialogImageFragment = new DialogImageFragment();
                        dialogImageFragment.setArguments(bundle);
                        dialogImageFragment.show(getChildFragmentManager(),null);

                    }
                });
        rcvImage.setAdapter(imageParkAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mainActivity,DividerItemDecoration.VERTICAL);
        rcvImage.addItemDecoration(itemDecoration);
        return view;
    }

    private List<ImagePark> getListImagePark() {
        List <ImagePark> list = new ArrayList<>();
        list.add(new ImagePark(R.drawable.ys_park_text_01,R.drawable.ys_park_image_01,"Bãi đỗ xe", "1"));
        list.add(new ImagePark(R.drawable.ys_park_text_02,R.drawable.ys_park_image_02,"Khu đất lối vào", "2"));
        list.add(new ImagePark(R.drawable.ys_park_text_03,R.drawable.ys_park_image_03,"Sân nghỉ", "3"));
        list.add(new ImagePark(R.drawable.ys_park_text_04,R.drawable.ys_park_image_04,"Vườn mê cung", "4"));
        list.add(new ImagePark(R.drawable.ys_park_text_05,R.drawable.ys_park_image_05,"Đình cô đơn", "5"));
        list.add(new ImagePark(R.drawable.ys_park_text_06,R.drawable.ys_park_image_06,"Khu tập thể dục", "6"));
        list.add(new ImagePark(R.drawable.ys_park_text_07,R.drawable.ys_park_image_07,"Khu vực trung tâm", "7"));
        list.add(new ImagePark(R.drawable.ys_park_text_08,R.drawable.ys_park_image_08,"Nhà hoang", "8"));
        list.add(new ImagePark(R.drawable.ys_park_text_09,R.drawable.ys_park_image_09,"Bãi đất trống 1", "9"));
        list.add(new ImagePark(R.drawable.ys_park_text_10,R.drawable.ys_park_image_10,"Ngã ba 1", "10"));
        list.add(new ImagePark(R.drawable.ys_park_text_11,R.drawable.ys_park_image_11,"Đình nghỉ", "11"));
        list.add(new ImagePark(R.drawable.ys_park_text_12,R.drawable.ys_park_image_12,"Bãi đất trống 2", "12"));
        list.add(new ImagePark(R.drawable.ys_park_text_13,R.drawable.ys_park_image_13,"Sân khấu âm nhạc", "13"));
        list.add(new ImagePark(R.drawable.ys_park_text_14,R.drawable.ys_park_image_14,"Bãi đất trống 3", "14"));
        list.add(new ImagePark(R.drawable.ys_park_text_15,R.drawable.ys_park_image_15,"Chòi ngắm cảnh", "15"));
        list.add(new ImagePark(R.drawable.ys_park_text_16,R.drawable.ys_park_image_16,"Cầu đỏ", "16"));
        list.add(new ImagePark(R.drawable.ys_park_text_17,R.drawable.ys_park_image_17,"Đình lớn", "17"));
        list.add(new ImagePark(R.drawable.ys_park_text_18,R.drawable.ys_park_image_18,"Khu vô dụng", "18"));
        list.add(new ImagePark(R.drawable.ys_park_text_19,R.drawable.ys_park_image_19,"Cầu trắng", "19"));
        list.add(new ImagePark(R.drawable.ys_park_text_20,R.drawable.ys_park_image_20,"Công viên chó", "20"));
        list.add(new ImagePark(R.drawable.ys_park_text_21,R.drawable.ys_park_image_21,"Ngã ba 2", "21"));
        list.add(new ImagePark(R.drawable.ys_park_text_22,R.drawable.ys_park_image_22,"Bãi đỗ xe ô tô", "22"));
        list.add(new ImagePark(R.drawable.ys_park_text_23,R.drawable.ys_park_image_23,"Khu bảo vệ", "23"));
        return list;
    }
}