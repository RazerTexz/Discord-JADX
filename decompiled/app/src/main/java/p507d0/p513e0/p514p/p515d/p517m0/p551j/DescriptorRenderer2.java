package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationUseSiteTarget;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.ClassifierNamePolicy;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.c, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorRenderer2 {

    /* JADX INFO: renamed from: a */
    public static final k f24225a;

    /* JADX INFO: renamed from: b */
    public static final DescriptorRenderer2 f24226b;

    /* JADX INFO: renamed from: c */
    public static final DescriptorRenderer2 f24227c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$a */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class a extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final a f24228j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setWithDefinedIn(false);
            descriptorRenderer4.setModifiers(Sets5.emptySet());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$b */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class b extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final b f24229j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setWithDefinedIn(false);
            descriptorRenderer4.setModifiers(Sets5.emptySet());
            descriptorRenderer4.setWithoutSuperTypes(true);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$c */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class c extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final c f24230j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setWithDefinedIn(false);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$d */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class d extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final d f24231j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setModifiers(Sets5.emptySet());
            descriptorRenderer4.setClassifierNamePolicy(ClassifierNamePolicy.b.f24223a);
            descriptorRenderer4.setParameterNameRenderingPolicy(DescriptorRenderer7.ONLY_NON_SYNTHESIZED);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$e */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class e extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final e f24232j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setDebugMode(true);
            descriptorRenderer4.setClassifierNamePolicy(ClassifierNamePolicy.a.f24222a);
            descriptorRenderer4.setModifiers(DescriptorRenderer3.f24245k);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$f */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class f extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final f f24233j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setModifiers(DescriptorRenderer3.f24244j);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$g */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class g extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final g f24234j = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setModifiers(DescriptorRenderer3.f24245k);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$h */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class h extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final h f24235j = new h();

        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setTextFormat(DescriptorRenderer9.f24330k);
            descriptorRenderer4.setModifiers(DescriptorRenderer3.f24245k);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$i */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class i extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final i f24236j = new i();

        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setWithDefinedIn(false);
            descriptorRenderer4.setModifiers(Sets5.emptySet());
            descriptorRenderer4.setClassifierNamePolicy(ClassifierNamePolicy.b.f24223a);
            descriptorRenderer4.setWithoutTypeParameters(true);
            descriptorRenderer4.setParameterNameRenderingPolicy(DescriptorRenderer7.NONE);
            descriptorRenderer4.setReceiverAfterName(true);
            descriptorRenderer4.setRenderCompanionObjectName(true);
            descriptorRenderer4.setWithoutSuperTypes(true);
            descriptorRenderer4.setStartFromName(true);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$j */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class j extends Lambda implements Function1<DescriptorRenderer4, Unit> {

        /* JADX INFO: renamed from: j */
        public static final j f24237j = new j();

        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setClassifierNamePolicy(ClassifierNamePolicy.b.f24223a);
            descriptorRenderer4.setParameterNameRenderingPolicy(DescriptorRenderer7.ONLY_NON_SYNTHESIZED);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$k */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class k {
        public k(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
            Intrinsics3.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifier");
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (!(classifierDescriptorWithTypeParameters instanceof ClassDescriptor)) {
                throw new AssertionError(Intrinsics3.stringPlus("Unexpected classifier: ", classifierDescriptorWithTypeParameters));
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorWithTypeParameters;
            if (classDescriptor.isCompanionObject()) {
                return "companion object";
            }
            int iOrdinal = classDescriptor.getKind().ordinal();
            if (iOrdinal == 0) {
                return "class";
            }
            if (iOrdinal == 1) {
                return "interface";
            }
            if (iOrdinal == 2) {
                return "enum class";
            }
            if (iOrdinal == 3) {
                return "enum entry";
            }
            if (iOrdinal == 4) {
                return "annotation class";
            }
            if (iOrdinal == 5) {
                return "object";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final DescriptorRenderer2 withOptions(Function1<? super DescriptorRenderer4, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            function1.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.lock();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$l */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public interface l {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$l$a */
        /* JADX INFO: compiled from: DescriptorRenderer.kt */
        public static final class a implements l {

            /* JADX INFO: renamed from: a */
            public static final a f24238a = new a();

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2.l
            public void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb) {
                Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "parameter");
                Intrinsics3.checkNotNullParameter(sb, "builder");
                if (i != i2 - 1) {
                    sb.append(", ");
                }
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2.l
            public void appendAfterValueParameters(int i, StringBuilder sb) {
                Intrinsics3.checkNotNullParameter(sb, "builder");
                sb.append(")");
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2.l
            public void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb) {
                Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "parameter");
                Intrinsics3.checkNotNullParameter(sb, "builder");
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2.l
            public void appendBeforeValueParameters(int i, StringBuilder sb) {
                Intrinsics3.checkNotNullParameter(sb, "builder");
                sb.append("(");
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb);

        void appendAfterValueParameters(int i, StringBuilder sb);

        void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb);

        void appendBeforeValueParameters(int i, StringBuilder sb);
    }

    static {
        k kVar = new k(null);
        f24225a = kVar;
        kVar.withOptions(c.f24230j);
        kVar.withOptions(a.f24228j);
        kVar.withOptions(b.f24229j);
        kVar.withOptions(d.f24231j);
        kVar.withOptions(i.f24236j);
        f24226b = kVar.withOptions(f.f24233j);
        kVar.withOptions(g.f24234j);
        kVar.withOptions(j.f24237j);
        f24227c = kVar.withOptions(e.f24232j);
        kVar.withOptions(h.f24235j);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer2 descriptorRenderer2, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i2 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        return descriptorRenderer2.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
    }

    public abstract String render(DeclarationDescriptor declarationDescriptor);

    public abstract String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns);

    public abstract String renderFqName(FqNameUnsafe fqNameUnsafe);

    public abstract String renderName(Name name, boolean z2);

    public abstract String renderType(KotlinType kotlinType);

    public abstract String renderTypeProjection(TypeProjection typeProjection);

    public final DescriptorRenderer2 withOptions(Function1<? super DescriptorRenderer4, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "changeOptions");
        DescriptorRendererOptionsImpl descriptorRendererOptionsImplCopy = ((DescriptorRendererImpl) this).getOptions().copy();
        function1.invoke(descriptorRendererOptionsImplCopy);
        descriptorRendererOptionsImplCopy.lock();
        return new DescriptorRendererImpl(descriptorRendererOptionsImplCopy);
    }
}
