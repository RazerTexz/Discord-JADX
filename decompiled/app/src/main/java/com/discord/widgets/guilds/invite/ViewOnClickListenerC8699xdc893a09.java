package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import com.discord.widgets.guilds.invite.WidgetGuildInviteSettings;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$3 */
/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC8699xdc893a09 implements View.OnClickListener {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ GuildInviteShareSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public ViewOnClickListenerC8699xdc893a09(GuildInvite guildInvite, WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, GuildInviteShareSheetViewModel.ViewState viewState) {
        this.$invite = guildInvite;
        this.this$0 = widgetGuildInviteShareSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteSettings.Companion companion = WidgetGuildInviteSettings.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ActivityResultLauncher<Intent> activityResultLauncherAccess$getGuildInviteSettingsLauncher$p = WidgetGuildInviteShareSheet.access$getGuildInviteSettingsLauncher$p(this.this$0);
        GuildInvite guildInvite = this.$invite;
        companion.launch(contextRequireContext, activityResultLauncherAccess$getGuildInviteSettingsLauncher$p, guildInvite != null ? guildInvite.getChannelId() : null, WidgetGuildInviteShareSheet.access$getViewModel$p(this.this$0).getGuildId(), "Instant Invite Action Sheet");
    }
}
