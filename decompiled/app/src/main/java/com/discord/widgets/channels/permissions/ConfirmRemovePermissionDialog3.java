package com.discord.widgets.channels.permissions;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: ConfirmRemovePermissionDialog.kt */
/* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog3 extends Lambda implements Function0<ConfirmRemovePermissionDialogViewModel> {
    public final /* synthetic */ ConfirmRemovePermissionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialog3(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        super(0);
        this.this$0 = confirmRemovePermissionDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ConfirmRemovePermissionDialogViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ConfirmRemovePermissionDialogViewModel invoke() {
        return new ConfirmRemovePermissionDialogViewModel(ConfirmRemovePermissionDialog.access$getPermissionOwnerFromArgs(this.this$0), ConfirmRemovePermissionDialog.access$getChannelIdFromArgs(this.this$0), null, 4, null);
    }
}
