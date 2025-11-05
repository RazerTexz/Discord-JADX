package com.discord.widgets.guilds.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChangeGuildIdentity.kt */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$imageSelectedResult$1 extends o implements Function1<String, Unit> {
    public static final WidgetChangeGuildIdentity$imageSelectedResult$1 INSTANCE = new WidgetChangeGuildIdentity$imageSelectedResult$1();

    public WidgetChangeGuildIdentity$imageSelectedResult$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "it");
    }
}
