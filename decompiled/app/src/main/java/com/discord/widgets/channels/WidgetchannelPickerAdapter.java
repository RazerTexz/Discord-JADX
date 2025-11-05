package com.discord.widgets.channels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.channels.ChannelPickerAdapterItem;
import com.discord.widgets.channels.ChannelPickerViewHolder;
import d0.t.n;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChannelPickerAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetchannelPickerAdapter extends RecyclerView.Adapter<ChannelPickerViewHolder> {
    private static final int VIEW_TYPE_CHANNEL_ITEM = 1;
    private static final int VIEW_TYPE_CREATE_CHANNEL = 0;
    private final DiffCreator<List<ChannelPickerAdapterItem>, ChannelPickerViewHolder> diffCreator;
    private List<? extends ChannelPickerAdapterItem> items;
    private final OnItemClickListener listener;

    /* compiled from: WidgetChannelPickerAdapter.kt */
    public interface OnItemClickListener {
        void onChannelItemClick(ChannelPickerAdapterItem.ChannelItem channelItem);

        void onCreateChannelClick();
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    /* renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$onCreateViewHolder$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function0<Unit> {
        public AnonymousClass1(OnItemClickListener onItemClickListener) {
            super(0, onItemClickListener, OnItemClickListener.class, "onCreateChannelClick", "onCreateChannelClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((OnItemClickListener) this.receiver).onCreateChannelClick();
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    /* renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$onCreateViewHolder$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<ChannelPickerAdapterItem.ChannelItem, Unit> {
        public AnonymousClass2(OnItemClickListener onItemClickListener) {
            super(1, onItemClickListener, OnItemClickListener.class, "onChannelItemClick", "onChannelItemClick(Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelPickerAdapterItem.ChannelItem channelItem) {
            invoke2(channelItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelPickerAdapterItem.ChannelItem channelItem) {
            m.checkNotNullParameter(channelItem, "p1");
            ((OnItemClickListener) this.receiver).onChannelItemClick(channelItem);
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    /* renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<? extends ChannelPickerAdapterItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChannelPickerAdapterItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ChannelPickerAdapterItem> list) {
            m.checkNotNullParameter(list, "items");
            WidgetchannelPickerAdapter.access$setItems$p(WidgetchannelPickerAdapter.this, list);
        }
    }

    public /* synthetic */ WidgetchannelPickerAdapter(OnItemClickListener onItemClickListener, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(onItemClickListener, appComponent, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(WidgetchannelPickerAdapter widgetchannelPickerAdapter) {
        return widgetchannelPickerAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(WidgetchannelPickerAdapter widgetchannelPickerAdapter, List list) {
        widgetchannelPickerAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ChannelPickerAdapterItem channelPickerAdapterItem = this.items.get(position);
        if (channelPickerAdapterItem instanceof ChannelPickerAdapterItem.CreateChannelItem) {
            return 0;
        }
        if (channelPickerAdapterItem instanceof ChannelPickerAdapterItem.ChannelItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ChannelPickerViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends ChannelPickerAdapterItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    public WidgetchannelPickerAdapter(OnItemClickListener onItemClickListener, AppComponent appComponent, DiffCreator<List<ChannelPickerAdapterItem>, ChannelPickerViewHolder> diffCreator) {
        m.checkNotNullParameter(onItemClickListener, "listener");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.listener = onItemClickListener;
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(ChannelPickerViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        if (holder instanceof ChannelPickerViewHolder.ChannelItemViewHolder) {
            ((ChannelPickerViewHolder.ChannelItemViewHolder) holder).configure(this.items.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ChannelPickerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_guild_role_subscription_channel_item, parent, false);
        int i = R.id.channel_item_name;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channel_item_name);
        if (textView != null) {
            i = R.id.channel_item_selected;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.channel_item_selected);
            if (imageView != null) {
                i = R.id.channel_item_type_icon;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.channel_item_type_icon);
                if (imageView2 != null) {
                    ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding = new ViewGuildRoleSubscriptionChannelItemBinding((LinearLayout) viewInflate, textView, imageView, imageView2);
                    m.checkNotNullExpressionValue(viewGuildRoleSubscriptionChannelItemBinding, "ViewGuildRoleSubscriptio…rent,\n        false\n    )");
                    if (viewType == 0) {
                        return new ChannelPickerViewHolder.CreateChannelViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new AnonymousClass1(this.listener));
                    }
                    if (viewType == 1) {
                        return new ChannelPickerViewHolder.ChannelItemViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new AnonymousClass2(this.listener));
                    }
                    Context context = parent.getContext();
                    m.checkNotNullExpressionValue(context, "parent.context");
                    throw new IllegalArgumentException(b.h(context, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, null, 4).toString());
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
