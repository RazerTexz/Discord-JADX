package p007b.p195g.p196a.p205c.p206a0;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p221z.DeserializerFactoryConfig;

/* compiled from: BasicDeserializerFactory.java */
/* renamed from: b.g.a.c.a0.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    public final DeserializerFactoryConfig _factoryConfig;

    static {
        new PropertyName("@JsonUnwrapped");
    }

    public BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }
}
