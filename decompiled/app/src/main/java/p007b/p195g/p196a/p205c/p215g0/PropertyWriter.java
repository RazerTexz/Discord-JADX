package p007b.p195g.p196a.p205c.p215g0;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.PropertyMetadata;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p210c0.ConcreteBeanPropertyBase;

/* JADX INFO: renamed from: b.g.a.c.g0.n, reason: use source file name */
/* JADX INFO: compiled from: PropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertyWriter extends ConcreteBeanPropertyBase implements Serializable {
    private static final long serialVersionUID = 1;

    public PropertyWriter(PropertyMetadata propertyMetadata) {
        super(propertyMetadata);
    }

    public PropertyWriter(BeanPropertyDefinition beanPropertyDefinition) {
        super(beanPropertyDefinition.mo1857o());
    }

    public PropertyWriter(PropertyWriter propertyWriter) {
        super(propertyWriter);
    }
}
