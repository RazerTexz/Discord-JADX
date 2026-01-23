package p507d0.p513e0.p514p.p515d;

import kotlin.Unit;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorVisitorEmptyBodies;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.a, reason: use source file name */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public class util extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit> {

    /* JADX INFO: renamed from: a */
    public final KDeclarationContainerImpl f22319a;

    public util(KDeclarationContainerImpl kDeclarationContainerImpl) {
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        this.f22319a = kDeclarationContainerImpl;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorVisitorEmptyBodies, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public /* bridge */ /* synthetic */ Object visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Object obj) {
        return visitFunctionDescriptor(functionDescriptor, (Unit) obj);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public /* bridge */ /* synthetic */ Object visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Object obj) {
        return visitPropertyDescriptor(propertyDescriptor, (Unit) obj);
    }

    public KCallableImpl<?> visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Unit unit) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(unit, "data");
        return new KFunctionImpl(this.f22319a, functionDescriptor);
    }

    public KCallableImpl<?> visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Unit unit) {
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(unit, "data");
        int i = (propertyDescriptor.getDispatchReceiverParameter() != null ? 1 : 0) + (propertyDescriptor.getExtensionReceiverParameter() != null ? 1 : 0);
        if (propertyDescriptor.isVar()) {
            if (i == 0) {
                return new KProperty0Impl(this.f22319a, propertyDescriptor);
            }
            if (i == 1) {
                return new KProperty1Impl(this.f22319a, propertyDescriptor);
            }
            if (i == 2) {
                return new KProperty2Impl(this.f22319a, propertyDescriptor);
            }
        } else {
            if (i == 0) {
                return new KProperty0Impl2(this.f22319a, propertyDescriptor);
            }
            if (i == 1) {
                return new KProperty1Impl2(this.f22319a, propertyDescriptor);
            }
            if (i == 2) {
                return new KProperty2Impl2(this.f22319a, propertyDescriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + propertyDescriptor);
    }
}
