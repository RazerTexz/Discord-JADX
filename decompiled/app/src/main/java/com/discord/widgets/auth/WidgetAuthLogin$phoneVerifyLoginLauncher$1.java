package com.discord.widgets.auth;

import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import d0.z.d.a;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthLogin.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthLogin$phoneVerifyLoginLauncher$1 extends o implements Function1<WidgetAuthPhoneVerify.Result, Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$phoneVerifyLoginLauncher$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends a implements Function1<Error, Unit> {
        public AnonymousClass1(WidgetAuthLogin widgetAuthLogin) {
            super(1, widgetAuthLogin, WidgetAuthLogin.class, "handleError", "handleError(Lcom/discord/utilities/error/Error;Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "p1");
            WidgetAuthLogin.handleError$default((WidgetAuthLogin) this.receiver, error, null, 2, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$phoneVerifyLoginLauncher$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            WidgetAuthLogin.login$default(WidgetAuthLogin$phoneVerifyLoginLauncher$1.this.this$0, null, false, 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$phoneVerifyLoginLauncher$1(WidgetAuthLogin widgetAuthLogin) {
        super(1);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify.Result result) {
        invoke2(result);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify.Result result) {
        m.checkNotNullParameter(result, "result");
        if (result instanceof WidgetAuthPhoneVerify.Result.Token) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getAuthentication().authorizeIP(((WidgetAuthPhoneVerify.Result.Token) result).getToken()), this.this$0, null, 2, null), WidgetAuthLogin.access$getBinding$p(this.this$0).h, 0L, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, new AnonymousClass1(this.this$0), (Function0) null, (Function0) null, new AnonymousClass2(), 52, (Object) null);
        }
    }
}
