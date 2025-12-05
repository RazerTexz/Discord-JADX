package p007b.p225i.p226a.p242c.p267x2.p275j0;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* compiled from: StreamReader.java */
/* renamed from: b.i.a.c.x2.j0.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class StreamReader {

    /* renamed from: b */
    public TrackOutput2 f8541b;

    /* renamed from: c */
    public ExtractorOutput f8542c;

    /* renamed from: d */
    public OggSeeker f8543d;

    /* renamed from: e */
    public long f8544e;

    /* renamed from: f */
    public long f8545f;

    /* renamed from: g */
    public long f8546g;

    /* renamed from: h */
    public int f8547h;

    /* renamed from: i */
    public int f8548i;

    /* renamed from: k */
    public long f8550k;

    /* renamed from: l */
    public boolean f8551l;

    /* renamed from: m */
    public boolean f8552m;

    /* renamed from: a */
    public final OggPacket f8540a = new OggPacket();

    /* renamed from: j */
    public b f8549j = new b();

    /* compiled from: StreamReader.java */
    /* renamed from: b.i.a.c.x2.j0.i$b */
    public static class b {

        /* renamed from: a */
        public Format2 f8553a;

        /* renamed from: b */
        public OggSeeker f8554b;
    }

    /* compiled from: StreamReader.java */
    /* renamed from: b.i.a.c.x2.j0.i$c */
    public static final class c implements OggSeeker {
        public c(a aVar) {
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* renamed from: a */
        public SeekMap mo3734a() {
            return new SeekMap.b(-9223372036854775807L, 0L);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* renamed from: b */
        public long mo3735b(ExtractorInput extractorInput) {
            return -1L;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* renamed from: c */
        public void mo3736c(long j) {
        }
    }

    /* renamed from: a */
    public long m3746a(long j) {
        return (this.f8548i * j) / 1000000;
    }

    /* renamed from: b */
    public void mo3747b(long j) {
        this.f8546g = j;
    }

    /* renamed from: c */
    public abstract long mo3737c(ParsableByteArray parsableByteArray);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* renamed from: d */
    public abstract boolean mo3738d(ParsableByteArray parsableByteArray, long j, b bVar) throws IOException;

    /* renamed from: e */
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
