package com.discord.widgets.channels.permissions;

import android.view.View;
import com.discord.widgets.channels.permissions.AddMemberAdapter;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddMemberAdapter3 implements View.OnClickListener {
    public final /* synthetic */ AddMemberAdapter.Item.PermissionOwnerItem $item;
    public final /* synthetic */ AddMemberAdapter.AddMemberAdapterItemItem this$0;

    public AddMemberAdapter3(AddMemberAdapter.AddMemberAdapterItemItem addMemberAdapterItemItem, AddMemberAdapter.Item.PermissionOwnerItem permissionOwnerItem) {
        this.this$0 = addMemberAdapterItemItem;
        this.$item = permissionOwnerItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AddMemberAdapter.AddMemberAdapterItemItem.access$handleClick(this.this$0, this.$item);
    }
}
