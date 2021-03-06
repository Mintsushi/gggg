package com.example.neopul13;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 리제 on 2017-05-10.
 */
// 상점화면의 리스트뷰 생성해주는 코드들 크 존나 잘만듬;;

public class StoreItemInfomationActivity extends Fragment
{
    private int itemNumber;

    StoreItemInfomationActivity(int i){
        this.itemNumber = i;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {


        View view = inflater.inflate(R.layout.view_listinfomation,null);
        view.setBackgroundColor(Color.BLUE);

        final ItemData itemdata = new ItemData();

        ImageView flowerImage = (ImageView) view.findViewById(R.id.liFlowerImage);
        flowerImage.setImageDrawable(getActivity().getDrawable(itemdata.getImages(itemNumber)));

        TextView name = (TextView) view.findViewById(R.id.liFlowerName);
        name.setText(itemdata.getnames(itemNumber));

        TextView information = (TextView) view.findViewById(R.id.liFlowerInfomation);
        information.setText(itemdata.getitems(itemNumber));

        Button buyFlowerButton = (Button) view.findViewById(R.id.buyButton);
        buyFlowerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
                builder.setMessage("Buy ?");
                builder.setTitle("Eixt")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int i){
                                startActivity(new Intent(getActivity(), MainActivity.class));
                                getActivity().finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Are You Buy?");
                alert.show();

                
            }
        });

        return view;
    }
}