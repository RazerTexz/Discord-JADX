package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: StringArraySerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.t.n, reason: use source file name */
/* loaded from: classes3.dex */
public class StringArraySerializer2 extends ArraySerializerBase<String[]> implements ContextualSerializer {

    /* renamed from: k */
    public static final StringArraySerializer2 f4843k;
    public final JsonSerializer<Object> _elementSerializer;

    static {
        TypeFactory.f4925k.m2168j(String.class);
        f4843k = new StringArraySerializer2();
    }

    public StringArraySerializer2() {
        super(String[].class);
        this._elementSerializer = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerMo2000H;
        Object objMo1775c;
        if (beanProperty != null) {
            AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
            AnnotatedMember member = beanProperty.getMember();
            jsonSerializerMo2000H = (member == null || (objMo1775c = annotationIntrospectorM2257v.mo1775c(member)) == null) ? null : serializerProvider.mo2000H(member, objMo1775c);
        }
        JsonFormat.a aVar = JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED;
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, String[].class);
        Boolean boolM1598b = dVarM2074l != null ? dVarM2074l.m1598b(aVar) : null;
        if (jsonSerializerMo2000H == null) {
            jsonSerializerMo2000H = this._elementSerializer;
        }
        JsonSerializer<?> jsonSerializerM2073k = m2073k(serializerProvider, beanProperty, jsonSerializerMo2000H);
        if (jsonSerializerM2073k == null) {
            jsonSerializerM2073k = serializerProvider.m2250n(String.class, beanProperty);
        }
        JsonSerializer<?> jsonSerializer = ClassUtil.m2187s(jsonSerializerM2073k) ? null : jsonSerializerM2073k;
        return (jsonSerializer == this._elementSerializer && Objects.equals(boolM1598b, this._unwrapSingle)) ? this : new StringArraySerializer2(this, beanProperty, jsonSerializer, boolM1598b);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return ((String[]) obj).length == 0;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String[] strArr = (String[]) obj;
        int length = strArr.length;
        if (length == 1 && ((this._unwrapSingle == null && serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2039u(strArr, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1649b0(strArr, length);
        m2039u(strArr, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* renamed from: p */
    public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((String[]) obj).length == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
    /* renamed from: s */
    public JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool) {
        return new StringArraySerializer2(this, beanProperty, this._elementSerializer, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
    /* renamed from: t */
    public /* bridge */ /* synthetic */ void mo2038t(String[] strArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2039u(strArr, jsonGenerator, serializerProvider);
    }

    /* renamed from: u */
    public void m2039u(String[] strArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        int length = strArr.length;
        if (length == 0) {
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        int i = 0;
        if (jsonSerializer == null) {
            while (i < length) {
                if (strArr[i] == null) {
                    jsonGenerator.mo1631A();
                } else {
                    jsonGenerator.mo1658j0(strArr[i]);
                }
                i++;
            }
            return;
        }
        int length2 = strArr.length;
        while (i < length2) {
            if (strArr[i] == null) {
                serializerProvider.m2248l(jsonGenerator);
            } else {
                jsonSerializer.mo1807f(strArr[i], jsonGenerator, serializerProvider);
            }
            i++;
        }
    }

    public StringArraySerializer2(StringArraySerializer2 stringArraySerializer2, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(stringArraySerializer2, beanProperty, bool);
        this._elementSerializer = jsonSerializer;
    }
}
