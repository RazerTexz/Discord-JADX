package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* JADX INFO: renamed from: d0.f0.t */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12081t<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a */
    public final Sequence<T> f25126a;

    /* JADX INFO: renamed from: b */
    public final Function1<T, Boolean> f25127b;

    /* JADX INFO: renamed from: d0.f0.t$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, KMarkers {

        /* JADX INFO: renamed from: j */
        public final Iterator<T> f25128j;

        /* JADX INFO: renamed from: k */
        public int f25129k = -1;

        /* JADX INFO: renamed from: l */
        public T f25130l;

        public a() {
            this.f25128j = C12081t.access$getSequence$p(C12081t.this).iterator();
        }

        /* JADX INFO: renamed from: a */
        public final void m10066a() {
            if (this.f25128j.hasNext()) {
                T next = this.f25128j.next();
                if (((Boolean) C12081t.access$getPredicate$p(C12081t.this).invoke(next)).booleanValue()) {
                    this.f25129k = 1;
                    this.f25130l = next;
                    return;
                }
            }
            this.f25129k = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25129k == -1) {
                m10066a();
            }
            return this.f25129k == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f25129k == -1) {
                m10066a();
            }
            if (this.f25129k == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f25130l;
            this.f25130l = null;
            this.f25129k = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12081t(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        this.f25126a = sequence;
        this.f25127b = function1;
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(C12081t c12081t) {
        return c12081t.f25127b;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(C12081t c12081t) {
        return c12081t.f25126a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }
}
