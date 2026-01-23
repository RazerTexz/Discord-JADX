package p007b.p225i.p226a.p242c.p267x2;

import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.x2.m, reason: use source file name */
/* JADX INFO: compiled from: FlacFrameReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacFrameReader {

    /* JADX INFO: renamed from: b.i.a.c.x2.m$a */
    /* JADX INFO: compiled from: FlacFrameReader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public long f8967a;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3802a(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z2, a aVar) {
        try {
            long jM3106z = parsableByteArray.m3106z();
            if (!z2) {
                jM3106z *= (long) flacStreamMetadata.f8971b;
            }
            aVar.f8967a = jM3106z;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m3803b(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i, a aVar) {
        boolean z2;
        long jM3101u = parsableByteArray.m3101u();
        long j = jM3101u >>> 16;
        if (j != i) {
            return false;
        }
        boolean z3 = (j & 1) == 1;
        int i2 = (int) ((jM3101u >> 12) & 15);
        int i3 = (int) ((jM3101u >> 8) & 15);
        int i4 = (int) (15 & (jM3101u >> 4));
        int i5 = (int) ((jM3101u >> 1) & 7);
        boolean z4 = (jM3101u & 1) == 1;
        if (!(i4 > 7 ? !(i4 > 10 || flacStreamMetadata.f8976g != 2) : i4 == flacStreamMetadata.f8976g - 1)) {
            return false;
        }
        if (!(i5 == 0 || i5 == flacStreamMetadata.f8978i) || z4 || !m3802a(parsableByteArray, flacStreamMetadata, z3, aVar)) {
            return false;
        }
        int iM3804c = m3804c(parsableByteArray, i2);
        if (!(iM3804c != -1 && iM3804c <= flacStreamMetadata.f8971b)) {
            return false;
        }
        int i6 = flacStreamMetadata.f8974e;
        if (i3 != 0) {
            if (i3 <= 11) {
                z2 = i3 == flacStreamMetadata.f8975f;
            } else if (i3 != 12) {
                if (i3 <= 14) {
                    int iM3105y = parsableByteArray.m3105y();
                    if (i3 == 14) {
                        iM3105y *= 10;
                    }
                    if (iM3105y == i6) {
                    }
                }
            } else if (parsableByteArray.m3100t() * 1000 == i6) {
            }
        }
        if (!z2) {
            return false;
        }
        int iM3100t = parsableByteArray.m3100t();
        int i7 = parsableByteArray.f6794b;
        byte[] bArr = parsableByteArray.f6793a;
        int i8 = i7 - 1;
        int i9 = Util2.f6708a;
        int i10 = 0;
        for (int i11 = parsableByteArray.f6794b; i11 < i8; i11++) {
            i10 = Util2.f6719l[i10 ^ (bArr[i11] & 255)];
        }
        return iM3100t == i10;
    }

    /* JADX INFO: renamed from: c */
    public static int m3804c(ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case 1:
                return Opcodes.CHECKCAST;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return parsableByteArray.m3100t() + 1;
            case 7:
                return parsableByteArray.m3105y() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
