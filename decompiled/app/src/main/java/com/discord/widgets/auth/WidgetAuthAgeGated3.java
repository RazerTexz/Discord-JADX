package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserAgeGateUnderage;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthAgeGated.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthAgeGated$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthAgeGated3 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetAuthAgeGated3 INSTANCE = new WidgetAuthAgeGated3();

    public WidgetAuthAgeGated3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserAgeGateUnderage trackImpressionUserAgeGateUnderage = new TrackImpressionUserAgeGateUnderage(Boolean.valueOf(StoreStream.INSTANCE.getUsers().getMeSnapshot().getId() > 0));
        trackImpressionUserAgeGateUnderage.m7526e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_REGISTRATION_FLOW, 7));
        return trackImpressionUserAgeGateUnderage;
    }
}
