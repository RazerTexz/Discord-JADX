package com.discord.widgets.user.phone;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetUserPhoneVerify.kt */
/* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$autofillCode$1$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify4 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public WidgetUserPhoneVerify4(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        super(1, widgetUserPhoneVerify, WidgetUserPhoneVerify.class, "handleCodeEntered", "handleCodeEntered(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "p1");
        WidgetUserPhoneVerify.access$handleCodeEntered((WidgetUserPhoneVerify) this.receiver, str);
    }
}
