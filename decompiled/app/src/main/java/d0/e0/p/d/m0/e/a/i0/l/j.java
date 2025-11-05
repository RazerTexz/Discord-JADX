package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.e.a.i0.l.b;
import d0.e0.p.d.m0.e.a.k0.c0;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.e.a.s;
import d0.e0.p.d.m0.e.b.b0.a;
import d0.e0.p.d.m0.e.b.n;
import d0.e0.p.d.m0.k.a0.d;
import d0.t.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LazyJavaPackageScope.kt */
/* loaded from: classes3.dex */
public final class j extends r {
    public final u n;
    public final i o;
    public final d0.e0.p.d.m0.m.k<Set<String>> p;
    public final d0.e0.p.d.m0.m.i<a, d0.e0.p.d.m0.c.e> q;

    /* compiled from: LazyJavaPackageScope.kt */
    public static final class a {
        public final d0.e0.p.d.m0.g.e a;

        /* renamed from: b, reason: collision with root package name */
        public final d0.e0.p.d.m0.e.a.k0.g f3334b;

        public a(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.e.a.k0.g gVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.a = eVar;
            this.f3334b = gVar;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && d0.z.d.m.areEqual(this.a, ((a) obj).a);
        }

        public final d0.e0.p.d.m0.e.a.k0.g getJavaClass() {
            return this.f3334b;
        }

        public final d0.e0.p.d.m0.g.e getName() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    public static abstract class b {

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class a extends b {
            public final d0.e0.p.d.m0.c.e a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d0.e0.p.d.m0.c.e eVar) {
                super(null);
                d0.z.d.m.checkNotNullParameter(eVar, "descriptor");
                this.a = eVar;
            }

            public final d0.e0.p.d.m0.c.e getDescriptor() {
                return this.a;
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$b, reason: collision with other inner class name */
        public static final class C0525b extends b {
            public static final C0525b a = new C0525b();

            public C0525b() {
                super(null);
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class c extends b {
            public static final c a = new c();

            public c() {
                super(null);
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    public static final class c extends d0.z.d.o implements Function1<a, d0.e0.p.d.m0.c.e> {
        public final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g $c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d0.e0.p.d.m0.e.a.i0.g gVar) {
            super(1);
            this.$c = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke(a aVar) {
            return invoke2(aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final d0.e0.p.d.m0.c.e invoke2(a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "request");
            d0.e0.p.d.m0.g.a aVar2 = new d0.e0.p.d.m0.g.a(j.this.o.getFqName(), aVar.getName());
            n.a aVarFindKotlinClassOrContent = aVar.getJavaClass() != null ? this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(aVar.getJavaClass()) : this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(aVar2);
            d0.e0.p.d.m0.e.b.p kotlinJvmBinaryClass = aVarFindKotlinClassOrContent == null ? null : aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
            d0.e0.p.d.m0.g.a classId = kotlinJvmBinaryClass == null ? null : kotlinJvmBinaryClass.getClassId();
            if (classId != null && (classId.isNestedClass() || classId.isLocal())) {
                return null;
            }
            b bVarAccess$resolveKotlinBinaryClass = j.access$resolveKotlinBinaryClass(j.this, kotlinJvmBinaryClass);
            if (bVarAccess$resolveKotlinBinaryClass instanceof b.a) {
                return ((b.a) bVarAccess$resolveKotlinBinaryClass).getDescriptor();
            }
            if (bVarAccess$resolveKotlinBinaryClass instanceof b.c) {
                return null;
            }
            if (!(bVarAccess$resolveKotlinBinaryClass instanceof b.C0525b)) {
                throw new NoWhenBranchMatchedException();
            }
            d0.e0.p.d.m0.e.a.k0.g javaClass = aVar.getJavaClass();
            if (javaClass == null) {
                d0.e0.p.d.m0.e.a.s finder = this.$c.getComponents().getFinder();
                if (aVarFindKotlinClassOrContent != null) {
                    if (!(aVarFindKotlinClassOrContent instanceof n.a.C0537a)) {
                        aVarFindKotlinClassOrContent = null;
                    }
                    n.a.C0537a c0537a = (n.a.C0537a) aVarFindKotlinClassOrContent;
                    byte[] content = c0537a == null ? null : c0537a.getContent();
                    javaClass = finder.findClass(new s.a(aVar2, content, null, 4, null));
                }
            }
            d0.e0.p.d.m0.e.a.k0.g gVar = javaClass;
            if ((gVar == null ? null : gVar.getLightClassOriginKind()) != c0.BINARY) {
                d0.e0.p.d.m0.g.b fqName = gVar == null ? null : gVar.getFqName();
                if (fqName == null || fqName.isRoot() || !d0.z.d.m.areEqual(fqName.parent(), j.this.o.getFqName())) {
                    return null;
                }
                f fVar = new f(this.$c, j.this.o, gVar, null, 8, null);
                this.$c.getComponents().getJavaClassesTracker().reportClass(fVar);
                return fVar;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + aVar2 + "\nfindKotlinClass(JavaClass) = " + d0.e0.p.d.m0.e.b.o.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), gVar) + "\nfindKotlinClass(ClassId) = " + d0.e0.p.d.m0.e.b.o.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), aVar2) + '\n');
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    public static final class d extends d0.z.d.o implements Function0<Set<? extends String>> {
        public final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g $c;
        public final /* synthetic */ j this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d0.e0.p.d.m0.e.a.i0.g gVar, j jVar) {
            super(0);
            this.$c = gVar;
            this.this$0 = jVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends String> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends String> invoke2() {
            return this.$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.o.getFqName());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d0.e0.p.d.m0.e.a.i0.g gVar, u uVar, i iVar) {
        super(gVar);
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(uVar, "jPackage");
        d0.z.d.m.checkNotNullParameter(iVar, "ownerDescriptor");
        this.n = uVar;
        this.o = iVar;
        this.p = gVar.getStorageManager().createNullableLazyValue(new d(gVar, this));
        this.q = gVar.getStorageManager().createMemoizedFunctionWithNullableValues(new c(gVar));
    }

    public static final b access$resolveKotlinBinaryClass(j jVar, d0.e0.p.d.m0.e.b.p pVar) {
        Objects.requireNonNull(jVar);
        if (pVar == null) {
            return b.C0525b.a;
        }
        if (pVar.getClassHeader().getKind() != a.EnumC0533a.CLASS) {
            return b.c.a;
        }
        d0.e0.p.d.m0.c.e eVarResolveClass = jVar.c.getComponents().getDeserializedDescriptorResolver().resolveClass(pVar);
        return eVarResolveClass != null ? new b.a(eVarResolveClass) : b.C0525b.a;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> a(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        if (!dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return n0.emptySet();
        }
        Set<String> setInvoke = this.p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(d0.e0.p.d.m0.g.e.identifier((String) it.next()));
            }
            return hashSet;
        }
        u uVar = this.n;
        if (function1 == null) {
            function1 = d0.e0.p.d.m0.p.d.alwaysTrue();
        }
        Collection<d0.e0.p.d.m0.e.a.k0.g> classes = uVar.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (d0.e0.p.d.m0.e.a.k0.g gVar : classes) {
            d0.e0.p.d.m0.g.e name = gVar.getLightClassOriginKind() == c0.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> b(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public d0.e0.p.d.m0.e.a.i0.l.b d() {
        return b.a.a;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public void f(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    public final d0.e0.p.d.m0.c.e findClassifierByJavaClass$descriptors_jvm(d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "javaClass");
        return o(gVar.getName(), gVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        return getContributedClassifier(eVar, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    @Override // d0.e0.p.d.m0.e.a.i0.l.k, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        boolean z2;
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        d.a aVar = d0.e0.p.d.m0.k.a0.d.a;
        if (!dVar.acceptsKinds(aVar.getNON_SINGLETON_CLASSIFIERS_MASK() | aVar.getCLASSIFIERS_MASK())) {
            return d0.t.n.emptyList();
        }
        Collection<d0.e0.p.d.m0.c.m> collectionInvoke = this.e.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            d0.e0.p.d.m0.c.m mVar = (d0.e0.p.d.m0.c.m) obj;
            if (mVar instanceof d0.e0.p.d.m0.c.e) {
                d0.e0.p.d.m0.g.e name = ((d0.e0.p.d.m0.c.e) mVar).getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
                z2 = function1.invoke(name).booleanValue();
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> h(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public d0.e0.p.d.m0.c.m j() {
        return this.o;
    }

    public final d0.e0.p.d.m0.c.e o(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.e.a.k0.g gVar) {
        if (!d0.e0.p.d.m0.g.g.isSafeIdentifier(eVar)) {
            return null;
        }
        Set<String> setInvoke = this.p.invoke();
        if (gVar != null || setInvoke == null || setInvoke.contains(eVar.asString())) {
            return this.q.invoke(new a(eVar, gVar));
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.e getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return o(eVar, null);
    }
}
