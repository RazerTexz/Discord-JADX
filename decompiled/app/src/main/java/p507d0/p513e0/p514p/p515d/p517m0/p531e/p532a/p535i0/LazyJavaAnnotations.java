package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaAnnotationMapper2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage4;
import p507d0.p578f0._Sequences2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LazyJavaAnnotations.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotations implements Annotations4 {

    /* renamed from: j */
    public final context4 f23304j;

    /* renamed from: k */
    public final InterfaceC11570d f23305k;

    /* renamed from: l */
    public final boolean f23306l;

    /* renamed from: m */
    public final storage4<InterfaceC11564a, AnnotationDescriptor> f23307m;

    /* compiled from: LazyJavaAnnotations.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.d$a */
    public static final class a extends Lambda implements Function1<InterfaceC11564a, AnnotationDescriptor> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnnotationDescriptor invoke(InterfaceC11564a interfaceC11564a) {
            return invoke2(interfaceC11564a);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final AnnotationDescriptor invoke2(InterfaceC11564a interfaceC11564a) {
            Intrinsics3.checkNotNullParameter(interfaceC11564a, "annotation");
            return JavaAnnotationMapper2.f23230a.mapOrResolveJavaAnnotation(interfaceC11564a, LazyJavaAnnotations.access$getC$p(LazyJavaAnnotations.this), LazyJavaAnnotations.access$getAreAnnotationsFreshlySupported$p(LazyJavaAnnotations.this));
        }
    }

    public LazyJavaAnnotations(context4 context4Var, InterfaceC11570d interfaceC11570d, boolean z2) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(interfaceC11570d, "annotationOwner");
        this.f23304j = context4Var;
        this.f23305k = interfaceC11570d;
        this.f23306l = z2;
        this.f23307m = context4Var.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new a());
    }

    public static final /* synthetic */ boolean access$getAreAnnotationsFreshlySupported$p(LazyJavaAnnotations lazyJavaAnnotations) {
        return lazyJavaAnnotations.f23306l;
    }

    public static final /* synthetic */ context4 access$getC$p(LazyJavaAnnotations lazyJavaAnnotations) {
        return lazyJavaAnnotations.f23304j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        InterfaceC11564a interfaceC11564aFindAnnotation = this.f23305k.findAnnotation(fqName);
        AnnotationDescriptor annotationDescriptorInvoke = interfaceC11564aFindAnnotation == null ? null : this.f23307m.invoke(interfaceC11564aFindAnnotation);
        return annotationDescriptorInvoke == null ? JavaAnnotationMapper2.f23230a.findMappedJavaAnnotation(fqName, this.f23305k, this.f23304j) : annotationDescriptorInvoke;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        return Annotations4.b.hasAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean isEmpty() {
        return this.f23305k.getAnnotations().isEmpty() && !this.f23305k.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return _Sequences2.filterNotNull(_Sequences2.plus((Sequence<? extends AnnotationDescriptor>) _Sequences2.map(_Collections.asSequence(this.f23305k.getAnnotations()), this.f23307m), JavaAnnotationMapper2.f23230a.findMappedJavaAnnotation(StandardNames.a.f22566u, this.f23305k, this.f23304j))).iterator();
    }

    public /* synthetic */ LazyJavaAnnotations(context4 context4Var, InterfaceC11570d interfaceC11570d, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, interfaceC11570d, (i & 4) != 0 ? false : z2);
    }
}
