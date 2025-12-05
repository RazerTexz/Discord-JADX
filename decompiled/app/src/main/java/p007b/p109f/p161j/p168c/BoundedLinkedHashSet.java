package p007b.p109f.p161j.p168c;

import java.util.LinkedHashSet;

/* compiled from: BoundedLinkedHashSet.java */
/* renamed from: b.f.j.c.d, reason: use source file name */
/* loaded from: classes.dex */
public class BoundedLinkedHashSet<E> {

    /* renamed from: a */
    public int f3656a;

    /* renamed from: b */
    public LinkedHashSet<E> f3657b;

    public BoundedLinkedHashSet(int i) {
        this.f3657b = new LinkedHashSet<>(i);
        this.f3656a = i;
    }

    /* renamed from: a */
    public synchronized boolean m1213a(E e) {
        if (this.f3657b.size() == this.f3656a) {
            LinkedHashSet<E> linkedHashSet = this.f3657b;
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        this.f3657b.remove(e);
        return this.f3657b.add(e);
    }

    /* renamed from: b */
    public synchronized boolean m1214b(E e) {
        return this.f3657b.contains(e);
    }
}
