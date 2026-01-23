package p007b.p225i.p226a.p242c.p267x2.p271f0;

import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.c, reason: use source file name */
/* JADX INFO: compiled from: StartOffsetExtractorInput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class StartOffsetExtractorInput implements ExtractorInput {

    /* JADX INFO: renamed from: a */
    public final ExtractorInput f8170a;

    /* JADX INFO: renamed from: b */
    public final long f8171b;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j) {
        this.f8170a = extractorInput;
        AnimatableValueParser.m531j(extractorInput.getPosition() >= j);
        this.f8171b = j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: b */
    public long mo3642b() {
        return this.f8170a.mo3642b() - this.f8171b;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: c */
    public boolean mo3643c(byte[] bArr, int i, int i2, boolean z2) {
        return this.f8170a.mo3643c(bArr, i, i2, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: e */
    public boolean mo3644e(byte[] bArr, int i, int i2, boolean z2) {
        return this.f8170a.mo3644e(bArr, i, i2, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: f */
    public long mo3645f() {
        return this.f8170a.mo3645f() - this.f8171b;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: g */
    public void mo3646g(int i) throws IOException {
        this.f8170a.mo3646g(i);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    public long getPosition() {
        return this.f8170a.getPosition() - this.f8171b;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: h */
    public int mo3647h(int i) {
        return this.f8170a.mo3647h(i);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: i */
    public int mo3648i(byte[] bArr, int i, int i2) {
        return this.f8170a.mo3648i(bArr, i, i2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: k */
    public void mo3649k() {
        this.f8170a.mo3649k();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: l */
    public void mo3650l(int i) throws IOException {
        this.f8170a.mo3650l(i);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: m */
    public boolean mo3651m(int i, boolean z2) {
        return this.f8170a.mo3651m(i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    /* JADX INFO: renamed from: o */
    public void mo3652o(byte[] bArr, int i, int i2) throws IOException {
        this.f8170a.mo3652o(bArr, i, i2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput, p007b.p225i.p226a.p242c.p257e3.DataReader
    public int read(byte[] bArr, int i, int i2) {
        return this.f8170a.read(bArr, i, i2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f8170a.readFully(bArr, i, i2);
    }
}
