package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.a;
import kotlin.Pair;

/* compiled from: ContractDeserializer.kt */
/* loaded from: classes3.dex */
public interface i {
    public static final a a = a.a;

    /* compiled from: ContractDeserializer.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final i f3502b = new C0577a();

        /* compiled from: ContractDeserializer.kt */
        /* renamed from: d0.e0.p.d.m0.l.b.i$a$a, reason: collision with other inner class name */
        public static final class C0577a implements i {
            @Override // d0.e0.p.d.m0.l.b.i
            public Pair deserializeContractFromFunction(d0.e0.p.d.m0.f.i iVar, d0.e0.p.d.m0.c.x xVar, d0.e0.p.d.m0.f.z.g gVar, c0 c0Var) {
                d0.z.d.m.checkNotNullParameter(iVar, "proto");
                d0.z.d.m.checkNotNullParameter(xVar, "ownerFunction");
                d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
                d0.z.d.m.checkNotNullParameter(c0Var, "typeDeserializer");
                return null;
            }
        }

        public final i getDEFAULT() {
            return f3502b;
        }
    }

    Pair<a.InterfaceC0511a<?>, Object> deserializeContractFromFunction(d0.e0.p.d.m0.f.i iVar, d0.e0.p.d.m0.c.x xVar, d0.e0.p.d.m0.f.z.g gVar, c0 c0Var);
}
