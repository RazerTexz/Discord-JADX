package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* compiled from: ImmutableCollection.java */
/* renamed from: b.i.b.b.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: j */
    public static final Object[] f12039j = new Object[0];

    /* compiled from: ImmutableCollection.java */
    /* renamed from: b.i.b.b.n$a */
    public static abstract class a<E> extends b<E> {

        /* renamed from: a */
        public Object[] f12040a;

        /* renamed from: b */
        public int f12041b;

        /* renamed from: c */
        public boolean f12042c;

        public a(int i) {
            C3404f.m4189A(i, "initialCapacity");
            this.f12040a = new Object[i];
            this.f12041b = 0;
        }
    }

    /* compiled from: ImmutableCollection.java */
    /* renamed from: b.i.b.b.n$b */
    public static abstract class b<E> {
        /* renamed from: a */
        public static int m6260a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i + (i >> 1) + 1;
            if (iHighestOneBit < i2) {
                iHighestOneBit = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    public ImmutableList2<E> mo6253c() {
        if (!isEmpty()) {
            return ImmutableList2.m6261k(toArray());
        }
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        return (ImmutableList2<E>) RegularImmutableList.f12012l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@NullableDecl Object obj);

    @CanIgnoreReturnValue
    /* renamed from: d */
    public int mo6242d(Object[] objArr, int i) {
        UnmodifiableIterator<E> unmodifiableIteratorMo6251j = mo6251j();
        while (unmodifiableIteratorMo6251j.hasNext()) {
            objArr[i] = unmodifiableIteratorMo6251j.next();
            i++;
        }
        return i;
    }

    /* renamed from: e */
    public Object[] mo6243e() {
        return null;
    }

    /* renamed from: g */
    public int mo6244g() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: h */
    public int mo6245h() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: i */
    public abstract boolean mo6246i();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return mo6251j();
    }

    /* renamed from: j */
    public abstract UnmodifiableIterator<E> mo6251j();

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f12039j);
    }

    public Object writeReplace() {
        return new ImmutableList2.c(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        Objects.requireNonNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrMo6243e = mo6243e();
            if (objArrMo6243e != null) {
                return (T[]) Arrays.copyOfRange(objArrMo6243e, mo6245h(), mo6244g(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        mo6242d(tArr, 0);
        return tArr;
    }
}
