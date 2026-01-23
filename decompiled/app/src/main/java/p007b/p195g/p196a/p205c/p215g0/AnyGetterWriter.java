package p007b.p195g.p196a.p205c.p215g0;

import java.util.Map;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p215g0.p217u.MapSerializer2;

/* JADX INFO: renamed from: b.g.a.c.g0.a, reason: use source file name */
/* JADX INFO: compiled from: AnyGetterWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnyGetterWriter {

    /* JADX INFO: renamed from: a */
    public final BeanProperty f4784a;

    /* JADX INFO: renamed from: b */
    public final AnnotatedMember f4785b;

    /* JADX INFO: renamed from: c */
    public JsonSerializer<Object> f4786c;

    /* JADX INFO: renamed from: d */
    public MapSerializer2 f4787d;

    public AnyGetterWriter(BeanProperty beanProperty, AnnotatedMember annotatedMember, JsonSerializer<?> jsonSerializer) {
        this.f4785b = annotatedMember;
        this.f4784a = beanProperty;
        this.f4786c = jsonSerializer;
        if (jsonSerializer instanceof MapSerializer2) {
            this.f4787d = (MapSerializer2) jsonSerializer;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1970a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object objMo1889j = this.f4785b.mo1889j(obj);
        if (objMo1889j == null) {
            return;
        }
        if (!(objMo1889j instanceof Map)) {
            serializerProvider.mo1942f(this.f4784a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", this.f4785b.mo1819c(), objMo1889j.getClass().getName()));
            throw null;
        }
        MapSerializer2 mapSerializer2 = this.f4787d;
        if (mapSerializer2 != null) {
            mapSerializer2.m2085u((Map) objMo1889j, jsonGenerator, serializerProvider);
        } else {
            this.f4786c.mo1807f(objMo1889j, jsonGenerator, serializerProvider);
        }
    }
}
