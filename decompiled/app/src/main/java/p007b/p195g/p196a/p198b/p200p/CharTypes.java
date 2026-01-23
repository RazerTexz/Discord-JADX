package p007b.p195g.p196a.p198b.p200p;

import java.util.Arrays;

/* JADX INFO: renamed from: b.g.a.b.p.a, reason: use source file name */
/* JADX INFO: compiled from: CharTypes.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CharTypes {

    /* JADX INFO: renamed from: a */
    public static final char[] f4536a;

    /* JADX INFO: renamed from: b */
    public static final byte[] f4537b;

    /* JADX INFO: renamed from: c */
    public static final int[] f4538c;

    /* JADX INFO: renamed from: d */
    public static final int[] f4539d;

    /* JADX INFO: renamed from: e */
    public static final int[] f4540e;

    /* JADX INFO: renamed from: f */
    public static final int[] f4541f;

    /* JADX INFO: renamed from: g */
    public static final int[] f4542g;

    /* JADX INFO: renamed from: b.g.a.b.p.a$a */
    /* JADX INFO: compiled from: CharTypes.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final a f4543a = new a();

        /* JADX INFO: renamed from: b */
        public int[][] f4544b = new int[128][];
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        f4536a = charArray;
        int length = charArray.length;
        f4537b = new byte[length];
        for (int i = 0; i < length; i++) {
            f4537b[i] = (byte) f4536a[i];
        }
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 32; i2++) {
            iArr[i2] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f4538c = iArr;
        int length2 = iArr.length;
        int[] iArr2 = new int[length2];
        System.arraycopy(iArr, 0, iArr2, 0, length2);
        for (int i3 = 128; i3 < 256; i3++) {
            iArr2[i3] = (i3 & 224) == 192 ? 2 : (i3 & 240) == 224 ? 3 : (i3 & 248) == 240 ? 4 : -1;
        }
        f4539d = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i4 = 33; i4 < 256; i4++) {
            if (Character.isJavaIdentifierPart((char) i4)) {
                iArr3[i4] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        f4540e = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, 256);
        Arrays.fill(iArr4, 128, 128, 0);
        int[] iArr5 = new int[256];
        int[] iArr6 = f4539d;
        System.arraycopy(iArr6, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        int[] iArr7 = new int[256];
        System.arraycopy(iArr6, 128, iArr7, 128, 128);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        int[] iArr8 = new int[128];
        for (int i5 = 0; i5 < 32; i5++) {
            iArr8[i5] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        f4541f = iArr8;
        int[] iArr9 = new int[256];
        f4542g = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i6 = 0; i6 < 10; i6++) {
            f4542g[i6 + 48] = i6;
        }
        for (int i7 = 0; i7 < 6; i7++) {
            int[] iArr10 = f4542g;
            int i8 = i7 + 10;
            iArr10[i7 + 97] = i8;
            iArr10[i7 + 65] = i8;
        }
    }
}
