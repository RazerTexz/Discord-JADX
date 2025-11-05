package d0.t;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbstractList.kt */
/* loaded from: classes3.dex */
public abstract class c<E> extends d0.t.a<E> implements List<E>, d0.z.d.g0.a {
    public static final a j = new a(null);

    /* compiled from: AbstractList.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void checkElementIndex$kotlin_stdlib(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(b.d.b.a.a.s("index: ", i, ", size: ", i2));
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException(b.d.b.a.a.s("index: ", i, ", size: ", i2));
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                StringBuilder sbW = b.d.b.a.a.W("fromIndex: ", i, ", toIndex: ", i2, ", size: ");
                sbW.append(i3);
                throw new IndexOutOfBoundsException(sbW.toString());
            }
            if (i > i2) {
                throw new IllegalArgumentException(b.d.b.a.a.s("fromIndex: ", i, " > toIndex: ", i2));
            }
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> collection, Collection<?> collection2) {
            d0.z.d.m.checkNotNullParameter(collection, "c");
            d0.z.d.m.checkNotNullParameter(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!d0.z.d.m.areEqual(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> collection) {
            d0.z.d.m.checkNotNullParameter(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }
    }

    /* compiled from: AbstractList.kt */
    public class b implements Iterator<E>, d0.z.d.g0.a {
        public int j;

        public b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j < c.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            c cVar = c.this;
            int i = this.j;
            this.j = i + 1;
            return (E) cVar.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: d0.t.c$c, reason: collision with other inner class name */
    public class C0595c extends c<E>.b implements ListIterator<E>, d0.z.d.g0.a {
        public C0595c(int i) {
            super();
            c.j.checkPositionIndex$kotlin_stdlib(i, c.this.size());
            this.j = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.j > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.j;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            c cVar = c.this;
            int i = this.j - 1;
            this.j = i;
            return (E) cVar.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.j - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    public static final class d<E> extends c<E> implements RandomAccess {
        public int k;
        public final c<E> l;
        public final int m;

        /* JADX WARN: Multi-variable type inference failed */
        public d(c<? extends E> cVar, int i, int i2) {
            d0.z.d.m.checkNotNullParameter(cVar, "list");
            this.l = cVar;
            this.m = i;
            c.j.checkRangeIndexes$kotlin_stdlib(i, i2, cVar.size());
            this.k = i2 - i;
        }

        @Override // d0.t.c, java.util.List
        public E get(int i) {
            c.j.checkElementIndex$kotlin_stdlib(i, this.k);
            return this.l.get(this.m + i);
        }

        @Override // d0.t.a
        public int getSize() {
            return this.k;
        }
    }

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return j.orderedEquals$kotlin_stdlib(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return j.orderedHashCode$kotlin_stdlib(this);
    }

    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (d0.z.d.m.areEqual(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (d0.z.d.m.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new C0595c(0);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new d(this, i, i2);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new C0595c(i);
    }
}
