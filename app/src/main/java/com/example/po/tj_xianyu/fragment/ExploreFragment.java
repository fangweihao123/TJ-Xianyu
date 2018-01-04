package com.example.po.tj_xianyu.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.po.tj_xianyu.R;
import com.example.po.tj_xianyu.adapter.ExploreAdapter;
import com.example.po.tj_xianyu.gson.Item;
import com.example.po.tj_xianyu.service.photoservice.PhotoService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13701 on 2017/12/28.
 */

public class ExploreFragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ArrayList<Item> itemList;
    private ExploreAdapter exploreAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.explore_layout,container,false);
        ButterKnife.bind(this,v);
        Resources res = getContext().getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.bottom_dialog);
        String bitmapString = PhotoService.convertIconToString(bitmap);
        itemList = new ArrayList<Item>();
        itemList.add(new Item(1,"水桶","这个水桶我不用了",0,1,bitmapString));
        itemList.add(new Item(2,"二手电脑","mac pro 三年前买的，速度有点慢了，不过办公还是没有问题的",2000,1,bitmapString));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        exploreAdapter = new ExploreAdapter(itemList,getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exploreAdapter);

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
