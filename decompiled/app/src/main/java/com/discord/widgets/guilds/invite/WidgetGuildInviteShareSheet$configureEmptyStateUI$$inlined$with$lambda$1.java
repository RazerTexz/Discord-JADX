package com.discord.widgets.guilds.invite;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;

/* compiled from: WidgetGuildInviteShareSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ GuildInviteShareSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$1(GuildInvite guildInvite, WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, GuildInviteShareSheetViewModel.ViewState viewState) {
        this.$invite = guildInvite;
        this.this$0 = widgetGuildInviteShareSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.$invite != null) {
            GuildInviteUiHelper.copyLinkClick(outline.x(view, "it", "it.context"), this.$invite, this.$viewState$inlined.getChannel(), WidgetGuildInviteShareSheet.access$getAnalyticsSource$p(this.this$0));
        }
    }
}
