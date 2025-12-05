package com.discord.widgets.servers;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsVanityUrl.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$guildId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetServerSettingsVanityUrl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsVanityUrl4(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        super(0);
        this.this$0 = widgetServerSettingsVanityUrl;
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
