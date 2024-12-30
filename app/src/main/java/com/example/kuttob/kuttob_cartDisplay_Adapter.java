package com.example.kuttob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class kuttob_cartDisplay_Adapter extends RecyclerView.Adapter<kuttob_cartDisplay_Adapter.ViewHolder> {

    private Context context;
    private List<kuttob_cart_display> kuttob_cart_displayList;

    public kuttob_cartDisplay_Adapter(Context context, List<kuttob_cart_display> cart_displays) {
        this.context = context;
        this.kuttob_cart_displayList = cart_displays;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.kuttob_layout_order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        kuttob_cart_display cart_display = kuttob_cart_displayList.get(position);
        holder.book_name.setText(cart_display.getBook_Name());
        holder.price.setText(cart_display.getPrice());
    }

    @Override
    public int getItemCount() {
        return kuttob_cart_displayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView book_name;
        private TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            book_name = itemView.findViewById(R.id.book_name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
