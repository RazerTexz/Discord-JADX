package com.discord.widgets.servers.community;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsCommunityOverview;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsCommunityOverview.kt */
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsCommunityOverview4 INSTANCE = new WidgetServerSettingsCommunityOverview4();

    public WidgetServerSettingsCommunityOverview4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsCommunityOverview();
    }
}
