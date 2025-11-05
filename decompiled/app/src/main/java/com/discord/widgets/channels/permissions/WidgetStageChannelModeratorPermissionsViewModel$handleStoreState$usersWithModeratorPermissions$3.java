package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$3 extends o implements Function1<PermissionOverwrite, Boolean> {
    public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel.StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$3(WidgetStageChannelModeratorPermissionsViewModel.StoreState storeState) {
        super(1);
        this.$storeState = storeState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        m.checkNotNullParameter(permissionOverwrite, "it");
        return !((WidgetStageChannelModeratorPermissionsViewModel.StoreState.Valid) this.$storeState).getGuild().isOwner(permissionOverwrite.e());
    }
}
