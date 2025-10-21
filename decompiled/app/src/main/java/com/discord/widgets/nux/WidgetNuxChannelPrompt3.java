package com.discord.widgets.nux;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildAddChannelPrompt;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetNuxChannelPrompt.kt */
/* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt3 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetNuxChannelPrompt3 INSTANCE = new WidgetNuxChannelPrompt3();

    public WidgetNuxChannelPrompt3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionGuildAddChannelPrompt trackImpressionGuildAddChannelPrompt = new TrackImpressionGuildAddChannelPrompt();
        trackImpressionGuildAddChannelPrompt.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.GUILD_ADD_FLOW, 7));
        return trackImpressionGuildAddChannelPrompt;
    }
}
