package com.discord.utilities.intent;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p512d0._Ranges;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.intent.StaticChannelRoutes$Companion$routeToName$2, reason: use source file name */
/* JADX INFO: compiled from: StaticChannelRoutes.kt */
/* JADX INFO: loaded from: classes2.dex */
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
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
