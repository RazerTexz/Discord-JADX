package p507d0.p513e0.p514p.p515d;

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
import kotlin.reflect.full.exceptions;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.KParameter;
import p507d0.p513e0.KTypeParameter;
import p507d0.p513e0.p514p.KTypesJvm;
import p507d0.p513e0.p514p.ReflectJvmMapping;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p516l0.Caller2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaCallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MutableCollectionsJVM;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p582u.C12169a;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: KCallableImpl.kt */
/* renamed from: d0.e0.p.d.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {

    /* renamed from: j */
    public final ReflectProperties.a<List<Annotation>> f22352j;

    /* renamed from: k */
    public final ReflectProperties.a<ArrayList<KParameter>> f22353k;

    /* renamed from: l */
    public final ReflectProperties.a<KTypeImpl> f22354l;

    /* renamed from: m */
    public final ReflectProperties.a<List<KTypeParameterImpl>> f22355m;

    /* compiled from: KCallableImpl.kt */
    /* renamed from: d0.e0.p.d.f$a */
    public static final class a extends Lambda implements Function0<List<? extends Annotation>> {
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
            return util2.computeAnnotations(KCallableImpl.this.getDescriptor());
        }
    }

    /* compiled from: KCallableImpl.kt */
    /* renamed from: d0.e0.p.d.f$b */
    public static final class b extends Lambda implements Function0<ArrayList<KParameter>> {

        /* compiled from: Comparisons.kt */
        /* renamed from: d0.e0.p.d.f$b$a */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return C12169a.compareValues(((KParameter) t).getName(), ((KParameter) t2).getName());
            }
        }

        /* compiled from: KCallableImpl.kt */
        /* renamed from: d0.e0.p.d.f$b$b, reason: collision with other inner class name */
        public static final class C13301b extends Lambda implements Function0<ParameterDescriptor> {
            public final /* synthetic */ ReceiverParameterDescriptor $instanceReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13301b(ReceiverParameterDescriptor receiverParameterDescriptor) {
                super(0);
                this.$instanceReceiver = receiverParameterDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ ParameterDescriptor invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ParameterDescriptor invoke() {
                return this.$instanceReceiver;
            }
        }

        /* compiled from: KCallableImpl.kt */
        /* renamed from: d0.e0.p.d.f$b$c */
        public static final class c extends Lambda implements Function0<ParameterDescriptor> {
            public final /* synthetic */ ReceiverParameterDescriptor $extensionReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(ReceiverParameterDescriptor receiverParameterDescriptor) {
                super(0);
                this.$extensionReceiver = receiverParameterDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ ParameterDescriptor invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ParameterDescriptor invoke() {
                return this.$extensionReceiver;
            }
        }

        /* compiled from: KCallableImpl.kt */
        /* renamed from: d0.e0.p.d.f$b$d */
        public static final class d extends Lambda implements Function0<ParameterDescriptor> {
            public final /* synthetic */ CallableMemberDescriptor $descriptor;

            /* renamed from: $i */
            public final /* synthetic */ int f22356$i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(CallableMemberDescriptor callableMemberDescriptor, int i) {
                super(0);
                this.$descriptor = callableMemberDescriptor;
                this.f22356$i = i;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ ParameterDescriptor invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ParameterDescriptor invoke() {
                ValueParameterDescriptor valueParameterDescriptor = this.$descriptor.getValueParameters().get(this.f22356$i);
                Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "descriptor.valueParameters[i]");
                return valueParameterDescriptor;
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ArrayList<KParameter> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ArrayList<KParameter> invoke2() {
            int i;
            CallableMemberDescriptor descriptor = KCallableImpl.this.getDescriptor();
            ArrayList<KParameter> arrayList = new ArrayList<>();
            int i2 = 0;
            if (KCallableImpl.this.isBound()) {
                i = 0;
            } else {
                ReceiverParameterDescriptor instanceReceiverParameter = util2.getInstanceReceiverParameter(descriptor);
                if (instanceReceiverParameter != null) {
                    arrayList.add(new KParameterImpl(KCallableImpl.this, 0, KParameter.a.INSTANCE, new C13301b(instanceReceiverParameter)));
                    i = 1;
                } else {
                    i = 0;
                }
                ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                if (extensionReceiverParameter != null) {
                    arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.a.EXTENSION_RECEIVER, new c(extensionReceiverParameter)));
                    i++;
                }
            }
            List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            int size = valueParameters.size();
            while (i2 < size) {
                arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.a.VALUE, new d(descriptor, i2)));
                i2++;
                i++;
            }
            if (KCallableImpl.this.m9337b() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
                MutableCollectionsJVM.sortWith(arrayList, new a());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* compiled from: KCallableImpl.kt */
    /* renamed from: d0.e0.p.d.f$c */
    public static final class c extends Lambda implements Function0<KTypeImpl> {

        /* compiled from: KCallableImpl.kt */
        /* renamed from: d0.e0.p.d.f$c$a */
        public static final class a extends Lambda implements Function0<Type> {
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
                Type typeAccess$extractContinuationArgument = KCallableImpl.access$extractContinuationArgument(KCallableImpl.this);
                return typeAccess$extractContinuationArgument != null ? typeAccess$extractContinuationArgument : KCallableImpl.this.getCaller().getReturnType();
            }
        }

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KTypeImpl invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KTypeImpl invoke() {
            KotlinType returnType = KCallableImpl.this.getDescriptor().getReturnType();
            Intrinsics3.checkNotNull(returnType);
            Intrinsics3.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
            return new KTypeImpl(returnType, new a());
        }
    }

    /* compiled from: KCallableImpl.kt */
    /* renamed from: d0.e0.p.d.f$d */
    public static final class d extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends KTypeParameterImpl> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends KTypeParameterImpl> invoke2() {
            List<TypeParameterDescriptor> typeParameters = KCallableImpl.this.getDescriptor().getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(typeParameters, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : typeParameters) {
                KCallableImpl kCallableImpl = KCallableImpl.this;
                Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "descriptor");
                arrayList.add(new KTypeParameterImpl(kCallableImpl, typeParameterDescriptor));
            }
            return arrayList;
        }
    }

    public KCallableImpl() {
        ReflectProperties.a<List<Annotation>> aVarLazySoft = ReflectProperties.lazySoft(new a());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.f22352j = aVarLazySoft;
        ReflectProperties.a<ArrayList<KParameter>> aVarLazySoft2 = ReflectProperties.lazySoft(new b());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.f22353k = aVarLazySoft2;
        ReflectProperties.a<KTypeImpl> aVarLazySoft3 = ReflectProperties.lazySoft(new c());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.f22354l = aVarLazySoft3;
        ReflectProperties.a<List<KTypeParameterImpl>> aVarLazySoft4 = ReflectProperties.lazySoft(new d());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.f22355m = aVarLazySoft4;
    }

    public static final Type access$extractContinuationArgument(KCallableImpl kCallableImpl) {
        Type[] lowerBounds;
        CallableMemberDescriptor descriptor = kCallableImpl.getDescriptor();
        if (!(descriptor instanceof FunctionDescriptor)) {
            descriptor = null;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) descriptor;
        if (functionDescriptor == null || !functionDescriptor.isSuspend()) {
            return null;
        }
        Object objLastOrNull = _Collections.lastOrNull((List<? extends Object>) kCallableImpl.getCaller().getParameterTypes());
        if (!(objLastOrNull instanceof ParameterizedType)) {
            objLastOrNull = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) objLastOrNull;
        if (!Intrinsics3.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics3.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
        Object objSingle = _Arrays.single(actualTypeArguments);
        if (!(objSingle instanceof WildcardType)) {
            objSingle = null;
        }
        WildcardType wildcardType = (WildcardType) objSingle;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) _Arrays.first(lowerBounds);
    }

    /* renamed from: a */
    public final Object m9336a(KType kType) throws NegativeArraySizeException {
        Class javaClass = JvmClassMapping.getJavaClass(KTypesJvm.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object objNewInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics3.checkNotNullExpressionValue(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        StringBuilder sbM833U = outline.m833U("Cannot instantiate the default empty array of type ");
        sbM833U.append(javaClass.getSimpleName());
        sbM833U.append(", because it is not an array type");
        throw new KotlinReflectionInternalError(sbM833U.toString());
    }

    /* renamed from: b */
    public final boolean m9337b() {
        return Intrinsics3.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... objArr) throws exceptions {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        try {
            return (R) getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new exceptions(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> map) throws exceptions, NegativeArraySizeException {
        Object objM9336a;
        Intrinsics3.checkNotNullParameter(map, "args");
        if (!m9337b()) {
            return callDefaultMethod$kotlin_reflection(map, null);
        }
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                objM9336a = map.get(kParameter);
                if (objM9336a == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.isOptional()) {
                objM9336a = null;
            } else {
                if (!kParameter.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                objM9336a = m9336a(kParameter.getType());
            }
            arrayList.add(objM9336a);
        }
        Caller2<?> defaultCaller = getDefaultCaller();
        if (defaultCaller == null) {
            StringBuilder sbM833U = outline.m833U("This callable does not support a default call: ");
            sbM833U.append(getDescriptor());
            throw new KotlinReflectionInternalError(sbM833U.toString());
        }
        try {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return (R) defaultCaller.call(array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e) {
            throw new exceptions(e);
        }
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> map, Continuation<?> continuation) throws exceptions {
        Intrinsics3.checkNotNullParameter(map, "args");
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
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
                Caller2<?> defaultCaller = getDefaultCaller();
                if (defaultCaller == null) {
                    StringBuilder sbM833U = outline.m833U("This callable does not support a default call: ");
                    sbM833U.append(getDescriptor());
                    throw new KotlinReflectionInternalError(sbM833U.toString());
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
                    throw new exceptions(e);
                }
            }
            KParameter next = it.next();
            if (i != 0 && i % 32 == 0) {
                arrayList2.add(Integer.valueOf(i2));
                i2 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.isOptional()) {
                arrayList.add(util2.isInlineClassType(next.getType()) ? null : util2.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(next.getType())));
                i2 = (1 << (i % 32)) | i2;
                z2 = true;
            } else {
                if (!next.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                arrayList.add(m9336a(next.getType()));
            }
            if (next.getKind() == KParameter.a.VALUE) {
                i++;
            }
        }
    }

    @Override // p507d0.p513e0.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this.f22352j.invoke();
        Intrinsics3.checkNotNullExpressionValue(listInvoke, "_annotations()");
        return listInvoke;
    }

    public abstract Caller2<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller2<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        ArrayList<KParameter> arrayListInvoke = this.f22353k.invoke();
        Intrinsics3.checkNotNullExpressionValue(arrayListInvoke, "_parameters()");
        return arrayListInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KTypeImpl kTypeImplInvoke = this.f22354l.invoke();
        Intrinsics3.checkNotNullExpressionValue(kTypeImplInvoke, "_returnType()");
        return kTypeImplInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> listInvoke = this.f22355m.invoke();
        Intrinsics3.checkNotNullExpressionValue(listInvoke, "_typeParameters()");
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        DescriptorVisibility2 visibility = getDescriptor().getVisibility();
        Intrinsics3.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return util2.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    public abstract boolean isBound();

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }
}
