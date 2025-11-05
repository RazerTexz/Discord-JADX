package com.discord.widgets.chat.list;

import android.view.View;
import com.discord.widgets.chat.list.InlineMediaView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.d2.e;

/* compiled from: Collect.kt */
/* loaded from: classes2.dex */
public final class InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1 implements e<Boolean> {
    public final /* synthetic */ InlineMediaView.AnonymousClass1 this$0;

    public InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1(InlineMediaView.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // s.a.d2.e
    public Object emit(Boolean bool, Continuation continuation) {
        Boolean bool2 = bool;
        View view = InlineMediaView.access$getBinding$p(InlineMediaView.this).h;
        m.checkNotNullExpressionValue(view, "binding.opacityShim");
        m.checkNotNullExpressionValue(bool2, "isAnyPanelOpen");
        view.setVisibility(bool2.booleanValue() ? 0 : 8);
        return Unit.a;
    }
}
