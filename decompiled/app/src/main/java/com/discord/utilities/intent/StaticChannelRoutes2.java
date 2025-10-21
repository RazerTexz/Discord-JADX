package com.discord.utilities.intent;

import d0.d0._Ranges;
import d0.t.MapsJVM;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: StaticChannelRoutes.kt */
/* renamed from: com.discord.utilities.intent.StaticChannelRoutes$Companion$routeToName$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StaticChannelRoutes2 extends Lambda implements Function0<Map<String, ? extends StaticChannelRoutes>> {
    public static final StaticChannelRoutes2 INSTANCE = new StaticChannelRoutes2();

    public StaticChannelRoutes2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends StaticChannelRoutes> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends StaticChannelRoutes> invoke2() {
        StaticChannelRoutes[] staticChannelRoutesArrValues = StaticChannelRoutes.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(1), 16));
        for (int i = 0; i < 1; i++) {
            StaticChannelRoutes staticChannelRoutes = staticChannelRoutesArrValues[i];
            linkedHashMap.put(staticChannelRoutes.getRoute(), staticChannelRoutes);
        }
        return linkedHashMap;
    }
}
