package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserRegistration;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.analytics.utils.RegistrationSteps;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthRegisterAccountInformation.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation5 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetAuthRegisterAccountInformation5 INSTANCE = new WidgetAuthRegisterAccountInformation5();

    public WidgetAuthRegisterAccountInformation5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserRegistration trackImpressionUserRegistration = new TrackImpressionUserRegistration(RegistrationSteps.ACCOUNT_INFORMATION);
        trackImpressionUserRegistration.m7528e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_REGISTRATION_FLOW, 7));
        return trackImpressionUserRegistration;
    }
}
