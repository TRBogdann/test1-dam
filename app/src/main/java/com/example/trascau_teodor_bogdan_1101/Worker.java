package com.example.trascau_teodor_bogdan_1101;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class Worker implements Runnable{
    String url;
    TextView tv;
    public Worker(String url, TextView tv)
    {
        this.url = url;
        this.tv = tv;
    }
    @Override
    public void run() {

        try {
            URLReader reader = new URLReader(url);
            String result = reader.read();
            Handler threadHandler = new Handler(Looper.getMainLooper());
            threadHandler.post(new Runnable() {
                @Override
                public void run() {
                    tv.setText(result);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
