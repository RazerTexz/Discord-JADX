package com.discord.utilities.permissions;

import com.discord.models.message.Message;
import java.util.Set;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.permissions.PermissionsContextsKt, reason: use source file name */
/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionsContexts4 {
    private static final Set<Integer> DELETEABLE_MESSAGE_TYPES = Sets5.setOf((Object[]) new Integer[]{0, 6, 7, 8, 9, 10, 11, 12, 18, 19, 20, 22, 23, 25});

    public static final Set<Integer> getDELETEABLE_MESSAGE_TYPES() {
        return DELETEABLE_MESSAGE_TYPES;
    }

    public static final boolean isDeleteable(Message message) {
        Intrinsics3.checkNotNullParameter(message, "$this$isDeleteable");
        return _Collections.contains(DELETEABLE_MESSAGE_TYPES, message.getType()) || message.isLocal();
    }
}
