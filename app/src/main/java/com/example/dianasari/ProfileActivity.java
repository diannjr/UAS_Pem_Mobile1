package com.example.dianasari;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dianasari.adapter.Adapter;
import com.example.dianasari.helper.Helper;
import com.example.dianasari.model.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.Button;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

}