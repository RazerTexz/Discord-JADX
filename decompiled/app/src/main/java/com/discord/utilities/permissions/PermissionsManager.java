package com.discord.utilities.permissions;


/* compiled from: PermissionsManager.kt */
/* loaded from: classes2.dex */
public final class PermissionsManager {
    public final boolean can(long permission, Long computedPermissions) {
        return PermissionUtils.can(permission, computedPermissions);
    }
}
