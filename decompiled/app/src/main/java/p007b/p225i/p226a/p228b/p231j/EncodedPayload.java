package p007b.p225i.p226a.p228b.p231j;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.Encoding2;

/* JADX INFO: renamed from: b.i.a.b.j.e, reason: use source file name */
/* JADX INFO: compiled from: EncodedPayload.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EncodedPayload {

    /* JADX INFO: renamed from: a */
    public final Encoding2 f5276a;

    /* JADX INFO: renamed from: b */
    public final byte[] f5277b;

    public EncodedPayload(@NonNull Encoding2 encoding2, @NonNull byte[] bArr) {
        Objects.requireNonNull(encoding2, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.f5276a = encoding2;
        this.f5277b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (this.f5276a.equals(encodedPayload.f5276a)) {
            return Arrays.equals(this.f5277b, encodedPayload.f5277b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5276a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5277b);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EncodedPayload{encoding=");
        sbM833U.append(this.f5276a);
        sbM833U.append(", bytes=[...]}");
        return sbM833U.toString();
    }
}
