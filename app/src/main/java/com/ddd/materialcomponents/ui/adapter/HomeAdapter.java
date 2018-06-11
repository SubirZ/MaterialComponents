package com.ddd.materialcomponents.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddd.materialcomponents.R;
import com.ddd.materialcomponents.databinding.RowHomeBinding;
import com.ddd.materialcomponents.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.C. on 22/05/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.GenreHolder> {
    private Context context;
    private List<HomeModel> homeList = new ArrayList<>();
    private LayoutInflater inflater;
    private OnClickListener listener;

    public HomeAdapter(Context context, List<HomeModel> arrayList, OnClickListener listener) {
        this.context = context;
        this.homeList = arrayList;
        this.listener = listener;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public GenreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GenreHolder((RowHomeBinding) DataBindingUtil.inflate(inflater, R.layout.row_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final GenreHolder holder, final int position) {
        holder.binding.tvProperty.setText(homeList.get(position).getPropertyName());
        holder.binding.ivProperty.setImageResource(homeList.get(position).getImage());
        holder.binding.cvParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    class GenreHolder extends RecyclerView.ViewHolder {
        private RowHomeBinding binding;

        public GenreHolder(RowHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnClickListener {

        void onClick(int position);
    }
}
