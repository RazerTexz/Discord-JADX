package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserRegistration;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.analytics.utils.RegistrationSteps;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthRegisterIdentity.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity5 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetAuthRegisterIdentity5 INSTANCE = new WidgetAuthRegisterIdentity5();

    public WidgetAuthRegisterIdentity5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserRegistration trackImpressionUserRegistration = new TrackImpressionUserRegistration(RegistrationSteps.IDENTITY);
        trackImpressionUserRegistration.m7528e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_REGISTRATION_FLOW, 7));
        return trackImpressionUserRegistration;
    }
}
