package com.discord.widgets.chat.list;

import android.view.View;
import com.discord.widgets.chat.list.InlineMediaView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.p664d2.FlowCollector;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1, reason: use source file name */
/* JADX INFO: compiled from: Collect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Collect2 implements FlowCollector<Boolean> {
    public final /* synthetic */ InlineMediaView.C79331 this$0;

    public Collect2(InlineMediaView.C79331 c79331) {
        this.this$0 = c79331;
    }

    @Override // p659s.p660a.p664d2.FlowCollector
    public Object emit(Boolean bool, Continuation continuation) {
        Boolean bool2 = bool;
        View view = InlineMediaView.access$getBinding$p(InlineMediaView.this).f15173h;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.opacityShim");
        Intrinsics3.checkNotNullExpressionValue(bool2, "isAnyPanelOpen");
        view.setVisibility(bool2.booleanValue() ? 0 : 8);
        return Unit.f27425a;
    }
}
