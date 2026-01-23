package com.discord.widgets.notice;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$Companion$showInputModal$2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Function0 $onCancelClicked;
    public final /* synthetic */ boolean $shouldHideKeyboard;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeDialog$Companion$showInputModal$2(Function0 function0, boolean z2) {
        super(1);
        this.$onCancelClicked = function0;
        this.$shouldHideKeyboard = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        this.$onCancelClicked.invoke();
        if (this.$shouldHideKeyboard) {
            CommonUtils.m6424r(view.getContext(), view);
        }
    }
}
