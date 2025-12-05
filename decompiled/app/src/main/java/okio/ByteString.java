package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.Charsets2;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.Buffer3;
import p615g0.C12384a;
import p615g0.p616z.ByteString4;

/* compiled from: ByteString.kt */
/* loaded from: classes3.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long serialVersionUID = 1;
    private final byte[] data;

    /* renamed from: l, reason: from kotlin metadata */
    public transient int hashCode;

    /* renamed from: m, reason: from kotlin metadata */
    public transient String utf8;

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j */
    public static final ByteString f27592j = new ByteString(new byte[0]);

    /* compiled from: ByteString.kt */
    /* renamed from: okio.ByteString$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: d */
        public static ByteString m11009d(Companion companion, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            Intrinsics3.checkParameterIsNotNull(bArr, "$this$toByteString");
            C3404f.m4192B(bArr.length, i, i2);
            return new ByteString(_ArraysJvm.copyOfRange(bArr, i, i2 + i));
        }

        /* renamed from: a */
        public final ByteString m11010a(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$decodeHex");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(outline.m883w("Unexpected hex string: ", str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (ByteString4.m10515a(str.charAt(i2 + 1)) + (ByteString4.m10515a(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }

        /* renamed from: b */
        public final ByteString m11011b(String str, Charset charset) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$encode");
            Intrinsics3.checkParameterIsNotNull(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        /* renamed from: c */
        public final ByteString m11012c(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$encodeUtf8");
            Intrinsics3.checkParameterIsNotNull(str, "$this$asUtf8ToByteArray");
            byte[] bytes = str.getBytes(Charsets2.f25136a);
            Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            ByteString byteString = new ByteString(bytes);
            byteString.utf8 = str;
            return byteString;
        }
    }

    public ByteString(byte[] bArr) {
        Intrinsics3.checkParameterIsNotNull(bArr, "data");
        this.data = bArr;
    }

    /* renamed from: h */
    public static final ByteString m11006h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$encodeUtf8");
        Intrinsics3.checkParameterIsNotNull(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(Charsets2.f25136a);
        Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        ByteString byteString = new ByteString(bytes);
        byteString.utf8 = str;
        return byteString;
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        int i = in.readInt();
        Intrinsics3.checkParameterIsNotNull(in, "$this$readByteString");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.m871q("byteCount < 0: ", i).toString());
        }
        byte[] bArr = new byte[i];
        while (i2 < i) {
            int i3 = in.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        ByteString byteString = new ByteString(bArr);
        Field declaredField = ByteString.class.getDeclaredField("data");
        Intrinsics3.checkExpressionValueIsNotNull(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(ByteString byteString) {
        ByteString byteString2 = byteString;
        Intrinsics3.checkParameterIsNotNull(byteString2, "other");
        int iMo10502j = mo10502j();
        int iMo10502j2 = byteString2.mo10502j();
        int iMin = Math.min(iMo10502j, iMo10502j2);
        for (int i = 0; i < iMin; i++) {
            int iMo10505m = mo10505m(i) & 255;
            int iMo10505m2 = byteString2.mo10505m(i) & 255;
            if (iMo10505m != iMo10505m2) {
                return iMo10505m < iMo10505m2 ? -1 : 1;
            }
        }
        if (iMo10502j == iMo10502j2) {
            return 0;
        }
        if (iMo10502j < iMo10502j2) {
        }
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            int iMo10502j = byteString.mo10502j();
            byte[] bArr = this.data;
            if (iMo10502j == bArr.length && byteString.mo10507o(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public String mo10500f() {
        byte[] bArr = this.data;
        byte[] bArr2 = C12384a.f26067a;
        byte[] bArr3 = C12384a.f26067a;
        Intrinsics3.checkParameterIsNotNull(bArr, "$this$encodeBase64");
        Intrinsics3.checkParameterIsNotNull(bArr3, "map");
        byte[] bArr4 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b2 = bArr[i];
            int i4 = i3 + 1;
            byte b3 = bArr[i3];
            int i5 = i4 + 1;
            byte b4 = bArr[i4];
            int i6 = i2 + 1;
            bArr4[i2] = bArr3[(b2 & 255) >> 2];
            int i7 = i6 + 1;
            bArr4[i6] = bArr3[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i8 = i7 + 1;
            bArr4[i7] = bArr3[((b3 & 15) << 2) | ((b4 & 255) >> 6)];
            i2 = i8 + 1;
            bArr4[i8] = bArr3[b4 & 63];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i];
            int i9 = i2 + 1;
            bArr4[i2] = bArr3[(b5 & 255) >> 2];
            int i10 = i9 + 1;
            bArr4[i9] = bArr3[(b5 & 3) << 4];
            byte b6 = (byte) 61;
            bArr4[i10] = b6;
            bArr4[i10 + 1] = b6;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b7 = bArr[i];
            byte b8 = bArr[i11];
            int i12 = i2 + 1;
            bArr4[i2] = bArr3[(b7 & 255) >> 2];
            int i13 = i12 + 1;
            bArr4[i12] = bArr3[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            bArr4[i13] = bArr3[(b8 & 15) << 2];
            bArr4[i13 + 1] = (byte) 61;
        }
        Intrinsics3.checkParameterIsNotNull(bArr4, "$this$toUtf8String");
        return new String(bArr4, Charsets2.f25136a);
    }

    /* renamed from: g */
    public ByteString mo10501g(String algorithm) {
        Intrinsics3.checkParameterIsNotNull(algorithm, "algorithm");
        byte[] bArrDigest = MessageDigest.getInstance(algorithm).digest(this.data);
        Intrinsics3.checkExpressionValueIsNotNull(bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(bArrDigest);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    /* renamed from: i, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: j */
    public int mo10502j() {
        return this.data.length;
    }

    /* renamed from: k */
    public String mo10503k() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = ByteString4.f26138a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: l */
    public byte[] mo10504l() {
        return this.data;
    }

    /* renamed from: m */
    public byte mo10505m(int pos) {
        return this.data[pos];
    }

    /* renamed from: n */
    public boolean mo10506n(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics3.checkParameterIsNotNull(other, "other");
        return other.mo10507o(otherOffset, this.data, offset, byteCount);
    }

    /* renamed from: o */
    public boolean mo10507o(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics3.checkParameterIsNotNull(other, "other");
        if (offset >= 0) {
            byte[] bArr = this.data;
            if (offset <= bArr.length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && C3404f.m4295h(bArr, offset, other, otherOffset, byteCount)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: p */
    public ByteString mo10508p() {
        byte b2;
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b3 = bArr[i];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics3.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b3 + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b5 = bArrCopyOf[i2];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i2] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i++;
        }
    }

    /* renamed from: q */
    public String m11008q() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        byte[] bArrMo10504l = mo10504l();
        Intrinsics3.checkParameterIsNotNull(bArrMo10504l, "$this$toUtf8String");
        String str2 = new String(bArrMo10504l, Charsets2.f25136a);
        this.utf8 = str2;
        return str2;
    }

    /* renamed from: r */
    public void mo10509r(OutputStream out) throws IOException {
        Intrinsics3.checkParameterIsNotNull(out, "out");
        out.write(this.data);
    }

    /* renamed from: s */
    public void mo10510s(Buffer3 buffer, int offset, int byteCount) {
        Intrinsics3.checkParameterIsNotNull(buffer, "buffer");
        Intrinsics3.checkParameterIsNotNull(this, "$this$commonWrite");
        Intrinsics3.checkParameterIsNotNull(buffer, "buffer");
        buffer.m10443S(this.data, offset, byteCount);
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        loop0: while (true) {
            if (i >= length) {
                break;
            }
            byte b2 = bArr[i];
            if (b2 >= 0) {
                int i4 = i2 + 1;
                if (i2 == 64) {
                    break;
                }
                if (b2 != 10 && b2 != 13) {
                    if ((b2 >= 0 && 31 >= b2) || (127 <= b2 && 159 >= b2)) {
                        break;
                    }
                } else {
                    if (b2 == 65533) {
                        break;
                    }
                    i3 += b2 < 65536 ? 1 : 2;
                    i++;
                    while (true) {
                        i2 = i4;
                        if (i < length && bArr[i] >= 0) {
                            int i5 = i + 1;
                            byte b3 = bArr[i];
                            i4 = i2 + 1;
                            if (i2 == 64) {
                                break loop0;
                            }
                            if (b3 != 10 && b3 != 13) {
                                if ((b3 >= 0 && 31 >= b3) || (127 <= b3 && 159 >= b3)) {
                                    break loop0;
                                }
                            } else {
                                if (b3 == 65533) {
                                    break loop0;
                                }
                                i3 += b3 < 65536 ? 1 : 2;
                                i = i5;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } else if ((b2 >> 5) == -2) {
                int i6 = i + 1;
                if (length > i6) {
                    byte b4 = bArr[i];
                    byte b5 = bArr[i6];
                    if ((b5 & 192) == 128) {
                        int i7 = (b5 ^ 3968) ^ (b4 << 6);
                        if (i7 >= 128) {
                            int i8 = i2 + 1;
                            if (i2 == 64) {
                                break;
                            }
                            if (i7 != 10 && i7 != 13) {
                                if ((i7 >= 0 && 31 >= i7) || (127 <= i7 && 159 >= i7)) {
                                    break;
                                }
                            } else {
                                if (i7 == 65533) {
                                    break;
                                }
                                i3 += i7 < 65536 ? 1 : 2;
                                i += 2;
                                i2 = i8;
                            }
                        } else if (i2 != 64) {
                            break;
                        }
                    } else if (i2 != 64) {
                        break;
                    }
                } else if (i2 != 64) {
                    break;
                }
            } else if ((b2 >> 4) == -2) {
                int i9 = i + 2;
                if (length > i9) {
                    byte b6 = bArr[i];
                    byte b7 = bArr[i + 1];
                    if ((b7 & 192) == 128) {
                        byte b8 = bArr[i9];
                        if ((b8 & 192) == 128) {
                            int i10 = ((b8 ^ (-123008)) ^ (b7 << 6)) ^ (b6 << 12);
                            if (i10 >= 2048) {
                                if (55296 > i10 || 57343 < i10) {
                                    int i11 = i2 + 1;
                                    if (i2 == 64) {
                                        break;
                                    }
                                    if (i10 != 10 && i10 != 13) {
                                        if ((i10 >= 0 && 31 >= i10) || (127 <= i10 && 159 >= i10)) {
                                            break;
                                        }
                                    } else {
                                        if (i10 == 65533) {
                                            break;
                                        }
                                        i3 += i10 < 65536 ? 1 : 2;
                                        i += 3;
                                        i2 = i11;
                                    }
                                } else if (i2 != 64) {
                                    break;
                                }
                            } else if (i2 != 64) {
                                break;
                            }
                        } else if (i2 != 64) {
                            break;
                        }
                    } else if (i2 != 64) {
                        break;
                    }
                } else if (i2 != 64) {
                    break;
                }
            } else if ((b2 >> 3) == -2) {
                int i12 = i + 3;
                if (length > i12) {
                    byte b9 = bArr[i];
                    byte b10 = bArr[i + 1];
                    if ((b10 & 192) == 128) {
                        byte b11 = bArr[i + 2];
                        if ((b11 & 192) == 128) {
                            byte b12 = bArr[i12];
                            if ((b12 & 192) == 128) {
                                int i13 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b9 << 18);
                                if (i13 <= 1114111) {
                                    if (55296 > i13 || 57343 < i13) {
                                        if (i13 >= 65536) {
                                            int i14 = i2 + 1;
                                            if (i2 == 64) {
                                                break;
                                            }
                                            if (i13 != 10 && i13 != 13) {
                                                if ((i13 >= 0 && 31 >= i13) || (127 <= i13 && 159 >= i13)) {
                                                    break;
                                                }
                                            } else {
                                                if (i13 == 65533) {
                                                    break;
                                                }
                                                i3 += i13 < 65536 ? 1 : 2;
                                                i += 4;
                                                i2 = i14;
                                            }
                                        } else if (i2 != 64) {
                                            break;
                                        }
                                    } else if (i2 != 64) {
                                        break;
                                    }
                                } else if (i2 != 64) {
                                    break;
                                }
                            } else if (i2 != 64) {
                                break;
                            }
                        } else if (i2 != 64) {
                            break;
                        }
                    } else if (i2 != 64) {
                        break;
                    }
                } else if (i2 != 64) {
                    break;
                }
            } else if (i2 != 64) {
                break;
            }
        }
        i3 = -1;
        if (i3 == -1) {
            if (this.data.length <= 64) {
                StringBuilder sbM833U = outline.m833U("[hex=");
                sbM833U.append(mo10503k());
                sbM833U.append(']');
                return sbM833U.toString();
            }
            StringBuilder sbM833U2 = outline.m833U("[size=");
            sbM833U2.append(this.data.length);
            sbM833U2.append(" hex=");
            byte[] bArr2 = this.data;
            if (!(64 <= bArr2.length)) {
                throw new IllegalArgumentException(outline.m813A(outline.m833U("endIndex > length("), this.data.length, ')').toString());
            }
            sbM833U2.append((64 == bArr2.length ? this : new ByteString(_ArraysJvm.copyOfRange(bArr2, 0, 64))).mo10503k());
            sbM833U2.append("…]");
            return sbM833U2.toString();
        }
        String strM11008q = m11008q();
        String strSubstring = strM11008q.substring(0, i3);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strReplace$default = StringsJVM.replace$default(StringsJVM.replace$default(StringsJVM.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (i3 >= strM11008q.length()) {
            return "[text=" + strReplace$default + ']';
        }
        StringBuilder sbM833U3 = outline.m833U("[size=");
        sbM833U3.append(this.data.length);
        sbM833U3.append(" text=");
        sbM833U3.append(strReplace$default);
        sbM833U3.append("…]");
        return sbM833U3.toString();
    }
}
