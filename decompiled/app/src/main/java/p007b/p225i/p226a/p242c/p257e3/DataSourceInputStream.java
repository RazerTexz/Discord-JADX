package p007b.p225i.p226a.p242c.p257e3;

import java.io.IOException;
import java.io.InputStream;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.c.e3.m, reason: use source file name */
/* JADX INFO: compiled from: DataSourceInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DataSourceInputStream extends InputStream {

    /* JADX INFO: renamed from: j */
    public final DataSource3 f6536j;

    /* JADX INFO: renamed from: k */
    public final DataSpec f6537k;

    /* JADX INFO: renamed from: o */
    public long f6541o;

    /* JADX INFO: renamed from: m */
    public boolean f6539m = false;

    /* JADX INFO: renamed from: n */
    public boolean f6540n = false;

    /* JADX INFO: renamed from: l */
    public final byte[] f6538l = new byte[1];

    public DataSourceInputStream(DataSource3 dataSource3, DataSpec dataSpec) {
        this.f6536j = dataSource3;
        this.f6537k = dataSpec;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f6540n) {
            return;
        }
        this.f6536j.close();
        this.f6540n = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f6538l) == -1) {
            return -1;
        }
        return this.f6538l[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        AnimatableValueParser.m426D(!this.f6540n);
        if (!this.f6539m) {
            this.f6536j.mo2586a(this.f6537k);
            this.f6539m = true;
        }
        int i3 = this.f6536j.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.f6541o += (long) i3;
        return i3;
    }
}
