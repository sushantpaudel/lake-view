package np.com.sushantpaudel.testapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PopupClass extends AppCompatActivity {

    private View mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_view);
        Bundle b = getIntent().getExtras();
        int value = -1; // or other values
        if(b != null)
            value = b.getInt("key");
        settingText(value);
        mContext=findViewById(R.id.popup_home);
        mContext.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
    public void settingText(int i){
        TextView txt=(TextView)findViewById(R.id.popup_text);
        ImageView view=(ImageView)findViewById(R.id.popup_image);
        Typeface typeface= Typeface.createFromAsset(getAssets(), "fonts/text_font.otf");
        txt.setTypeface(typeface);
        view.setVisibility(View.VISIBLE);
        switch (i){
            case 10:
                //Davis Fall
                view.setBackgroundResource(R.drawable.a0);
                txt.setText(getResources().getString(R.string.DavisFall));
                break;
            case 11:
                //Sarankot
                view.setBackgroundResource(R.drawable.a1);
                txt.setText(getResources().getString(R.string.Sarangkot));
                break;
            case 12:
                //Shanti Stupa
                view.setBackgroundResource(R.drawable.a2);
                txt.setText(getResources().getString(R.string.ShantiStupa));
                break;
            case 13:
                //Begnas Lake
                view.setBackgroundResource(R.drawable.a3);
                txt.setText(getResources().getString(R.string.BegnasLake));
                break;
            case 14:
                //Fewa Lake
                view.setBackgroundResource(R.drawable.a4);
                txt.setText(getResources().getString(R.string.FewaLake));
                break;
            case 15:
                //Rupa Lake
                view.setBackgroundResource(R.drawable.a5);
                txt.setText(getResources().getString(R.string.RupaLake));
                break;
            case 20:
                //Talbarahi Temple
                view.setBackgroundResource(R.drawable.b0);
                txt.setText(getResources().getString(R.string.TalbarahiTemple));
                break;
            case 21:
                //Gupteshwor Cave
                view.setBackgroundResource(R.drawable.b1);
                txt.setText(getResources().getString(R.string.GupteshworCave));
                break;
        }

    }
}
