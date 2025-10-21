package com.discord.widgets.hubs;

import com.discord.analytics.generated.events.impression.TrackImpressionHubExistingGuildChoose;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetHubAddServer.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddServer5 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetHubAddServer5 INSTANCE = new WidgetHubAddServer5();

    public WidgetHubAddServer5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionHubExistingGuildChoose();
    }
}
