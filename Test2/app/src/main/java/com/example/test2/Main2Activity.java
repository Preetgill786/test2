package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity  implements  AdapterView.OnItemSelectedListener {
    ImageView iVimg;
    Spinner sp;
    EditText etcapital;
    ListView lv;
    myListView adapter;
    Main2Activity customView = null;
    static  int i;
    List<poiList> poiCanada =new ArrayList<poiList>();
    List<poiList> poiUsa =new ArrayList<poiList>();
    List<poiList> poiEngland =new ArrayList<poiList>();

    String[] capital = {"Ottawa", "Washington", "London"};
    int[] imageList={R.drawable.canada,R.drawable.usa,R.drawable.england};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iVimg=findViewById(R.id.img);
        sp=findViewById(R.id.country);
        etcapital=findViewById(R.id.capital);

        iVimg.setBackgroundResource(R.drawable.canada);


        List<String> country = new ArrayList<String>();
        country.add("CANADA ");
        country.add("USA");
        country.add("ENGLAND");

        //create an adapter and fill it from the list
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, country);
        //make the drop down style
        countryAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter items
        sp.setAdapter(countryAdapter);
        sp.setOnItemSelectedListener(this);

//        lv = (ListView) findViewById(R.id.listV);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
//                String text = sp.getSelectedItem().toString();
//                if (country[i]=="CANADA"){
//                    intent.putExtra("placeName",capital[i]);
//
//                    intent.putExtra("imageID", imageList[i]);
//
//                    startActivity(intent);
//
//                    //Toast.makeText(CountryDetailActivity.this, version[i]+" ", Toast.LENGTH_SHORT).show();
//
//                }
//                if (countryList[i]=="USA"){
//                    intent.putExtra("placeName",version1[i]);
//
//                    intent.putExtra("imageID", images[i]);
//
//                    startActivity(intent);
//
//                    Toast.makeText(CountryDetailActivity.this, version[i]+" ", Toast.LENGTH_SHORT).show();
//
//                }
//                if (countryList[i]=="England"){
//                    intent.putExtra("placeName",version2[i]);
//
//                    intent.putExtra("imageID", images[i]);
//
//                    startActivity(intent);
//
//                    Toast.makeText(CountryDetailActivity.this, version[i]+" ", Toast.LENGTH_SHORT).show();
//
//                }
//
//
//
//            }
//        });



    }
    public void setData(){
        poiList item = new poiList("Niagara falls","niagara");
        poiCanada.add(item);
        item=new poiList("CN Tower","cn");
        poiCanada.add(item);
        item=new poiList("The Butchart Gardens","btgarden");
        poiCanada.add(item);
        item=new poiList("Notre-Dame Basilica","dame");
        poiCanada.add(item);
        poiList item1 = new poiList("The Statue of Liberty","statue");
        poiUsa.add(item1);
        item1=new poiList("The White House","house");
        poiUsa.add(item1);
        item1=new poiList("Tims Square","timm");
        poiUsa.add(item1);
        poiList item2=new poiList("Big Ben","bigben");
        poiEngland.add(item2);
        item2=new poiList("Westminster Abbey","abbey");
        poiEngland.add(item2);
        item2=new poiList("Hyde Park","hyde");
        poiEngland.add(item2);
    }



    public void onItemClick(int i){
        poiList tempValue =(poiList) poiCanada.get(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        i = position;
        String cp = new String(capital[i]);
        etcapital.setText(cp);
        int img = imageList[i];
        iVimg.setBackgroundResource(img);
 if (i==0){
     customView = this;
     setData();
     Resources res= getResources();
     lv=findViewById(R.id.listV);
     adapter=new myListView(customView, (ArrayList) poiCanada,res);
     lv.setAdapter(adapter);

 }
  if(i==1){
     customView = this;
     setData();
     Resources res= getResources();
     lv=findViewById(R.id.listV);
     adapter=new myListView(customView, (ArrayList) poiUsa,res);
     lv.setAdapter(adapter);

 }
 if(i==2){
     customView = this;
     setData();
     Resources res= getResources();
     lv=findViewById(R.id.listV);
     adapter=new myListView(customView, (ArrayList) poiEngland,res);
     lv.setAdapter(adapter);

 }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
