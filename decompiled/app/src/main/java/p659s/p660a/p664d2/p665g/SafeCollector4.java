package p659s.p660a.p664d2.p665g;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.InlineMarker;
import p507d0.p592z.p594d.TypeIntrinsics;
import p659s.p660a.p664d2.FlowCollector;

/* compiled from: SafeCollector.kt */
/* renamed from: s.a.d2.g.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class SafeCollector4 {

    /* renamed from: a */
    public static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> f27792a = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new a(), 3);

    /* compiled from: SafeCollector.kt */
    /* renamed from: s.a.d2.g.f$a */
    public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function3<FlowCollector<? super Object>, Object, Continuation<? super Unit>, Object> {
        public a() {
            super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public Object invoke(FlowCollector<? super Object> flowCollector, Object obj, Continuation<? super Unit> continuation) {
            InlineMarker.mark(0);
            Object objEmit = flowCollector.emit(obj, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            return objEmit;
        }
    }
}
