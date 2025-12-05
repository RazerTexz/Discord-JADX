package com.discord.widgets.servers.community;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsEnableCommunity;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsEnableCommunity.kt */
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunity$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunity3 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsEnableCommunity3 INSTANCE = new WidgetServerSettingsEnableCommunity3();

    public WidgetServerSettingsEnableCommunity3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsEnableCommunity();
    }
}
