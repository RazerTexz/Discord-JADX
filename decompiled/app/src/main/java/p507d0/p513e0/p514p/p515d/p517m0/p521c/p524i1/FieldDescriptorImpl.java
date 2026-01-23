package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.FieldDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotatedImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.p, reason: use source file name */
/* JADX INFO: compiled from: FieldDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FieldDescriptorImpl extends AnnotatedImpl implements FieldDescriptor {

    /* JADX INFO: renamed from: k */
    public final PropertyDescriptor f22921k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FieldDescriptorImpl(Annotations4 annotations4, PropertyDescriptor propertyDescriptor) {
        super(annotations4);
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "correspondingProperty");
        this.f22921k = propertyDescriptor;
    }
}
