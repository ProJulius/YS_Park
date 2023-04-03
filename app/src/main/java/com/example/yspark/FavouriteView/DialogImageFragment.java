package com.example.yspark.FavouriteView;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yspark.ContactView.ContactFragment;
import com.example.yspark.R;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class DialogImageFragment extends DialogFragment {
    private int imageID;
    private ImageView imageView;
    private Context mContext;
    private AnimatorSet front_anim;
    private AnimatorSet back_anim;
    private boolean isFront = true;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_image, container, false);
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int textResId = bundle.getInt("textResId");
            ImageView textView = view.findViewById(R.id.favourite_text);
            textView.setImageDrawable(getContext().getDrawable(textResId));

            int imageResId = bundle.getInt("imageResId");
            ImageView imageView = view.findViewById(R.id.favourite_image);
            imageView.setImageDrawable(getContext().getDrawable(imageResId));

        }

        float scale = mContext.getApplicationContext().getResources().getDisplayMetrics().density;

        ImageView front = view.findViewById(R.id.favourite_image);
        ImageView back = view.findViewById(R.id.favourite_text);
        Button flip = view.findViewById(R.id.flip_btn);

        front.setCameraDistance(8000 * scale);
        back.setCameraDistance(8000 * scale);

        // Now we will set the front animation
        front_anim = (AnimatorSet) AnimatorInflater.loadAnimator(mContext.getApplicationContext(), R.animator.front_animator);
        back_anim = (AnimatorSet) AnimatorInflater.loadAnimator(mContext.getApplicationContext(), R.animator.back_animator);

        // Now we will set the event listener
        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFront) {
                    front_anim.setTarget(front);
                    back_anim.setTarget(back);
                    front_anim.start();
                    back_anim.start();
                    isFront = false;
                } else {
                    front_anim.setTarget(back);
                    back_anim.setTarget(front);
                    back_anim.start();
                    front_anim.start();
                    isFront = true;
                }
            }
        });

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}