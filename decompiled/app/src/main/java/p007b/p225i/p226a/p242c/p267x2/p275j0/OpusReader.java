package p007b.p225i.p226a.p242c.p267x2.p275j0;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.h, reason: use source file name */
/* JADX INFO: compiled from: OpusReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OpusReader extends StreamReader {

    /* JADX INFO: renamed from: n */
    public static final byte[] f8538n = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: o */
    public boolean f8539o;

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    /* JADX INFO: renamed from: c */
    public long mo3737c(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.f6793a;
        int i = bArr[0] & 255;
        int i2 = i & 3;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (i2 != 1 && i2 != 2) {
            i3 = bArr[1] & 63;
        }
        int i4 = i >> 3;
        int i5 = i4 & 3;
        return m3746a(((long) i3) * ((long) (i4 >= 16 ? 2500 << i5 : i4 >= 12 ? 10000 << (i5 & 1) : i5 == 3 ? 60000 : 10000 << i5)));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* JADX INFO: renamed from: d */
    public boolean mo3738d(ParsableByteArray parsableByteArray, long j, StreamReader.b bVar) {
        if (this.f8539o) {
            Objects.requireNonNull(bVar.f8553a);
            boolean z2 = parsableByteArray.m3086f() == 1332770163;
            parsableByteArray.m3079E(0);
            return z2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.f6793a, parsableByteArray.f6795c);
        int i = bArrCopyOf[9] & 255;
        List<byte[]> listM519g = AnimatableValueParser.m519g(bArrCopyOf);
        Format2.b bVar2 = new Format2.b();
        bVar2.f7173k = "audio/opus";
        bVar2.f7186x = i;
        bVar2.f7187y = 48000;
        bVar2.f7175m = listM519g;
        bVar.f8553a = bVar2.m3277a();
        this.f8539o = true;
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    /* JADX INFO: renamed from: e */
    public void mo3739e(boolean z2) {
        super.mo3739e(z2);
        if (z2) {
            this.f8539o = false;
        }
    }
}
