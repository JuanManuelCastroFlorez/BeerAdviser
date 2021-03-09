package com.example.beeradvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);

        String [] light = getResources().getStringArray(R.array.lightRecomendation);
        String [] dark = getResources().getStringArray(R.array.darkRecomendation);
        String [] brown = getResources().getStringArray(R.array.brownRecomendation);
        String [] amber = getResources().getStringArray(R.array.amberRecomendation);

        BeerExpert be = new BeerExpert(light, brown, dark, amber);

        String beerType = String.valueOf(color.getSelectedItem());
        //System.out.println(be.getRecomnedation(beerType));
        //brands.setText(light[0] + dark[0] + amber[0] + brown[0]);
        brands.setText(be.getRecomnedation(beerType));

    }
}