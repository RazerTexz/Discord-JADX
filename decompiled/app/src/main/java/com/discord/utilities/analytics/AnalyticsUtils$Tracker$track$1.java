package com.discord.utilities.analytics;

import com.discord.utilities.analytics.AnalyticsUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AnalyticsUtils.kt */
/* loaded from: classes2.dex */
public final class AnalyticsUtils$Tracker$track$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ AnalyticsUtils.Tracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsUtils$Tracker$track$1(AnalyticsUtils.Tracker tracker) {
        super(1);
        this.this$0 = tracker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        AnalyticsUtils.Tracker.access$drainEventsQueue(this.this$0);
    }
}
