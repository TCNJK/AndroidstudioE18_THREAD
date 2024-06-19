package com.example.androidstudioe18_thread;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Service.ImageDownloader;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.imageView);
        downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl = "https://scontent.fsgn2-8.fna.fbcdn.net/v/t1.15752-9/436549524_1190928272061680_8191214194669823011_n.png?_nc_cat=102&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeE1o_h4ke6Kbw3xGaySypJL7MI0ecXounnswjR5xei6ee4uKqnEWl6YeQkae1woIp91T2mpGTSwOE0zygKaL90v&_nc_ohc=0DnLLJJr704Q7kNvgErIx5D&_nc_ht=scontent.fsgn2-8.fna&cb_e2o_trans=t&oh=03_Q7cD1QG0DvinhwBaEclcowPQ-27P-reLhD3V8vfUfsHbBKS8Vw&oe=6699BBE2";
                new ImageDownloader(imageView).downloadImage(imageUrl);
            }
        });
    }
}