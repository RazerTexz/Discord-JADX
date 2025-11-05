package com.discord.widgets.user.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import com.discord.R;
import com.discord.databinding.WidgetGlobalSearchItemGuildBinding;
import com.discord.databinding.WidgetGuildsListItemDmBinding;
import com.discord.databinding.WidgetGuildsListItemGuildBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter extends MGRecyclerAdapterSimple<WidgetGlobalSearchGuildsModel.Item> {
    private Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> onClickListener;
    private Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> onLongClickListener;
    private final int overlayColor;

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static abstract class Item extends MGRecyclerViewHolder<WidgetGlobalSearchGuildsAdapter, WidgetGlobalSearchGuildsModel.Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(@LayoutRes int i, WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter) {
            super(i, widgetGlobalSearchGuildsAdapter);
            m.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        }

        public static final /* synthetic */ WidgetGlobalSearchGuildsAdapter access$getAdapter$p(Item item) {
            return (WidgetGlobalSearchGuildsAdapter) item.adapter;
        }

        public final void configureMentionsCount(TextView textView, int count) {
            m.checkNotNullParameter(textView, "textView");
            if (count < 1) {
                ViewExtensions.setTextAndVisibilityBy(textView, null);
                textView.setContentDescription(null);
                return;
            }
            textView.setVisibility(0);
            textView.setText(String.valueOf(count));
            Context context = textView.getContext();
            m.checkNotNullExpressionValue(context, "context");
            textView.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.overlay_guild_mentions_primary_630, 0, 2, (Object) null));
            textView.setContentDescription(b.h(context, R.string.mentions_count, new Object[]{String.valueOf(count)}, null, 4));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetGlobalSearchGuildsModel.Item data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.itemView.setOnClickListener(new WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1(this, position, data));
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchGuildsAdapter$Item$onConfigure$2(this, position, data));
        }
    }

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static final class ItemDirectMessage extends Item {
        private final WidgetGuildsListItemDmBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemDirectMessage(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
            super(i, widgetGlobalSearchGuildsAdapter);
            m.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
            WidgetGuildsListItemDmBinding widgetGuildsListItemDmBindingA = WidgetGuildsListItemDmBinding.a(this.itemView);
            m.checkNotNullExpressionValue(widgetGuildsListItemDmBindingA, "WidgetGuildsListItemDmBinding.bind(itemView)");
            this.binding = widgetGuildsListItemDmBindingA;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel.Item item) {
            onConfigure(i, item);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item
        public void onConfigure(int position, WidgetGlobalSearchGuildsModel.Item data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure2(position, data);
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.guildsItemDmCount");
            configureMentionsCount(textView, data.getMentionCount());
            SimpleDraweeView simpleDraweeView = this.binding.f2459b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildsItemDmAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getChannel(), R.dimen.avatar_size_large, (MGImages.ChangeDetector) null, 8, (Object) null);
        }
    }

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static final class ItemDivider extends Item {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemDivider(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
            super(i, widgetGlobalSearchGuildsAdapter);
            m.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        }
    }

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static final class ItemGuild extends Item {
        private final WidgetGlobalSearchItemGuildBinding binding;
        private final WidgetGuildsListItemGuildBinding bindingGuild;
        private final int overlayColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGuild(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i, @ColorInt int i2) {
            super(i, widgetGlobalSearchGuildsAdapter);
            m.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
            this.overlayColor = i2;
            View view = this.itemView;
            int i3 = R.id.guilds_item_selected;
            ImageView imageView = (ImageView) view.findViewById(R.id.guilds_item_selected);
            if (imageView != null) {
                i3 = R.id.guilds_item_unread;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.guilds_item_unread);
                if (imageView2 != null) {
                    WidgetGlobalSearchItemGuildBinding widgetGlobalSearchItemGuildBinding = new WidgetGlobalSearchItemGuildBinding((RelativeLayout) view, imageView, imageView2);
                    m.checkNotNullExpressionValue(widgetGlobalSearchItemGuildBinding, "WidgetGlobalSearchItemGuildBinding.bind(itemView)");
                    this.binding = widgetGlobalSearchItemGuildBinding;
                    WidgetGuildsListItemGuildBinding widgetGuildsListItemGuildBindingA = WidgetGuildsListItemGuildBinding.a(this.itemView);
                    m.checkNotNullExpressionValue(widgetGuildsListItemGuildBindingA, "WidgetGuildsListItemGuildBinding.bind(itemView)");
                    this.bindingGuild = widgetGuildsListItemGuildBindingA;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel.Item item) {
            onConfigure(i, item);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item
        public void onConfigure(int position, WidgetGlobalSearchGuildsModel.Item data) {
            Guild guild;
            m.checkNotNullParameter(data, "data");
            super.onConfigure2(position, data);
            Guild guild2 = data.getGuild();
            boolean z2 = guild2 != null && guild2.hasIcon();
            SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            boolean zIsSelected = data.isSelected();
            Guild guild3 = data.getGuild();
            Integer numValueOf = Integer.valueOf(this.overlayColor);
            m.checkNotNullExpressionValue(this.bindingGuild.d, "bindingGuild.guildsItemAvatar");
            SimpleDraweeViewExtensionsKt.setGuildIcon$default(simpleDraweeView, zIsSelected, guild3, r8.getResources().getDimensionPixelSize(R.dimen.guild_icon_radius), null, numValueOf, null, null, false, null, 488, null);
            TextView textView = this.bindingGuild.e;
            m.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
            String shortName = null;
            if (!z2 && (guild = data.getGuild()) != null) {
                shortName = guild.getShortName();
            }
            textView.setText(shortName);
            TextView textView2 = this.bindingGuild.h;
            m.checkNotNullExpressionValue(textView2, "bindingGuild.guildsItemMentions");
            configureMentionsCount(textView2, data.getMentionCount());
            ImageView imageView = this.bindingGuild.i;
            m.checkNotNullExpressionValue(imageView, "bindingGuild.guildsItemVoice");
            imageView.setVisibility(data.getConnectedToVoice() ? 0 : 8);
            ImageView imageView2 = this.binding.c;
            m.checkNotNullExpressionValue(imageView2, "binding.guildsItemUnread");
            imageView2.setVisibility(data.isUnread() ? 0 : 8);
            ImageView imageView3 = this.binding.f2404b;
            m.checkNotNullExpressionValue(imageView3, "binding.guildsItemSelected");
            imageView3.setVisibility(data.isSelected() ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter(RecyclerView recyclerView, @ColorInt int i) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.overlayColor = i;
        this.onClickListener = WidgetGlobalSearchGuildsAdapter$onClickListener$1.INSTANCE;
        this.onLongClickListener = WidgetGlobalSearchGuildsAdapter$onLongClickListener$1.INSTANCE;
    }

    public final Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    public final Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> getOnLongClickListener() {
        return this.onLongClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> function3) {
        m.checkNotNullParameter(function3, "<set-?>");
        this.onClickListener = function3;
    }

    public final void setOnLongClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> function3) {
        m.checkNotNullParameter(function3, "<set-?>");
        this.onLongClickListener = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetGlobalSearchGuildsModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new ItemDivider(this, R.layout.widget_global_search_item_divider);
        }
        if (viewType == 2) {
            return new ItemDirectMessage(this, R.layout.widget_global_search_item_dm);
        }
        if (viewType == 3) {
            return new ItemGuild(this, R.layout.widget_global_search_item_guild, this.overlayColor);
        }
        throw invalidViewTypeException(viewType);
    }
}
