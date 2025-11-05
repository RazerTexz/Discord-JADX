package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.a1;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.f1;
import d0.e0.p.d.m0.c.r0;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.e.a.f0;
import d0.e0.p.d.m0.e.a.g0.g;
import d0.e0.p.d.m0.e.a.k0.x;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.y0;
import d0.t.n0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: LazyJavaClassDescriptor.kt */
/* loaded from: classes3.dex */
public final class f extends d0.e0.p.d.m0.c.i1.h implements d0.e0.p.d.m0.e.a.h0.d {
    public final h A;
    public final r0<h> B;
    public final d0.e0.p.d.m0.k.a0.g C;
    public final o D;
    public final d0.e0.p.d.m0.c.g1.g E;
    public final d0.e0.p.d.m0.m.j<List<z0>> F;
    public final d0.e0.p.d.m0.e.a.i0.g r;

    /* renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.e.a.k0.g f3328s;
    public final d0.e0.p.d.m0.c.e t;
    public final d0.e0.p.d.m0.e.a.i0.g u;
    public final d0.e0.p.d.m0.c.f v;
    public final z w;

    /* renamed from: x, reason: collision with root package name */
    public final f1 f3329x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f3330y;

    /* renamed from: z, reason: collision with root package name */
    public final b f3331z;

    /* compiled from: LazyJavaClassDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    public final class b extends d0.e0.p.d.m0.n.b {
        public final d0.e0.p.d.m0.m.j<List<z0>> c;
        public final /* synthetic */ f d;

        /* compiled from: LazyJavaClassDescriptor.kt */
        public static final class a extends d0.z.d.o implements Function0<List<? extends z0>> {
            public final /* synthetic */ f this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar) {
                super(0);
                this.this$0 = fVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends z0> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends z0> invoke2() {
                return a1.computeConstructorTypeParameters(this.this$0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar) {
            super(f.access$getC$p(fVar).getStorageManager());
            d0.z.d.m.checkNotNullParameter(fVar, "this$0");
            this.d = fVar;
            this.c = f.access$getC$p(fVar).getStorageManager().createLazyValue(new a(fVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01b1  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01d0  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0214  */
        @Override // d0.e0.p.d.m0.n.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Collection<c0> a() {
            d0.e0.p.d.m0.g.b bVar;
            d0.e0.p.d.m0.g.b purelyImplementedInterface;
            ArrayList arrayList;
            j0 j0VarSimpleNotNullType;
            j1 j1Var = j1.INVARIANT;
            Collection<d0.e0.p.d.m0.e.a.k0.j> supertypes = this.d.getJClass().getSupertypes();
            ArrayList arrayList2 = new ArrayList(supertypes.size());
            ArrayList arrayList3 = new ArrayList(0);
            d0.e0.p.d.m0.c.g1.g annotations = this.d.getAnnotations();
            d0.e0.p.d.m0.g.b bVar2 = a0.n;
            d0.z.d.m.checkNotNullExpressionValue(bVar2, "PURELY_IMPLEMENTS_ANNOTATION");
            d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = annotations.findAnnotation(bVar2);
            if (cVarFindAnnotation == null) {
                bVar = null;
            } else {
                Object objSingleOrNull = u.singleOrNull(cVarFindAnnotation.getAllValueArguments().values());
                w wVar = objSingleOrNull instanceof w ? (w) objSingleOrNull : null;
                String value = wVar == null ? null : wVar.getValue();
                if (value != null && d0.e0.p.d.m0.g.d.isValidJavaFqName(value)) {
                    bVar = new d0.e0.p.d.m0.g.b(value);
                }
            }
            if (bVar != null) {
                if (!(!bVar.isRoot() && bVar.startsWith(d0.e0.p.d.m0.b.k.k))) {
                    bVar = null;
                }
            }
            if (bVar == null) {
                purelyImplementedInterface = d0.e0.p.d.m0.e.a.q.a.getPurelyImplementedInterface(d0.e0.p.d.m0.k.x.a.getFqNameSafe(this.d));
                if (purelyImplementedInterface == null) {
                    j0VarSimpleNotNullType = null;
                }
                for (d0.e0.p.d.m0.e.a.k0.j jVar : supertypes) {
                    c0 c0VarTransformJavaType = f.access$getC$p(this.d).getTypeResolver().transformJavaType(jVar, d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.SUPERTYPE, false, null, 3, null));
                    if (f.access$getC$p(this.d).getComponents().getSettings().getTypeEnhancementImprovements()) {
                        c0VarTransformJavaType = f.access$getC$p(this.d).getComponents().getSignatureEnhancement().enhanceSuperType(c0VarTransformJavaType, f.access$getC$p(this.d));
                    }
                    if (c0VarTransformJavaType.getConstructor().getDeclarationDescriptor() instanceof d0.b) {
                        arrayList3.add(jVar);
                    }
                    if (!d0.z.d.m.areEqual(c0VarTransformJavaType.getConstructor(), j0VarSimpleNotNullType == null ? null : j0VarSimpleNotNullType.getConstructor()) && !d0.e0.p.d.m0.b.h.isAnyOrNullableAny(c0VarTransformJavaType)) {
                        arrayList2.add(c0VarTransformJavaType);
                    }
                }
                d0.e0.p.d.m0.c.e eVarAccess$getAdditionalSupertypeClassDescriptor$p = f.access$getAdditionalSupertypeClassDescriptor$p(this.d);
                d0.e0.p.d.m0.p.a.addIfNotNull(arrayList2, eVarAccess$getAdditionalSupertypeClassDescriptor$p != null ? d0.e0.p.d.m0.b.q.q.createMappedTypeParametersSubstitution(eVarAccess$getAdditionalSupertypeClassDescriptor$p, this.d).buildSubstitutor().substitute(eVarAccess$getAdditionalSupertypeClassDescriptor$p.getDefaultType(), j1Var) : null);
                d0.e0.p.d.m0.p.a.addIfNotNull(arrayList2, j0VarSimpleNotNullType);
                if (!arrayList3.isEmpty()) {
                    d0.e0.p.d.m0.l.b.p errorReporter = f.access$getC$p(this.d).getComponents().getErrorReporter();
                    d0.e0.p.d.m0.c.e declarationDescriptor = getDeclarationDescriptor();
                    ArrayList arrayList4 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList3, 10));
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(((d0.e0.p.d.m0.e.a.k0.j) ((x) it.next())).getPresentableText());
                    }
                    errorReporter.reportIncompleteHierarchy(declarationDescriptor, arrayList4);
                }
                return !(arrayList2.isEmpty() ^ true) ? u.toList(arrayList2) : d0.t.m.listOf(f.access$getC$p(this.d).getModule().getBuiltIns().getAnyType());
            }
            purelyImplementedInterface = bVar;
            d0.e0.p.d.m0.c.e eVarResolveTopLevelClass = d0.e0.p.d.m0.k.x.a.resolveTopLevelClass(f.access$getC$p(this.d).getModule(), purelyImplementedInterface, d0.e0.p.d.m0.d.b.d.FROM_JAVA_LOADER);
            if (eVarResolveTopLevelClass != null) {
                int size = eVarResolveTopLevelClass.getTypeConstructor().getParameters().size();
                List<z0> parameters = this.d.getTypeConstructor().getParameters();
                d0.z.d.m.checkNotNullExpressionValue(parameters, "getTypeConstructor().parameters");
                int size2 = parameters.size();
                if (size2 == size) {
                    arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it2 = parameters.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new y0(j1Var, ((z0) it2.next()).getDefaultType()));
                    }
                } else {
                    if (size2 == 1 && size > 1 && bVar == null) {
                        y0 y0Var = new y0(j1Var, ((z0) u.single((List) parameters)).getDefaultType());
                        IntRange intRange = new IntRange(1, size);
                        ArrayList arrayList5 = new ArrayList(d0.t.o.collectionSizeOrDefault(intRange, 10));
                        Iterator<Integer> it3 = intRange.iterator();
                        while (it3.hasNext()) {
                            ((d0.t.c0) it3).nextInt();
                            arrayList5.add(y0Var);
                        }
                        arrayList = arrayList5;
                    }
                    j0VarSimpleNotNullType = null;
                }
                d0.e0.p.d.m0.n.d0 d0Var = d0.e0.p.d.m0.n.d0.a;
                j0VarSimpleNotNullType = d0.e0.p.d.m0.n.d0.simpleNotNullType(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), eVarResolveTopLevelClass, arrayList);
            }
            while (r1.hasNext()) {
            }
            d0.e0.p.d.m0.c.e eVarAccess$getAdditionalSupertypeClassDescriptor$p2 = f.access$getAdditionalSupertypeClassDescriptor$p(this.d);
            d0.e0.p.d.m0.p.a.addIfNotNull(arrayList2, eVarAccess$getAdditionalSupertypeClassDescriptor$p2 != null ? d0.e0.p.d.m0.b.q.q.createMappedTypeParametersSubstitution(eVarAccess$getAdditionalSupertypeClassDescriptor$p2, this.d).buildSubstitutor().substitute(eVarAccess$getAdditionalSupertypeClassDescriptor$p2.getDefaultType(), j1Var) : null);
            d0.e0.p.d.m0.p.a.addIfNotNull(arrayList2, j0VarSimpleNotNullType);
            if (!arrayList3.isEmpty()) {
            }
            if (!(arrayList2.isEmpty() ^ true)) {
            }
        }

        @Override // d0.e0.p.d.m0.n.g
        public x0 d() {
            return f.access$getC$p(this.d).getComponents().getSupertypeLoopChecker();
        }

        @Override // d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // d0.e0.p.d.m0.n.u0
        public List<z0> getParameters() {
            return this.c.invoke();
        }

        @Override // d0.e0.p.d.m0.n.u0
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            String strAsString = this.d.getName().asString();
            d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
            return strAsString;
        }

        @Override // d0.e0.p.d.m0.n.b, d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
        public d0.e0.p.d.m0.c.e getDeclarationDescriptor() {
            return this.d;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    public static final class c extends d0.z.d.o implements Function0<List<? extends z0>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends z0> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends z0> invoke2() {
            List<y> typeParameters = f.this.getJClass().getTypeParameters();
            f fVar = f.this;
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(typeParameters, 10));
            for (y yVar : typeParameters) {
                z0 z0VarResolveTypeParameter = f.access$getC$p(fVar).getTypeParameterResolver().resolveTypeParameter(yVar);
                if (z0VarResolveTypeParameter == null) {
                    throw new AssertionError("Parameter " + yVar + " surely belongs to class " + fVar.getJClass() + ", so it must be resolved");
                }
                arrayList.add(z0VarResolveTypeParameter);
            }
            return arrayList;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    public static final class d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.n.l1.g, h> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ h invoke(d0.e0.p.d.m0.n.l1.g gVar) {
            return invoke2(gVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final h invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "it");
            d0.e0.p.d.m0.e.a.i0.g gVarAccess$getC$p = f.access$getC$p(f.this);
            f fVar = f.this;
            return new h(gVarAccess$getC$p, fVar, fVar.getJClass(), f.access$getAdditionalSupertypeClassDescriptor$p(f.this) != null, f.access$getUnsubstitutedMemberScope$p(f.this));
        }
    }

    static {
        new a(null);
        n0.setOf((Object[]) new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public /* synthetic */ f(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.e.a.k0.g gVar2, d0.e0.p.d.m0.c.e eVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, mVar, gVar2, (i & 8) != 0 ? null : eVar);
    }

    public static final /* synthetic */ d0.e0.p.d.m0.c.e access$getAdditionalSupertypeClassDescriptor$p(f fVar) {
        return fVar.t;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g access$getC$p(f fVar) {
        return fVar.u;
    }

    public static final /* synthetic */ h access$getUnsubstitutedMemberScope$p(f fVar) {
        return fVar.A;
    }

    public final f copy$descriptors_jvm(d0.e0.p.d.m0.e.a.g0.g gVar, d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "javaResolverCache");
        d0.e0.p.d.m0.e.a.i0.g gVar2 = this.u;
        d0.e0.p.d.m0.e.a.i0.g gVarReplaceComponents = d0.e0.p.d.m0.e.a.i0.a.replaceComponents(gVar2, gVar2.getComponents().replace(gVar));
        d0.e0.p.d.m0.c.m containingDeclaration = getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        return new f(gVarReplaceComponents, containingDeclaration, this.f3328s, eVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.E;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        return this.F.invoke();
    }

    public final d0.e0.p.d.m0.e.a.k0.g getJClass() {
        return this.f3328s;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.f getKind() {
        return this.v;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public z getModality() {
        return this.w;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.e> getSealedSubclasses() {
        if (this.w != z.SEALED) {
            return d0.t.n.emptyList();
        }
        d0.e0.p.d.m0.e.a.i0.m.a attributes$default = d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, null, 3, null);
        Collection<d0.e0.p.d.m0.e.a.k0.j> permittedTypes = this.f3328s.getPermittedTypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = permittedTypes.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.h declarationDescriptor = this.u.getTypeResolver().transformJavaType((d0.e0.p.d.m0.e.a.k0.j) it.next(), attributes$default).getConstructor().getDeclarationDescriptor();
            d0.e0.p.d.m0.c.e eVar = declarationDescriptor instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) declarationDescriptor : null;
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getStaticScope() {
        return this.D;
    }

    @Override // d0.e0.p.d.m0.c.h
    public u0 getTypeConstructor() {
        return this.f3331z;
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedInnerClassesScope() {
        return this.C;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return (h) this.B.getScope(gVar);
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        if (!d0.z.d.m.areEqual(this.f3329x, t.a) || this.f3328s.getOuterClass() != null) {
            return f0.toDescriptorVisibility(this.f3329x);
        }
        d0.e0.p.d.m0.c.u uVar = d0.e0.p.d.m0.e.a.w.a;
        d0.z.d.m.checkNotNullExpressionValue(uVar, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
        return uVar;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isCompanionObject() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isData() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isFun() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return this.f3330y;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        return d0.z.d.m.stringPlus("Lazy Java class ", d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.e.a.k0.g gVar2, d0.e0.p.d.m0.c.e eVar) {
        z zVarConvertFromFlags;
        super(gVar.getStorageManager(), mVar, gVar2.getName(), gVar.getComponents().getSourceElementFactory().source(gVar2), false);
        d0.z.d.m.checkNotNullParameter(gVar, "outerContext");
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar2, "jClass");
        this.r = gVar;
        this.f3328s = gVar2;
        this.t = eVar;
        d0.e0.p.d.m0.e.a.i0.g gVarChildForClassOrPackage$default = d0.e0.p.d.m0.e.a.i0.a.childForClassOrPackage$default(gVar, this, gVar2, 0, 4, null);
        this.u = gVarChildForClassOrPackage$default;
        ((g.a) gVarChildForClassOrPackage$default.getComponents().getJavaResolverCache()).recordClass(gVar2, this);
        gVar2.getLightClassOriginKind();
        this.v = gVar2.isAnnotationType() ? d0.e0.p.d.m0.c.f.ANNOTATION_CLASS : gVar2.isInterface() ? d0.e0.p.d.m0.c.f.INTERFACE : gVar2.isEnum() ? d0.e0.p.d.m0.c.f.ENUM_CLASS : d0.e0.p.d.m0.c.f.CLASS;
        if (gVar2.isAnnotationType() || gVar2.isEnum()) {
            zVarConvertFromFlags = z.FINAL;
        } else {
            zVarConvertFromFlags = z.j.convertFromFlags(false, gVar2.isSealed() || gVar2.isAbstract() || gVar2.isInterface(), !gVar2.isFinal());
        }
        this.w = zVarConvertFromFlags;
        this.f3329x = gVar2.getVisibility();
        this.f3330y = (gVar2.getOuterClass() == null || gVar2.isStatic()) ? false : true;
        this.f3331z = new b(this);
        h hVar = new h(gVarChildForClassOrPackage$default, this, gVar2, eVar != null, null, 16, null);
        this.A = hVar;
        this.B = r0.a.create(this, gVarChildForClassOrPackage$default.getStorageManager(), gVarChildForClassOrPackage$default.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new d());
        this.C = new d0.e0.p.d.m0.k.a0.g(hVar);
        this.D = new o(gVarChildForClassOrPackage$default, gVar2, this);
        this.E = d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(gVarChildForClassOrPackage$default, gVar2);
        this.F = gVarChildForClassOrPackage$default.getStorageManager().createLazyValue(new c());
    }

    @Override // d0.e0.p.d.m0.c.e
    public List<d0.e0.p.d.m0.c.d> getConstructors() {
        return this.A.getConstructors$descriptors_jvm().invoke();
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope() {
        return getUnsubstitutedMemberScope();
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.e
    public h getUnsubstitutedMemberScope() {
        return (h) super.getUnsubstitutedMemberScope();
    }
}
