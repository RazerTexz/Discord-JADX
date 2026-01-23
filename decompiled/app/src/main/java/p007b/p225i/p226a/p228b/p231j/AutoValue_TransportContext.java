package p007b.p225i.p226a.p228b.p231j;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.Priority3;
import p007b.p225i.p226a.p228b.p231j.TransportContext;

/* JADX INFO: renamed from: b.i.a.b.j.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_TransportContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_TransportContext extends TransportContext {

    /* JADX INFO: renamed from: a */
    public final String f5258a;

    /* JADX INFO: renamed from: b */
    public final byte[] f5259b;

    /* JADX INFO: renamed from: c */
    public final Priority3 f5260c;

    /* JADX INFO: renamed from: b.i.a.b.j.b$b */
    /* JADX INFO: compiled from: AutoValue_TransportContext.java */
    public static final class b extends TransportContext.a {

        /* JADX INFO: renamed from: a */
        public String f5261a;

        /* JADX INFO: renamed from: b */
        public byte[] f5262b;

        /* JADX INFO: renamed from: c */
        public Priority3 f5263c;

        @Override // p007b.p225i.p226a.p228b.p231j.TransportContext.a
        /* JADX INFO: renamed from: a */
        public TransportContext mo2351a() {
            String strM883w = this.f5261a == null ? " backendName" : "";
            if (this.f5263c == null) {
                strM883w = outline.m883w(strM883w, " priority");
            }
            if (strM883w.isEmpty()) {
                return new AutoValue_TransportContext(this.f5261a, this.f5262b, this.f5263c, null);
            }
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }

        @Override // p007b.p225i.p226a.p228b.p231j.TransportContext.a
        /* JADX INFO: renamed from: b */
        public TransportContext.a mo2352b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.f5261a = str;
            return this;
        }

        @Override // p007b.p225i.p226a.p228b.p231j.TransportContext.a
        /* JADX INFO: renamed from: c */
        public TransportContext.a mo2353c(Priority3 priority3) {
            Objects.requireNonNull(priority3, "Null priority");
            this.f5263c = priority3;
            return this;
        }
    }

    public AutoValue_TransportContext(String str, byte[] bArr, Priority3 priority3, a aVar) {
        this.f5258a = str;
        this.f5259b = bArr;
        this.f5260c = priority3;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.TransportContext
    /* JADX INFO: renamed from: b */
    public String mo2348b() {
        return this.f5258a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.TransportContext
    @Nullable
    /* JADX INFO: renamed from: c */
    public byte[] mo2349c() {
        return this.f5259b;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.TransportContext
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* JADX INFO: renamed from: d */
    public Priority3 mo2350d() {
        return this.f5260c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f5258a.equals(transportContext.mo2348b())) {
            if (Arrays.equals(this.f5259b, transportContext instanceof AutoValue_TransportContext ? ((AutoValue_TransportContext) transportContext).f5259b : transportContext.mo2349c()) && this.f5260c.equals(transportContext.mo2350d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f5258a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5259b)) * 1000003) ^ this.f5260c.hashCode();
    }
}
