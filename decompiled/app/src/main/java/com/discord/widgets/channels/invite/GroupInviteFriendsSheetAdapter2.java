package com.discord.widgets.channels.invite;

import android.view.View;
import com.discord.models.user.User;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.Intrinsics3;

/* compiled from: GroupInviteFriendsSheetAdapter.kt */
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter2 implements View.OnClickListener {
    public final /* synthetic */ User $modelUser;
    public final /* synthetic */ GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem this$0;

    public GroupInviteFriendsSheetAdapter2(GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem groupInviteFriendsListItem, User user) {
        this.this$0 = groupInviteFriendsListItem;
        this.$modelUser = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialCheckBox materialCheckBox = GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem.access$getBinding$p(this.this$0).d;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.userSelectedCheckbox");
        GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem.access$getAdapter$p(this.this$0).getOnUserChecked().invoke(this.$modelUser, Boolean.valueOf(materialCheckBox.isChecked()));
    }
}
