package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p257e3.DataSink;
import p007b.p225i.p226a.p242c.p257e3.DataSource3;
import p007b.p225i.p226a.p242c.p257e3.DataSpec;
import p007b.p225i.p226a.p242c.p257e3.TeeDataSource;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p355b.p356a.Charsets;

/* compiled from: CacheDataSource.java */
/* renamed from: b.i.a.c.e3.b0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class CacheDataSource implements DataSource3 {

    /* renamed from: a */
    public final Cache f6438a;

    /* renamed from: b */
    public final DataSource3 f6439b;

    /* renamed from: c */
    @Nullable
    public final DataSource3 f6440c;

    /* renamed from: d */
    public final DataSource3 f6441d;

    /* renamed from: e */
    public final CacheKeyFactory2 f6442e;

    /* renamed from: f */
    @Nullable
    public final a f6443f;

    /* renamed from: g */
    public final boolean f6444g;

    /* renamed from: h */
    public final boolean f6445h;

    /* renamed from: i */
    public final boolean f6446i;

    /* renamed from: j */
    @Nullable
    public Uri f6447j;

    /* renamed from: k */
    @Nullable
    public DataSpec f6448k;

    /* renamed from: l */
    @Nullable
    public DataSpec f6449l;

    /* renamed from: m */
    @Nullable
    public DataSource3 f6450m;

    /* renamed from: n */
    public long f6451n;

    /* renamed from: o */
    public long f6452o;

    /* renamed from: p */
    public long f6453p;

    /* renamed from: q */
    @Nullable
    public CacheSpan f6454q;

    /* renamed from: r */
    public boolean f6455r;

    /* renamed from: s */
    public boolean f6456s;

    /* renamed from: t */
    public long f6457t;

    /* renamed from: u */
    public long f6458u;

    /* compiled from: CacheDataSource.java */
    /* renamed from: b.i.a.c.e3.b0.c$a */
    public interface a {
        /* renamed from: a */
        void m2783a(int i);

        /* renamed from: b */
        void m2784b(long j, long j2);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource3 dataSource3, DataSource3 dataSource32, @Nullable DataSink dataSink, int i, @Nullable a aVar) {
        this.f6438a = cache;
        this.f6439b = dataSource32;
        int i2 = CacheKeyFactory2.f6464a;
        this.f6442e = C2682a.f6436b;
        this.f6444g = (i & 1) != 0;
        this.f6445h = (i & 2) != 0;
        this.f6446i = (i & 4) != 0;
        this.f6441d = dataSource3;
        this.f6440c = new TeeDataSource(dataSource3, dataSink);
        this.f6443f = null;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: a */
    public long mo2586a(DataSpec dataSpec) throws IOException {
        a aVar;
        try {
            Objects.requireNonNull((C2682a) this.f6442e);
            String string = dataSpec.f6549h;
            if (string == null) {
                string = dataSpec.f6542a.toString();
            }
            DataSpec.b bVarM2855a = dataSpec.m2855a();
            bVarM2855a.f6559h = string;
            DataSpec dataSpecM2857a = bVarM2855a.m2857a();
            this.f6448k = dataSpecM2857a;
            Cache cache = this.f6438a;
            Uri uri = dataSpecM2857a.f6542a;
            byte[] bArr = ((DefaultContentMetadata) cache.mo2827b(string)).f6500c.get("exo_redir");
            Uri uri2 = null;
            String str = bArr != null ? new String(bArr, Charsets.f11945c) : null;
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.f6447j = uri;
            this.f6452o = dataSpec.f6547f;
            boolean z2 = true;
            int i = (this.f6445h && this.f6455r) ? 0 : (this.f6446i && dataSpec.f6548g == -1) ? 1 : -1;
            if (i == -1) {
                z2 = false;
            }
            this.f6456s = z2;
            if (z2 && (aVar = this.f6443f) != null) {
                aVar.m2783a(i);
            }
            if (this.f6456s) {
                this.f6453p = -1L;
            } else {
                long jM2814a = ContentMetadata.m2814a(this.f6438a.mo2827b(string));
                this.f6453p = jM2814a;
                if (jM2814a != -1) {
                    long j = jM2814a - dataSpec.f6547f;
                    this.f6453p = j;
                    if (j < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = dataSpec.f6548g;
            if (jMin != -1) {
                long j2 = this.f6453p;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.f6453p = jMin;
            }
            long j3 = this.f6453p;
            if (j3 > 0 || j3 == -1) {
                m2782t(dataSpecM2857a, false);
            }
            long j4 = dataSpec.f6548g;
            return j4 != -1 ? j4 : this.f6453p;
        } catch (Throwable th) {
            m2779q(th);
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    public void close() throws IOException {
        this.f6448k = null;
        this.f6447j = null;
        this.f6452o = 0L;
        a aVar = this.f6443f;
        if (aVar != null && this.f6457t > 0) {
            aVar.m2784b(this.f6438a.mo2833h(), this.f6457t);
            this.f6457t = 0L;
        }
        try {
            m2778p();
        } catch (Throwable th) {
            m2779q(th);
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: d */
    public void mo2587d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        this.f6439b.mo2587d(transferListener);
        this.f6441d.mo2587d(transferListener);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: j */
    public Map<String, List<String>> mo2588j() {
        return m2781s() ? this.f6441d.mo2588j() : Collections.emptyMap();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    @Nullable
    /* renamed from: n */
    public Uri mo2589n() {
        return this.f6447j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: p */
    public final void m2778p() throws IOException {
        DataSource3 dataSource3 = this.f6450m;
        if (dataSource3 == null) {
            return;
        }
        try {
            dataSource3.close();
        } finally {
            this.f6449l = null;
            this.f6450m = null;
            CacheSpan cacheSpan = this.f6454q;
            if (cacheSpan != null) {
                this.f6438a.mo2834i(cacheSpan);
                this.f6454q = null;
            }
        }
    }

    /* renamed from: q */
    public final void m2779q(Throwable th) {
        if (m2780r() || (th instanceof Cache.CacheException)) {
            this.f6455r = true;
        }
    }

    /* renamed from: r */
    public final boolean m2780r() {
        return this.f6450m == this.f6439b;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008a A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:9:0x001b, B:11:0x0024, B:12:0x0027, B:14:0x0038, B:16:0x003e, B:17:0x0044, B:19:0x0055, B:20:0x0059, B:22:0x005f, B:24:0x0065, B:26:0x006b, B:30:0x007a, B:31:0x008a, B:37:0x0098), top: B:42:0x001b }] */
    @Override // p007b.p225i.p226a.p242c.p257e3.DataReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.f6453p == 0) {
            return -1;
        }
        DataSpec dataSpec = this.f6448k;
        Objects.requireNonNull(dataSpec);
        DataSpec dataSpec2 = this.f6449l;
        Objects.requireNonNull(dataSpec2);
        try {
            if (this.f6452o >= this.f6458u) {
                m2782t(dataSpec, true);
            }
            DataSource3 dataSource3 = this.f6450m;
            Objects.requireNonNull(dataSource3);
            int i3 = dataSource3.read(bArr, i, i2);
            if (i3 != -1) {
                if (m2780r()) {
                    this.f6457t += i3;
                }
                long j = i3;
                this.f6452o += j;
                this.f6451n += j;
                long j2 = this.f6453p;
                if (j2 != -1) {
                    this.f6453p = j2 - j;
                }
            } else if (m2781s()) {
                long j3 = dataSpec2.f6548g;
                if (j3 != -1 && this.f6451n >= j3) {
                    long j4 = this.f6453p;
                    if (j4 <= 0) {
                        if (j4 == -1) {
                        }
                    }
                    m2778p();
                    m2782t(dataSpec, false);
                    return read(bArr, i, i2);
                }
                String str = dataSpec.f6549h;
                int i4 = Util2.f6708a;
                this.f6453p = 0L;
                if (this.f6450m == this.f6440c) {
                    ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                    ContentMetadataMutations.m2815a(contentMetadataMutations, this.f6452o);
                    this.f6438a.mo2828c(str, contentMetadataMutations);
                }
            }
            return i3;
        } catch (Throwable th) {
            m2779q(th);
            throw th;
        }
    }

    /* renamed from: s */
    public final boolean m2781s() {
        return !m2780r();
    }

    /* renamed from: t */
    public final void m2782t(DataSpec dataSpec, boolean z2) throws IOException {
        CacheSpan cacheSpanMo2831f;
        DataSpec dataSpecM2857a;
        DataSource3 dataSource3;
        String str = dataSpec.f6549h;
        int i = Util2.f6708a;
        if (this.f6456s) {
            cacheSpanMo2831f = null;
        } else if (this.f6444g) {
            try {
                cacheSpanMo2831f = this.f6438a.mo2831f(str, this.f6452o, this.f6453p);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpanMo2831f = this.f6438a.mo2830e(str, this.f6452o, this.f6453p);
        }
        if (cacheSpanMo2831f == null) {
            dataSource3 = this.f6441d;
            DataSpec.b bVarM2855a = dataSpec.m2855a();
            bVarM2855a.f6557f = this.f6452o;
            bVarM2855a.f6558g = this.f6453p;
            dataSpecM2857a = bVarM2855a.m2857a();
        } else if (cacheSpanMo2831f.f6468m) {
            Uri uriFromFile = Uri.fromFile(cacheSpanMo2831f.f6469n);
            long j = cacheSpanMo2831f.f6466k;
            long j2 = this.f6452o - j;
            long jMin = cacheSpanMo2831f.f6467l - j2;
            long j3 = this.f6453p;
            if (j3 != -1) {
                jMin = Math.min(jMin, j3);
            }
            DataSpec.b bVarM2855a2 = dataSpec.m2855a();
            bVarM2855a2.f6552a = uriFromFile;
            bVarM2855a2.f6553b = j;
            bVarM2855a2.f6557f = j2;
            bVarM2855a2.f6558g = jMin;
            dataSpecM2857a = bVarM2855a2.m2857a();
            dataSource3 = this.f6439b;
        } else {
            long jMin2 = cacheSpanMo2831f.f6467l;
            if (jMin2 == -1) {
                jMin2 = this.f6453p;
            } else {
                long j4 = this.f6453p;
                if (j4 != -1) {
                    jMin2 = Math.min(jMin2, j4);
                }
            }
            DataSpec.b bVarM2855a3 = dataSpec.m2855a();
            bVarM2855a3.f6557f = this.f6452o;
            bVarM2855a3.f6558g = jMin2;
            dataSpecM2857a = bVarM2855a3.m2857a();
            dataSource3 = this.f6440c;
            if (dataSource3 == null) {
                dataSource3 = this.f6441d;
                this.f6438a.mo2834i(cacheSpanMo2831f);
                cacheSpanMo2831f = null;
            }
        }
        this.f6458u = (this.f6456s || dataSource3 != this.f6441d) ? RecyclerView.FOREVER_NS : this.f6452o + 102400;
        if (z2) {
            AnimatableValueParser.m426D(this.f6450m == this.f6441d);
            if (dataSource3 == this.f6441d) {
                return;
            }
            try {
                m2778p();
            } finally {
            }
        }
        if (cacheSpanMo2831f != null && (!cacheSpanMo2831f.f6468m)) {
            this.f6454q = cacheSpanMo2831f;
        }
        this.f6450m = dataSource3;
        this.f6449l = dataSpecM2857a;
        this.f6451n = 0L;
        long jMo2586a = dataSource3.mo2586a(dataSpecM2857a);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpecM2857a.f6548g == -1 && jMo2586a != -1) {
            this.f6453p = jMo2586a;
            ContentMetadataMutations.m2815a(contentMetadataMutations, this.f6452o + jMo2586a);
        }
        if (m2781s()) {
            Uri uriMo2589n = dataSource3.mo2589n();
            this.f6447j = uriMo2589n;
            Uri uri = dataSpec.f6542a.equals(uriMo2589n) ^ true ? this.f6447j : null;
            if (uri == null) {
                contentMetadataMutations.f6497b.add("exo_redir");
                contentMetadataMutations.f6496a.remove("exo_redir");
            } else {
                String string = uri.toString();
                Map<String, Object> map = contentMetadataMutations.f6496a;
                Objects.requireNonNull(string);
                map.put("exo_redir", string);
                contentMetadataMutations.f6497b.remove("exo_redir");
            }
        }
        if (this.f6450m == this.f6440c) {
            this.f6438a.mo2828c(str, contentMetadataMutations);
        }
    }
}
