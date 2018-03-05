package com.prolificinteractive.materialcalendarview.sample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Routing Activity for other samples
 */
public class MainActivity extends ActionBarActivity {
    int MAX_PAGE = 3;                         //View Pager의 총 페이지 갯수를 나타내는 변수 선언
    Fragment cur_fragment = new Fragment(); //현재 Viewpager가 가리키는 Fragment를 받을 변수 선언
    ImageButton major, school, school_fair, q_a;
    Button bt, view_click;
    int cur_pagenumber = 0;
    Log LOG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);        //Viewpager 선언 및 초기화
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));     //선언한 viewpager에 adapter를 연결
       // LinearLayout view_liear = (LinearLayout)findViewById(R.id.view_liear);

        major = (ImageButton) findViewById(R.id.major);
        school = (ImageButton) findViewById(R.id.school);
        school_fair = (ImageButton) findViewById(R.id.school_fair);
        q_a = (ImageButton) findViewById(R.id.q_a);
        bt = (Button) findViewById(R.id.bt);
        view_click = (Button)findViewById(R.id.view_click);

        findViewById(R.id.major).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        major = (ImageButton) findViewById(R.id.major);
                        major.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                q_a.setImageResource(R.drawable.q_a);
                                major.setImageResource(R.drawable.major_c);
                                school.setImageResource(R.drawable.school_story);
                                school_fair.setImageResource(R.drawable.school_fair);
                                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                });

        findViewById(R.id.q_a).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        q_a = (ImageButton) findViewById(R.id.q_a);
                        q_a.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                q_a.setImageResource(R.drawable.q_a_c);
                                major.setImageResource(R.drawable.major);
                                school.setImageResource(R.drawable.school_story);
                                school_fair.setImageResource(R.drawable.school_fair);
                                Intent intent = new Intent(MainActivity.this, QnAActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                });

        findViewById(R.id.school_fair).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        school_fair = (ImageButton) findViewById(R.id.school_fair);
                        school_fair.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                q_a.setImageResource(R.drawable.q_a);
                                major.setImageResource(R.drawable.major);
                                school.setImageResource(R.drawable.school_story);
                                school_fair.setImageResource(R.drawable.school_fair_c);
                                Intent intent = new Intent(MainActivity.this, BasicActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                });

        findViewById(R.id.school).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        school = (ImageButton) findViewById(R.id.school);
                        school.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                q_a.setImageResource(R.drawable.q_a);
                                major.setImageResource(R.drawable.major);
                                school.setImageResource(R.drawable.schoolstory_c);
                                school_fair.setImageResource(R.drawable.school_fair);
                                Intent intent = new Intent(MainActivity.this, SchoolStoryActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                });

//        viewPager.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SchoolFairActivity.class);
//                startActivity(intent);
//            }
//        });
//
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "LOG:: click_1");

                Intent intent;

                switch (cur_pagenumber) {
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, BasicActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.e-mirim.hs.kr"));
                        startActivity(browserIntent);
                        break;
                }
            }
        });

        view_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "LOG:: click_1");

                Intent intent;

                switch (cur_pagenumber) {
                    case 0:
                        Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, BasicActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.e-mirim.hs.kr"));
                        startActivity(browserIntent);
                        break;
                }
            }
        });

//        view_liear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("TAG", "LOG:: click_3");
//
//                Intent intent;
//
//                switch (cur_pagenumber) {
//                    case 0:
//                        break;
//                    case 1:
//                        intent = new Intent(MainActivity.this, BasicActivity.class);
//                        startActivity(intent);
//                        break;
//                    case 2:
//                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.e-mirim.hs.kr"));
//                        startActivity(browserIntent);
//                        break;
//                }
//            }
//        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                cur_pagenumber = position;
                Toast.makeText(MainActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    private class adapter extends FragmentPagerAdapter {                    //adapter클래스
        public adapter(FragmentManager fm) {
            super(fm);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        @Override
        public Fragment getItem(final int position) {
            Toast.makeText(MainActivity.this, "Fragment", Toast.LENGTH_SHORT).show();

            if (position < 0 || MAX_PAGE <= position)        //가리키는 페이지가 0 이하거나 MAX_PAGE보다 많을 시 null로 리턴
                return null;

            switch (position) {              //포지션에 맞는 Fragment찾아서 cur_fragment변수에 대입
                case 0:
                    cur_fragment = new page_1();
                    break;

                case 1:
                    cur_fragment = new page_2();
                    break;

                case 2:
                    cur_fragment = new page_3();
                    break;
            }

            return cur_fragment;
        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
    }
}