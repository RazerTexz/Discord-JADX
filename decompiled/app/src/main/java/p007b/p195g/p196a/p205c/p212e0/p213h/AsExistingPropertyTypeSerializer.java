package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.p212e0.TypeIdResolver;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* compiled from: AsExistingPropertyTypeSerializer.java */
/* renamed from: b.g.a.c.e0.h.b, reason: use source file name */
/* loaded from: classes3.dex */
public class AsExistingPropertyTypeSerializer extends AsPropertyTypeSerializer {
    public AsExistingPropertyTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty, str);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.AsPropertyTypeSerializer, p007b.p195g.p196a.p205c.p212e0.p213h.AsArrayTypeSerializer, p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* renamed from: a */
    public /* bridge */ /* synthetic */ TypeSerializer mo1955a(BeanProperty beanProperty) {
        return m1963i(beanProperty);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.AsPropertyTypeSerializer, p007b.p195g.p196a.p205c.p212e0.p213h.AsArrayTypeSerializer, p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* renamed from: c */
    public JsonTypeInfo.a mo1957c() {
        return JsonTypeInfo.a.EXISTING_PROPERTY;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.AsPropertyTypeSerializer, p007b.p195g.p196a.p205c.p212e0.p213h.AsArrayTypeSerializer
    /* renamed from: g */
    public /* bridge */ /* synthetic */ AsArrayTypeSerializer mo1961g(BeanProperty beanProperty) {
        return m1963i(beanProperty);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.AsPropertyTypeSerializer
    /* renamed from: h */
    public /* bridge */ /* synthetic */ AsPropertyTypeSerializer mo1962h(BeanProperty beanProperty) {
        return m1963i(beanProperty);
    }

    /* renamed from: i */
    public AsExistingPropertyTypeSerializer m1963i(BeanProperty beanProperty) {
        return this.f4780b == beanProperty ? this : new AsExistingPropertyTypeSerializer(this.f4779a, beanProperty, this.f4771c);
    }
}
