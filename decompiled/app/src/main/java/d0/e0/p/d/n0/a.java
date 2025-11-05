package d0.e0.p.d.n0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ConsPStack.java */
/* loaded from: classes3.dex */
public final class a<E> implements Iterable<E> {
    public static final a<Object> j = new a<>();
    public final E k;
    public final a<E> l;
    public final int m;

    /* compiled from: ConsPStack.java */
    /* renamed from: d0.e0.p.d.n0.a$a, reason: collision with other inner class name */
    public static class C0592a<E> implements Iterator<E> {
        public a<E> j;

        public C0592a(a<E> aVar) {
            this.j = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.m > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.j;
            E e = aVar.k;
            this.j = aVar.l;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public a() {
        this.m = 0;
        this.k = null;
        this.l = null;
    }

    public static <E> a<E> empty() {
        return (a<E>) j;
    }

    public final a<E> c(Object obj) {
        if (this.m == 0) {
            return this;
        }
        if (this.k.equals(obj)) {
            return this.l;
        }
        a<E> aVarC = this.l.c(obj);
        return aVarC == this.l ? this : new a<>(this.k, aVarC);
    }

    public final a<E> d(int i) {
        if (i < 0 || i > this.m) {
            throw new IndexOutOfBoundsException();
        }
        return i == 0 ? this : this.l.d(i - 1);
    }

    public E get(int i) {
        if (i < 0 || i > this.m) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return new C0592a(d(i)).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.q("Index: ", i));
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C0592a(d(0));
    }

    public a<E> minus(int i) {
        return c(get(i));
    }

    public a<E> plus(E e) {
        return new a<>(e, this);
    }

    public int size() {
        return this.m;
    }

    public a(E e, a<E> aVar) {
        this.k = e;
        this.l = aVar;
        this.m = aVar.m + 1;
    }
}
