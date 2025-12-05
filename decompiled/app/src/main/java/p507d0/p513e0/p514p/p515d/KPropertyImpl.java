package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty4;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.RuntimeTypeMapper2;
import p507d0.p513e0.p514p.p515d.p516l0.Caller2;
import p507d0.p513e0.p514p.p515d.p516l0.InlineClassAwareCaller2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyGetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.DescriptorsJvmAbiUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p592z.p594d.CallableReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: KPropertyImpl.kt */
/* renamed from: d0.e0.p.d.s, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {

    /* renamed from: n */
    public static final Object f25048n;

    /* renamed from: o */
    public final ReflectProperties.b<Field> f25049o;

    /* renamed from: p */
    public final ReflectProperties.a<PropertyDescriptor> f25050p;

    /* renamed from: q */
    public final KDeclarationContainerImpl f25051q;

    /* renamed from: r */
    public final String f25052r;

    /* renamed from: s */
    public final String f25053s;

    /* renamed from: t */
    public final Object f25054t;

    /* compiled from: KPropertyImpl.kt */
    /* renamed from: d0.e0.p.d.s$a */
    public static abstract class a<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType> {
        @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
        public Caller2<?> getDefaultCaller() {
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
        public abstract PropertyAccessorDescriptor getDescriptor();

        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
        public boolean isBound() {
            return getProperty().isBound();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            return getDescriptor().isExternal();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return getDescriptor().isInfix();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            return getDescriptor().isInline();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return getDescriptor().isOperator();
        }

        @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
        public boolean isSuspend() {
            return getDescriptor().isSuspend();
        }
    }

    /* compiled from: KPropertyImpl.kt */
    /* renamed from: d0.e0.p.d.s$b */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: KPropertyImpl.kt */
    /* renamed from: d0.e0.p.d.s$c */
    public static abstract class c<V> extends a<V, V> implements KProperty.Getter<V> {

        /* renamed from: n */
        public static final /* synthetic */ KProperty[] f25055n = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* renamed from: o */
        public final ReflectProperties.a f25056o = ReflectProperties.lazySoft(new b());

        /* renamed from: p */
        public final ReflectProperties.b f25057p = ReflectProperties.lazy(new a());

        /* compiled from: KPropertyImpl.kt */
        /* renamed from: d0.e0.p.d.s$c$a */
        public static final class a extends Lambda implements Function0<Caller2<?>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Caller2<?> invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Caller2<?> invoke() {
                return KPropertyImpl5.access$computeCallerForAccessor(c.this, true);
            }
        }

        /* compiled from: KPropertyImpl.kt */
        /* renamed from: d0.e0.p.d.s$c$b */
        public static final class b extends Lambda implements Function0<PropertyGetterDescriptor> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ PropertyGetterDescriptor invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PropertyGetterDescriptor invoke() {
                PropertyGetterDescriptor getter = c.this.getProperty().getDescriptor().getGetter();
                return getter != null ? getter : DescriptorFactory.createDefaultGetter(c.this.getProperty().getDescriptor(), Annotations4.f22735f.getEMPTY());
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
        public Caller2<?> getCaller() {
            return (Caller2) this.f25057p.getValue(this, f25055n[1]);
        }

        @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
        public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
            return getDescriptor();
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a, p507d0.p513e0.p514p.p515d.KCallableImpl
        public PropertyGetterDescriptor getDescriptor() {
            return (PropertyGetterDescriptor) this.f25056o.getValue(this, f25055n[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            StringBuilder sbM833U = outline.m833U("<get-");
            sbM833U.append(getProperty().getName());
            sbM833U.append('>');
            return sbM833U.toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a, p507d0.p513e0.p514p.p515d.KCallableImpl
        public /* bridge */ /* synthetic */ PropertyAccessorDescriptor getDescriptor() {
            return getDescriptor();
        }
    }

    /* compiled from: KPropertyImpl.kt */
    /* renamed from: d0.e0.p.d.s$d */
    public static abstract class d<V> extends a<V, Unit> implements KProperty4<V> {

        /* renamed from: n */
        public static final /* synthetic */ KProperty[] f25058n = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* renamed from: o */
        public final ReflectProperties.a f25059o = ReflectProperties.lazySoft(new b());

        /* renamed from: p */
        public final ReflectProperties.b f25060p = ReflectProperties.lazy(new a());

        /* compiled from: KPropertyImpl.kt */
        /* renamed from: d0.e0.p.d.s$d$a */
        public static final class a extends Lambda implements Function0<Caller2<?>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Caller2<?> invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Caller2<?> invoke() {
                return KPropertyImpl5.access$computeCallerForAccessor(d.this, false);
            }
        }

        /* compiled from: KPropertyImpl.kt */
        /* renamed from: d0.e0.p.d.s$d$b */
        public static final class b extends Lambda implements Function0<PropertySetterDescriptor> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ PropertySetterDescriptor invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PropertySetterDescriptor invoke() {
                PropertySetterDescriptor setter = d.this.getProperty().getDescriptor().getSetter();
                if (setter != null) {
                    return setter;
                }
                PropertyDescriptor descriptor = d.this.getProperty().getDescriptor();
                Annotations4.a aVar = Annotations4.f22735f;
                return DescriptorFactory.createDefaultSetter(descriptor, aVar.getEMPTY(), aVar.getEMPTY());
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
        public Caller2<?> getCaller() {
            return (Caller2) this.f25060p.getValue(this, f25058n[1]);
        }

        @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
        public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
            return getDescriptor();
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a, p507d0.p513e0.p514p.p515d.KCallableImpl
        public PropertySetterDescriptor getDescriptor() {
            return (PropertySetterDescriptor) this.f25059o.getValue(this, f25058n[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            StringBuilder sbM833U = outline.m833U("<set-");
            sbM833U.append(getProperty().getName());
            sbM833U.append('>');
            return sbM833U.toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a, p507d0.p513e0.p514p.p515d.KCallableImpl
        public /* bridge */ /* synthetic */ PropertyAccessorDescriptor getDescriptor() {
            return getDescriptor();
        }
    }

    /* compiled from: KPropertyImpl.kt */
    /* renamed from: d0.e0.p.d.s$e */
    public static final class e extends Lambda implements Function0<PropertyDescriptor> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ PropertyDescriptor invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyDescriptor invoke() {
            return KPropertyImpl.this.getContainer().findPropertyDescriptor(KPropertyImpl.this.getName(), KPropertyImpl.this.getSignature());
        }
    }

    /* compiled from: KPropertyImpl.kt */
    /* renamed from: d0.e0.p.d.s$f */
    public static final class f extends Lambda implements Function0<Field> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Field invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Field invoke2() {
            Class<?> enclosingClass;
            RuntimeTypeMapper2 runtimeTypeMapper2MapPropertySignature = RuntimeTypeMapper3.f22358b.mapPropertySignature(KPropertyImpl.this.getDescriptor());
            if (!(runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.c)) {
                if (runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.a) {
                    return ((RuntimeTypeMapper2.a) runtimeTypeMapper2MapPropertySignature).getField();
                }
                if ((runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.b) || (runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.d)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            RuntimeTypeMapper2.c cVar = (RuntimeTypeMapper2.c) runtimeTypeMapper2MapPropertySignature;
            PropertyDescriptor descriptor = cVar.getDescriptor();
            JvmMemberSignature.a jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.f23720a, cVar.getProto(), cVar.getNameResolver(), cVar.getTypeTable(), false, 8, null);
            if (jvmFieldSignature$default == null) {
                return null;
            }
            if (DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor) || JvmProtoBufUtil.isMovedFromInterfaceCompanion(cVar.getProto())) {
                enclosingClass = KPropertyImpl.this.getContainer().getJClass().getEnclosingClass();
            } else {
                DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                enclosingClass = containingDeclaration instanceof ClassDescriptor ? util2.toJavaClass((ClassDescriptor) containingDeclaration) : KPropertyImpl.this.getContainer().getJClass();
            }
            if (enclosingClass == null) {
                return null;
            }
            try {
                return enclosingClass.getDeclaredField(jvmFieldSignature$default.getName());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
    }

    static {
        new b(null);
        f25048n = new Object();
    }

    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.f25051q = kDeclarationContainerImpl;
        this.f25052r = str;
        this.f25053s = str2;
        this.f25054t = obj;
        ReflectProperties.b<Field> bVarLazy = ReflectProperties.lazy(new f());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.f25049o = bVarLazy;
        ReflectProperties.a<PropertyDescriptor> aVarLazySoft = ReflectProperties.lazySoft(propertyDescriptor, new e());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.f25050p = aVarLazySoft;
    }

    /* renamed from: c */
    public final Field m10056c() {
        if (getDescriptor().isDelegated()) {
            return getJavaField();
        }
        return null;
    }

    public boolean equals(Object obj) {
        KPropertyImpl<?> kPropertyImplAsKPropertyImpl = util2.asKPropertyImpl(obj);
        return kPropertyImplAsKPropertyImpl != null && Intrinsics3.areEqual(getContainer(), kPropertyImplAsKPropertyImpl.getContainer()) && Intrinsics3.areEqual(getName(), kPropertyImplAsKPropertyImpl.getName()) && Intrinsics3.areEqual(this.f25053s, kPropertyImplAsKPropertyImpl.f25053s) && Intrinsics3.areEqual(this.f25054t, kPropertyImplAsKPropertyImpl.f25054t);
    }

    public final Object getBoundReceiver() {
        return InlineClassAwareCaller2.coerceToExpectedReceiverType(this.f25054t, getDescriptor());
    }

    @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
    public Caller2<?> getCaller() {
        return mo11489getGetter().getCaller();
    }

    @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.f25051q;
    }

    @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
    public Caller2<?> getDefaultCaller() {
        return mo11489getGetter().getDefaultCaller();
    }

    @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
        return getDescriptor();
    }

    /* renamed from: getGetter */
    public abstract c<V> mo11489getGetter();

    public final Field getJavaField() {
        return this.f25049o.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.f25052r;
    }

    public final String getSignature() {
        return this.f25053s;
    }

    public int hashCode() {
        return this.f25053s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
    public boolean isBound() {
        return !Intrinsics3.areEqual(this.f25054t, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return ReflectionObjectRenderer.f22349b.renderProperty(getDescriptor());
    }

    @Override // p507d0.p513e0.p514p.p515d.KCallableImpl
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor propertyDescriptorInvoke = this.f25050p.invoke();
        Intrinsics3.checkNotNullExpressionValue(propertyDescriptorInvoke, "_descriptor()");
        return propertyDescriptorInvoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        String strAsString = propertyDescriptor.getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(kDeclarationContainerImpl, strAsString, RuntimeTypeMapper3.f22358b.mapPropertySignature(propertyDescriptor).asString(), propertyDescriptor, CallableReference.NO_RECEIVER);
    }
}
