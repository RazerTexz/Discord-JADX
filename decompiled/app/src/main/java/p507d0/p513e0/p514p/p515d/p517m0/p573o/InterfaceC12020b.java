package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.b */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12020b {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.b$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a {
        public static String invoke(InterfaceC12020b interfaceC12020b, FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(interfaceC12020b, "this");
            Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (interfaceC12020b.check(functionDescriptor)) {
                return null;
            }
            return interfaceC12020b.getDescription();
        }
    }

    boolean check(FunctionDescriptor functionDescriptor);

    String getDescription();

    String invoke(FunctionDescriptor functionDescriptor);
}
