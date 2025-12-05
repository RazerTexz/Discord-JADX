package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: JavaAnnotationMapper.kt */
/* renamed from: d0.e0.p.d.m0.e.a.g0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaAnnotationMapper5 extends JavaAnnotationMapper {

    /* renamed from: g */
    public static final /* synthetic */ KProperty<Object>[] f23245g = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JavaAnnotationMapper5.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: h */
    public final storage5 f23246h;

    /* compiled from: JavaAnnotationMapper.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.g0.h$a */
    public static final class a extends Lambda implements Function0<Map<Name, ? extends AbstractC11815g<?>>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Name, ? extends AbstractC11815g<?>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Name, ? extends AbstractC11815g<?>> invoke2() {
            AbstractC11815g<?> abstractC11815gMapJavaRetentionArgument$descriptors_jvm = JavaAnnotationMapper3.f23236a.mapJavaRetentionArgument$descriptors_jvm(JavaAnnotationMapper5.this.f23227e);
            Map<Name, ? extends AbstractC11815g<?>> mapMapOf = abstractC11815gMapJavaRetentionArgument$descriptors_jvm == null ? null : MapsJVM.mapOf(Tuples.m10073to(JavaAnnotationMapper2.f23230a.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), abstractC11815gMapJavaRetentionArgument$descriptors_jvm));
            return mapMapOf != null ? mapMapOf : Maps6.emptyMap();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaAnnotationMapper5(InterfaceC11564a interfaceC11564a, context4 context4Var) {
        super(context4Var, interfaceC11564a, StandardNames.a.f22507D);
        Intrinsics3.checkNotNullParameter(interfaceC11564a, "annotation");
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        this.f23246h = context4Var.getStorageManager().createLazyValue(new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaAnnotationMapper, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public Map<Name, AbstractC11815g<?>> getAllValueArguments() {
        return (Map) storage7.getValue(this.f23246h, this, (KProperty<?>) f23245g[0]);
    }
}
