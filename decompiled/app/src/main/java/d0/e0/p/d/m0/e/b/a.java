package d0.e0.p.d.m0.e.b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.b.p;
import d0.e0.p.d.m0.e.b.s;
import d0.e0.p.d.m0.f.a0.a;
import d0.e0.p.d.m0.f.a0.b.e;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.k.v.b0;
import d0.e0.p.d.m0.l.b.y;
import d0.e0.p.d.m0.m.f;
import d0.e0.p.d.m0.n.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* loaded from: classes3.dex */
public abstract class a<A, C> implements d0.e0.p.d.m0.l.b.c<A, C> {
    public final n a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.h<p, b<A, C>> f3361b;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.a$a, reason: collision with other inner class name */
    public enum EnumC0531a {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC0531a[] valuesCustom() {
            EnumC0531a[] enumC0531aArrValuesCustom = values();
            EnumC0531a[] enumC0531aArr = new EnumC0531a[enumC0531aArrValuesCustom.length];
            System.arraycopy(enumC0531aArrValuesCustom, 0, enumC0531aArr, 0, enumC0531aArrValuesCustom.length);
            return enumC0531aArr;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class b<A, C> {
        public final Map<s, List<A>> a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<s, C> f3362b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Map<s, ? extends List<? extends A>> map, Map<s, ? extends C> map2) {
            d0.z.d.m.checkNotNullParameter(map, "memberAnnotations");
            d0.z.d.m.checkNotNullParameter(map2, "propertyConstants");
            this.a = map;
            this.f3362b = map2;
        }

        public final Map<s, List<A>> getMemberAnnotations() {
            return this.a;
        }

        public final Map<s, C> getPropertyConstants() {
            return this.f3362b;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class c implements p.c {
        public final /* synthetic */ a<A, C> a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<A> f3363b;

        public c(a<A, C> aVar, ArrayList<A> arrayList) {
            this.a = aVar;
            this.f3363b = arrayList;
        }

        @Override // d0.e0.p.d.m0.e.b.p.c
        public p.a visitAnnotation(d0.e0.p.d.m0.g.a aVar, u0 u0Var) {
            d0.z.d.m.checkNotNullParameter(aVar, "classId");
            d0.z.d.m.checkNotNullParameter(u0Var, "source");
            return a.access$loadAnnotationIfNotSpecial(this.a, aVar, u0Var, this.f3363b);
        }

        @Override // d0.e0.p.d.m0.e.b.p.c
        public void visitEnd() {
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class d extends d0.z.d.o implements Function1<p, b<? extends A, ? extends C>> {
        public final /* synthetic */ a<A, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a<A, C> aVar) {
            super(1);
            this.this$0 = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(p pVar) {
            return invoke2(pVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final b<A, C> invoke2(p pVar) {
            d0.z.d.m.checkNotNullParameter(pVar, "kotlinClass");
            return a.access$loadAnnotationsAndInitializers(this.this$0, pVar);
        }
    }

    public a(d0.e0.p.d.m0.m.o oVar, n nVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(nVar, "kotlinClassFinder");
        this.a = nVar;
        this.f3361b = oVar.createMemoizedFunction(new d(this));
    }

    public static final p.a access$loadAnnotationIfNotSpecial(a aVar, d0.e0.p.d.m0.g.a aVar2, u0 u0Var, List list) {
        Objects.requireNonNull(aVar);
        if (d0.e0.p.d.m0.a.a.getSPECIAL_ANNOTATIONS().contains(aVar2)) {
            return null;
        }
        return aVar.h(aVar2, u0Var, list);
    }

    public static final b access$loadAnnotationsAndInitializers(a aVar, p pVar) {
        Objects.requireNonNull(aVar);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        d0.e0.p.d.m0.e.b.b bVar = new d0.e0.p.d.m0.e.b.b(aVar, map, map2);
        d0.z.d.m.checkNotNullParameter(pVar, "kotlinClass");
        pVar.visitMembers(bVar, null);
        return new b(map, map2);
    }

    public static /* synthetic */ List b(a aVar, d0.e0.p.d.m0.l.b.y yVar, s sVar, boolean z2, boolean z3, Boolean bool, boolean z4, int i, Object obj) {
        return aVar.a(yVar, sVar, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z4);
    }

    public static /* synthetic */ s d(a aVar, d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.l.b.b bVar, boolean z2, int i, Object obj) {
        return aVar.c(nVar, cVar, gVar, bVar, (i & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ s f(a aVar, d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return aVar.e(nVar, cVar, gVar, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? true : z4);
    }

    public final List<A> a(d0.e0.p.d.m0.l.b.y yVar, s sVar, boolean z2, boolean z3, Boolean bool, boolean z4) {
        p pVarG = g(yVar, z2, z3, bool, z4);
        if (pVarG == null) {
            pVarG = yVar instanceof y.a ? j((y.a) yVar) : null;
        }
        if (pVarG == null) {
            return d0.t.n.emptyList();
        }
        List<A> list = ((b) ((f.m) this.f3361b).invoke(pVarG)).getMemberAnnotations().get(sVar);
        return list == null ? d0.t.n.emptyList() : list;
    }

    public final s c(d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.l.b.b bVar, boolean z2) {
        if (nVar instanceof d0.e0.p.d.m0.f.d) {
            s.a aVar = s.a;
            e.b jvmConstructorSignature = d0.e0.p.d.m0.f.a0.b.h.a.getJvmConstructorSignature((d0.e0.p.d.m0.f.d) nVar, cVar, gVar);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return aVar.fromJvmMemberSignature(jvmConstructorSignature);
        }
        if (nVar instanceof d0.e0.p.d.m0.f.i) {
            s.a aVar2 = s.a;
            e.b jvmMethodSignature = d0.e0.p.d.m0.f.a0.b.h.a.getJvmMethodSignature((d0.e0.p.d.m0.f.i) nVar, cVar, gVar);
            if (jvmMethodSignature == null) {
                return null;
            }
            return aVar2.fromJvmMemberSignature(jvmMethodSignature);
        }
        if (!(nVar instanceof d0.e0.p.d.m0.f.n)) {
            return null;
        }
        g.f<d0.e0.p.d.m0.f.n, a.d> fVar = d0.e0.p.d.m0.f.a0.a.d;
        d0.z.d.m.checkNotNullExpressionValue(fVar, "propertySignature");
        a.d dVar = (a.d) d0.e0.p.d.m0.f.z.e.getExtensionOrNull((g.d) nVar, fVar);
        if (dVar == null) {
            return null;
        }
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 1) {
            return e((d0.e0.p.d.m0.f.n) nVar, cVar, gVar, true, true, z2);
        }
        if (iOrdinal == 2) {
            if (!dVar.hasGetter()) {
                return null;
            }
            s.a aVar3 = s.a;
            a.c getter = dVar.getGetter();
            d0.z.d.m.checkNotNullExpressionValue(getter, "signature.getter");
            return aVar3.fromMethod(cVar, getter);
        }
        if (iOrdinal != 3 || !dVar.hasSetter()) {
            return null;
        }
        s.a aVar4 = s.a;
        a.c setter = dVar.getSetter();
        d0.z.d.m.checkNotNullExpressionValue(setter, "signature.setter");
        return aVar4.fromMethod(cVar, setter);
    }

    public final s e(d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, boolean z2, boolean z3, boolean z4) {
        g.f<d0.e0.p.d.m0.f.n, a.d> fVar = d0.e0.p.d.m0.f.a0.a.d;
        d0.z.d.m.checkNotNullExpressionValue(fVar, "propertySignature");
        a.d dVar = (a.d) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        if (z2) {
            e.a jvmFieldSignature = d0.e0.p.d.m0.f.a0.b.h.a.getJvmFieldSignature(nVar, cVar, gVar, z4);
            if (jvmFieldSignature == null) {
                return null;
            }
            return s.a.fromJvmMemberSignature(jvmFieldSignature);
        }
        if (!z3 || !dVar.hasSyntheticMethod()) {
            return null;
        }
        s.a aVar = s.a;
        a.c syntheticMethod = dVar.getSyntheticMethod();
        d0.z.d.m.checkNotNullExpressionValue(syntheticMethod, "signature.syntheticMethod");
        return aVar.fromMethod(cVar, syntheticMethod);
    }

    public final p g(d0.e0.p.d.m0.l.b.y yVar, boolean z2, boolean z3, Boolean bool, boolean z4) {
        y.a outerClass;
        c.EnumC0550c enumC0550c = c.EnumC0550c.INTERFACE;
        if (z2) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + yVar + ')').toString());
            }
            if (yVar instanceof y.a) {
                y.a aVar = (y.a) yVar;
                if (aVar.getKind() == enumC0550c) {
                    n nVar = this.a;
                    d0.e0.p.d.m0.g.a aVarCreateNestedClassId = aVar.getClassId().createNestedClassId(d0.e0.p.d.m0.g.e.identifier("DefaultImpls"));
                    d0.z.d.m.checkNotNullExpressionValue(aVarCreateNestedClassId, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                    return o.findKotlinClass(nVar, aVarCreateNestedClassId);
                }
            }
            if (bool.booleanValue() && (yVar instanceof y.b)) {
                u0 source = yVar.getSource();
                j jVar = source instanceof j ? (j) source : null;
                d0.e0.p.d.m0.k.y.c facadeClassName = jVar == null ? null : jVar.getFacadeClassName();
                if (facadeClassName != null) {
                    n nVar2 = this.a;
                    String internalName = facadeClassName.getInternalName();
                    d0.z.d.m.checkNotNullExpressionValue(internalName, "facadeClassName.internalName");
                    d0.e0.p.d.m0.g.a aVar2 = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b(d0.g0.t.replace$default(internalName, MentionUtilsKt.SLASH_CHAR, '.', false, 4, (Object) null)));
                    d0.z.d.m.checkNotNullExpressionValue(aVar2, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                    return o.findKotlinClass(nVar2, aVar2);
                }
            }
        }
        if (z3 && (yVar instanceof y.a)) {
            y.a aVar3 = (y.a) yVar;
            if (aVar3.getKind() == c.EnumC0550c.COMPANION_OBJECT && (outerClass = aVar3.getOuterClass()) != null && (outerClass.getKind() == c.EnumC0550c.CLASS || outerClass.getKind() == c.EnumC0550c.ENUM_CLASS || (z4 && (outerClass.getKind() == enumC0550c || outerClass.getKind() == c.EnumC0550c.ANNOTATION_CLASS)))) {
                return j(outerClass);
            }
        }
        if (!(yVar instanceof y.b) || !(yVar.getSource() instanceof j)) {
            return null;
        }
        u0 source2 = yVar.getSource();
        Objects.requireNonNull(source2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        j jVar2 = (j) source2;
        p knownJvmBinaryClass = jVar2.getKnownJvmBinaryClass();
        return knownJvmBinaryClass == null ? o.findKotlinClass(this.a, jVar2.getClassId()) : knownJvmBinaryClass;
    }

    public abstract p.a h(d0.e0.p.d.m0.g.a aVar, u0 u0Var, List<A> list);

    public final List<A> i(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.n nVar, EnumC0531a enumC0531a) {
        Boolean bool = d0.e0.p.d.m0.f.z.b.f3416z.get(nVar.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_CONST.get(proto.flags)");
        boolean zBooleanValue = bool.booleanValue();
        d0.e0.p.d.m0.f.a0.b.h hVar = d0.e0.p.d.m0.f.a0.b.h.a;
        boolean zIsMovedFromInterfaceCompanion = d0.e0.p.d.m0.f.a0.b.h.isMovedFromInterfaceCompanion(nVar);
        if (enumC0531a == EnumC0531a.PROPERTY) {
            s sVarF = f(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), false, true, false, 40, null);
            return sVarF == null ? d0.t.n.emptyList() : b(this, yVar, sVarF, true, false, Boolean.valueOf(zBooleanValue), zIsMovedFromInterfaceCompanion, 8, null);
        }
        s sVarF2 = f(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), true, false, false, 48, null);
        if (sVarF2 == null) {
            return d0.t.n.emptyList();
        }
        return d0.g0.w.contains$default((CharSequence) sVarF2.getSignature(), (CharSequence) "$delegate", false, 2, (Object) null) != (enumC0531a == EnumC0531a.DELEGATE_FIELD) ? d0.t.n.emptyList() : a(yVar, sVarF2, true, true, Boolean.valueOf(zBooleanValue), zIsMovedFromInterfaceCompanion);
    }

    public final p j(y.a aVar) {
        u0 source = aVar.getSource();
        r rVar = source instanceof r ? (r) source : null;
        if (rVar == null) {
            return null;
        }
        return rVar.getBinaryClass();
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadCallableAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.l.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        if (bVar == d0.e0.p.d.m0.l.b.b.PROPERTY) {
            return i(yVar, (d0.e0.p.d.m0.f.n) nVar, EnumC0531a.PROPERTY);
        }
        s sVarD = d(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), bVar, false, 16, null);
        return sVarD == null ? d0.t.n.emptyList() : b(this, yVar, sVarD, false, false, null, false, 60, null);
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadClassAnnotations(y.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "container");
        p pVarJ = j(aVar);
        if (pVarJ == null) {
            throw new IllegalStateException(d0.z.d.m.stringPlus("Class for loading annotations is not found: ", aVar.debugFqName()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        c cVar = new c(this, arrayList);
        d0.z.d.m.checkNotNullParameter(pVarJ, "kotlinClass");
        pVarJ.loadClassAnnotations(cVar, null);
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadEnumEntryAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.g gVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(gVar, "proto");
        s.a aVar = s.a;
        String string = yVar.getNameResolver().getString(gVar.getName());
        d0.e0.p.d.m0.f.a0.b.b bVar = d0.e0.p.d.m0.f.a0.b.b.a;
        String strAsString = ((y.a) yVar).getClassId().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "container as ProtoContainer.Class).classId.asString()");
        return b(this, yVar, aVar.fromFieldNameAndDesc(string, d0.e0.p.d.m0.f.a0.b.b.mapClass(strAsString)), false, false, null, false, 60, null);
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadExtensionReceiverParameterAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.l.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        s sVarD = d(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), bVar, false, 16, null);
        return sVarD != null ? b(this, yVar, s.a.fromMethodSignatureAndParameterIndex(sVarD, 0), false, false, null, false, 60, null) : d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadPropertyBackingFieldAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.n nVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        return i(yVar, nVar, EnumC0531a.BACKING_FIELD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.l.b.c
    public C loadPropertyConstant(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.n nVar, c0 c0Var) {
        C c2;
        b0 zVar;
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(c0Var, "expectedType");
        Boolean bool = d0.e0.p.d.m0.f.z.b.f3416z.get(nVar.getFlags());
        d0.e0.p.d.m0.f.a0.b.h hVar = d0.e0.p.d.m0.f.a0.b.h.a;
        p pVarG = g(yVar, true, true, bool, d0.e0.p.d.m0.f.a0.b.h.isMovedFromInterfaceCompanion(nVar));
        if (pVarG == null) {
            pVarG = yVar instanceof y.a ? j((y.a) yVar) : null;
        }
        if (pVarG == null) {
            return null;
        }
        s sVarC = c(nVar, yVar.getNameResolver(), yVar.getTypeTable(), d0.e0.p.d.m0.l.b.b.PROPERTY, pVarG.getClassHeader().getMetadataVersion().isAtLeast(f.a.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
        if (sVarC == null || (c2 = ((b) ((f.m) this.f3361b).invoke(pVarG)).getPropertyConstants().get(sVarC)) == 0) {
            return null;
        }
        d0.e0.p.d.m0.b.o oVar = d0.e0.p.d.m0.b.o.a;
        if (!d0.e0.p.d.m0.b.o.isUnsignedType(c0Var)) {
            return c2;
        }
        C c3 = (C) ((d0.e0.p.d.m0.k.v.g) c2);
        d0.z.d.m.checkNotNullParameter(c3, "constant");
        if (c3 instanceof d0.e0.p.d.m0.k.v.d) {
            zVar = new d0.e0.p.d.m0.k.v.x(((d0.e0.p.d.m0.k.v.d) c3).getValue().byteValue());
        } else if (c3 instanceof d0.e0.p.d.m0.k.v.v) {
            zVar = new d0.e0.p.d.m0.k.v.a0(((d0.e0.p.d.m0.k.v.v) c3).getValue().shortValue());
        } else if (c3 instanceof d0.e0.p.d.m0.k.v.m) {
            zVar = new d0.e0.p.d.m0.k.v.y(((d0.e0.p.d.m0.k.v.m) c3).getValue().intValue());
        } else {
            if (!(c3 instanceof d0.e0.p.d.m0.k.v.s)) {
                return c3;
            }
            zVar = new d0.e0.p.d.m0.k.v.z(((d0.e0.p.d.m0.k.v.s) c3).getValue().longValue());
        }
        return zVar;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadPropertyDelegateFieldAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.n nVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        return i(yVar, nVar, EnumC0531a.DELEGATE_FIELD);
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadTypeAnnotations(d0.e0.p.d.m0.f.q qVar, d0.e0.p.d.m0.f.z.c cVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        Object extension = qVar.getExtension(d0.e0.p.d.m0.f.a0.a.f);
        d0.z.d.m.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<d0.e0.p.d.m0.f.b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(iterable, 10));
        for (d0.e0.p.d.m0.f.b bVar : iterable) {
            d0.z.d.m.checkNotNullExpressionValue(bVar, "it");
            d0.z.d.m.checkNotNullParameter(bVar, "proto");
            d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
            arrayList.add(((d0.e0.p.d.m0.e.b.c) this).e.deserializeAnnotation(bVar, cVar));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadTypeParameterAnnotations(d0.e0.p.d.m0.f.s sVar, d0.e0.p.d.m0.f.z.c cVar) {
        d0.z.d.m.checkNotNullParameter(sVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        Object extension = sVar.getExtension(d0.e0.p.d.m0.f.a0.a.h);
        d0.z.d.m.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<d0.e0.p.d.m0.f.b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(iterable, 10));
        for (d0.e0.p.d.m0.f.b bVar : iterable) {
            d0.z.d.m.checkNotNullExpressionValue(bVar, "it");
            d0.z.d.m.checkNotNullParameter(bVar, "proto");
            d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
            arrayList.add(((d0.e0.p.d.m0.e.b.c) this).e.deserializeAnnotation(bVar, cVar));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    @Override // d0.e0.p.d.m0.l.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<A> loadValueParameterAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.l.b.b bVar, int i, d0.e0.p.d.m0.f.u uVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "callableProto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        d0.z.d.m.checkNotNullParameter(uVar, "proto");
        s sVarD = d(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), bVar, false, 16, null);
        if (sVarD == null) {
            return d0.t.n.emptyList();
        }
        int i2 = 1;
        if (nVar instanceof d0.e0.p.d.m0.f.i) {
            if (!d0.e0.p.d.m0.f.z.f.hasReceiver((d0.e0.p.d.m0.f.i) nVar)) {
                i2 = 0;
            }
        } else if (nVar instanceof d0.e0.p.d.m0.f.n) {
            if (!d0.e0.p.d.m0.f.z.f.hasReceiver((d0.e0.p.d.m0.f.n) nVar)) {
            }
        } else {
            if (!(nVar instanceof d0.e0.p.d.m0.f.d)) {
                throw new UnsupportedOperationException(d0.z.d.m.stringPlus("Unsupported message: ", nVar.getClass()));
            }
            y.a aVar = (y.a) yVar;
            if (aVar.getKind() == c.EnumC0550c.ENUM_CLASS) {
                i2 = 2;
            } else if (!aVar.isInner()) {
            }
        }
        return b(this, yVar, s.a.fromMethodSignatureAndParameterIndex(sVarD, i + i2), false, false, null, false, 60, null);
    }
}
