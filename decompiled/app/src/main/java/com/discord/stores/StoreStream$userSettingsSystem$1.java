package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreStream.kt */
/* loaded from: classes2.dex */
public final class StoreStream$userSettingsSystem$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$userSettingsSystem$1(StoreStream storeStream) {
        super(1);
        this.this$0 = storeStream;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        this.this$0.getAccessibility().updateFontScale(i);
    }
}
