package com.discord.widgets.guildscheduledevent;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.GuildScheduledEventListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

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
            super(C5419R.layout.guild_scheduled_event_list_item, GuildScheduledEventListAdapter.this);
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
            GuildScheduledEventListItemBinding guildScheduledEventListItemBinding = new GuildScheduledEventListItemBinding(guildScheduledEventItemView, guildScheduledEventItemView);
            Intrinsics3.checkNotNullExpressionValue(guildScheduledEventListItemBinding, "GuildScheduledEventListItemBinding.bind(itemView)");
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
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            GuildScheduledEventListItem.Event event = (GuildScheduledEventListItem.Event) data;
            this.binding.f15151b.configureInEventList(event, new GuildScheduledEventListAdapter2(this, event), new GuildScheduledEventListAdapter3(this, event), new GuildScheduledEventListAdapter4(this, event), new GuildScheduledEventListAdapter5(this, event), new GuildScheduledEventListAdapter6(this, event));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventListAdapter(RecyclerView recyclerView, Function1<? super GuildScheduledEventListItem.Event, Unit> function1, Function1<? super GuildScheduledEventListItem.Event, Unit> function12, Function1<? super GuildScheduledEventListItem.Event, Unit> function13, Function1<? super GuildScheduledEventListItem.Event, Unit> function14, Function1<? super GuildScheduledEventListItem.Event, Unit> function15) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(function1, "onRsvpClicked");
        Intrinsics3.checkNotNullParameter(function12, "onEventStartClicked");
        Intrinsics3.checkNotNullParameter(function13, "onCardClicked");
        Intrinsics3.checkNotNullParameter(function14, "onJoinClicked");
        Intrinsics3.checkNotNullParameter(function15, "onShareClicked");
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
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new EventViewHolder();
        }
        throw invalidViewTypeException(viewType);
    }
}
