package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.m0;
import d0.e0.p.d.m0.n.n0;
import d0.e0.p.d.m0.n.o0;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import d0.t.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: TypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class c0 {
    public final l a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f3483b;
    public final String c;
    public final String d;
    public boolean e;
    public final Function1<Integer, d0.e0.p.d.m0.c.h> f;
    public final Function1<Integer, d0.e0.p.d.m0.c.h> g;
    public final Map<Integer, z0> h;

    /* compiled from: TypeDeserializer.kt */
    public static final class a extends d0.z.d.o implements Function1<Integer, d0.e0.p.d.m0.c.h> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final d0.e0.p.d.m0.c.h invoke(int i) {
            return c0.access$computeClassifierDescriptor(c0.this, i);
        }
    }

    /* compiled from: TypeDeserializer.kt */
    public static final class b extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.c.g1.c>> {
        public final /* synthetic */ d0.e0.p.d.m0.f.q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d0.e0.p.d.m0.f.q qVar) {
            super(0);
            this.$proto = qVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.g1.c> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends d0.e0.p.d.m0.c.g1.c> invoke2() {
            return c0.access$getC$p(c0.this).getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(this.$proto, c0.access$getC$p(c0.this).getNameResolver());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    public static final class c extends d0.z.d.o implements Function1<Integer, d0.e0.p.d.m0.c.h> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final d0.e0.p.d.m0.c.h invoke(int i) {
            return c0.access$computeTypeAliasDescriptor(c0.this, i);
        }
    }

    /* compiled from: TypeDeserializer.kt */
    public /* synthetic */ class d extends d0.z.d.j implements Function1<d0.e0.p.d.m0.g.a, d0.e0.p.d.m0.g.a> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return d0.z.d.a0.getOrCreateKotlinClass(d0.e0.p.d.m0.g.a.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.a invoke(d0.e0.p.d.m0.g.a aVar) {
            return invoke2(aVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.g.a invoke2(d0.e0.p.d.m0.g.a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "p0");
            return aVar.getOuterClassId();
        }
    }

    /* compiled from: TypeDeserializer.kt */
    public static final class e extends d0.z.d.o implements Function1<d0.e0.p.d.m0.f.q, d0.e0.p.d.m0.f.q> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.f.q invoke(d0.e0.p.d.m0.f.q qVar) {
            return invoke2(qVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.f.q invoke2(d0.e0.p.d.m0.f.q qVar) {
            d0.z.d.m.checkNotNullParameter(qVar, "it");
            return d0.e0.p.d.m0.f.z.f.outerType(qVar, c0.access$getC$p(c0.this).getTypeTable());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    public static final class f extends d0.z.d.o implements Function1<d0.e0.p.d.m0.f.q, Integer> {
        public static final f j = new f();

        public f() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(d0.e0.p.d.m0.f.q qVar) {
            d0.z.d.m.checkNotNullParameter(qVar, "it");
            return qVar.getArgumentCount();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(d0.e0.p.d.m0.f.q qVar) {
            return Integer.valueOf(invoke2(qVar));
        }
    }

    public c0(l lVar, c0 c0Var, List<d0.e0.p.d.m0.f.s> list, String str, String str2, boolean z2) {
        Map<Integer, z0> linkedHashMap;
        d0.z.d.m.checkNotNullParameter(lVar, "c");
        d0.z.d.m.checkNotNullParameter(list, "typeParameterProtos");
        d0.z.d.m.checkNotNullParameter(str, "debugName");
        d0.z.d.m.checkNotNullParameter(str2, "containerPresentableName");
        this.a = lVar;
        this.f3483b = c0Var;
        this.c = str;
        this.d = str2;
        this.e = z2;
        this.f = lVar.getStorageManager().createMemoizedFunctionWithNullableValues(new a());
        this.g = lVar.getStorageManager().createMemoizedFunctionWithNullableValues(new c());
        if (list.isEmpty()) {
            linkedHashMap = h0.emptyMap();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            for (d0.e0.p.d.m0.f.s sVar : list) {
                linkedHashMap.put(Integer.valueOf(sVar.getId()), new d0.e0.p.d.m0.l.b.e0.m(this.a, sVar, i));
                i++;
            }
        }
        this.h = linkedHashMap;
    }

    public static final d0.e0.p.d.m0.c.h access$computeClassifierDescriptor(c0 c0Var, int i) {
        d0.e0.p.d.m0.g.a classId = w.getClassId(c0Var.a.getNameResolver(), i);
        return classId.isLocal() ? c0Var.a.getComponents().deserializeClass(classId) : d0.e0.p.d.m0.c.w.findClassifierAcrossModuleDependencies(c0Var.a.getComponents().getModuleDescriptor(), classId);
    }

    public static final d0.e0.p.d.m0.c.h access$computeTypeAliasDescriptor(c0 c0Var, int i) {
        d0.e0.p.d.m0.g.a classId = w.getClassId(c0Var.a.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return d0.e0.p.d.m0.c.w.findTypeAliasAcrossModuleDependencies(c0Var.a.getComponents().getModuleDescriptor(), classId);
    }

    public static final /* synthetic */ l access$getC$p(c0 c0Var) {
        return c0Var.a;
    }

    public static final List<q.b> c(d0.e0.p.d.m0.f.q qVar, c0 c0Var) {
        List<q.b> argumentList = qVar.getArgumentList();
        d0.z.d.m.checkNotNullExpressionValue(argumentList, "argumentList");
        d0.e0.p.d.m0.f.q qVarOuterType = d0.e0.p.d.m0.f.z.f.outerType(qVar, c0Var.a.getTypeTable());
        List<q.b> listC = qVarOuterType == null ? null : c(qVarOuterType, c0Var);
        if (listC == null) {
            listC = d0.t.n.emptyList();
        }
        return d0.t.u.plus((Collection) argumentList, (Iterable) listC);
    }

    public static final d0.e0.p.d.m0.c.e d(c0 c0Var, d0.e0.p.d.m0.f.q qVar, int i) {
        d0.e0.p.d.m0.g.a classId = w.getClassId(c0Var.a.getNameResolver(), i);
        List<Integer> mutableList = d0.f0.q.toMutableList(d0.f0.q.map(d0.f0.n.generateSequence(qVar, c0Var.new e()), f.j));
        int iCount = d0.f0.q.count(d0.f0.n.generateSequence(classId, d.j));
        while (mutableList.size() < iCount) {
            mutableList.add(0);
        }
        return c0Var.a.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    public static /* synthetic */ j0 simpleType$default(c0 c0Var, d0.e0.p.d.m0.f.q qVar, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return c0Var.simpleType(qVar, z2);
    }

    public final j0 a(int i) {
        if (w.getClassId(this.a.getNameResolver(), i).isLocal()) {
            return this.a.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    public final j0 b(d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.n.c0 c0Var2) {
        d0.e0.p.d.m0.b.h builtIns = d0.e0.p.d.m0.n.o1.a.getBuiltIns(c0Var);
        d0.e0.p.d.m0.c.g1.g annotations = c0Var.getAnnotations();
        d0.e0.p.d.m0.n.c0 receiverTypeFromFunctionType = d0.e0.p.d.m0.b.g.getReceiverTypeFromFunctionType(c0Var);
        List listDropLast = d0.t.u.dropLast(d0.e0.p.d.m0.b.g.getValueParameterTypesFromFunctionType(c0Var), 1);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listDropLast, 10));
        Iterator it = listDropLast.iterator();
        while (it.hasNext()) {
            arrayList.add(((w0) it.next()).getType());
        }
        return d0.e0.p.d.m0.b.g.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, arrayList, null, c0Var2, true).makeNullableAsSpecified(c0Var.isMarkedNullable());
    }

    public final u0 e(int i) {
        z0 z0Var = this.h.get(Integer.valueOf(i));
        u0 typeConstructor = z0Var == null ? null : z0Var.getTypeConstructor();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        c0 c0Var = this.f3483b;
        if (c0Var == null) {
            return null;
        }
        return c0Var.e(i);
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.e;
    }

    public final List<z0> getOwnTypeParameters() {
        return d0.t.u.toList(this.h.values());
    }

    public final j0 simpleType(d0.e0.p.d.m0.f.q qVar, boolean z2) {
        u0 u0VarCreateErrorTypeConstructor;
        Object next;
        j0 j0VarSimpleType$default;
        int size;
        j0 j0VarWithAbbreviation;
        Object y0Var;
        d0.z.d.m.checkNotNullParameter(qVar, "proto");
        j0 j0VarSimpleType$default2 = null;
        j0VarSimpleType$default2 = null;
        j0VarSimpleType$default2 = null;
        j0VarSimpleType$default2 = null;
        j0 j0VarA = qVar.hasClassName() ? a(qVar.getClassName()) : qVar.hasTypeAliasName() ? a(qVar.getTypeAliasName()) : null;
        if (j0VarA != null) {
            return j0VarA;
        }
        if (qVar.hasClassName()) {
            d0.e0.p.d.m0.c.h hVarInvoke = this.f.invoke(Integer.valueOf(qVar.getClassName()));
            if (hVarInvoke == null) {
                hVarInvoke = d(this, qVar, qVar.getClassName());
            }
            u0VarCreateErrorTypeConstructor = hVarInvoke.getTypeConstructor();
            d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor");
        } else if (qVar.hasTypeParameter()) {
            u0VarCreateErrorTypeConstructor = e(qVar.getTypeParameter());
            if (u0VarCreateErrorTypeConstructor == null) {
                StringBuilder sbU = b.d.b.a.a.U("Unknown type parameter ");
                sbU.append(qVar.getTypeParameter());
                sbU.append(". Please try recompiling module containing \"");
                sbU.append(this.d);
                sbU.append('\"');
                u0VarCreateErrorTypeConstructor = d0.e0.p.d.m0.n.t.createErrorTypeConstructor(sbU.toString());
                d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )");
            }
        } else if (qVar.hasTypeParameterName()) {
            d0.e0.p.d.m0.c.m containingDeclaration = this.a.getContainingDeclaration();
            String string = this.a.getNameResolver().getString(qVar.getTypeParameterName());
            Iterator<T> it = getOwnTypeParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (d0.z.d.m.areEqual(((z0) next).getName().asString(), string)) {
                    break;
                }
            }
            z0 z0Var = (z0) next;
            u0 typeConstructor = z0Var == null ? null : z0Var.getTypeConstructor();
            u0VarCreateErrorTypeConstructor = typeConstructor == null ? d0.e0.p.d.m0.n.t.createErrorTypeConstructor("Deserialized type parameter " + string + " in " + containingDeclaration) : typeConstructor;
            d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }");
        } else if (qVar.hasTypeAliasName()) {
            d0.e0.p.d.m0.c.h hVarInvoke2 = this.g.invoke(Integer.valueOf(qVar.getTypeAliasName()));
            if (hVarInvoke2 == null) {
                hVarInvoke2 = d(this, qVar, qVar.getTypeAliasName());
            }
            u0VarCreateErrorTypeConstructor = hVarInvoke2.getTypeConstructor();
            d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor");
        } else {
            u0VarCreateErrorTypeConstructor = d0.e0.p.d.m0.n.t.createErrorTypeConstructor("Unknown type");
            d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "createErrorTypeConstructor(\"Unknown type\")");
        }
        if (d0.e0.p.d.m0.n.t.isError(u0VarCreateErrorTypeConstructor.getDeclarationDescriptor())) {
            j0 j0VarCreateErrorTypeWithCustomConstructor = d0.e0.p.d.m0.n.t.createErrorTypeWithCustomConstructor(u0VarCreateErrorTypeConstructor.toString(), u0VarCreateErrorTypeConstructor);
            d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorTypeWithCustomConstructor, "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)");
            return j0VarCreateErrorTypeWithCustomConstructor;
        }
        d0.e0.p.d.m0.l.b.e0.a aVar = new d0.e0.p.d.m0.l.b.e0.a(this.a.getStorageManager(), new b(qVar));
        List<q.b> listC = c(qVar, this);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listC, 10));
        int i = 0;
        for (Object obj : listC) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            q.b bVar = (q.b) obj;
            List<z0> parameters = u0VarCreateErrorTypeConstructor.getParameters();
            d0.z.d.m.checkNotNullExpressionValue(parameters, "constructor.parameters");
            z0 z0Var2 = (z0) d0.t.u.getOrNull(parameters, i);
            if (bVar.getProjection() == q.b.c.STAR) {
                y0Var = z0Var2 == null ? new n0(this.a.getComponents().getModuleDescriptor().getBuiltIns()) : new o0(z0Var2);
            } else {
                z zVar = z.a;
                q.b.c projection = bVar.getProjection();
                d0.z.d.m.checkNotNullExpressionValue(projection, "typeArgumentProto.projection");
                j1 j1VarVariance = zVar.variance(projection);
                d0.e0.p.d.m0.f.q qVarType = d0.e0.p.d.m0.f.z.f.type(bVar, this.a.getTypeTable());
                y0Var = qVarType == null ? new y0(d0.e0.p.d.m0.n.t.createErrorType("No type recorded")) : new y0(j1VarVariance, type(qVarType));
            }
            arrayList.add(y0Var);
            i = i2;
        }
        List list = d0.t.u.toList(arrayList);
        d0.e0.p.d.m0.c.h declarationDescriptor = u0VarCreateErrorTypeConstructor.getDeclarationDescriptor();
        boolean z3 = true;
        if (z2 && (declarationDescriptor instanceof d0.e0.p.d.m0.c.y0)) {
            d0 d0Var = d0.a;
            j0 j0VarComputeExpandedType = d0.computeExpandedType((d0.e0.p.d.m0.c.y0) declarationDescriptor, list);
            if (!e0.isNullable(j0VarComputeExpandedType) && !qVar.getNullable()) {
                z3 = false;
            }
            j0VarSimpleType$default = j0VarComputeExpandedType.makeNullableAsSpecified(z3).replaceAnnotations(d0.e0.p.d.m0.c.g1.g.f.create(d0.t.u.plus((Iterable) aVar, (Iterable) j0VarComputeExpandedType.getAnnotations())));
        } else {
            Boolean bool = d0.e0.p.d.m0.f.z.b.a.get(qVar.getFlags());
            d0.z.d.m.checkNotNullExpressionValue(bool, "SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                boolean nullable = qVar.getNullable();
                int size2 = u0VarCreateErrorTypeConstructor.getParameters().size() - list.size();
                if (size2 == 0) {
                    d0 d0Var2 = d0.a;
                    j0 j0VarSimpleType$default3 = d0.simpleType$default(aVar, u0VarCreateErrorTypeConstructor, list, nullable, null, 16, null);
                    if (d0.e0.p.d.m0.b.g.isFunctionType(j0VarSimpleType$default3)) {
                        boolean releaseCoroutines = this.a.getComponents().getConfiguration().getReleaseCoroutines();
                        w0 w0Var = (w0) d0.t.u.lastOrNull((List) d0.e0.p.d.m0.b.g.getValueParameterTypesFromFunctionType(j0VarSimpleType$default3));
                        d0.e0.p.d.m0.n.c0 type = w0Var == null ? null : w0Var.getType();
                        if (type != null) {
                            d0.e0.p.d.m0.c.h declarationDescriptor2 = type.getConstructor().getDeclarationDescriptor();
                            d0.e0.p.d.m0.g.b fqNameSafe = declarationDescriptor2 == null ? null : d0.e0.p.d.m0.k.x.a.getFqNameSafe(declarationDescriptor2);
                            if (type.getArguments().size() == 1 && (d0.e0.p.d.m0.b.l.isContinuation(fqNameSafe, true) || d0.e0.p.d.m0.b.l.isContinuation(fqNameSafe, false))) {
                                d0.e0.p.d.m0.n.c0 type2 = ((w0) d0.t.u.single((List) type.getArguments())).getType();
                                d0.z.d.m.checkNotNullExpressionValue(type2, "continuationArgumentType.arguments.single().type");
                                d0.e0.p.d.m0.c.m containingDeclaration2 = this.a.getContainingDeclaration();
                                if (!(containingDeclaration2 instanceof d0.e0.p.d.m0.c.a)) {
                                    containingDeclaration2 = null;
                                }
                                d0.e0.p.d.m0.c.a aVar2 = (d0.e0.p.d.m0.c.a) containingDeclaration2;
                                if (d0.z.d.m.areEqual(aVar2 != null ? d0.e0.p.d.m0.k.x.a.fqNameOrNull(aVar2) : null, b0.a)) {
                                    j0VarSimpleType$default3 = b(j0VarSimpleType$default3, type2);
                                } else {
                                    if (!this.e && (!releaseCoroutines || !d0.e0.p.d.m0.b.l.isContinuation(fqNameSafe, !releaseCoroutines))) {
                                        z3 = false;
                                    }
                                    this.e = z3;
                                    j0VarSimpleType$default3 = b(j0VarSimpleType$default3, type2);
                                }
                            }
                            j0VarSimpleType$default2 = j0VarSimpleType$default3;
                        }
                    }
                } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
                    d0 d0Var3 = d0.a;
                    u0 typeConstructor2 = u0VarCreateErrorTypeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
                    d0.z.d.m.checkNotNullExpressionValue(typeConstructor2, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
                    j0VarSimpleType$default2 = d0.simpleType$default(aVar, typeConstructor2, list, nullable, null, 16, null);
                }
                if (j0VarSimpleType$default2 == null) {
                    j0VarSimpleType$default = d0.e0.p.d.m0.n.t.createErrorTypeWithArguments(d0.z.d.m.stringPlus("Bad suspend function in metadata with constructor: ", u0VarCreateErrorTypeConstructor), list);
                    d0.z.d.m.checkNotNullExpressionValue(j0VarSimpleType$default, "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
                } else {
                    j0VarSimpleType$default = j0VarSimpleType$default2;
                }
            } else {
                d0 d0Var4 = d0.a;
                j0VarSimpleType$default = d0.simpleType$default(aVar, u0VarCreateErrorTypeConstructor, list, qVar.getNullable(), null, 16, null);
            }
        }
        d0.e0.p.d.m0.f.q qVarAbbreviatedType = d0.e0.p.d.m0.f.z.f.abbreviatedType(qVar, this.a.getTypeTable());
        if (qVarAbbreviatedType != null && (j0VarWithAbbreviation = m0.withAbbreviation(j0VarSimpleType$default, simpleType(qVarAbbreviatedType, false))) != null) {
            j0VarSimpleType$default = j0VarWithAbbreviation;
        }
        return qVar.hasClassName() ? this.a.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(w.getClassId(this.a.getNameResolver(), qVar.getClassName()), j0VarSimpleType$default) : j0VarSimpleType$default;
    }

    public String toString() {
        String str = this.c;
        c0 c0Var = this.f3483b;
        return d0.z.d.m.stringPlus(str, c0Var == null ? "" : d0.z.d.m.stringPlus(". Child of ", c0Var.c));
    }

    public final d0.e0.p.d.m0.n.c0 type(d0.e0.p.d.m0.f.q qVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "proto");
        if (!qVar.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(qVar, true);
        }
        String string = this.a.getNameResolver().getString(qVar.getFlexibleTypeCapabilitiesId());
        j0 j0VarSimpleType$default = simpleType$default(this, qVar, false, 2, null);
        d0.e0.p.d.m0.f.q qVarFlexibleUpperBound = d0.e0.p.d.m0.f.z.f.flexibleUpperBound(qVar, this.a.getTypeTable());
        d0.z.d.m.checkNotNull(qVarFlexibleUpperBound);
        return this.a.getComponents().getFlexibleTypeDeserializer().create(qVar, string, j0VarSimpleType$default, simpleType$default(this, qVarFlexibleUpperBound, false, 2, null));
    }

    public /* synthetic */ c0(l lVar, c0 c0Var, List list, String str, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lVar, c0Var, list, str, str2, (i & 32) != 0 ? false : z2);
    }
}
