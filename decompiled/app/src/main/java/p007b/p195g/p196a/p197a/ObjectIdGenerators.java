package p007b.p195g.p196a.p197a;

/* compiled from: ObjectIdGenerators.java */
/* renamed from: b.g.a.a.j0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ObjectIdGenerators<T> extends ObjectIdGenerator<T> {
    public final Class<?> _scope;

    public ObjectIdGenerators(Class<?> cls) {
        this._scope = cls;
    }

    @Override // p007b.p195g.p196a.p197a.ObjectIdGenerator
    /* renamed from: a */
    public boolean mo1608a(ObjectIdGenerator<?> objectIdGenerator) {
        return objectIdGenerator.getClass() == getClass() && objectIdGenerator.mo1611d() == this._scope;
    }

    @Override // p007b.p195g.p196a.p197a.ObjectIdGenerator
    /* renamed from: d */
    public final Class<?> mo1611d() {
        return this._scope;
    }
}
