package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserWelcome;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthLanding.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthLanding$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLanding3 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetAuthLanding3 INSTANCE = new WidgetAuthLanding3();

    public WidgetAuthLanding3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionUserWelcome();
    }
}
