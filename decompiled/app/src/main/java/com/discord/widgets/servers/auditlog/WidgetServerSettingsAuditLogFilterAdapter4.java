package com.discord.widgets.servers.auditlog;

import android.view.View;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter4 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter4(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder auditLogFilterUserViewHolder) {
        this.this$0 = auditLogFilterUserViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialRadioButton materialRadioButton = WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder.access$getBinding$p(this.this$0).f2541b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.auditLogFilterRadioButton");
        materialRadioButton.setChecked(true);
    }
}
