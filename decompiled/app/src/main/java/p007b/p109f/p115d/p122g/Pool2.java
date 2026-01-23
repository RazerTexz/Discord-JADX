package p007b.p109f.p115d.p122g;

import p007b.p109f.p115d.p123h.ResourceReleaser;

/* JADX INFO: renamed from: b.f.d.g.e, reason: use source file name */
/* JADX INFO: compiled from: Pool.java */
/* JADX INFO: loaded from: classes.dex */
public interface Pool2<V> extends ResourceReleaser<V>, MemoryTrimmable {
    V get(int i);

    @Override // p007b.p109f.p115d.p123h.ResourceReleaser
    void release(V v);
}
