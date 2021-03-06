package com.example.ahsan.hciproject.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.ahsan.hciproject.Activity.DealItemList;
import com.example.ahsan.hciproject.Adapter.GridImageAdapter;
import com.example.ahsan.hciproject.Adapter.ItemAdapter;
import com.example.ahsan.hciproject.R;
import com.example.ahsan.hciproject.entity.Deal;
import com.example.ahsan.hciproject.entity.DealItem;
import com.example.ahsan.hciproject.entity.Item;
import com.example.ahsan.hciproject.util.RecycletItemClickListener;
import com.example.ahsan.hciproject.util.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by AHSAN on 11/15/2017.
 */

public class Beverages  extends Fragment {

    private RecyclerView recycler_view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.deal_view, container, false);
        recycler_view = view.findViewById(R.id.recycler_view);
        initImageLoader();
        tempGridSetup();

        return view;
    }
    private void tempGridSetup(){
        ArrayList<DealItem> dealItems = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("https://static.pexels.com/photos/5938/food-salad-healthy-lunch.jpg","Food 1","567",false));
        items.add(new Item("https://static.pexels.com/photos/76093/pexels-photo-76093.jpeg","Food 2","600",false));
        items.add(new Item("https://static.pexels.com/photos/70497/pexels-photo-70497.jpeg","Food 3","563",false));
        items.add(new Item("https://static.pexels.com/photos/376464/pexels-photo-376464.jpeg","Food 4","567",true));
//
        dealItems.add(new DealItem("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg","Deal1",items,"657"));
        dealItems.add(new DealItem("https://i.redd.it/9bf67ygj710z.jpg","Deal2",items,"657"));
        dealItems.add(new DealItem("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg","Deal3",items,"657"));
        dealItems.add(new DealItem("http://i.imgur.com/EwZRpvQ.jpg","Deal4",items,"657"));
        dealItems.add(new DealItem("http://i.imgur.com/JTb2pXP.jpg","Deal5",items,"657"));
//        deals.add(new Deal("deal6","https://i.redd.it/59kjlxxf720z.jpg"));
//        deals.add(new Deal("deal7","https://i.redd.it/pwduhknig00z.jpg"));
//        deals.add(new Deal("deal8","https://i.redd.it/clusqsm4oxzy.jpg"));
//        deals.add(new Deal("deal9","https://i.redd.it/svqvn7xs420z.jpg"));
//        deals.add(new Deal("deal10","http://i.imgur.com/j4AfH6P.jpg"));
//        deals.add(new Deal("deal11","https://i.redd.it/89cjkojkl10z.jpg"));
//        deals.add(new Deal("deal12","https://i.redd.it/aw7pv8jq4zzy.jpg"));
//
        setupImageGrid(dealItems);

    }

    private void setupImageGrid(ArrayList<DealItem> imgURLs){
        ItemAdapter mAdapter = new ItemAdapter(imgURLs);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(mAdapter);
        recycler_view.addOnItemTouchListener(new RecycletItemClickListener(getContext(), recycler_view ,new RecycletItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getContext(),DealItemList.class);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getContext());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

}
