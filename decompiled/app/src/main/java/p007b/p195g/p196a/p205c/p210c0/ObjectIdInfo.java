package p007b.p195g.p196a.p205c.p210c0;

import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p197a.SimpleObjectIdResolver;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: ObjectIdInfo.java */
/* renamed from: b.g.a.c.c0.a0, reason: use source file name */
/* loaded from: classes3.dex */
public class ObjectIdInfo {

    /* renamed from: a */
    public static final ObjectIdInfo f4627a = new ObjectIdInfo(PropertyName.f5030k, Object.class, null, false, null);

    /* renamed from: b */
    public final PropertyName f4628b;

    /* renamed from: c */
    public final Class<? extends ObjectIdGenerator<?>> f4629c;

    /* renamed from: d */
    public final Class<?> f4630d;

    /* renamed from: e */
    public final Class<?> f4631e;

    /* renamed from: f */
    public final boolean f4632f;

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r5v0, types: [java.lang.Class<?>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectIdInfo(PropertyName propertyName, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2, boolean z2, Class cls3) {
        this.f4628b = propertyName;
        this.f4631e = cls;
        this.f4629c = cls2;
        this.f4632f = z2;
        this.f4630d = cls3 == null ? SimpleObjectIdResolver.class : cls3;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ObjectIdInfo: propName=");
        sbM833U.append(this.f4628b);
        sbM833U.append(", scope=");
        sbM833U.append(ClassUtil.m2189u(this.f4631e));
        sbM833U.append(", generatorType=");
        sbM833U.append(ClassUtil.m2189u(this.f4629c));
        sbM833U.append(", alwaysAsId=");
        sbM833U.append(this.f4632f);
        return sbM833U.toString();
    }
}
