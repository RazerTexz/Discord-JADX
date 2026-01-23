package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.SpecialGenericSignatures;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.methodSignatureMapping3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h, reason: use source file name */
/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class specialBuiltinMembers3 extends SpecialGenericSignatures {

    /* JADX INFO: renamed from: m */
    public static final specialBuiltinMembers3 f23259m = new specialBuiltinMembers3();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h$a */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class a extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            return specialBuiltinMembers3.access$getHasErasedValueParametersInJava(specialBuiltinMembers3.this, callableMemberDescriptor);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h$b */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class b extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            return (callableMemberDescriptor instanceof FunctionDescriptor) && specialBuiltinMembers3.access$getHasErasedValueParametersInJava(specialBuiltinMembers3.this, callableMemberDescriptor);
        }
    }

    public static final boolean access$getHasErasedValueParametersInJava(specialBuiltinMembers3 specialbuiltinmembers3, CallableMemberDescriptor callableMemberDescriptor) {
        Objects.requireNonNull(specialbuiltinmembers3);
        return _Collections.contains(SpecialGenericSignatures.f23195a.getERASED_VALUE_PARAMETERS_SIGNATURES(), methodSignatureMapping3.computeJvmSignature(callableMemberDescriptor));
    }

    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        specialBuiltinMembers3 specialbuiltinmembers3 = f23259m;
        Name name = functionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "functionDescriptor.name");
        if (specialbuiltinmembers3.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (FunctionDescriptor) DescriptorUtils2.firstOverridden$default(functionDescriptor, false, specialbuiltinmembers3.new a(), 1, null);
        }
        return null;
    }

    public static final SpecialGenericSignatures.b getSpecialSignatureInfo(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.f23195a;
        if (!aVar.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(callableMemberDescriptor.getName())) {
            return null;
        }
        CallableMemberDescriptor callableMemberDescriptorFirstOverridden$default = DescriptorUtils2.firstOverridden$default(callableMemberDescriptor, false, f23259m.new b(), 1, null);
        String strComputeJvmSignature = callableMemberDescriptorFirstOverridden$default == null ? null : methodSignatureMapping3.computeJvmSignature(callableMemberDescriptorFirstOverridden$default);
        if (strComputeJvmSignature == null) {
            return null;
        }
        return aVar.getSpecialSignatureInfo(strComputeJvmSignature);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(Name name) {
        Intrinsics3.checkNotNullParameter(name, "<this>");
        return SpecialGenericSignatures.f23195a.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(name);
    }
}
