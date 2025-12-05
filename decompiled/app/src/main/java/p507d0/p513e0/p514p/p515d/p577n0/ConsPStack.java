package p507d0.p513e0.p514p.p515d.p577n0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: ConsPStack.java */
/* renamed from: d0.e0.p.d.n0.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class ConsPStack<E> implements Iterable<E> {

    /* renamed from: j */
    public static final ConsPStack<Object> f25018j = new ConsPStack<>();

    /* renamed from: k */
    public final E f25019k;

    /* renamed from: l */
    public final ConsPStack<E> f25020l;

    /* renamed from: m */
    public final int f25021m;

    /* compiled from: ConsPStack.java */
    /* renamed from: d0.e0.p.d.n0.a$a */
    public static class a<E> implements Iterator<E> {

        /* renamed from: j */
        public ConsPStack<E> f25022j;

        public a(ConsPStack<E> consPStack) {
            this.f25022j = consPStack;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25022j.f25021m > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            ConsPStack<E> consPStack = this.f25022j;
            E e = consPStack.f25019k;
            this.f25022j = consPStack.f25020l;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public ConsPStack() {
        this.f25021m = 0;
        this.f25019k = null;
        this.f25020l = null;
    }

    public static <E> ConsPStack<E> empty() {
        return (ConsPStack<E>) f25018j;
    }

    /* renamed from: c */
    public final ConsPStack<E> m10049c(Object obj) {
        if (this.f25021m == 0) {
            return this;
        }
        if (this.f25019k.equals(obj)) {
            return this.f25020l;
        }
        ConsPStack<E> consPStackM10049c = this.f25020l.m10049c(obj);
        return consPStackM10049c == this.f25020l ? this : new ConsPStack<>(this.f25019k, consPStackM10049c);
    }

    /* renamed from: d */
    public final ConsPStack<E> m10050d(int i) {
        if (i < 0 || i > this.f25021m) {
            throw new IndexOutOfBoundsException();
        }
        return i == 0 ? this : this.f25020l.m10050d(i - 1);
    }

    public E get(int i) {
        if (i < 0 || i > this.f25021m) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return new a(m10050d(i)).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException(outline.m871q("Index: ", i));
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new a(m10050d(0));
    }

    public ConsPStack<E> minus(int i) {
        return m10049c(get(i));
    }

    public ConsPStack<E> plus(E e) {
        return new ConsPStack<>(e, this);
    }

    public int size() {
        return this.f25021m;
    }

    public ConsPStack(E e, ConsPStack<E> consPStack) {
        this.f25019k = e;
        this.f25020l = consPStack;
        this.f25021m = consPStack.f25021m + 1;
    }
}
