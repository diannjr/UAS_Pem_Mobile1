package com.example.dianasari;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dianasari.helper.Helper;

public class EditActivity extends AppCompatActivity {
    private EditText editname, editjabatan, editalamat;
    private Button btnsave;
    private Helper db = new Helper(this);
    private String id, name, jabatan, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editname = findViewById(R.id.edit_name);
        editjabatan = findViewById(R.id.edit_jabatan);
        editalamat = findViewById(R.id.edit_alamat);
        btnsave = findViewById(R.id.btn_save);

        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        jabatan = getIntent().getStringExtra("jabatan");
        alamat = getIntent().getStringExtra("alamat");

        if  (id == null || id.equals("")) {
            setTitle("Edit Nama");
        } else {
            setTitle("Edit Nama");
            editname.setText(name);
            editjabatan.setText(jabatan);
            editalamat.setText(alamat);
        }
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if ( id == null || id.equals("")) {
                        save();
                    } else {
                        edit();
                    }
                } catch (Exception e) {
                    Log.e("Saving", e.getMessage());
                }
            }
        });
    }

    private void save() {
        if (String.valueOf(editname.getText()).equals("") || String.valueOf(editjabatan.getText()).equals("") || String.valueOf(editjabatan.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
        } else {
            db.insert(editname.getText().toString(), editjabatan.getText().toString(),editalamat.getText().toString());
            Toast.makeText(getApplicationContext(), "Data Sudah Tersimpan", Toast.LENGTH_SHORT).show();
        }
    }

    private void edit() {
        if (String.valueOf(editname.getText()).equals("") || String.valueOf(editjabatan.getText()).equals("") || String.valueOf(editjabatan.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
        } else {
            db.update(Integer.parseInt(id), editname.getText().toString(), editjabatan.getText().toString(), editalamat.getText().toString());
            Toast.makeText(getApplicationContext(), "Data Sudah Diedit", Toast.LENGTH_SHORT).show();
        }
    }
}
