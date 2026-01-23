package com.discord.stores;

import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$Companion$initialize$3 extends Lambda implements Function0<String> {
    public static final StoreStream$Companion$initialize$3 INSTANCE = new StoreStream$Companion$initialize$3();

    public StoreStream$Companion$initialize$3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return StoreStream.Companion.access$getCollector$p(StoreStream.INSTANCE).getUserSettingsSystem().getLocale();
    }
}
