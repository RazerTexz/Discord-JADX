package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.c0;
import d0.e0.p.d.e;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.f.a0.b.e;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KProperty;

/* compiled from: KPropertyImpl.kt */
/* loaded from: classes3.dex */
public abstract class s<V> extends d0.e0.p.d.f<V> implements KProperty<V> {
    public static final Object n;
    public final c0.b<Field> o;
    public final c0.a<n0> p;
    public final i q;
    public final String r;

    /* renamed from: s, reason: collision with root package name */
    public final String f3568s;
    public final Object t;

    /* compiled from: KPropertyImpl.kt */
    public static abstract class a<PropertyType, ReturnType> extends d0.e0.p.d.f<ReturnType> implements KFunction<ReturnType> {
        @Override // d0.e0.p.d.f
        public i getContainer() {
            return getProperty().getContainer();
        }

        @Override // d0.e0.p.d.f
        public d0.e0.p.d.l0.d<?> getDefaultCaller() {
            return null;
        }

        @Override // d0.e0.p.d.f
        public abstract m0 getDescriptor();

        public abstract s<PropertyType> getProperty();

        @Override // d0.e0.p.d.f
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
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: KPropertyImpl.kt */
    public static abstract class c<V> extends a<V, V> implements KProperty.Getter<V> {
        public static final /* synthetic */ KProperty[] n = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        public final c0.a o = c0.lazySoft(new b());
        public final c0.b p = c0.lazy(new a());

        /* compiled from: KPropertyImpl.kt */
        public static final class a extends d0.z.d.o implements Function0<d0.e0.p.d.l0.d<?>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ d0.e0.p.d.l0.d<?> invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.l0.d<?> invoke() {
                return w.access$computeCallerForAccessor(c.this, true);
            }
        }

        /* compiled from: KPropertyImpl.kt */
        public static final class b extends d0.z.d.o implements Function0<o0> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ o0 invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final o0 invoke() {
                o0 getter = c.this.getProperty().getDescriptor().getGetter();
                return getter != null ? getter : d0.e0.p.d.m0.k.d.createDefaultGetter(c.this.getProperty().getDescriptor(), d0.e0.p.d.m0.c.g1.g.f.getEMPTY());
            }
        }

        @Override // d0.e0.p.d.f
        public d0.e0.p.d.l0.d<?> getCaller() {
            return (d0.e0.p.d.l0.d) this.p.getValue(this, n[1]);
        }

        @Override // d0.e0.p.d.f
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getDescriptor() {
            return getDescriptor();
        }

        @Override // d0.e0.p.d.s.a, d0.e0.p.d.f
        public o0 getDescriptor() {
            return (o0) this.o.getValue(this, n[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            StringBuilder sbU = b.d.b.a.a.U("<get-");
            sbU.append(getProperty().getName());
            sbU.append('>');
            return sbU.toString();
        }

        @Override // d0.e0.p.d.s.a, d0.e0.p.d.f
        public /* bridge */ /* synthetic */ m0 getDescriptor() {
            return getDescriptor();
        }
    }

    /* compiled from: KPropertyImpl.kt */
    public static abstract class d<V> extends a<V, Unit> implements KMutableProperty$Setter<V> {
        public static final /* synthetic */ KProperty[] n = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        public final c0.a o = c0.lazySoft(new b());
        public final c0.b p = c0.lazy(new a());

        /* compiled from: KPropertyImpl.kt */
        public static final class a extends d0.z.d.o implements Function0<d0.e0.p.d.l0.d<?>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ d0.e0.p.d.l0.d<?> invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.l0.d<?> invoke() {
                return w.access$computeCallerForAccessor(d.this, false);
            }
        }

        /* compiled from: KPropertyImpl.kt */
        public static final class b extends d0.z.d.o implements Function0<p0> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p0 invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final p0 invoke() {
                p0 setter = d.this.getProperty().getDescriptor().getSetter();
                if (setter != null) {
                    return setter;
                }
                n0 descriptor = d.this.getProperty().getDescriptor();
                g.a aVar = d0.e0.p.d.m0.c.g1.g.f;
                return d0.e0.p.d.m0.k.d.createDefaultSetter(descriptor, aVar.getEMPTY(), aVar.getEMPTY());
            }
        }

        @Override // d0.e0.p.d.f
        public d0.e0.p.d.l0.d<?> getCaller() {
            return (d0.e0.p.d.l0.d) this.p.getValue(this, n[1]);
        }

        @Override // d0.e0.p.d.f
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getDescriptor() {
            return getDescriptor();
        }

        @Override // d0.e0.p.d.s.a, d0.e0.p.d.f
        public p0 getDescriptor() {
            return (p0) this.o.getValue(this, n[0]);
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            StringBuilder sbU = b.d.b.a.a.U("<set-");
            sbU.append(getProperty().getName());
            sbU.append('>');
            return sbU.toString();
        }

        @Override // d0.e0.p.d.s.a, d0.e0.p.d.f
        public /* bridge */ /* synthetic */ m0 getDescriptor() {
            return getDescriptor();
        }
    }

    /* compiled from: KPropertyImpl.kt */
    public static final class e extends d0.z.d.o implements Function0<n0> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ n0 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final n0 invoke() {
            return s.this.getContainer().findPropertyDescriptor(s.this.getName(), s.this.getSignature());
        }
    }

    /* compiled from: KPropertyImpl.kt */
    public static final class f extends d0.z.d.o implements Function0<Field> {
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
            d0.e0.p.d.e eVarMapPropertySignature = f0.f3198b.mapPropertySignature(s.this.getDescriptor());
            if (!(eVarMapPropertySignature instanceof e.c)) {
                if (eVarMapPropertySignature instanceof e.a) {
                    return ((e.a) eVarMapPropertySignature).getField();
                }
                if ((eVarMapPropertySignature instanceof e.b) || (eVarMapPropertySignature instanceof e.d)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            e.c cVar = (e.c) eVarMapPropertySignature;
            n0 descriptor = cVar.getDescriptor();
            e.a jvmFieldSignature$default = d0.e0.p.d.m0.f.a0.b.h.getJvmFieldSignature$default(d0.e0.p.d.m0.f.a0.b.h.a, cVar.getProto(), cVar.getNameResolver(), cVar.getTypeTable(), false, 8, null);
            if (jvmFieldSignature$default == null) {
                return null;
            }
            if (d0.e0.p.d.m0.e.a.n.isPropertyWithBackingFieldInOuterClass(descriptor) || d0.e0.p.d.m0.f.a0.b.h.isMovedFromInterfaceCompanion(cVar.getProto())) {
                enclosingClass = s.this.getContainer().getJClass().getEnclosingClass();
            } else {
                d0.e0.p.d.m0.c.m containingDeclaration = descriptor.getContainingDeclaration();
                enclosingClass = containingDeclaration instanceof d0.e0.p.d.m0.c.e ? j0.toJavaClass((d0.e0.p.d.m0.c.e) containingDeclaration) : s.this.getContainer().getJClass();
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
        n = new Object();
    }

    public s(i iVar, String str, String str2, n0 n0Var, Object obj) {
        this.q = iVar;
        this.r = str;
        this.f3568s = str2;
        this.t = obj;
        c0.b<Field> bVarLazy = c0.lazy(new f());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.o = bVarLazy;
        c0.a<n0> aVarLazySoft = c0.lazySoft(n0Var, new e());
        d0.z.d.m.checkNotNullExpressionValue(aVarLazySoft, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.p = aVarLazySoft;
    }

    public final Field c() {
        if (getDescriptor().isDelegated()) {
            return getJavaField();
        }
        return null;
    }

    public boolean equals(Object obj) {
        s<?> sVarAsKPropertyImpl = j0.asKPropertyImpl(obj);
        return sVarAsKPropertyImpl != null && d0.z.d.m.areEqual(getContainer(), sVarAsKPropertyImpl.getContainer()) && d0.z.d.m.areEqual(getName(), sVarAsKPropertyImpl.getName()) && d0.z.d.m.areEqual(this.f3568s, sVarAsKPropertyImpl.f3568s) && d0.z.d.m.areEqual(this.t, sVarAsKPropertyImpl.t);
    }

    public final Object getBoundReceiver() {
        return d0.e0.p.d.l0.h.coerceToExpectedReceiverType(this.t, getDescriptor());
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getCaller() {
        return mo112getGetter().getCaller();
    }

    @Override // d0.e0.p.d.f
    public i getContainer() {
        return this.q;
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getDefaultCaller() {
        return mo112getGetter().getDefaultCaller();
    }

    @Override // d0.e0.p.d.f
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getDescriptor() {
        return getDescriptor();
    }

    /* renamed from: getGetter */
    public abstract c<V> mo112getGetter();

    public final Field getJavaField() {
        return this.o.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.r;
    }

    public final String getSignature() {
        return this.f3568s;
    }

    public int hashCode() {
        return this.f3568s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // d0.e0.p.d.f
    public boolean isBound() {
        return !d0.z.d.m.areEqual(this.t, d0.z.d.d.NO_RECEIVER);
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
        return e0.f3197b.renderProperty(getDescriptor());
    }

    @Override // d0.e0.p.d.f
    public n0 getDescriptor() {
        n0 n0VarInvoke = this.p.invoke();
        d0.z.d.m.checkNotNullExpressionValue(n0VarInvoke, "_descriptor()");
        return n0VarInvoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(i iVar, String str, String str2, Object obj) {
        this(iVar, str, str2, null, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public s(i iVar, n0 n0Var) {
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        String strAsString = n0Var.getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(iVar, strAsString, f0.f3198b.mapPropertySignature(n0Var).asString(), n0Var, d0.z.d.d.NO_RECEIVER);
    }
}
