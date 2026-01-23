package com.discord.widgets.servers.settings.members;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsMembers;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsMembers4 INSTANCE = new WidgetServerSettingsMembers4();

    public WidgetServerSettingsMembers4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsMembers();
    }
}
