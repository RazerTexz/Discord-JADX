package com.discord.widgets.user.phone;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserPhoneVerify.kt */
/* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$onViewBound$1$1, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify8 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public WidgetUserPhoneVerify8(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        super(1, widgetUserPhoneVerify, WidgetUserPhoneVerify.class, "handleCodeEntered", "handleCodeEntered(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "p1");
        WidgetUserPhoneVerify.access$handleCodeEntered((WidgetUserPhoneVerify) this.receiver, str);
    }
}
