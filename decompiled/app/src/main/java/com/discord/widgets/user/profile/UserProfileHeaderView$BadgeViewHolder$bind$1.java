package com.discord.widgets.user.profile;

import android.view.View;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.profile.UserProfileHeaderView;

/* compiled from: UserProfileHeaderView.kt */
/* loaded from: classes.dex */
public final class UserProfileHeaderView$BadgeViewHolder$bind$1 implements View.OnClickListener {
    public final /* synthetic */ Badge $data;
    public final /* synthetic */ UserProfileHeaderView.BadgeViewHolder this$0;

    public UserProfileHeaderView$BadgeViewHolder$bind$1(UserProfileHeaderView.BadgeViewHolder badgeViewHolder, Badge badge) {
        this.this$0 = badgeViewHolder;
        this.$data = badge;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.this$0.getOnBadgeClick().invoke(this.$data);
    }
}
