package com.discord.widgets.settings.account;

import androidx.fragment.app.FragmentActivity;
import com.discord.utilities.stateful.StatefulViews;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$passwordVerifyLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountUsernameEdit3(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        super(0);
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StatefulViews.clear$default(WidgetSettingsAccountUsernameEdit.access$getState$p(this.this$0), false, 1, null);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
