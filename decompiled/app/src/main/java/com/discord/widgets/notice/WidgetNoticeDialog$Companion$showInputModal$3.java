package com.discord.widgets.notice;

import android.view.View;
import com.discord.R;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNoticeDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetNoticeDialog$Companion$showInputModal$3 extends o implements Function1<View, Unit> {
    public final /* synthetic */ CharSequence $hintText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeDialog$Companion$showInputModal$3(CharSequence charSequence) {
        super(1);
        this.$hintText = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        View viewFindViewById = view.findViewById(R.id.view_input);
        m.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextIn…tLayout>(R.id.view_input)");
        ((TextInputLayout) viewFindViewById).setHint(this.$hintText);
    }
}
