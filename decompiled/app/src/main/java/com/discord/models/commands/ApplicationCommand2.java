package com.discord.models.commands;

import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ApplicationCommand.kt */
/* renamed from: com.discord.models.commands.ApplicationCommandKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommand2 {
    public static final boolean hasPermission(ApplicationCommand applicationCommand, long j, List<Long> list) {
        Object next;
        Intrinsics3.checkNotNullParameter(applicationCommand, "$this$hasPermission");
        Intrinsics3.checkNotNullParameter(list, "roles");
        if (applicationCommand.getDefaultPermissions() == null) {
            return true;
        }
        if (applicationCommand.getPermissions() != null) {
            Boolean bool = applicationCommand.getPermissions().get(Long.valueOf(j));
            if (bool != null) {
                return bool.booleanValue();
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(applicationCommand.getPermissions().get(Long.valueOf(((Number) it.next()).longValue())));
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (Intrinsics3.areEqual((Boolean) next, Boolean.TRUE)) {
                    break;
                }
            }
            Boolean bool2 = (Boolean) next;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return applicationCommand.getDefaultPermissions().booleanValue();
    }
}
