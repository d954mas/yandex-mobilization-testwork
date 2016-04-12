package com.d954mas.android.yandextest.adapters;

/**
 * Created by user on 10.04.2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.d954mas.android.yandextest.fragments.ArtistsFragment;
import com.d954mas.android.yandextest.fragments.GenresFragment;
import com.d954mas.android.yandextest.models.ArtistModel;

import java.util.List;

/**
 * Created by Admin on 11-12-2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    protected ArtistsFragment artistsFragment;
    protected GenresFragment genresFragment;
    private List<ArtistModel> data;

    public void setData(List<ArtistModel> data) {
        this.data = data;
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("ViewPagerAdapter","getItem: "+position);
        switch (position){
            case 0:{
                artistsFragment=new ArtistsFragment();
                artistsFragment.setData(data);
                return artistsFragment;
            }
            case 1:{
                genresFragment=new GenresFragment();
                return genresFragment;
            }
            default:return null;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object o= super.instantiateItem(container, position);
        switch (position){
            case 0:
                artistsFragment= (ArtistsFragment) o;
                artistsFragment.setData(data);
                break;
            case 1:{
                genresFragment= (GenresFragment) o;
                break;
            }
        }
        return o;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "All";
            case 1:return "Genres";
            default:return "";
        }
    }


    public ArtistsFragment getArtistsFragment() {
        return artistsFragment;
    }

    public GenresFragment getGenresFragment() {
        return genresFragment;
    }


}