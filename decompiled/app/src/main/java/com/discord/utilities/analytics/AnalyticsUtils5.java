package com.discord.utilities.analytics;

import com.discord.utilities.analytics.AnalyticsUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.analytics.AnalyticsUtils$Tracker$track$1, reason: use source file name */
/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils5 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ AnalyticsUtils.Tracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsUtils5(AnalyticsUtils.Tracker tracker) {
        super(1);
        this.this$0 = tracker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        AnalyticsUtils.Tracker.access$drainEventsQueue(this.this$0);
    }
}
