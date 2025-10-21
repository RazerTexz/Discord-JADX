package com.discord.widgets.servers.settings.invites;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsInstantInvites.kt */
/* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$guildId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites6 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetServerSettingsInstantInvites this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsInstantInvites6(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites) {
        super(0);
        this.this$0 = widgetServerSettingsInstantInvites;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, -1L);
    }
}
