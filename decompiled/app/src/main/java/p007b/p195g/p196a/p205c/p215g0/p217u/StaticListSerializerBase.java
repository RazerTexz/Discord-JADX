package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.g0.u.h0, reason: use source file name */
/* JADX INFO: compiled from: StaticListSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements ContextualSerializer {
    public final Boolean _unwrapSingle;

    public StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._unwrapSingle = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerMo2000H;
        Object objMo1775c;
        if (beanProperty != null) {
            AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
            AnnotatedMember member = beanProperty.getMember();
            jsonSerializerMo2000H = (member == null || (objMo1775c = annotationIntrospectorM2257v.mo1775c(member)) == null) ? null : serializerProvider.mo2000H(member, objMo1775c);
        }
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        Boolean boolM1598b = dVarM2074l != null ? dVarM2074l.m1598b(JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        JsonSerializer<?> jsonSerializerM2073k = m2073k(serializerProvider, beanProperty, jsonSerializerMo2000H);
        if (jsonSerializerM2073k == null) {
            jsonSerializerM2073k = serializerProvider.m2250n(String.class, beanProperty);
        }
        return ClassUtil.m2187s(jsonSerializerM2073k) ? Objects.equals(boolM1598b, this._unwrapSingle) ? this : mo2025p(beanProperty, boolM1598b) : new CollectionSerializer2(serializerProvider.m1938b(String.class), true, null, jsonSerializerM2073k);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        Collection collection = (Collection) obj;
        return collection == null || collection.size() == 0;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public /* bridge */ /* synthetic */ void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        mo2026q((Collection) obj, jsonGenerator, serializerProvider, typeSerializer);
    }

    /* JADX INFO: renamed from: p */
    public abstract JsonSerializer<?> mo2025p(BeanProperty beanProperty, Boolean bool);

    /* JADX INFO: renamed from: q */
    public abstract void mo2026q(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException;

    public StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, Boolean bool) {
        super(staticListSerializerBase);
        this._unwrapSingle = bool;
    }
}
