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
import com.discord.widgets.guilds.join.ChannelItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* loaded from: classes2.dex */
public final class ChannelViewHolder extends BaseChannelViewHolder {
    private final WidgetGuildWelcomeChannelBinding binding;

    /* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.join.ChannelViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ChannelItem $data;

        public AnonymousClass1(ChannelItem channelItem) {
            this.$data = channelItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ((ChannelItem.ChannelData) this.$data).getGoToChannel().invoke(Long.valueOf(((ChannelItem.ChannelData) this.$data).getWelcomeChannel().getChannelId()), Integer.valueOf(((ChannelItem.ChannelData) this.$data).getIndex()));
            ((ChannelItem.ChannelData) this.$data).getDismissSheet().invoke();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChannelViewHolder(WidgetGuildWelcomeChannelBinding widgetGuildWelcomeChannelBinding) {
        m.checkNotNullParameter(widgetGuildWelcomeChannelBinding, "binding");
        CardView cardView = widgetGuildWelcomeChannelBinding.a;
        m.checkNotNullExpressionValue(cardView, "binding.root");
        super(cardView);
        this.binding = widgetGuildWelcomeChannelBinding;
    }

    @Override // com.discord.widgets.guilds.join.BaseChannelViewHolder
    public void bind(ChannelItem data) {
        m.checkNotNullParameter(data, "data");
        super.bind(data);
        ChannelItem.ChannelData channelData = (ChannelItem.ChannelData) data;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildWelcomeChannelEmoji");
        int mediaProxySize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().width);
        GuildWelcomeChannel welcomeChannel = channelData.getWelcomeChannel();
        m.checkNotNullParameter(welcomeChannel, "$this$getEmojiUri");
        Long emojiId = welcomeChannel.getEmojiId();
        String imageUri = emojiId != null ? ModelEmojiCustom.getImageUri(emojiId.longValue(), false, mediaProxySize) : null;
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.guildWelcomeChannelDescription");
        textView.setText(channelData.getWelcomeChannel().getDescription());
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.guildWelcomeChannelName");
        Channel channelFindChannelById = StoreStream.INSTANCE.getChannels().findChannelById(channelData.getWelcomeChannel().getChannelId());
        textView2.setText(String.valueOf(channelFindChannelById != null ? ChannelUtils.c(channelFindChannelById) : null));
        this.binding.f2456b.setOnClickListener(new AnonymousClass1(data));
        if (imageUri != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildWelcomeChannelEmoji");
            MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, false, null, null, 124, null);
            SimpleDraweeView simpleDraweeView3 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView3.setVisibility(0);
            TextView textView3 = this.binding.f;
            m.checkNotNullExpressionValue(textView3, "binding.guildWelcomeChannelUnicodeEmoji");
            textView3.setVisibility(8);
            return;
        }
        if (channelData.getWelcomeChannel().getEmojiName() != null) {
            SimpleDraweeView simpleDraweeView4 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView4.setVisibility(8);
            TextView textView4 = this.binding.f;
            m.checkNotNullExpressionValue(textView4, "binding.guildWelcomeChannelUnicodeEmoji");
            textView4.setVisibility(0);
            TextView textView5 = this.binding.f;
            m.checkNotNullExpressionValue(textView5, "binding.guildWelcomeChannelUnicodeEmoji");
            textView5.setText(channelData.getWelcomeChannel().getEmojiName());
        }
    }
}
