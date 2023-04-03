package com.example.yspark.MapView;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yspark.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InformationMapFragment extends Fragment {

    Button btnBackMap;
    Button btnSave;
    TextView txtLocation;
    EditText edtLocation;
    ImageView imgLocation;
    private String filename = "filemap.txt";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information_map, container, false);

        btnBackMap = view.findViewById(R.id.back_map);
        btnSave = view.findViewById(R.id.save_location);
        txtLocation = view.findViewById(R.id.txt_location);
        edtLocation = view.findViewById(R.id.edt_location);
        imgLocation = view.findViewById(R.id.img_location);

        Bundle bundle = getArguments();
        txtLocation.setText(bundle.getString("nameLocation"));
        imgLocation.setImageBitmap(bundle.getParcelable("imageLocation"));

        btnBackMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment informationMapFragment = new MapFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_fade_in, R.anim.animation_fade_out);
                fragmentTransaction.replace(R.id.information_map_fragment, informationMapFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataFromFile();
                saveDataToFile();

                Fragment informationMapFragment = new MapFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_fade_in, R.anim.animation_fade_out);
                fragmentTransaction.replace(R.id.information_map_fragment, informationMapFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        
        return view;
    }

    private void saveDataToFile() {
        String data = btnSave.getText().toString();
        try {
            FileOutputStream fos = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            Toast.makeText(getActivity(), "Dữ liệu đã được lưu!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDataFromFile() {
        File file = new File(filename);
        StringBuilder text = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            // Handle exception here
        }
        btnSave.setText(text.toString());
    }
}