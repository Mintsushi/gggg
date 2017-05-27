package com.example.neopul14;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 리제 on 2017-05-27.
 */

public class Content_mainActivity  extends AppCompatActivity implements GestureDetector.OnGestureListener {
    GestureDetector detector;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        count = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        // 터치 전용
        detector = new GestureDetector(this, this);

        // 식물관리창으로 가는 버튼 ( 임시 재작 )
        Button nameButton = (Button) findViewById(R.id.abutton);
        int asf = R.id.abutton;
        Log.i("ass2", "d = " + asf);
        nameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginPageActivity.class));
                finish();
            }

        });

        // 상점으로 가는 버튼 >> StoreMainActivity.class
        Button storeButton = (Button) findViewById(R.id.storeButton);
        int asd = R.id.storeButton;
        Log.i("ass1", "d = " + asd);
        storeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StoreMainActivity.class));
                finish();
            }

        });

        // 정원창에 9개의 이미지뷰 생성
        ImageView plantImage[] = new ImageView[9];
        plantImage[0] = (ImageView) findViewById(R.id.plantImage1);
        plantImage[1] = (ImageView) findViewById(R.id.plantImage2);
        plantImage[2] = (ImageView) findViewById(R.id.plantImage3);
        plantImage[3] = (ImageView) findViewById(R.id.plantImage4);
        plantImage[4] = (ImageView) findViewById(R.id.plantImage5);
        plantImage[5] = (ImageView) findViewById(R.id.plantImage6);
        plantImage[6] = (ImageView) findViewById(R.id.plantImage7);
        plantImage[7] = (ImageView) findViewById(R.id.plantImage8);
        plantImage[8] = (ImageView) findViewById(R.id.plantImage9);

        // 9개의 창 모두 비활성화
        //View.VISIBLE / View.INVISIBLE
        //활성   / 비활성 /
        for(int a =0; 9>a; a++){
            plantImage[a].setVisibility(View.INVISIBLE);
        }

        // 이미지를 누르면 관리창으로 가는 버튼
        for(int a =0; 9>a; a++){
            plantImage[a].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), PlantManagementActivity.class));
                    finish();
                }
            });

            //이미지 롱 클릭 이밴트 ( 화분 자리바꾸기에 쓸 예정 =)
            plantImage[a].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(getApplicationContext(), "1번 클릭", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });

        }
        plantImage[3].setVisibility(View.VISIBLE);

    }


    // 이 밑으로는 클릭 이밴트들
    // 왼쪽 슬라이드 캘랜더로 가계해주고

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = motionEvent.getDeviceId();
        Log.i("getMotion", "getID = " + d);
        return detector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(this, "[Touch] X = " + e.getX() + " / Y = " + e.getY(), Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float x1 = e1.getX(); //40
        float x2 = e2.getX(); //140

        if ((x2 - x1) > 100 && count == 0) {
            count = 1;
            startActivity(new Intent(Content_mainActivity.this, CalendarActivity.class));
            overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
            finish();
            return false;
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(this, "[LongPress] X = " + e.getX() + " / Y = " + e.getY(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        return false;
    }
}
