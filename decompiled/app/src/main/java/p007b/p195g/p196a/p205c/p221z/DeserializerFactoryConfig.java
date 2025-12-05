package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.AbstractTypeResolver;
import p007b.p195g.p196a.p205c.p206a0.BeanDeserializerModifier;
import p007b.p195g.p196a.p205c.p206a0.Deserializers;
import p007b.p195g.p196a.p205c.p206a0.KeyDeserializers;
import p007b.p195g.p196a.p205c.p206a0.ValueInstantiators;
import p007b.p195g.p196a.p205c.p206a0.p208l.StdKeyDeserializers;

/* compiled from: DeserializerFactoryConfig.java */
/* renamed from: b.g.a.c.z.j, reason: use source file name */
/* loaded from: classes3.dex */
public class DeserializerFactoryConfig implements Serializable {

    /* renamed from: j */
    public static final Deserializers[] f5090j = new Deserializers[0];

    /* renamed from: k */
    public static final BeanDeserializerModifier[] f5091k = new BeanDeserializerModifier[0];

    /* renamed from: l */
    public static final AbstractTypeResolver[] f5092l = new AbstractTypeResolver[0];

    /* renamed from: m */
    public static final ValueInstantiators[] f5093m = new ValueInstantiators[0];

    /* renamed from: n */
    public static final KeyDeserializers[] f5094n = {new StdKeyDeserializers()};
    private static final long serialVersionUID = 1;
    public final Deserializers[] _additionalDeserializers = f5090j;
    public final KeyDeserializers[] _additionalKeyDeserializers = f5094n;
    public final BeanDeserializerModifier[] _modifiers = f5091k;
    public final AbstractTypeResolver[] _abstractTypeResolvers = f5092l;
    public final ValueInstantiators[] _valueInstantiators = f5093m;
}
