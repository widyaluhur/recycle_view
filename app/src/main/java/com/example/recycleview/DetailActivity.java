package com.example.recycleview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView tvPreview, tvNamaPreview;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_team);

        ivLogo = findViewById(R.id.iv_logo);
        tvNamaPreview = findViewById(R.id.preview_nama_team);
        tvPreview = findViewById(R.id.tv_preview);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if (getIntent().hasExtra("logo") && getIntent().hasExtra("nama") && getIntent().hasExtra("preview")){
            int logoTeam = getIntent().getIntExtra("logo", 0);
            String namaTeam = getIntent().getStringExtra("nama");
            String previewTeam = getIntent().getStringExtra("preview");

            setDataActivity(logoTeam, namaTeam, previewTeam);
        }
    }

    private void setDataActivity(int logoTeam, String namaTeam, String previewTeam){
        Glide.with(this).asBitmap().load(logoTeam).into(ivLogo);
        tvNamaPreview.setText(namaTeam);
        tvPreview.setText(previewTeam);
    }
}
