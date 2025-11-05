package b.a.p;

import b.i.a.c.e3.b0.r;
import b.i.a.c.e3.l;
import b.i.a.c.e3.q;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import d0.z.d.m;

/* compiled from: CacheDataSourceFactory.kt */
/* loaded from: classes.dex */
public final class j implements l.a {
    public final q.a a;

    /* renamed from: b, reason: collision with root package name */
    public final long f253b;

    public j(q.a aVar, long j) {
        m.checkNotNullParameter(aVar, "defaultDatasourceFactory");
        this.a = aVar;
        this.f253b = j;
    }

    @Override // b.i.a.c.e3.l.a
    public b.i.a.c.e3.l a() {
        l lVar = l.f254b;
        r rVar = (r) l.a.getValue();
        q.a aVar = this.a;
        return new b.i.a.c.e3.b0.c(rVar, new q(aVar.a, aVar.f949b.a()), new FileDataSource(), new CacheDataSink(rVar, this.f253b), 3, null);
    }
}
