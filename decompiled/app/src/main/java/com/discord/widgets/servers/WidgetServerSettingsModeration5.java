package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsModeration;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsModeration5 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsModeration5 INSTANCE = new WidgetServerSettingsModeration5();

    public WidgetServerSettingsModeration5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsModeration();
    }
}
