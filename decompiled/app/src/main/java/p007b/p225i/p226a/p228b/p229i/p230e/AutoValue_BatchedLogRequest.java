package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.a.b.i.e.d, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_BatchedLogRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_BatchedLogRequest extends BatchedLogRequest {

    /* JADX INFO: renamed from: a */
    public final List<LogRequest> f5164a;

    public AutoValue_BatchedLogRequest(List<LogRequest> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.f5164a = list;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.BatchedLogRequest
    @NonNull
    /* JADX INFO: renamed from: a */
    public List<LogRequest> mo2313a() {
        return this.f5164a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.f5164a.equals(((BatchedLogRequest) obj).mo2313a());
        }
        return false;
    }

    public int hashCode() {
        return this.f5164a.hashCode() ^ 1000003;
    }

    public String toString() {
        return outline.m824L(outline.m833U("BatchedLogRequest{logRequests="), this.f5164a, "}");
    }
}
