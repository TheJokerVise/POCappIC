package mobile.intranet.infocamere.it.pocappic.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobile.intranet.infocamere.it.pocappic.R;
import mobile.intranet.infocamere.it.pocappic.model.ItemUI;

public class ItemUIAdapter extends RecyclerView.Adapter {

    List<ItemUI> models;

    public ItemUIAdapter(List<ItemUI> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(
                parent.getContext()).inflate(viewType, parent, false);
        return new ItemUIHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemUIHolder) holder).bindData(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.fragment_itemui;
    }
}
