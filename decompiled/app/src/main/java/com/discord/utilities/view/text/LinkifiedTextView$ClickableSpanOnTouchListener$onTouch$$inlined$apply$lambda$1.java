package com.discord.utilities.view.text;

import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* compiled from: LinkifiedTextView.kt */
/* loaded from: classes2.dex */
public final class LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$$inlined$apply$lambda$1 extends o implements Function1<Throwable, Unit> {
    public final /* synthetic */ Job $this_apply;
    public final /* synthetic */ LinkifiedTextView.ClickableSpanOnTouchListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$$inlined$apply$lambda$1(Job job, LinkifiedTextView.ClickableSpanOnTouchListener clickableSpanOnTouchListener) {
        super(1);
        this.$this_apply = job;
        this.this$0 = clickableSpanOnTouchListener;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        LinkifiedTextView.ClickableSpanOnTouchListener.access$getJob$p(this.this$0).weakCompareAndSet(this.$this_apply, null);
    }
}
