package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* loaded from: classes3.dex */
public final class p extends z0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3533b = new a(null);
    public final z0 c;
    public final z0 d;

    /* compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final z0 create(z0 z0Var, z0 z0Var2) {
            d0.z.d.m.checkNotNullParameter(z0Var, "first");
            d0.z.d.m.checkNotNullParameter(z0Var2, "second");
            return z0Var.isEmpty() ? z0Var2 : z0Var2.isEmpty() ? z0Var : new p(z0Var, z0Var2, null);
        }
    }

    public p(z0 z0Var, z0 z0Var2, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = z0Var;
        this.d = z0Var2;
    }

    public static final z0 create(z0 z0Var, z0 z0Var2) {
        return f3533b.create(z0Var, z0Var2);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean approximateCapturedTypes() {
        return this.c.approximateCapturedTypes() || this.d.approximateCapturedTypes();
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean approximateContravariantCapturedTypes() {
        return this.c.approximateContravariantCapturedTypes() || this.d.approximateContravariantCapturedTypes();
    }

    @Override // d0.e0.p.d.m0.n.z0
    public d0.e0.p.d.m0.c.g1.g filterAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        return this.d.filterAnnotations(this.c.filterAnnotations(gVar));
    }

    @Override // d0.e0.p.d.m0.n.z0
    public w0 get(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "key");
        w0 w0Var = this.c.get(c0Var);
        return w0Var == null ? this.d.get(c0Var) : w0Var;
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean isEmpty() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.z0
    public c0 prepareTopLevelType(c0 c0Var, j1 j1Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "topLevelType");
        d0.z.d.m.checkNotNullParameter(j1Var, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return this.d.prepareTopLevelType(this.c.prepareTopLevelType(c0Var, j1Var), j1Var);
    }
}
