package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: Sequences.kt */
/* renamed from: d0.f0.h */
/* loaded from: classes3.dex */
public final class C12069h<T, R, E> implements Sequence<E> {

    /* renamed from: a */
    public final Sequence<T> f25089a;

    /* renamed from: b */
    public final Function1<T, R> f25090b;

    /* renamed from: c */
    public final Function1<R, Iterator<E>> f25091c;

    /* compiled from: Sequences.kt */
    /* renamed from: d0.f0.h$a */
    public static final class a implements Iterator<E>, KMarkers {

        /* renamed from: j */
        public final Iterator<T> f25092j;

        /* renamed from: k */
        public Iterator<? extends E> f25093k;

        public a() {
            this.f25092j = C12069h.access$getSequence$p(C12069h.this).iterator();
        }

        /* renamed from: a */
        public final boolean m10062a() {
            Iterator<? extends E> it = this.f25093k;
            if (it != null && !it.hasNext()) {
                this.f25093k = null;
            }
            while (true) {
                if (this.f25093k != null) {
                    break;
                }
                if (!this.f25092j.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) C12069h.access$getIterator$p(C12069h.this).invoke(C12069h.access$getTransformer$p(C12069h.this).invoke(this.f25092j.next()));
                if (it2.hasNext()) {
                    this.f25093k = it2;
                    break;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return m10062a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!m10062a()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f25093k;
            Intrinsics3.checkNotNull(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12069h(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1, Function1<? super R, ? extends Iterator<? extends E>> function12) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        Intrinsics3.checkNotNullParameter(function1, "transformer");
        Intrinsics3.checkNotNullParameter(function12, "iterator");
        this.f25089a = sequence;
        this.f25090b = function1;
        this.f25091c = function12;
    }

    public static final /* synthetic */ Function1 access$getIterator$p(C12069h c12069h) {
        return c12069h.f25091c;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(C12069h c12069h) {
        return c12069h.f25089a;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(C12069h c12069h) {
        return c12069h.f25090b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new a();
    }
}
