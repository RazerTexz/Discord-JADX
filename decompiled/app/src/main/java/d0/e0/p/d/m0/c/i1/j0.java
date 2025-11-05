package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.j1;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: TypeAliasConstructorDescriptor.kt */
/* loaded from: classes3.dex */
public final class j0 extends q implements i0 {
    public static final a M = new a(null);
    public static final /* synthetic */ KProperty<Object>[] N = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(j0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    public final d0.e0.p.d.m0.m.o O;
    public final y0 P;
    public d0.e0.p.d.m0.c.d Q;

    /* compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final c1 access$getTypeSubstitutorForUnderlyingClass(a aVar, y0 y0Var) {
            Objects.requireNonNull(aVar);
            if (y0Var.getClassDescriptor() == null) {
                return null;
            }
            return c1.create(y0Var.getExpandedType());
        }

        public final i0 createIfAvailable(d0.e0.p.d.m0.m.o oVar, y0 y0Var, d0.e0.p.d.m0.c.d dVar) {
            d0.e0.p.d.m0.c.d dVarSubstitute;
            d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
            d0.z.d.m.checkNotNullParameter(y0Var, "typeAliasDescriptor");
            d0.z.d.m.checkNotNullParameter(dVar, "constructor");
            c1 c1VarCreate = y0Var.getClassDescriptor() == null ? null : c1.create(y0Var.getExpandedType());
            if (c1VarCreate == null || (dVarSubstitute = dVar.substitute(c1VarCreate)) == null) {
                return null;
            }
            d0.e0.p.d.m0.c.g1.g annotations = dVar.getAnnotations();
            b.a kind = dVar.getKind();
            d0.z.d.m.checkNotNullExpressionValue(kind, "constructor.kind");
            u0 source = y0Var.getSource();
            d0.z.d.m.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            j0 j0Var = new j0(oVar, y0Var, dVarSubstitute, null, annotations, kind, source, null);
            List<d0.e0.p.d.m0.c.c1> substitutedValueParameters = q.getSubstitutedValueParameters(j0Var, dVar.getValueParameters(), c1VarCreate);
            if (substitutedValueParameters == null) {
                return null;
            }
            d0.e0.p.d.m0.n.j0 j0VarLowerIfFlexible = d0.e0.p.d.m0.n.y.lowerIfFlexible(dVarSubstitute.getReturnType().unwrap());
            d0.e0.p.d.m0.n.j0 defaultType = y0Var.getDefaultType();
            d0.z.d.m.checkNotNullExpressionValue(defaultType, "typeAliasDescriptor.defaultType");
            d0.e0.p.d.m0.n.j0 j0VarWithAbbreviation = d0.e0.p.d.m0.n.m0.withAbbreviation(j0VarLowerIfFlexible, defaultType);
            q0 dispatchReceiverParameter = dVar.getDispatchReceiverParameter();
            j0Var.initialize(dispatchReceiverParameter != null ? d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(j0Var, c1VarCreate.safeSubstitute(dispatchReceiverParameter.getType(), j1.INVARIANT), d0.e0.p.d.m0.c.g1.g.f.getEMPTY()) : null, null, y0Var.getDeclaredTypeParameters(), substitutedValueParameters, j0VarWithAbbreviation, d0.e0.p.d.m0.c.z.FINAL, y0Var.getVisibility());
            return j0Var;
        }
    }

    /* compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class b extends d0.z.d.o implements Function0<j0> {
        public final /* synthetic */ d0.e0.p.d.m0.c.d $underlyingConstructorDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d0.e0.p.d.m0.c.d dVar) {
            super(0);
            this.$underlyingConstructorDescriptor = dVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ j0 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final j0 invoke() {
            d0.e0.p.d.m0.m.o storageManager = j0.this.getStorageManager();
            y0 typeAliasDescriptor = j0.this.getTypeAliasDescriptor();
            d0.e0.p.d.m0.c.d dVar = this.$underlyingConstructorDescriptor;
            j0 j0Var = j0.this;
            d0.e0.p.d.m0.c.g1.g annotations = dVar.getAnnotations();
            b.a kind = this.$underlyingConstructorDescriptor.getKind();
            d0.z.d.m.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
            u0 source = j0.this.getTypeAliasDescriptor().getSource();
            d0.z.d.m.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            j0 j0Var2 = new j0(storageManager, typeAliasDescriptor, dVar, j0Var, annotations, kind, source, null);
            j0 j0Var3 = j0.this;
            d0.e0.p.d.m0.c.d dVar2 = this.$underlyingConstructorDescriptor;
            c1 c1VarAccess$getTypeSubstitutorForUnderlyingClass = a.access$getTypeSubstitutorForUnderlyingClass(j0.M, j0Var3.getTypeAliasDescriptor());
            if (c1VarAccess$getTypeSubstitutorForUnderlyingClass == null) {
                return null;
            }
            q0 dispatchReceiverParameter = dVar2.getDispatchReceiverParameter();
            j0Var2.initialize(null, dispatchReceiverParameter == null ? null : dispatchReceiverParameter.substitute(c1VarAccess$getTypeSubstitutorForUnderlyingClass), j0Var3.getTypeAliasDescriptor().getDeclaredTypeParameters(), j0Var3.getValueParameters(), j0Var3.getReturnType(), d0.e0.p.d.m0.c.z.FINAL, j0Var3.getTypeAliasDescriptor().getVisibility());
            return j0Var2;
        }
    }

    public j0(d0.e0.p.d.m0.m.o oVar, y0 y0Var, d0.e0.p.d.m0.c.d dVar, i0 i0Var, d0.e0.p.d.m0.c.g1.g gVar, b.a aVar, u0 u0Var) {
        super(y0Var, i0Var, gVar, d0.e0.p.d.m0.g.e.special("<init>"), aVar, u0Var);
        this.O = oVar;
        this.P = y0Var;
        setActual(getTypeAliasDescriptor().isActual());
        oVar.createNullableLazyValue(new b(dVar));
        this.Q = dVar;
    }

    public /* synthetic */ j0(d0.e0.p.d.m0.m.o oVar, y0 y0Var, d0.e0.p.d.m0.c.d dVar, i0 i0Var, d0.e0.p.d.m0.c.g1.g gVar, b.a aVar, u0 u0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(oVar, y0Var, dVar, i0Var, gVar, aVar, u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public q b(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.x xVar, b.a aVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(mVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(aVar, "kind");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        return new j0(this.O, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, gVar, b.a.DECLARATION, u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b.a aVar, boolean z2) {
        return copy(mVar, zVar, uVar, aVar, z2);
    }

    @Override // d0.e0.p.d.m0.c.l
    public d0.e0.p.d.m0.c.e getConstructedClass() {
        d0.e0.p.d.m0.c.e constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        d0.z.d.m.checkNotNullExpressionValue(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.i getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.a
    public d0.e0.p.d.m0.n.c0 getReturnType() {
        d0.e0.p.d.m0.n.c0 returnType = super.getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        return returnType;
    }

    public final d0.e0.p.d.m0.m.o getStorageManager() {
        return this.O;
    }

    public y0 getTypeAliasDescriptor() {
        return this.P;
    }

    @Override // d0.e0.p.d.m0.c.i1.i0
    public d0.e0.p.d.m0.c.d getUnderlyingConstructorDescriptor() {
        return this.Q;
    }

    @Override // d0.e0.p.d.m0.c.l
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.l substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b.a aVar, boolean z2) {
        return copy(mVar, zVar, uVar, aVar, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public i0 copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b.a aVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(mVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(zVar, "modality");
        d0.z.d.m.checkNotNullParameter(uVar, "visibility");
        d0.z.d.m.checkNotNullParameter(aVar, "kind");
        d0.e0.p.d.m0.c.x xVarBuild = newCopyBuilder().setOwner(mVar).setModality(zVar).setVisibility(uVar).setKind(aVar).setCopyOverrides(z2).build();
        Objects.requireNonNull(xVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (i0) xVarBuild;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public y0 getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public i0 substitute(c1 c1Var) {
        d0.z.d.m.checkNotNullParameter(c1Var, "substitutor");
        d0.e0.p.d.m0.c.x xVarSubstitute = super.substitute(c1Var);
        Objects.requireNonNull(xVarSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        j0 j0Var = (j0) xVarSubstitute;
        c1 c1VarCreate = c1.create(j0Var.getReturnType());
        d0.z.d.m.checkNotNullExpressionValue(c1VarCreate, "create(substitutedTypeAliasConstructor.returnType)");
        d0.e0.p.d.m0.c.d dVarSubstitute = getUnderlyingConstructorDescriptor().getOriginal().substitute(c1VarCreate);
        if (dVarSubstitute == null) {
            return null;
        }
        j0Var.Q = dVarSubstitute;
        return j0Var;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public i0 getOriginal() {
        return (i0) super.getOriginal();
    }
}
