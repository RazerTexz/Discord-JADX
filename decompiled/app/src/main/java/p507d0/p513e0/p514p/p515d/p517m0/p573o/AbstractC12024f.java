package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: modifierChecks.kt */
/* renamed from: d0.e0.p.d.m0.o.f */
/* loaded from: classes3.dex */
public abstract class AbstractC12024f implements InterfaceC12020b {

    /* renamed from: a */
    public final String f24912a;

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.f$a */
    public static final class a extends AbstractC12024f {

        /* renamed from: b */
        public static final a f24913b = new a();

        public a() {
            super("must be a member function", null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getDispatchReceiverParameter() != null;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.f$b */
    public static final class b extends AbstractC12024f {

        /* renamed from: b */
        public static final b f24914b = new b();

        public b() {
            super("must be a member or an extension function", null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.getDispatchReceiverParameter() == null && functionDescriptor.getExtensionReceiverParameter() == null) ? false : true;
        }
    }

    public AbstractC12024f(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24912a = str;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return this.f24912a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(FunctionDescriptor functionDescriptor) {
        return InterfaceC12020b.a.invoke(this, functionDescriptor);
    }
}
