package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreStream.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$4 extends FunctionReferenceImpl implements Function1<Long, Boolean> {
    public StoreStream$lazyChannelMembersStore$4(StoreApplicationStreaming storeApplicationStreaming) {
        super(1, storeApplicationStreaming, StoreApplicationStreaming.class, "isUserStreaming", "isUserStreaming(J)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        return ((StoreApplicationStreaming) this.receiver).isUserStreaming(j);
    }
}
