package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreStream.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$2 extends FunctionReferenceImpl implements Function1<Long, Integer> {
    public StoreStream$lazyChannelMembersStore$2(StoreGuildMemberCounts storeGuildMemberCounts) {
        super(1, storeGuildMemberCounts, StoreGuildMemberCounts.class, "getApproximateMemberCount", "getApproximateMemberCount(J)I", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Long l) {
        return Integer.valueOf(invoke(l.longValue()));
    }

    public final int invoke(long j) {
        return ((StoreGuildMemberCounts) this.receiver).getApproximateMemberCount(j);
    }
}
