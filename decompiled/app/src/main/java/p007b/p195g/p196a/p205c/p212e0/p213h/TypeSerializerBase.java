package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.p212e0.TypeIdResolver;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.e0.h.m, reason: use source file name */
/* JADX INFO: compiled from: TypeSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeSerializerBase extends TypeSerializer {

    /* JADX INFO: renamed from: a */
    public final TypeIdResolver f4779a;

    /* JADX INFO: renamed from: b */
    public final BeanProperty f4780b;

    public TypeSerializerBase(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        this.f4779a = typeIdResolver;
        this.f4780b = beanProperty;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: b */
    public String mo1956b() {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: e */
    public WritableTypeId mo1959e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
        if (writableTypeId.f4586c == null) {
            Object obj = writableTypeId.f4584a;
            Class<?> cls = writableTypeId.f4585b;
            writableTypeId.f4586c = cls == null ? this.f4779a.mo1946a(obj) : this.f4779a.mo1948c(obj, cls);
        }
        Objects.requireNonNull(jsonGenerator);
        Object obj2 = writableTypeId.f4586c;
        JsonToken2 jsonToken2 = writableTypeId.f4589f;
        String strValueOf = obj2 instanceof String ? (String) obj2 : String.valueOf(obj2);
        writableTypeId.f4590g = true;
        int i = writableTypeId.f4588e;
        JsonToken2 jsonToken22 = JsonToken2.START_OBJECT;
        if (jsonToken2 != jsonToken22) {
            C1563b.m760j(i);
            if (i == 3 || i == 4) {
                writableTypeId.f4588e = 1;
                i = 1;
            }
        }
        int iM758h = C1563b.m758h(i);
        if (iM758h == 1) {
            jsonGenerator.mo1651c0();
            jsonGenerator.mo1666y(strValueOf);
        } else {
            if (iM758h == 2) {
                jsonGenerator.mo1653d0(writableTypeId.f4584a);
                jsonGenerator.mo1666y(writableTypeId.f4587d);
                jsonGenerator.mo1658j0(strValueOf);
                return writableTypeId;
            }
            if (iM758h != 3 && iM758h != 4) {
                jsonGenerator.mo1645W();
                jsonGenerator.mo1658j0(strValueOf);
            }
        }
        if (jsonToken2 == jsonToken22) {
            jsonGenerator.mo1653d0(writableTypeId.f4584a);
        } else if (jsonToken2 == JsonToken2.START_ARRAY) {
            jsonGenerator.mo1645W();
        }
        return writableTypeId;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
    /* JADX INFO: renamed from: f */
    public WritableTypeId mo1960f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
        Objects.requireNonNull(jsonGenerator);
        JsonToken2 jsonToken2 = writableTypeId.f4589f;
        if (jsonToken2 == JsonToken2.START_OBJECT) {
            jsonGenerator.mo1664u();
        } else if (jsonToken2 == JsonToken2.START_ARRAY) {
            jsonGenerator.mo1663t();
        }
        if (writableTypeId.f4590g) {
            int iM758h = C1563b.m758h(writableTypeId.f4588e);
            if (iM758h == 0) {
                jsonGenerator.mo1663t();
            } else if (iM758h != 2 && iM758h != 3) {
                if (iM758h != 4) {
                    jsonGenerator.mo1664u();
                } else {
                    Object obj = writableTypeId.f4586c;
                    String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
                    jsonGenerator.mo1666y(writableTypeId.f4587d);
                    jsonGenerator.mo1658j0(strValueOf);
                }
            }
        }
        return writableTypeId;
    }
}
