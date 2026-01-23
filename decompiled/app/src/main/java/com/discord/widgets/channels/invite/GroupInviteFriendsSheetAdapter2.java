package com.discord.widgets.channels.invite;

import android.view.View;
import com.discord.models.user.User;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter;
import com.google.android.material.checkbox.MaterialCheckBox;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter2 implements View.OnClickListener {
    public final /* synthetic */ User $modelUser;
    public final /* synthetic */ GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem this$0;

    public GroupInviteFriendsSheetAdapter2(GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem groupInviteFriendsListItem, User user) {
        this.this$0 = groupInviteFriendsListItem;
        this.$modelUser = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialCheckBox materialCheckBox = GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem.access$getBinding$p(this.this$0).f15116d;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.userSelectedCheckbox");
        GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem.access$getAdapter$p(this.this$0).getOnUserChecked().invoke(this.$modelUser, Boolean.valueOf(materialCheckBox.isChecked()));
    }
}
