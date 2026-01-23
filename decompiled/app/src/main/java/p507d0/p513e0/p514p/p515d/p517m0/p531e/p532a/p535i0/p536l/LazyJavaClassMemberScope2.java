package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KDeclarationContainer;
import p507d0.p512d0._Ranges;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.suspendFunctionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyGetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassDescriptorBase;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.EnumEntrySyntheticClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyGetterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertySetterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.SimpleFunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ValueParameterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.utils;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.ClassicBuiltinSpecialProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaDescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaIncompatibilityRulesOverridabilityCondition;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAbi;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.DescriptorResolverUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaResolverCache;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.SignaturePropagator;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.TypeUsage;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaForKotlinOverridePropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaMethodDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaPropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.util3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.util4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaAnnotations2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11578k;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11590w;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.signatureEnhancement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.propertiesConventionUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.specialBuiltinMembers;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.specialBuiltinMembers2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.specialBuiltinMembers3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.utils2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.methodSignatureMapping3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage4;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartSet;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p580t.MutableCollections;
import p507d0.p580t._Collections;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaClassMemberScope2 extends LazyJavaScope {

    /* JADX INFO: renamed from: n */
    public final ClassDescriptor f23361n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC11574g f23362o;

    /* JADX INFO: renamed from: p */
    public final boolean f23363p;

    /* JADX INFO: renamed from: q */
    public final storage5<List<ClassConstructorDescriptor>> f23364q;

    /* JADX INFO: renamed from: r */
    public final storage5<Set<Name>> f23365r;

    /* JADX INFO: renamed from: s */
    public final storage5<Map<Name, InterfaceC11581n>> f23366s;

    /* JADX INFO: renamed from: t */
    public final storage4<Name, ClassDescriptorBase> f23367t;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$a */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public /* synthetic */ class a extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public a(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
            super(1, lazyJavaClassMemberScope2);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(LazyJavaClassMemberScope2.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, "p0");
            return LazyJavaClassMemberScope2.access$searchMethodsByNameWithoutBuiltinMagic((LazyJavaClassMemberScope2) this.receiver, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$b */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public /* synthetic */ class b extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public b(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
            super(1, lazyJavaClassMemberScope2);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(LazyJavaClassMemberScope2.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, "p0");
            return LazyJavaClassMemberScope2.access$searchMethodsInSupertypesWithoutBuiltinMagic((LazyJavaClassMemberScope2) this.receiver, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$c */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class c extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, "it");
            return LazyJavaClassMemberScope2.access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope2.this, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$d */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class d extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, "it");
            return LazyJavaClassMemberScope2.access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope2.this, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$e */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class e extends Lambda implements Function0<List<? extends ClassConstructorDescriptor>> {

        /* JADX INFO: renamed from: $c */
        public final /* synthetic */ context4 f23368$c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(context4 context4Var) {
            super(0);
            this.f23368$c = context4Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ClassConstructorDescriptor> invoke() {
            return invoke2();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<? extends ClassConstructorDescriptor> invoke2() {
            Collection<InterfaceC11578k> constructors = LazyJavaClassMemberScope2.access$getJClass$p(LazyJavaClassMemberScope2.this).getConstructors();
            ArrayList arrayList = new ArrayList(constructors.size());
            Iterator<InterfaceC11578k> it = constructors.iterator();
            while (it.hasNext()) {
                arrayList.add(LazyJavaClassMemberScope2.access$resolveConstructor(LazyJavaClassMemberScope2.this, it.next()));
            }
            if (LazyJavaClassMemberScope2.access$getJClass$p(LazyJavaClassMemberScope2.this).isRecord()) {
                ClassConstructorDescriptor classConstructorDescriptorAccess$createDefaultRecordConstructor = LazyJavaClassMemberScope2.access$createDefaultRecordConstructor(LazyJavaClassMemberScope2.this);
                boolean z2 = false;
                String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default(classConstructorDescriptorAccess$createDefaultRecordConstructor, false, false, 2, null);
                if (arrayList.isEmpty()) {
                    z2 = true;
                    if (z2) {
                        arrayList.add(classConstructorDescriptorAccess$createDefaultRecordConstructor);
                        ((JavaResolverCache.a) this.f23368$c.getComponents().getJavaResolverCache()).recordConstructor(LazyJavaClassMemberScope2.access$getJClass$p(LazyJavaClassMemberScope2.this), classConstructorDescriptorAccess$createDefaultRecordConstructor);
                    }
                } else {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics3.areEqual(methodSignatureMapping3.computeJvmDescriptor$default((ClassConstructorDescriptor) it2.next(), false, false, 2, null), strComputeJvmDescriptor$default)) {
                            break;
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
            }
            signatureEnhancement signatureEnhancement = this.f23368$c.getComponents().getSignatureEnhancement();
            context4 context4Var = this.f23368$c;
            LazyJavaClassMemberScope2 lazyJavaClassMemberScope2 = LazyJavaClassMemberScope2.this;
            boolean zIsEmpty = arrayList.isEmpty();
            List listListOfNotNull = arrayList;
            if (zIsEmpty) {
                listListOfNotNull = Collections2.listOfNotNull(LazyJavaClassMemberScope2.access$createDefaultConstructor(lazyJavaClassMemberScope2));
            }
            return _Collections.toList(signatureEnhancement.enhanceSignatures(context4Var, listListOfNotNull));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$f */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class f extends Lambda implements Function0<Map<Name, ? extends InterfaceC11581n>> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Name, ? extends InterfaceC11581n> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Name, ? extends InterfaceC11581n> invoke2() {
            Collection<InterfaceC11581n> fields = LazyJavaClassMemberScope2.access$getJClass$p(LazyJavaClassMemberScope2.this).getFields();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fields) {
                if (((InterfaceC11581n) obj).isEnumEntry()) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((InterfaceC11581n) obj2).getName(), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$g */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class g extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ SimpleFunctionDescriptor $function;
        public final /* synthetic */ LazyJavaClassMemberScope2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
            super(1);
            this.$function = simpleFunctionDescriptor;
            this.this$0 = lazyJavaClassMemberScope2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, "accessorName");
            return Intrinsics3.areEqual(this.$function.getName(), name) ? CollectionsJVM.listOf(this.$function) : _Collections.plus(LazyJavaClassMemberScope2.access$searchMethodsByNameWithoutBuiltinMagic(this.this$0, name), (Iterable) LazyJavaClassMemberScope2.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, name));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$h */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class h extends Lambda implements Function0<Set<? extends Name>> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Name> invoke2() {
            return _Collections.toSet(LazyJavaClassMemberScope2.access$getJClass$p(LazyJavaClassMemberScope2.this).getInnerClassNames());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$i */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class i extends Lambda implements Function1<Name, ClassDescriptorBase> {

        /* JADX INFO: renamed from: $c */
        public final /* synthetic */ context4 f23369$c;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$i$a */
        /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
        public static final class a extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ LazyJavaClassMemberScope2 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
                super(0);
                this.this$0 = lazyJavaClassMemberScope2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends Name> invoke2() {
                return _Sets.plus((Set) this.this$0.getFunctionNames(), (Iterable) this.this$0.getVariableNames());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(context4 context4Var) {
            super(1);
            this.f23369$c = context4Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassDescriptorBase invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ClassDescriptorBase invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            if (!((Set) LazyJavaClassMemberScope2.access$getNestedClassIndex$p(LazyJavaClassMemberScope2.this).invoke()).contains(name)) {
                InterfaceC11581n interfaceC11581n = (InterfaceC11581n) ((Map) LazyJavaClassMemberScope2.access$getEnumEntryIndex$p(LazyJavaClassMemberScope2.this).invoke()).get(name);
                if (interfaceC11581n == null) {
                    return null;
                }
                return EnumEntrySyntheticClassDescriptor.create(this.f23369$c.getStorageManager(), LazyJavaClassMemberScope2.this.f23361n, name, this.f23369$c.getStorageManager().createLazyValue(new a(LazyJavaClassMemberScope2.this)), LazyJavaAnnotations2.resolveAnnotations(this.f23369$c, interfaceC11581n), this.f23369$c.getComponents().getSourceElementFactory().source(interfaceC11581n));
            }
            JavaClassFinder finder = this.f23369$c.getComponents().getFinder();
            ClassId classId = DescriptorUtils2.getClassId(LazyJavaClassMemberScope2.this.f23361n);
            Intrinsics3.checkNotNull(classId);
            ClassId classIdCreateNestedClassId = classId.createNestedClassId(name);
            Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "ownerDescriptor.classId!!.createNestedClassId(name)");
            InterfaceC11574g interfaceC11574gFindClass = finder.findClass(new JavaClassFinder.a(classIdCreateNestedClassId, null, LazyJavaClassMemberScope2.access$getJClass$p(LazyJavaClassMemberScope2.this), 2, null));
            if (interfaceC11574gFindClass == null) {
                return null;
            }
            context4 context4Var = this.f23369$c;
            LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(context4Var, LazyJavaClassMemberScope2.this.f23361n, interfaceC11574gFindClass, null, 8, null);
            context4Var.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
            return lazyJavaClassDescriptor;
        }
    }

    public /* synthetic */ LazyJavaClassMemberScope2(context4 context4Var, ClassDescriptor classDescriptor, InterfaceC11574g interfaceC11574g, boolean z2, LazyJavaClassMemberScope2 lazyJavaClassMemberScope2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, classDescriptor, interfaceC11574g, z2, (i2 & 16) != 0 ? null : lazyJavaClassMemberScope2);
    }

    public static final ClassConstructorDescriptor access$createDefaultConstructor(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        List<ValueParameterDescriptor> listEmptyList;
        Tuples2 tuples2;
        boolean zIsAnnotationType = lazyJavaClassMemberScope2.f23362o.isAnnotationType();
        if ((lazyJavaClassMemberScope2.f23362o.isInterface() || !lazyJavaClassMemberScope2.f23362o.hasDefaultConstructor()) && !zIsAnnotationType) {
            return null;
        }
        ClassDescriptor classDescriptor = lazyJavaClassMemberScope2.f23361n;
        JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations4.f22735f.getEMPTY(), true, lazyJavaClassMemberScope2.f23389c.getComponents().getSourceElementFactory().source(lazyJavaClassMemberScope2.f23362o));
        Intrinsics3.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        if (zIsAnnotationType) {
            Collection<InterfaceC11585r> methods = lazyJavaClassMemberScope2.f23362o.getMethods();
            listEmptyList = new ArrayList<>(methods.size());
            JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, true, null, 2, null);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : methods) {
                if (Intrinsics3.areEqual(((InterfaceC11585r) obj).getName(), JvmAnnotationNames.f23148b)) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            }
            Tuples2 tuples22 = new Tuples2(arrayList, arrayList2);
            List list = (List) tuples22.component1();
            List<InterfaceC11585r> list2 = (List) tuples22.component2();
            list.size();
            InterfaceC11585r interfaceC11585r = (InterfaceC11585r) _Collections.firstOrNull(list);
            if (interfaceC11585r != null) {
                javaTypes5 returnType = interfaceC11585r.getReturnType();
                if (returnType instanceof javaTypes2) {
                    javaTypes2 javatypes2 = (javaTypes2) returnType;
                    tuples2 = new Tuples2(lazyJavaClassMemberScope2.f23389c.getTypeResolver().transformArrayType(javatypes2, attributes$default, true), lazyJavaClassMemberScope2.f23389c.getTypeResolver().transformJavaType(javatypes2.getComponentType(), attributes$default));
                } else {
                    tuples2 = new Tuples2(lazyJavaClassMemberScope2.f23389c.getTypeResolver().transformJavaType(returnType, attributes$default), null);
                }
                lazyJavaClassMemberScope2.m9481o(listEmptyList, javaClassConstructorDescriptorCreateJavaConstructor, 0, interfaceC11585r, (KotlinType) tuples2.component1(), (KotlinType) tuples2.component2());
            }
            int i2 = interfaceC11585r != null ? 1 : 0;
            int i3 = 0;
            for (InterfaceC11585r interfaceC11585r2 : list2) {
                lazyJavaClassMemberScope2.m9481o(listEmptyList, javaClassConstructorDescriptorCreateJavaConstructor, i3 + i2, interfaceC11585r2, lazyJavaClassMemberScope2.f23389c.getTypeResolver().transformJavaType(interfaceC11585r2.getReturnType(), attributes$default), null);
                i3++;
            }
        } else {
            listEmptyList = Collections.emptyList();
        }
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(listEmptyList, lazyJavaClassMemberScope2.m9465B(classDescriptor));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(true);
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(classDescriptor.getDefaultType());
        ((JavaResolverCache.a) lazyJavaClassMemberScope2.f23389c.getComponents().getJavaResolverCache()).recordConstructor(lazyJavaClassMemberScope2.f23362o, javaClassConstructorDescriptorCreateJavaConstructor);
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    public static final ClassConstructorDescriptor access$createDefaultRecordConstructor(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        ClassDescriptor classDescriptor = lazyJavaClassMemberScope2.f23361n;
        JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations4.f22735f.getEMPTY(), true, lazyJavaClassMemberScope2.f23389c.getComponents().getSourceElementFactory().source(lazyJavaClassMemberScope2.f23362o));
        Intrinsics3.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        Collection<InterfaceC11590w> recordComponents = lazyJavaClassMemberScope2.f23362o.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        KotlinType kotlinType = null;
        JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 2, null);
        int i2 = 0;
        for (InterfaceC11590w interfaceC11590w : recordComponents) {
            int i3 = i2 + 1;
            KotlinType kotlinTypeTransformJavaType = lazyJavaClassMemberScope2.f23389c.getTypeResolver().transformJavaType(interfaceC11590w.getType(), attributes$default);
            arrayList.add(new ValueParameterDescriptorImpl(javaClassConstructorDescriptorCreateJavaConstructor, null, i2, Annotations4.f22735f.getEMPTY(), interfaceC11590w.getName(), kotlinTypeTransformJavaType, false, false, false, interfaceC11590w.isVararg() ? lazyJavaClassMemberScope2.f23389c.getComponents().getModule().getBuiltIns().getArrayElementType(kotlinTypeTransformJavaType) : kotlinType, lazyJavaClassMemberScope2.f23389c.getComponents().getSourceElementFactory().source(interfaceC11590w)));
            i2 = i3;
            attributes$default = attributes$default;
            kotlinType = kotlinType;
        }
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(arrayList, lazyJavaClassMemberScope2.m9465B(classDescriptor));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(classDescriptor.getDefaultType());
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    public static final /* synthetic */ storage5 access$getEnumEntryIndex$p(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        return lazyJavaClassMemberScope2.f23366s;
    }

    public static final /* synthetic */ InterfaceC11574g access$getJClass$p(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        return lazyJavaClassMemberScope2.f23362o;
    }

    public static final /* synthetic */ storage5 access$getNestedClassIndex$p(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        return lazyJavaClassMemberScope2.f23365r;
    }

    public static final JavaClassConstructorDescriptor access$resolveConstructor(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2, InterfaceC11578k interfaceC11578k) {
        ClassDescriptor classDescriptor = lazyJavaClassMemberScope2.f23361n;
        JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, LazyJavaAnnotations2.resolveAnnotations(lazyJavaClassMemberScope2.f23389c, interfaceC11578k), false, lazyJavaClassMemberScope2.f23389c.getComponents().getSourceElementFactory().source(interfaceC11578k));
        Intrinsics3.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor,\n            c.resolveAnnotations(constructor), /* isPrimary = */\n            false,\n            c.components.sourceElementFactory.source(constructor)\n        )");
        context4 context4VarChildForMethod = context.childForMethod(lazyJavaClassMemberScope2.f23389c, javaClassConstructorDescriptorCreateJavaConstructor, interfaceC11578k, classDescriptor.getDeclaredTypeParameters().size());
        LazyJavaScope.b bVarM9496n = lazyJavaClassMemberScope2.m9496n(context4VarChildForMethod, javaClassConstructorDescriptorCreateJavaConstructor, interfaceC11578k.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
        List<InterfaceC11592y> typeParameters = interfaceC11578k.getTypeParameters();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = context4VarChildForMethod.getTypeParameterResolver().resolveTypeParameter((InterfaceC11592y) it.next());
            Intrinsics3.checkNotNull(typeParameterDescriptorResolveTypeParameter);
            arrayList.add(typeParameterDescriptorResolveTypeParameter);
        }
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(bVarM9496n.getDescriptors(), utils2.toDescriptorVisibility(interfaceC11578k.getVisibility()), _Collections.plus((Collection) declaredTypeParameters, (Iterable) arrayList));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(bVarM9496n.getHasSynthesizedNames());
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(classDescriptor.getDefaultType());
        ((JavaResolverCache.a) context4VarChildForMethod.getComponents().getJavaResolverCache()).recordConstructor(interfaceC11578k, javaClassConstructorDescriptorCreateJavaConstructor);
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    public static final Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2, Name name) {
        Collection<InterfaceC11585r> collectionFindMethodsByName = lazyJavaClassMemberScope2.f23392f.invoke().findMethodsByName(name);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionFindMethodsByName, 10));
        Iterator<T> it = collectionFindMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(lazyJavaClassMemberScope2.m9495m((InterfaceC11585r) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2, Name name) {
        boolean z2;
        Set<SimpleFunctionDescriptor> setM9466C = lazyJavaClassMemberScope2.m9466C(name);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setM9466C) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
            if (!specialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(simpleFunctionDescriptor)) {
                specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.f23259m;
                z2 = specialBuiltinMembers3.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) != null;
            }
            if (!z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: A */
    public final SimpleFunctionDescriptor m9464A(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        KotlinType returnType;
        JvmAbi jvmAbi = JvmAbi.f23531a;
        String strAsString = propertyDescriptor.getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        Name nameIdentifier = Name.identifier(JvmAbi.setterName(strAsString));
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = function1.invoke(nameIdentifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && KotlinBuiltIns.isUnit(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.f24806a;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) _Collections.single((List) valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    /* JADX INFO: renamed from: B */
    public final DescriptorVisibility2 m9465B(ClassDescriptor classDescriptor) {
        DescriptorVisibility2 visibility = classDescriptor.getVisibility();
        Intrinsics3.checkNotNullExpressionValue(visibility, "classDescriptor.visibility");
        if (!Intrinsics3.areEqual(visibility, JavaDescriptorVisibilities.f23526b)) {
            return visibility;
        }
        DescriptorVisibility2 descriptorVisibility2 = JavaDescriptorVisibilities.f23527c;
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "PROTECTED_AND_PACKAGE");
        return descriptorVisibility2;
    }

    /* JADX INFO: renamed from: C */
    public final Set<SimpleFunctionDescriptor> m9466C(Name name) {
        Collection<KotlinType> collectionM9485s = m9485s();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = collectionM9485s.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getContributedFunctions(name, LookupLocation3.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: D */
    public final Set<PropertyDescriptor> m9467D(Name name) {
        Collection<KotlinType> collectionM9485s = m9485s();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionM9485s.iterator();
        while (it.hasNext()) {
            Collection<? extends PropertyDescriptor> contributedVariables = ((KotlinType) it.next()).getMemberScope().getContributedVariables(name, LookupLocation3.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(contributedVariables, 10));
            Iterator<T> it2 = contributedVariables.iterator();
            while (it2.hasNext()) {
                arrayList2.add((PropertyDescriptor) it2.next());
            }
            MutableCollections.addAll(arrayList, arrayList2);
        }
        return _Collections.toSet(arrayList);
    }

    /* JADX INFO: renamed from: E */
    public final boolean m9468E(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2, null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics3.checkNotNullExpressionValue(original, "builtinWithErasedParameters.original");
        return Intrinsics3.areEqual(strComputeJvmDescriptor$default, methodSignatureMapping3.computeJvmDescriptor$default(original, false, false, 2, null)) && !m9489w(simpleFunctionDescriptor, functionDescriptor);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x010d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[LOOP:3: B:40:0x009e->B:124:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[LOOP:6: B:8:0x001e->B:137:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[LOOP:7: B:16:0x003d->B:142:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0170  */
    /* JADX INFO: renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m9469F(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "function.name");
        List<Name> propertyNamesCandidatesByAccessorName = propertiesConventionUtil.getPropertyNamesCandidatesByAccessorName(name);
        if ((propertyNamesCandidatesByAccessorName instanceof Collection) && propertyNamesCandidatesByAccessorName.isEmpty()) {
            z4 = false;
        } else {
            Iterator<T> it = propertyNamesCandidatesByAccessorName.iterator();
            while (it.hasNext()) {
                Set<PropertyDescriptor> setM9467D = m9467D((Name) it.next());
                if (!(setM9467D instanceof Collection) || !setM9467D.isEmpty()) {
                    for (PropertyDescriptor propertyDescriptor : setM9467D) {
                        if (!m9488v(propertyDescriptor, new g(simpleFunctionDescriptor, this))) {
                            z2 = false;
                            if (z2) {
                                z3 = true;
                                break;
                            }
                        } else {
                            if (!propertyDescriptor.isVar()) {
                                JvmAbi jvmAbi = JvmAbi.f23531a;
                                String strAsString = simpleFunctionDescriptor.getName().asString();
                                Intrinsics3.checkNotNullExpressionValue(strAsString, "function.name.asString()");
                                if (!JvmAbi.isSetterName(strAsString)) {
                                }
                                if (z2) {
                                }
                            }
                            z2 = true;
                            if (z2) {
                            }
                        }
                    }
                    z3 = false;
                    if (!z3) {
                        z4 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    if (!z3) {
                    }
                }
            }
            z4 = false;
        }
        if (z4) {
            return false;
        }
        specialBuiltinMembers2 specialbuiltinmembers2 = specialBuiltinMembers2.f23218m;
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<Name> builtinFunctionNamesByJvmName = specialbuiltinmembers2.getBuiltinFunctionNamesByJvmName(name2);
        if ((builtinFunctionNamesByJvmName instanceof Collection) && builtinFunctionNamesByJvmName.isEmpty()) {
            z6 = false;
        } else {
            for (Name name3 : builtinFunctionNamesByJvmName) {
                Set<SimpleFunctionDescriptor> setM9466C = m9466C(name3);
                ArrayList arrayList = new ArrayList();
                for (Object obj : setM9466C) {
                    if (specialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    z5 = false;
                    if (!z5) {
                        z6 = true;
                        break;
                    }
                } else {
                    FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
                    aVarNewCopyBuilder.setName(name3);
                    aVarNewCopyBuilder.setSignatureChange();
                    aVarNewCopyBuilder.setPreserveSourceElement();
                    FunctionDescriptor functionDescriptor = (SimpleFunctionDescriptor) aVarNewCopyBuilder.build();
                    Intrinsics3.checkNotNull(functionDescriptor);
                    if (!arrayList.isEmpty()) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            if (m9490x((SimpleFunctionDescriptor) it2.next(), functionDescriptor)) {
                                z5 = true;
                                break;
                            }
                        }
                        z5 = false;
                        if (!z5) {
                        }
                    }
                }
            }
            z6 = false;
        }
        if (!z6) {
            specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.f23259m;
            Name name4 = simpleFunctionDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name4, ModelAuditLogEntry.CHANGE_KEY_NAME);
            if (specialbuiltinmembers3.getSameAsBuiltinMethodWithErasedValueParameters(name4)) {
                Name name5 = simpleFunctionDescriptor.getName();
                Intrinsics3.checkNotNullExpressionValue(name5, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Set<SimpleFunctionDescriptor> setM9466C2 = m9466C(name5);
                ArrayList arrayList2 = new ArrayList();
                for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : setM9466C2) {
                    specialBuiltinMembers3 specialbuiltinmembers32 = specialBuiltinMembers3.f23259m;
                    FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = specialBuiltinMembers3.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor2);
                    if (overriddenBuiltinFunctionWithErasedValueParametersInJava != null) {
                        arrayList2.add(overriddenBuiltinFunctionWithErasedValueParametersInJava);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        if (m9468E(simpleFunctionDescriptor, (FunctionDescriptor) it3.next())) {
                            z7 = true;
                            break;
                        }
                    }
                    z7 = false;
                    if (!z7) {
                    }
                }
            } else {
                z7 = false;
                if (!z7) {
                    SimpleFunctionDescriptor simpleFunctionDescriptorM9487u = m9487u(simpleFunctionDescriptor);
                    if (simpleFunctionDescriptorM9487u == null) {
                        z8 = false;
                        if (z8) {
                            return true;
                        }
                    } else {
                        Name name6 = simpleFunctionDescriptor.getName();
                        Intrinsics3.checkNotNullExpressionValue(name6, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        Set<SimpleFunctionDescriptor> setM9466C3 = m9466C(name6);
                        if (!setM9466C3.isEmpty()) {
                            for (SimpleFunctionDescriptor simpleFunctionDescriptor3 : setM9466C3) {
                                if (simpleFunctionDescriptor3.isSuspend() && m9489w(simpleFunctionDescriptorM9487u, simpleFunctionDescriptor3)) {
                                    z8 = true;
                                    break;
                                }
                            }
                            z8 = false;
                            if (z8) {
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: a */
    public Set<Name> mo9470a(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        return _Sets.plus((Set) this.f23365r.invoke(), (Iterable) this.f23366s.invoke().keySet());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: b */
    public Set mo9471b(MemberScope2 memberScope2, Function1 function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Collection<KotlinType> supertypes = this.f23361n.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(this.f23392f.invoke().getMethodNames());
        linkedHashSet.addAll(this.f23392f.invoke().getRecordComponentNames());
        linkedHashSet.addAll(mo9470a(memberScope2, function1));
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: c */
    public void mo9472c(Collection<SimpleFunctionDescriptor> collection, Name name) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!this.f23362o.isRecord() || this.f23392f.invoke().findRecordComponentByName(name) == null) {
            return;
        }
        if (collection.isEmpty()) {
            z2 = true;
        } else {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        if (z2) {
            InterfaceC11590w interfaceC11590wFindRecordComponentByName = this.f23392f.invoke().findRecordComponentByName(name);
            Intrinsics3.checkNotNull(interfaceC11590wFindRecordComponentByName);
            JavaMethodDescriptor javaMethodDescriptorCreateJavaMethod = JavaMethodDescriptor.createJavaMethod(this.f23361n, LazyJavaAnnotations2.resolveAnnotations(this.f23389c, interfaceC11590wFindRecordComponentByName), interfaceC11590wFindRecordComponentByName.getName(), this.f23389c.getComponents().getSourceElementFactory().source(interfaceC11590wFindRecordComponentByName), true);
            Intrinsics3.checkNotNullExpressionValue(javaMethodDescriptorCreateJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, recordComponent.name, c.components.sourceElementFactory.source(recordComponent), true\n        )");
            javaMethodDescriptorCreateJavaMethod.initialize(null, mo9477i(), Collections2.emptyList(), Collections2.emptyList(), this.f23389c.getTypeResolver().transformJavaType(interfaceC11590wFindRecordComponentByName.getType(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 2, null)), Modality.f23104j.convertFromFlags(false, false, true), DescriptorVisibilities.f23087e, null);
            javaMethodDescriptorCreateJavaMethod.setParameterNamesStatus(false, false);
            ((JavaResolverCache.a) this.f23389c.getComponents().getJavaResolverCache()).recordMethod(interfaceC11590wFindRecordComponentByName, javaMethodDescriptorCreateJavaMethod);
            collection.add(javaMethodDescriptorCreateJavaMethod);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: d */
    public DeclaredMemberIndex2 mo9473d() {
        return new DeclaredMemberIndex(this.f23362o, LazyJavaClassMemberScope.f23360j);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo9474f(Collection<SimpleFunctionDescriptor> collection, Name name) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Set<SimpleFunctionDescriptor> setM9466C = m9466C(name);
        if (!specialBuiltinMembers2.f23218m.getSameAsRenamedInJvmBuiltin(name) && !specialBuiltinMembers3.f23259m.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            if (setM9466C.isEmpty()) {
                z2 = true;
                if (z2) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : setM9466C) {
                        if (m9469F((SimpleFunctionDescriptor) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    m9482p(collection, name, arrayList, false);
                    return;
                }
            } else {
                Iterator<T> it = setM9466C.iterator();
                while (it.hasNext()) {
                    if (((FunctionDescriptor) it.next()).isSuspend()) {
                        z2 = false;
                        break;
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
        }
        Collection<SimpleFunctionDescriptor> collectionCreate = SmartSet.f25003j.create();
        Collection<? extends SimpleFunctionDescriptor> collectionResolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, setM9466C, Collections2.emptyList(), this.f23361n, ErrorReporter.f24676a, this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, emptyList(), ownerDescriptor, ErrorReporter.DO_NOTHING,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        m9483q(name, collection, collectionResolveOverridesForNonStaticMembers, collection, new a(this));
        m9483q(name, collection, collectionResolveOverridesForNonStaticMembers, collectionCreate, new b(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setM9466C) {
            if (m9469F((SimpleFunctionDescriptor) obj2)) {
                arrayList2.add(obj2);
            }
        }
        m9482p(collection, name, _Collections.plus((Collection) arrayList2, (Iterable) collectionCreate), true);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: g */
    public void mo9475g(Name name, Collection<PropertyDescriptor> collection) {
        InterfaceC11585r interfaceC11585r;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(collection, "result");
        if (this.f23362o.isAnnotationType() && (interfaceC11585r = (InterfaceC11585r) _Collections.singleOrNull(this.f23392f.invoke().findMethodsByName(name))) != null) {
            JavaPropertyDescriptor javaPropertyDescriptorCreate = JavaPropertyDescriptor.create(this.f23361n, LazyJavaAnnotations2.resolveAnnotations(this.f23389c, interfaceC11585r), Modality.FINAL, utils2.toDescriptorVisibility(interfaceC11585r.getVisibility()), false, interfaceC11585r.getName(), this.f23389c.getComponents().getSourceElementFactory().source(interfaceC11585r), false);
            Intrinsics3.checkNotNullExpressionValue(javaPropertyDescriptorCreate, "create(\n            ownerDescriptor, annotations, modality, method.visibility.toDescriptorVisibility(),\n            /* isVar = */ false, method.name, c.components.sourceElementFactory.source(method),\n            /* isStaticFinal = */ false\n        )");
            PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateDefaultGetter = DescriptorFactory.createDefaultGetter(javaPropertyDescriptorCreate, Annotations4.f22735f.getEMPTY());
            Intrinsics3.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateDefaultGetter, "createDefaultGetter(propertyDescriptor, Annotations.EMPTY)");
            javaPropertyDescriptorCreate.initialize(propertyGetterDescriptorImplCreateDefaultGetter, null);
            KotlinType kotlinTypeM9494e = m9494e(interfaceC11585r, context.childForMethod$default(this.f23389c, javaPropertyDescriptorCreate, interfaceC11585r, 0, 4, null));
            javaPropertyDescriptorCreate.setType(kotlinTypeM9494e, Collections2.emptyList(), mo9477i(), null);
            propertyGetterDescriptorImplCreateDefaultGetter.initialize(kotlinTypeM9494e);
            collection.add(javaPropertyDescriptorCreate);
        }
        Set<PropertyDescriptor> setM9467D = m9467D(name);
        if (setM9467D.isEmpty()) {
            return;
        }
        SmartSet.b bVar = SmartSet.f25003j;
        SmartSet smartSetCreate = bVar.create();
        SmartSet smartSetCreate2 = bVar.create();
        m9484r(setM9467D, collection, smartSetCreate, new c());
        m9484r(_Sets.minus((Set) setM9467D, (Iterable) smartSetCreate), smartSetCreate2, null, new d());
        Collection<? extends PropertyDescriptor> collectionResolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, _Sets.plus((Set) setM9467D, (Iterable) smartSetCreate2), collection, this.f23361n, this.f23389c.getComponents().getErrorReporter(), this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n                name,\n                propertiesFromSupertypes + propertiesOverridesFromSuperTypes,\n                result,\n                ownerDescriptor,\n                c.components.errorReporter,\n                c.components.kotlinTypeChecker.overridingUtil\n            )");
        collection.addAll(collectionResolveOverridesForNonStaticMembers);
    }

    public final storage5<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.f23364q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        storage4<Name, ClassDescriptorBase> storage4Var;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        LazyJavaClassMemberScope2 lazyJavaClassMemberScope2 = (LazyJavaClassMemberScope2) this.f23390d;
        ClassDescriptorBase classDescriptorBaseInvoke = null;
        if (lazyJavaClassMemberScope2 != null && (storage4Var = lazyJavaClassMemberScope2.f23367t) != null) {
            classDescriptorBaseInvoke = storage4Var.invoke(name);
        }
        return classDescriptorBaseInvoke == null ? this.f23367t.invoke(name) : classDescriptorBaseInvoke;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        return super.getContributedFunctions(name, lookupLocation2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        return super.getContributedVariables(name, lookupLocation2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: h */
    public Set<Name> mo9476h(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        if (this.f23362o.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f23392f.invoke().getFieldNames());
        Collection<KotlinType> supertypes = this.f23361n.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: i */
    public ReceiverParameterDescriptor mo9477i() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(this.f23361n);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: j */
    public DeclarationDescriptor mo9478j() {
        return this.f23361n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: k */
    public boolean mo9479k(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics3.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.f23362o.isAnnotationType()) {
            return false;
        }
        return m9469F(javaMethodDescriptor);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* JADX INFO: renamed from: l */
    public LazyJavaScope.a mo9480l(InterfaceC11585r interfaceC11585r, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics3.checkNotNullParameter(interfaceC11585r, "method");
        Intrinsics3.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics3.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics3.checkNotNullParameter(list2, "valueParameters");
        SignaturePropagator.b bVarResolvePropagatedSignature = ((SignaturePropagator.a) this.f23389c.getComponents().getSignaturePropagator()).resolvePropagatedSignature(interfaceC11585r, this.f23361n, kotlinType, null, list2, list);
        Intrinsics3.checkNotNullExpressionValue(bVarResolvePropagatedSignature, "c.components.signaturePropagator.resolvePropagatedSignature(\n            method, ownerDescriptor, returnType, null, valueParameters, methodTypeParameters\n        )");
        KotlinType returnType = bVarResolvePropagatedSignature.getReturnType();
        Intrinsics3.checkNotNullExpressionValue(returnType, "propagated.returnType");
        KotlinType receiverType = bVarResolvePropagatedSignature.getReceiverType();
        List<ValueParameterDescriptor> valueParameters = bVarResolvePropagatedSignature.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "propagated.valueParameters");
        List<TypeParameterDescriptor> typeParameters = bVarResolvePropagatedSignature.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "propagated.typeParameters");
        boolean zHasStableParameterNames = bVarResolvePropagatedSignature.hasStableParameterNames();
        List<String> errors = bVarResolvePropagatedSignature.getErrors();
        Intrinsics3.checkNotNullExpressionValue(errors, "propagated.errors");
        return new LazyJavaScope.a(returnType, receiverType, valueParameters, typeParameters, zHasStableParameterNames, errors);
    }

    /* JADX INFO: renamed from: o */
    public final void m9481o(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i2, InterfaceC11585r interfaceC11585r, KotlinType kotlinType, KotlinType kotlinType2) {
        Annotations4 empty = Annotations4.f22735f.getEMPTY();
        Name name = interfaceC11585r.getName();
        KotlinType kotlinTypeMakeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics3.checkNotNullExpressionValue(kotlinTypeMakeNotNullable, "makeNotNullable(returnType)");
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, null, i2, empty, name, kotlinTypeMakeNotNullable, interfaceC11585r.getHasAnnotationParameterDefaultValue(), false, false, kotlinType2 == null ? null : TypeUtils.makeNotNullable(kotlinType2), this.f23389c.getComponents().getSourceElementFactory().source(interfaceC11585r)));
    }

    /* JADX INFO: renamed from: p */
    public final void m9482p(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z2) {
        Collection<? extends SimpleFunctionDescriptor> collectionResolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, this.f23361n, this.f23389c.getComponents().getErrorReporter(), this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, result, ownerDescriptor, c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        if (!z2) {
            collection.addAll(collectionResolveOverridesForNonStaticMembers);
            return;
        }
        List listPlus = _Collections.plus((Collection) collection, (Iterable) collectionResolveOverridesForNonStaticMembers);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionResolveOverridesForNonStaticMembers, 10));
        for (SimpleFunctionDescriptor simpleFunctionDescriptorM9486t : collectionResolveOverridesForNonStaticMembers) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) specialBuiltinMembers.getOverriddenSpecialBuiltin(simpleFunctionDescriptorM9486t);
            if (simpleFunctionDescriptor == null) {
                Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorM9486t, "resolvedOverride");
            } else {
                Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorM9486t, "resolvedOverride");
                simpleFunctionDescriptorM9486t = m9486t(simpleFunctionDescriptorM9486t, simpleFunctionDescriptor, listPlus);
            }
            arrayList.add(simpleFunctionDescriptorM9486t);
        }
        collection.addAll(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x010f  */
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m9483q(Name name, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptorM9486t;
        SimpleFunctionDescriptor simpleFunctionDescriptorM9486t2;
        SimpleFunctionDescriptor simpleFunctionDescriptorM9487u;
        Object next;
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : collection2) {
            SimpleFunctionDescriptor simpleFunctionDescriptor3 = (SimpleFunctionDescriptor) specialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(simpleFunctionDescriptor2);
            if (simpleFunctionDescriptor3 == null) {
                simpleFunctionDescriptorM9486t = null;
            } else {
                String jvmMethodNameIfSpecial = specialBuiltinMembers.getJvmMethodNameIfSpecial(simpleFunctionDescriptor3);
                Intrinsics3.checkNotNull(jvmMethodNameIfSpecial);
                Name nameIdentifier = Name.identifier(jvmMethodNameIfSpecial);
                Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(nameInJava)");
                Iterator<? extends SimpleFunctionDescriptor> it = function1.invoke(nameIdentifier).iterator();
                while (it.hasNext()) {
                    FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder = it.next().newCopyBuilder();
                    aVarNewCopyBuilder.setName(name);
                    aVarNewCopyBuilder.setSignatureChange();
                    aVarNewCopyBuilder.setPreserveSourceElement();
                    SimpleFunctionDescriptor simpleFunctionDescriptor4 = (SimpleFunctionDescriptor) aVarNewCopyBuilder.build();
                    Intrinsics3.checkNotNull(simpleFunctionDescriptor4);
                    if (m9490x(simpleFunctionDescriptor3, simpleFunctionDescriptor4)) {
                        simpleFunctionDescriptorM9486t = m9486t(simpleFunctionDescriptor4, simpleFunctionDescriptor3, collection);
                        break;
                    }
                }
                simpleFunctionDescriptorM9486t = null;
            }
            collections.addIfNotNull(collection3, simpleFunctionDescriptorM9486t);
            specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.f23259m;
            FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = specialBuiltinMembers3.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor2);
            if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null) {
                simpleFunctionDescriptorM9486t2 = null;
            } else {
                Name name2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "overridden.name");
                Iterator<T> it2 = function1.invoke(name2).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (m9468E((SimpleFunctionDescriptor) next, overriddenBuiltinFunctionWithErasedValueParametersInJava)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                SimpleFunctionDescriptor simpleFunctionDescriptor5 = (SimpleFunctionDescriptor) next;
                if (simpleFunctionDescriptor5 == null) {
                    simpleFunctionDescriptor = null;
                } else {
                    FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder2 = simpleFunctionDescriptor5.newCopyBuilder();
                    List<ValueParameterDescriptor> valueParameters = overriddenBuiltinFunctionWithErasedValueParametersInJava.getValueParameters();
                    Intrinsics3.checkNotNullExpressionValue(valueParameters, "overridden.valueParameters");
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameters, 10));
                    for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                        KotlinType type = valueParameterDescriptor.getType();
                        Intrinsics3.checkNotNullExpressionValue(type, "it.type");
                        arrayList.add(new util4(type, valueParameterDescriptor.declaresDefaultValue()));
                    }
                    List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor5.getValueParameters();
                    Intrinsics3.checkNotNullExpressionValue(valueParameters2, "override.valueParameters");
                    aVarNewCopyBuilder2.setValueParameters(util3.copyValueParameters(arrayList, valueParameters2, overriddenBuiltinFunctionWithErasedValueParametersInJava));
                    aVarNewCopyBuilder2.setSignatureChange();
                    aVarNewCopyBuilder2.setPreserveSourceElement();
                    simpleFunctionDescriptor = (SimpleFunctionDescriptor) aVarNewCopyBuilder2.build();
                }
                if (simpleFunctionDescriptor != null) {
                    if (!m9469F(simpleFunctionDescriptor)) {
                        simpleFunctionDescriptor = null;
                    }
                    if (simpleFunctionDescriptor != null) {
                        simpleFunctionDescriptorM9486t2 = m9486t(simpleFunctionDescriptor, overriddenBuiltinFunctionWithErasedValueParametersInJava, collection);
                    }
                }
            }
            collections.addIfNotNull(collection3, simpleFunctionDescriptorM9486t2);
            if (simpleFunctionDescriptor2.isSuspend()) {
                Name name3 = simpleFunctionDescriptor2.getName();
                Intrinsics3.checkNotNullExpressionValue(name3, "descriptor.name");
                Iterator<T> it3 = function1.invoke(name3).iterator();
                while (it3.hasNext()) {
                    simpleFunctionDescriptorM9487u = m9487u((SimpleFunctionDescriptor) it3.next());
                    if (simpleFunctionDescriptorM9487u == null || !m9489w(simpleFunctionDescriptorM9487u, simpleFunctionDescriptor2)) {
                        simpleFunctionDescriptorM9487u = null;
                    }
                    if (simpleFunctionDescriptorM9487u != null) {
                        break;
                    }
                }
                simpleFunctionDescriptorM9487u = null;
            } else {
                simpleFunctionDescriptorM9487u = null;
            }
            collections.addIfNotNull(collection3, simpleFunctionDescriptorM9487u);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: r */
    public final void m9484r(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptorM9464A;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        for (PropertyDescriptor propertyDescriptor : set) {
            JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor = null;
            PropertySetterDescriptor propertySetterDescriptor = null;
            if (m9488v(propertyDescriptor, function1)) {
                SimpleFunctionDescriptor simpleFunctionDescriptorM9492z = m9492z(propertyDescriptor, function1);
                Intrinsics3.checkNotNull(simpleFunctionDescriptorM9492z);
                if (propertyDescriptor.isVar()) {
                    simpleFunctionDescriptorM9464A = m9464A(propertyDescriptor, function1);
                    Intrinsics3.checkNotNull(simpleFunctionDescriptorM9464A);
                } else {
                    simpleFunctionDescriptorM9464A = null;
                }
                if (simpleFunctionDescriptorM9464A != null) {
                    simpleFunctionDescriptorM9464A.getModality();
                    simpleFunctionDescriptorM9492z.getModality();
                }
                JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor2 = new JavaForKotlinOverridePropertyDescriptor(this.f23361n, simpleFunctionDescriptorM9492z, simpleFunctionDescriptorM9464A, propertyDescriptor);
                KotlinType returnType = simpleFunctionDescriptorM9492z.getReturnType();
                Intrinsics3.checkNotNull(returnType);
                javaForKotlinOverridePropertyDescriptor2.setType(returnType, Collections2.emptyList(), mo9477i(), null);
                PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateGetter = DescriptorFactory.createGetter(javaForKotlinOverridePropertyDescriptor2, simpleFunctionDescriptorM9492z.getAnnotations(), false, false, false, simpleFunctionDescriptorM9492z.getSource());
                propertyGetterDescriptorImplCreateGetter.setInitialSignatureDescriptor(simpleFunctionDescriptorM9492z);
                propertyGetterDescriptorImplCreateGetter.initialize(javaForKotlinOverridePropertyDescriptor2.getType());
                Intrinsics3.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateGetter, "createGetter(\n            propertyDescriptor, getterMethod.annotations, /* isDefault = */false,\n            /* isExternal = */ false, /* isInline = */ false, getterMethod.source\n        ).apply {\n            initialSignatureDescriptor = getterMethod\n            initialize(propertyDescriptor.type)\n        }");
                if (simpleFunctionDescriptorM9464A != null) {
                    List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptorM9464A.getValueParameters();
                    Intrinsics3.checkNotNullExpressionValue(valueParameters, "setterMethod.valueParameters");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) _Collections.firstOrNull((List) valueParameters);
                    if (valueParameterDescriptor == null) {
                        throw new AssertionError(Intrinsics3.stringPlus("No parameter found for ", simpleFunctionDescriptorM9464A));
                    }
                    PropertySetterDescriptorImpl propertySetterDescriptorImplCreateSetter = DescriptorFactory.createSetter(javaForKotlinOverridePropertyDescriptor2, simpleFunctionDescriptorM9464A.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptorM9464A.getVisibility(), simpleFunctionDescriptorM9464A.getSource());
                    propertySetterDescriptorImplCreateSetter.setInitialSignatureDescriptor(simpleFunctionDescriptorM9464A);
                    propertySetterDescriptor = propertySetterDescriptorImplCreateSetter;
                    propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateGetter;
                } else {
                    propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateGetter;
                }
                javaForKotlinOverridePropertyDescriptor2.initialize(propertyGetterDescriptorImpl, propertySetterDescriptor);
                javaForKotlinOverridePropertyDescriptor = javaForKotlinOverridePropertyDescriptor2;
            }
            if (javaForKotlinOverridePropertyDescriptor != null) {
                collection.add(javaForKotlinOverridePropertyDescriptor);
                if (set2 == null) {
                    return;
                }
                ((SmartSet) set2).add(propertyDescriptor);
                return;
            }
        }
    }

    public void recordLookup(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        utils.record(this.f23389c.getComponents().getLookupTracker(), lookupLocation2, this.f23361n, name);
    }

    /* JADX INFO: renamed from: s */
    public final Collection<KotlinType> m9485s() {
        if (!this.f23363p) {
            return this.f23389c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(this.f23361n);
        }
        Collection<KotlinType> supertypes = this.f23361n.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        return supertypes;
    }

    /* JADX INFO: renamed from: t */
    public final SimpleFunctionDescriptor m9486t(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        boolean z2 = true;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
                if (!Intrinsics3.areEqual(simpleFunctionDescriptor, simpleFunctionDescriptor2) && simpleFunctionDescriptor2.getInitialSignatureDescriptor() == null && m9489w(simpleFunctionDescriptor2, callableDescriptor)) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return simpleFunctionDescriptor;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor3 = (SimpleFunctionDescriptor) simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics3.checkNotNull(simpleFunctionDescriptor3);
        return simpleFunctionDescriptor3;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    public String toString() {
        return Intrinsics3.stringPlus("Lazy Java member scope for ", this.f23362o.getFqName());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0012  */
    /* JADX INFO: renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SimpleFunctionDescriptor m9487u(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "valueParameters");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) _Collections.lastOrNull((List) valueParameters);
        if (valueParameterDescriptor != null) {
            ClassifierDescriptor declarationDescriptor = valueParameterDescriptor.getType().getConstructor().getDeclarationDescriptor();
            FqNameUnsafe fqNameUnsafe = declarationDescriptor == null ? null : DescriptorUtils2.getFqNameUnsafe(declarationDescriptor);
            if (fqNameUnsafe != null) {
                if (!fqNameUnsafe.isSafe()) {
                    fqNameUnsafe = null;
                }
                FqName safe = fqNameUnsafe == null ? null : fqNameUnsafe.toSafe();
                if (!suspendFunctionTypes.isContinuation(safe, this.f23389c.getComponents().getSettings().isReleaseCoroutines())) {
                    valueParameterDescriptor = null;
                }
            }
        }
        if (valueParameterDescriptor == null) {
            return null;
        }
        FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters2, "valueParameters");
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) aVarNewCopyBuilder.setValueParameters(_Collections.dropLast(valueParameters2, 1)).setReturnType(valueParameterDescriptor.getType().getArguments().get(0).getType()).build();
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = (SimpleFunctionDescriptorImpl) simpleFunctionDescriptor2;
        if (simpleFunctionDescriptorImpl != null) {
            simpleFunctionDescriptorImpl.setSuspend(true);
        }
        return simpleFunctionDescriptor2;
    }

    /* JADX INFO: renamed from: v */
    public final boolean m9488v(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtil.isJavaField(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptorM9492z = m9492z(propertyDescriptor, function1);
        SimpleFunctionDescriptor simpleFunctionDescriptorM9464A = m9464A(propertyDescriptor, function1);
        if (simpleFunctionDescriptorM9492z == null) {
            return false;
        }
        if (propertyDescriptor.isVar()) {
            return simpleFunctionDescriptorM9464A != null && simpleFunctionDescriptorM9464A.getModality() == simpleFunctionDescriptorM9492z.getModality();
        }
        return true;
    }

    /* JADX INFO: renamed from: w */
    public final boolean m9489w(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.d.a result = OverridingUtil.f24411b.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        Intrinsics3.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, this, true).result");
        return result == OverridingUtil.d.a.OVERRIDABLE && !JavaIncompatibilityRulesOverridabilityCondition.f23529a.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor);
    }

    /* JADX INFO: renamed from: x */
    public final boolean m9490x(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (specialBuiltinMembers2.f23218m.isRemoveAtByIndex(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        Intrinsics3.checkNotNullExpressionValue(functionDescriptor, "if (superDescriptor.isRemoveAtByIndex) subDescriptor.original else subDescriptor");
        return m9489w(functionDescriptor, simpleFunctionDescriptor);
    }

    /* JADX INFO: renamed from: y */
    public final SimpleFunctionDescriptor m9491y(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Name nameIdentifier = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(getterName)");
        Iterator<T> it = function1.invoke(nameIdentifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.f24806a;
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    /* JADX INFO: renamed from: z */
    public final SimpleFunctionDescriptor m9492z(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertyGetterDescriptor propertyGetterDescriptor = getter == null ? null : (PropertyGetterDescriptor) specialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter);
        String builtinSpecialPropertyGetterName = propertyGetterDescriptor != null ? ClassicBuiltinSpecialProperties.f23436a.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor) : null;
        if (builtinSpecialPropertyGetterName != null && !specialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(this.f23361n, propertyGetterDescriptor)) {
            return m9491y(propertyDescriptor, builtinSpecialPropertyGetterName, function1);
        }
        JvmAbi jvmAbi = JvmAbi.f23531a;
        String strAsString = propertyDescriptor.getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        return m9491y(propertyDescriptor, JvmAbi.getterName(strAsString), function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope2(context4 context4Var, ClassDescriptor classDescriptor, InterfaceC11574g interfaceC11574g, boolean z2, LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        super(context4Var, lazyJavaClassMemberScope2);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(classDescriptor, "ownerDescriptor");
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "jClass");
        this.f23361n = classDescriptor;
        this.f23362o = interfaceC11574g;
        this.f23363p = z2;
        this.f23364q = context4Var.getStorageManager().createLazyValue(new e(context4Var));
        this.f23365r = context4Var.getStorageManager().createLazyValue(new h());
        this.f23366s = context4Var.getStorageManager().createLazyValue(new f());
        this.f23367t = context4Var.getStorageManager().createMemoizedFunctionWithNullableValues(new i(context4Var));
    }
}
