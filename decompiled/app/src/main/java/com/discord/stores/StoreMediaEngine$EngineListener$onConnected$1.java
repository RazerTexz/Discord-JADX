package com.discord.stores;

import com.discord.stores.StoreMediaEngine;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreMediaEngine.kt */
/* loaded from: classes2.dex */
public final class StoreMediaEngine$EngineListener$onConnected$1 extends o implements Function1<StoreMediaEngine.Listener, Unit> {
    public static final StoreMediaEngine$EngineListener$onConnected$1 INSTANCE = new StoreMediaEngine$EngineListener$onConnected$1();

    public StoreMediaEngine$EngineListener$onConnected$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreMediaEngine.Listener listener) {
        invoke2(listener);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreMediaEngine.Listener listener) {
        m.checkNotNullParameter(listener, "it");
        listener.onConnected();
    }
}
