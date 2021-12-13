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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class adapter extends ArrayAdapter<model> {
    private Context context;
    private List<model> modelList;
    private List<model> modelListFiltered;

    public adapter( Context context, List<model> modelList) {
        super(context,R.layout.list_item,modelList );
        this.context=context;
        this.modelList=modelList;
        this.modelListFiltered=modelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null,true);
        TextView country= view.findViewById(R.id.countryName);
        ImageView imageView= view.findViewById(R.id.flag);

        country.setText(modelListFiltered.get(position).getCountries());

        Glide.with(context).load(modelListFiltered.get(position).getFlag()).into(imageView);


        return view;
    }

    @Override
    public int getCount() {
        return modelListFiltered.size();
    }

    @Nullable
    @Override
    public model getItem(int position) {
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
                FilterResults filterResults= new FilterResults();

                if (constraint==null || constraint.length()==0){
                    filterResults.count=modelList.size();
                    filterResults.values=modelList;
                }else {
                    List<model> list= new ArrayList<>();
                    String searchR = constraint.toString().toLowerCase();

                    for (model item:modelList){
                        if(item.getCountries().toLowerCase().contains(searchR)){
                            list.add(item);
                        }

                        filterResults.count=list.size();
                        filterResults.values=list;
                    }
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                  modelListFiltered= (List<model>) results.values;
                  countries.countryList=(List<model>)results.values;
                  notifyDataSetChanged();
            }
        };

        return filter;
    }
}
