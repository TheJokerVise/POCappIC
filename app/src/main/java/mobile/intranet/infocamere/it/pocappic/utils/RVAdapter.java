package mobile.intranet.infocamere.it.pocappic.utils;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mobile.intranet.infocamere.it.pocappic.CardExActivity;
import mobile.intranet.infocamere.it.pocappic.PresenzeActivity;
import mobile.intranet.infocamere.it.pocappic.R;
import mobile.intranet.infocamere.it.pocappic.model.ItemUI;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemUIViewHolder> {

    List<ItemUI> items;

    public RVAdapter(List<ItemUI> items) {
        this.items = items;
    }

    public static class ItemUIViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        CardView cv;
        LinearLayout linearCont;
        TextView header;
        TextView titleSection;
        TextView subtitleSection;
        ImageView imgSection;

        ItemUIViewHolder (View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_ui);
            linearCont = (LinearLayout) itemView.findViewById(R.id.linear_cont);
            header = (TextView) itemView.findViewById(R.id.txt_header);
            titleSection = (TextView) itemView.findViewById(R.id.txt_titleSection);
            subtitleSection = (TextView) itemView.findViewById(R.id.txt_subsection);
            imgSection = (ImageView) itemView.findViewById(R.id.img_section);
        }

        @Override
        public void onClick(View view) {
            Log.i("ITEMUIVIEWHOLDER", "click");
        }
    }

    @NonNull
    @Override
    public ItemUIViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = (View) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_ui, parent, false);

        ItemUIViewHolder itemuivvh = new ItemUIViewHolder(v);

        return itemuivvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemUIViewHolder holder, int position) {
        holder.header.setText(items.get(position).getHeaderTitle());
        holder.titleSection.setText(items.get(position).getTitle());
        holder.subtitleSection.setText(items.get(position).getSubtitle());
        if (items.get(position).getBkg_image().contains("tempo")) {
            holder.imgSection.setBackgroundResource(R.drawable.tempo2);
        }
        else {
            holder.imgSection.setBackgroundResource(R.drawable.trasferte);
        }
        holder.linearCont.setBackgroundColor(Color.parseColor(items.get(position).getBkg_color()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {

                    case 0:
                        Intent presenze = new Intent(v.getContext(), PresenzeActivity.class);
                        v.getContext().startActivity(presenze);

                        break;

                    case 1:
                        Intent trasferte = new Intent(v.getContext(), CardExActivity.class);
                        v.getContext().startActivity(trasferte);

                        break;

                    default:
                        Toast.makeText(
                                v.getContext(),
                                "Position: " + position,
                                Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}