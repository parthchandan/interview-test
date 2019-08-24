package com.test.interview.ui.list;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.squareup.picasso.Picasso;
import com.test.interview.R;
import com.test.interview.data.model.CanadaDetails;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.RepoViewHolder>{

    private final List<CanadaDetails> data = new ArrayList<>();

    ImageListAdapter(ImageListViewModel viewModel, LifecycleOwner lifecycleOwner) {
        viewModel.getRepos().observe(lifecycleOwner, repos -> {
            data.clear();
            if (repos != null) {
                data.addAll(repos.getRows());
                notifyDataSetChanged();
            }
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_repo_list_item, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static final class RepoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_title) TextView title;
        @BindView(R.id.text_description) TextView description;
        @BindView(R.id.image_details_icon)
        ImageView imageDetailsIcon;

        RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(CanadaDetails imageItem) {
            title.setText(imageItem.title);
            description.setText(imageItem.description);
            Picasso.get().load(imageItem.getImageHref()).into(imageDetailsIcon);
        }
    }
}
