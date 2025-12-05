package com.discord.widgets.servers;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$sam$rx_functions_Action1$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions3 implements Action1 {
    private final /* synthetic */ Function1 function;

    public WidgetServerSettingsInstantInvitesActions3(Function1 function1) {
        this.function = function1;
    }

    @Override // p658rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
