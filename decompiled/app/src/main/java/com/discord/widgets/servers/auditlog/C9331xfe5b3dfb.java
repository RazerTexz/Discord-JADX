package com.discord.widgets.servers.auditlog;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$1 */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9331xfe5b3dfb<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem) t).getIsChecked()), Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem) t2).getIsChecked()));
    }
}
