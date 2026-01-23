package com.discord.widgets.guilds.invite;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$guildInviteSettingsLauncher$1 extends Lambda implements Function1<GuildInvite, Unit> {
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareSheet$guildInviteSettingsLauncher$1(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        super(1);
        this.this$0 = widgetGuildInviteShareSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildInvite guildInvite) {
        invoke2(guildInvite);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildInvite guildInvite) {
        Intrinsics3.checkNotNullParameter(guildInvite, "guildInvite");
        WidgetGuildInviteShareSheet.access$getViewModel$p(this.this$0).updateInvite(guildInvite);
    }
}
