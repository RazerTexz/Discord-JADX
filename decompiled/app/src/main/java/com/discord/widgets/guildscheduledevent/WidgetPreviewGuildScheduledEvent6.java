package com.discord.widgets.guildscheduledevent;

import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent6 extends Lambda implements Function0<PreviewGuildScheduledEventViewModel> {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPreviewGuildScheduledEvent6(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        super(0);
        this.this$0 = widgetPreviewGuildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PreviewGuildScheduledEventViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PreviewGuildScheduledEventViewModel invoke() {
        return new PreviewGuildScheduledEventViewModel(WidgetPreviewGuildScheduledEvent.access$getEventModel$p(this.this$0), (WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData) this.this$0.getMostRecentIntent().getSerializableExtra("INTENT_EXTRA_EXISTING_EVENT_DATA"), null, null, null, 28, null);
    }
}
