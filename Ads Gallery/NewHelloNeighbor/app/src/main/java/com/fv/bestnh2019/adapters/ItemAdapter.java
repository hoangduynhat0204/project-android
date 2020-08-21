package com.fv.bestnh2019.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fv.bestnh2019.R;
import com.fv.bestnh2019.models.Item;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ElementViewHolder> {

    private List<Item> data;
    private ElementListener mElementListener;

    public ItemAdapter(List<Item> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_element, parent, false);
        return new ElementViewHolder(view);
    }

    public void setElementListener(ElementListener elementListener) {
        this.mElementListener = elementListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder elementViewHolder, int position) {
        Picasso.get().load(data.get(position).getImageResourceId()).into(elementViewHolder.mImgElement);
        elementViewHolder.mTvTitle.setText(data.get(position).getTitle());
        elementViewHolder.mTvContent.setText(data.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface ElementListener {
        void onItemClick(Item item);
    }

    class ElementViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle;
        TextView mTvContent;
        ImageView mImgElement;

        ElementViewHolder(View itemView) {
            super(itemView);
            mImgElement = itemView.findViewById(R.id.imgElement);
            mTvTitle = itemView.findViewById(R.id.tvTitle);
            mTvContent = itemView.findViewById(R.id.tvContent);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mElementListener != null) {
                        Item item = data.get(getAdapterPosition());
                        mElementListener.onItemClick(item);
                    }
                }
            });
        }
    }
}
