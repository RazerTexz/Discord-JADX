package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: StoreApplicationCommands.kt */
/* loaded from: classes2.dex */
public final class StoreApplicationCommands$requestInitialApplicationCommands$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Ref$IntRef $offset$inlined;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$requestInitialApplicationCommands$$inlined$let$lambda$1(StoreApplicationCommands storeApplicationCommands, Ref$IntRef ref$IntRef) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$offset$inlined = ref$IntRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationCommands storeApplicationCommands = this.this$0;
        StoreApplicationCommands.access$handleDiscoverCommandsUpdate(storeApplicationCommands, StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands).getBuiltInCommands());
    }
}
