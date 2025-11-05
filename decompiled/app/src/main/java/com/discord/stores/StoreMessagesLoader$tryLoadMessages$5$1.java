package com.discord.stores;

import com.discord.stores.StoreMessagesLoader;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreMessagesLoader.kt */
/* loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$5$1 extends o implements Function1<StoreMessagesLoader.ChannelLoadedState, StoreMessagesLoader.ChannelLoadedState> {
    public static final StoreMessagesLoader$tryLoadMessages$5$1 INSTANCE = new StoreMessagesLoader$tryLoadMessages$5$1();

    public StoreMessagesLoader$tryLoadMessages$5$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessagesLoader.ChannelLoadedState invoke(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        return invoke2(channelLoadedState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessagesLoader.ChannelLoadedState invoke2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        m.checkNotNullParameter(channelLoadedState, "it");
        return StoreMessagesLoader.ChannelLoadedState.copy$default(channelLoadedState, false, false, true, false, null, 27, null);
    }
}
