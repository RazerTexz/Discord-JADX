package com.discord.widgets.contact_sync;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetContactSync.kt */
/* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$handleEvent$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetContactSync5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync5(WidgetContactSync widgetContactSync) {
        super(0);
        this.this$0 = widgetContactSync;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetContactSync.access$getViewModel$p(this.this$0).skip();
    }
}
