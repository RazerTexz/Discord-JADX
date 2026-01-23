package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.util.concurrent.atomic.AtomicReference;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p218h0.ReferenceType;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* JADX INFO: renamed from: b.g.a.c.g0.u.c, reason: use source file name */
/* JADX INFO: compiled from: AtomicReferenceSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AtomicReferenceSerializer extends ReferenceTypeSerializer<AtomicReference<?>> {
    private static final long serialVersionUID = 1;

    public AtomicReferenceSerializer(ReferenceType referenceType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(referenceType, typeSerializer, jsonSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ReferenceTypeSerializer
    /* JADX INFO: renamed from: q */
    public Object mo2046q(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ReferenceTypeSerializer
    /* JADX INFO: renamed from: r */
    public Object mo2047r(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ReferenceTypeSerializer
    /* JADX INFO: renamed from: s */
    public boolean mo2048s(AtomicReference<?> atomicReference) {
        return atomicReference.get() != null;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ReferenceTypeSerializer
    /* JADX INFO: renamed from: t */
    public ReferenceTypeSerializer<AtomicReference<?>> mo2049t(Object obj, boolean z2) {
        return new AtomicReferenceSerializer(this, this._property, this._valueTypeSerializer, this._valueSerializer, this._unwrapper, obj, z2);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ReferenceTypeSerializer
    /* JADX INFO: renamed from: u */
    public ReferenceTypeSerializer<AtomicReference<?>> mo2050u(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer4 nameTransformer4) {
        return new AtomicReferenceSerializer(this, beanProperty, typeSerializer, jsonSerializer, nameTransformer4, this._suppressableValue, this._suppressNulls);
    }

    public AtomicReferenceSerializer(AtomicReferenceSerializer atomicReferenceSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer4 nameTransformer4, Object obj, boolean z2) {
        super(atomicReferenceSerializer, beanProperty, typeSerializer, jsonSerializer, nameTransformer4, obj, z2);
    }
}
