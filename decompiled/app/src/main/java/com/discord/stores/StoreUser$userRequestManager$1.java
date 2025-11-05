package com.discord.stores;

import com.discord.api.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreUser.kt */
/* loaded from: classes2.dex */
public final class StoreUser$userRequestManager$1 extends o implements Function1<User, Unit> {
    public final /* synthetic */ StoreUser this$0;

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$userRequestManager$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ User $user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(User user) {
            super(0);
            this.$user = user;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUser.access$getNotifyUserUpdated$p(StoreUser$userRequestManager$1.this.this$0).invoke(this.$user);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUser$userRequestManager$1(StoreUser storeUser) {
        super(1);
        this.this$0 = storeUser;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        m.checkNotNullParameter(user, "user");
        StoreUser.access$getDispatcher$p(this.this$0).schedule(new AnonymousClass1(user));
    }
}
