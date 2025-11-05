package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.w;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.t;
import d0.t.h0;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* loaded from: classes3.dex */
public final class e implements d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.e.a.h0.i {
    public static final /* synthetic */ KProperty<Object>[] a = {a0.property1(new y(a0.getOrCreateKotlinClass(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), a0.property1(new y(a0.getOrCreateKotlinClass(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), a0.property1(new y(a0.getOrCreateKotlinClass(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.e.a.i0.g f3327b;
    public final d0.e0.p.d.m0.e.a.k0.a c;
    public final d0.e0.p.d.m0.m.k d;
    public final d0.e0.p.d.m0.m.j e;
    public final d0.e0.p.d.m0.e.a.j0.a f;
    public final d0.e0.p.d.m0.m.j g;
    public final boolean h;
    public final boolean i;

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    public static final class a extends d0.z.d.o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke2() {
            Collection<d0.e0.p.d.m0.e.a.k0.b> arguments = e.access$getJavaAnnotation$p(e.this).getArguments();
            e eVar = e.this;
            ArrayList arrayList = new ArrayList();
            for (d0.e0.p.d.m0.e.a.k0.b bVar : arguments) {
                d0.e0.p.d.m0.g.e name = bVar.getName();
                if (name == null) {
                    name = d0.e0.p.d.m0.e.a.a0.f3305b;
                }
                d0.e0.p.d.m0.k.v.g gVarAccess$resolveAnnotationArgument = e.access$resolveAnnotationArgument(eVar, bVar);
                Pair pair = gVarAccess$resolveAnnotationArgument == null ? null : d0.o.to(name, gVarAccess$resolveAnnotationArgument);
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            return h0.toMap(arrayList);
        }
    }

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    public static final class b extends d0.z.d.o implements Function0<d0.e0.p.d.m0.g.b> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.b invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d0.e0.p.d.m0.g.b invoke() {
            d0.e0.p.d.m0.g.a classId = e.access$getJavaAnnotation$p(e.this).getClassId();
            if (classId == null) {
                return null;
            }
            return classId.asSingleFqName();
        }
    }

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    public static final class c extends d0.z.d.o implements Function0<j0> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ j0 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final j0 invoke() {
            d0.e0.p.d.m0.g.b fqName = e.this.getFqName();
            if (fqName == null) {
                return t.createErrorType(d0.z.d.m.stringPlus("No fqName: ", e.access$getJavaAnnotation$p(e.this)));
            }
            d0.e0.p.d.m0.c.e eVarMapJavaToKotlin$default = d0.e0.p.d.m0.b.q.d.mapJavaToKotlin$default(d0.e0.p.d.m0.b.q.d.a, fqName, e.access$getC$p(e.this).getModule().getBuiltIns(), null, 4, null);
            if (eVarMapJavaToKotlin$default == null) {
                d0.e0.p.d.m0.e.a.k0.g gVarResolve = e.access$getJavaAnnotation$p(e.this).resolve();
                eVarMapJavaToKotlin$default = gVarResolve == null ? null : e.access$getC$p(e.this).getComponents().getModuleClassResolver().resolveClass(gVarResolve);
                if (eVarMapJavaToKotlin$default == null) {
                    eVarMapJavaToKotlin$default = e.access$createTypeForMissingDependencies(e.this, fqName);
                }
            }
            return eVarMapJavaToKotlin$default.getDefaultType();
        }
    }

    public e(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.k0.a aVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(aVar, "javaAnnotation");
        this.f3327b = gVar;
        this.c = aVar;
        this.d = gVar.getStorageManager().createNullableLazyValue(new b());
        this.e = gVar.getStorageManager().createLazyValue(new c());
        this.f = gVar.getComponents().getSourceElementFactory().source(aVar);
        this.g = gVar.getStorageManager().createLazyValue(new a());
        this.h = aVar.isIdeExternalAnnotation();
        this.i = aVar.isFreshlySupportedTypeUseAnnotation() || z2;
    }

    public static final d0.e0.p.d.m0.c.e access$createTypeForMissingDependencies(e eVar, d0.e0.p.d.m0.g.b bVar) {
        c0 module = eVar.f3327b.getModule();
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(bVar);
        d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(fqName)");
        return w.findNonGenericClassAcrossDependencies(module, aVar, eVar.f3327b.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g access$getC$p(e eVar) {
        return eVar.f3327b;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.k0.a access$getJavaAnnotation$p(e eVar) {
        return eVar.c;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.k.v.g access$resolveAnnotationArgument(e eVar, d0.e0.p.d.m0.e.a.k0.b bVar) {
        return eVar.a(bVar);
    }

    public final d0.e0.p.d.m0.k.v.g<?> a(d0.e0.p.d.m0.e.a.k0.b bVar) {
        d0.e0.p.d.m0.k.v.g<?> aVar;
        if (bVar instanceof d0.e0.p.d.m0.e.a.k0.o) {
            return d0.e0.p.d.m0.k.v.h.a.createConstantValue(((d0.e0.p.d.m0.e.a.k0.o) bVar).getValue());
        }
        if (bVar instanceof d0.e0.p.d.m0.e.a.k0.m) {
            d0.e0.p.d.m0.e.a.k0.m mVar = (d0.e0.p.d.m0.e.a.k0.m) bVar;
            d0.e0.p.d.m0.g.a enumClassId = mVar.getEnumClassId();
            d0.e0.p.d.m0.g.e entryName = mVar.getEntryName();
            if (enumClassId == null || entryName == null) {
                return null;
            }
            return new d0.e0.p.d.m0.k.v.j(enumClassId, entryName);
        }
        if (bVar instanceof d0.e0.p.d.m0.e.a.k0.e) {
            d0.e0.p.d.m0.g.e name = bVar.getName();
            if (name == null) {
                name = d0.e0.p.d.m0.e.a.a0.f3305b;
            }
            d0.z.d.m.checkNotNullExpressionValue(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            List<d0.e0.p.d.m0.e.a.k0.b> elements = ((d0.e0.p.d.m0.e.a.k0.e) bVar).getElements();
            j0 type = getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "type");
            if (e0.isError(type)) {
                return null;
            }
            d0.e0.p.d.m0.c.e annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(this);
            d0.z.d.m.checkNotNull(annotationClass);
            c1 annotationParameterByName = d0.e0.p.d.m0.e.a.g0.a.getAnnotationParameterByName(name, annotationClass);
            d0.e0.p.d.m0.n.c0 type2 = annotationParameterByName != null ? annotationParameterByName.getType() : null;
            if (type2 == null) {
                type2 = this.f3327b.getComponents().getModule().getBuiltIns().getArrayType(j1.INVARIANT, t.createErrorType("Unknown array element type"));
            }
            d0.z.d.m.checkNotNullExpressionValue(type2, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(elements, 10));
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                d0.e0.p.d.m0.k.v.g<?> gVarA = a((d0.e0.p.d.m0.e.a.k0.b) it.next());
                if (gVarA == null) {
                    gVarA = new d0.e0.p.d.m0.k.v.t();
                }
                arrayList.add(gVarA);
            }
            aVar = d0.e0.p.d.m0.k.v.h.a.createArrayValue(arrayList, type2);
        } else {
            if (!(bVar instanceof d0.e0.p.d.m0.e.a.k0.c)) {
                if (bVar instanceof d0.e0.p.d.m0.e.a.k0.h) {
                    return d0.e0.p.d.m0.k.v.r.f3476b.create(this.f3327b.getTypeResolver().transformJavaType(((d0.e0.p.d.m0.e.a.k0.h) bVar).getReferencedType(), d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, null, 3, null)));
                }
                return null;
            }
            aVar = new d0.e0.p.d.m0.k.v.a(new e(this.f3327b, ((d0.e0.p.d.m0.e.a.k0.c) bVar).getAnnotation(), false, 4, null));
        }
        return aVar;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return (Map) d0.e0.p.d.m0.m.n.getValue(this.g, this, (KProperty<?>) a[2]);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public d0.e0.p.d.m0.g.b getFqName() {
        return (d0.e0.p.d.m0.g.b) d0.e0.p.d.m0.m.n.getValue(this.d, this, (KProperty<?>) a[0]);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public /* bridge */ /* synthetic */ u0 getSource() {
        return getSource();
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.c0 getType() {
        return getType();
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.i;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.i
    public boolean isIdeExternalAnnotation() {
        return this.h;
    }

    public String toString() {
        return d0.e0.p.d.m0.j.c.renderAnnotation$default(d0.e0.p.d.m0.j.c.f3439b, this, null, 2, null);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public d0.e0.p.d.m0.e.a.j0.a getSource() {
        return this.f;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public j0 getType() {
        return (j0) d0.e0.p.d.m0.m.n.getValue(this.e, this, (KProperty<?>) a[1]);
    }

    public /* synthetic */ e(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.k0.a aVar, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, aVar, (i & 4) != 0 ? false : z2);
    }
}
