package np.com.sushantpaudel.testapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static android.R.attr.maxHeight;
import static android.R.attr.maxWidth;
import static android.R.attr.minWidth;
import static android.R.attr.orientation;
import static android.R.attr.screenSize;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView_travel_destinations,recyclerView_cultural_heritage;
    private List<Album> albumList;
    private AlbumsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Collapsing Recycler views on clicking Text Views
        final TextView txt1=(TextView)findViewById(R.id.DropDownTravelDestinations);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recyclerView_travel_destinations.getVisibility()==View.GONE){
                    recyclerView_travel_destinations.setVisibility(View.VISIBLE);
                    txt1.setPadding(0,0,0,0);
                }else{
                    recyclerView_travel_destinations.setVisibility(View.GONE);
                    txt1.setPadding(20,20,20,20);
                }
            }
        });
        final TextView txt2=(TextView)findViewById(R.id.DropDownCulturalHeritage);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recyclerView_cultural_heritage.getVisibility()==View.GONE){
                    recyclerView_cultural_heritage.setVisibility(View.VISIBLE);
                    txt2.setPadding(0,0,0,0);
                }else{
                    recyclerView_cultural_heritage.setVisibility(View.GONE);
                    txt2.setPadding(20,20,20,20);
                }
            }
        });

        //App bar layout :: Default code
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //RECYCLER VIEW & CARD VIEW
        //first recycler view
        recyclerView_travel_destinations = (RecyclerView) findViewById(R.id.recycler_view_travel_destinations);
        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList,1);
		
        final RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_travel_destinations.setLayoutManager(mLayoutManager);
        recyclerView_travel_destinations.setItemAnimator(new DefaultItemAnimator());
        recyclerView_travel_destinations.setAdapter(adapter);
        recyclerView_travel_destinations.setNestedScrollingEnabled(false);
        
		prepareImages_travel_destinations();
        //second recycler view
        recyclerView_cultural_heritage = (RecyclerView) findViewById(R.id.recycler_view_cultural_heritage);
        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList,2);

		final RecyclerView.LayoutManager nLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_cultural_heritage.setLayoutManager(nLayoutManager);
        recyclerView_cultural_heritage.setItemAnimator(new DefaultItemAnimator());
        recyclerView_cultural_heritage.setAdapter(adapter);
        recyclerView_cultural_heritage.setNestedScrollingEnabled(false);

		prepareImages_cultural_heritage();
        //end here recycler and card view*************************
    }

    private void prepareImages_travel_destinations()    {
        int[] travel_destinations =new int[]{
                R.drawable.a0,
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5
        };
        Album a=new Album("Davis Fall", travel_destinations[0]);
        albumList.add(a);
        a=new Album("Sarangkot", travel_destinations[1]);
        albumList.add(a);
        a=new Album("Shanti Stupa", travel_destinations[2]);
        albumList.add(a);
        a=new Album("Begnas Lake", travel_destinations[3]);
        albumList.add(a);
        a=new Album("Fewa Lake", travel_destinations[4]);
        albumList.add(a);
        a=new Album("Rupa Lake", travel_destinations[5]);
        albumList.add(a);
        adapter.notifyDataSetChanged();
    }

    private void prepareImages_cultural_heritage() {
        int[] cultural_heritage =new int[]{
                R.drawable.b0,
                R.drawable.b1
        };
        Album b=new Album("Talbarahi Temple", cultural_heritage[0]);
        albumList.add(b);
        b=new Album("Gupteswor Cave", cultural_heritage[1]);
        albumList.add(b);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.contact) {
            //for opening contact us activity
        } else if (id== R.id.update){
            //for showing a snack bar with Updated Succesfully
            Toast.makeText(this,"Recently Updated",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.NightLife) {
            // Open Night Life activity
        } else if (id == R.id.LodgesHotels) {
            // Open Lodges and Hotels
        } else if (id == R.id.RestaurantCafe) {
            // Open Restaurants and Cafe
        } else if (id == R.id.Paragliding) {
            // Open Paragliding agencies
        } else if (id == R.id.Bungee) {
            Intent bungee=new Intent(this,Bungee.class);
            startActivity(bungee);
            // Open Bungee (Hemja one)
        } else if (id == R.id.TravelAgencies) {
            // Open Travel Agencies
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
