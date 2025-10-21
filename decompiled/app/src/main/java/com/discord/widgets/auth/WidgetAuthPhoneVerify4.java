package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserRegistration;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetAuthPhoneVerify.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetAuthPhoneVerify4 INSTANCE = new WidgetAuthPhoneVerify4();

    public WidgetAuthPhoneVerify4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserRegistration trackImpressionUserRegistration = new TrackImpressionUserRegistration(null);
        trackImpressionUserRegistration.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_REGISTRATION_FLOW, 7));
        return trackImpressionUserRegistration;
    }
}
