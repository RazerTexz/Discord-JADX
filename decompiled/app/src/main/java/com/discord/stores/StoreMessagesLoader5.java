package com.discord.stores;

import com.discord.stores.StoreMessagesLoader;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$5$1, reason: use source file name */
/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader5 extends Lambda implements Function1<StoreMessagesLoader.ChannelLoadedState, StoreMessagesLoader.ChannelLoadedState> {
    public static final StoreMessagesLoader5 INSTANCE = new StoreMessagesLoader5();

    public StoreMessagesLoader5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessagesLoader.ChannelLoadedState invoke(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        return invoke2(channelLoadedState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessagesLoader.ChannelLoadedState invoke2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
        return StoreMessagesLoader.ChannelLoadedState.copy$default(channelLoadedState, false, false, true, false, null, 27, null);
    }
}
