package org.akshanshgusain.killmonger2test;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
         private ArrayList<Object> mObjects=new ArrayList<>();
         private RecyclerView mRecyclerView;
         private RecyclerView.LayoutManager mLayoutManager;
         private Toolbar mToolbar;
         private DrawerLayout mDrawerLayout;
         private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.main_recyclerView);
        //Declare MainAdapter Here
        MainAdapter adapter=new MainAdapter(getObject(),this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Adding toolbar
        mToolbar=(Toolbar)findViewById(R.id.tootbar_pink);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Drawerlayout
        mDrawerLayout=(DrawerLayout)findViewById(R.id.nav_drawer);
        //Toggle
        ActionBarDrawerToggle mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        //Navigation View Listner
        mNavigationView=(NavigationView)findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        }

        public ArrayList<Object> getObject(){
            mObjects.add(getHorizontalData().get(0));
            mObjects.add(getBannerData().get(0));
            mObjects.add(getVerticalData().get(0));

            return mObjects;
        }
    public static ArrayList<SingleBanner> getBannerData() {
    ArrayList<SingleBanner> mtemp=new ArrayList<>();

        mtemp.add(new SingleBanner("https://www.samsung.com/global/galaxy/gear-s3/images/buy-now_banner_gear-s3.png"));
        mtemp.add(new SingleBanner("https://pixel.nymag.com/imgs/daily/selectall/2017/09/20/20-apple-watch.w710.h473.jpg"));
        mtemp.add(new SingleBanner("https://cnet4.cbsistatic.com/img/KnuL1WDed3sanatLbE4YDddJGVg=/2017/10/31/312b3b6e-59b7-499a-aea4-9bc5f9721a21/iphone-x-54.jpg"));
        return mtemp;


    }

    public static ArrayList<SingleHorizontal> getHorizontalData() {
        ArrayList<SingleHorizontal> mtemp=new ArrayList<>();
        mtemp.add(new SingleHorizontal(R.drawable.ic_launcher_foreground_dark2,"Horizontal Description"));
         mtemp.add(new SingleHorizontal(R.drawable.ic_launcher_foreground_dark2,"Horizontal Description"));
         mtemp.add(new SingleHorizontal(R.drawable.ic_launcher_foreground_dark2,"Horizontal Description"));
         mtemp.add(new SingleHorizontal(R.drawable.ic_launcher_foreground_dark2,"Horizontal Description"));
         mtemp.add(new SingleHorizontal(R.drawable.ic_launcher_foreground_dark2,"Horizontal Description"));
        return mtemp;
    }

     public static ArrayList<SingleVertical> getVerticalData() {
         ArrayList<SingleVertical> mtemp=new ArrayList<>();
         mtemp.add(new SingleVertical("Vertical Description",R.drawable.ic_launcher_foreground_dark3));
         mtemp.add(new SingleVertical("Vertical Description",R.drawable.ic_launcher_foreground_dark3));
         mtemp.add(new SingleVertical("Vertical Description",R.drawable.ic_launcher_foreground_dark3));
         mtemp.add(new SingleVertical("Vertical Description",R.drawable.ic_launcher_foreground_dark3));
         mtemp.add(new SingleVertical("Vertical Description",R.drawable.ic_launcher_foreground_dark3));
         mtemp.add(new SingleVertical("Vertical Description",R.drawable.ic_launcher_foreground_dark3));
         mtemp.add(new SingleVertical("Vertical Description",R.drawable.ic_launcher_foreground_dark3));

         return  mtemp;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_menu1:
                Toast.makeText(this, "one", Toast.LENGTH_SHORT).show();break;
            case R.id.nav_menu2:
                Toast.makeText(this, "two", Toast.LENGTH_SHORT).show();break;
            case R.id.nav_outer:
                Toast.makeText(this, "Three", Toast.LENGTH_SHORT).show();break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
