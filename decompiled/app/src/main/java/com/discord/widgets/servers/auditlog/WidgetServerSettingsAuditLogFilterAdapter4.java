package com.discord.widgets.servers.auditlog;

import android.view.View;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import com.google.android.material.radiobutton.MaterialRadioButton;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter4 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter4(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder auditLogFilterUserViewHolder) {
        this.this$0 = auditLogFilterUserViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialRadioButton materialRadioButton = WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder.access$getBinding$p(this.this$0).f17517b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.auditLogFilterRadioButton");
        materialRadioButton.setChecked(true);
    }
}
