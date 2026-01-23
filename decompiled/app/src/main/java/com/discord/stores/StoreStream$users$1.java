package com.discord.stores;

import com.discord.api.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$users$1 extends FunctionReferenceImpl implements Function1<User, Unit> {
    public StoreStream$users$1(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleUserUpdated", "handleUserUpdated(Lcom/discord/api/user/User;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "p1");
        StoreStream.access$handleUserUpdated((StoreStream) this.receiver, user);
    }
}
