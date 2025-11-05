package d0.f0;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes3.dex */
public class l {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class a<T> implements Sequence<T> {
        public final /* synthetic */ Function2 a;

        public a(Function2 function2) {
            this.a = function2;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return l.iterator(this.a);
        }
    }

    public static final <T> Iterator<T> iterator(Function2<? super k<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        d0.z.d.m.checkNotNullParameter(function2, "block");
        j jVar = new j();
        jVar.setNextStep(d0.w.h.b.createCoroutineUnintercepted(function2, jVar, jVar));
        return jVar;
    }

    public static final <T> Sequence<T> sequence(Function2<? super k<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        d0.z.d.m.checkNotNullParameter(function2, "block");
        return new a(function2);
    }
}
