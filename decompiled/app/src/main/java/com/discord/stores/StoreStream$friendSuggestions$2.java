package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreStream.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$friendSuggestions$2 extends k implements Function0<Unit> {
    public StoreStream$friendSuggestions$2(StoreStream storeStream) {
        super(0, storeStream, StoreStream.class, "handleFriendSuggestionsFetchFailure", "handleFriendSuggestionsFetchFailure()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.access$handleFriendSuggestionsFetchFailure((StoreStream) this.receiver);
    }
}
