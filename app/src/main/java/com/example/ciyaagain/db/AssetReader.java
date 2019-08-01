package com.example.ciyaagain.db;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class AssetReader {

    private static final String TAG = AssetReader.class.getName();

    WeakReference<Context> context;

    public AssetReader(Context context) {
        this.context = new WeakReference<>(context);
    }

    public String getFileJSON(String fileName) {
        if(context.get() != null){
            try{
                AssetManager manager = context.get().getAssets();
                InputStream file = manager.open(fileName);
                byte[] formArray = new byte[file.available()];
                file.read(formArray);
                file.close();
                return new String(formArray);
            }catch (IOException ex){
                Log.e(TAG, ex.getLocalizedMessage(), ex);
            }
        }

        return null;
    }
}
