package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.Collection;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMetadataVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmNameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ClassData;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.IncompatibleVersionErrorData;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context5;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedPackageMemberScope;
import p507d0.p580t.Collections2;
import p507d0.p580t.Sets5;
import p507d0.p580t.SetsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: DeserializedDescriptorResolver.kt */
/* renamed from: d0.e0.p.d.m0.e.b.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class DeserializedDescriptorResolver {

    /* renamed from: a */
    public static final a f23603a = new a(null);

    /* renamed from: b */
    public static final Set<KotlinClassHeader.a> f23604b = SetsJVM.setOf(KotlinClassHeader.a.CLASS);

    /* renamed from: c */
    public static final Set<KotlinClassHeader.a> f23605c = Sets5.setOf((Object[]) new KotlinClassHeader.a[]{KotlinClassHeader.a.FILE_FACADE, KotlinClassHeader.a.MULTIFILE_CLASS_PART});

    /* renamed from: d */
    public static final JvmMetadataVersion f23606d = new JvmMetadataVersion(1, 1, 2);

    /* renamed from: e */
    public static final JvmMetadataVersion f23607e = new JvmMetadataVersion(1, 1, 11);

    /* renamed from: f */
    public static final JvmMetadataVersion f23608f = new JvmMetadataVersion(1, 1, 13);

    /* renamed from: g */
    public context5 f23609g;

    /* compiled from: DeserializedDescriptorResolver.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.f$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.access$getKOTLIN_1_3_RC_METADATA_VERSION$cp();
        }

        public final Set<KotlinClassHeader.a> getKOTLIN_CLASS$descriptors_jvm() {
            return DeserializedDescriptorResolver.access$getKOTLIN_CLASS$cp();
        }
    }

    /* compiled from: DeserializedDescriptorResolver.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.f$b */
    public static final class b extends Lambda implements Function0<Collection<? extends Name>> {

        /* renamed from: j */
        public static final b f23610j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<? extends Name> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<? extends Name> invoke2() {
            return Collections2.emptyList();
        }
    }

    public static final /* synthetic */ JvmMetadataVersion access$getKOTLIN_1_3_RC_METADATA_VERSION$cp() {
        return f23608f;
    }

    public static final /* synthetic */ Set access$getKOTLIN_CLASS$cp() {
        return f23604b;
    }

    public static final boolean access$getSkipMetadataVersionCheck(DeserializedDescriptorResolver deserializedDescriptorResolver) {
        return deserializedDescriptorResolver.getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    /* renamed from: a */
    public final DeserializedContainerSource m9545a(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        DeserializedContainerSource deserializedContainerSource = DeserializedContainerSource.STABLE;
        return getComponents().getConfiguration().getAllowUnstableDependencies() ? deserializedContainerSource : kotlinJvmBinaryClass.getClassHeader().isUnstableFirBinary() ? DeserializedContainerSource.FIR_UNSTABLE : kotlinJvmBinaryClass.getClassHeader().isUnstableJvmIrBinary() ? DeserializedContainerSource.IR_UNSTABLE : deserializedContainerSource;
    }

    /* renamed from: b */
    public final IncompatibleVersionErrorData<JvmMetadataVersion> m9546b(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (getComponents().getConfiguration().getSkipMetadataVersionCheck() || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
            return null;
        }
        return new IncompatibleVersionErrorData<>(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), JvmMetadataVersion.f23711f, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    /* renamed from: c */
    public final boolean m9547c(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (!getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() || (!kotlinJvmBinaryClass.getClassHeader().isPreRelease() && !Intrinsics3.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), f23606d))) {
            if (!(!getComponents().getConfiguration().getSkipPrereleaseCheck() && kotlinJvmBinaryClass.getClassHeader().isPreRelease() && Intrinsics3.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), f23607e))) {
                return false;
            }
        }
        return true;
    }

    public final MemberScope3 createKotlinPackagePartScope(PackageFragmentDescriptor packageFragmentDescriptor, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] strings;
        Tuples2<JvmNameResolver, C11687l> packageDataFrom;
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] strArrM9548d = m9548d(kotlinJvmBinaryClass, f23605c);
        if (strArrM9548d == null || (strings = kotlinJvmBinaryClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.f23720a;
                packageDataFrom = JvmProtoBufUtil.readPackageDataFrom(strArrM9548d, strings);
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e);
            }
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            packageDataFrom = null;
        }
        if (packageDataFrom == null) {
            return null;
        }
        JvmNameResolver jvmNameResolverComponent1 = packageDataFrom.component1();
        C11687l c11687lComponent2 = packageDataFrom.component2();
        return new DeserializedPackageMemberScope(packageFragmentDescriptor, c11687lComponent2, jvmNameResolverComponent1, kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), new JvmPackagePartSource(kotlinJvmBinaryClass, c11687lComponent2, jvmNameResolverComponent1, m9546b(kotlinJvmBinaryClass), m9547c(kotlinJvmBinaryClass), m9545a(kotlinJvmBinaryClass)), getComponents(), b.f23610j);
    }

    /* renamed from: d */
    public final String[] m9548d(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.a> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data != null && set.contains(classHeader.getKind())) {
            return data;
        }
        return null;
    }

    public final context5 getComponents() {
        context5 context5Var = this.f23609g;
        if (context5Var != null) {
            return context5Var;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("components");
        throw null;
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] strings;
        Tuples2<JvmNameResolver, C11678c> classDataFrom;
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        String[] strArrM9548d = m9548d(kotlinJvmBinaryClass, f23603a.getKOTLIN_CLASS$descriptors_jvm());
        if (strArrM9548d == null || (strings = kotlinJvmBinaryClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.f23720a;
                classDataFrom = JvmProtoBufUtil.readClassDataFrom(strArrM9548d, strings);
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e);
            }
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            classDataFrom = null;
        }
        if (classDataFrom == null) {
            return null;
        }
        return new ClassData(classDataFrom.component1(), classDataFrom.component2(), kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(kotlinJvmBinaryClass, m9546b(kotlinJvmBinaryClass), m9547c(kotlinJvmBinaryClass), m9545a(kotlinJvmBinaryClass)));
    }

    public final ClassDescriptor resolveClass(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        ClassData classData$descriptors_jvm = readClassData$descriptors_jvm(kotlinJvmBinaryClass);
        if (classData$descriptors_jvm == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(kotlinJvmBinaryClass.getClassId(), classData$descriptors_jvm);
    }

    public final void setComponents(context5 context5Var) {
        Intrinsics3.checkNotNullParameter(context5Var, "<set-?>");
        this.f23609g = context5Var;
    }

    public final void setComponents(DeserializationComponentsForJava deserializationComponentsForJava) {
        Intrinsics3.checkNotNullParameter(deserializationComponentsForJava, "components");
        setComponents(deserializationComponentsForJava.getComponents());
    }
}
