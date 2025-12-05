package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsOverview;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsOverview.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsOverview7 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsOverview7 INSTANCE = new WidgetServerSettingsOverview7();

    public WidgetServerSettingsOverview7() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsOverview();
    }
}
