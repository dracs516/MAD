package com.example.progressbarandalertdialogue;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class A_Progress_Bar extends AppCompatActivity {

    Button btnStartProgress;
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_progress_bar);

        btnStartProgress = findViewById(R.id.button1);
        btnStartProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar = new ProgressDialog(A_Progress_Bar.this);
                progressBar.setCancelable(true);
                progressBar.setMessage("File downloading");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();

                progressBarStatus = 0;
                fileSize = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressBarStatus < 100){


                            try {
                                Thread.sleep(1000);
                                progressBarStatus = doOperation();
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }

                            progressBarHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressBarStatus);
                                }
                            });
                        }
                        if(progressBarStatus >= 100){
                            try {
                                Thread.sleep(1000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }

                            progressBar.dismiss();
                        }
                    }
                }).start();
            }
        });
    }

    public int doOperation(){
        while (fileSize <= 10000){
            fileSize++;

            if(fileSize == 1000) return 10;
            else if(fileSize == 2000) return 20;
            else if(fileSize == 3000) return 30;
            else if(fileSize == 4000) return 40;
            else if(fileSize == 5000) return 50;
            else if(fileSize == 6000) return 60;
            else if(fileSize == 7000) return 70;
            else if(fileSize == 8000) return 80;
//            else return 100;
        }
        return 100;
    }
}