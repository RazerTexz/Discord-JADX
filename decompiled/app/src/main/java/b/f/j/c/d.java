package b.f.j.c;

import java.util.LinkedHashSet;

/* compiled from: BoundedLinkedHashSet.java */
/* loaded from: classes.dex */
public class d<E> {
    public int a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashSet<E> f554b;

    public d(int i) {
        this.f554b = new LinkedHashSet<>(i);
        this.a = i;
    }

    public synchronized boolean a(E e) {
        if (this.f554b.size() == this.a) {
            LinkedHashSet<E> linkedHashSet = this.f554b;
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        this.f554b.remove(e);
        return this.f554b.add(e);
    }

    public synchronized boolean b(E e) {
        return this.f554b.contains(e);
    }
}
