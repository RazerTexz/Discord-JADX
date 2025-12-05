package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.p215g0.BeanSerializerModifier;
import p007b.p195g.p196a.p205c.p215g0.Serializers;
import p007b.p195g.p196a.p205c.p219i0.ArrayIterator2;

/* compiled from: SerializerFactoryConfig.java */
/* renamed from: b.g.a.c.z.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class SerializerFactoryConfig implements Serializable {

    /* renamed from: j */
    public static final Serializers[] f5097j = new Serializers[0];

    /* renamed from: k */
    public static final BeanSerializerModifier[] f5098k = new BeanSerializerModifier[0];
    private static final long serialVersionUID = 1;
    public final Serializers[] _additionalKeySerializers;
    public final Serializers[] _additionalSerializers;
    public final BeanSerializerModifier[] _modifiers;

    public SerializerFactoryConfig() {
        Serializers[] serializersArr = f5097j;
        this._additionalSerializers = serializersArr;
        this._additionalKeySerializers = serializersArr;
        this._modifiers = f5098k;
    }

    /* renamed from: a */
    public boolean m2282a() {
        return this._modifiers.length > 0;
    }

    /* renamed from: b */
    public Iterable<BeanSerializerModifier> m2283b() {
        return new ArrayIterator2(this._modifiers);
    }
}
