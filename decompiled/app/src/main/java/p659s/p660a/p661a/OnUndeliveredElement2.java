package p659s.p660a.p661a;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: s.a.a.o, reason: use source file name */
/* JADX INFO: compiled from: OnUndeliveredElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OnUndeliveredElement2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ Object $element;
    public final /* synthetic */ Function1 $this_bindCancellationFun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnUndeliveredElement2(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        super(1);
        this.$this_bindCancellationFun = function1;
        this.$element = obj;
        this.$context = coroutineContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Function1 function1 = this.$this_bindCancellationFun;
        Object obj = this.$element;
        CoroutineContext coroutineContext = this.$context;
        OnUndeliveredElement onUndeliveredElementM4327p = C3404f.m4327p(function1, obj, null);
        if (onUndeliveredElementM4327p != null) {
            C3404f.m4348u0(coroutineContext, onUndeliveredElementM4327p);
        }
        return Unit.f27425a;
    }
}
