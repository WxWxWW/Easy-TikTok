package com.qxy.minitiktok.util;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qxy.minitiktok.TikTokApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

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
            out = TikTokApplication.getContext().openFileOutput(fileName,Context.MODE_PRIVATE);
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
            input = TikTokApplication.getContext().openFileInput(fileName);
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

    public static  <T extends Object> List<T> loadListData(String dataJson){
        Gson gson = new Gson();
        List<T> datas = gson.fromJson(dataJson,new TypeToken<List<T>>(){}.getType());
        return datas;
    }

    public static  <T extends Object> T loadObject(String dataJson,Class<T> classOf){
        Gson gson = new Gson();
        T datas = gson.fromJson(dataJson,classOf);
        return datas;
    }


}
