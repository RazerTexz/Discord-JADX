package b.f.j.c;

import b.f.j.c.m;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCountingMemoryCache.java */
/* loaded from: classes.dex */
public class u<K, V> implements b0<m.a<K, V>> {
    public final /* synthetic */ b0 a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f560b;

    public u(v vVar, b0 b0Var) {
        this.f560b = vVar;
        this.a = b0Var;
    }

    @Override // b.f.j.c.b0
    public int a(Object obj) {
        m.a aVar = (m.a) obj;
        return this.f560b.h ? aVar.f : this.a.a(aVar.f558b.u());
    }
}
