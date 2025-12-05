package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsChannels;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsChannels.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannels6 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsChannels6 INSTANCE = new WidgetServerSettingsChannels6();

    public WidgetServerSettingsChannels6() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsChannels();
    }
}
