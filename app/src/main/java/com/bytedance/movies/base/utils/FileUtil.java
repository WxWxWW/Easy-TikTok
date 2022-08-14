package com.bytedance.movies.base.utils;

import android.content.Context;

import com.bytedance.movies.MoviesApplication;
import com.bytedance.movies.database.bean.Movie;
import com.bytedance.movies.database.bean.ReqData;
import com.bytedance.movies.database.bean.Tv;
import com.bytedance.movies.database.bean.Variety;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Objects;

/**
 * @Classname FileUtil
 * @Description: 文件常用操作
 * @Created by 康斯坦丁
 * @Date 2022/8/13 23:51
 */
public class FileUtil {
    private int operateMode = 0;


    //保存
    public static void save(String data,String fileName){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = MoviesApplication.getContext().openFileOutput(fileName,Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
            LogUtil.d("写入文件成功");
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.d("写入文件异常");
        }finally {
            try{
                if(writer != null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    //读取
    public static String load(String fileName){
        BufferedReader reader = null;
        FileInputStream input = null;
        StringBuilder content = new StringBuilder();
        try{
            input = MoviesApplication.getContext().openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(input));
            String line = "";
            while((line = reader.readLine())!= null){
                content.append(line);
            }
            LogUtil.d("读取文件成功");
        }catch (IOException e){
            e.printStackTrace();
            LogUtil.d("读取文件异常，为空");
        }finally {
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    public static  List<Movie> loadMovie(String dataJson){
        Gson gson = new Gson();
        List<Movie> datas = gson.fromJson(dataJson,new TypeToken<List<Movie>>(){}.getType());
        return datas;
    }
    public static  List<Tv> loadTv(String dataJson){
        Gson gson = new Gson();
        List<Tv> datas = gson.fromJson(dataJson,new TypeToken<List<Tv>>(){}.getType());
        return datas;
    }
    public static  List<Variety> loadVariety(String dataJson){
        Gson gson = new Gson();
        List<Variety> datas = gson.fromJson(dataJson,new TypeToken<List<Variety>>(){}.getType());
        return datas;
    }

    public static  List<Movie> loadObject(String dataJson){
        Gson gson = new Gson();
        ReqData datas = gson.fromJson(dataJson,ReqData.class);
        return datas.getData().getList();
    }
}
