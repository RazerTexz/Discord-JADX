package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.Serializable;
import java.util.Objects;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* JADX INFO: renamed from: b.g.a.c.g0.t.e, reason: use source file name */
/* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FilteredBeanPropertyWriter2 extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    public final BeanPropertyWriter _delegate;
    public final Class<?> _view;

    public FilteredBeanPropertyWriter2(BeanPropertyWriter beanPropertyWriter, Class<?> cls) {
        super(beanPropertyWriter, beanPropertyWriter._name);
        this._delegate = beanPropertyWriter;
        this._view = cls;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* JADX INFO: renamed from: e */
    public void mo1979e(JsonSerializer<Object> jsonSerializer) {
        this._delegate.mo1979e(jsonSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* JADX INFO: renamed from: f */
    public void mo1980f(JsonSerializer<Object> jsonSerializer) {
        this._delegate.mo1980f(jsonSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* JADX INFO: renamed from: g */
    public BeanPropertyWriter mo1981g(NameTransformer4 nameTransformer4) {
        return new FilteredBeanPropertyWriter2(this._delegate.mo1981g(nameTransformer4), this._view);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* JADX INFO: renamed from: h */
    public void mo1982h(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Class<?> cls = serializerProvider._serializationView;
        if (cls == null || this._view.isAssignableFrom(cls)) {
            this._delegate.mo1982h(obj, jsonGenerator, serializerProvider);
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._delegate._nullSerializer;
        if (jsonSerializer != null) {
            jsonSerializer.mo1807f(null, jsonGenerator, serializerProvider);
        } else {
            jsonGenerator.mo1631A();
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* JADX INFO: renamed from: i */
    public void mo1983i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Class<?> cls = serializerProvider._serializationView;
        if (cls == null || this._view.isAssignableFrom(cls)) {
            this._delegate.mo1983i(obj, jsonGenerator, serializerProvider);
        } else {
            Objects.requireNonNull(this._delegate);
            Objects.requireNonNull(jsonGenerator);
        }
    }
}
