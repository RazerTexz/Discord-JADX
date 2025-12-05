package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.p212e0.TypeIdResolver;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* compiled from: AsPropertyTypeSerializer.java */
/* renamed from: b.g.a.c.e0.h.d, reason: use source file name */
/* loaded from: classes3.dex */
public class AsPropertyTypeSerializer extends AsArrayTypeSerializer {

    /* renamed from: c */
    public final String f4771c;

    public AsPropertyTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty);
        this.f4771c = str;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.AsArrayTypeSerializer, p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* renamed from: a */
    public /* bridge */ /* synthetic */ TypeSerializer mo1955a(BeanProperty beanProperty) {
        return mo1962h(beanProperty);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.TypeSerializerBase, p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* renamed from: b */
    public String mo1956b() {
        return this.f4771c;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.AsArrayTypeSerializer, p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* renamed from: c */
    public JsonTypeInfo.a mo1957c() {
        return JsonTypeInfo.a.PROPERTY;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.AsArrayTypeSerializer
    /* renamed from: g */
    public /* bridge */ /* synthetic */ AsArrayTypeSerializer mo1961g(BeanProperty beanProperty) {
        return mo1962h(beanProperty);
    }

    /* renamed from: h */
    public AsPropertyTypeSerializer mo1962h(BeanProperty beanProperty) {
        return this.f4780b == beanProperty ? this : new AsPropertyTypeSerializer(this.f4779a, beanProperty, this.f4771c);
    }
}
