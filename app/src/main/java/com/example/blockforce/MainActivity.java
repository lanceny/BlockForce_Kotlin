package com.example.blockforce;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private ScoreDatabaseHelper helper = null;
    private StringBuilder ScoreText = new StringBuilder();
    private String[] cols =  {"Lines", "date", "Latest"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new ScoreDatabaseHelper(this);
    }


    public void Start_onClick(View view) {
        Intent i = new Intent(this,com.example.blockforce.Play.class);
        startActivityForResult(i,1);
        overridePendingTransition(0, 0);
    }

    public void How_onClick(View view){
        DialogFragment dialog = new HowToPlayDialog();
        dialog.show(getSupportFragmentManager(),"dialog_how");
    }

    public void score_onClick(View view){
        ScoreText.setLength(0);
        try(SQLiteDatabase db = helper.getWritableDatabase()){

            db.beginTransaction();
            Cursor search = db.query("score", cols, "Latest = ?", new String[]{"1"}, null, null, null, null);
            if(search.getCount() != 0){
                search.moveToFirst();
                ScoreText.append("Latest score\nLines : ").append(search.getString(0)).append("   Date : ").append(search.getString(1)).append("\n\n");

                Cursor cs = db.query("score", cols, null, null, null, null,"Lines DESC", null);
                boolean eol = cs.moveToFirst();
                while(eol){
                    ScoreText.append("Lines : ").append(cs.getString(0)).append("   Date : ").append(cs.getString(1)).append("\n");
                    eol = cs.moveToNext();
                }
                cs.close();
            }
            search.close();

            db.setTransactionSuccessful();
            db.endTransaction();
        }

        DialogFragment dialog = new ScoreDialog(ScoreText);
        dialog.show(getSupportFragmentManager(),"dialog_score");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = df.format(new Date(System.currentTimeMillis()));
        if(requestCode == 1 && resultCode == RESULT_OK){
            int Lines = data.getIntExtra("Lines",0);
            try(SQLiteDatabase db = helper.getWritableDatabase()){
                db.beginTransaction();

                ContentValues cv = new ContentValues();
                cv.put("Latest", 0);
                db.update("score", cv, "Latest = 1", null);
                cv = new ContentValues();
                cv.put("Lines", Lines);
                cv.put("date", date);
                cv.put("Latest", 1);
                db.insertWithOnConflict("score", null, cv, SQLiteDatabase.CONFLICT_REPLACE);

                db.setTransactionSuccessful();
                db.endTransaction();
            }
            Toast.makeText(this,"Game Over !!  Lines "+Lines,Toast.LENGTH_LONG).show();
        }
    }
}
