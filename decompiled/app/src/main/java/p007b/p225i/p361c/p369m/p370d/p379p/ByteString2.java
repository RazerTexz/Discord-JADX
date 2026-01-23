package p007b.p225i.p361c.p369m.p370d.p379p;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: b.i.c.m.d.p.a, reason: use source file name */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ByteString2 {

    /* JADX INFO: renamed from: a */
    public final byte[] f12684a;

    /* JADX INFO: renamed from: b */
    public volatile int f12685b = 0;

    public ByteString2(byte[] bArr) {
        this.f12684a = bArr;
    }

    /* JADX INFO: renamed from: a */
    public static ByteString2 m6637a(String str) {
        try {
            return new ByteString2(str.getBytes(Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString2)) {
            return false;
        }
        byte[] bArr = this.f12684a;
        int length = bArr.length;
        byte[] bArr2 = ((ByteString2) obj).f12684a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f12685b;
        if (i == 0) {
            byte[] bArr = this.f12684a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i = length == 0 ? 1 : length;
            this.f12685b = i;
        }
        return i;
    }
}
