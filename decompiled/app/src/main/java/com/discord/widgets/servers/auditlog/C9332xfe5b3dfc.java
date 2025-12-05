package com.discord.widgets.servers.auditlog;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$2 */
/* loaded from: classes2.dex */
public final class C9332xfe5b3dfc<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem) t).getIsChecked()), Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem) t2).getIsChecked()));
    }
}
