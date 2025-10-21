package com.discord.stores;

import com.discord.stores.StoreThreadMessages;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreThreadMessages.kt */
/* renamed from: com.discord.stores.StoreThreadMessages$deleteForParentChannel$removed$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreThreadMessages3 extends Lambda implements Function1<StoreThreadMessages.ThreadState, Boolean> {
    public final /* synthetic */ long $parentChannelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadMessages3(long j) {
        super(1);
        this.$parentChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadMessages.ThreadState threadState) {
        return Boolean.valueOf(invoke2(threadState));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadMessages.ThreadState threadState) {
        Intrinsics3.checkNotNullParameter(threadState, "thread");
        return threadState.getParentId() == this.$parentChannelId;
    }
}
