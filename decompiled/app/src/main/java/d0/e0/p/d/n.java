package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.c0;
import d0.e0.p.d.i;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.k.a0.i;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;

/* compiled from: KPackageImpl.kt */
/* loaded from: classes3.dex */
public final class n extends i {
    public final c0.b<a> m;
    public final Class<?> n;

    /* compiled from: KPackageImpl.kt */
    public final class a extends i.b {
        public static final /* synthetic */ KProperty[] d = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "members", "getMembers()Ljava/util/Collection;"))};
        public final c0.a e;
        public final c0.a f;
        public final c0.b g;
        public final c0.b h;

        /* compiled from: KPackageImpl.kt */
        /* renamed from: d0.e0.p.d.n$a$a, reason: collision with other inner class name */
        public static final class C0591a extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.k1.a.f> {
            public C0591a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.k1.a.f invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.m0.c.k1.a.f invoke() {
                return d0.e0.p.d.m0.c.k1.a.f.a.create(n.this.getJClass());
            }
        }

        /* compiled from: KPackageImpl.kt */
        public static final class b extends d0.z.d.o implements Function0<Collection<? extends f<?>>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends f<?>> invoke2() {
                a aVar = a.this;
                return n.this.b(aVar.getScope(), i.c.DECLARED);
            }
        }

        /* compiled from: KPackageImpl.kt */
        public static final class c extends d0.z.d.o implements Function0<Triple<? extends d0.e0.p.d.m0.f.a0.b.g, ? extends d0.e0.p.d.m0.f.l, ? extends d0.e0.p.d.m0.f.a0.b.f>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Triple<? extends d0.e0.p.d.m0.f.a0.b.g, ? extends d0.e0.p.d.m0.f.l, ? extends d0.e0.p.d.m0.f.a0.b.f> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Triple<? extends d0.e0.p.d.m0.f.a0.b.g, ? extends d0.e0.p.d.m0.f.l, ? extends d0.e0.p.d.m0.f.a0.b.f> invoke2() {
                d0.e0.p.d.m0.e.b.b0.a classHeader;
                d0.e0.p.d.m0.c.k1.a.f fVarAccess$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                if (fVarAccess$getKotlinClass$p == null || (classHeader = fVarAccess$getKotlinClass$p.getClassHeader()) == null) {
                    return null;
                }
                String[] data = classHeader.getData();
                String[] strings = classHeader.getStrings();
                if (data == null || strings == null) {
                    return null;
                }
                Pair<d0.e0.p.d.m0.f.a0.b.g, d0.e0.p.d.m0.f.l> packageDataFrom = d0.e0.p.d.m0.f.a0.b.h.readPackageDataFrom(data, strings);
                return new Triple<>(packageDataFrom.component1(), packageDataFrom.component2(), classHeader.getMetadataVersion());
            }
        }

        /* compiled from: KPackageImpl.kt */
        public static final class d extends d0.z.d.o implements Function0<Class<?>> {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Class<?> invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Class<?> invoke() {
                d0.e0.p.d.m0.e.b.b0.a classHeader;
                d0.e0.p.d.m0.c.k1.a.f fVarAccess$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                String multifileClassName = (fVarAccess$getKotlinClass$p == null || (classHeader = fVarAccess$getKotlinClass$p.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
                if (multifileClassName == null) {
                    return null;
                }
                if (multifileClassName.length() > 0) {
                    return n.this.getJClass().getClassLoader().loadClass(d0.g0.t.replace$default(multifileClassName, MentionUtilsKt.SLASH_CHAR, '.', false, 4, (Object) null));
                }
                return null;
            }
        }

        /* compiled from: KPackageImpl.kt */
        public static final class e extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.a0.i> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.m0.k.a0.i invoke() {
                d0.e0.p.d.m0.c.k1.a.f fVarAccess$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                return fVarAccess$getKotlinClass$p != null ? a.this.getModuleData().getPackagePartScopeCache().getPackagePartScope(fVarAccess$getKotlinClass$p) : i.b.f3461b;
            }
        }

        public a() {
            super();
            this.e = c0.lazySoft(new C0591a());
            this.f = c0.lazySoft(new e());
            this.g = c0.lazy(new d());
            this.h = c0.lazy(new c());
            c0.lazySoft(new b());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final d0.e0.p.d.m0.c.k1.a.f access$getKotlinClass$p(a aVar) {
            return (d0.e0.p.d.m0.c.k1.a.f) aVar.e.getValue(aVar, d[0]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Triple<d0.e0.p.d.m0.f.a0.b.g, d0.e0.p.d.m0.f.l, d0.e0.p.d.m0.f.a0.b.f> getMetadata() {
            return (Triple) this.h.getValue(this, d[3]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Class<?> getMultifileFacade() {
            return (Class) this.g.getValue(this, d[2]);
        }

        public final d0.e0.p.d.m0.k.a0.i getScope() {
            return (d0.e0.p.d.m0.k.a0.i) this.f.getValue(this, d[1]);
        }
    }

    /* compiled from: KPackageImpl.kt */
    public static final class b extends d0.z.d.o implements Function0<a> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ a invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return n.this.new a();
        }
    }

    /* compiled from: KPackageImpl.kt */
    public static final /* synthetic */ class c extends d0.z.d.j implements Function2<d0.e0.p.d.m0.l.b.u, d0.e0.p.d.m0.f.n, n0> {
        public static final c j = new c();

        public c() {
            super(2);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "loadProperty";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return d0.z.d.a0.getOrCreateKotlinClass(d0.e0.p.d.m0.l.b.u.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ n0 invoke(d0.e0.p.d.m0.l.b.u uVar, d0.e0.p.d.m0.f.n nVar) {
            return invoke2(uVar, nVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final n0 invoke2(d0.e0.p.d.m0.l.b.u uVar, d0.e0.p.d.m0.f.n nVar) {
            d0.z.d.m.checkNotNullParameter(uVar, "p1");
            d0.z.d.m.checkNotNullParameter(nVar, "p2");
            return uVar.loadProperty(nVar);
        }
    }

    public n(Class<?> cls, String str) {
        d0.z.d.m.checkNotNullParameter(cls, "jClass");
        this.n = cls;
        c0.b<a> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Data() }");
        this.m = bVarLazy;
    }

    @Override // d0.e0.p.d.i
    public Class<?> c() {
        Class<?> multifileFacade = this.m.invoke().getMultifileFacade();
        return multifileFacade != null ? multifileFacade : getJClass();
    }

    public boolean equals(Object obj) {
        return (obj instanceof n) && d0.z.d.m.areEqual(getJClass(), ((n) obj).getJClass());
    }

    @Override // d0.e0.p.d.i
    public Collection<d0.e0.p.d.m0.c.l> getConstructorDescriptors() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.i
    public Collection<d0.e0.p.d.m0.c.x> getFunctions(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.m.invoke().getScope().getContributedFunctions(eVar, d0.e0.p.d.m0.d.b.d.FROM_REFLECTION);
    }

    @Override // d0.z.d.e
    public Class<?> getJClass() {
        return this.n;
    }

    @Override // d0.e0.p.d.i
    public n0 getLocalProperty(int i) {
        Triple<d0.e0.p.d.m0.f.a0.b.g, d0.e0.p.d.m0.f.l, d0.e0.p.d.m0.f.a0.b.f> metadata = this.m.invoke().getMetadata();
        if (metadata == null) {
            return null;
        }
        d0.e0.p.d.m0.f.a0.b.g gVarComponent1 = metadata.component1();
        d0.e0.p.d.m0.f.l lVarComponent2 = metadata.component2();
        d0.e0.p.d.m0.f.a0.b.f fVarComponent3 = metadata.component3();
        g.f<d0.e0.p.d.m0.f.l, List<d0.e0.p.d.m0.f.n>> fVar = d0.e0.p.d.m0.f.a0.a.n;
        d0.z.d.m.checkNotNullExpressionValue(fVar, "JvmProtoBuf.packageLocalVariable");
        d0.e0.p.d.m0.f.n nVar = (d0.e0.p.d.m0.f.n) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(lVarComponent2, fVar, i);
        if (nVar == null) {
            return null;
        }
        Class<?> jClass = getJClass();
        d0.e0.p.d.m0.f.t typeTable = lVarComponent2.getTypeTable();
        d0.z.d.m.checkNotNullExpressionValue(typeTable, "packageProto.typeTable");
        return (n0) j0.deserializeToDescriptor(jClass, nVar, gVarComponent1, new d0.e0.p.d.m0.f.z.g(typeTable), fVarComponent3, c.j);
    }

    @Override // d0.e0.p.d.i
    public Collection<n0> getProperties(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.m.invoke().getScope().getContributedVariables(eVar, d0.e0.p.d.m0.d.b.d.FROM_REFLECTION);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("file class ");
        sbU.append(d0.e0.p.d.m0.c.k1.b.b.getClassId(getJClass()).asSingleFqName());
        return sbU.toString();
    }
}
