package com.nsky.app.home.viewmodel;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nsky.app.R;
import com.nsky.app.home.model.FeatureBlock;
import com.nsky.kit.arch.FragmentContainerActivity;

/** Creates the UI for a single item in the catalog table of contents. */
class TocViewHolder extends RecyclerView.ViewHolder {

  private static final String FRAGMENT_CONTENT = "fragment_content";

  private final TextView titleView;
  private final ImageView imageView;
  private final TextView statusWipLabelView;

  private FragmentActivity activity;
  private FeatureBlock featureBlock;

  TocViewHolder(FragmentActivity activity, ViewGroup viewGroup) {
    super(
        LayoutInflater.from(activity)
            .inflate(R.layout.cat_toc_item, viewGroup, false /* attachToRoot */));

    titleView = itemView.findViewById(R.id.cat_toc_title);
    imageView = itemView.findViewById(R.id.cat_toc_image);
    statusWipLabelView = itemView.findViewById(R.id.cat_toc_status_wip_label);
  }

  void bind(FragmentActivity activity, FeatureBlock featureBlock) {
    this.activity = activity;
    this.featureBlock = featureBlock;

    titleView.setText(featureBlock.getTitleResId());
    imageView.setImageResource(featureBlock.getDrawableResId());
    itemView.setOnClickListener(clickListener);
    statusWipLabelView.setVisibility(
        featureBlock.getStatus() == FeatureBlock.STATUS_WIP ? View.VISIBLE : View.GONE);
  }

  private final OnClickListener clickListener =
      new OnClickListener() {
        @Override
        public void onClick(View v) {
//          FeatureBlockUtils.startFragment(activity, featureBlock.createFragment(), FRAGMENT_CONTENT);
          FragmentContainerActivity.Companion.launch(activity, featureBlock.getFragmentClass());
        }
      };
}
