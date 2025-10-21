package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import java.util.Set;
import rx.Observable;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter2<T, R> implements Func1<Set<? extends Long>, Observable<? extends Map<Long, ? extends User>>> {
    public static final WidgetServerSettingsAuditLogFilter2 INSTANCE = new WidgetServerSettingsAuditLogFilter2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends User>> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, User>> call2(Set<Long> set) {
        StoreUser users = StoreStream.INSTANCE.getUsers();
        Intrinsics3.checkNotNullExpressionValue(set, "it");
        return users.observeUsers(set);
    }
}
