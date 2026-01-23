package com.discord.widgets.user.profile;

import android.view.View;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.platform.Platform;
import com.discord.widgets.user.profile.UserProfileConnectionsView;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$ViewHolder$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView3 implements View.OnClickListener {
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ String $profileUrl;
    public final /* synthetic */ int $themedPlatformImageRes;
    public final /* synthetic */ String $username;
    public final /* synthetic */ UserProfileConnectionsView.ViewHolder this$0;

    public UserProfileConnectionsView3(UserProfileConnectionsView.ViewHolder viewHolder, Platform platform, String str, int i, String str2) {
        this.this$0 = viewHolder;
        this.$platform = platform;
        this.$username = str;
        this.$themedPlatformImageRes = i;
        this.$profileUrl = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AnalyticsTracker.connectedAccountViewed(this.$platform.getPlatformId());
        UserProfileConnectionsView.ViewHolder.access$getAdapter$p(this.this$0).getOnConnectedAccountClick().invoke(this.$username, Integer.valueOf(this.$themedPlatformImageRes), this.$profileUrl);
    }
}
