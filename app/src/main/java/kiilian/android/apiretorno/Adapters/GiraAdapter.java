package kiilian.android.apiretorno.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import kiilian.android.apiretorno.R;
import kiilian.android.apiretorno.Models.Giras;

import java.util.ArrayList;

public class GiraAdapter extends ArrayAdapter<Giras>{
    private static class ViewHolder{
        TextView id;
        TextView data;
    }

    public GiraAdapter(Context context, ArrayList<Giras> gira){
        super(context, R.layout.item_gira, gira);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Giras giras = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gira, parent, false);

            viewHolder.id = (TextView) convertView.findViewById(R.id.value_gira_id);
            viewHolder.data = (TextView) convertView.findViewById(R.id.value_gira_data);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.id.setText(giras.getId());
        viewHolder.data.setText(giras.getData());

        return convertView;

    }

}
