package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.p212e0.TypeIdResolver;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.e0.h.c, reason: use source file name */
/* JADX INFO: compiled from: AsExternalTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsExternalTypeSerializer extends TypeSerializerBase {

    /* JADX INFO: renamed from: c */
    public final String f4770c;

    public AsExternalTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty);
        this.f4770c = str;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: a */
    public TypeSerializer mo1955a(BeanProperty beanProperty) {
        return this.f4780b == beanProperty ? this : new AsExternalTypeSerializer(this.f4779a, beanProperty, this.f4770c);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.TypeSerializerBase, p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: b */
    public String mo1956b() {
        return this.f4770c;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: c */
    public JsonTypeInfo.a mo1957c() {
        return JsonTypeInfo.a.EXTERNAL_PROPERTY;
    }
}
