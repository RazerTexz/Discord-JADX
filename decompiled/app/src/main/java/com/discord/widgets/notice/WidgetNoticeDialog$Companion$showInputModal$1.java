package com.discord.widgets.notice;

import android.content.Context;
import android.view.View;
import com.discord.C5419R;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetNoticeDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetNoticeDialog$Companion$showInputModal$1 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Function2 $onOKClicked;
    public final /* synthetic */ boolean $shouldHideKeyboard;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeDialog$Companion$showInputModal$1(Function2 function2, boolean z2) {
        super(1);
        this.$onOKClicked = function2;
        this.$shouldHideKeyboard = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Function2 function2 = this.$onOKClicked;
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        View viewFindViewById = view.findViewById(C5419R.id.view_input);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextIn…tLayout>(R.id.view_input)");
        function2.invoke(context, ViewExtensions.getTextOrEmpty((TextInputLayout) viewFindViewById));
        if (this.$shouldHideKeyboard) {
            CommonUtils.m6424r(view.getContext(), view);
        }
    }
}
