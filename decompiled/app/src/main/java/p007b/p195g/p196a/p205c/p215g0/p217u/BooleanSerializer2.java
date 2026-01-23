package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.e, reason: use source file name */
/* JADX INFO: compiled from: BooleanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public final class BooleanSerializer2 extends StdScalarSerializer<Object> implements ContextualSerializer {
    private static final long serialVersionUID = 1;
    public final boolean _forPrimitive;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.e$a */
    /* JADX INFO: compiled from: BooleanSerializer.java */
    public static final class a extends StdScalarSerializer<Object> implements ContextualSerializer {
        private static final long serialVersionUID = 1;
        public final boolean _forPrimitive;

        public a(boolean z2) {
            super(z2 ? Boolean.TYPE : Boolean.class, false);
            this._forPrimitive = z2;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
        /* JADX INFO: renamed from: a */
        public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, Boolean.class);
            return (dVarM2074l == null || dVarM2074l.m1601e().m1596f()) ? this : new BooleanSerializer2(this._forPrimitive);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.mo1634H(!Boolean.FALSE.equals(obj) ? 1 : 0);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StdScalarSerializer, p007b.p195g.p196a.p205c.JsonSerializer
        /* JADX INFO: renamed from: g */
        public final void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
            jsonGenerator.mo1662s(Boolean.TRUE.equals(obj));
        }
    }

    public BooleanSerializer2(boolean z2) {
        super(z2 ? Boolean.TYPE : Boolean.class, false);
        this._forPrimitive = z2;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, Boolean.class);
        return (dVarM2074l == null || !dVarM2074l.m1601e().m1596f()) ? this : new a(this._forPrimitive);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1662s(Boolean.TRUE.equals(obj));
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StdScalarSerializer, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public final void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.mo1662s(Boolean.TRUE.equals(obj));
    }
}
