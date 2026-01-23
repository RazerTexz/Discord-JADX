package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p243a3.ProgressiveMediaPeriod;
import p007b.p225i.p226a.p242c.p257e3.DataSource3;
import p007b.p225i.p226a.p242c.p257e3.DataSpec;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* JADX INFO: renamed from: b.i.a.c.a3.s, reason: use source file name */
/* JADX INFO: compiled from: IcyDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class IcyDataSource implements DataSource3 {

    /* JADX INFO: renamed from: a */
    public final DataSource3 f5698a;

    /* JADX INFO: renamed from: b */
    public final int f5699b;

    /* JADX INFO: renamed from: c */
    public final a f5700c;

    /* JADX INFO: renamed from: d */
    public final byte[] f5701d;

    /* JADX INFO: renamed from: e */
    public int f5702e;

    /* JADX INFO: renamed from: b.i.a.c.a3.s$a */
    /* JADX INFO: compiled from: IcyDataSource.java */
    public interface a {
    }

    public IcyDataSource(DataSource3 dataSource3, int i, a aVar) {
        AnimatableValueParser.m531j(i > 0);
        this.f5698a = dataSource3;
        this.f5699b = i;
        this.f5700c = aVar;
        this.f5701d = new byte[1];
        this.f5702e = i;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* JADX INFO: renamed from: a */
    public long mo2586a(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* JADX INFO: renamed from: d */
    public void mo2587d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        this.f5698a.mo2587d(transferListener);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* JADX INFO: renamed from: j */
    public Map<String, List<String>> mo2588j() {
        return this.f5698a.mo2588j();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        return this.f5698a.mo2589n();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078 A[RETURN] */
    @Override // p007b.p225i.p226a.p242c.p257e3.DataReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long jMax;
        if (this.f5702e == 0) {
            boolean z2 = true;
            if (this.f5698a.read(this.f5701d, 0, 1) != -1) {
                int i3 = (this.f5701d[0] & 255) << 4;
                if (i3 != 0) {
                    byte[] bArr2 = new byte[i3];
                    int i4 = i3;
                    int i5 = 0;
                    while (i4 > 0) {
                        int i6 = this.f5698a.read(bArr2, i5, i4);
                        if (i6 == -1) {
                            z2 = false;
                            break;
                        }
                        i5 += i6;
                        i4 -= i6;
                    }
                    while (i3 > 0) {
                        int i7 = i3 - 1;
                        if (bArr2[i7] != 0) {
                            break;
                        }
                        i3 = i7;
                    }
                    if (i3 > 0) {
                        a aVar = this.f5700c;
                        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr2, i3);
                        ProgressiveMediaPeriod.a aVar2 = (ProgressiveMediaPeriod.a) aVar;
                        if (aVar2.f5551n) {
                            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
                            Map<String, String> map = ProgressiveMediaPeriod.f5498j;
                            jMax = Math.max(progressiveMediaPeriod.m2498v(), aVar2.f5547j);
                        } else {
                            jMax = aVar2.f5547j;
                        }
                        int iM3081a = parsableByteArray.m3081a();
                        TrackOutput2 trackOutput2 = aVar2.f5550m;
                        Objects.requireNonNull(trackOutput2);
                        trackOutput2.mo2524c(parsableByteArray, iM3081a);
                        trackOutput2.mo2525d(jMax, 1, iM3081a, 0, null);
                        aVar2.f5551n = true;
                    }
                }
                if (z2) {
                    return -1;
                }
                this.f5702e = this.f5699b;
            } else {
                z2 = false;
                if (z2) {
                }
            }
        }
        int i8 = this.f5698a.read(bArr, i, Math.min(this.f5702e, i2));
        if (i8 != -1) {
            this.f5702e -= i8;
        }
        return i8;
    }
}
