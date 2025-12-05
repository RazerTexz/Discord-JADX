package com.discord.widgets.settings.account;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$showPasswordModal$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes4 extends Lambda implements Function2<Context, String, Unit> {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountBackupCodes4(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        super(2);
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
        invoke2(context, str);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str) {
        Intrinsics3.checkNotNullParameter(context, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(str, "newPassword");
        WidgetSettingsAccountBackupCodes.access$setPassword$p(this.this$0, str);
        WidgetSettingsAccountBackupCodes.access$sendVerificationKey(this.this$0);
    }
}
