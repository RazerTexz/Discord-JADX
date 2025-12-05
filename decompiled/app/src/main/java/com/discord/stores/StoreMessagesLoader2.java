package com.discord.stores;

import com.discord.stores.StoreChat;
import com.discord.stores.StoreMessagesLoader;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreMessagesLoader.kt */
/* renamed from: com.discord.stores.StoreMessagesLoader$handleChatInteraction$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreMessagesLoader2 extends Lambda implements Function1<StoreMessagesLoader.ChannelLoadedState, StoreMessagesLoader.ChannelLoadedState> {
    public final /* synthetic */ StoreChat.InteractionState $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader2(StoreChat.InteractionState interactionState) {
        super(1);
        this.$this_apply = interactionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessagesLoader.ChannelLoadedState invoke(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        return invoke2(channelLoadedState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessagesLoader.ChannelLoadedState invoke2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
        return StoreMessagesLoader.ChannelLoadedState.copy$default(channelLoadedState, false, false, false, this.$this_apply.isTouchedSinceLastJump(), null, 23, null);
    }
}
