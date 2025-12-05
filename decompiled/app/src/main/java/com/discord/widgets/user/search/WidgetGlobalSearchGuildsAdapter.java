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
import com.discord.C5419R;
import com.discord.databinding.WidgetGlobalSearchItemGuildBinding;
import com.discord.databinding.WidgetGuildsListItemDmBinding;
import com.discord.databinding.WidgetGuildsListItemGuildBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

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
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        }

        public static final /* synthetic */ WidgetGlobalSearchGuildsAdapter access$getAdapter$p(Item item) {
            return (WidgetGlobalSearchGuildsAdapter) item.adapter;
        }

        public final void configureMentionsCount(TextView textView, int count) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            if (count < 1) {
                ViewExtensions.setTextAndVisibilityBy(textView, null);
                textView.setContentDescription(null);
                return;
            }
            textView.setVisibility(0);
            textView.setText(String.valueOf(count));
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.overlay_guild_mentions_primary_630, 0, 2, (Object) null));
            textView.setContentDescription(FormatUtils.m216h(context, C5419R.string.mentions_count, new Object[]{String.valueOf(count)}, null, 4));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetGlobalSearchGuildsModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.itemView.setOnClickListener(new WidgetGlobalSearchGuildsAdapter2(this, position, data));
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchGuildsAdapter3(this, position, data));
        }
    }

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static final class ItemDirectMessage extends Item {
        private final WidgetGuildsListItemDmBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemDirectMessage(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
            WidgetGuildsListItemDmBinding widgetGuildsListItemDmBindingM8418a = WidgetGuildsListItemDmBinding.m8418a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemDmBindingM8418a, "WidgetGuildsListItemDmBinding.bind(itemView)");
            this.binding = widgetGuildsListItemDmBindingM8418a;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel.Item item) {
            onConfigure(i, item);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item
        public void onConfigure(int position, WidgetGlobalSearchGuildsModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure2(position, data);
            TextView textView = this.binding.f17097c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildsItemDmCount");
            configureMentionsCount(textView, data.getMentionCount());
            SimpleDraweeView simpleDraweeView = this.binding.f17096b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildsItemDmAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getChannel(), C5419R.dimen.avatar_size_large, (MGImages.ChangeDetector) null, 8, (Object) null);
        }
    }

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static final class ItemDivider extends Item {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemDivider(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
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
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
            this.overlayColor = i2;
            View view = this.itemView;
            int i3 = C5419R.id.guilds_item_selected;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.guilds_item_selected);
            if (imageView != null) {
                i3 = C5419R.id.guilds_item_unread;
                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.guilds_item_unread);
                if (imageView2 != null) {
                    WidgetGlobalSearchItemGuildBinding widgetGlobalSearchItemGuildBinding = new WidgetGlobalSearchItemGuildBinding((RelativeLayout) view, imageView, imageView2);
                    Intrinsics3.checkNotNullExpressionValue(widgetGlobalSearchItemGuildBinding, "WidgetGlobalSearchItemGuildBinding.bind(itemView)");
                    this.binding = widgetGlobalSearchItemGuildBinding;
                    WidgetGuildsListItemGuildBinding widgetGuildsListItemGuildBindingM8419a = WidgetGuildsListItemGuildBinding.m8419a(this.itemView);
                    Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemGuildBindingM8419a, "WidgetGuildsListItemGuildBinding.bind(itemView)");
                    this.bindingGuild = widgetGuildsListItemGuildBindingM8419a;
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
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure2(position, data);
            Guild guild2 = data.getGuild();
            boolean z2 = guild2 != null && guild2.hasIcon();
            SimpleDraweeView simpleDraweeView = this.bindingGuild.f17109d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            boolean zIsSelected = data.isSelected();
            Guild guild3 = data.getGuild();
            Integer numValueOf = Integer.valueOf(this.overlayColor);
            Intrinsics3.checkNotNullExpressionValue(this.bindingGuild.f17109d, "bindingGuild.guildsItemAvatar");
            SimpleDraweeViewExtensions.setGuildIcon$default(simpleDraweeView, zIsSelected, guild3, r8.getResources().getDimensionPixelSize(C5419R.dimen.guild_icon_radius), null, numValueOf, null, null, false, null, 488, null);
            TextView textView = this.bindingGuild.f17110e;
            Intrinsics3.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
            String shortName = null;
            if (!z2 && (guild = data.getGuild()) != null) {
                shortName = guild.getShortName();
            }
            textView.setText(shortName);
            TextView textView2 = this.bindingGuild.f17113h;
            Intrinsics3.checkNotNullExpressionValue(textView2, "bindingGuild.guildsItemMentions");
            configureMentionsCount(textView2, data.getMentionCount());
            ImageView imageView = this.bindingGuild.f17114i;
            Intrinsics3.checkNotNullExpressionValue(imageView, "bindingGuild.guildsItemVoice");
            imageView.setVisibility(data.getConnectedToVoice() ? 0 : 8);
            ImageView imageView2 = this.binding.f16717c;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildsItemUnread");
            imageView2.setVisibility(data.isUnread() ? 0 : 8);
            ImageView imageView3 = this.binding.f16716b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.guildsItemSelected");
            imageView3.setVisibility(data.isSelected() ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter(RecyclerView recyclerView, @ColorInt int i) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.overlayColor = i;
        this.onClickListener = WidgetGlobalSearchGuildsAdapter4.INSTANCE;
        this.onLongClickListener = WidgetGlobalSearchGuildsAdapter5.INSTANCE;
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
        Intrinsics3.checkNotNullParameter(function3, "<set-?>");
        this.onClickListener = function3;
    }

    public final void setOnLongClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> function3) {
        Intrinsics3.checkNotNullParameter(function3, "<set-?>");
        this.onLongClickListener = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetGlobalSearchGuildsModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new ItemDivider(this, C5419R.layout.widget_global_search_item_divider);
        }
        if (viewType == 2) {
            return new ItemDirectMessage(this, C5419R.layout.widget_global_search_item_dm);
        }
        if (viewType == 3) {
            return new ItemGuild(this, C5419R.layout.widget_global_search_item_guild, this.overlayColor);
        }
        throw invalidViewTypeException(viewType);
    }
}
