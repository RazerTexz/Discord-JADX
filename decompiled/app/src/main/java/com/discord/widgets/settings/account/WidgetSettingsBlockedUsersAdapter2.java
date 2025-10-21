package com.discord.widgets.settings.account;

import android.view.View;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersAdapter;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel;

/* compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsBlockedUsersViewModel.Item $data;
    public final /* synthetic */ WidgetSettingsBlockedUsersAdapter.BlockedUserViewHolder this$0;

    public WidgetSettingsBlockedUsersAdapter2(WidgetSettingsBlockedUsersAdapter.BlockedUserViewHolder blockedUserViewHolder, WidgetSettingsBlockedUsersViewModel.Item item) {
        this.this$0 = blockedUserViewHolder;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsBlockedUsersAdapter.BlockedUserViewHolder.access$getAdapter$p(this.this$0).getOnClickUserProfile().invoke(this.$data.getUser());
    }
}
