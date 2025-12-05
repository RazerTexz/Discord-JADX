package p007b.p225i.p226a.p228b.p229i.p230e;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: AutoValue_LogResponse.java */
/* renamed from: b.i.a.b.i.e.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_LogResponse extends LogResponse {

    /* renamed from: a */
    public final long f5188a;

    public AutoValue_LogResponse(long j) {
        this.f5188a = j;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.LogResponse
    /* renamed from: b */
    public long mo2330b() {
        return this.f5188a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.f5188a == ((LogResponse) obj).mo2330b();
    }

    public int hashCode() {
        long j = this.f5188a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return outline.m815C(outline.m833U("LogResponse{nextRequestWaitMillis="), this.f5188a, "}");
    }
}
