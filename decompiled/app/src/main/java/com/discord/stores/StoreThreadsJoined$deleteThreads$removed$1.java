package com.discord.stores;

import com.discord.stores.StoreThreadsJoined;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreThreadsJoined.kt */
/* loaded from: classes2.dex */
public final class StoreThreadsJoined$deleteThreads$removed$1 extends o implements Function1<StoreThreadsJoined.JoinedThread, Boolean> {
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsJoined$deleteThreads$removed$1(long j) {
        super(1);
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadsJoined.JoinedThread joinedThread) {
        return Boolean.valueOf(invoke2(joinedThread));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadsJoined.JoinedThread joinedThread) {
        m.checkNotNullParameter(joinedThread, "joinedThread");
        return joinedThread.getGuildId() == this.$guildId;
    }
}
