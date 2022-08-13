package com.bytedance.movies.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MovieCacheDao {
    private static MovieCacheDao spDao;
    private File cachePath;
    private File filePath;
    private Context context;

    private MovieCacheDao() {
    }

    public static MovieCacheDao newInstance(Context context,String cacheDirName) {
        if (spDao == null) {
            spDao = new MovieCacheDao();
            spDao.cachePath = new File(context.getExternalCacheDir(),cacheDirName);
            spDao.filePath = context.getExternalFilesDir("movie");
            spDao.context = context;
        }
        return spDao;
    }

    public Drawable getPosterByStringId(String id, String url) {
        File file = new File(cachePath, id);
        if (file.exists()) {
            if (file.length() == 0) {
                System.out.println("cache err");
                return null;
            }
            System.out.println("from cache");
            return Drawable.createFromPath(file.getAbsolutePath());
        } else {
            return null;
        }
    }

    public void writePosterCache(String id, Drawable drawable) {
        File file = new File(cachePath,id);
        if(file.exists()) return;
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file.getAbsolutePath());
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}