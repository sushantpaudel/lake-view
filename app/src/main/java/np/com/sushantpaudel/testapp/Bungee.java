package np.com.sushantpaudel.testapp;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.io.InputStream;

public class Bungee extends AppCompatActivity {
    GoogleMap mGoogleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bungee);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set image in toolbar
        CollapsingToolbarLayout myToolbar=(CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        try{
            InputStream ims = getAssets().open("bungee/bungee_logo.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            myToolbar.setBackground(d);
        }
        catch (IOException ex){
        }
        //change font in text view and retrieve its data from asset
        TextView myTextView=(TextView)findViewById(R.id.bungee_text);
        Typeface typeface= Typeface.createFromAsset(getAssets(), "fonts/text_font.otf");
        myTextView.setTypeface(typeface);
        myTextView.setTextSize(15);
        try{
            InputStream ims=getAssets().open("bungee/text_bungee.txt");
            int size=ims.available();
            byte[] buffer=new byte[size];
            ims.read(buffer);
            ims.close();
            myTextView.setText(new String(buffer));
        }catch (IOException ex){
        }

        //Map Fragment using
      //  initmap();
        //To view map
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Show map...", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                NestedScrollView scroll=(NestedScrollView)findViewById(R.id.content_bungee);
                scroll.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

  /*  private void initmap() {
        MapFragment mMap= (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mMap.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap=googleMap;
        goToLocation(28.19,83.96,15);
    }

    private void goToLocation(double lat, double lng,int zoom) {
        LatLng ll=new LatLng(lat,lng);
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(ll,zoom);
        mGoogleMap.moveCamera(update);
    }*/
}
