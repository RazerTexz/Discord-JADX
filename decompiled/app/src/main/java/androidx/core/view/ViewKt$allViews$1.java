package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p507d0.Result3;
import p507d0.p578f0.SequenceBuilder2;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl5;
import p507d0.p584w.p586i.p587a.DebugMetadata;

/* compiled from: View.kt */
@DebugMetadata(m10084c = "androidx.core.view.ViewKt$allViews$1", m10085f = "View.kt", m10086l = {406, 408}, m10087m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super View>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, Continuation<? super ViewKt$allViews$1> continuation) {
        super(2, continuation);
        this.$this_allViews = view;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, continuation);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceBuilder2<? super View> sequenceBuilder2, Continuation<? super Unit> continuation) {
        return ((ViewKt$allViews$1) create(sequenceBuilder2, continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceBuilder2<? super View> sequenceBuilder2, Continuation<? super Unit> continuation) {
        return invoke2(sequenceBuilder2, continuation);
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceBuilder2 sequenceBuilder2;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            sequenceBuilder2 = (SequenceBuilder2) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = sequenceBuilder2;
            this.label = 1;
            if (sequenceBuilder2.yield(view, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                return Unit.f27425a;
            }
            sequenceBuilder2 = (SequenceBuilder2) this.L$0;
            Result3.throwOnFailure(obj);
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            Sequence<View> descendants = ViewGroup.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (sequenceBuilder2.yieldAll(descendants, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.f27425a;
    }
}
