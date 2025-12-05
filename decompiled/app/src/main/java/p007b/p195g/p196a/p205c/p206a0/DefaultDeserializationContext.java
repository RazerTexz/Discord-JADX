package p007b.p195g.p196a.p205c.p206a0;

import java.io.Serializable;
import java.util.List;
import p007b.p195g.p196a.p205c.DeserializationContext;

/* compiled from: DefaultDeserializationContext.java */
/* renamed from: b.g.a.c.a0.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DefaultDeserializationContext extends DeserializationContext implements Serializable {
    private static final long serialVersionUID = 1;
    private List<?> _objectIdResolvers;

    /* compiled from: DefaultDeserializationContext.java */
    /* renamed from: b.g.a.c.a0.d$a */
    public static final class a extends DefaultDeserializationContext {
        private static final long serialVersionUID = 1;

        public a(DeserializerFactory deserializerFactory) {
            super(deserializerFactory, null);
        }
    }

    public DefaultDeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        super(deserializerFactory, null);
    }
}
