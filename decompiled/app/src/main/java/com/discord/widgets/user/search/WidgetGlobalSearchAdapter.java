package com.discord.widgets.user.search;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSearchItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: WidgetGlobalSearchAdapter.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter extends MGRecyclerAdapterSimple<WidgetGlobalSearchModel.ItemDataPayload> {
    private Function4<? super View, ? super Integer, ? super WidgetGlobalSearchModel.ItemDataPayload, ? super Boolean, Unit> onSelectedListener;

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    public static final class ChannelViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            m.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure(i, itemDataPayload);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemChannel) data);
        }
    }

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    public static final class GuildViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            m.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure(i, itemDataPayload);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemGuild) data);
        }
    }

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> {
        private final WidgetChannelSearchItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(R.layout.widget_channel_search_item_header, widgetGlobalSearchAdapter);
            m.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetChannelSearchItemHeaderBinding widgetChannelSearchItemHeaderBinding = new WidgetChannelSearchItemHeaderBinding(textView, textView);
            m.checkNotNullExpressionValue(widgetChannelSearchItemHeaderBinding, "WidgetChannelSearchItemH…derBinding.bind(itemView)");
            this.binding = widgetChannelSearchItemHeaderBinding;
        }

        public static final /* synthetic */ WidgetGlobalSearchAdapter access$getAdapter$p(HeaderViewHolder headerViewHolder) {
            return (WidgetGlobalSearchAdapter) headerViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure2(i, itemDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.f2266b.setText(((WidgetGlobalSearchModel.ItemHeader) data).getName());
            this.binding.a.setOnClickListener(new WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$1(this, position, data));
            TextView textView = this.binding.a;
            m.checkNotNullExpressionValue(textView, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(textView, new WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$2(this, position, data));
        }
    }

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    public static abstract class SearchViewHolder extends MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> {
        private final ViewGlobalSearchItem viewGlobalSearchItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(R.layout.widget_channel_search_item, widgetGlobalSearchAdapter);
            m.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type com.discord.widgets.user.search.ViewGlobalSearchItem");
            ViewGlobalSearchItem viewGlobalSearchItem = (ViewGlobalSearchItem) view;
            viewGlobalSearchItem.setSelected(true);
            this.viewGlobalSearchItem = viewGlobalSearchItem;
        }

        public static final /* synthetic */ WidgetGlobalSearchAdapter access$getAdapter$p(SearchViewHolder searchViewHolder) {
            return (WidgetGlobalSearchAdapter) searchViewHolder.adapter;
        }

        public final ViewGlobalSearchItem getViewGlobalSearchItem() {
            return this.viewGlobalSearchItem;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure(i, itemDataPayload);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.itemView.setOnClickListener(new WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$1(this, position, data));
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$2(this, position, data));
        }
    }

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    public static final class UserViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            m.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure(i, itemDataPayload);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemUser) data);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onSelectedListener = WidgetGlobalSearchAdapter$onSelectedListener$1.INSTANCE;
    }

    public final Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> getOnSelectedListener() {
        return this.onSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnSelectedListener(Function4<? super View, ? super Integer, ? super WidgetGlobalSearchModel.ItemDataPayload, ? super Boolean, Unit> function4) {
        m.checkNotNullParameter(function4, "<set-?>");
        this.onSelectedListener = function4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == -1) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 0) {
            return new ChannelViewHolder(this);
        }
        if (viewType == 1) {
            return new UserViewHolder(this);
        }
        if (viewType == 2) {
            return new GuildViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
