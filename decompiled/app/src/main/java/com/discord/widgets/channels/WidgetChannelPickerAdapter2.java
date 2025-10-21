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
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChannelPickerAdapter.kt */
/* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class WidgetChannelPickerAdapter2 extends RecyclerView.ViewHolder {

    /* compiled from: WidgetChannelPickerAdapter.kt */
    /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$ChannelItemViewHolder */
    public static final class ChannelItemViewHolder extends WidgetChannelPickerAdapter2 {
        private final ViewGuildRoleSubscriptionChannelItemBinding binding;
        private WidgetChannelPickerAdapter.ChannelItem item;

        /* compiled from: WidgetChannelPickerAdapter.kt */
        /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$ChannelItemViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ Function1 $onItemClickListener;

            public AnonymousClass1(Function1 function1) {
                this.$onItemClickListener = function1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelPickerAdapter.ChannelItem channelItemAccess$getItem$p = ChannelItemViewHolder.access$getItem$p(ChannelItemViewHolder.this);
                if (channelItemAccess$getItem$p != null) {
                    this.$onItemClickListener.invoke(channelItemAccess$getItem$p);
                }
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ChannelItemViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, Function1<? super WidgetChannelPickerAdapter.ChannelItem, Unit> function1) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function1, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionChannelItemBinding;
            this.itemView.setOnClickListener(new AnonymousClass1(function1));
        }

        public static final /* synthetic */ WidgetChannelPickerAdapter.ChannelItem access$getItem$p(ChannelItemViewHolder channelItemViewHolder) {
            return channelItemViewHolder.item;
        }

        public static final /* synthetic */ void access$setItem$p(ChannelItemViewHolder channelItemViewHolder, WidgetChannelPickerAdapter.ChannelItem channelItem) {
            channelItemViewHolder.item = channelItem;
        }

        public final void configure(WidgetChannelPickerAdapter adapterItem) {
            Intrinsics3.checkNotNullParameter(adapterItem, "adapterItem");
            WidgetChannelPickerAdapter.ChannelItem channelItem = (WidgetChannelPickerAdapter.ChannelItem) adapterItem;
            this.item = channelItem;
            if (channelItem != null) {
                TextView textView = this.binding.f2193b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelItemName");
                textView.setText(ChannelUtils.c(channelItem.getChannel()));
                this.binding.d.setImageResource(GuildChannelIconUtils2.guildChannelIcon(channelItem.getChannel()));
                ImageView imageView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
                imageView.setVisibility(channelItem.isSelected() ? 0 : 8);
            }
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @SuppressLint({"SetTextI18n"})
    /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$CreateChannelViewHolder */
    public static final class CreateChannelViewHolder extends WidgetChannelPickerAdapter2 {

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
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function0, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            Drawable drawable = null;
            super(linearLayout, null);
            viewGuildRoleSubscriptionChannelItemBinding.f2193b.setText(R.string.guild_role_subscription_tier_benefits_create_a_channel_label);
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            int themedColor = ColorCompat.getThemedColor(view, R.attr.colorTextLink);
            viewGuildRoleSubscriptionChannelItemBinding.f2193b.setTextColor(themedColor);
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            Drawable drawable2 = ContextCompat.getDrawable(view2.getContext(), R.drawable.ic_add_24dp);
            if (drawable2 != null) {
                Intrinsics3.checkNotNullExpressionValue(drawable2, "drawable");
                ColorCompat2.setTint(drawable2, themedColor, false);
                drawable = drawable2;
            }
            viewGuildRoleSubscriptionChannelItemBinding.d.setImageDrawable(drawable);
            ImageView imageView = viewGuildRoleSubscriptionChannelItemBinding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
            imageView.setVisibility(8);
            this.itemView.setOnClickListener(new AnonymousClass1(function0));
        }
    }

    private WidgetChannelPickerAdapter2(View view) {
        super(view);
    }

    public /* synthetic */ WidgetChannelPickerAdapter2(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
