package com.discord.widgets.servers.auditlog;

import android.widget.CompoundButton;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem $item;
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$1(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterUserViewHolder auditLogFilterUserViewHolder, WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem auditLogUserFilterItem) {
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
