package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.k */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12029k implements InterfaceC12020b {

    /* JADX INFO: renamed from: a */
    public final String f24956a;

    /* JADX INFO: renamed from: b */
    public final Function1<KotlinBuiltIns, KotlinType> f24957b;

    /* JADX INFO: renamed from: c */
    public final String f24958c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends AbstractC12029k {

        /* JADX INFO: renamed from: d */
        public static final a f24959d = new a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class C13340a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {

            /* JADX INFO: renamed from: j */
            public static final C13340a f24960j = new C13340a();

            public C13340a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                return invoke2(kotlinBuiltIns);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KotlinType invoke2(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "<this>");
                KotlinType4 booleanType = kotlinBuiltIns.getBooleanType();
                Intrinsics3.checkNotNullExpressionValue(booleanType, "booleanType");
                return booleanType;
            }
        }

        public a() {
            super("Boolean", C13340a.f24960j, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends AbstractC12029k {

        /* JADX INFO: renamed from: d */
        public static final b f24961d = new b();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$b$a */
        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {

            /* JADX INFO: renamed from: j */
            public static final a f24962j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                return invoke2(kotlinBuiltIns);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KotlinType invoke2(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "<this>");
                KotlinType4 intType = kotlinBuiltIns.getIntType();
                Intrinsics3.checkNotNullExpressionValue(intType, "intType");
                return intType;
            }
        }

        public b() {
            super("Int", a.f24962j, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$c */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends AbstractC12029k {

        /* JADX INFO: renamed from: d */
        public static final c f24963d = new c();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$c$a */
        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {

            /* JADX INFO: renamed from: j */
            public static final a f24964j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                return invoke2(kotlinBuiltIns);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KotlinType invoke2(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "<this>");
                KotlinType4 unitType = kotlinBuiltIns.getUnitType();
                Intrinsics3.checkNotNullExpressionValue(unitType, "unitType");
                return unitType;
            }
        }

        public c() {
            super("Unit", a.f24964j, null);
        }
    }

    public AbstractC12029k(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24956a = str;
        this.f24957b = function1;
        this.f24958c = Intrinsics3.stringPlus("must return ", str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics3.areEqual(functionDescriptor.getReturnType(), this.f24957b.invoke(DescriptorUtils2.getBuiltIns(functionDescriptor)));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return this.f24958c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(FunctionDescriptor functionDescriptor) {
        return InterfaceC12020b.a.invoke(this, functionDescriptor);
    }
}
