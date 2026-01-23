package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.p212e0.TypeIdResolver;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.e0.h.a, reason: use source file name */
/* JADX INFO: compiled from: AsArrayTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsArrayTypeSerializer extends TypeSerializerBase {
    public AsArrayTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ TypeSerializer mo1955a(BeanProperty beanProperty) {
        return mo1961g(beanProperty);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: c */
    public JsonTypeInfo.a mo1957c() {
        return JsonTypeInfo.a.WRAPPER_ARRAY;
    }

    /* JADX INFO: renamed from: g */
    public AsArrayTypeSerializer mo1961g(BeanProperty beanProperty) {
        return this.f4780b == beanProperty ? this : new AsArrayTypeSerializer(this.f4779a, beanProperty);
    }
}
