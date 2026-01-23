package com.discord.widgets.user.profile;

import android.view.View;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.profile.UserProfileHeaderView;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$BadgeViewHolder$bind$1, reason: use source file name */
/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView2 implements View.OnClickListener {
    public final /* synthetic */ Badge $data;
    public final /* synthetic */ UserProfileHeaderView.BadgeViewHolder this$0;

    public UserProfileHeaderView2(UserProfileHeaderView.BadgeViewHolder badgeViewHolder, Badge badge) {
        this.this$0 = badgeViewHolder;
        this.$data = badge;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.this$0.getOnBadgeClick().invoke(this.$data);
    }
}
