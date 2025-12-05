package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.SimpleFunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.C12027i;

/* compiled from: JavaMethodDescriptor.java */
/* renamed from: d0.e0.p.d.m0.e.a.h0.f, reason: use source file name */
/* loaded from: classes3.dex */
public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {

    /* renamed from: M */
    public static final CallableDescriptor.a<ValueParameterDescriptor> f23262M = new a();

    /* renamed from: N */
    public b f23263N;

    /* renamed from: O */
    public final boolean f23264O;

    /* compiled from: JavaMethodDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.e.a.h0.f$a */
    public static class a implements CallableDescriptor.a<ValueParameterDescriptor> {
    }

    /* compiled from: JavaMethodDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.e.a.h0.f$b */
    public enum b {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        b(boolean z2, boolean z3) {
            this.isStable = z2;
            this.isSynthesized = z3;
        }

        public static b get(boolean z2, boolean z3) {
            return z2 ? z3 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z3 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaMethodDescriptor(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations4 annotations4, Name name, CallableMemberDescriptor.a aVar, SourceElement sourceElement, boolean z2) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations4, name, aVar, sourceElement);
        if (declarationDescriptor == null) {
            m9458a(0);
            throw null;
        }
        if (annotations4 == null) {
            m9458a(1);
            throw null;
        }
        if (name == null) {
            m9458a(2);
            throw null;
        }
        if (aVar == null) {
            m9458a(3);
            throw null;
        }
        if (sourceElement == null) {
            m9458a(4);
            throw null;
        }
        this.f23263N = null;
        this.f23264O = z2;
    }

    /* renamed from: a */
    public static /* synthetic */ void m9458a(int i) {
        String str = (i == 12 || i == 17 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 17 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 12) {
            objArr[1] = "initialize";
        } else if (i == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 17 && i != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static JavaMethodDescriptor createJavaMethod(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, SourceElement sourceElement, boolean z2) {
        if (declarationDescriptor == null) {
            m9458a(5);
            throw null;
        }
        if (annotations4 == null) {
            m9458a(6);
            throw null;
        }
        if (name == null) {
            m9458a(7);
            throw null;
        }
        if (sourceElement != null) {
            return new JavaMethodDescriptor(declarationDescriptor, null, annotations4, name, CallableMemberDescriptor.a.DECLARATION, sourceElement, z2);
        }
        m9458a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.SimpleFunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    /* renamed from: b */
    public FunctionDescriptorImpl mo9373b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            m9458a(13);
            throw null;
        }
        if (aVar == null) {
            m9458a(14);
            throw null;
        }
        if (annotations4 == null) {
            m9458a(15);
            throw null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            name = getName();
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations4, name, aVar, sourceElement, this.f23264O);
        javaMethodDescriptor.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return javaMethodDescriptor;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Tuples2 tuples2) {
        return enhance(kotlinType, (List<util4>) list, kotlinType2, (Tuples2<CallableDescriptor.a<?>, ?>) tuples2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.f23263N.isStable;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.f23263N.isSynthesized;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.SimpleFunctionDescriptorImpl
    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, DescriptorVisibility2 descriptorVisibility2, Map<? extends CallableDescriptor.a<?>, ?> map) {
        if (list == null) {
            m9458a(9);
            throw null;
        }
        if (list2 == null) {
            m9458a(10);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            m9458a(11);
            throw null;
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplInitialize = super.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, kotlinType, modality, descriptorVisibility2, map);
        setOperator(C12027i.f24917a.check(simpleFunctionDescriptorImplInitialize).isSuccess());
        if (simpleFunctionDescriptorImplInitialize != null) {
            return simpleFunctionDescriptorImplInitialize;
        }
        m9458a(12);
        throw null;
    }

    public void setParameterNamesStatus(boolean z2, boolean z3) {
        this.f23263N = b.get(z2, z3);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaCallableMemberDescriptor
    public JavaMethodDescriptor enhance(KotlinType kotlinType, List<util4> list, KotlinType kotlinType2, Tuples2<CallableDescriptor.a<?>, ?> tuples2) {
        if (list == null) {
            m9458a(18);
            throw null;
        }
        if (kotlinType2 == null) {
            m9458a(19);
            throw null;
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(util3.copyValueParameters(list, getValueParameters(), this)).setReturnType(kotlinType2).setExtensionReceiverParameter(kotlinType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(this, kotlinType, Annotations4.f22735f.getEMPTY())).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (tuples2 != null) {
            javaMethodDescriptor.putInUserDataMap(tuples2.getFirst(), tuples2.getSecond());
        }
        if (javaMethodDescriptor != null) {
            return javaMethodDescriptor;
        }
        m9458a(20);
        throw null;
    }
}
