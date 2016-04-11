package com.d954mas.android.yandextest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 09.04.2016.
 */
public class ArtistBean {
    private String url;
    protected JSONObject json;

    public long id;
    public String name;
    public String smallImageUrl;
    public String bigImageUrl;
    public ArrayList<String> genres;
    public int tracks;
    public int albums;
    public String link;
    public String description;

    public ArtistBean(){
        genres=new ArrayList<>();
    }

    public ArtistBean(JSONObject artist){
        this();
        changeData(artist);
    }

    public void changeData(JSONObject json){
        this.json = json;
        genres.clear();
        try {
            id=json.getLong("id");
            name=json.getString("name");
            JSONArray genresJsonArray=json.getJSONArray("genres");
            for (int i = 0; i < genresJsonArray.length(); i++) {
                genres.add(genresJsonArray.getString(i));
            }
            smallImageUrl=json.getJSONObject("cover").getString("small");
            bigImageUrl=json.getJSONObject("cover").getString("big");
            tracks=json.getInt("tracks");
            albums=json.getInt("albums");
            if(json.has("link")){
                link=json.getString("link");
            }else{
                link="";
            }

            description=json.getString("description");
            if(!description.isEmpty()){//игнорируем пустые строки
                description=Character.toUpperCase(description.charAt(0))+description.substring(1,description.length()-1);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJson() {
        return json;
    }
}
