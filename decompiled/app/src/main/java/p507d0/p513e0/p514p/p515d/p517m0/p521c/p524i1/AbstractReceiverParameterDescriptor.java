package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.TransientReceiver;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.c, reason: use source file name */
/* JADX INFO: compiled from: AbstractReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractReceiverParameterDescriptor extends DeclarationDescriptorImpl implements ReceiverParameterDescriptor {

    /* JADX INFO: renamed from: l */
    public static final Name f22818l = Name.special("<this>");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractReceiverParameterDescriptor(Annotations4 annotations4) {
        super(annotations4, f22818l);
        if (annotations4 != null) {
        } else {
            m9391a(0);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9391a(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitReceiverParameterDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public ParameterDescriptor getOriginal() {
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public Collection<? extends CallableDescriptor> getOverriddenDescriptors() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        m9391a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public KotlinType getReturnType() {
        return getType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return SourceElement.f23099a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueDescriptor2
    public KotlinType getType() {
        KotlinType type = getValue().getType();
        if (type != null) {
            return type;
        }
        m9391a(3);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9391a(2);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9391a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.f23088f;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        m9391a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public ReceiverParameterDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 == null) {
            m9391a(1);
            throw null;
        }
        if (typeSubstitutor2.isEmpty()) {
            return this;
        }
        KotlinType kotlinTypeSubstitute = getContainingDeclaration() instanceof ClassDescriptor ? typeSubstitutor2.substitute(getType(), Variance.OUT_VARIANCE) : typeSubstitutor2.substitute(getType(), Variance.INVARIANT);
        if (kotlinTypeSubstitute == null) {
            return null;
        }
        return kotlinTypeSubstitute == getType() ? this : new ReceiverParameterDescriptorImpl(getContainingDeclaration(), new TransientReceiver(kotlinTypeSubstitute), getAnnotations());
    }
}
