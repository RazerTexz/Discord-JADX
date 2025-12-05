package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;
import p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* compiled from: BeanAsArraySerializer.java */
/* renamed from: b.g.a.c.g0.t.b, reason: use source file name */
/* loaded from: classes3.dex */
public class BeanAsArraySerializer extends BeanSerializerBase {
    private static final long serialVersionUID = 1;
    public final BeanSerializerBase _defaultSerializer;

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase, set, set2);
        this._defaultSerializer = beanSerializerBase;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public final void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
            BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
            if (beanPropertyWriterArr == null || serializerProvider._serializationView == null) {
                beanPropertyWriterArr = this._props;
            }
            if (beanPropertyWriterArr.length == 1) {
                m2019z(obj, jsonGenerator, serializerProvider);
                return;
            }
        }
        jsonGenerator.mo1646X(obj);
        m2019z(obj, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        if (this._objectIdWriter != null) {
            m2053p(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        WritableTypeId writableTypeIdM2055r = m2055r(typeSerializer, obj, JsonToken2.START_ARRAY);
        typeSerializer.mo1959e(jsonGenerator, writableTypeIdM2055r);
        jsonGenerator.mo1654e(obj);
        m2019z(obj, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdM2055r);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: h */
    public JsonSerializer<Object> mo1984h(NameTransformer4 nameTransformer4) {
        return this._defaultSerializer.mo1984h(nameTransformer4);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: s */
    public BeanSerializerBase mo1985s() {
        return this;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("BeanAsArraySerializer for ");
        sbM833U.append(this._handledType.getName());
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: v */
    public BeanSerializerBase mo1986v(Set set, Set set2) {
        return new BeanAsArraySerializer(this, (Set<String>) set, (Set<String>) set2);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: w */
    public BeanSerializerBase mo1987w(Object obj) {
        return new BeanAsArraySerializer(this, this._objectIdWriter, obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: x */
    public BeanSerializerBase mo1988x(ObjectIdWriter objectIdWriter) {
        return this._defaultSerializer.mo1988x(objectIdWriter);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: y */
    public BeanSerializerBase mo1989y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return this;
    }

    /* renamed from: z */
    public final void m2019z(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
        if (beanPropertyWriterArr == null || serializerProvider._serializationView == null) {
            beanPropertyWriterArr = this._props;
        }
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter == null) {
                    jsonGenerator.mo1631A();
                } else {
                    beanPropertyWriter.mo1982h(obj, jsonGenerator, serializerProvider);
                }
                i++;
            }
        } catch (Exception e) {
            m2077o(serializerProvider, e, obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i]._name._value : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.m8743e(new JsonMappingException.C10677a(obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i]._name._value : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase, objectIdWriter, obj);
        this._defaultSerializer = beanSerializerBase;
    }

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase) {
        super(beanSerializerBase, (ObjectIdWriter) null, beanSerializerBase._propertyFilterId);
        this._defaultSerializer = beanSerializerBase;
    }
}
