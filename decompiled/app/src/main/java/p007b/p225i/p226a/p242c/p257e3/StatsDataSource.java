package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: StatsDataSource.java */
/* renamed from: b.i.a.c.e3.y, reason: use source file name */
/* loaded from: classes3.dex */
public final class StatsDataSource implements DataSource3 {

    /* renamed from: a */
    public final DataSource3 f6641a;

    /* renamed from: b */
    public long f6642b;

    /* renamed from: c */
    public Uri f6643c;

    /* renamed from: d */
    public Map<String, List<String>> f6644d;

    public StatsDataSource(DataSource3 dataSource3) {
        Objects.requireNonNull(dataSource3);
        this.f6641a = dataSource3;
        this.f6643c = Uri.EMPTY;
        this.f6644d = Collections.emptyMap();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: a */
    public long mo2586a(DataSpec dataSpec) throws IOException {
        this.f6643c = dataSpec.f6542a;
        this.f6644d = Collections.emptyMap();
        long jMo2586a = this.f6641a.mo2586a(dataSpec);
        Uri uriMo2589n = mo2589n();
        Objects.requireNonNull(uriMo2589n);
        this.f6643c = uriMo2589n;
        this.f6644d = mo2588j();
        return jMo2586a;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    public void close() throws IOException {
        this.f6641a.close();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: d */
    public void mo2587d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        this.f6641a.mo2587d(transferListener);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: j */
    public Map<String, List<String>> mo2588j() {
        return this.f6641a.mo2588j();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    @Nullable
    /* renamed from: n */
    public Uri mo2589n() {
        return this.f6641a.mo2589n();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f6641a.read(bArr, i, i2);
        if (i3 != -1) {
            this.f6642b += i3;
        }
        return i3;
    }
}
