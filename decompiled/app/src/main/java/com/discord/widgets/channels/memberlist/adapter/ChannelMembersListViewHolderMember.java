package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelMembersListItemUserBinding;
import com.discord.models.presence.Presence;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.views.UsernameView;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ChannelMembersListViewHolderMember.kt */
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderMember extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemUserBinding binding;

    /* compiled from: ChannelMembersListViewHolderMember.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderMember$bind$1 */
    public static final class ViewOnClickListenerC75151 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onClicked;

        public ViewOnClickListenerC75151(Function0 function0) {
            this.$onClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onClicked.invoke();
        }
    }

    /* compiled from: ChannelMembersListViewHolderMember.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderMember$bind$3 */
    public static final class ViewOnClickListenerC75163 implements View.OnClickListener {
        public final /* synthetic */ ChannelMembersListAdapter.Item.Member $data;
        public final /* synthetic */ boolean $isBooster;

        public ViewOnClickListenerC75163(boolean z2, ChannelMembersListAdapter.Item.Member member) {
            this.$isBooster = z2;
            this.$data = member;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$isBooster) {
                String readableTimeString = TimeUtils.getReadableTimeString(outline.m885x(view, "it", "it.context"), this.$data.getPremiumSince());
                Context context = view.getContext();
                Context context2 = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
                AppToast.m170h(context, FormatUtils.m216h(context2, C5419R.string.premium_guild_subscription_tooltip, new Object[]{readableTimeString}, null, 4), 0, null, 12);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderMember(WidgetChannelMembersListItemUserBinding widgetChannelMembersListItemUserBinding) {
        super(widgetChannelMembersListItemUserBinding.f15862a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemUserBinding, "binding");
        this.binding = widgetChannelMembersListItemUserBinding;
    }

    public final void bind(ChannelMembersListAdapter.Item.Member data, Function0<Unit> onClicked) {
        int themedColor;
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onClicked, "onClicked");
        this.binding.f15862a.setOnClickListener(new ViewOnClickListenerC75151(onClicked));
        UsernameView usernameView = this.binding.f15867f;
        UsernameView.m8566c(usernameView, data.getName(), null, false, null, null, 30);
        Integer color = data.getColor();
        if (color != null) {
            themedColor = color.intValue();
        } else {
            Intrinsics3.checkNotNullExpressionValue(usernameView, "this");
            themedColor = ColorCompat.getThemedColor(usernameView, C5419R.attr.primary_000);
        }
        usernameView.setUsernameColor(themedColor);
        boolean z2 = data.getPremiumSince() != null;
        UsernameView usernameView2 = this.binding.f15867f;
        boolean zIsBot = data.isBot();
        Integer tagText = data.getTagText();
        usernameView2.m8567a(zIsBot, tagText != null ? tagText.intValue() : C5419R.string.bot_tag_bot, data.getTagVerified());
        ImageView imageView = this.binding.f15866e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelMembersListItemGroupOwnerIndicator");
        imageView.setVisibility(data.getShowOwnerIndicator() ? 0 : 8);
        ImageView imageView2 = this.binding.f15864c;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemBoostedIndicator");
        imageView2.setVisibility(z2 ? 0 : 8);
        this.binding.f15864c.setOnClickListener(new ViewOnClickListenerC75163(z2, data));
        this.binding.f15868g.setPresence(data.getPresence());
        StatusView statusView = this.binding.f15868g;
        Intrinsics3.checkNotNullExpressionValue(statusView, "binding.channelMembersListItemPresence");
        statusView.setVisibility(UserUtils.INSTANCE.isStatusVisible(data.getUserFlags(), data.getPresence(), true) ? 0 : 8);
        ImageView imageView3 = this.binding.f15869h;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.channelMembersListItemRichPresenceIv");
        imageView3.setVisibility(PresenceUtils.INSTANCE.shouldShowRichPresenceIcon(data.getPresence()) ? 0 : 8);
        Presence presence = data.getPresence();
        boolean zIsApplicationStreaming = data.isApplicationStreaming();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f15865d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.channelMembersListItemGame");
        PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, false, !data.getCanDisplayStatusEmoji(), 8, null);
        SimpleDraweeView simpleDraweeView = this.binding.f15863b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelMembersListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getAvatarUrl(), C5419R.dimen.avatar_size_standard, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
    }
}
