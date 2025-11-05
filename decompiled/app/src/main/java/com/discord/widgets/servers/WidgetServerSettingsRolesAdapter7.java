package com.discord.widgets.servers;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsRolesAdapter.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$roleDropListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter7 extends Lambda implements Function1<Map<String, ? extends Integer>, Unit> {
    public static final WidgetServerSettingsRolesAdapter7 INSTANCE = new WidgetServerSettingsRolesAdapter7();

    public WidgetServerSettingsRolesAdapter7() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Integer> map) {
        invoke2((Map<String, Integer>) map);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Integer> map) {
        Intrinsics3.checkNotNullParameter(map, "it");
    }
}
