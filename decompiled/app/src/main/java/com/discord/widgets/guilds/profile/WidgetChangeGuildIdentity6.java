package com.discord.widgets.guilds.profile;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChangeGuildIdentity.kt */
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$imageSelectedResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity6 extends Lambda implements Function1<String, Unit> {
    public static final WidgetChangeGuildIdentity6 INSTANCE = new WidgetChangeGuildIdentity6();

    public WidgetChangeGuildIdentity6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
    }
}
