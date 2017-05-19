package raj.io.verticalandhoritzontalscrollandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import raj.io.verticalandhoritzontalscrollandroid.R;
import raj.io.verticalandhoritzontalscrollandroid.model.HorizontalScrollItemModel;


/**
 * Created by vraj0 on 19-May-17.
 */

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {


    private List<HorizontalScrollItemModel> list;
    Context context;
    LayoutInflater layoutInflater;

    public HorizontalRecyclerViewAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.layout_horizontal_scroll_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        HorizontalScrollItemModel item = list.get(position);
        holder.title.setText(item.getTitle());
        holder.rating.setText(item.getRating() + "");
        if (item.isFree())
            holder.free.setText("Free");
        else
            holder.free.setText("Paid");
        holder.color.setBackgroundColor(item.getColor());
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public void update(List<HorizontalScrollItemModel> list) {
        this.list.clear();
        if (list != null)
            this.list.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView color;
        TextView title, rating, free;

        public ViewHolder(View v) {
            super(v);

            color = (ImageView) v.findViewById(R.id.color);
            title = (TextView) v.findViewById(R.id.title);
            rating = (TextView) v.findViewById(R.id.rating);
            free = (TextView) v.findViewById(R.id.free);
        }
    }
}
