package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.widgets.channels.ChannelPickerAdapterItem;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChannelPickerAdapter.kt */
/* loaded from: classes2.dex */
public abstract class ChannelPickerViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: WidgetChannelPickerAdapter.kt */
    public static final class ChannelItemViewHolder extends ChannelPickerViewHolder {
        private final ViewGuildRoleSubscriptionChannelItemBinding binding;
        private ChannelPickerAdapterItem.ChannelItem item;

        /* compiled from: WidgetChannelPickerAdapter.kt */
        /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$ChannelItemViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ Function1 $onItemClickListener;

            public AnonymousClass1(Function1 function1) {
                this.$onItemClickListener = function1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelPickerAdapterItem.ChannelItem channelItemAccess$getItem$p = ChannelItemViewHolder.access$getItem$p(ChannelItemViewHolder.this);
                if (channelItemAccess$getItem$p != null) {
                    this.$onItemClickListener.invoke(channelItemAccess$getItem$p);
                }
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ChannelItemViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, Function1<? super ChannelPickerAdapterItem.ChannelItem, Unit> function1) {
            m.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            m.checkNotNullParameter(function1, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionChannelItemBinding;
            this.itemView.setOnClickListener(new AnonymousClass1(function1));
        }

        public static final /* synthetic */ ChannelPickerAdapterItem.ChannelItem access$getItem$p(ChannelItemViewHolder channelItemViewHolder) {
            return channelItemViewHolder.item;
        }

        public static final /* synthetic */ void access$setItem$p(ChannelItemViewHolder channelItemViewHolder, ChannelPickerAdapterItem.ChannelItem channelItem) {
            channelItemViewHolder.item = channelItem;
        }

        public final void configure(ChannelPickerAdapterItem adapterItem) {
            m.checkNotNullParameter(adapterItem, "adapterItem");
            ChannelPickerAdapterItem.ChannelItem channelItem = (ChannelPickerAdapterItem.ChannelItem) adapterItem;
            this.item = channelItem;
            if (channelItem != null) {
                TextView textView = this.binding.f2193b;
                m.checkNotNullExpressionValue(textView, "binding.channelItemName");
                textView.setText(ChannelUtils.c(channelItem.getChannel()));
                this.binding.d.setImageResource(GuildChannelIconUtilsKt.guildChannelIcon(channelItem.getChannel()));
                ImageView imageView = this.binding.c;
                m.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
                imageView.setVisibility(channelItem.isSelected() ? 0 : 8);
            }
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @SuppressLint({"SetTextI18n"})
    public static final class CreateChannelViewHolder extends ChannelPickerViewHolder {

        /* compiled from: WidgetChannelPickerAdapter.kt */
        /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$CreateChannelViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ Function0 $onItemClickListener;

            public AnonymousClass1(Function0 function0) {
                this.$onItemClickListener = function0;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.$onItemClickListener.invoke();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public CreateChannelViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, Function0<Unit> function0) {
            m.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            m.checkNotNullParameter(function0, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.root");
            Drawable drawable = null;
            super(linearLayout, null);
            viewGuildRoleSubscriptionChannelItemBinding.f2193b.setText(R.string.guild_role_subscription_tier_benefits_create_a_channel_label);
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            int themedColor = ColorCompat.getThemedColor(view, R.attr.colorTextLink);
            viewGuildRoleSubscriptionChannelItemBinding.f2193b.setTextColor(themedColor);
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            Drawable drawable2 = ContextCompat.getDrawable(view2.getContext(), R.drawable.ic_add_24dp);
            if (drawable2 != null) {
                m.checkNotNullExpressionValue(drawable2, "drawable");
                ColorCompatKt.setTint(drawable2, themedColor, false);
                drawable = drawable2;
            }
            viewGuildRoleSubscriptionChannelItemBinding.d.setImageDrawable(drawable);
            ImageView imageView = viewGuildRoleSubscriptionChannelItemBinding.c;
            m.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
            imageView.setVisibility(8);
            this.itemView.setOnClickListener(new AnonymousClass1(function0));
        }
    }

    private ChannelPickerViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ ChannelPickerViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
