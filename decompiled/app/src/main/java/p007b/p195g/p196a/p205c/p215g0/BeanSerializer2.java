package p007b.p195g.p196a.p205c.p215g0;

import java.io.IOException;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.p216t.BeanAsArraySerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.ObjectIdWriter;
import p007b.p195g.p196a.p205c.p215g0.p216t.UnwrappingBeanSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* compiled from: BeanSerializer.java */
/* renamed from: b.g.a.c.g0.d, reason: use source file name */
/* loaded from: classes3.dex */
public class BeanSerializer2 extends BeanSerializerBase {
    private static final long serialVersionUID = 29;

    public BeanSerializer2(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType, beanSerializerBuilder, beanPropertyWriterArr, beanPropertyWriterArr2);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public final void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (this._objectIdWriter != null) {
            jsonGenerator.mo1654e(obj);
            m2054q(obj, jsonGenerator, serializerProvider, true);
            return;
        }
        jsonGenerator.mo1653d0(obj);
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            m2056u(obj, jsonGenerator, serializerProvider);
            jsonGenerator.mo1664u();
        } else {
            if (this._filteredProps != null) {
                Class<?> cls = serializerProvider._serializationView;
            }
            m2075m(serializerProvider, obj2, obj);
            throw null;
        }
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: h */
    public JsonSerializer<Object> mo1984h(NameTransformer4 nameTransformer4) {
        return new UnwrappingBeanSerializer(this, nameTransformer4);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: s */
    public BeanSerializerBase mo1985s() {
        return (this._objectIdWriter == null && this._anyGetterWriter == null && this._propertyFilterId == null) ? new BeanAsArraySerializer(this) : this;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("BeanSerializer for ");
        sbM833U.append(this._handledType.getName());
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: v */
    public BeanSerializerBase mo1986v(Set<String> set, Set<String> set2) {
        return new BeanSerializer2(this, set, set2);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: w */
    public BeanSerializerBase mo1987w(Object obj) {
        return new BeanSerializer2(this, this._objectIdWriter, obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: x */
    public BeanSerializerBase mo1988x(ObjectIdWriter objectIdWriter) {
        return new BeanSerializer2(this, objectIdWriter, this._propertyFilterId);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* renamed from: y */
    public BeanSerializerBase mo1989y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return new BeanSerializer2(this, beanPropertyWriterArr, beanPropertyWriterArr2);
    }

    public BeanSerializer2(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase, objectIdWriter, obj);
    }

    public BeanSerializer2(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase, set, set2);
    }

    public BeanSerializer2(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase, beanPropertyWriterArr, beanPropertyWriterArr2);
    }
}
