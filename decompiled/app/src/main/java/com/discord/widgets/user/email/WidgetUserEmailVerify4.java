package com.discord.widgets.user.email;

import com.discord.app.AppActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$emailUpdateLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetUserEmailVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserEmailVerify4(WidgetUserEmailVerify widgetUserEmailVerify) {
        super(0);
        this.this$0 = widgetUserEmailVerify;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }
}
