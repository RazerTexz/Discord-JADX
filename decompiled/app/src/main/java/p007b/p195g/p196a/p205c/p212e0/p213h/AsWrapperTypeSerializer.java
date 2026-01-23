package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.p212e0.TypeIdResolver;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.e0.h.e, reason: use source file name */
/* JADX INFO: compiled from: AsWrapperTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsWrapperTypeSerializer extends TypeSerializerBase {
    public AsWrapperTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: a */
    public TypeSerializer mo1955a(BeanProperty beanProperty) {
        return this.f4780b == beanProperty ? this : new AsWrapperTypeSerializer(this.f4779a, beanProperty);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: c */
    public JsonTypeInfo.a mo1957c() {
        return JsonTypeInfo.a.WRAPPER_OBJECT;
    }
}
