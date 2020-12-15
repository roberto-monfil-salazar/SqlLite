package com.example.sqllite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;

public class RecordDetailActivity extends AppCompatActivity {

    private CircularImageView civImage3;
    private TextView tvPelicula, tvDescription, tvDirector, tvPrecio;
    private ActionBar actionBar;
    private String recordID;
    private HelperDB helperDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Detalles de la Pelicula");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        recordID = intent.getStringExtra("RECORD_ID");

        helperDB = new HelperDB(this);

        civImage3 = findViewById(R.id.civImage3);
        tvPelicula = findViewById(R.id.tvPelicula);
        tvDescription = findViewById(R.id.tvDescription);
        tvDirector = findViewById(R.id.tvDirector);
        tvPrecio = findViewById(R.id.tvPrecio);

        showRecordDetails();

    }

    private void showRecordDetails() {
        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.C_ID + " =\"" + recordID + "\"";

        SQLiteDatabase db = helperDB.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String id = "" + cursor.getInt(cursor.getColumnIndex(Constants.C_ID));
                String product_name = "" + cursor.getString(cursor.getColumnIndex(Constants.C_Pelicula));
                String image = "" + cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE));
                String brand = "" + cursor.getString(cursor.getColumnIndex(Constants.C_Director));
                String model = "" + cursor.getString(cursor.getColumnIndex(Constants.C_Actor));
                String serialNumber = "" + cursor.getString(cursor.getColumnIndex(Constants.C_Duracion));
                String price = "" + cursor.getString(cursor.getColumnIndex(Constants.C_Precio));
                String description = "" + cursor.getString(cursor.getColumnIndex(Constants.C_DESCRIPTION));

                if (image.equals("null")) {
                    civImage3.setImageResource(R.drawable.ic_launcher_foreground);
                } else {
                    civImage3.setImageURI(Uri.parse(image));
                }

                tvPelicula.setText(product_name);
                tvDescription.setText(description);
                tvDirector.setText(brand);
                tvPrecio.setText(price);

            } while (cursor.moveToNext());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}