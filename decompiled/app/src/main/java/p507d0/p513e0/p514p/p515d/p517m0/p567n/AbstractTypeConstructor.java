package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner2;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: AbstractTypeConstructor.kt */
/* renamed from: d0.e0.p.d.m0.n.g, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractTypeConstructor implements TypeConstructor {

    /* renamed from: a */
    public final storage5<b> f24772a;

    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: d0.e0.p.d.m0.n.g$a */
    public final class a implements TypeConstructor {

        /* renamed from: a */
        public final KotlinTypeRefiner f24773a;

        /* renamed from: b */
        public final Lazy f24774b;

        /* renamed from: c */
        public final /* synthetic */ AbstractTypeConstructor f24775c;

        /* compiled from: AbstractTypeConstructor.kt */
        /* renamed from: d0.e0.p.d.m0.n.g$a$a, reason: collision with other inner class name */
        public static final class C13336a extends Lambda implements Function0<List<? extends KotlinType>> {
            public final /* synthetic */ AbstractTypeConstructor this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13336a(AbstractTypeConstructor abstractTypeConstructor) {
                super(0);
                this.this$1 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends KotlinType> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends KotlinType> invoke2() {
                return KotlinTypeRefiner2.refineTypes(a.access$getKotlinTypeRefiner$p(a.this), this.this$1.getSupertypes());
            }
        }

        public a(AbstractTypeConstructor abstractTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(abstractTypeConstructor, "this$0");
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f24775c = abstractTypeConstructor;
            this.f24773a = kotlinTypeRefiner;
            this.f24774b = LazyJVM.lazy(Lazy5.PUBLICATION, new C13336a(abstractTypeConstructor));
        }

        public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefiner$p(a aVar) {
            return aVar.f24773a;
        }

        public boolean equals(Object obj) {
            return this.f24775c.equals(obj);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.f24775c.getBuiltIns();
            Intrinsics3.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.f24775c.getDeclarationDescriptor();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.f24775c.getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public /* bridge */ /* synthetic */ Collection getSupertypes() {
            return getSupertypes();
        }

        public int hashCode() {
            return this.f24775c.hashCode();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public boolean isDenotable() {
            return this.f24775c.isDenotable();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.f24775c.refine(kotlinTypeRefiner);
        }

        public String toString() {
            return this.f24775c.toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public List<KotlinType> getSupertypes() {
            return (List) this.f24774b.getValue();
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: d0.e0.p.d.m0.n.g$b */
    public static final class b {

        /* renamed from: a */
        public final Collection<KotlinType> f24776a;

        /* renamed from: b */
        public List<? extends KotlinType> f24777b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends KotlinType> collection) {
            Intrinsics3.checkNotNullParameter(collection, "allSupertypes");
            this.f24776a = collection;
            this.f24777b = CollectionsJVM.listOf(ErrorUtils.f24879c);
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.f24776a;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.f24777b;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> list) {
            Intrinsics3.checkNotNullParameter(list, "<set-?>");
            this.f24777b = list;
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: d0.e0.p.d.m0.n.g$c */
    public static final class c extends Lambda implements Function0<b> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ b invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b(AbstractTypeConstructor.this.mo9370a());
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: d0.e0.p.d.m0.n.g$d */
    public static final class d extends Lambda implements Function1<Boolean, b> {

        /* renamed from: j */
        public static final d f24778j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final b invoke(boolean z2) {
            return new b(CollectionsJVM.listOf(ErrorUtils.f24879c));
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: d0.e0.p.d.m0.n.g$e */
    public static final class e extends Lambda implements Function1<b, Unit> {

        /* compiled from: AbstractTypeConstructor.kt */
        /* renamed from: d0.e0.p.d.m0.n.g$e$a */
        public static final class a extends Lambda implements Function1<TypeConstructor, Iterable<? extends KotlinType>> {
            public final /* synthetic */ AbstractTypeConstructor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AbstractTypeConstructor abstractTypeConstructor) {
                super(1);
                this.this$0 = abstractTypeConstructor;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Iterable<KotlinType> invoke2(TypeConstructor typeConstructor) {
                Intrinsics3.checkNotNullParameter(typeConstructor, "it");
                return AbstractTypeConstructor.access$computeNeighbours(this.this$0, typeConstructor, false);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Iterable<? extends KotlinType> invoke(TypeConstructor typeConstructor) {
                return invoke2(typeConstructor);
            }
        }

        /* compiled from: AbstractTypeConstructor.kt */
        /* renamed from: d0.e0.p.d.m0.n.g$e$b */
        public static final class b extends Lambda implements Function1<KotlinType, Unit> {
            public final /* synthetic */ AbstractTypeConstructor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(AbstractTypeConstructor abstractTypeConstructor) {
                super(1);
                this.this$0 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KotlinType kotlinType) {
                invoke2(kotlinType);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KotlinType kotlinType) {
                Intrinsics3.checkNotNullParameter(kotlinType, "it");
                this.this$0.mo9405f(kotlinType);
            }
        }

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
            invoke2(bVar);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(b bVar) {
            Intrinsics3.checkNotNullParameter(bVar, "supertypes");
            Collection<KotlinType> collectionFindLoopsInSupertypesAndDisconnect = AbstractTypeConstructor.this.mo9371d().findLoopsInSupertypesAndDisconnect(AbstractTypeConstructor.this, bVar.getAllSupertypes(), new a(AbstractTypeConstructor.this), new b(AbstractTypeConstructor.this));
            if (collectionFindLoopsInSupertypesAndDisconnect.isEmpty()) {
                KotlinType kotlinTypeMo9403b = AbstractTypeConstructor.this.mo9403b();
                collectionFindLoopsInSupertypesAndDisconnect = kotlinTypeMo9403b == null ? null : CollectionsJVM.listOf(kotlinTypeMo9403b);
                if (collectionFindLoopsInSupertypesAndDisconnect == null) {
                    collectionFindLoopsInSupertypesAndDisconnect = Collections2.emptyList();
                }
            }
            Objects.requireNonNull(AbstractTypeConstructor.this);
            AbstractTypeConstructor abstractTypeConstructor = AbstractTypeConstructor.this;
            List<KotlinType> list = collectionFindLoopsInSupertypesAndDisconnect instanceof List ? (List) collectionFindLoopsInSupertypesAndDisconnect : null;
            if (list == null) {
                list = _Collections.toList(collectionFindLoopsInSupertypesAndDisconnect);
            }
            bVar.setSupertypesWithoutCycles(abstractTypeConstructor.mo9404e(list));
        }
    }

    public AbstractTypeConstructor(StorageManager storageManager) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        this.f24772a = storageManager.createLazyValueWithPostCompute(new c(), d.f24778j, new e());
    }

    public static final Collection access$computeNeighbours(AbstractTypeConstructor abstractTypeConstructor, TypeConstructor typeConstructor, boolean z2) {
        Objects.requireNonNull(abstractTypeConstructor);
        AbstractTypeConstructor abstractTypeConstructor2 = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        List listPlus = abstractTypeConstructor2 != null ? _Collections.plus((Collection) abstractTypeConstructor2.f24772a.invoke().getAllSupertypes(), (Iterable) abstractTypeConstructor2.mo9996c(z2)) : null;
        if (listPlus != null) {
            return listPlus;
        }
        Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "supertypes");
        return supertypes;
    }

    /* renamed from: a */
    public abstract Collection<KotlinType> mo9370a();

    /* renamed from: b */
    public KotlinType mo9403b() {
        return null;
    }

    /* renamed from: c */
    public Collection<KotlinType> mo9996c(boolean z2) {
        return Collections2.emptyList();
    }

    /* renamed from: d */
    public abstract SupertypeLoopChecker mo9371d();

    /* renamed from: e */
    public List<KotlinType> mo9404e(List<KotlinType> list) {
        Intrinsics3.checkNotNullParameter(list, "supertypes");
        return list;
    }

    /* renamed from: f */
    public void mo9405f(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public abstract ClassifierDescriptor getDeclarationDescriptor();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public /* bridge */ /* synthetic */ Collection getSupertypes() {
        return getSupertypes();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public List<KotlinType> getSupertypes() {
        return this.f24772a.invoke().getSupertypesWithoutCycles();
    }
}
