package com.discord.stores;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreStream.kt */
/* loaded from: classes2.dex */
public final class StoreStream$guildStickers$1 extends Lambda implements Function1<List<? extends Long>, Unit> {
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$guildStickers$1(StoreStream storeStream) {
        super(1);
        this.this$0 = storeStream;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
        invoke2((List<Long>) list);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "deletedStickers");
        this.this$0.getStickers().handleDeletedStickers(list);
    }
}
