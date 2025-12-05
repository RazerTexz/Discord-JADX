package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: modifierChecks.kt */
/* renamed from: d0.e0.p.d.m0.o.h */
/* loaded from: classes3.dex */
public final class C12026h implements InterfaceC12020b {

    /* renamed from: a */
    public static final C12026h f24916a = new C12026h();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "functionDescriptor.valueParameters");
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                if (!(!DescriptorUtils2.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return "should not have varargs or parameters with default values";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(FunctionDescriptor functionDescriptor) {
        return InterfaceC12020b.a.invoke(this, functionDescriptor);
    }
}
