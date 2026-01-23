package com.discord.widgets.guilds.invite;

import android.view.View;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$1 */
/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC8697xdc893a07 implements View.OnClickListener {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ GuildInviteShareSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public ViewOnClickListenerC8697xdc893a07(GuildInvite guildInvite, WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, GuildInviteShareSheetViewModel.ViewState viewState) {
        this.$invite = guildInvite;
        this.this$0 = widgetGuildInviteShareSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.$invite != null) {
            GuildInviteUiHelper.copyLinkClick(outline.m885x(view, "it", "it.context"), this.$invite, this.$viewState$inlined.getChannel(), WidgetGuildInviteShareSheet.access$getAnalyticsSource$p(this.this$0));
        }
    }
}
