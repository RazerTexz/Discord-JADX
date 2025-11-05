package s.a.d2.g;

import d0.z.d.e0;
import d0.z.d.k;
import d0.z.d.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
public final class f {
    public static final Function3<s.a.d2.e<Object>, Object, Continuation<? super Unit>, Object> a = (Function3) e0.beforeCheckcastToFunctionOfArity(new a(), 3);

    /* compiled from: SafeCollector.kt */
    public static final /* synthetic */ class a extends k implements Function3<s.a.d2.e<? super Object>, Object, Continuation<? super Unit>, Object> {
        public a() {
            super(3, s.a.d2.e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public Object invoke(s.a.d2.e<? super Object> eVar, Object obj, Continuation<? super Unit> continuation) {
            l.mark(0);
            Object objEmit = eVar.emit(obj, continuation);
            l.mark(2);
            l.mark(1);
            return objEmit;
        }
    }
}
