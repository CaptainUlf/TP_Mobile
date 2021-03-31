package com.example.tp4.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tp4.R;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NatureFragment.newInstance(0, mContext.getString(R.string.titre_section0));
            case 1:
                return NatureFragment.newInstance(1, mContext.getString(R.string.titre_section1));
            case 2:
                return NatureFragment.newInstance(2, mContext.getString(R.string.titre_section2));
            case 3:
                return NatureFragment.newInstance(3, mContext.getString(R.string.titre_section3));
            case 4:
                return NatureFragment.newInstance(4, mContext.getString(R.string.titre_section4));
        }
        return null;
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return mContext.getString(R.string.titre_section0).toUpperCase(l);
            case 1:
                return mContext.getString(R.string.titre_section1).toUpperCase(l);
            case 2:
                return mContext.getString(R.string.titre_section2).toUpperCase(l);
            case 3:
                return mContext.getString(R.string.titre_section3).toUpperCase(l);
            case 4:
                return mContext.getString(R.string.titre_section4).toUpperCase(l);
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}