package p007b.p225i.p226a.p228b.p231j.p232q;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p231j.EventInternal;

/* JADX INFO: renamed from: b.i.a.b.j.q.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_BackendRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_BackendRequest extends BackendRequest {

    /* JADX INFO: renamed from: a */
    public final Iterable<EventInternal> f5300a;

    /* JADX INFO: renamed from: b */
    public final byte[] f5301b;

    public AutoValue_BackendRequest(Iterable iterable, byte[] bArr, a aVar) {
        this.f5300a = iterable;
        this.f5301b = bArr;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.BackendRequest
    /* JADX INFO: renamed from: a */
    public Iterable<EventInternal> mo2362a() {
        return this.f5300a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.BackendRequest
    @Nullable
    /* JADX INFO: renamed from: b */
    public byte[] mo2363b() {
        return this.f5301b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f5300a.equals(backendRequest.mo2362a())) {
            if (Arrays.equals(this.f5301b, backendRequest instanceof AutoValue_BackendRequest ? ((AutoValue_BackendRequest) backendRequest).f5301b : backendRequest.mo2363b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5300a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5301b);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("BackendRequest{events=");
        sbM833U.append(this.f5300a);
        sbM833U.append(", extras=");
        sbM833U.append(Arrays.toString(this.f5301b));
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
