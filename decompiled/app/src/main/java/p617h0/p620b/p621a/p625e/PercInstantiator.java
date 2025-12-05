package p617h0.p620b.p621a.p625e;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.ObjectInstantiator;

/* compiled from: PercInstantiator.java */
/* renamed from: h0.b.a.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public class PercInstantiator<T> implements ObjectInstantiator<T> {

    /* renamed from: a */
    public final Method f26397a;

    /* renamed from: b */
    public final Object[] f26398b;

    public PercInstantiator(Class<T> cls) {
        Object[] objArr = {null, Boolean.FALSE};
        this.f26398b = objArr;
        objArr[0] = cls;
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Boolean.TYPE);
            this.f26397a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        }
    }

    @Override // p617h0.p620b.p621a.ObjectInstantiator
    public T newInstance() {
        try {
            return (T) this.f26397a.invoke(null, this.f26398b);
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
