package p507d0.p578f0;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SequenceBuilder.kt */
/* renamed from: d0.f0.l, reason: use source file name */
/* loaded from: classes3.dex */
public class SequenceBuilder3 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: d0.f0.l$a */
    public static final class a<T> implements Sequence<T> {

        /* renamed from: a */
        public final /* synthetic */ Function2 f25104a;

        public a(Function2 function2) {
            this.f25104a = function2;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return SequenceBuilder3.iterator(this.f25104a);
        }
    }

    public static final <T> Iterator<T> iterator(Function2<? super SequenceBuilder2<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(function2, "block");
        SequenceBuilder sequenceBuilder = new SequenceBuilder();
        sequenceBuilder.setNextStep(IntrinsicsJvm.createCoroutineUnintercepted(function2, sequenceBuilder, sequenceBuilder));
        return sequenceBuilder;
    }

    public static final <T> Sequence<T> sequence(Function2<? super SequenceBuilder2<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(function2, "block");
        return new a(function2);
    }
}
