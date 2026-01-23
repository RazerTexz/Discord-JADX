package p007b.p195g.p196a.p205c.p215g0;

import java.util.Collections;
import java.util.List;
import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p215g0.p216t.ObjectIdWriter;

/* JADX INFO: renamed from: b.g.a.c.g0.e, reason: use source file name */
/* JADX INFO: compiled from: BeanSerializerBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class BeanSerializerBuilder {

    /* JADX INFO: renamed from: a */
    public static final BeanPropertyWriter[] f4796a = new BeanPropertyWriter[0];

    /* JADX INFO: renamed from: b */
    public final BeanDescription f4797b;

    /* JADX INFO: renamed from: c */
    public SerializationConfig f4798c;

    /* JADX INFO: renamed from: d */
    public List<BeanPropertyWriter> f4799d = Collections.emptyList();

    /* JADX INFO: renamed from: e */
    public BeanPropertyWriter[] f4800e;

    /* JADX INFO: renamed from: f */
    public AnyGetterWriter f4801f;

    /* JADX INFO: renamed from: g */
    public Object f4802g;

    /* JADX INFO: renamed from: h */
    public AnnotatedMember f4803h;

    /* JADX INFO: renamed from: i */
    public ObjectIdWriter f4804i;

    public BeanSerializerBuilder(BeanDescription beanDescription) {
        this.f4797b = beanDescription;
    }

    /* JADX INFO: renamed from: a */
    public JsonSerializer<?> m1990a() {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.f4803h != null && this.f4798c.m2279q(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.f4803h.m1902f(this.f4798c.m2279q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        AnyGetterWriter anyGetterWriter = this.f4801f;
        if (anyGetterWriter != null) {
            anyGetterWriter.f4785b.m1902f(this.f4798c.m2279q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        List<BeanPropertyWriter> list = this.f4799d;
        if (list == null || list.isEmpty()) {
            if (this.f4801f == null && this.f4804i == null) {
                return null;
            }
            beanPropertyWriterArr = f4796a;
        } else {
            List<BeanPropertyWriter> list2 = this.f4799d;
            beanPropertyWriterArr = (BeanPropertyWriter[]) list2.toArray(new BeanPropertyWriter[list2.size()]);
            if (this.f4798c.m2279q(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (BeanPropertyWriter beanPropertyWriter : beanPropertyWriterArr) {
                    beanPropertyWriter._member.m1902f(this.f4798c.m2279q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
            }
        }
        BeanPropertyWriter[] beanPropertyWriterArr2 = this.f4800e;
        if (beanPropertyWriterArr2 == null || beanPropertyWriterArr2.length == this.f4799d.size()) {
            return new BeanSerializer2(this.f4797b.f4626a, this, beanPropertyWriterArr, this.f4800e);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(this.f4799d.size()), Integer.valueOf(this.f4800e.length)));
    }
}
