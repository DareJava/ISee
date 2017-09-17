package com.iseeapp.isee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.iseeapp.isee.R;
import com.iseeapp.isee.pojo.Category;
import com.iseeapp.isee.pojo.Comment;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {
    private final Context context;
    private final List<Category> values;
    private TextView categoryName;
    private CheckBox categoryCheck;

    public CategoryAdapter(Context context, List<Category> values) {
        super(context, R.layout.activity_categories, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_categories, parent, false);
        categoryName = (TextView) rowView.findViewById(R.id.categoryType);
        categoryCheck = (CheckBox) rowView.findViewById(R.id.categoryChk);


        Category category = values.get(position);
        categoryName.setText(category.getCategoryName());

        return rowView;
    }
}