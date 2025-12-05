package p007b.p195g.p196a.p205c.p215g0.p216t;

import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p215g0.VirtualBeanPropertyWriter;
import p007b.p195g.p196a.p205c.p219i0.Annotations;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* compiled from: AttributePropertyWriter.java */
/* renamed from: b.g.a.c.g0.t.a, reason: use source file name */
/* loaded from: classes3.dex */
public class AttributePropertyWriter extends VirtualBeanPropertyWriter {
    private static final long serialVersionUID = 1;
    public final String _attrName;

    public AttributePropertyWriter(String str, BeanPropertyDefinition beanPropertyDefinition, Annotations annotations, JavaType javaType) {
        super(beanPropertyDefinition, annotations, javaType, null, null, null, beanPropertyDefinition.mo1850g(), null);
        this._attrName = str;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.VirtualBeanPropertyWriter
    /* renamed from: j */
    public Object mo2017j(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        return serializerProvider.m2258w(this._attrName);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.VirtualBeanPropertyWriter
    /* renamed from: k */
    public VirtualBeanPropertyWriter mo2018k(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, BeanPropertyDefinition beanPropertyDefinition, JavaType javaType) {
        throw new IllegalStateException("Should not be called on this type");
    }
}
