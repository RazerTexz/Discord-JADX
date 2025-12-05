package p507d0.p578f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: Sequences.kt */
/* renamed from: d0.f0.u */
/* loaded from: classes3.dex */
public final class C12082u<T, R> implements Sequence<R> {

    /* renamed from: a */
    public final Sequence<T> f25132a;

    /* renamed from: b */
    public final Function1<T, R> f25133b;

    /* compiled from: Sequences.kt */
    /* renamed from: d0.f0.u$a */
    public static final class a implements Iterator<R>, KMarkers {

        /* renamed from: j */
        public final Iterator<T> f25134j;

        public a() {
            this.f25134j = C12082u.access$getSequence$p(C12082u.this).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25134j.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) C12082u.access$getTransformer$p(C12082u.this).invoke(this.f25134j.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12082u(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        Intrinsics3.checkNotNullParameter(function1, "transformer");
        this.f25132a = sequence;
        this.f25133b = function1;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(C12082u c12082u) {
        return c12082u.f25132a;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(C12082u c12082u) {
        return c12082u.f25133b;
    }

    public final <E> Sequence<E> flatten$kotlin_stdlib(Function1<? super R, ? extends Iterator<? extends E>> function1) {
        Intrinsics3.checkNotNullParameter(function1, "iterator");
        return new C12069h(this.f25132a, this.f25133b, function1);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new a();
    }
}
