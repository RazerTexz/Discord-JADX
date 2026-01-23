package com.discord.widgets.servers.auditlog;

import android.widget.CompoundButton;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter3 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem $item;
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter3(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder auditLogFilterUserViewHolder, WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem auditLogUserFilterItem) {
        this.this$0 = auditLogFilterUserViewHolder;
        this.$item = auditLogUserFilterItem;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            StoreStream.INSTANCE.getAuditLog().setAuditLogFilterUserId(this.$item.getId());
            Function0 function0Access$getOnFilterSelectedCallback$p = WidgetServerSettingsAuditLogFilterAdapter.access$getOnFilterSelectedCallback$p(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder.access$getAdapter$p(this.this$0));
            if (function0Access$getOnFilterSelectedCallback$p != null) {
            }
        }
    }
}
