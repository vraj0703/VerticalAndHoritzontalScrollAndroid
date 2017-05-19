package raj.io.verticalandhoritzontalscrollandroid.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import raj.io.verticalandhoritzontalscrollandroid.R;
import raj.io.verticalandhoritzontalscrollandroid.model.VerticalScrollItemModel;


/**
 * Created by vraj0 on 18-May-17.
 */

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.ViewHolder> {

    private List<VerticalScrollItemModel> list;
    Context context;
    LayoutInflater layoutInflater;

    public VerticalRecyclerViewAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.layout_vertical_scroll_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());

        HorizontalRecyclerViewAdapter adapter = new HorizontalRecyclerViewAdapter(context);
        holder.horizontalList.setAdapter(adapter);
        holder.horizontalList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        adapter.update(list.get(position).getList());

    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public void update(List<VerticalScrollItemModel> list) {
        this.list.clear();
        if (list != null){
            this.list.addAll(list);}
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView horizontalList;
        TextView title;

        public ViewHolder(View v) {
            super(v);
            horizontalList = (RecyclerView) v.findViewById(R.id.list);
            title = (TextView) v.findViewById(R.id.title);
        }
    }

}
