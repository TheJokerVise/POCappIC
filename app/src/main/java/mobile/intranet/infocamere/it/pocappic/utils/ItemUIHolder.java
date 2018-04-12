package mobile.intranet.infocamere.it.pocappic.utils;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.text.Line;

import mobile.intranet.infocamere.it.pocappic.R;
import mobile.intranet.infocamere.it.pocappic.model.ItemUI;

public class ItemUIHolder extends RecyclerView.ViewHolder {

    private CardView cv;
    private LinearLayout ll;
    private TextView tv_header;
    private TextView tv_title;
    private TextView tv_subtitle;
    private ImageView iv_imgSection;

    public ItemUIHolder(View itemView) {
        super(itemView);

        cv = (CardView) itemView.findViewById(R.id.card_id);
        ll = (LinearLayout) itemView.findViewById(R.id.containerSectionLinear);
        tv_header = (TextView) itemView.findViewById(R.id.txt_header);
        tv_title = (TextView) itemView.findViewById(R.id.txt_title);
        tv_subtitle = (TextView) itemView.findViewById(R.id.txt_subtitle);
        iv_imgSection = (ImageView) itemView.findViewById(R.id.iv_imgSection);
    }

    public void bindData(final ItemUI itemUImodel) {
        cv.setCardBackgroundColor(Color.parseColor(itemUImodel.getBkg_color()));
        ll.setBackgroundColor(Color.parseColor(itemUImodel.getBkg_color()));
        tv_header.setText(itemUImodel.getHeaderTitle());
        tv_title.setText(itemUImodel.getTitle());
        tv_subtitle.setText(itemUImodel.getSubtitle());
        iv_imgSection.setBackgroundResource(R.drawable.trasferte);
    }

}
