package com.example.nom6_scroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//adapter만들어줄때는 baseAdapter를 상속받아서만들어준다.
public class MyFirstAdapter extends BaseAdapter {
private List<Weather> mData;
private Map<String,Integer> mWeatherImageMap;
public MyFirstAdapter(List<Weather> Data){
    this.mData=Data;
    mWeatherImageMap=new HashMap<>();
    mWeatherImageMap.put("맑음",R.drawable.sunny);
    mWeatherImageMap.put("폭설",R.drawable.blizzard);
    mWeatherImageMap.put("구름",R.drawable.cloudy);
    mWeatherImageMap.put("비",R.drawable.rainy);
    mWeatherImageMap.put("눈",R.drawable.snow);


}

    //아이템의 개수
    @Override
    public int getCount() {
        return mData.size();
    }

//어디에 아이템이있는지
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//외부의 layout을 inflater를 통해서  가져옴
    //convert뷰는 getview로 return 해준값을 저장
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    viewHolder holder;
    if(convertView==null){
        holder=new viewHolder();
        convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather,parent,false);
        ImageView weatherImageView=convertView.findViewById(R.id.weather_image);
        TextView cityText=convertView.findViewById(R.id.city_text);
        TextView tempText=convertView.findViewById(R.id.temp_text);

        holder.weatherImageView=weatherImageView;
        holder.cityText=cityText;
        holder.tempText=tempText;
        convertView.setTag(holder);
    }
    else{
        holder=(viewHolder) convertView.getTag();
    }

    Weather weather=mData.get(position);
    holder.cityText.setText(weather.getCity());
    holder.tempText.setText(weather.getTemp());
    holder.weatherImageView.setImageResource(mWeatherImageMap.get(weather.getWeather()));
        return convertView;
    }
//반복적으로 findview하는것을 줄여주는 기능을한다.
    static class viewHolder{

        public ImageView weatherImageView;
        public TextView cityText;
        public TextView tempText;
    }
}
