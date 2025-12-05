package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: Sequences.kt */
/* renamed from: d0.f0.s */
/* loaded from: classes3.dex */
public final class C12080s<T> implements Sequence<T>, InterfaceC12066e<T> {

    /* renamed from: a */
    public final Sequence<T> f25122a;

    /* renamed from: b */
    public final int f25123b;

    /* compiled from: Sequences.kt */
    /* renamed from: d0.f0.s$a */
    public static final class a implements Iterator<T>, KMarkers {

        /* renamed from: j */
        public int f25124j;

        /* renamed from: k */
        public final Iterator<T> f25125k;

        public a(C12080s c12080s) {
            this.f25124j = C12080s.access$getCount$p(c12080s);
            this.f25125k = C12080s.access$getSequence$p(c12080s).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25124j > 0 && this.f25125k.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.f25124j;
            if (i == 0) {
                throw new NoSuchElementException();
            }
            this.f25124j = i - 1;
            return this.f25125k.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12080s(Sequence<? extends T> sequence, int i) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        this.f25122a = sequence;
        this.f25123b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    public static final /* synthetic */ int access$getCount$p(C12080s c12080s) {
        return c12080s.f25123b;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(C12080s c12080s) {
        return c12080s.f25122a;
    }

    @Override // p507d0.p578f0.InterfaceC12066e
    public Sequence<T> drop(int i) {
        int i2 = this.f25123b;
        return i >= i2 ? C12075n.emptySequence() : new C12079r(this.f25122a, i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // p507d0.p578f0.InterfaceC12066e
    public Sequence<T> take(int i) {
        return i >= this.f25123b ? this : new C12080s(this.f25122a, i);
    }
}
