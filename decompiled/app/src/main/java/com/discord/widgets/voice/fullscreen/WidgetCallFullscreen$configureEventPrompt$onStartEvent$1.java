package com.discord.widgets.voice.fullscreen;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCallFullscreen.kt */
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$configureEventPrompt$onStartEvent$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ GuildScheduledEvent $startableEvent;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureEventPrompt$onStartEvent$1(WidgetCallFullscreen widgetCallFullscreen, GuildScheduledEvent guildScheduledEvent) {
        super(0);
        this.this$0 = widgetCallFullscreen;
        this.$startableEvent = guildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$startableEvent == null) {
            return;
        }
        WidgetPreviewGuildScheduledEvent.Companion.launch$default(WidgetPreviewGuildScheduledEvent.INSTANCE, this.this$0.requireContext(), GuildScheduledEventModel2.toModel(this.$startableEvent), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(this.$startableEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), null, false, 24, null);
    }
}
