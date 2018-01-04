package com.example.po.tj_xianyu.service.cameraservice;

import android.content.Context;
import android.os.Environment;

import com.example.po.tj_xianyu.gson.Item;

import java.io.File;
import java.util.UUID;

/**
 * Created by 13701 on 2018/1/3.
 */

public class CameraService {
    public static File getPhotoFile(Context mContext,Item item){
        File externalFileDir = mContext
                .getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if(externalFileDir==null)
            return null;

        if(item.getItemName()==""){
            return new File(externalFileDir,"IMG"+ UUID.randomUUID().toString()+".jpg");
        }else{
            return new File(externalFileDir,item.getPhotoFileName());
        }

    }
}
