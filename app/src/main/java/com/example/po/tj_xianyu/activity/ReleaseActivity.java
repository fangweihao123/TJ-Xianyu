package com.example.po.tj_xianyu.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.po.tj_xianyu.R;
import com.example.po.tj_xianyu.gson.Item;
import com.example.po.tj_xianyu.service.cameraservice.CameraService;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 13701 on 2017/12/25.
 */

public class ReleaseActivity extends AppCompatActivity {
    @BindView(R.id.et_main_3)
    EditText mItemName;
    @BindView(R.id.et_desc)
    EditText mItemDesc;
    @BindView(R.id.et_price)
    EditText mEditText;
    @BindView(R.id.item_taken_photo)
    ImageView mPhotoView;
    @BindView(R.id.item_camera)
    ImageButton mImageButton;
    private File mPhotoFile;
    private Item mItem = new Item();
    private static final int REQUEST_PHOTO = 2;
    public static final int TAKE_PHOTO = 111;
    final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


    @OnClick(R.id.item_camera)
    public void camera(){
        String name = mItemName.getText().toString();
        mItem.setItemName(name);
        mPhotoFile = CameraService.getPhotoFile(this,mItem);
        boolean canTakePhoto = mPhotoFile!=null&&
                captureImage.resolveActivity(getPackageManager())!=null;
        mImageButton.setEnabled(canTakePhoto);                                  //判断是否存在相机 从而判断是否能够进行拍照

        if(canTakePhoto){
            Uri uri = Uri.fromFile(mPhotoFile);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        }
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivityForResult(captureImage,REQUEST_PHOTO);
                takePhoto();
            }
        });
    }

    private void takePhoto(){
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(captureIntent, TAKE_PHOTO);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.fragment_widgets);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }
}
