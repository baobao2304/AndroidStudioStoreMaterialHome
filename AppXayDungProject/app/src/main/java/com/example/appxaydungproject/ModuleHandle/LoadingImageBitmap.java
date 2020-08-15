package com.example.appxaydungproject.ModuleHandle;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class LoadingImageBitmap {
    public int LoadingImage(String strImg, ImageView imageView){
        int id;
        Context context = imageView.getContext();
        return  id = context.getResources().getIdentifier(strImg,"drawable",context.getPackageName());
    }
}
