package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.e.b.b0.a;
import d0.t.m0;
import d0.t.n0;
import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* compiled from: DeserializedDescriptorResolver.kt */
/* loaded from: classes3.dex */
public final class f {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Set<a.EnumC0533a> f3376b = m0.setOf(a.EnumC0533a.CLASS);
    public static final Set<a.EnumC0533a> c = n0.setOf((Object[]) new a.EnumC0533a[]{a.EnumC0533a.FILE_FACADE, a.EnumC0533a.MULTIFILE_CLASS_PART});
    public static final d0.e0.p.d.m0.f.a0.b.f d = new d0.e0.p.d.m0.f.a0.b.f(1, 1, 2);
    public static final d0.e0.p.d.m0.f.a0.b.f e = new d0.e0.p.d.m0.f.a0.b.f(1, 1, 11);
    public static final d0.e0.p.d.m0.f.a0.b.f f = new d0.e0.p.d.m0.f.a0.b.f(1, 1, 13);
    public d0.e0.p.d.m0.l.b.j g;

    /* compiled from: DeserializedDescriptorResolver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final d0.e0.p.d.m0.f.a0.b.f getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return f.access$getKOTLIN_1_3_RC_METADATA_VERSION$cp();
        }

        public final Set<a.EnumC0533a> getKOTLIN_CLASS$descriptors_jvm() {
            return f.access$getKOTLIN_CLASS$cp();
        }
    }

    /* compiled from: DeserializedDescriptorResolver.kt */
    public static final class b extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.m0.g.e>> {
        public static final b j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.g.e> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<? extends d0.e0.p.d.m0.g.e> invoke2() {
            return d0.t.n.emptyList();
        }
    }

    public static final /* synthetic */ d0.e0.p.d.m0.f.a0.b.f access$getKOTLIN_1_3_RC_METADATA_VERSION$cp() {
        return f;
    }

    public static final /* synthetic */ Set access$getKOTLIN_CLASS$cp() {
        return f3376b;
    }

    public static final boolean access$getSkipMetadataVersionCheck(f fVar) {
        return fVar.getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    public final d0.e0.p.d.m0.l.b.e0.e a(p pVar) {
        d0.e0.p.d.m0.l.b.e0.e eVar = d0.e0.p.d.m0.l.b.e0.e.STABLE;
        return getComponents().getConfiguration().getAllowUnstableDependencies() ? eVar : pVar.getClassHeader().isUnstableFirBinary() ? d0.e0.p.d.m0.l.b.e0.e.FIR_UNSTABLE : pVar.getClassHeader().isUnstableJvmIrBinary() ? d0.e0.p.d.m0.l.b.e0.e.IR_UNSTABLE : eVar;
    }

    public final d0.e0.p.d.m0.l.b.r<d0.e0.p.d.m0.f.a0.b.f> b(p pVar) {
        if (getComponents().getConfiguration().getSkipMetadataVersionCheck() || pVar.getClassHeader().getMetadataVersion().isCompatible()) {
            return null;
        }
        return new d0.e0.p.d.m0.l.b.r<>(pVar.getClassHeader().getMetadataVersion(), d0.e0.p.d.m0.f.a0.b.f.f, pVar.getLocation(), pVar.getClassId());
    }

    public final boolean c(p pVar) {
        if (!getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() || (!pVar.getClassHeader().isPreRelease() && !d0.z.d.m.areEqual(pVar.getClassHeader().getMetadataVersion(), d))) {
            if (!(!getComponents().getConfiguration().getSkipPrereleaseCheck() && pVar.getClassHeader().isPreRelease() && d0.z.d.m.areEqual(pVar.getClassHeader().getMetadataVersion(), e))) {
                return false;
            }
        }
        return true;
    }

    public final d0.e0.p.d.m0.k.a0.i createKotlinPackagePartScope(e0 e0Var, p pVar) {
        String[] strings;
        Pair<d0.e0.p.d.m0.f.a0.b.g, d0.e0.p.d.m0.f.l> packageDataFrom;
        d0.z.d.m.checkNotNullParameter(e0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(pVar, "kotlinClass");
        String[] strArrD = d(pVar, c);
        if (strArrD == null || (strings = pVar.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                d0.e0.p.d.m0.f.a0.b.h hVar = d0.e0.p.d.m0.f.a0.b.h.a;
                packageDataFrom = d0.e0.p.d.m0.f.a0.b.h.readPackageDataFrom(strArrD, strings);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(d0.z.d.m.stringPlus("Could not read data from ", pVar.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || pVar.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            packageDataFrom = null;
        }
        if (packageDataFrom == null) {
            return null;
        }
        d0.e0.p.d.m0.f.a0.b.g gVarComponent1 = packageDataFrom.component1();
        d0.e0.p.d.m0.f.l lVarComponent2 = packageDataFrom.component2();
        return new d0.e0.p.d.m0.l.b.e0.i(e0Var, lVarComponent2, gVarComponent1, pVar.getClassHeader().getMetadataVersion(), new j(pVar, lVarComponent2, gVarComponent1, b(pVar), c(pVar), a(pVar)), getComponents(), b.j);
    }

    public final String[] d(p pVar, Set<? extends a.EnumC0533a> set) {
        d0.e0.p.d.m0.e.b.b0.a classHeader = pVar.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data != null && set.contains(classHeader.getKind())) {
            return data;
        }
        return null;
    }

    public final d0.e0.p.d.m0.l.b.j getComponents() {
        d0.e0.p.d.m0.l.b.j jVar = this.g;
        if (jVar != null) {
            return jVar;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("components");
        throw null;
    }

    public final d0.e0.p.d.m0.l.b.f readClassData$descriptors_jvm(p pVar) {
        String[] strings;
        Pair<d0.e0.p.d.m0.f.a0.b.g, d0.e0.p.d.m0.f.c> classDataFrom;
        d0.z.d.m.checkNotNullParameter(pVar, "kotlinClass");
        String[] strArrD = d(pVar, a.getKOTLIN_CLASS$descriptors_jvm());
        if (strArrD == null || (strings = pVar.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                d0.e0.p.d.m0.f.a0.b.h hVar = d0.e0.p.d.m0.f.a0.b.h.a;
                classDataFrom = d0.e0.p.d.m0.f.a0.b.h.readClassDataFrom(strArrD, strings);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(d0.z.d.m.stringPlus("Could not read data from ", pVar.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || pVar.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            classDataFrom = null;
        }
        if (classDataFrom == null) {
            return null;
        }
        return new d0.e0.p.d.m0.l.b.f(classDataFrom.component1(), classDataFrom.component2(), pVar.getClassHeader().getMetadataVersion(), new r(pVar, b(pVar), c(pVar), a(pVar)));
    }

    public final d0.e0.p.d.m0.c.e resolveClass(p pVar) {
        d0.z.d.m.checkNotNullParameter(pVar, "kotlinClass");
        d0.e0.p.d.m0.l.b.f classData$descriptors_jvm = readClassData$descriptors_jvm(pVar);
        if (classData$descriptors_jvm == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(pVar.getClassId(), classData$descriptors_jvm);
    }

    public final void setComponents(d0.e0.p.d.m0.l.b.j jVar) {
        d0.z.d.m.checkNotNullParameter(jVar, "<set-?>");
        this.g = jVar;
    }

    public final void setComponents(e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "components");
        setComponents(eVar.getComponents());
    }
}
