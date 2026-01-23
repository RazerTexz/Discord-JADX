package com.discord.widgets.servers.auditlog;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onFilterSelectedCallback$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter8 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter8(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
        super(0);
        this.this$0 = widgetServerSettingsAuditLogFilter;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
