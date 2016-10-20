package hu.bme.aut.weatherinfo.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.weatherinfo.R;

/**
 * Created by mobsoft on 2016. 10. 20..
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private final List<String> cities;
    private OnCitySelectedListener listener;

    public CityAdapter(OnCitySelectedListener listener) {
        this.listener = listener;
        cities = new ArrayList<>();
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        CityViewHolder viewHolder = new CityViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.position = position;
        holder.nameTextView.setText(cities.get(position));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public void addCity(String newCity) {
        cities.add(newCity);
        notifyItemInserted(cities.size() - 1);
    }

    public void removeCity(int position) {
        cities.remove(position);
        notifyItemRemoved(position);
        if (position < cities.size()) {
            notifyItemRangeChanged(position, cities.size() - position);
        }
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {

        int position;

        TextView nameTextView;
        Button removeButton;

        public CityViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.CityItemNameTextView);
            removeButton = (Button) itemView.findViewById(R.id.CityItemRemoveButton);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onCitySelected(cities.get(position));
                    }
                }
            });
        }
    }
}