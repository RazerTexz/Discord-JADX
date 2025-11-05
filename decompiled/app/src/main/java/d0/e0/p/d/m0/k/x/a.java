package d0.e0.p.d.m0.k.x;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.c.i;
import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.k.v.g;
import d0.e0.p.d.m0.n.l1.g;
import d0.e0.p.d.m0.p.b;
import d0.f0.q;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.j;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.Sequence;

/* compiled from: DescriptorUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: DescriptorUtils.kt */
    /* renamed from: d0.e0.p.d.m0.k.x.a$a, reason: collision with other inner class name */
    public static final class C0568a implements b.c<c1> {
        public static final C0568a a = new C0568a();

        @Override // d0.e0.p.d.m0.p.b.c
        public /* bridge */ /* synthetic */ Iterable<? extends c1> getNeighbors(c1 c1Var) {
            return getNeighbors2(c1Var);
        }

        /* renamed from: getNeighbors, reason: avoid collision after fix types in other method */
        public final Iterable<c1> getNeighbors2(c1 c1Var) {
            Collection<c1> overriddenDescriptors = c1Var.getOverriddenDescriptors();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(overriddenDescriptors, 10));
            Iterator<T> it = overriddenDescriptors.iterator();
            while (it.hasNext()) {
                arrayList.add(((c1) it.next()).getOriginal());
            }
            return arrayList;
        }
    }

    /* compiled from: DescriptorUtils.kt */
    public /* synthetic */ class b extends j implements Function1<c1, Boolean> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return a0.getOrCreateKotlinClass(c1.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(c1 c1Var) {
            return Boolean.valueOf(invoke2(c1Var));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(c1 c1Var) {
            m.checkNotNullParameter(c1Var, "p0");
            return c1Var.declaresDefaultValue();
        }
    }

    /* compiled from: DescriptorUtils.kt */
    public static final class c implements b.c<d0.e0.p.d.m0.c.b> {
        public final /* synthetic */ boolean a;

        public c(boolean z2) {
            this.a = z2;
        }

        @Override // d0.e0.p.d.m0.p.b.c
        public /* bridge */ /* synthetic */ Iterable<? extends d0.e0.p.d.m0.c.b> getNeighbors(d0.e0.p.d.m0.c.b bVar) {
            return getNeighbors2(bVar);
        }

        /* renamed from: getNeighbors, reason: avoid collision after fix types in other method */
        public final Iterable<d0.e0.p.d.m0.c.b> getNeighbors2(d0.e0.p.d.m0.c.b bVar) {
            if (this.a) {
                bVar = bVar == null ? null : bVar.getOriginal();
            }
            Collection<? extends d0.e0.p.d.m0.c.b> overriddenDescriptors = bVar != null ? bVar.getOverriddenDescriptors() : null;
            return overriddenDescriptors == null ? n.emptyList() : overriddenDescriptors;
        }
    }

    /* compiled from: DescriptorUtils.kt */
    public static final class d extends b.AbstractC0589b<d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.b> {
        public final /* synthetic */ Ref$ObjectRef<d0.e0.p.d.m0.c.b> a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<d0.e0.p.d.m0.c.b, Boolean> f3477b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Ref$ObjectRef<d0.e0.p.d.m0.c.b> ref$ObjectRef, Function1<? super d0.e0.p.d.m0.c.b, Boolean> function1) {
            this.a = ref$ObjectRef;
            this.f3477b = function1;
        }

        @Override // d0.e0.p.d.m0.p.b.AbstractC0589b, d0.e0.p.d.m0.p.b.d
        public /* bridge */ /* synthetic */ void afterChildren(Object obj) {
            afterChildren((d0.e0.p.d.m0.c.b) obj);
        }

        @Override // d0.e0.p.d.m0.p.b.d
        public /* bridge */ /* synthetic */ boolean beforeChildren(Object obj) {
            return beforeChildren((d0.e0.p.d.m0.c.b) obj);
        }

        @Override // d0.e0.p.d.m0.p.b.d
        public /* bridge */ /* synthetic */ Object result() {
            return result();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void afterChildren(d0.e0.p.d.m0.c.b bVar) {
            m.checkNotNullParameter(bVar, "current");
            if (this.a.element == null && this.f3477b.invoke(bVar).booleanValue()) {
                this.a.element = bVar;
            }
        }

        public boolean beforeChildren(d0.e0.p.d.m0.c.b bVar) {
            m.checkNotNullParameter(bVar, "current");
            return this.a.element == null;
        }

        @Override // d0.e0.p.d.m0.p.b.d
        public d0.e0.p.d.m0.c.b result() {
            return this.a.element;
        }
    }

    /* compiled from: DescriptorUtils.kt */
    public static final class e extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.m, d0.e0.p.d.m0.c.m> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m invoke(d0.e0.p.d.m0.c.m mVar) {
            return invoke2(mVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.c.m invoke2(d0.e0.p.d.m0.c.m mVar) {
            m.checkNotNullParameter(mVar, "it");
            return mVar.getContainingDeclaration();
        }
    }

    static {
        m.checkNotNullExpressionValue(d0.e0.p.d.m0.g.e.identifier("value"), "identifier(\"value\")");
    }

    public static final boolean declaresOrInheritsDefaultValue(c1 c1Var) {
        m.checkNotNullParameter(c1Var, "<this>");
        Boolean boolIfAny = d0.e0.p.d.m0.p.b.ifAny(d0.t.m.listOf(c1Var), C0568a.a, b.j);
        m.checkNotNullExpressionValue(boolIfAny, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return boolIfAny.booleanValue();
    }

    public static final g<?> firstArgument(d0.e0.p.d.m0.c.g1.c cVar) {
        m.checkNotNullParameter(cVar, "<this>");
        return (g) u.firstOrNull(cVar.getAllValueArguments().values());
    }

    public static final d0.e0.p.d.m0.c.b firstOverridden(d0.e0.p.d.m0.c.b bVar, boolean z2, Function1<? super d0.e0.p.d.m0.c.b, Boolean> function1) {
        m.checkNotNullParameter(bVar, "<this>");
        m.checkNotNullParameter(function1, "predicate");
        return (d0.e0.p.d.m0.c.b) d0.e0.p.d.m0.p.b.dfs(d0.t.m.listOf(bVar), new c(z2), new d(new Ref$ObjectRef(), function1));
    }

    public static /* synthetic */ d0.e0.p.d.m0.c.b firstOverridden$default(d0.e0.p.d.m0.c.b bVar, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return firstOverridden(bVar, z2, function1);
    }

    public static final d0.e0.p.d.m0.g.b fqNameOrNull(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        d0.e0.p.d.m0.g.c fqNameUnsafe = getFqNameUnsafe(mVar);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe == null) {
            return null;
        }
        return fqNameUnsafe.toSafe();
    }

    public static final d0.e0.p.d.m0.c.e getAnnotationClass(d0.e0.p.d.m0.c.g1.c cVar) {
        m.checkNotNullParameter(cVar, "<this>");
        h declarationDescriptor = cVar.getType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) declarationDescriptor;
        }
        return null;
    }

    public static final d0.e0.p.d.m0.b.h getBuiltIns(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        return getModule(mVar).getBuiltIns();
    }

    public static final d0.e0.p.d.m0.g.a getClassId(h hVar) {
        d0.e0.p.d.m0.c.m containingDeclaration;
        d0.e0.p.d.m0.g.a classId;
        if (hVar == null || (containingDeclaration = hVar.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof e0) {
            return new d0.e0.p.d.m0.g.a(((e0) containingDeclaration).getFqName(), hVar.getName());
        }
        if (!(containingDeclaration instanceof i) || (classId = getClassId((h) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(hVar.getName());
    }

    public static final d0.e0.p.d.m0.g.b getFqNameSafe(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        d0.e0.p.d.m0.g.b fqNameSafe = d0.e0.p.d.m0.k.e.getFqNameSafe(mVar);
        m.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(this)");
        return fqNameSafe;
    }

    public static final d0.e0.p.d.m0.g.c getFqNameUnsafe(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        d0.e0.p.d.m0.g.c fqName = d0.e0.p.d.m0.k.e.getFqName(mVar);
        m.checkNotNullExpressionValue(fqName, "getFqName(this)");
        return fqName;
    }

    public static final d0.e0.p.d.m0.n.l1.g getKotlinTypeRefiner(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.n.l1.o oVar = (d0.e0.p.d.m0.n.l1.o) c0Var.getCapability(d0.e0.p.d.m0.n.l1.h.getREFINER_CAPABILITY());
        d0.e0.p.d.m0.n.l1.g gVar = oVar == null ? null : (d0.e0.p.d.m0.n.l1.g) oVar.getValue();
        return gVar == null ? g.a.a : gVar;
    }

    public static final c0 getModule(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        c0 containingModule = d0.e0.p.d.m0.k.e.getContainingModule(mVar);
        m.checkNotNullExpressionValue(containingModule, "getContainingModule(this)");
        return containingModule;
    }

    public static final Sequence<d0.e0.p.d.m0.c.m> getParents(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        return q.drop(getParentsWithSelf(mVar), 1);
    }

    public static final Sequence<d0.e0.p.d.m0.c.m> getParentsWithSelf(d0.e0.p.d.m0.c.m mVar) {
        m.checkNotNullParameter(mVar, "<this>");
        return d0.f0.n.generateSequence(mVar, e.j);
    }

    public static final d0.e0.p.d.m0.c.b getPropertyIfAccessor(d0.e0.p.d.m0.c.b bVar) {
        m.checkNotNullParameter(bVar, "<this>");
        if (!(bVar instanceof m0)) {
            return bVar;
        }
        n0 correspondingProperty = ((m0) bVar).getCorrespondingProperty();
        m.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    public static final d0.e0.p.d.m0.c.e getSuperClassNotAny(d0.e0.p.d.m0.c.e eVar) {
        m.checkNotNullParameter(eVar, "<this>");
        for (d0.e0.p.d.m0.n.c0 c0Var : eVar.getDefaultType().getConstructor().getSupertypes()) {
            if (!d0.e0.p.d.m0.b.h.isAnyOrNullableAny(c0Var)) {
                h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
                if (d0.e0.p.d.m0.k.e.isClassOrEnumClass(declarationDescriptor)) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (d0.e0.p.d.m0.c.e) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean isTypeRefinementEnabled(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.n.l1.o oVar = (d0.e0.p.d.m0.n.l1.o) c0Var.getCapability(d0.e0.p.d.m0.n.l1.h.getREFINER_CAPABILITY());
        return (oVar == null ? null : (d0.e0.p.d.m0.n.l1.g) oVar.getValue()) != null;
    }

    public static final d0.e0.p.d.m0.c.e resolveTopLevelClass(c0 c0Var, d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.d.b.b bVar2) {
        m.checkNotNullParameter(c0Var, "<this>");
        m.checkNotNullParameter(bVar, "topLevelClassFqName");
        m.checkNotNullParameter(bVar2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        bVar.isRoot();
        d0.e0.p.d.m0.g.b bVarParent = bVar.parent();
        m.checkNotNullExpressionValue(bVarParent, "topLevelClassFqName.parent()");
        d0.e0.p.d.m0.k.a0.i memberScope = c0Var.getPackage(bVarParent).getMemberScope();
        d0.e0.p.d.m0.g.e eVarShortName = bVar.shortName();
        m.checkNotNullExpressionValue(eVarShortName, "topLevelClassFqName.shortName()");
        h contributedClassifier = memberScope.getContributedClassifier(eVarShortName, bVar2);
        if (contributedClassifier instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) contributedClassifier;
        }
        return null;
    }
}
