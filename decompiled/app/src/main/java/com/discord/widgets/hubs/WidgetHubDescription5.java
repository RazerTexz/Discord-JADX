package com.discord.widgets.hubs;

import com.discord.analytics.generated.events.impression.TrackImpressionHubCreateGuildCustomize;
import com.discord.analytics.generated.events.impression.TrackImpressionHubExistingGuildCustomize;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription5 extends Lambda implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription5(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return this.this$0.getArgs().isNewGuild() ? new TrackImpressionHubCreateGuildCustomize() : new TrackImpressionHubExistingGuildCustomize();
    }
}
