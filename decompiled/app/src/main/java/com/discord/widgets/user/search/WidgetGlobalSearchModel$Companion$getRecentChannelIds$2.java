package com.discord.widgets.user.search;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getRecentChannelIds$2 extends o implements Function1<Map.Entry<? extends Long, ? extends Long>, Long> {
    public static final WidgetGlobalSearchModel$Companion$getRecentChannelIds$2 INSTANCE = new WidgetGlobalSearchModel$Companion$getRecentChannelIds$2();

    public WidgetGlobalSearchModel$Companion$getRecentChannelIds$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends Long> entry) {
        return Long.valueOf(invoke2((Map.Entry<Long, Long>) entry));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(Map.Entry<Long, Long> entry) {
        m.checkNotNullParameter(entry, "it");
        return entry.getKey().longValue();
    }
}
