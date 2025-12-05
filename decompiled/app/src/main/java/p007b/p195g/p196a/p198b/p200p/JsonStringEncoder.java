package p007b.p195g.p196a.p198b.p200p;

import java.util.ArrayList;
import java.util.Arrays;
import p007b.p195g.p196a.p198b.p204t.TextBuffer;

/* compiled from: JsonStringEncoder.java */
/* renamed from: b.g.a.b.p.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class JsonStringEncoder {

    /* renamed from: a */
    public static final char[] f4550a = (char[]) CharTypes.f4536a.clone();

    /* renamed from: b */
    public static final JsonStringEncoder f4551b;

    static {
        CharTypes.f4537b.clone();
        f4551b = new JsonStringEncoder();
    }

    /* renamed from: a */
    public char[] m1696a(String str) {
        int i;
        char[] cArrM1743e = new char[120];
        int[] iArr = CharTypes.f4541f;
        int length = iArr.length;
        int length2 = str.length();
        TextBuffer textBuffer = null;
        char[] cArr = null;
        int i2 = 0;
        int i3 = 0;
        loop0: while (i2 < length2) {
            do {
                char cCharAt = str.charAt(i2);
                if (cCharAt >= length || iArr[cCharAt] == 0) {
                    if (i3 >= cArrM1743e.length) {
                        if (textBuffer == null) {
                            textBuffer = new TextBuffer(null, cArrM1743e);
                        }
                        cArrM1743e = textBuffer.m1743e();
                        i3 = 0;
                    }
                    cArrM1743e[i3] = cCharAt;
                    i2++;
                    i3++;
                } else {
                    int i4 = 2;
                    if (cArr == null) {
                        cArr = new char[]{'\\', 0, '0', '0', 0, 0};
                    }
                    int i5 = i2 + 1;
                    char cCharAt2 = str.charAt(i2);
                    int i6 = iArr[cCharAt2];
                    if (i6 < 0) {
                        cArr[1] = 'u';
                        char[] cArr2 = f4550a;
                        cArr[4] = cArr2[cCharAt2 >> 4];
                        cArr[5] = cArr2[cCharAt2 & 15];
                        i4 = 6;
                    } else {
                        cArr[1] = (char) i6;
                    }
                    int i7 = i3 + i4;
                    if (i7 > cArrM1743e.length) {
                        int length3 = cArrM1743e.length - i3;
                        if (length3 > 0) {
                            System.arraycopy(cArr, 0, cArrM1743e, i3, length3);
                        }
                        if (textBuffer == null) {
                            textBuffer = new TextBuffer(null, cArrM1743e);
                        }
                        cArrM1743e = textBuffer.m1743e();
                        int i8 = i4 - length3;
                        System.arraycopy(cArr, length3, cArrM1743e, 0, i8);
                        i3 = i8;
                    } else {
                        System.arraycopy(cArr, 0, cArrM1743e, i3, i4);
                        i3 = i7;
                    }
                    i2 = i5;
                }
            } while (i2 < length2);
        }
        if (textBuffer == null) {
            return Arrays.copyOfRange(cArrM1743e, 0, i3);
        }
        textBuffer.f4611h = i3;
        char[] charArray = textBuffer.f4613j;
        if (charArray == null) {
            String str2 = textBuffer.f4612i;
            if (str2 != null) {
                charArray = str2.toCharArray();
            } else {
                int i9 = textBuffer.f4606c;
                if (i9 >= 0) {
                    charArray = TextBuffer.f4604a;
                } else {
                    int length4 = i9 >= 0 ? 0 : charArray != null ? charArray.length : str2 != null ? str2.length() : textBuffer.f4609f + i3;
                    if (length4 < 1) {
                        charArray = TextBuffer.f4604a;
                    } else {
                        charArray = new char[length4];
                        ArrayList<char[]> arrayList = textBuffer.f4607d;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            i = 0;
                            for (int i10 = 0; i10 < size; i10++) {
                                char[] cArr3 = textBuffer.f4607d.get(i10);
                                int length5 = cArr3.length;
                                System.arraycopy(cArr3, 0, charArray, i, length5);
                                i += length5;
                            }
                        } else {
                            i = 0;
                        }
                        System.arraycopy(textBuffer.f4610g, 0, charArray, i, textBuffer.f4611h);
                    }
                }
            }
            textBuffer.f4613j = charArray;
        }
        return charArray;
    }
}
