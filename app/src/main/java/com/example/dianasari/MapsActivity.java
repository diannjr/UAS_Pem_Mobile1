package com.example.dianasari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MapsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        EditText editTextSource = findViewById(R.id.lokasi);
        EditText editTextDestination = findViewById(R.id.tujuan);
        Button button = findViewById(R.id.btn_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lokasi = editTextSource.getText().toString();
                String tujuan = editTextDestination.getText().toString();
                if (lokasi.equals("") && tujuan.equals("")) {
                    Toast.makeText(MapsActivity.this,"Input Lokasi dan Tujuan anda", Toast.LENGTH_SHORT).show();
                } else {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + lokasi + "/" + tujuan);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            }
        });

    }
}