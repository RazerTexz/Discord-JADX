package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreInviteSettings.kt */
/* renamed from: com.discord.stores.StoreInviteSettings$trackWithInvite$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreInviteSettings3 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ Function1 $trackBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInviteSettings3(Function1 function1) {
        super(1);
        this.$trackBlock = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        this.$trackBlock.invoke(null);
    }
}
