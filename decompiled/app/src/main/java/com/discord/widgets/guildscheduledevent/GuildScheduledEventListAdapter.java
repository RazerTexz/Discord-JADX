package com.discord.widgets.guildscheduledevent;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.GuildScheduledEventListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventListAdapter.kt */
/* loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter extends MGRecyclerAdapterSimple<GuildScheduledEventListItem> {
    private final Function1<GuildScheduledEventListItem.Event, Unit> onCardClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onEventStartClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onJoinClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onRsvpClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onShareClicked;

    /* compiled from: GuildScheduledEventListAdapter.kt */
    public final class EventViewHolder extends MGRecyclerViewHolder<GuildScheduledEventListAdapter, GuildScheduledEventListItem> {
        private final GuildScheduledEventListItemBinding binding;

        public EventViewHolder() {
            super(R.layout.guild_scheduled_event_list_item, GuildScheduledEventListAdapter.this);
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
            GuildScheduledEventListItemBinding guildScheduledEventListItemBinding = new GuildScheduledEventListItemBinding(guildScheduledEventItemView, guildScheduledEventItemView);
            m.checkNotNullExpressionValue(guildScheduledEventListItemBinding, "GuildScheduledEventListItemBinding.bind(itemView)");
            this.binding = guildScheduledEventListItemBinding;
        }

        public static final /* synthetic */ GuildScheduledEventListAdapter access$getAdapter$p(EventViewHolder eventViewHolder) {
            return (GuildScheduledEventListAdapter) eventViewHolder.adapter;
        }

        public final GuildScheduledEventListItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, GuildScheduledEventListItem guildScheduledEventListItem) throws Resources.NotFoundException {
            onConfigure2(i, guildScheduledEventListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, GuildScheduledEventListItem data) throws Resources.NotFoundException {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            GuildScheduledEventListItem.Event event = (GuildScheduledEventListItem.Event) data;
            this.binding.f2121b.configureInEventList(event, new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$1(this, event), new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$2(this, event), new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$3(this, event), new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$4(this, event), new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$5(this, event));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventListAdapter(RecyclerView recyclerView, Function1<? super GuildScheduledEventListItem.Event, Unit> function1, Function1<? super GuildScheduledEventListItem.Event, Unit> function12, Function1<? super GuildScheduledEventListItem.Event, Unit> function13, Function1<? super GuildScheduledEventListItem.Event, Unit> function14, Function1<? super GuildScheduledEventListItem.Event, Unit> function15) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(function1, "onRsvpClicked");
        m.checkNotNullParameter(function12, "onEventStartClicked");
        m.checkNotNullParameter(function13, "onCardClicked");
        m.checkNotNullParameter(function14, "onJoinClicked");
        m.checkNotNullParameter(function15, "onShareClicked");
        this.onRsvpClicked = function1;
        this.onEventStartClicked = function12;
        this.onCardClicked = function13;
        this.onJoinClicked = function14;
        this.onShareClicked = function15;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnCardClicked() {
        return this.onCardClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnEventStartClicked() {
        return this.onEventStartClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnJoinClicked() {
        return this.onJoinClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnRsvpClicked() {
        return this.onRsvpClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnShareClicked() {
        return this.onShareClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, GuildScheduledEventListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new EventViewHolder();
        }
        throw invalidViewTypeException(viewType);
    }
}
