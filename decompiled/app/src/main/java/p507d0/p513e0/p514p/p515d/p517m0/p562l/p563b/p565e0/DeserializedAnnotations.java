package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: DeserializedAnnotations.kt */
/* renamed from: d0.e0.p.d.m0.l.b.e0.a, reason: use source file name */
/* loaded from: classes3.dex */
public class DeserializedAnnotations implements Annotations4 {

    /* renamed from: j */
    public static final /* synthetic */ KProperty<Object>[] f24521j = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DeserializedAnnotations.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* renamed from: k */
    public final storage5 f24522k;

    public DeserializedAnnotations(StorageManager storageManager, Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "compute");
        this.f24522k = storageManager.createLazyValue(function0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        return Annotations4.b.findAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        return Annotations4.b.hasAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean isEmpty() {
        return ((List) storage7.getValue(this.f24522k, this, (KProperty<?>) f24521j[0])).isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return ((List) storage7.getValue(this.f24522k, this, (KProperty<?>) f24521j[0])).iterator();
    }
}
