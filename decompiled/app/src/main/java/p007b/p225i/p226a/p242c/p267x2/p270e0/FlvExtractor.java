package p007b.p225i.p226a.p242c.p267x2.p270e0;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.IndexSeekMap;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.c, reason: use source file name */
/* JADX INFO: compiled from: FlvExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlvExtractor implements Extractor {

    /* JADX INFO: renamed from: f */
    public ExtractorOutput f8131f;

    /* JADX INFO: renamed from: h */
    public boolean f8133h;

    /* JADX INFO: renamed from: i */
    public long f8134i;

    /* JADX INFO: renamed from: j */
    public int f8135j;

    /* JADX INFO: renamed from: k */
    public int f8136k;

    /* JADX INFO: renamed from: l */
    public int f8137l;

    /* JADX INFO: renamed from: m */
    public long f8138m;

    /* JADX INFO: renamed from: n */
    public boolean f8139n;

    /* JADX INFO: renamed from: o */
    public AudioTagPayloadReader f8140o;

    /* JADX INFO: renamed from: p */
    public VideoTagPayloadReader f8141p;

    /* JADX INFO: renamed from: a */
    public final ParsableByteArray f8126a = new ParsableByteArray(4);

    /* JADX INFO: renamed from: b */
    public final ParsableByteArray f8127b = new ParsableByteArray(9);

    /* JADX INFO: renamed from: c */
    public final ParsableByteArray f8128c = new ParsableByteArray(11);

    /* JADX INFO: renamed from: d */
    public final ParsableByteArray f8129d = new ParsableByteArray();

    /* JADX INFO: renamed from: e */
    public final ScriptTagPayloadReader f8130e = new ScriptTagPayloadReader();

    /* JADX INFO: renamed from: g */
    public int f8132g = 1;

    static {
        C3012a c3012a = C3012a.f8121a;
    }

    @RequiresNonNull({"extractorOutput"})
    /* JADX INFO: renamed from: a */
    public final void m3659a() {
        if (this.f8139n) {
            return;
        }
        this.f8131f.mo2477a(new SeekMap.b(-9223372036854775807L, 0L));
        this.f8139n = true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        extractorInput.mo3652o(this.f8126a.f6793a, 0, 3);
        this.f8126a.m3079E(0);
        if (this.f8126a.m3102v() != 4607062) {
            return false;
        }
        extractorInput.mo3652o(this.f8126a.f6793a, 0, 2);
        this.f8126a.m3079E(0);
        if ((this.f8126a.m3105y() & 250) != 0) {
            return false;
        }
        extractorInput.mo3652o(this.f8126a.f6793a, 0, 4);
        this.f8126a.m3079E(0);
        int iM3086f = this.f8126a.m3086f();
        extractorInput.mo3649k();
        extractorInput.mo3646g(iM3086f);
        extractorInput.mo3652o(this.f8126a.f6793a, 0, 4);
        this.f8126a.m3079E(0);
        return this.f8126a.m3086f() == 0;
    }

    /* JADX INFO: renamed from: c */
    public final ParsableByteArray m3660c(ExtractorInput extractorInput) throws IOException {
        int i = this.f8137l;
        ParsableByteArray parsableByteArray = this.f8129d;
        byte[] bArr = parsableByteArray.f6793a;
        if (i > bArr.length) {
            parsableByteArray.f6793a = new byte[Math.max(bArr.length * 2, i)];
            parsableByteArray.f6795c = 0;
            parsableByteArray.f6794b = 0;
        } else {
            parsableByteArray.m3079E(0);
        }
        this.f8129d.m3078D(this.f8137l);
        extractorInput.readFully(this.f8129d.f6793a, 0, this.f8137l);
        return this.f8129d;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0009 A[SYNTHETIC] */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean zM8837a;
        boolean z2;
        AnimatableValueParser.m438H(this.f8131f);
        while (true) {
            int i = this.f8132g;
            if (i == 1) {
                if (extractorInput.mo3643c(this.f8127b.f6793a, 0, 9, true)) {
                    this.f8127b.m3079E(0);
                    this.f8127b.m3080F(4);
                    int iM3100t = this.f8127b.m3100t();
                    boolean z3 = (iM3100t & 4) != 0;
                    z = (iM3100t & 1) != 0;
                    if (z3 && this.f8140o == null) {
                        this.f8140o = new AudioTagPayloadReader(this.f8131f.mo2492p(8, 1));
                    }
                    if (z && this.f8141p == null) {
                        this.f8141p = new VideoTagPayloadReader(this.f8131f.mo2492p(9, 2));
                    }
                    this.f8131f.mo2486j();
                    this.f8135j = (this.f8127b.m3086f() - 9) + 4;
                    this.f8132g = 2;
                    z = true;
                }
                if (!z) {
                    return -1;
                }
            } else if (i == 2) {
                extractorInput.mo3650l(this.f8135j);
                this.f8135j = 0;
                this.f8132g = 3;
            } else if (i == 3) {
                if (extractorInput.mo3643c(this.f8128c.f6793a, 0, 11, true)) {
                    this.f8128c.m3079E(0);
                    this.f8136k = this.f8128c.m3100t();
                    this.f8137l = this.f8128c.m3102v();
                    this.f8138m = this.f8128c.m3102v();
                    this.f8138m = (((long) (this.f8128c.m3100t() << 24)) | this.f8138m) * 1000;
                    this.f8128c.m3080F(3);
                    this.f8132g = 4;
                    z = true;
                }
                if (!z) {
                    return -1;
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                long j = this.f8133h ? this.f8134i + this.f8138m : this.f8130e.f8142b == -9223372036854775807L ? 0L : this.f8138m;
                int i2 = this.f8136k;
                if (i2 == 8 && this.f8140o != null) {
                    m3659a();
                    zM8837a = this.f8140o.m8837a(m3660c(extractorInput), j);
                } else if (i2 == 9 && this.f8141p != null) {
                    m3659a();
                    zM8837a = this.f8141p.m8837a(m3660c(extractorInput), j);
                } else if (i2 != 18 || this.f8139n) {
                    extractorInput.mo3650l(this.f8137l);
                    zM8837a = false;
                    z2 = false;
                    if (!this.f8133h && zM8837a) {
                        this.f8133h = true;
                        this.f8134i = this.f8130e.f8142b != -9223372036854775807L ? -this.f8138m : 0L;
                    }
                    this.f8135j = 4;
                    this.f8132g = 2;
                    if (!z2) {
                        return 0;
                    }
                } else {
                    zM8837a = this.f8130e.m8837a(m3660c(extractorInput), j);
                    ScriptTagPayloadReader scriptTagPayloadReader = this.f8130e;
                    long j2 = scriptTagPayloadReader.f8142b;
                    if (j2 != -9223372036854775807L) {
                        this.f8131f.mo2477a(new IndexSeekMap(scriptTagPayloadReader.f8144d, scriptTagPayloadReader.f8143c, j2));
                        this.f8139n = true;
                    }
                }
                z2 = true;
                if (!this.f8133h) {
                    this.f8133h = true;
                    this.f8134i = this.f8130e.f8142b != -9223372036854775807L ? -this.f8138m : 0L;
                }
                this.f8135j = 4;
                this.f8132g = 2;
                if (!z2) {
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8131f = extractorOutput;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        if (j == 0) {
            this.f8132g = 1;
            this.f8133h = false;
        } else {
            this.f8132g = 3;
        }
        this.f8135j = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
