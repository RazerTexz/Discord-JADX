package p507d0.p513e0.p514p.p515d;

import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.e0, reason: use source file name */
/* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectionObjectRenderer {

    /* JADX INFO: renamed from: b */
    public static final ReflectionObjectRenderer f22349b = new ReflectionObjectRenderer();

    /* JADX INFO: renamed from: a */
    public static final DescriptorRenderer2 f22348a = DescriptorRenderer2.f24226b;

    /* JADX INFO: renamed from: d0.e0.p.d.e0$a */
    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    public static final class a extends Lambda implements Function1<ValueParameterDescriptor, CharSequence> {

        /* JADX INFO: renamed from: j */
        public static final a f22350j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
            return invoke2(valueParameterDescriptor);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(ValueParameterDescriptor valueParameterDescriptor) {
            ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f22349b;
            Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
            KotlinType type = valueParameterDescriptor.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "it.type");
            return reflectionObjectRenderer.renderType(type);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e0$b */
    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    public static final class b extends Lambda implements Function1<ValueParameterDescriptor, CharSequence> {

        /* JADX INFO: renamed from: j */
        public static final b f22351j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
            return invoke2(valueParameterDescriptor);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(ValueParameterDescriptor valueParameterDescriptor) {
            ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f22349b;
            Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
            KotlinType type = valueParameterDescriptor.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "it.type");
            return reflectionObjectRenderer.renderType(type);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m9334a(StringBuilder sb, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            KotlinType type = receiverParameterDescriptor.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
            sb.append(".");
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m9335b(StringBuilder sb, CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor instanceReceiverParameter = util2.getInstanceReceiverParameter(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        m9334a(sb, instanceReceiverParameter);
        boolean z2 = (instanceReceiverParameter == null || extensionReceiverParameter == null) ? false : true;
        if (z2) {
            sb.append("(");
        }
        m9334a(sb, extensionReceiverParameter);
        if (z2) {
            sb.append(")");
        }
    }

    public final String renderFunction(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = f22349b;
        reflectionObjectRenderer.m9335b(sb, functionDescriptor);
        DescriptorRenderer2 descriptorRenderer2 = f22348a;
        Name name = functionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(descriptorRenderer2.renderName(name, true));
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
        _Collections.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, a.f22350j, 48, null);
        sb.append(": ");
        KotlinType returnType = functionDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        Intrinsics3.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderLambda(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "invoke");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = f22349b;
        reflectionObjectRenderer.m9335b(sb, functionDescriptor);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "invoke.valueParameters");
        _Collections.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, b.f22351j, 48, null);
        sb.append(" -> ");
        KotlinType returnType = functionDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        Intrinsics3.checkNotNullExpressionValue(returnType, "invoke.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderParameter(KParameterImpl kParameterImpl) {
        String strRenderFunction;
        Intrinsics3.checkNotNullParameter(kParameterImpl, "parameter");
        StringBuilder sb = new StringBuilder();
        int iOrdinal = kParameterImpl.getKind().ordinal();
        if (iOrdinal == 0) {
            sb.append("instance parameter");
        } else if (iOrdinal == 1) {
            sb.append("extension receiver parameter");
        } else if (iOrdinal == 2) {
            StringBuilder sbM833U = outline.m833U("parameter #");
            sbM833U.append(kParameterImpl.getIndex());
            sbM833U.append(' ');
            sbM833U.append(kParameterImpl.getName());
            sb.append(sbM833U.toString());
        }
        sb.append(" of ");
        ReflectionObjectRenderer reflectionObjectRenderer = f22349b;
        CallableMemberDescriptor descriptor = kParameterImpl.getCallable().getDescriptor();
        if (descriptor instanceof PropertyDescriptor) {
            strRenderFunction = reflectionObjectRenderer.renderProperty((PropertyDescriptor) descriptor);
        } else {
            if (!(descriptor instanceof FunctionDescriptor)) {
                throw new IllegalStateException(("Illegal callable: " + descriptor).toString());
            }
            strRenderFunction = reflectionObjectRenderer.renderFunction((FunctionDescriptor) descriptor);
        }
        sb.append(strRenderFunction);
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderProperty(PropertyDescriptor propertyDescriptor) {
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(propertyDescriptor.isVar() ? "var " : "val ");
        ReflectionObjectRenderer reflectionObjectRenderer = f22349b;
        reflectionObjectRenderer.m9335b(sb, propertyDescriptor);
        DescriptorRenderer2 descriptorRenderer2 = f22348a;
        Name name = propertyDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(descriptorRenderer2.renderName(name, true));
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "descriptor.type");
        sb.append(reflectionObjectRenderer.renderType(type));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        return f22348a.renderType(kotlinType);
    }
}
