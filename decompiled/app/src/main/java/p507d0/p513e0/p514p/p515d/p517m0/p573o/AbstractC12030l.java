package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: modifierChecks.kt */
/* renamed from: d0.e0.p.d.m0.o.l */
/* loaded from: classes3.dex */
public abstract class AbstractC12030l implements InterfaceC12020b {

    /* renamed from: a */
    public final String f24965a;

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.l$a */
    public static final class a extends AbstractC12030l {

        /* renamed from: b */
        public final int f24966b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(int i) {
            StringBuilder sbM834V = outline.m834V("must have at least ", i, " value parameter");
            sbM834V.append(i > 1 ? "s" : "");
            super(sbM834V.toString(), null);
            this.f24966b = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() >= this.f24966b;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.l$b */
    public static final class b extends AbstractC12030l {

        /* renamed from: b */
        public final int f24967b;

        public b(int i) {
            super(outline.m873r("must have exactly ", i, " value parameters"), null);
            this.f24967b = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == this.f24967b;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.l$c */
    public static final class c extends AbstractC12030l {

        /* renamed from: b */
        public static final c f24968b = new c();

        public c() {
            super("must have no value parameters", null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.l$d */
    public static final class d extends AbstractC12030l {

        /* renamed from: b */
        public static final d f24969b = new d();

        public d() {
            super("must have a single value parameter", null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == 1;
        }
    }

    public AbstractC12030l(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24965a = str;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return this.f24965a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(FunctionDescriptor functionDescriptor) {
        return InterfaceC12020b.a.invoke(this, functionDescriptor);
    }
}
