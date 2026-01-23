package p007b.p225i.p226a.p242c.p267x2.p275j0;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.i, reason: use source file name */
/* JADX INFO: compiled from: StreamReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamReader {

    /* JADX INFO: renamed from: b */
    public TrackOutput2 f8541b;

    /* JADX INFO: renamed from: c */
    public ExtractorOutput f8542c;

    /* JADX INFO: renamed from: d */
    public OggSeeker f8543d;

    /* JADX INFO: renamed from: e */
    public long f8544e;

    /* JADX INFO: renamed from: f */
    public long f8545f;

    /* JADX INFO: renamed from: g */
    public long f8546g;

    /* JADX INFO: renamed from: h */
    public int f8547h;

    /* JADX INFO: renamed from: i */
    public int f8548i;

    /* JADX INFO: renamed from: k */
    public long f8550k;

    /* JADX INFO: renamed from: l */
    public boolean f8551l;

    /* JADX INFO: renamed from: m */
    public boolean f8552m;

    /* JADX INFO: renamed from: a */
    public final OggPacket f8540a = new OggPacket();

    /* JADX INFO: renamed from: j */
    public b f8549j = new b();

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.i$b */
    /* JADX INFO: compiled from: StreamReader.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public Format2 f8553a;

        /* JADX INFO: renamed from: b */
        public OggSeeker f8554b;
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.i$c */
    /* JADX INFO: compiled from: StreamReader.java */
    public static final class c implements OggSeeker {
        public c(a aVar) {
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* JADX INFO: renamed from: a */
        public SeekMap mo3734a() {
            return new SeekMap.b(-9223372036854775807L, 0L);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* JADX INFO: renamed from: b */
        public long mo3735b(ExtractorInput extractorInput) {
            return -1L;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* JADX INFO: renamed from: c */
        public void mo3736c(long j) {
        }
    }

    /* JADX INFO: renamed from: a */
    public long m3746a(long j) {
        return (((long) this.f8548i) * j) / 1000000;
    }

    /* JADX INFO: renamed from: b */
    public void mo3747b(long j) {
        this.f8546g = j;
    }

    /* JADX INFO: renamed from: c */
    public abstract long mo3737c(ParsableByteArray parsableByteArray);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* JADX INFO: renamed from: d */
    public abstract boolean mo3738d(ParsableByteArray parsableByteArray, long j, b bVar) throws IOException;

    /* JADX INFO: renamed from: e */
    public void mo3739e(boolean z2) {
        if (z2) {
            this.f8549j = new b();
            this.f8545f = 0L;
            this.f8547h = 0;
        } else {
            this.f8547h = 1;
        }
        this.f8544e = -1L;
        this.f8546g = 0L;
    }
}
