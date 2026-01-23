package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.b0, reason: use source file name */
/* JADX INFO: compiled from: PropertyAccessorDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertyAccessorDescriptorImpl extends DeclarationDescriptorNonRootImpl implements PropertyAccessorDescriptor {

    /* JADX INFO: renamed from: n */
    public boolean f22810n;

    /* JADX INFO: renamed from: o */
    public final boolean f22811o;

    /* JADX INFO: renamed from: p */
    public final Modality f22812p;

    /* JADX INFO: renamed from: q */
    public final PropertyDescriptor f22813q;

    /* JADX INFO: renamed from: r */
    public final boolean f22814r;

    /* JADX INFO: renamed from: s */
    public final CallableMemberDescriptor.a f22815s;

    /* JADX INFO: renamed from: t */
    public DescriptorVisibility2 f22816t;

    /* JADX INFO: renamed from: u */
    public FunctionDescriptor f22817u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyAccessorDescriptorImpl(Modality modality, DescriptorVisibility2 descriptorVisibility2, PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Name name, boolean z2, boolean z3, boolean z4, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(propertyDescriptor.getContainingDeclaration(), annotations4, name, sourceElement);
        if (modality == null) {
            m9389a(0);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            m9389a(1);
            throw null;
        }
        if (propertyDescriptor == null) {
            m9389a(2);
            throw null;
        }
        if (annotations4 == null) {
            m9389a(3);
            throw null;
        }
        if (name == null) {
            m9389a(4);
            throw null;
        }
        if (sourceElement == null) {
            m9389a(5);
            throw null;
        }
        this.f22817u = null;
        this.f22812p = modality;
        this.f22816t = descriptorVisibility2;
        this.f22813q = propertyDescriptor;
        this.f22810n = z2;
        this.f22811o = z3;
        this.f22814r = z4;
        this.f22815s = aVar;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9389a(int i) {
        String str;
        int i2;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            case 7:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public Collection<PropertyAccessorDescriptor> m9390b(boolean z2) {
        ArrayList arrayList = new ArrayList(0);
        for (PropertyDescriptor propertyDescriptor : getCorrespondingProperty().getOverriddenDescriptors()) {
            Substitutable getter = z2 ? propertyDescriptor.getGetter() : propertyDescriptor.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        return copy(declarationDescriptor, modality, descriptorVisibility2, aVar, z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor
    public PropertyDescriptor getCorrespondingProperty() {
        PropertyDescriptor propertyDescriptor = this.f22813q;
        if (propertyDescriptor != null) {
            return propertyDescriptor;
        }
        m9389a(12);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.f22817u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public CallableMemberDescriptor.a getKind() {
        CallableMemberDescriptor.a aVar = this.f22815s;
        if (aVar != null) {
            return aVar;
        }
        m9389a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.f22812p;
        if (modality != null) {
            return modality;
        }
        m9389a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public abstract PropertyAccessorDescriptor getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9389a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.a<V> aVar) {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = this.f22816t;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        m9389a(10);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor
    public boolean isDefault() {
        return this.f22810n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExternal() {
        return this.f22811o;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isInfix() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isInline() {
        return this.f22814r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isOperator() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    public void setDefault(boolean z2) {
        this.f22810n = z2;
    }

    public void setInitialSignatureDescriptor(FunctionDescriptor functionDescriptor) {
        this.f22817u = functionDescriptor;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != null) {
            return;
        }
        m9389a(14);
        throw null;
    }

    public void setVisibility(DescriptorVisibility2 descriptorVisibility2) {
        this.f22816t = descriptorVisibility2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public PropertyAccessorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public FunctionDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            throw new UnsupportedOperationException();
        }
        m9389a(7);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }
}
