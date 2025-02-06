package it.keybeeproject.keybee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import it.keybeeproject.keybee.R;

public class PopUpAdapter  extends RecyclerView.Adapter<PopUpAdapter.ViewHolder> {
    Context con;
    ArrayList<String> listdata;


    public PopUpAdapter(Context con, ArrayList<String> listdata) {
        this.con=con;
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.popup_iteam, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        System.out.println(listdata.get(position)+"===position==="+position);
        holder.text1.setText(listdata.get(position));
        holder.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //moveup(holder.getAdapterPosition());
                moveup(position);
            }
        });
        holder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //movedown(holder.getAdapterPosition());
                movedown(position);
            }
        });
    }

    private void moveup(int position) {
        int currentpos=position;
        if(position>0){
           /* listdata.remove(currentpos);
            listdata.add(currentpos - 1, listdata.get(currentpos - 1));*/
            Collections.swap(listdata, position, position - 1);
            notifyItemMoved(position, position - 1);
            notifyItemChanged(position);
            notifyItemChanged(position - 1);
        }


    }

    private void movedown(int position) {
        int currentpos=position;
        if(currentpos<listdata.size()-1){
                /*listdata.remove(currentpos);
                listdata.add(currentpos + 1, listdata.get(currentpos+1));*/
            Collections.swap(listdata, position, position + 1);
            notifyItemMoved(currentpos, currentpos + 1);
            notifyItemChanged(position);
            notifyItemChanged(position + 1);
        }

    }



    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public void setList(ArrayList datalist) {
        //listdata.clear();
        System.out.println("listdata===="+listdata.get(0));
        System.out.println("datalist===="+datalist.get(0));
        listdata=datalist;
        System.out.println("datalist===="+listdata.get(0));
    }

    public ArrayList<String> getList() {
        return listdata;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView up,down;
        public TextView text1;
        public ViewHolder(View itemView) {
            super(itemView);
            this.up = (ImageView) itemView.findViewById(R.id.up);
            this.down = (ImageView) itemView.findViewById(R.id.down);
            this.text1 = (TextView) itemView.findViewById(R.id.text1);
        }
    }
}
