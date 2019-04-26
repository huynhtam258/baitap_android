package com.thigiuaki.t7_b5_huynhmanhtam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper {
    String DATABASE_NAME = "StudentDB.sqlite";
    private static final String DB_PATH_SUFIX = "/databases/";
    SQLiteDatabase db = null;
    Context context;

    public DBHelper(Context context) {
        this.context = context;
        processSQLite();
    }

    private void processSQLite() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()) {
            try {
                CopyDataFromAsset();
                Toast.makeText(context, "Copy ok", Toast.LENGTH_SHORT).show();


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void CopyDataFromAsset() {
        try {
            InputStream databaseInputStream = context.getAssets().open(DATABASE_NAME);
            String outputStream = getPathDataBaseSystem();
            File file = new File(context.getApplicationInfo().dataDir + DB_PATH_SUFIX);
            if (!file.exists()) {
                file.mkdir();
            }
            OutputStream databaseOutputStream = new FileOutputStream(outputStream);
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = databaseInputStream.read(buffer)) > 0) {
                databaseOutputStream.write(buffer, 0, lenght);
            }
            databaseOutputStream.flush();
            databaseOutputStream.close();
            databaseInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPathDataBaseSystem() {
        return context.getApplicationInfo().dataDir + DB_PATH_SUFIX + DATABASE_NAME;
    }

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> arrayList = new ArrayList<>();

    }

}
