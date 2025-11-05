package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.i1.j0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: AbstractTypeAliasDescriptor.kt */
/* loaded from: classes3.dex */
public abstract class e extends l implements y0 {
    public final d0.e0.p.d.m0.c.u n;
    public List<? extends z0> o;
    public final b p;

    /* compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class a extends d0.z.d.o implements Function1<i1, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(i1 i1Var) {
            return invoke2(i1Var);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean invoke2(i1 i1Var) {
            boolean z2;
            d0.z.d.m.checkNotNullExpressionValue(i1Var, "type");
            if (!d0.e0.p.d.m0.n.e0.isError(i1Var)) {
                e eVar = e.this;
                d0.e0.p.d.m0.c.h declarationDescriptor = i1Var.getConstructor().getDeclarationDescriptor();
                z2 = (declarationDescriptor instanceof z0) && !d0.z.d.m.areEqual(((z0) declarationDescriptor).getContainingDeclaration(), eVar);
            }
            return Boolean.valueOf(z2);
        }
    }

    /* compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class b implements u0 {
        public b() {
        }

        @Override // d0.e0.p.d.m0.n.u0
        public d0.e0.p.d.m0.b.h getBuiltIns() {
            return d0.e0.p.d.m0.k.x.a.getBuiltIns(getDeclarationDescriptor());
        }

        @Override // d0.e0.p.d.m0.n.u0
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // d0.e0.p.d.m0.n.u0
        public List<z0> getParameters() {
            List list = ((d0.e0.p.d.m0.l.b.e0.l) e.this).f3498z;
            if (list != null) {
                return list;
            }
            d0.z.d.m.throwUninitializedPropertyAccessException("typeConstructorParameters");
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public Collection<d0.e0.p.d.m0.n.c0> getSupertypes() {
            Collection<d0.e0.p.d.m0.n.c0> supertypes = getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
            d0.z.d.m.checkNotNullExpressionValue(supertypes, "declarationDescriptor.underlyingType.constructor.supertypes");
            return supertypes;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public boolean isDenotable() {
            return true;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
            return this;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("[typealias ");
            sbU.append(getDeclarationDescriptor().getName().asString());
            sbU.append(']');
            return sbU.toString();
        }

        @Override // d0.e0.p.d.m0.n.u0
        public y0 getDeclarationDescriptor() {
            return e.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.u0 u0Var, d0.e0.p.d.m0.c.u uVar) {
        super(mVar, gVar, eVar, u0Var);
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(u0Var, "sourceElement");
        d0.z.d.m.checkNotNullParameter(uVar, "visibilityImpl");
        this.n = uVar;
        this.p = new b();
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        d0.z.d.m.checkNotNullParameter(oVar, "visitor");
        return oVar.visitTypeAliasDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        List list = this.o;
        if (list != null) {
            return list;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getOriginal() {
        return getOriginal();
    }

    public final Collection<i0> getTypeAliasConstructors() {
        d0.e0.p.d.m0.l.b.e0.l lVar = (d0.e0.p.d.m0.l.b.e0.l) this;
        d0.e0.p.d.m0.c.e classDescriptor = lVar.getClassDescriptor();
        if (classDescriptor == null) {
            return d0.t.n.emptyList();
        }
        Collection<d0.e0.p.d.m0.c.d> constructors = classDescriptor.getConstructors();
        d0.z.d.m.checkNotNullExpressionValue(constructors, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.c.d dVar : constructors) {
            j0.a aVar = j0.M;
            d0.e0.p.d.m0.m.o oVar = lVar.q;
            d0.z.d.m.checkNotNullExpressionValue(dVar, "it");
            i0 i0VarCreateIfAvailable = aVar.createIfAvailable(oVar, this, dVar);
            if (i0VarCreateIfAvailable != null) {
                arrayList.add(i0VarCreateIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.h
    public u0 getTypeConstructor() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        return this.n;
    }

    public final void initialize(List<? extends z0> list) {
        d0.z.d.m.checkNotNullParameter(list, "declaredTypeParameters");
        this.o = list;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return e1.contains(((d0.e0.p.d.m0.l.b.e0.l) this).getUnderlyingType(), new a());
    }

    @Override // d0.e0.p.d.m0.c.i1.k
    public String toString() {
        return d0.z.d.m.stringPlus("typealias ", getName().asString());
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public y0 getOriginal() {
        return (y0) super.getOriginal();
    }
}
