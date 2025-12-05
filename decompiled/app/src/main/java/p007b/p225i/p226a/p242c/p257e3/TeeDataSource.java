package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: TeeDataSource.java */
/* renamed from: b.i.a.c.e3.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class TeeDataSource implements DataSource3 {

    /* renamed from: a */
    public final DataSource3 f6645a;

    /* renamed from: b */
    public final DataSink f6646b;

    /* renamed from: c */
    public boolean f6647c;

    /* renamed from: d */
    public long f6648d;

    public TeeDataSource(DataSource3 dataSource3, DataSink dataSink) {
        this.f6645a = dataSource3;
        this.f6646b = dataSink;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: a */
    public long mo2586a(DataSpec dataSpec) throws IOException {
        DataSpec dataSpec2 = dataSpec;
        long jMo2586a = this.f6645a.mo2586a(dataSpec2);
        this.f6648d = jMo2586a;
        if (jMo2586a == 0) {
            return 0L;
        }
        long j = dataSpec2.f6548g;
        if (j == -1 && jMo2586a != -1) {
            dataSpec2 = j == jMo2586a ? dataSpec2 : new DataSpec(dataSpec2.f6542a, dataSpec2.f6543b, dataSpec2.f6544c, dataSpec2.f6545d, dataSpec2.f6546e, dataSpec2.f6547f + 0, jMo2586a, dataSpec2.f6549h, dataSpec2.f6550i, dataSpec2.f6551j);
        }
        this.f6647c = true;
        this.f6646b.mo2852a(dataSpec2);
        return this.f6648d;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    public void close() throws IOException {
        try {
            this.f6645a.close();
        } finally {
            if (this.f6647c) {
                this.f6647c = false;
                this.f6646b.close();
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: d */
    public void mo2587d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        this.f6645a.mo2587d(transferListener);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: j */
    public Map<String, List<String>> mo2588j() {
        return this.f6645a.mo2588j();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    @Nullable
    /* renamed from: n */
    public Uri mo2589n() {
        return this.f6645a.mo2589n();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f6648d == 0) {
            return -1;
        }
        int i3 = this.f6645a.read(bArr, i, i2);
        if (i3 > 0) {
            this.f6646b.write(bArr, i, i3);
            long j = this.f6648d;
            if (j != -1) {
                this.f6648d = j - i3;
            }
        }
        return i3;
    }
}
