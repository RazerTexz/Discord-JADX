package p007b.p225i.p408d.p410q;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: b.i.d.q.h */
/* loaded from: classes3.dex */
public class C4923h<T> implements ObjectConstructor<T> {

    /* renamed from: a */
    public final /* synthetic */ Constructor f13121a;

    public C4923h(C4922g c4922g, Constructor constructor) {
        this.f13121a = constructor;
    }

    @Override // p007b.p225i.p408d.p410q.ObjectConstructor
    /* renamed from: a */
    public T mo6869a() {
        try {
            return (T) this.f13121a.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            StringBuilder sbM833U = outline.m833U("Failed to invoke ");
            sbM833U.append(this.f13121a);
            sbM833U.append(" with no args");
            throw new RuntimeException(sbM833U.toString(), e2);
        } catch (InvocationTargetException e3) {
            StringBuilder sbM833U2 = outline.m833U("Failed to invoke ");
            sbM833U2.append(this.f13121a);
            sbM833U2.append(" with no args");
            throw new RuntimeException(sbM833U2.toString(), e3.getTargetException());
        }
    }
}
