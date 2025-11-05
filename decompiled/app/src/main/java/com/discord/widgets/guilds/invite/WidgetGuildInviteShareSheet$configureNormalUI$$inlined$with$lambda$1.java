package com.discord.widgets.guilds.invite;

import android.content.res.Resources;
import android.view.View;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;

/* compiled from: WidgetGuildInviteShareSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ String $searchQuery$inlined;
    public final /* synthetic */ GuildInviteShareSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$1(GuildInvite guildInvite, WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, String str, GuildInviteShareSheetViewModel.ViewState viewState) {
        this.$invite = guildInvite;
        this.this$0 = widgetGuildInviteShareSheet;
        this.$searchQuery$inlined = str;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        GuildInviteUiHelper.shareLinkClick(this.this$0.getContext(), this.$invite, this.$viewState$inlined.getChannel());
    }
}
