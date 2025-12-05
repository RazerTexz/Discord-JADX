package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: Sequences.kt */
/* renamed from: d0.f0.i */
/* loaded from: classes3.dex */
public final class C12070i<T> implements Sequence<T> {

    /* renamed from: a */
    public final Function0<T> f25095a;

    /* renamed from: b */
    public final Function1<T, T> f25096b;

    /* compiled from: Sequences.kt */
    /* renamed from: d0.f0.i$a */
    public static final class a implements Iterator<T>, KMarkers {

        /* renamed from: j */
        public T f25097j;

        /* renamed from: k */
        public int f25098k = -2;

        public a() {
        }

        /* renamed from: a */
        public final void m10063a() {
            T t;
            if (this.f25098k == -2) {
                t = (T) C12070i.access$getGetInitialValue$p(C12070i.this).invoke();
            } else {
                Function1 function1Access$getGetNextValue$p = C12070i.access$getGetNextValue$p(C12070i.this);
                T t2 = this.f25097j;
                Intrinsics3.checkNotNull(t2);
                t = (T) function1Access$getGetNextValue$p.invoke(t2);
            }
            this.f25097j = t;
            this.f25098k = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25098k < 0) {
                m10063a();
            }
            return this.f25098k == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f25098k < 0) {
                m10063a();
            }
            if (this.f25098k == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f25097j;
            Objects.requireNonNull(t, "null cannot be cast to non-null type T");
            this.f25098k = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12070i(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics3.checkNotNullParameter(function0, "getInitialValue");
        Intrinsics3.checkNotNullParameter(function1, "getNextValue");
        this.f25095a = function0;
        this.f25096b = function1;
    }

    public static final /* synthetic */ Function0 access$getGetInitialValue$p(C12070i c12070i) {
        return c12070i.f25095a;
    }

    public static final /* synthetic */ Function1 access$getGetNextValue$p(C12070i c12070i) {
        return c12070i.f25096b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }
}
