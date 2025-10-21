package com.discord.stores;

import com.discord.stores.StoreOutboundPromotions;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreOutboundPromotions.kt */
/* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreOutboundPromotions3 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* compiled from: StoreOutboundPromotions.kt */
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreOutboundPromotions.access$setState$p(StoreOutboundPromotions3.this.this$0, StoreOutboundPromotions.State.Failed.INSTANCE);
            StoreOutboundPromotions3.this.this$0.markChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions3(StoreOutboundPromotions storeOutboundPromotions) {
        super(1);
        this.this$0 = storeOutboundPromotions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        StoreOutboundPromotions.access$getDispatcher$p(this.this$0).schedule(new AnonymousClass1());
    }
}
