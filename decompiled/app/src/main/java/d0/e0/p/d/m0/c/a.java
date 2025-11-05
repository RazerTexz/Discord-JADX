package d0.e0.p.d.m0.c;

import java.util.Collection;
import java.util.List;

/* compiled from: CallableDescriptor.java */
/* loaded from: classes3.dex */
public interface a extends n, q, w0<a> {

    /* compiled from: CallableDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0511a<V> {
    }

    q0 getDispatchReceiverParameter();

    q0 getExtensionReceiverParameter();

    @Override // d0.e0.p.d.m0.c.m
    a getOriginal();

    Collection<? extends a> getOverriddenDescriptors();

    d0.e0.p.d.m0.n.c0 getReturnType();

    List<z0> getTypeParameters();

    <V> V getUserData(InterfaceC0511a<V> interfaceC0511a);

    List<c1> getValueParameters();

    boolean hasSynthesizedParameterNames();
}
