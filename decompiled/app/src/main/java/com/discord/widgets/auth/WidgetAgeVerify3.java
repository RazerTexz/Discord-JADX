package com.discord.widgets.auth;

import com.discord.widgets.auth.WidgetAgeVerify;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureBirthdayInput$1$$special$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify3 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAgeVerify.C71531 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerify3(WidgetAgeVerify.C71531 c71531) {
        super(1);
        this.this$0 = c71531;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.f27425a;
    }

    public final void invoke(long j) {
        WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).setDateOfBirth(j);
    }
}
