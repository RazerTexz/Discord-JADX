package com.discord.widgets.guilds.profile;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$sam$rx_functions_Action1$0, reason: use source file name */
/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity7 implements Action1 {
    private final /* synthetic */ Function1 function;

    public WidgetChangeGuildIdentity7(Function1 function1) {
        this.function = function1;
    }

    @Override // p658rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
