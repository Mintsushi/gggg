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

import java.io.File;

/**
 * Created by 리제 on 2017-05-10.
 */

public class StoreFlowerPollenInfomationActivity extends Fragment
{
    private int flowerNumber;
    private int pollenNumber;
    StoreFlowerPollenInfomationActivity(int i, int j){
        this.flowerNumber = i;
        this.pollenNumber = j;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.view_listinfomation,null);
        view.setBackgroundColor(Color.RED);

        final PlantData plantdata = new PlantData();

        ImageView flowerImage = (ImageView) view.findViewById(R.id.liFlowerImage);
        //flowerNumber + pollenNumber;
        flowerImage.setImageDrawable(getActivity().getDrawable(plantdata.getImages(pollenNumber)));

        TextView name = (TextView) view.findViewById(R.id.liFlowerName);
        name.setText(plantdata.getnames(flowerNumber));

        TextView information = (TextView) view.findViewById(R.id.liFlowerInfomation);
        information.setText(plantdata.getitems(flowerNumber));

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