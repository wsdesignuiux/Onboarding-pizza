package e.wolfsoft1.onboarding_pizza;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import adapter.CarouselPagerAdapter;
import adapter.LoginPagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class LoginActivity extends AppCompatActivity {

    public final static int LOOPS = 1000;
    public CarouselPagerAdapter adapter;
    public LoginPagerAdapter loginPagerAdapter;
    public ViewPager pager;
    public static int count = 10; //ViewPager items size
    /**
     * You shouldn't define first page = 0.
     * Let define firstpage = 'number viewpager size' to make endless carousel
     */
    public static int FIRST_PAGE = 10;

    private CircleIndicator indicator;

    int currentPage = 0;
    int NUM_PAGES = 2;


    int count1 = 0;
    Timer timer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pager = (ViewPager) findViewById(R.id.myviewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);


//        //set page margin between pages for viewpager
//        DisplayMetrics metrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int pageMargin = ((metrics.widthPixels / 4) * 2);
//        pager.setPageMargin(-pageMargin);
//
//        adapter = new CarouselPagerAdapter(this, getSupportFragmentManager());
//        pager.setAdapter(adapter);
//        indicator.setViewPager(pager);
//        adapter.registerDataSetObserver(indicator.getDataSetObserver());
//        adapter.notifyDataSetChanged();
//
//        pager.addOnPageChangeListener(adapter);
//
//        // Set current item to the middle page so we can fling to both
//        // directions left and right
//        pager.setCurrentItem(FIRST_PAGE);
//        pager.setOffscreenPageLimit(3);



        loginPagerAdapter = new LoginPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(loginPagerAdapter);

        indicator.setViewPager(pager);

        loginPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());



        // Timer for auto sliding
        timer  = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(count1<=5){
                            pager.setCurrentItem(count1);
                            count1++;
                        }else{
                            count = 0;
                            pager.setCurrentItem(count1);
                        }
                    }
                });
            }
        }, 500, 3000);


//        final Handler handler = new Handler();
//
//        final Runnable update = new Runnable() {
//            public void run() {
//                if (currentPage == NUM_PAGES - 1) {
//                    currentPage = 0;
//                }
//                pager.setCurrentItem(currentPage++, true);
//            }
//        };
//
//
//        new
//
//                Timer().
//
//                schedule(new TimerTask() {
//
//                    @Override
//                    public void run () {
//                        handler.post(update);
//                    }
//                },100,500);

    }
}
