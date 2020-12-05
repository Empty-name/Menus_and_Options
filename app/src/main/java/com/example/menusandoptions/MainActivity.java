package com.example.menusandoptions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_android;
    Button btn_activate, btn_terminate;
    Animation anim_rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_android = findViewById(R.id.iv_android);
        btn_activate = findViewById(R.id.btn_activate);
        btn_terminate = findViewById(R.id.btn_terminate);
        anim_rotate = AnimationUtils.loadAnimation(this, R.anim.anim_android);
        anim_rotate.setDuration(3000);

        setOnClickListener();
    }

    public void setOnClickListener(){
        btn_activate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iv_android.startAnimation(anim_rotate);
                    }
                }
        );

        btn_terminate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Confirm exit");
                        builder.setMessage("Are you sure you want to exit?");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.finish();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
        );

    }


}