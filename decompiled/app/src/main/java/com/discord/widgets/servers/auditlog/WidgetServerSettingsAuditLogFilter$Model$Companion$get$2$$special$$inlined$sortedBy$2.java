package com.discord.widgets.servers.auditlog;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import d0.u.a;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$2<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem) t).getIsChecked()), Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem) t2).getIsChecked()));
    }
}
