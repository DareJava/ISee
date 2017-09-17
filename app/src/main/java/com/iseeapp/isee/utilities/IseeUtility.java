package com.iseeapp.isee.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.iseeapp.isee.pojo.Category;
import com.iseeapp.isee.pojo.UploadedResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dare.fatimehin on 17/04/17.
 */

public class IseeUtility {
    private static final String ISeePREF = "ISEE_PREF";
    private static final String loginKey = "login";


    public static void StoreValueInSharedPreferences(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(ISeePREF, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public static boolean isUserAlreadyLoggedIn(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(ISeePREF, 0);
        String name = preferences.getString(loginKey, "");
        return !name.equalsIgnoreCase("");
    }

    public static List prepareUploadedTestData() {
        List ff = new ArrayList();
        UploadedResource u = new UploadedResource();
        UploadedResource u2 = new UploadedResource();
        UploadedResource u3 = new UploadedResource();
        u.setTitle("Buy Panasonic tech and landlord is fake for the wasted");
        u.setDescription("The dog from the ventor has leapt over the fence and");

        u2.setTitle("Headless Chicken");
        u2.setDescription("Picture showing a chicken without the head.");

        u3.setTitle("The bad roads around benin city around uniben");
        u3.setDescription("Picture showing a chicken without the head.");
        ff.add(u); ff.add(u2); ff.add(u3);
        return ff;
    }

    public static List prepareCategoryTestData() {
        List ff = new ArrayList();
        Category c = new Category();
        c.setCategoryId(12L);
        c.setCategoryName("Lifestyle");

        Category c2 = new Category();
        c2.setCategoryId(12L);
        c2.setCategoryName("Sport");

        Category c3 = new Category();
        c3.setCategoryId(12L);
        c3.setCategoryName("Around you");

        Category c4 = new Category();
        c4.setCategoryId(12L);
        c4.setCategoryName("Religious and Non denominational");

        ff.add(c); ff.add(c2); ff.add(c3); ff.add(c4);ff.add(c);
        ff.add(c2); ff.add(c3); ff.add(c4);ff.add(c); ff.add(c2); ff.add(c3); ff.add(c4);

        return ff;
    }
}
