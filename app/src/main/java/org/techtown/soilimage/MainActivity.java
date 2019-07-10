package org.techtown.soilimage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private long time= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gallery_button = (Button)findViewById(R.id.gallery_button);
        gallery_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gintent = new Intent(MainActivity.this, GalleryImport.class);
                startActivity(gintent);
            }
        });

        Button takePicture_button = (Button)findViewById(R.id.picture_button);
        takePicture_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pintent = new Intent(MainActivity.this, TakePicture.class);
                startActivity(pintent);
            }
        });

    }
    //뒤로가기 버튼을 두번 연속으로 눌러야 종료되게끔 하는 메소드
    @Override
    public void onBackPressed(){
        if (System.currentTimeMillis()-time>=2000){
            time = System.currentTimeMillis();


        }else if(System.currentTimeMillis()-time<2000){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("정말로 종료하시겠습니까?");
            builder.setTitle("종료 알림창")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("종료 알림창");
            alert.show();
            //super.onBackPressed();
        }
    }
}
