package com.example.yspark.ContactView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yspark.R;

public class ContactFragment extends DialogFragment {
    private ImageView btnFacebook, btnGitHub, btnQrCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        btnFacebook = (ImageView) view.findViewById(R.id.logoFacebook);
        btnQrCode = (ImageView) view.findViewById(R.id.logoQrCode);
        btnGitHub = (ImageView) view.findViewById(R.id.logoGithub);

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/proletrung"));
                startActivity(intentFacebook);
            }
        });

        btnGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ProJulius"));
                startActivity(intentFacebook);
            }
        });

        btnQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactFragment dialogFragment = new ContactFragment();
                dialogFragment.show(getFragmentManager(), "");
            }
        });

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View customLayout = inflater.inflate(R.layout.dialog_qr_code, null);
        builder.setView(customLayout);

        builder.setCancelable(true);
        return builder.create();
    }
}