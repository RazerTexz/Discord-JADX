package p659s.p660a.p661a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: Atomic.kt */
/* renamed from: s.a.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Atomic2<T> extends Atomic3 {

    /* renamed from: a */
    public static final AtomicReferenceFieldUpdater f27672a = AtomicReferenceFieldUpdater.newUpdater(Atomic2.class, Object.class, "_consensus");
    public volatile Object _consensus = Atomic.f27671a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p659s.p660a.p661a.Atomic3
    /* renamed from: a */
    public final Object mo11142a(Object obj) {
        Object objMo11144c = this._consensus;
        Object obj2 = Atomic.f27671a;
        if (objMo11144c == obj2) {
            objMo11144c = mo11144c(obj);
            Object obj3 = this._consensus;
            if (obj3 != obj2) {
                objMo11144c = obj3;
            } else if (!f27672a.compareAndSet(this, obj2, objMo11144c)) {
                objMo11144c = this._consensus;
            }
        }
        mo11143b(obj, objMo11144c);
        return objMo11144c;
    }

    /* renamed from: b */
    public abstract void mo11143b(T t, Object obj);

    /* renamed from: c */
    public abstract Object mo11144c(T t);
}
