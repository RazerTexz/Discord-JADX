package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.a, reason: use source file name */
/* JADX INFO: compiled from: CallableDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface CallableDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility, Substitutable<CallableDescriptor> {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.a$a */
    /* JADX INFO: compiled from: CallableDescriptor.java */
    public interface a<V> {
    }

    ReceiverParameterDescriptor getDispatchReceiverParameter();

    ReceiverParameterDescriptor getExtensionReceiverParameter();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    CallableDescriptor getOriginal();

    Collection<? extends CallableDescriptor> getOverriddenDescriptors();

    KotlinType getReturnType();

    List<TypeParameterDescriptor> getTypeParameters();

    <V> V getUserData(a<V> aVar);

    List<ValueParameterDescriptor> getValueParameters();

    boolean hasSynthesizedParameterNames();
}
