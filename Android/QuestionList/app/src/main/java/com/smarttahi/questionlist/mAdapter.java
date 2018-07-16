package com.smarttahi.questionlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.smarttahi.questionlist.R;
import com.smarttahi.questionlist.tools.Data.*;

import java.util.ArrayList;

public class mAdapter extends RecyclerView.Adapter<mViewHolder> {
    private ArrayList<Question> question;

    public mAdapter(ArrayList<Question> q) {
        question = q;
    }


    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new mViewHolder(view,0);

       /* View view;
        if (getItemViewType(viewType) == mViewHolder.FOOTER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_header, parent, false);
            return new mViewHolder(view, mViewHolder.FOOTER);
        } else if (getItemViewType(viewType) == mViewHolder.FOOTER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_footer, parent, false);
            return new mViewHolder(view, mViewHolder.FOOTER);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
            return new mViewHolder(view, mViewHolder.CENTER);
        }*/
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        Question q = question.get(position);
        holder.id.setText(q.getNickname());
        holder.description.setText(q.getDescription());
        holder.time.setText(q.getCreated_at());
        holder.integral.setText(String.valueOf(q.getReward()));
        holder.kind.setText(q.getKind());
//       holder.head.setImageBitmap(Bitmap.createBitmap(BitmapFactory.decodeByteArray(q.getPhoto_thumbnail_src())));
        holder.title.setText(q.getTitle());
    }

    @Override
    public int getItemCount() {
        return question.size();
    }


    public void refreshItem(ArrayList<Question> Q) {
        question.clear();
        question=Q;
        notifyDataSetChanged();
    }
}


class mViewHolder extends RecyclerView.ViewHolder {
    public static final int HEADER = -1;
    public static final int FOOTER = 1;
    public static final int CENTER = 0;
    public TextView description;
    public TextView id;
    //    public ImageView head;
    public TextView time;
    public TextView kind;
    public TextView integral;
    public TextView title;

    public ProgressBar footer;
    public ProgressBar header;


    mViewHolder(View itemView, int type) {
        super(itemView);
        if (type == CENTER) {
            id = itemView.findViewById(R.id.question_idName);
//        head = itemView.findViewById(R.id.question_mine_head);
            description = itemView.findViewById(R.id.question_item_detail);
            kind = itemView.findViewById(R.id.question_item_kind);
            time = itemView.findViewById(R.id.question_time);
            integral = itemView.findViewById(R.id.question_item_pay);
            title = itemView.findViewById(R.id.question_item_title);
        } else if (type == HEADER) {
            header = itemView.findViewById(R.id.header);
        } else {
            footer = itemView.findViewById(R.id.footer);
        }
    }
}
