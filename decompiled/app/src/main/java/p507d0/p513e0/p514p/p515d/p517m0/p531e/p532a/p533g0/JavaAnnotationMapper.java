package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.Collection;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.PossiblyExternalAnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.b, reason: use source file name */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public class JavaAnnotationMapper implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ KProperty<Object>[] f23223a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JavaAnnotationMapper.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* JADX INFO: renamed from: b */
    public final FqName f23224b;

    /* JADX INFO: renamed from: c */
    public final SourceElement f23225c;

    /* JADX INFO: renamed from: d */
    public final storage5 f23226d;

    /* JADX INFO: renamed from: e */
    public final annotationArguments f23227e;

    /* JADX INFO: renamed from: f */
    public final boolean f23228f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.b$a */
    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    public static final class a extends Lambda implements Function0<KotlinType4> {

        /* JADX INFO: renamed from: $c */
        public final /* synthetic */ context4 f23229$c;
        public final /* synthetic */ JavaAnnotationMapper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(context4 context4Var, JavaAnnotationMapper javaAnnotationMapper) {
            super(0);
            this.f23229$c = context4Var;
            this.this$0 = javaAnnotationMapper;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType4 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            KotlinType4 defaultType = this.f23229$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
            return defaultType;
        }
    }

    public JavaAnnotationMapper(context4 context4Var, InterfaceC11564a interfaceC11564a, FqName fqName) {
        Collection<annotationArguments> arguments;
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        this.f23224b = fqName;
        SourceElement sourceElementSource = interfaceC11564a == null ? null : context4Var.getComponents().getSourceElementFactory().source(interfaceC11564a);
        if (sourceElementSource == null) {
            sourceElementSource = SourceElement.f23099a;
            Intrinsics3.checkNotNullExpressionValue(sourceElementSource, "NO_SOURCE");
        }
        this.f23225c = sourceElementSource;
        this.f23226d = context4Var.getStorageManager().createLazyValue(new a(context4Var, this));
        this.f23227e = (interfaceC11564a == null || (arguments = interfaceC11564a.getArguments()) == null) ? null : (annotationArguments) _Collections.firstOrNull(arguments);
        this.f23228f = Intrinsics3.areEqual(interfaceC11564a != null ? Boolean.valueOf(interfaceC11564a.isIdeExternalAnnotation()) : null, Boolean.TRUE);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public Map<Name, AbstractC11815g<?>> getAllValueArguments() {
        return Maps6.emptyMap();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public FqName getFqName() {
        return this.f23224b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public SourceElement getSource() {
        return this.f23225c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.f23228f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public KotlinType4 getType() {
        return (KotlinType4) storage7.getValue(this.f23226d, this, (KProperty<?>) f23223a[0]);
    }
}
