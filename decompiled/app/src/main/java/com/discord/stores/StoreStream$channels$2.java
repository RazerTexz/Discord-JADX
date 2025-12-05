package com.discord.stores;

import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreStream.kt */
/* loaded from: classes2.dex */
public final class StoreStream$channels$2 extends Lambda implements Function0<List<? extends Long>> {
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$channels$2(StoreStream storeStream) {
        super(0);
        this.this$0 = storeStream;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Long> invoke2() {
        return _Collections.toList(this.this$0.getLurking().getLurkingGuildIdsSync());
    }
}
