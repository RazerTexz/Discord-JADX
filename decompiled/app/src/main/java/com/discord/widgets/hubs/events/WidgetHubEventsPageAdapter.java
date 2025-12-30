package com.discord.widgets.hubs.events;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetHubEventBinding;
import com.discord.databinding.WidgetHubEventsFooterBinding;
import com.discord.databinding.WidgetHubEventsHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.LoadingButton;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.hubs.events.WidgetHubEventsPageAdapter2;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubEventsPageAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageAdapter extends RecyclerView.Adapter<WidgetHubEventsPageViewHolder> {
    private final Context context;
    private final WidgetHubEventsPage3 eventListener;
    private List<? extends WidgetHubEventsPageAdapter2> items;

    public WidgetHubEventsPageAdapter(Context context, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "eventListener");
        this.context = context;
        this.eventListener = widgetHubEventsPage3;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getViewType();
    }

    public final List<WidgetHubEventsPageAdapter2> getItems() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        onBindViewHolder((WidgetHubEventsPageViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setItems(List<? extends WidgetHubEventsPageAdapter2> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(WidgetHubEventsPageViewHolder holder, int position) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (holder instanceof WidgetHubEventsPageViewHolder5) {
            ((WidgetHubEventsPageViewHolder5) holder).bind();
            return;
        }
        if (holder instanceof WidgetHubEventsPageViewHolder3) {
            WidgetHubEventsPageAdapter2 widgetHubEventsPageAdapter2 = this.items.get(position);
            Objects.requireNonNull(widgetHubEventsPageAdapter2, "null cannot be cast to non-null type com.discord.widgets.hubs.events.HubEventsPage.Footer");
            ((WidgetHubEventsPageViewHolder3) holder).bind((WidgetHubEventsPageAdapter2.Footer) widgetHubEventsPageAdapter2);
        } else if (holder instanceof WidgetHubEventsPageViewHolder2) {
            WidgetHubEventsPageAdapter2 widgetHubEventsPageAdapter22 = this.items.get(position);
            Objects.requireNonNull(widgetHubEventsPageAdapter22, "null cannot be cast to non-null type com.discord.widgets.hubs.events.HubEventsPage.Event");
            ((WidgetHubEventsPageViewHolder2) holder).bind(((WidgetHubEventsPageAdapter2.Event) widgetHubEventsPageAdapter22).getGuildScheduledEventData());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetHubEventsPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.context);
        if (viewType != 0) {
            if (viewType == 1) {
                View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.widget_hub_events_footer, parent, false);
                LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(C5419R.id.button);
                if (loadingButton == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(C5419R.id.button)));
                }
                WidgetHubEventsFooterBinding widgetHubEventsFooterBinding = new WidgetHubEventsFooterBinding((LinearLayout) viewInflate, loadingButton);
                Intrinsics3.checkNotNullExpressionValue(widgetHubEventsFooterBinding, "WidgetHubEventsFooterBin…(inflater, parent, false)");
                return new WidgetHubEventsPageViewHolder3(widgetHubEventsFooterBinding, this.eventListener);
            }
            if (viewType != 2) {
                throw new IllegalStateException(outline.m871q("Invalid view type: ", viewType));
            }
            View viewInflate2 = layoutInflaterFrom.inflate(C5419R.layout.widget_hub_event, parent, false);
            Objects.requireNonNull(viewInflate2, "rootView");
            GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) viewInflate2;
            WidgetHubEventBinding widgetHubEventBinding = new WidgetHubEventBinding(guildScheduledEventItemView, guildScheduledEventItemView);
            Intrinsics3.checkNotNullExpressionValue(widgetHubEventBinding, "WidgetHubEventBinding.in…(inflater, parent, false)");
            return new WidgetHubEventsPageViewHolder2(widgetHubEventBinding, this.eventListener);
        }
        View viewInflate3 = layoutInflaterFrom.inflate(C5419R.layout.widget_hub_events_header, parent, false);
        int i = C5419R.id.close;
        ImageView imageView = (ImageView) viewInflate3.findViewById(C5419R.id.close);
        if (imageView != null) {
            i = C5419R.id.description;
            TextView textView = (TextView) viewInflate3.findViewById(C5419R.id.description);
            if (textView != null) {
                i = C5419R.id.image;
                ImageView imageView2 = (ImageView) viewInflate3.findViewById(C5419R.id.image);
                if (imageView2 != null) {
                    i = C5419R.id.title;
                    TextView textView2 = (TextView) viewInflate3.findViewById(C5419R.id.title);
                    if (textView2 != null) {
                        WidgetHubEventsHeaderBinding widgetHubEventsHeaderBinding = new WidgetHubEventsHeaderBinding((ConstraintLayout) viewInflate3, imageView, textView, imageView2, textView2);
                        Intrinsics3.checkNotNullExpressionValue(widgetHubEventsHeaderBinding, "WidgetHubEventsHeaderBin…(inflater, parent, false)");
                        return new WidgetHubEventsPageViewHolder5(widgetHubEventsHeaderBinding, this.eventListener);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i)));
    }
}
