package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaMethodDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.RawType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.RawType2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.ExternalOverridabilityCondition;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p, reason: use source file name */
/* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p$a */
    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f23514a;

        static {
            OverridingUtil.d.a.values();
            f23514a = new int[]{1, 0, 0};
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p$b */
    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public static final class b extends Lambda implements Function1<ValueParameterDescriptor, KotlinType> {

        /* JADX INFO: renamed from: j */
        public static final b f23515j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType invoke(ValueParameterDescriptor valueParameterDescriptor) {
            return invoke2(valueParameterDescriptor);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType invoke2(ValueParameterDescriptor valueParameterDescriptor) {
            return valueParameterDescriptor.getType();
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.a getContract() {
        return ExternalOverridabilityCondition.a.SUCCESS_ONLY;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.b isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        boolean z2;
        CallableDescriptor callableDescriptorSubstitute;
        ExternalOverridabilityCondition.b bVar = ExternalOverridabilityCondition.b.UNKNOWN;
        Intrinsics3.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics3.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        if (!(callableDescriptor2 instanceof JavaMethodDescriptor)) {
            return bVar;
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
        Intrinsics3.checkNotNullExpressionValue(javaMethodDescriptor.getTypeParameters(), "subDescriptor.typeParameters");
        if (!r1.isEmpty()) {
            return bVar;
        }
        OverridingUtil.d basicOverridabilityProblem = OverridingUtil.getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if ((basicOverridabilityProblem == null ? null : basicOverridabilityProblem.getResult()) != null) {
            return bVar;
        }
        List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "subDescriptor.valueParameters");
        Sequence map = _Sequences2.map(_Collections.asSequence(valueParameters), b.f23515j);
        KotlinType returnType = javaMethodDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        Sequence sequencePlus = _Sequences2.plus((Sequence<? extends KotlinType>) map, returnType);
        ReceiverParameterDescriptor extensionReceiverParameter = javaMethodDescriptor.getExtensionReceiverParameter();
        Iterator it = _Sequences2.plus(sequencePlus, (Iterable) Collections2.listOfNotNull(extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null)).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            KotlinType kotlinType = (KotlinType) it.next();
            if ((kotlinType.getArguments().isEmpty() ^ true) && !(kotlinType.unwrap() instanceof RawType2)) {
                z2 = true;
                break;
            }
        }
        if (z2 || (callableDescriptorSubstitute = callableDescriptor.substitute(RawType.f23432b.buildSubstitutor())) == null) {
            return bVar;
        }
        if (callableDescriptorSubstitute instanceof SimpleFunctionDescriptor) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) callableDescriptorSubstitute;
            Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptor.getTypeParameters(), "erasedSuper.typeParameters");
            if (!r1.isEmpty()) {
                callableDescriptorSubstitute = (SimpleFunctionDescriptor) simpleFunctionDescriptor.newCopyBuilder().setTypeParameters(Collections2.emptyList()).build();
                Intrinsics3.checkNotNull(callableDescriptorSubstitute);
            }
        }
        OverridingUtil.d.a result = OverridingUtil.f24411b.isOverridableByWithoutExternalConditions(callableDescriptorSubstitute, callableDescriptor2, false).getResult();
        Intrinsics3.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
        return a.f23514a[result.ordinal()] == 1 ? ExternalOverridabilityCondition.b.OVERRIDABLE : bVar;
    }
}
