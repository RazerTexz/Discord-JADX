package p615g0;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import okio.ByteString;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.u, reason: use source file name */
/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SegmentedByteString extends ByteString {

    /* JADX INFO: renamed from: n */
    public final transient byte[][] f26129n;

    /* JADX INFO: renamed from: o */
    public final transient int[] f26130o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.f27592j.getData());
        Intrinsics3.checkParameterIsNotNull(bArr, "segments");
        Intrinsics3.checkParameterIsNotNull(iArr, "directory");
        this.f26129n = bArr;
        this.f26130o = iArr;
    }

    private final Object writeReplace() {
        return m10512u();
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.mo10502j() == mo10502j() && mo10506n(0, byteString, 0, mo10502j())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: f */
    public String mo10500f() {
        return m10512u().mo10500f();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: g */
    public ByteString mo10501g(String str) throws NoSuchAlgorithmException {
        Intrinsics3.checkParameterIsNotNull(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = this.f26129n.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f26130o;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            messageDigest.update(this.f26129n[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics3.checkExpressionValueIsNotNull(bArrDigest, "digest.digest()");
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.f26129n.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.f26130o;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr = this.f26129n[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: j */
    public int mo10502j() {
        return this.f26130o[this.f26129n.length - 1];
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: k */
    public String mo10503k() {
        return m10512u().mo10503k();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: l */
    public byte[] mo10504l() {
        return m10511t();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: m */
    public byte mo10505m(int i) {
        C3404f.m4192B(this.f26130o[this.f26129n.length - 1], i, 1L);
        int iM4269a1 = C3404f.m4269a1(this, i);
        int i2 = iM4269a1 == 0 ? 0 : this.f26130o[iM4269a1 - 1];
        int[] iArr = this.f26130o;
        byte[][] bArr = this.f26129n;
        return bArr[iM4269a1][(i - i2) + iArr[bArr.length + iM4269a1]];
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: n */
    public boolean mo10506n(int i, ByteString byteString, int i2, int i3) {
        Intrinsics3.checkParameterIsNotNull(byteString, "other");
        if (i < 0 || i > mo10502j() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iM4269a1 = C3404f.m4269a1(this, i);
        while (i < i4) {
            int i5 = iM4269a1 == 0 ? 0 : this.f26130o[iM4269a1 - 1];
            int[] iArr = this.f26130o;
            int i6 = iArr[iM4269a1] - i5;
            int i7 = iArr[this.f26129n.length + iM4269a1];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!byteString.mo10507o(i2, this.f26129n[iM4269a1], (i - i5) + i7, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iM4269a1++;
        }
        return true;
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: o */
    public boolean mo10507o(int i, byte[] bArr, int i2, int i3) {
        Intrinsics3.checkParameterIsNotNull(bArr, "other");
        if (i < 0 || i > mo10502j() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iM4269a1 = C3404f.m4269a1(this, i);
        while (i < i4) {
            int i5 = iM4269a1 == 0 ? 0 : this.f26130o[iM4269a1 - 1];
            int[] iArr = this.f26130o;
            int i6 = iArr[iM4269a1] - i5;
            int i7 = iArr[this.f26129n.length + iM4269a1];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!C3404f.m4295h(this.f26129n[iM4269a1], (i - i5) + i7, bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iM4269a1++;
        }
        return true;
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: p */
    public ByteString mo10508p() {
        return m10512u().mo10508p();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: r */
    public void mo10509r(OutputStream outputStream) throws IOException {
        Intrinsics3.checkParameterIsNotNull(outputStream, "out");
        int length = this.f26129n.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f26130o;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.f26129n[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: s */
    public void mo10510s(Buffer3 buffer3, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "buffer");
        int i3 = i2 + i;
        int iM4269a1 = C3404f.m4269a1(this, i);
        while (i < i3) {
            int i4 = iM4269a1 == 0 ? 0 : this.f26130o[iM4269a1 - 1];
            int[] iArr = this.f26130o;
            int i5 = iArr[iM4269a1] - i4;
            int i6 = iArr[this.f26129n.length + iM4269a1];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = (i - i4) + i6;
            Segment2 segment2 = new Segment2(this.f26129n[iM4269a1], i7, i7 + iMin, true, false);
            Segment2 segment22 = buffer3.f26079j;
            if (segment22 == null) {
                segment2.f26124g = segment2;
                segment2.f26123f = segment2;
                buffer3.f26079j = segment2;
            } else {
                Segment2 segment23 = segment22.f26124g;
                if (segment23 == null) {
                    Intrinsics3.throwNpe();
                }
                segment23.m10495b(segment2);
            }
            i += iMin;
            iM4269a1++;
        }
        buffer3.f26080k += (long) mo10502j();
    }

    /* JADX INFO: renamed from: t */
    public byte[] m10511t() {
        byte[] bArr = new byte[mo10502j()];
        int length = this.f26129n.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.f26130o;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            _ArraysJvm.copyInto(this.f26129n[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return m10512u().toString();
    }

    /* JADX INFO: renamed from: u */
    public final ByteString m10512u() {
        return new ByteString(m10511t());
    }
}
