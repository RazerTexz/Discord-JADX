package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Tuples2;
import kotlin.Tuples3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.ReflectKotlinClass2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMetadataVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmNameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.ProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.MemberDeserializer;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: KPackageImpl.kt */
/* renamed from: d0.e0.p.d.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {

    /* renamed from: m */
    public final ReflectProperties.b<a> f25009m;

    /* renamed from: n */
    public final Class<?> f25010n;

    /* compiled from: KPackageImpl.kt */
    /* renamed from: d0.e0.p.d.n$a */
    public final class a extends KDeclarationContainerImpl.b {

        /* renamed from: d */
        public static final /* synthetic */ KProperty[] f25011d = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "members", "getMembers()Ljava/util/Collection;"))};

        /* renamed from: e */
        public final ReflectProperties.a f25012e;

        /* renamed from: f */
        public final ReflectProperties.a f25013f;

        /* renamed from: g */
        public final ReflectProperties.b f25014g;

        /* renamed from: h */
        public final ReflectProperties.b f25015h;

        /* compiled from: KPackageImpl.kt */
        /* renamed from: d0.e0.p.d.n$a$a, reason: collision with other inner class name */
        public static final class C13341a extends Lambda implements Function0<ReflectKotlinClass2> {
            public C13341a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ ReflectKotlinClass2 invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReflectKotlinClass2 invoke() {
                return ReflectKotlinClass2.f23015a.create(KPackageImpl.this.getJClass());
            }
        }

        /* compiled from: KPackageImpl.kt */
        /* renamed from: d0.e0.p.d.n$a$b */
        public static final class b extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends KCallableImpl<?>> invoke2() {
                a aVar = a.this;
                return KPackageImpl.this.m9341b(aVar.getScope(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* compiled from: KPackageImpl.kt */
        /* renamed from: d0.e0.p.d.n$a$c */
        public static final class c extends Lambda implements Function0<Tuples3<? extends JvmNameResolver, ? extends C11687l, ? extends JvmMetadataVersion>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Tuples3<? extends JvmNameResolver, ? extends C11687l, ? extends JvmMetadataVersion> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Tuples3<? extends JvmNameResolver, ? extends C11687l, ? extends JvmMetadataVersion> invoke2() {
                KotlinClassHeader classHeader;
                ReflectKotlinClass2 reflectKotlinClass2Access$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                if (reflectKotlinClass2Access$getKotlinClass$p == null || (classHeader = reflectKotlinClass2Access$getKotlinClass$p.getClassHeader()) == null) {
                    return null;
                }
                String[] data = classHeader.getData();
                String[] strings = classHeader.getStrings();
                if (data == null || strings == null) {
                    return null;
                }
                Tuples2<JvmNameResolver, C11687l> packageDataFrom = JvmProtoBufUtil.readPackageDataFrom(data, strings);
                return new Tuples3<>(packageDataFrom.component1(), packageDataFrom.component2(), classHeader.getMetadataVersion());
            }
        }

        /* compiled from: KPackageImpl.kt */
        /* renamed from: d0.e0.p.d.n$a$d */
        public static final class d extends Lambda implements Function0<Class<?>> {
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
                KotlinClassHeader classHeader;
                ReflectKotlinClass2 reflectKotlinClass2Access$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                String multifileClassName = (reflectKotlinClass2Access$getKotlinClass$p == null || (classHeader = reflectKotlinClass2Access$getKotlinClass$p.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
                if (multifileClassName == null) {
                    return null;
                }
                if (multifileClassName.length() > 0) {
                    return KPackageImpl.this.getJClass().getClassLoader().loadClass(StringsJVM.replace$default(multifileClassName, MentionUtils.SLASH_CHAR, '.', false, 4, (Object) null));
                }
                return null;
            }
        }

        /* compiled from: KPackageImpl.kt */
        /* renamed from: d0.e0.p.d.n$a$e */
        public static final class e extends Lambda implements Function0<MemberScope3> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ MemberScope3 invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MemberScope3 invoke() {
                ReflectKotlinClass2 reflectKotlinClass2Access$getKotlinClass$p = a.access$getKotlinClass$p(a.this);
                return reflectKotlinClass2Access$getKotlinClass$p != null ? a.this.getModuleData().getPackagePartScopeCache().getPackagePartScope(reflectKotlinClass2Access$getKotlinClass$p) : MemberScope3.b.f24373b;
            }
        }

        public a() {
            super();
            this.f25012e = ReflectProperties.lazySoft(new C13341a());
            this.f25013f = ReflectProperties.lazySoft(new e());
            this.f25014g = ReflectProperties.lazy(new d());
            this.f25015h = ReflectProperties.lazy(new c());
            ReflectProperties.lazySoft(new b());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final ReflectKotlinClass2 access$getKotlinClass$p(a aVar) {
            return (ReflectKotlinClass2) aVar.f25012e.getValue(aVar, f25011d[0]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Tuples3<JvmNameResolver, C11687l, JvmMetadataVersion> getMetadata() {
            return (Tuples3) this.f25015h.getValue(this, f25011d[3]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Class<?> getMultifileFacade() {
            return (Class) this.f25014g.getValue(this, f25011d[2]);
        }

        public final MemberScope3 getScope() {
            return (MemberScope3) this.f25013f.getValue(this, f25011d[1]);
        }
    }

    /* compiled from: KPackageImpl.kt */
    /* renamed from: d0.e0.p.d.n$b */
    public static final class b extends Lambda implements Function0<a> {
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
            return KPackageImpl.this.new a();
        }
    }

    /* compiled from: KPackageImpl.kt */
    /* renamed from: d0.e0.p.d.n$c */
    public static final /* synthetic */ class c extends FunctionReference implements Function2<MemberDeserializer, C11689n, PropertyDescriptor> {

        /* renamed from: j */
        public static final c f25017j = new c();

        public c() {
            super(2);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadProperty";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(MemberDeserializer.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ PropertyDescriptor invoke(MemberDeserializer memberDeserializer, C11689n c11689n) {
            return invoke2(memberDeserializer, c11689n);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final PropertyDescriptor invoke2(MemberDeserializer memberDeserializer, C11689n c11689n) {
            Intrinsics3.checkNotNullParameter(memberDeserializer, "p1");
            Intrinsics3.checkNotNullParameter(c11689n, "p2");
            return memberDeserializer.loadProperty(c11689n);
        }
    }

    public KPackageImpl(Class<?> cls, String str) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        this.f25010n = cls;
        ReflectProperties.b<a> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Data() }");
        this.f25009m = bVarLazy;
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    /* renamed from: c */
    public Class<?> mo9342c() {
        Class<?> multifileFacade = this.f25009m.invoke().getMultifileFacade();
        return multifileFacade != null ? multifileFacade : getJClass();
    }

    public boolean equals(Object obj) {
        return (obj instanceof KPackageImpl) && Intrinsics3.areEqual(getJClass(), ((KPackageImpl) obj).getJClass());
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f25009m.invoke().getScope().getContributedFunctions(name, LookupLocation3.FROM_REFLECTION);
    }

    @Override // p507d0.p592z.p594d.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.f25010n;
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        Tuples3<JvmNameResolver, C11687l, JvmMetadataVersion> metadata = this.f25009m.invoke().getMetadata();
        if (metadata == null) {
            return null;
        }
        JvmNameResolver jvmNameResolverComponent1 = metadata.component1();
        C11687l c11687lComponent2 = metadata.component2();
        JvmMetadataVersion jvmMetadataVersionComponent3 = metadata.component3();
        GeneratedMessageLite.f<C11687l, List<C11689n>> fVar = JvmProtoBuf.f23664n;
        Intrinsics3.checkNotNullExpressionValue(fVar, "JvmProtoBuf.packageLocalVariable");
        C11689n c11689n = (C11689n) ProtoBufUtil.getExtensionOrNull(c11687lComponent2, fVar, i);
        if (c11689n == null) {
            return null;
        }
        Class<?> jClass = getJClass();
        C11695t typeTable = c11687lComponent2.getTypeTable();
        Intrinsics3.checkNotNullExpressionValue(typeTable, "packageProto.typeTable");
        return (PropertyDescriptor) util2.deserializeToDescriptor(jClass, c11689n, jvmNameResolverComponent1, new TypeTable(typeTable), jvmMetadataVersionComponent3, c.f25017j);
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f25009m.invoke().getScope().getContributedVariables(name, LookupLocation3.FROM_REFLECTION);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("file class ");
        sbM833U.append(reflectClassUtil.getClassId(getJClass()).asSingleFqName());
        return sbM833U.toString();
    }
}
