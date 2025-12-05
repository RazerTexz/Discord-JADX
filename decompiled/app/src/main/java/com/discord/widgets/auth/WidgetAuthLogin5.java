package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserLogin;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthLogin.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthLogin$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLogin5 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetAuthLogin5 INSTANCE = new WidgetAuthLogin5();

    public WidgetAuthLogin5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserLogin trackImpressionUserLogin = new TrackImpressionUserLogin(null, 1);
        trackImpressionUserLogin.m7527e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_LOGIN_FLOW, 7));
        return trackImpressionUserLogin;
    }
}
