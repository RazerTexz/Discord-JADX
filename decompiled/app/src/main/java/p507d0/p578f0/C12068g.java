package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: Sequences.kt */
/* renamed from: d0.f0.g */
/* loaded from: classes3.dex */
public final class C12068g<T> implements Sequence<T> {

    /* renamed from: a */
    public final Sequence<T> f25082a;

    /* renamed from: b */
    public final boolean f25083b;

    /* renamed from: c */
    public final Function1<T, Boolean> f25084c;

    /* compiled from: Sequences.kt */
    /* renamed from: d0.f0.g$a */
    public static final class a implements Iterator<T>, KMarkers {

        /* renamed from: j */
        public final Iterator<T> f25085j;

        /* renamed from: k */
        public int f25086k = -1;

        /* renamed from: l */
        public T f25087l;

        public a() {
            this.f25085j = C12068g.access$getSequence$p(C12068g.this).iterator();
        }

        /* renamed from: a */
        public final void m10061a() {
            while (this.f25085j.hasNext()) {
                T next = this.f25085j.next();
                if (((Boolean) C12068g.access$getPredicate$p(C12068g.this).invoke(next)).booleanValue() == C12068g.access$getSendWhen$p(C12068g.this)) {
                    this.f25087l = next;
                    this.f25086k = 1;
                    return;
                }
            }
            this.f25086k = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25086k == -1) {
                m10061a();
            }
            return this.f25086k == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f25086k == -1) {
                m10061a();
            }
            if (this.f25086k == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f25087l;
            this.f25087l = null;
            this.f25086k = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12068g(Sequence<? extends T> sequence, boolean z2, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        this.f25082a = sequence;
        this.f25083b = z2;
        this.f25084c = function1;
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(C12068g c12068g) {
        return c12068g.f25084c;
    }

    public static final /* synthetic */ boolean access$getSendWhen$p(C12068g c12068g) {
        return c12068g.f25083b;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(C12068g c12068g) {
        return c12068g.f25082a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }
}
