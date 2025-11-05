package com.discord.widgets.chat.list;

import android.view.View;
import com.discord.widgets.chat.list.InlineMediaView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.d2.FlowCollector;

/* compiled from: Collect.kt */
/* renamed from: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Collect2 implements FlowCollector<Boolean> {
    public final /* synthetic */ InlineMediaView.AnonymousClass1 this$0;

    public Collect2(InlineMediaView.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // s.a.d2.FlowCollector
    public Object emit(Boolean bool, Continuation continuation) {
        Boolean bool2 = bool;
        View view = InlineMediaView.access$getBinding$p(InlineMediaView.this).h;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.opacityShim");
        Intrinsics3.checkNotNullExpressionValue(bool2, "isAnyPanelOpen");
        view.setVisibility(bool2.booleanValue() ? 0 : 8);
        return Unit.a;
    }
}
