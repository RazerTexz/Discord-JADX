package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.lang.reflect.Method;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p197a.ObjectIdGenerators3;
import p007b.p195g.p196a.p205c.p210c0.ObjectIdInfo;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;

/* JADX INFO: renamed from: b.g.a.c.g0.t.k, reason: use source file name */
/* JADX INFO: compiled from: PropertyBasedObjectIdGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyBasedObjectIdGenerator extends ObjectIdGenerators3 {
    private static final long serialVersionUID = 1;
    public final BeanPropertyWriter _property;

    public PropertyBasedObjectIdGenerator(Class<?> cls, BeanPropertyWriter beanPropertyWriter) {
        super(cls);
        this._property = beanPropertyWriter;
    }

    @Override // p007b.p195g.p196a.p197a.ObjectIdGenerators, p007b.p195g.p196a.p197a.ObjectIdGenerator
    /* JADX INFO: renamed from: a */
    public boolean mo1608a(ObjectIdGenerator<?> objectIdGenerator) {
        if (objectIdGenerator.getClass() != PropertyBasedObjectIdGenerator.class) {
            return false;
        }
        PropertyBasedObjectIdGenerator propertyBasedObjectIdGenerator = (PropertyBasedObjectIdGenerator) objectIdGenerator;
        return propertyBasedObjectIdGenerator._scope == this._scope && propertyBasedObjectIdGenerator._property == this._property;
    }

    @Override // p007b.p195g.p196a.p197a.ObjectIdGenerator
    /* JADX INFO: renamed from: b */
    public ObjectIdGenerator<Object> mo1609b(Class<?> cls) {
        return cls == this._scope ? this : new PropertyBasedObjectIdGenerator(cls, this._property);
    }

    @Override // p007b.p195g.p196a.p197a.ObjectIdGenerator
    /* JADX INFO: renamed from: c */
    public Object mo1610c(Object obj) {
        try {
            BeanPropertyWriter beanPropertyWriter = this._property;
            Method method = beanPropertyWriter.f4792l;
            return method == null ? beanPropertyWriter.f4793m.get(obj) : method.invoke(obj, null);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder sbM833U = outline.m833U("Problem accessing property '");
            sbM833U.append(this._property._name._value);
            sbM833U.append("': ");
            sbM833U.append(e2.getMessage());
            throw new IllegalStateException(sbM833U.toString(), e2);
        }
    }

    @Override // p007b.p195g.p196a.p197a.ObjectIdGenerator
    /* JADX INFO: renamed from: e */
    public ObjectIdGenerator<Object> mo1612e(Object obj) {
        return this;
    }

    public PropertyBasedObjectIdGenerator(ObjectIdInfo objectIdInfo, BeanPropertyWriter beanPropertyWriter) {
        super(objectIdInfo.f4631e);
        this._property = beanPropertyWriter;
    }
}
