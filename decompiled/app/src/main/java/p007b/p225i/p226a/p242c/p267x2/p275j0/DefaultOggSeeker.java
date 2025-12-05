package p007b.p225i.p226a.p242c.p267x2.p275j0;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.SeekPoint;

/* compiled from: DefaultOggSeeker.java */
/* renamed from: b.i.a.c.x2.j0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultOggSeeker implements OggSeeker {

    /* renamed from: a */
    public final OggPageHeader f8503a;

    /* renamed from: b */
    public final long f8504b;

    /* renamed from: c */
    public final long f8505c;

    /* renamed from: d */
    public final StreamReader f8506d;

    /* renamed from: e */
    public int f8507e;

    /* renamed from: f */
    public long f8508f;

    /* renamed from: g */
    public long f8509g;

    /* renamed from: h */
    public long f8510h;

    /* renamed from: i */
    public long f8511i;

    /* renamed from: j */
    public long f8512j;

    /* renamed from: k */
    public long f8513k;

    /* renamed from: l */
    public long f8514l;

    /* compiled from: DefaultOggSeeker.java */
    /* renamed from: b.i.a.c.x2.j0.b$b */
    public final class b implements SeekMap {
        public b(a aVar) {
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: c */
        public boolean mo3619c() {
            return true;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: h */
        public SeekMap.a mo3620h(long j) {
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            long j2 = (defaultOggSeeker.f8506d.f8548i * j) / 1000000;
            long j3 = defaultOggSeeker.f8504b;
            long j4 = defaultOggSeeker.f8505c;
            return new SeekMap.a(new SeekPoint(j, Util2.m3001i(((((j4 - j3) * j2) / defaultOggSeeker.f8508f) + j3) - 30000, j3, j4 - 1)));
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: i */
        public long mo3621i() {
            return (DefaultOggSeeker.this.f8508f * 1000000) / r0.f8506d.f8548i;
        }
    }

    public DefaultOggSeeker(StreamReader streamReader, long j, long j2, long j3, long j4, boolean z2) {
        AnimatableValueParser.m531j(j >= 0 && j2 > j);
        this.f8506d = streamReader;
        this.f8504b = j;
        this.f8505c = j2;
        if (j3 == j2 - j || z2) {
            this.f8508f = j4;
            this.f8507e = 4;
        } else {
            this.f8507e = 0;
        }
        this.f8503a = new OggPageHeader();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
    @Nullable
    /* renamed from: a */
    public SeekMap mo3734a() {
        if (this.f8508f != 0) {
            return new b(null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo3735b(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        long jM3001i;
        long j;
        int i = this.f8507e;
        if (i == 0) {
            long position = extractorInput.getPosition();
            this.f8509g = position;
            this.f8507e = 1;
            long j2 = this.f8505c - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                j = -1;
            } else if (this.f8511i == this.f8512j) {
                jM3001i = -1;
                j = -1;
                if (jM3001i == -1) {
                    return jM3001i;
                }
                this.f8507e = 3;
            } else {
                long position2 = extractorInput.getPosition();
                if (this.f8503a.m3745c(extractorInput, this.f8512j)) {
                    this.f8503a.m3743a(extractorInput, false);
                    extractorInput.mo3649k();
                    long j3 = this.f8510h;
                    OggPageHeader oggPageHeader = this.f8503a;
                    long j4 = oggPageHeader.f8532c;
                    long j5 = j3 - j4;
                    int i2 = oggPageHeader.f8534e + oggPageHeader.f8535f;
                    if (0 > j5 || j5 >= 72000) {
                        if (j5 < 0) {
                            this.f8512j = position2;
                            this.f8514l = j4;
                        } else {
                            this.f8511i = extractorInput.getPosition() + i2;
                            this.f8513k = this.f8503a.f8532c;
                        }
                        long j6 = this.f8512j;
                        long j7 = this.f8511i;
                        if (j6 - j7 < 100000) {
                            this.f8512j = j7;
                            jM3001i = j7;
                        } else {
                            long position3 = extractorInput.getPosition() - (i2 * (j5 <= 0 ? 2L : 1L));
                            long j8 = this.f8512j;
                            long j9 = this.f8511i;
                            jM3001i = Util2.m3001i((((j8 - j9) * j5) / (this.f8514l - this.f8513k)) + position3, j9, j8 - 1);
                        }
                    }
                } else {
                    jM3001i = this.f8511i;
                    if (jM3001i == position2) {
                        throw new IOException("No ogg page can be found.");
                    }
                }
                j = -1;
                if (jM3001i == -1) {
                }
            }
            while (true) {
                this.f8503a.m3745c(extractorInput, j);
                this.f8503a.m3743a(extractorInput, false);
                OggPageHeader oggPageHeader2 = this.f8503a;
                if (oggPageHeader2.f8532c > this.f8510h) {
                    extractorInput.mo3649k();
                    this.f8507e = 4;
                    return -(this.f8513k + 2);
                }
                extractorInput.mo3650l(oggPageHeader2.f8534e + oggPageHeader2.f8535f);
                this.f8511i = extractorInput.getPosition();
                this.f8513k = this.f8503a.f8532c;
                j = -1;
            }
        }
        this.f8503a.m3744b();
        if (!this.f8503a.m3745c(extractorInput, -1L)) {
            throw new EOFException();
        }
        this.f8503a.m3743a(extractorInput, false);
        OggPageHeader oggPageHeader3 = this.f8503a;
        extractorInput.mo3650l(oggPageHeader3.f8534e + oggPageHeader3.f8535f);
        long j10 = this.f8503a.f8532c;
        while (true) {
            OggPageHeader oggPageHeader4 = this.f8503a;
            if ((oggPageHeader4.f8531b & 4) == 4 || !oggPageHeader4.m3745c(extractorInput, -1L) || extractorInput.getPosition() >= this.f8505c || !this.f8503a.m3743a(extractorInput, true)) {
                break;
            }
            OggPageHeader oggPageHeader5 = this.f8503a;
            try {
                extractorInput.mo3650l(oggPageHeader5.f8534e + oggPageHeader5.f8535f);
                z2 = true;
            } catch (EOFException unused) {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            j10 = this.f8503a.f8532c;
        }
        this.f8508f = j10;
        this.f8507e = 4;
        return this.f8509g;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
    /* renamed from: c */
    public void mo3736c(long j) {
        this.f8510h = Util2.m3001i(j, 0L, this.f8508f - 1);
        this.f8507e = 2;
        this.f8511i = this.f8504b;
        this.f8512j = this.f8505c;
        this.f8513k = 0L;
        this.f8514l = this.f8508f;
    }
}
