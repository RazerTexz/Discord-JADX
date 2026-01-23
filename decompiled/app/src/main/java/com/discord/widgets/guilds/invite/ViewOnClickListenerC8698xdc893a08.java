package com.discord.widgets.guilds.invite;

import android.view.View;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$2 */
/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC8698xdc893a08 implements View.OnClickListener {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ GuildInviteShareSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public ViewOnClickListenerC8698xdc893a08(GuildInvite guildInvite, WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, GuildInviteShareSheetViewModel.ViewState viewState) {
        this.$invite = guildInvite;
        this.this$0 = widgetGuildInviteShareSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.$invite != null) {
            GuildInviteUiHelper.shareLinkClick(this.this$0.getContext(), this.$invite, this.$viewState$inlined.getChannel());
        }
    }
}
