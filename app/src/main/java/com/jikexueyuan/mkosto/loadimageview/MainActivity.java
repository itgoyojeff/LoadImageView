package com.jikexueyuan.mkosto.loadimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView001,imageView002,imageView003,imageView004;
    public static final String picUrl = "http://avatar.csdn.net/1/B/B/1_mkosto.jpg?1467859404110";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView001 = (ImageView)findViewById(R.id.imageView001);
        imageView002 = (ImageView)findViewById(R.id.imageView002);
        imageView003 = (ImageView)findViewById(R.id.imageView003);
        imageView004 = (ImageView)findViewById(R.id.imageView004);

        //用普通方法加载图片
        new NormalLoadPictrue().getPicture(picUrl,imageView001);

        //用ImageLoader加载图片
        ImageLoader.getInstance().displayImage(picUrl, imageView002,new ImageLoaderPicture(this).getOptions(),new SimpleImageLoadingListener());

        //用Volley加载图片
        VolleyLoadPicture vlp = new VolleyLoadPicture(this, imageView003);
        vlp.getmImageLoader().get(picUrl, vlp.getOne_listener());

        //xUtils加载图片
         BitmapUtils bitmapUtils = new BitmapUtils(this);
        bitmapUtils.display(imageView004, picUrl);
    }
}
