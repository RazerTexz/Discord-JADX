package p007b.p109f.p161j.p168c;

import p007b.p109f.p161j.p168c.CountingMemoryCache;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: b.f.j.c.u, reason: use source file name */
/* JADX INFO: compiled from: LruCountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class LruCountingMemoryCache<K, V> implements ValueDescriptor<CountingMemoryCache.a<K, V>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ValueDescriptor f3690a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LruCountingMemoryCache2 f3691b;

    public LruCountingMemoryCache(LruCountingMemoryCache2 lruCountingMemoryCache2, ValueDescriptor valueDescriptor) {
        this.f3691b = lruCountingMemoryCache2;
        this.f3690a = valueDescriptor;
    }

    @Override // p007b.p109f.p161j.p168c.ValueDescriptor
    /* JADX INFO: renamed from: a */
    public int mo1212a(Object obj) {
        CountingMemoryCache.a aVar = (CountingMemoryCache.a) obj;
        return this.f3691b.f3699h ? aVar.f3683f : this.f3690a.mo1212a(aVar.f3679b.m8642u());
    }
}
