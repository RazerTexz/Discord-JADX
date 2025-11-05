package com.discord.widgets.servers.auditlog;

import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter;

/* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$3 implements View.OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;
    public final /* synthetic */ WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder this$0;

    public WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$3(WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder auditLogEntryViewHolder, MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.this$0 = auditLogEntryViewHolder;
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsAuditLogAdapter.access$setEnsureExpandedIsVisible$p(WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0), true);
        StoreStream.INSTANCE.getAuditLog().toggleSelectedState(((WidgetServerSettingsAuditLogAdapter.AuditLogEntryItem) this.$data).getAuditLogEntry().getId());
    }
}
