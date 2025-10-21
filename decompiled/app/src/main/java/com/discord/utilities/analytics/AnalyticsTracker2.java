package com.discord.utilities.analytics;

import com.discord.utilities.lifecycle.ApplicationProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: AnalyticsTracker.kt */
/* renamed from: com.discord.utilities.analytics.AnalyticsTracker$firebaseAnalytics$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsTracker2 extends Lambda implements Function0<FirebaseAnalytics> {
    public static final AnalyticsTracker2 INSTANCE = new AnalyticsTracker2();

    public AnalyticsTracker2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FirebaseAnalytics invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FirebaseAnalytics invoke() {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(ApplicationProvider.INSTANCE.get());
        Intrinsics3.checkNotNullExpressionValue(firebaseAnalytics, "FirebaseAnalytics.getIns…pplicationProvider.get())");
        return firebaseAnalytics;
    }
}
