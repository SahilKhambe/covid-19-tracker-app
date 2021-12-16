package com.example.covid_19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<Model> {

    private Context context;
    private List<Model> modelList;
    private List<Model> modelListFiltered;

    public MyCustomAdapter(Context context, List<Model> modelList) {
        super(context, R.layout.list_custom_item, modelList);

        this.context = context;
        this.modelList = modelList;
        this.modelListFiltered = modelList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item, null, true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imgView = view.findViewById(R.id.img_flag);

        tvCountryName.setText(modelListFiltered.get(position).getCountry());
        Glide.with(context).load(modelListFiltered.get(position).getFlag()).into(imgView);

        return view;
    }

    @Override
    public int getCount() {

        return modelListFiltered.size();
    }

    @Nullable
    @Override
    public Model getItem(int position) {

        return modelListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){

                    filterResults.count = modelList.size();
                    filterResults.values = modelList;

                }else {

                    List<Model> resultModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(Model itemModel:modelList){

                        if(itemModel.getCountry().toLowerCase().contains(searchStr)){

                            resultModel.add(itemModel);

                        }

                        filterResults.count = resultModel.size();
                        filterResults.values = resultModel;

                    }

                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                modelListFiltered = (List<Model>) results.values;
                AffectedCountries.modelList = (List<Model>) results.values;
                notifyDataSetChanged();

            }
        };

        return filter;
    }
}
