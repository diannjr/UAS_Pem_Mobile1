package com.example.dianasari;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    private Button scanner;
    Button btndata;
    Button btnmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        scanner = findViewById(R.id.scann);
        scanner.setOnClickListener(v-> {
            scanCode();
        });

        btndata = (Button) findViewById(R.id.btn_data);
        btndata.setOnClickListener(this);
        btnmaps = (Button) findViewById(R.id.btn_maps);
        btnmaps.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_data:
                Intent btn_data = new Intent(MenuActivity.this, DataActivity.class);
                startActivity(btn_data);
                break;
            case R.id.btn_maps:
                Intent btn_maps = new Intent(MenuActivity.this, MapsActivity.class);
                startActivity(btn_maps);
                break;
            default:
                break;
        }
    }

    private void scanCode() {
        ScanOptions scanOptions = new ScanOptions();
        scanOptions.setPrompt("Volume up to flash on");
        scanOptions.setBeepEnabled(true);
        scanOptions.setOrientationLocked(true);
        scanOptions.setCaptureActivity(CaptureQR.class);
        barlaucher.launch(scanOptions);
    }

    ActivityResultLauncher<ScanOptions> barlaucher = registerForActivityResult(new ScanContract(),result -> {
        if (result.getContents() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
            builder.setTitle("Result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {dialog.dismiss();}
            }).show();
        }
    });


}
