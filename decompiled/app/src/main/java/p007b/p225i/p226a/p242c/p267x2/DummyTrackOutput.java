package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p257e3.DataReader;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* JADX INFO: renamed from: b.i.a.c.x2.g, reason: use source file name */
/* JADX INFO: compiled from: DummyTrackOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DummyTrackOutput implements TrackOutput2 {

    /* JADX INFO: renamed from: a */
    public final byte[] f8179a = new byte[4096];

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* JADX INFO: renamed from: a */
    public int mo2522a(DataReader dataReader, int i, boolean z2, int i2) throws IOException {
        int i3 = dataReader.read(this.f8179a, 0, Math.min(this.f8179a.length, i));
        if (i3 != -1) {
            return i3;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* JADX INFO: renamed from: b */
    public /* synthetic */ int mo2523b(DataReader dataReader, int i, boolean z2) {
        return TrackOutput.m3817a(this, dataReader, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo2524c(ParsableByteArray parsableByteArray, int i) {
        TrackOutput.m3818b(this, parsableByteArray, i);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* JADX INFO: renamed from: d */
    public void mo2525d(long j, int i, int i2, int i3, @Nullable TrackOutput2.a aVar) {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* JADX INFO: renamed from: e */
    public void mo2526e(Format2 format2) {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* JADX INFO: renamed from: f */
    public void mo2527f(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.m3079E(parsableByteArray.f6794b + i);
    }
}
