package p007b.p008a.p040p;

import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import p007b.p225i.p226a.p242c.p257e3.DataSource3;
import p007b.p225i.p226a.p242c.p257e3.DefaultDataSource;
import p007b.p225i.p226a.p242c.p257e3.p258b0.CacheDataSource;
import p007b.p225i.p226a.p242c.p257e3.p258b0.SimpleCache2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.p.j, reason: use source file name */
/* JADX INFO: compiled from: CacheDataSourceFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CacheDataSourceFactory implements DataSource3.a {

    /* JADX INFO: renamed from: a */
    public final DefaultDataSource.a f1588a;

    /* JADX INFO: renamed from: b */
    public final long f1589b;

    public CacheDataSourceFactory(DefaultDataSource.a aVar, long j) {
        Intrinsics3.checkNotNullParameter(aVar, "defaultDatasourceFactory");
        this.f1588a = aVar;
        this.f1589b = j;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3.a
    /* JADX INFO: renamed from: a */
    public DataSource3 mo234a() {
        SimpleCacheProvider simpleCacheProvider = SimpleCacheProvider.f1597b;
        SimpleCache2 simpleCache2 = (SimpleCache2) SimpleCacheProvider.f1596a.getValue();
        DefaultDataSource.a aVar = this.f1588a;
        return new CacheDataSource(simpleCache2, new DefaultDataSource(aVar.f6605a, aVar.f6606b.mo234a()), new FileDataSource(), new CacheDataSink(simpleCache2, this.f1589b), 3, null);
    }
}
