package com.example.lamborghiniapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lamborghiniapp.R;
import com.example.lamborghiniapp.Car;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class CollectionListAdapter extends RecyclerView.Adapter<CollectionListAdapter.ViewHolder> {
    private final int carItemLayout;
    private List<Car> carList;
    private  List<Car> allCars;
    public CollectionListAdapter(int layoutId) {
        carItemLayout = layoutId;
    }
    public void setCarList(List<Car> cars) {
        carList = cars;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return carList == null ? 0 : carList.size();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(carItemLayout, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        item.setText("\t" + carList.get(listPosition).getModelName() +" " + usFormat.format(carList.get(listPosition).getPrice()) + " " + carList.get(listPosition).getEngineType() + "\n");
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        ViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.car_row);
        }
    }
}
