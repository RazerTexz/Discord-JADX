package com.discord.widgets.servers.auditlog;

import android.view.View;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.m;

/* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$2(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder auditLogFilterUserViewHolder) {
        this.this$0 = auditLogFilterUserViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialRadioButton materialRadioButton = WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder.access$getBinding$p(this.this$0).f2541b;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.auditLogFilterRadioButton");
        materialRadioButton.setChecked(true);
    }
}
