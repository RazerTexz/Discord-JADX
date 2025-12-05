package p007b.p225i.p226a.p242c.p267x2.p274i0;

import com.discord.api.permission.Permission;
import java.io.IOException;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* compiled from: Sniffer.java */
/* renamed from: b.i.a.c.x2.i0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class Sniffer2 {

    /* renamed from: a */
    public static final int[] f8459a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    /* JADX WARN: Removed duplicated region for block: B:101:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00e3 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m3730a(ExtractorInput extractorInput, boolean z2, boolean z3) throws IOException {
        boolean z4;
        boolean z5;
        long jMo3642b = extractorInput.mo3642b();
        long j = Permission.SEND_TTS_MESSAGES;
        long j2 = -1;
        if (jMo3642b != -1 && jMo3642b <= Permission.SEND_TTS_MESSAGES) {
            j = jMo3642b;
        }
        int i = (int) j;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z6 = false;
        int i2 = 0;
        boolean z7 = false;
        while (i2 < i) {
            parsableByteArray.m3075A(8);
            if (!extractorInput.mo3644e(parsableByteArray.f6793a, z6 ? 1 : 0, 8, true)) {
                break;
            }
            long jM3101u = parsableByteArray.m3101u();
            int iM3086f = parsableByteArray.m3086f();
            int i3 = 16;
            if (jM3101u == 1) {
                extractorInput.mo3652o(parsableByteArray.f6793a, 8, 8);
                parsableByteArray.m3078D(16);
                jM3101u = parsableByteArray.m3093m();
            } else {
                if (jM3101u == 0) {
                    long jMo3642b2 = extractorInput.mo3642b();
                    if (jMo3642b2 != j2) {
                        jM3101u = (jMo3642b2 - extractorInput.mo3645f()) + 8;
                    }
                }
                i3 = 8;
            }
            long j3 = i3;
            if (jM3101u < j3) {
                return z6;
            }
            i2 += i3;
            if (iM3086f == 1836019574) {
                i += (int) jM3101u;
                if (jMo3642b != -1 && i > jMo3642b) {
                    i = (int) jMo3642b;
                }
                j2 = -1;
            } else {
                if (iM3086f == 1836019558 || iM3086f == 1836475768) {
                    z4 = true;
                    break;
                }
                long j4 = jMo3642b;
                if ((i2 + jM3101u) - j3 >= i) {
                    break;
                }
                int i4 = (int) (jM3101u - j3);
                i2 += i4;
                if (iM3086f == 1718909296) {
                    if (i4 < 8) {
                        return false;
                    }
                    parsableByteArray.m3075A(i4);
                    extractorInput.mo3652o(parsableByteArray.f6793a, 0, i4);
                    int i5 = i4 / 4;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i5) {
                            break;
                        }
                        if (i6 != 1) {
                            int iM3086f2 = parsableByteArray.m3086f();
                            if ((iM3086f2 >>> 8) != 3368816 && (iM3086f2 != 1751476579 || !z3)) {
                                for (int i7 : f8459a) {
                                    if (i7 == iM3086f2) {
                                        z5 = true;
                                        break;
                                    }
                                }
                                z5 = false;
                                if (!z5) {
                                    z7 = true;
                                    break;
                                }
                            } else {
                                z5 = true;
                                if (!z5) {
                                }
                            }
                        } else {
                            parsableByteArray.m3080F(4);
                        }
                        i6++;
                    }
                    if (!z7) {
                        return false;
                    }
                } else if (i4 != 0) {
                    extractorInput.mo3646g(i4);
                }
                jMo3642b = j4;
                j2 = -1;
                z6 = false;
            }
        }
        z4 = false;
        return z7 && z2 == z4;
    }
}
