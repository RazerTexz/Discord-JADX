package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;
import p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* JADX INFO: renamed from: b.g.a.c.g0.t.t, reason: use source file name */
/* JADX INFO: compiled from: UnwrappingBeanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnwrappingBeanSerializer extends BeanSerializerBase implements Serializable {
    private static final long serialVersionUID = 1;
    public final NameTransformer4 _nameTransformer;

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, ObjectIdWriter objectIdWriter, Object obj) {
        super(unwrappingBeanSerializer, objectIdWriter, obj);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public final void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1654e(obj);
        if (this._objectIdWriter != null) {
            m2054q(obj, jsonGenerator, serializerProvider, false);
            return;
        }
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            m2056u(obj, jsonGenerator, serializerProvider);
            return;
        }
        if (this._filteredProps != null) {
            Class<?> cls = serializerProvider._serializationView;
        }
        m2075m(serializerProvider, obj2, obj);
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        if (serializerProvider.m2240D(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            serializerProvider.m1943g(this._handledType, "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        jsonGenerator.mo1654e(obj);
        if (this._objectIdWriter != null) {
            m2053p(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            m2056u(obj, jsonGenerator, serializerProvider);
        } else {
            BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
            m2075m(serializerProvider, obj2, obj);
            throw null;
        }
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: h */
    public JsonSerializer<Object> mo1984h(NameTransformer4 nameTransformer4) {
        return new UnwrappingBeanSerializer(this, nameTransformer4);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* JADX INFO: renamed from: s */
    public BeanSerializerBase mo1985s() {
        return this;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("UnwrappingBeanSerializer for ");
        sbM833U.append(this._handledType.getName());
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* JADX INFO: renamed from: v */
    public BeanSerializerBase mo1986v(Set<String> set, Set<String> set2) {
        return new UnwrappingBeanSerializer(this, set, set2);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* JADX INFO: renamed from: w */
    public BeanSerializerBase mo1987w(Object obj) {
        return new UnwrappingBeanSerializer(this, this._objectIdWriter, obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* JADX INFO: renamed from: x */
    public BeanSerializerBase mo1988x(ObjectIdWriter objectIdWriter) {
        return new UnwrappingBeanSerializer(this, objectIdWriter);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase
    /* JADX INFO: renamed from: y */
    public BeanSerializerBase mo1989y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return new UnwrappingBeanSerializer(this, beanPropertyWriterArr, beanPropertyWriterArr2);
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, Set<String> set, Set<String> set2) {
        super(unwrappingBeanSerializer, set, set2);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(unwrappingBeanSerializer, beanPropertyWriterArr, beanPropertyWriterArr2);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, ObjectIdWriter objectIdWriter) {
        super(unwrappingBeanSerializer, objectIdWriter, unwrappingBeanSerializer._propertyFilterId);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(BeanSerializerBase beanSerializerBase, NameTransformer4 nameTransformer4) {
        super(beanSerializerBase, BeanSerializerBase.m2051t(beanSerializerBase._props, nameTransformer4), BeanSerializerBase.m2051t(beanSerializerBase._filteredProps, nameTransformer4));
        this._nameTransformer = nameTransformer4;
    }
}
