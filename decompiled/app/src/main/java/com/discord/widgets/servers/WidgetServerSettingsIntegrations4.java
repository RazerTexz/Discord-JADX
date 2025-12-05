package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsIntegration;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsIntegrations.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrations$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrations4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsIntegrations4 INSTANCE = new WidgetServerSettingsIntegrations4();

    public WidgetServerSettingsIntegrations4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsIntegration();
    }
}
