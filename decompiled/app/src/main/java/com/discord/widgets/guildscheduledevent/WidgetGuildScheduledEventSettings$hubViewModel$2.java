package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$hubViewModel$2 extends Lambda implements Function0<GuildScheduledEventDirectoryAssociationViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventSettings$hubViewModel$2(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(0);
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDirectoryAssociationViewModel invoke() {
        return new GuildScheduledEventDirectoryAssociationViewModel(WidgetGuildScheduledEventSettings.access$getGuildId$p(this.this$0), WidgetGuildScheduledEventSettings.access$getExistingGuildScheduledEventId$p(this.this$0), null, null, 12, null);
    }
}
