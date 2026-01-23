package p007b.p225i.p226a.p228b.p231j.p232q;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;

/* JADX INFO: renamed from: b.i.a.b.j.q.c, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CreationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CreationContext extends CreationContext {

    /* JADX INFO: renamed from: a */
    public final Context f5304a;

    /* JADX INFO: renamed from: b */
    public final Clock3 f5305b;

    /* JADX INFO: renamed from: c */
    public final Clock3 f5306c;

    /* JADX INFO: renamed from: d */
    public final String f5307d;

    public AutoValue_CreationContext(Context context, Clock3 clock3, Clock3 clock32, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.f5304a = context;
        Objects.requireNonNull(clock3, "Null wallClock");
        this.f5305b = clock3;
        Objects.requireNonNull(clock32, "Null monotonicClock");
        this.f5306c = clock32;
        Objects.requireNonNull(str, "Null backendName");
        this.f5307d = str;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.CreationContext
    /* JADX INFO: renamed from: a */
    public Context mo2366a() {
        return this.f5304a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.CreationContext
    @NonNull
    /* JADX INFO: renamed from: b */
    public String mo2367b() {
        return this.f5307d;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.CreationContext
    /* JADX INFO: renamed from: c */
    public Clock3 mo2368c() {
        return this.f5306c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.CreationContext
    /* JADX INFO: renamed from: d */
    public Clock3 mo2369d() {
        return this.f5305b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        return this.f5304a.equals(creationContext.mo2366a()) && this.f5305b.equals(creationContext.mo2369d()) && this.f5306c.equals(creationContext.mo2368c()) && this.f5307d.equals(creationContext.mo2367b());
    }

    public int hashCode() {
        return ((((((this.f5304a.hashCode() ^ 1000003) * 1000003) ^ this.f5305b.hashCode()) * 1000003) ^ this.f5306c.hashCode()) * 1000003) ^ this.f5307d.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CreationContext{applicationContext=");
        sbM833U.append(this.f5304a);
        sbM833U.append(", wallClock=");
        sbM833U.append(this.f5305b);
        sbM833U.append(", monotonicClock=");
        sbM833U.append(this.f5306c);
        sbM833U.append(", backendName=");
        return outline.m822J(sbM833U, this.f5307d, "}");
    }
}
