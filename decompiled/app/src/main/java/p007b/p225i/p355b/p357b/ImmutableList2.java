package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.ImmutableCollection;

/* compiled from: ImmutableList.java */
/* renamed from: b.i.b.b.p, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ImmutableList2<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: k */
    public static final AbstractIndexedListIterator<Object> f12045k = new b(RegularImmutableList.f12012l, 0);

    /* compiled from: ImmutableList.java */
    /* renamed from: b.i.b.b.p$a */
    public static final class a<E> extends ImmutableCollection.a<E> {
        public a() {
            super(4);
        }

        @CanIgnoreReturnValue
        /* renamed from: b */
        public a<E> m6271b(E e) {
            Objects.requireNonNull(e);
            int i = this.f12041b + 1;
            Object[] objArr = this.f12040a;
            if (objArr.length < i) {
                this.f12040a = Arrays.copyOf(objArr, ImmutableCollection.b.m6260a(objArr.length, i));
                this.f12042c = false;
            } else if (this.f12042c) {
                this.f12040a = (Object[]) objArr.clone();
                this.f12042c = false;
            }
            Object[] objArr2 = this.f12040a;
            int i2 = this.f12041b;
            this.f12041b = i2 + 1;
            objArr2[i2] = e;
            return this;
        }

        /* renamed from: c */
        public ImmutableList2<E> m6272c() {
            this.f12042c = true;
            return ImmutableList2.m6262l(this.f12040a, this.f12041b);
        }
    }

    /* compiled from: ImmutableList.java */
    /* renamed from: b.i.b.b.p$b */
    public static class b<E> extends AbstractIndexedListIterator<E> {

        /* renamed from: l */
        public final ImmutableList2<E> f12046l;

        public b(ImmutableList2<E> immutableList2, int i) {
            super(immutableList2.size(), i);
            this.f12046l = immutableList2;
        }
    }

    /* compiled from: ImmutableList.java */
    /* renamed from: b.i.b.b.p$c */
    public static class c implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public c(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableList2.m6265o(this.elements);
        }
    }

    /* compiled from: ImmutableList.java */
    /* renamed from: b.i.b.b.p$d */
    public class d extends ImmutableList2<E> {

        /* renamed from: l */
        public final transient int f12047l;

        /* renamed from: m */
        public final transient int f12048m;

        public d(int i, int i2) {
            this.f12047l = i;
            this.f12048m = i2;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: e */
        public Object[] mo6243e() {
            return ImmutableList2.this.mo6243e();
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: g */
        public int mo6244g() {
            return ImmutableList2.this.mo6245h() + this.f12047l + this.f12048m;
        }

        @Override // java.util.List
        public E get(int i) {
            C3404f.m4359x(i, this.f12048m);
            return ImmutableList2.this.get(i + this.f12047l);
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: h */
        public int mo6245h() {
            return ImmutableList2.this.mo6245h() + this.f12047l;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: i */
        public boolean mo6246i() {
            return true;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableList2, p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return m6268p();
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableList2, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return m6268p();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f12048m;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableList2, java.util.List
        public /* bridge */ /* synthetic */ List subList(int i, int i2) {
            return mo6270w(i, i2);
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableList2
        /* renamed from: w */
        public ImmutableList2<E> mo6270w(int i, int i2) {
            C3404f.m4198D(i, i2, this.f12048m);
            ImmutableList2 immutableList2 = ImmutableList2.this;
            int i3 = this.f12047l;
            return immutableList2.mo6270w(i + i3, i2 + i3);
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableList2, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return m6269r(i);
        }
    }

    /* renamed from: k */
    public static <E> ImmutableList2<E> m6261k(Object[] objArr) {
        return m6262l(objArr, objArr.length);
    }

    /* renamed from: l */
    public static <E> ImmutableList2<E> m6262l(Object[] objArr, int i) {
        return i == 0 ? (ImmutableList2<E>) RegularImmutableList.f12012l : new RegularImmutableList(objArr, i);
    }

    /* renamed from: m */
    public static <E> ImmutableList2<E> m6263m(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            C3404f.m4363y(objArr[i], i);
        }
        return m6262l(objArr, objArr.length);
    }

    /* renamed from: n */
    public static <E> ImmutableList2<E> m6264n(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return m6263m(collection.toArray());
        }
        ImmutableList2<E> immutableList2Mo6253c = ((ImmutableCollection) collection).mo6253c();
        return immutableList2Mo6253c.mo6246i() ? m6261k(immutableList2Mo6253c.toArray()) : immutableList2Mo6253c;
    }

    /* renamed from: o */
    public static <E> ImmutableList2<E> m6265o(E[] eArr) {
        return eArr.length == 0 ? (ImmutableList2<E>) RegularImmutableList.f12012l : m6263m((Object[]) eArr.clone());
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* renamed from: u */
    public static <E> ImmutableList2<E> m6266u(E e) {
        return m6263m(e);
    }

    /* renamed from: v */
    public static <E> ImmutableList2<E> m6267v(E e, E e2, E e3, E e4, E e5) {
        return m6263m(e, e2, e3, e4, e5);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: c */
    public final ImmutableList2<E> mo6253c() {
        return this;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: d */
    public int mo6242d(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            int size = size();
            if (size != list.size()) {
                return false;
            }
            if (!(list instanceof RandomAccess)) {
                Iterator<E> it = iterator();
                Iterator<E> it2 = list.iterator();
                while (it.hasNext()) {
                    if (!it2.hasNext() || !C3404f.m4252V(it.next(), it2.next())) {
                        return false;
                    }
                }
                return !it2.hasNext();
            }
            for (int i = 0; i < size; i++) {
                if (!C3404f.m4252V(get(i), list.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return m6268p();
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: j */
    public UnmodifiableIterator<E> mo6251j() {
        return m6268p();
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return m6268p();
    }

    /* renamed from: p */
    public AbstractIndexedListIterator<E> m6268p() {
        return m6269r(0);
    }

    /* renamed from: r */
    public AbstractIndexedListIterator<E> m6269r(int i) {
        C3404f.m4195C(i, size());
        return isEmpty() ? (AbstractIndexedListIterator<E>) f12045k : new b(this, i);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return mo6270w(i, i2);
    }

    /* renamed from: w */
    public ImmutableList2<E> mo6270w(int i, int i2) {
        C3404f.m4198D(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? (ImmutableList2<E>) RegularImmutableList.f12012l : new d(i, i3);
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    public Object writeReplace() {
        return new c(toArray());
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return m6269r(i);
    }
}
