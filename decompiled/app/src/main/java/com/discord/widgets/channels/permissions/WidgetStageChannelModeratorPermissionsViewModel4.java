package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel4 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
    public static final WidgetStageChannelModeratorPermissionsViewModel4 INSTANCE = new WidgetStageChannelModeratorPermissionsViewModel4();

    public WidgetStageChannelModeratorPermissionsViewModel4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "it");
        return PermissionUtils.can(20971536L, Long.valueOf(permissionOverwrite.getAllow()));
    }
}
