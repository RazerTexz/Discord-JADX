package d0.e0.p.d;

import d0.e0.f;
import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.z0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;

/* compiled from: KCallableImpl.kt */
/* loaded from: classes3.dex */
public abstract class f<R> implements KCallable<R>, z {
    public final c0.a<List<Annotation>> j;
    public final c0.a<ArrayList<d0.e0.f>> k;
    public final c0.a<x> l;
    public final c0.a<List<y>> m;

    /* compiled from: KCallableImpl.kt */
    public static final class a extends d0.z.d.o implements Function0<List<? extends Annotation>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Annotation> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Annotation> invoke2() {
            return j0.computeAnnotations(f.this.getDescriptor());
        }
    }

    /* compiled from: KCallableImpl.kt */
    public static final class b extends d0.z.d.o implements Function0<ArrayList<d0.e0.f>> {

        /* compiled from: Comparisons.kt */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return d0.u.a.compareValues(((d0.e0.f) t).getName(), ((d0.e0.f) t2).getName());
            }
        }

        /* compiled from: KCallableImpl.kt */
        /* renamed from: d0.e0.p.d.f$b$b, reason: collision with other inner class name */
        public static final class C0496b extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.k0> {
            public final /* synthetic */ q0 $instanceReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0496b(q0 q0Var) {
                super(0);
                this.$instanceReceiver = q0Var;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.k0 invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.m0.c.k0 invoke() {
                return this.$instanceReceiver;
            }
        }

        /* compiled from: KCallableImpl.kt */
        public static final class c extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.k0> {
            public final /* synthetic */ q0 $extensionReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(q0 q0Var) {
                super(0);
                this.$extensionReceiver = q0Var;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.k0 invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.m0.c.k0 invoke() {
                return this.$extensionReceiver;
            }
        }

        /* compiled from: KCallableImpl.kt */
        public static final class d extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.k0> {
            public final /* synthetic */ d0.e0.p.d.m0.c.b $descriptor;
            public final /* synthetic */ int $i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(d0.e0.p.d.m0.c.b bVar, int i) {
                super(0);
                this.$descriptor = bVar;
                this.$i = i;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.k0 invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.m0.c.k0 invoke() {
                c1 c1Var = this.$descriptor.getValueParameters().get(this.$i);
                d0.z.d.m.checkNotNullExpressionValue(c1Var, "descriptor.valueParameters[i]");
                return c1Var;
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ArrayList<d0.e0.f> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ArrayList<d0.e0.f> invoke2() {
            int i;
            d0.e0.p.d.m0.c.b descriptor = f.this.getDescriptor();
            ArrayList<d0.e0.f> arrayList = new ArrayList<>();
            int i2 = 0;
            if (f.this.isBound()) {
                i = 0;
            } else {
                q0 instanceReceiverParameter = j0.getInstanceReceiverParameter(descriptor);
                if (instanceReceiverParameter != null) {
                    arrayList.add(new o(f.this, 0, f.a.INSTANCE, new C0496b(instanceReceiverParameter)));
                    i = 1;
                } else {
                    i = 0;
                }
                q0 extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                if (extensionReceiverParameter != null) {
                    arrayList.add(new o(f.this, i, f.a.EXTENSION_RECEIVER, new c(extensionReceiverParameter)));
                    i++;
                }
            }
            List<c1> valueParameters = descriptor.getValueParameters();
            d0.z.d.m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            int size = valueParameters.size();
            while (i2 < size) {
                arrayList.add(new o(f.this, i, f.a.VALUE, new d(descriptor, i2)));
                i2++;
                i++;
            }
            if (f.this.b() && (descriptor instanceof d0.e0.p.d.m0.e.a.h0.b) && arrayList.size() > 1) {
                d0.t.q.sortWith(arrayList, new a());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* compiled from: KCallableImpl.kt */
    public static final class c extends d0.z.d.o implements Function0<x> {

        /* compiled from: KCallableImpl.kt */
        public static final class a extends d0.z.d.o implements Function0<Type> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Type invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Type invoke2() {
                Type typeAccess$extractContinuationArgument = f.access$extractContinuationArgument(f.this);
                return typeAccess$extractContinuationArgument != null ? typeAccess$extractContinuationArgument : f.this.getCaller().getReturnType();
            }
        }

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ x invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x invoke() {
            d0.e0.p.d.m0.n.c0 returnType = f.this.getDescriptor().getReturnType();
            d0.z.d.m.checkNotNull(returnType);
            d0.z.d.m.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
            return new x(returnType, new a());
        }
    }

    /* compiled from: KCallableImpl.kt */
    public static final class d extends d0.z.d.o implements Function0<List<? extends y>> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends y> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends y> invoke2() {
            List<z0> typeParameters = f.this.getDescriptor().getTypeParameters();
            d0.z.d.m.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(typeParameters, 10));
            for (z0 z0Var : typeParameters) {
                f fVar = f.this;
                d0.z.d.m.checkNotNullExpressionValue(z0Var, "descriptor");
                arrayList.add(new y(fVar, z0Var));
            }
            return arrayList;
        }
    }

    public f() {
        c0.a<List<Annotation>> aVarLazySoft = c0.lazySoft(new a());
        d0.z.d.m.checkNotNullExpressionValue(aVarLazySoft, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.j = aVarLazySoft;
        c0.a<ArrayList<d0.e0.f>> aVarLazySoft2 = c0.lazySoft(new b());
        d0.z.d.m.checkNotNullExpressionValue(aVarLazySoft2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.k = aVarLazySoft2;
        c0.a<x> aVarLazySoft3 = c0.lazySoft(new c());
        d0.z.d.m.checkNotNullExpressionValue(aVarLazySoft3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.l = aVarLazySoft3;
        c0.a<List<y>> aVarLazySoft4 = c0.lazySoft(new d());
        d0.z.d.m.checkNotNullExpressionValue(aVarLazySoft4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.m = aVarLazySoft4;
    }

    public static final Type access$extractContinuationArgument(f fVar) {
        Type[] lowerBounds;
        d0.e0.p.d.m0.c.b descriptor = fVar.getDescriptor();
        if (!(descriptor instanceof d0.e0.p.d.m0.c.x)) {
            descriptor = null;
        }
        d0.e0.p.d.m0.c.x xVar = (d0.e0.p.d.m0.c.x) descriptor;
        if (xVar == null || !xVar.isSuspend()) {
            return null;
        }
        Object objLastOrNull = d0.t.u.lastOrNull((List<? extends Object>) fVar.getCaller().getParameterTypes());
        if (!(objLastOrNull instanceof ParameterizedType)) {
            objLastOrNull = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) objLastOrNull;
        if (!d0.z.d.m.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        d0.z.d.m.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
        Object objSingle = d0.t.k.single(actualTypeArguments);
        if (!(objSingle instanceof WildcardType)) {
            objSingle = null;
        }
        WildcardType wildcardType = (WildcardType) objSingle;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) d0.t.k.first(lowerBounds);
    }

    public final Object a(KType kType) throws NegativeArraySizeException {
        Class javaClass = d0.z.a.getJavaClass(d0.e0.p.a.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object objNewInstance = Array.newInstance(javaClass.getComponentType(), 0);
            d0.z.d.m.checkNotNullExpressionValue(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        StringBuilder sbU = b.d.b.a.a.U("Cannot instantiate the default empty array of type ");
        sbU.append(javaClass.getSimpleName());
        sbU.append(", because it is not an array type");
        throw new a0(sbU.toString());
    }

    public final boolean b() {
        return d0.z.d.m.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... objArr) throws IllegalCallableAccessException {
        d0.z.d.m.checkNotNullParameter(objArr, "args");
        try {
            return (R) getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<d0.e0.f, ? extends Object> map) throws IllegalCallableAccessException, NegativeArraySizeException {
        Object objA;
        d0.z.d.m.checkNotNullParameter(map, "args");
        if (!b()) {
            return callDefaultMethod$kotlin_reflection(map, null);
        }
        List<d0.e0.f> parameters = getParameters();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
        for (d0.e0.f fVar : parameters) {
            if (map.containsKey(fVar)) {
                objA = map.get(fVar);
                if (objA == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + fVar + ')');
                }
            } else if (fVar.isOptional()) {
                objA = null;
            } else {
                if (!fVar.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + fVar);
                }
                objA = a(fVar.getType());
            }
            arrayList.add(objA);
        }
        d0.e0.p.d.l0.d<?> defaultCaller = getDefaultCaller();
        if (defaultCaller == null) {
            StringBuilder sbU = b.d.b.a.a.U("This callable does not support a default call: ");
            sbU.append(getDescriptor());
            throw new a0(sbU.toString());
        }
        try {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return (R) defaultCaller.call(array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    public final R callDefaultMethod$kotlin_reflection(Map<d0.e0.f, ? extends Object> map, Continuation<?> continuation) throws IllegalCallableAccessException {
        d0.z.d.m.checkNotNullParameter(map, "args");
        List<d0.e0.f> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<d0.e0.f> it = parameters.iterator();
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (continuation != null) {
                    arrayList.add(continuation);
                }
                if (!z2) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i2));
                d0.e0.p.d.l0.d<?> defaultCaller = getDefaultCaller();
                if (defaultCaller == null) {
                    StringBuilder sbU = b.d.b.a.a.U("This callable does not support a default call: ");
                    sbU.append(getDescriptor());
                    throw new a0(sbU.toString());
                }
                arrayList.addAll(arrayList2);
                arrayList.add(null);
                try {
                    Object[] array2 = arrayList.toArray(new Object[0]);
                    if (array2 != null) {
                        return (R) defaultCaller.call(array2);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                } catch (IllegalAccessException e) {
                    throw new IllegalCallableAccessException(e);
                }
            }
            d0.e0.f next = it.next();
            if (i != 0 && i % 32 == 0) {
                arrayList2.add(Integer.valueOf(i2));
                i2 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.isOptional()) {
                arrayList.add(j0.isInlineClassType(next.getType()) ? null : j0.defaultPrimitiveValue(d0.e0.p.b.getJavaType(next.getType())));
                i2 = (1 << (i % 32)) | i2;
                z2 = true;
            } else {
                if (!next.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                arrayList.add(a(next.getType()));
            }
            if (next.getKind() == f.a.VALUE) {
                i++;
            }
        }
    }

    @Override // d0.e0.b
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this.j.invoke();
        d0.z.d.m.checkNotNullExpressionValue(listInvoke, "_annotations()");
        return listInvoke;
    }

    public abstract d0.e0.p.d.l0.d<?> getCaller();

    public abstract i getContainer();

    public abstract d0.e0.p.d.l0.d<?> getDefaultCaller();

    public abstract d0.e0.p.d.m0.c.b getDescriptor();

    @Override // kotlin.reflect.KCallable
    public List<d0.e0.f> getParameters() {
        ArrayList<d0.e0.f> arrayListInvoke = this.k.invoke();
        d0.z.d.m.checkNotNullExpressionValue(arrayListInvoke, "_parameters()");
        return arrayListInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        x xVarInvoke = this.l.invoke();
        d0.z.d.m.checkNotNullExpressionValue(xVarInvoke, "_returnType()");
        return xVarInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<d0.e0.h> getTypeParameters() {
        List<y> listInvoke = this.m.invoke();
        d0.z.d.m.checkNotNullExpressionValue(listInvoke, "_typeParameters()");
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        d0.e0.p.d.m0.c.u visibility = getDescriptor().getVisibility();
        d0.z.d.m.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return j0.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == d0.e0.p.d.m0.c.z.ABSTRACT;
    }

    public abstract boolean isBound();

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == d0.e0.p.d.m0.c.z.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == d0.e0.p.d.m0.c.z.OPEN;
    }
}
