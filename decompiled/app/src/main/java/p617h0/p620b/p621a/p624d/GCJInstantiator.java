package p617h0.p620b.p621a.p624d;

import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;

/* JADX INFO: renamed from: h0.b.a.d.a, reason: use source file name */
/* JADX INFO: compiled from: GCJInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class GCJInstantiator<T> extends GCJInstantiatorBase<T> {
    public GCJInstantiator(Class<T> cls) {
        super(cls);
    }

    @Override // p617h0.p620b.p621a.ObjectInstantiator
    public T newInstance() {
        try {
            Class<T> cls = this.f26396c;
            return cls.cast(GCJInstantiatorBase.f26394a.invoke(GCJInstantiatorBase.f26395b, cls, Object.class));
        } catch (IllegalAccessException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        } catch (InvocationTargetException e3) {
            throw new ObjenesisException(e3);
        }
    }
}
