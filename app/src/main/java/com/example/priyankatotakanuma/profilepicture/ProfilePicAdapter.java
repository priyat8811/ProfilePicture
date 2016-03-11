package com.example.priyankatotakanuma.profilepicture;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfilePicAdapter extends BaseAdapter {
    private ArrayList<String> names;
    private ArrayList<Integer> imageUrls;
    Context context;
    private Dialog dialog;

    public ProfilePicAdapter(Context context, ArrayList<String> names, ArrayList<Integer> imageUrls) {
        this.names = names;
        this.imageUrls = imageUrls;
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name = (TextView) convertView.findViewById(R.id.text);
        holder.profilePic = (ImageView) convertView.findViewById(R.id.pic);

        holder.name.setText(names.get(position));
        holder.profilePic.setImageResource(imageUrls.get(position));

        holder.profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.picture_dialog);
                ImageView dialog_image = (ImageView) dialog.findViewById(R.id.profile);
                dialog.setCancelable(true);
                dialog.show();
                if (position == 0) {
                    dialog_image.setImageResource(R.drawable.industry_offerings_symbol);
                }
                if (position == 1) {
                    dialog_image.setImageResource(R.drawable.news_symbol);
                }
                if (position == 2) {
                    dialog_image.setImageResource(R.drawable.pdf_symbol);
                }
                if (position == 3) {
                    dialog_image.setImageResource(R.drawable.ic_launcher);
                }


            }
        });
        return convertView;
    }

    public static class ViewHolder {
        private TextView name;
        private ImageView profilePic;
    }
}
