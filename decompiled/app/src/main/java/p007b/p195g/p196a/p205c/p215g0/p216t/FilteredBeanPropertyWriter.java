package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.Serializable;
import java.util.Objects;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* compiled from: FilteredBeanPropertyWriter.java */
/* renamed from: b.g.a.c.g0.t.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class FilteredBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    public final BeanPropertyWriter _delegate;
    public final Class<?>[] _views;

    public FilteredBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
        super(beanPropertyWriter, beanPropertyWriter._name);
        this._delegate = beanPropertyWriter;
        this._views = clsArr;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* renamed from: e */
    public void mo1979e(JsonSerializer<Object> jsonSerializer) {
        this._delegate.mo1979e(jsonSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* renamed from: f */
    public void mo1980f(JsonSerializer<Object> jsonSerializer) {
        this._delegate.mo1980f(jsonSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* renamed from: g */
    public BeanPropertyWriter mo1981g(NameTransformer4 nameTransformer4) {
        return new FilteredBeanPropertyWriter(this._delegate.mo1981g(nameTransformer4), this._views);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* renamed from: h */
    public void mo1982h(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        if (m2020j(serializerProvider._serializationView)) {
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
    /* renamed from: i */
    public void mo1983i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        if (m2020j(serializerProvider._serializationView)) {
            this._delegate.mo1983i(obj, jsonGenerator, serializerProvider);
        } else {
            Objects.requireNonNull(this._delegate);
            Objects.requireNonNull(jsonGenerator);
        }
    }

    /* renamed from: j */
    public final boolean m2020j(Class<?> cls) {
        if (cls == null) {
            return true;
        }
        int length = this._views.length;
        for (int i = 0; i < length; i++) {
            if (this._views[i].isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}
