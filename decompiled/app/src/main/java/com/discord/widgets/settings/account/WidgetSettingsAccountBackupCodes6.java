package com.discord.widgets.settings.account;

import android.content.Context;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$showVerificationKeyModal$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes6 extends Lambda implements Function2<Context, String, Unit> {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountBackupCodes6(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        super(2);
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
        invoke2(context, str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str) {
        Intrinsics3.checkNotNullParameter(context, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(str, "inputText");
        WidgetSettingsAccountBackupCodes.access$setVerificationKey$p(this.this$0, str);
        WidgetSettingsAccountBackupCodes.getBackupCodes$default(this.this$0, false, 1, null);
    }
}
