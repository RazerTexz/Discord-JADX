package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import kotlin.jvm.functions.Function0;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter2<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem $item;
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterActionViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter2(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterActionViewHolder auditLogFilterActionViewHolder, WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem auditLogActionFilterItem) {
        this.this$0 = auditLogFilterActionViewHolder;
        this.$item = auditLogActionFilterItem;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreStream.INSTANCE.getAuditLog().setAuditLogFilterActionId(this.$item.getActionId());
        Function0 function0Access$getOnFilterSelectedCallback$p = WidgetServerSettingsAuditLogFilterAdapter.access$getOnFilterSelectedCallback$p(WidgetServerSettingsAuditLogFilterAdapter.AuditLogFilterActionViewHolder.access$getAdapter$p(this.this$0));
        if (function0Access$getOnFilterSelectedCallback$p != null) {
        }
    }
}
