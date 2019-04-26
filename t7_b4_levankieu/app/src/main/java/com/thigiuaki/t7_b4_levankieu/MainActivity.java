package com.thigiuaki.t7_b4_levankieu;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public abstract class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;
    public static SQL db;
    EditText edtten, edtgia;
    Button btnthem,btndanhsach;
    ImageView imganh;

    db = new SQL(this,"BanHang.sqlite",null,1);
    db.TruyVan("Create Table If not Exists SanPham(ID Integer Primary Key Autoincrement, TenSP Varchar, Gia Integer, HinhMh Blob)");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        imganh.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.Insertsanpham(edtten.getText().toString(), Integer.parseInt(edtgia.getText().toString()),ConverttoArrayByte(imganh));
                Toast.makeText(MainActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                edtgia.setText("");
                edtten.setText("");
                edtten.requestFocus();
            }
        });

        btndanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DanhsachSP.class);
                startActivity(intent);
            }
        });
    }
public void anhxa(){
    edtten= (EditText) findViewById(R.id.edtTen);
    edtgia= (EditText) findViewById(R.id.edtGiatien);
    btnthem= (Button) findViewById(R.id.btnThemSP);
    btndanhsach= (Button) findViewById(R.id.btnXemDS);
    imganh= (ImageView) findViewById(R.id.imageView);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE&&resultCode==RESULT_OK)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imganh.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public byte[] ConverttoArrayByte(ImageView img)
    {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap=bitmapDrawable.getBitmap();

        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }







}
