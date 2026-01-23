package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import p637j0.p641k.Func1;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$getEmojiContextObservable$1<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, StoreEmoji.EmojiContext> {
    public static final EmojiPickerViewModel$Companion$getEmojiContextObservable$1 INSTANCE = new EmojiPickerViewModel$Companion$getEmojiContextObservable$1();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ StoreEmoji.EmojiContext call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreEmoji.EmojiContext call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent == null) {
            return null;
        }
        return new StoreEmoji.EmojiContext.Chat(channelOrParent.getGuildId(), resolvedSelectedChannel.getId());
    }
}
