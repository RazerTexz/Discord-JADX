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
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: JavaAnnotationMapper.kt */
/* renamed from: d0.e0.p.d.m0.e.a.g0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaAnnotationMapper4 extends JavaAnnotationMapper {

    /* renamed from: g */
    public static final /* synthetic */ KProperty<Object>[] f23240g = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JavaAnnotationMapper4.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: h */
    public final storage5 f23241h;

    /* compiled from: JavaAnnotationMapper.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.g0.e$a */
    public static final class a extends Lambda implements Function0<Map<Name, ? extends C11831w>> {

        /* renamed from: j */
        public static final a f23242j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Name, ? extends C11831w> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Name, ? extends C11831w> invoke2() {
            return MapsJVM.mapOf(Tuples.m10073to(JavaAnnotationMapper2.f23230a.getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm(), new C11831w("Deprecated in Java")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaAnnotationMapper4(InterfaceC11564a interfaceC11564a, context4 context4Var) {
        super(context4Var, interfaceC11564a, StandardNames.a.f22566u);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        this.f23241h = context4Var.getStorageManager().createLazyValue(a.f23242j);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaAnnotationMapper, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public Map<Name, AbstractC11815g<?>> getAllValueArguments() {
        return (Map) storage7.getValue(this.f23241h, this, (KProperty<?>) f23240g[0]);
    }
}
