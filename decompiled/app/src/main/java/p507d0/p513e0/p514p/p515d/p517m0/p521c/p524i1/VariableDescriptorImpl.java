package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.m0, reason: use source file name */
/* JADX INFO: compiled from: VariableDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class VariableDescriptorImpl extends DeclarationDescriptorNonRootImpl implements VariableDescriptor {

    /* JADX INFO: renamed from: n */
    public KotlinType f22906n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableDescriptorImpl(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, KotlinType kotlinType, SourceElement sourceElement) {
        super(declarationDescriptor, annotations4, name, sourceElement);
        if (declarationDescriptor == null) {
            m9417a(0);
            throw null;
        }
        if (annotations4 == null) {
            m9417a(1);
            throw null;
        }
        if (name == null) {
            m9417a(2);
            throw null;
        }
        if (sourceElement == null) {
            m9417a(3);
            throw null;
        }
        this.f22906n = kotlinType;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9417a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return null;
    }

    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type != null) {
            return type;
        }
        m9417a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueDescriptor2
    public KotlinType getType() {
        KotlinType kotlinType = this.f22906n;
        if (kotlinType != null) {
            return kotlinType;
        }
        m9417a(4);
        throw null;
    }

    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9417a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9417a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    public void setOutType(KotlinType kotlinType) {
        this.f22906n = kotlinType;
    }
}
