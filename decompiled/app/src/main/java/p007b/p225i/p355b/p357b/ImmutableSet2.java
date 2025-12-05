package p007b.p225i.p355b.p357b;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: ImmutableSet.java */
/* renamed from: b.i.b.b.r, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ImmutableSet2<E> extends ImmutableCollection<E> implements Set<E> {

    /* renamed from: k */
    public static final /* synthetic */ int f12057k = 0;

    /* renamed from: l */
    @RetainedWith
    @NullableDecl
    @LazyInit
    public transient ImmutableList2<E> f12058l;

    /* compiled from: ImmutableSet.java */
    /* renamed from: b.i.b.b.r$a */
    public static class a implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public a(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet2.m6282n(this.elements);
        }
    }

    /* renamed from: k */
    public static int m6279k(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return BasicMeasure.EXACTLY;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (iHighestOneBit * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* renamed from: l */
    public static <E> ImmutableSet2<E> m6280l(int i, Object... objArr) {
        if (i == 0) {
            return RegularImmutableSet.f12032m;
        }
        if (i == 1) {
            return new SingletonImmutableSet(objArr[0]);
        }
        int iM6279k = m6279k(i);
        Object[] objArr2 = new Object[iM6279k];
        int i2 = iM6279k - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            C3404f.m4363y(obj, i5);
            int iHashCode = obj.hashCode();
            int iM4277c1 = C3404f.m4277c1(iHashCode);
            while (true) {
                int i6 = iM4277c1 & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iM4277c1++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new SingletonImmutableSet(objArr[0], i3);
        }
        if (m6279k(i4) < iM6279k / 2) {
            return m6280l(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new RegularImmutableSet(objArr, i3, objArr2, i2, i4);
    }

    /* renamed from: m */
    public static <E> ImmutableSet2<E> m6281m(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet2) && !(collection instanceof SortedSet)) {
            ImmutableSet2<E> immutableSet2 = (ImmutableSet2) collection;
            if (!immutableSet2.mo6246i()) {
                return immutableSet2;
            }
        }
        Object[] array = collection.toArray();
        return m6280l(array.length, array);
    }

    /* renamed from: n */
    public static <E> ImmutableSet2<E> m6282n(E[] eArr) {
        int length = eArr.length;
        return length != 0 ? length != 1 ? m6280l(eArr.length, (Object[]) eArr.clone()) : new SingletonImmutableSet(eArr[0]) : RegularImmutableSet.f12032m;
    }

    /* renamed from: r */
    public static <E> ImmutableSet2<E> m6283r(E e, E e2, E e3) {
        return m6280l(3, e, e2, e3);
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: c */
    public ImmutableList2<E> mo6253c() {
        ImmutableList2<E> immutableList2 = this.f12058l;
        if (immutableList2 != null) {
            return immutableList2;
        }
        ImmutableList2<E> immutableList2Mo6252o = mo6252o();
        this.f12058l = immutableList2Mo6252o;
        return immutableList2Mo6252o;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet2) && mo6278p() && ((ImmutableSet2) obj).mo6278p() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Collections2.m6238a(this);
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return mo6251j();
    }

    /* renamed from: o */
    public ImmutableList2<E> mo6252o() {
        return ImmutableList2.m6261k(toArray());
    }

    /* renamed from: p */
    public boolean mo6278p() {
        return this instanceof RegularImmutableSet;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    public Object writeReplace() {
        return new a(toArray());
    }
}
