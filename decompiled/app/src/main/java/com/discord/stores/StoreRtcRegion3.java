package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreRtcRegion.kt */
/* renamed from: com.discord.stores.StoreRtcRegion$handleConnectionOpen$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreRtcRegion3 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ StoreRtcRegion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcRegion3(StoreRtcRegion storeRtcRegion) {
        super(1);
        this.this$0 = storeRtcRegion;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        StoreRtcRegion.access$fetchRtcLatencyTestRegionsIps(this.this$0);
    }
}
