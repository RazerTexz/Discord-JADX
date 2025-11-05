package d0.e0.p.d.m0.c.h1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.n.c0;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;

/* compiled from: AdditionalClassPartsProvider.kt */
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: AdditionalClassPartsProvider.kt */
    /* renamed from: d0.e0.p.d.m0.c.h1.a$a, reason: collision with other inner class name */
    public static final class C0513a implements a {
        public static final C0513a a = new C0513a();

        @Override // d0.e0.p.d.m0.c.h1.a
        public Collection<d0.e0.p.d.m0.c.d> getConstructors(d0.e0.p.d.m0.c.e eVar) {
            m.checkNotNullParameter(eVar, "classDescriptor");
            return n.emptyList();
        }

        @Override // d0.e0.p.d.m0.c.h1.a
        public Collection<t0> getFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.e eVar2) {
            m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkNotNullParameter(eVar2, "classDescriptor");
            return n.emptyList();
        }

        @Override // d0.e0.p.d.m0.c.h1.a
        public Collection<d0.e0.p.d.m0.g.e> getFunctionsNames(d0.e0.p.d.m0.c.e eVar) {
            m.checkNotNullParameter(eVar, "classDescriptor");
            return n.emptyList();
        }

        @Override // d0.e0.p.d.m0.c.h1.a
        public Collection<c0> getSupertypes(d0.e0.p.d.m0.c.e eVar) {
            m.checkNotNullParameter(eVar, "classDescriptor");
            return n.emptyList();
        }
    }

    Collection<d0.e0.p.d.m0.c.d> getConstructors(d0.e0.p.d.m0.c.e eVar);

    Collection<t0> getFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.e eVar2);

    Collection<d0.e0.p.d.m0.g.e> getFunctionsNames(d0.e0.p.d.m0.c.e eVar);

    Collection<c0> getSupertypes(d0.e0.p.d.m0.c.e eVar);
}
