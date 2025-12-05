package p507d0.p513e0.p514p.p515d;

import java.io.IOException;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty5;
import kotlin.reflect.KProperty6;
import p507d0.p513e0.KClass;
import p507d0.p513e0.KProperty2;
import p507d0.p513e0.KProperty3;
import p507d0.p513e0.p514p.reflectLambda;
import p507d0.p592z.p594d.CallableReference;
import p507d0.p592z.p594d.FunctionBase;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.MutablePropertyReference0;
import p507d0.p592z.p594d.MutablePropertyReference1;
import p507d0.p592z.p594d.PropertyReference0;
import p507d0.p592z.p594d.PropertyReference1;
import p507d0.p592z.p594d.ReflectionFactory;

/* compiled from: ReflectionFactoryImpl.java */
/* renamed from: d0.e0.p.d.d0, reason: use source file name */
/* loaded from: classes3.dex */
public class ReflectionFactoryImpl extends ReflectionFactory {
    /* renamed from: a */
    public static KDeclarationContainerImpl m9333a(CallableReference callableReference) {
        KDeclarationContainer owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : EmptyContainerForLocal.f22320m;
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public KFunction function(FunctionReference functionReference) {
        return new KFunctionImpl(m9333a(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class cls) {
        return kClassCache.getOrCreateKotlinClass(cls);
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new KPackageImpl(cls, str);
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public KProperty5 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return new KProperty0Impl(m9333a(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public KProperty2 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return new KProperty1Impl(m9333a(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public KProperty6 property0(PropertyReference0 propertyReference0) {
        return new KProperty0Impl2(m9333a(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public KProperty3 property1(PropertyReference1 propertyReference1) {
        return new KProperty1Impl2(m9333a(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }

    @Override // p507d0.p592z.p594d.ReflectionFactory
    public String renderLambdaToString(FunctionBase functionBase) throws IOException {
        KFunctionImpl kFunctionImplAsKFunctionImpl;
        KFunction kFunctionReflect = reflectLambda.reflect(functionBase);
        return (kFunctionReflect == null || (kFunctionImplAsKFunctionImpl = util2.asKFunctionImpl(kFunctionReflect)) == null) ? super.renderLambdaToString(functionBase) : ReflectionObjectRenderer.f22349b.renderLambda(kFunctionImplAsKFunctionImpl.getDescriptor());
    }
}
