package com.discord.widgets.notice;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNoticeDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetNoticeDialog$Builder$setPositiveButton$1 extends Lambda implements Function1<View, Unit> {
    public static final WidgetNoticeDialog$Builder$setPositiveButton$1 INSTANCE = new WidgetNoticeDialog$Builder$setPositiveButton$1();

    public WidgetNoticeDialog$Builder$setPositiveButton$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
    }
}
