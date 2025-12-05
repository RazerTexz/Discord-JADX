package com.discord.widgets.guilds.join;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.databinding.WidgetGuildWelcomeChannelBinding;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetChannelAdapter3;
import com.facebook.drawee.view.SimpleDraweeView;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* renamed from: com.discord.widgets.guilds.join.ChannelViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetChannelAdapter4 extends WidgetGuildWelcomeSheetChannelAdapter2 {
    private final WidgetGuildWelcomeChannelBinding binding;

    /* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.join.ChannelViewHolder$bind$1 */
    public static final class ViewOnClickListenerC87151 implements View.OnClickListener {
        public final /* synthetic */ WidgetGuildWelcomeSheetChannelAdapter3 $data;

        public ViewOnClickListenerC87151(WidgetGuildWelcomeSheetChannelAdapter3 widgetGuildWelcomeSheetChannelAdapter3) {
            this.$data = widgetGuildWelcomeSheetChannelAdapter3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ((WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) this.$data).getGoToChannel().invoke(Long.valueOf(((WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) this.$data).getWelcomeChannel().getChannelId()), Integer.valueOf(((WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) this.$data).getIndex()));
            ((WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) this.$data).getDismissSheet().invoke();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildWelcomeSheetChannelAdapter4(WidgetGuildWelcomeChannelBinding widgetGuildWelcomeChannelBinding) {
        Intrinsics3.checkNotNullParameter(widgetGuildWelcomeChannelBinding, "binding");
        CardView cardView = widgetGuildWelcomeChannelBinding.f17079a;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.root");
        super(cardView);
        this.binding = widgetGuildWelcomeChannelBinding;
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetChannelAdapter2
    public void bind(WidgetGuildWelcomeSheetChannelAdapter3 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.bind(data);
        WidgetGuildWelcomeSheetChannelAdapter3.ChannelData channelData = (WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) data;
        SimpleDraweeView simpleDraweeView = this.binding.f17082d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildWelcomeChannelEmoji");
        int mediaProxySize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().width);
        GuildWelcomeChannel welcomeChannel = channelData.getWelcomeChannel();
        Intrinsics3.checkNotNullParameter(welcomeChannel, "$this$getEmojiUri");
        Long emojiId = welcomeChannel.getEmojiId();
        String imageUri = emojiId != null ? ModelEmojiCustom.getImageUri(emojiId.longValue(), false, mediaProxySize) : null;
        TextView textView = this.binding.f17081c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildWelcomeChannelDescription");
        textView.setText(channelData.getWelcomeChannel().getDescription());
        TextView textView2 = this.binding.f17083e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildWelcomeChannelName");
        Channel channelFindChannelById = StoreStream.INSTANCE.getChannels().findChannelById(channelData.getWelcomeChannel().getChannelId());
        textView2.setText(String.valueOf(channelFindChannelById != null ? ChannelUtils.m7679c(channelFindChannelById) : null));
        this.binding.f17080b.setOnClickListener(new ViewOnClickListenerC87151(data));
        if (imageUri != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f17082d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildWelcomeChannelEmoji");
            MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, false, null, null, 124, null);
            SimpleDraweeView simpleDraweeView3 = this.binding.f17082d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView3.setVisibility(0);
            TextView textView3 = this.binding.f17084f;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildWelcomeChannelUnicodeEmoji");
            textView3.setVisibility(8);
            return;
        }
        if (channelData.getWelcomeChannel().getEmojiName() != null) {
            SimpleDraweeView simpleDraweeView4 = this.binding.f17082d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView4.setVisibility(8);
            TextView textView4 = this.binding.f17084f;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildWelcomeChannelUnicodeEmoji");
            textView4.setVisibility(0);
            TextView textView5 = this.binding.f17084f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildWelcomeChannelUnicodeEmoji");
            textView5.setText(channelData.getWelcomeChannel().getEmojiName());
        }
    }
}
