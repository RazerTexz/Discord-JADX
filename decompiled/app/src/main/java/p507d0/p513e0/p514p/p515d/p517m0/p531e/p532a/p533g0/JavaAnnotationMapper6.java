package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments5;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.i, reason: use source file name */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaAnnotationMapper6 extends JavaAnnotationMapper {

    /* JADX INFO: renamed from: g */
    public static final /* synthetic */ KProperty<Object>[] f23247g = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JavaAnnotationMapper6.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: h */
    public final storage5 f23248h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.i$a */
    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    public static final class a extends Lambda implements Function0<Map<Name, ? extends AbstractC11815g<? extends Object>>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Name, ? extends AbstractC11815g<? extends Object>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Name, ? extends AbstractC11815g<? extends Object>> invoke2() {
            annotationArguments annotationarguments = JavaAnnotationMapper6.this.f23227e;
            AbstractC11815g<?> abstractC11815gMapJavaTargetArguments$descriptors_jvm = annotationarguments instanceof annotationArguments3 ? JavaAnnotationMapper3.f23236a.mapJavaTargetArguments$descriptors_jvm(((annotationArguments3) annotationarguments).getElements()) : annotationarguments instanceof annotationArguments5 ? JavaAnnotationMapper3.f23236a.mapJavaTargetArguments$descriptors_jvm(CollectionsJVM.listOf(annotationarguments)) : null;
            Map<Name, ? extends AbstractC11815g<? extends Object>> mapMapOf = abstractC11815gMapJavaTargetArguments$descriptors_jvm != null ? MapsJVM.mapOf(Tuples.m10073to(JavaAnnotationMapper2.f23230a.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), abstractC11815gMapJavaTargetArguments$descriptors_jvm)) : null;
            return mapMapOf != null ? mapMapOf : Maps6.emptyMap();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaAnnotationMapper6(InterfaceC11564a interfaceC11564a, context4 context4Var) {
        super(context4Var, interfaceC11564a, StandardNames.a.f22504A);
        Intrinsics3.checkNotNullParameter(interfaceC11564a, "annotation");
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        this.f23248h = context4Var.getStorageManager().createLazyValue(new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaAnnotationMapper, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public Map<Name, AbstractC11815g<Object>> getAllValueArguments() {
        return (Map) storage7.getValue(this.f23248h, this, (KProperty<?>) f23247g[0]);
    }
}
