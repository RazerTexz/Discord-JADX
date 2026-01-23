package com.discord.widgets.nux;

import com.discord.analytics.generated.events.impression.TrackImpressionHubCreateGuildTemplate;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.nux.WidgetHubGuildTemplates$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildTemplates7 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetGuildTemplates7 INSTANCE = new WidgetGuildTemplates7();

    public WidgetGuildTemplates7() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionHubCreateGuildTemplate();
    }
}
