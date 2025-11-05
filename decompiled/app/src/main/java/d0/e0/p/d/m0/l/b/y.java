package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.f.c;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProtoContainer.kt */
/* loaded from: classes3.dex */
public abstract class y {
    public final d0.e0.p.d.m0.f.z.c a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.z.g f3510b;
    public final u0 c;

    /* compiled from: ProtoContainer.kt */
    public static final class a extends y {
        public final d0.e0.p.d.m0.f.c d;
        public final a e;
        public final d0.e0.p.d.m0.g.a f;
        public final c.EnumC0550c g;
        public final boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d0.e0.p.d.m0.f.c cVar, d0.e0.p.d.m0.f.z.c cVar2, d0.e0.p.d.m0.f.z.g gVar, u0 u0Var, a aVar) {
            super(cVar2, gVar, u0Var, null);
            d0.z.d.m.checkNotNullParameter(cVar, "classProto");
            d0.z.d.m.checkNotNullParameter(cVar2, "nameResolver");
            d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
            this.d = cVar;
            this.e = aVar;
            this.f = w.getClassId(cVar2, cVar.getFqName());
            c.EnumC0550c enumC0550c = d0.e0.p.d.m0.f.z.b.e.get(cVar.getFlags());
            this.g = enumC0550c == null ? c.EnumC0550c.CLASS : enumC0550c;
            Boolean bool = d0.e0.p.d.m0.f.z.b.f.get(cVar.getFlags());
            d0.z.d.m.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
            this.h = bool.booleanValue();
        }

        @Override // d0.e0.p.d.m0.l.b.y
        public d0.e0.p.d.m0.g.b debugFqName() {
            d0.e0.p.d.m0.g.b bVarAsSingleFqName = this.f.asSingleFqName();
            d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName, "classId.asSingleFqName()");
            return bVarAsSingleFqName;
        }

        public final d0.e0.p.d.m0.g.a getClassId() {
            return this.f;
        }

        public final d0.e0.p.d.m0.f.c getClassProto() {
            return this.d;
        }

        public final c.EnumC0550c getKind() {
            return this.g;
        }

        public final a getOuterClass() {
            return this.e;
        }

        public final boolean isInner() {
            return this.h;
        }
    }

    /* compiled from: ProtoContainer.kt */
    public static final class b extends y {
        public final d0.e0.p.d.m0.g.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, u0 u0Var) {
            super(cVar, gVar, u0Var, null);
            d0.z.d.m.checkNotNullParameter(bVar, "fqName");
            d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
            d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
            this.d = bVar;
        }

        @Override // d0.e0.p.d.m0.l.b.y
        public d0.e0.p.d.m0.g.b debugFqName() {
            return this.d;
        }
    }

    public y(d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, u0 u0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = cVar;
        this.f3510b = gVar;
        this.c = u0Var;
    }

    public abstract d0.e0.p.d.m0.g.b debugFqName();

    public final d0.e0.p.d.m0.f.z.c getNameResolver() {
        return this.a;
    }

    public final u0 getSource() {
        return this.c;
    }

    public final d0.e0.p.d.m0.f.z.g getTypeTable() {
        return this.f3510b;
    }

    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + debugFqName();
    }
}
