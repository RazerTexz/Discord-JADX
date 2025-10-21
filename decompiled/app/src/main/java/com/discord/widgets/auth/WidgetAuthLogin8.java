package com.discord.widgets.auth;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetAuthLogin.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthLogin$undeleteAccountLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLogin8 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin8(WidgetAuthLogin widgetAuthLogin) {
        super(0);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetAuthLogin.login$default(this.this$0, null, true, 1, null);
    }
}
