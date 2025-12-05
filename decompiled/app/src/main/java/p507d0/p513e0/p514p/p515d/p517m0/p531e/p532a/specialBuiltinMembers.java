package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.TypeCheckingProcedure;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: specialBuiltinMembers.kt */
/* renamed from: d0.e0.p.d.m0.e.a.d0, reason: use source file name */
/* loaded from: classes3.dex */
public final class specialBuiltinMembers {

    /* compiled from: specialBuiltinMembers.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.d0$a */
    public static final class a extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {

        /* renamed from: j */
        public static final a f23192j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            return ClassicBuiltinSpecialProperties.f23436a.hasBuiltinSpecialPropertyFqName(DescriptorUtils2.getPropertyIfAccessor(callableMemberDescriptor));
        }
    }

    /* compiled from: specialBuiltinMembers.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.d0$b */
    public static final class b extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {

        /* renamed from: j */
        public static final b f23193j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            return specialBuiltinMembers2.f23218m.isBuiltinFunctionWithDifferentNameInJvm((SimpleFunctionDescriptor) callableMemberDescriptor);
        }
    }

    /* compiled from: specialBuiltinMembers.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.d0$c */
    public static final class c extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {

        /* renamed from: j */
        public static final c f23194j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            if (KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
                specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.f23259m;
                if (specialBuiltinMembers3.getSpecialSignatureInfo(callableMemberDescriptor) != null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) != null;
    }

    public static final String getJvmMethodNameIfSpecial(CallableMemberDescriptor callableMemberDescriptor) {
        Name jvmName;
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor overriddenBuiltinWithDifferentJvmName = KotlinBuiltIns.isBuiltIn(callableMemberDescriptor) ? getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) : null;
        CallableMemberDescriptor propertyIfAccessor = overriddenBuiltinWithDifferentJvmName == null ? null : DescriptorUtils2.getPropertyIfAccessor(overriddenBuiltinWithDifferentJvmName);
        if (propertyIfAccessor == null) {
            return null;
        }
        if (propertyIfAccessor instanceof PropertyDescriptor) {
            return ClassicBuiltinSpecialProperties.f23436a.getBuiltinSpecialPropertyGetterName(propertyIfAccessor);
        }
        if (!(propertyIfAccessor instanceof SimpleFunctionDescriptor) || (jvmName = specialBuiltinMembers2.f23218m.getJvmName((SimpleFunctionDescriptor) propertyIfAccessor)) == null) {
            return null;
        }
        return jvmName.asString();
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T t) {
        Intrinsics3.checkNotNullParameter(t, "<this>");
        if (!SpecialGenericSignatures.f23195a.getORIGINAL_SHORT_NAMES().contains(t.getName()) && !BuiltinSpecialProperties.f23276a.getSPECIAL_SHORT_NAMES().contains(DescriptorUtils2.getPropertyIfAccessor(t).getName())) {
            return null;
        }
        if (t instanceof PropertyDescriptor ? true : t instanceof PropertyAccessorDescriptor) {
            return (T) DescriptorUtils2.firstOverridden$default(t, false, a.f23192j, 1, null);
        }
        if (t instanceof SimpleFunctionDescriptor) {
            return (T) DescriptorUtils2.firstOverridden$default(t, false, b.f23193j, 1, null);
        }
        return null;
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T t) {
        Intrinsics3.checkNotNullParameter(t, "<this>");
        T t2 = (T) getOverriddenBuiltinWithDifferentJvmName(t);
        if (t2 != null) {
            return t2;
        }
        specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.f23259m;
        Name name = t.getName();
        Intrinsics3.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (specialbuiltinmembers3.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (T) DescriptorUtils2.firstOverridden$default(t, false, c.f23194j, 1, null);
        }
        return null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(ClassDescriptor classDescriptor, CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(callableDescriptor, "specialCallableDescriptor");
        KotlinType4 defaultType = ((ClassDescriptor) callableDescriptor.getContainingDeclaration()).getDefaultType();
        Intrinsics3.checkNotNullExpressionValue(defaultType, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        ClassDescriptor superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(classDescriptor);
        while (true) {
            if (superClassDescriptor == null) {
                return false;
            }
            if (!(superClassDescriptor instanceof JavaClassDescriptor)) {
                if (TypeCheckingProcedure.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), defaultType) != null) {
                    return !KotlinBuiltIns.isBuiltIn(superClassDescriptor);
                }
            }
            superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(superClassDescriptor);
        }
    }

    public static final boolean isFromJava(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return DescriptorUtils2.getPropertyIfAccessor(callableMemberDescriptor).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return isFromJava(callableMemberDescriptor) || KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
    }
}
