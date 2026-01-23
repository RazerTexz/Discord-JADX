package p617h0.p620b.p621a.p626f;

import java.lang.reflect.Field;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.ObjectInstantiator;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: h0.b.a.f.b, reason: use source file name */
/* JADX INFO: compiled from: UnsafeFactoryInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnsafeFactoryInstantiator<T> implements ObjectInstantiator<T> {

    /* JADX INFO: renamed from: a */
    public static Unsafe f26400a;

    /* JADX INFO: renamed from: b */
    public final Class<T> f26401b;

    public UnsafeFactoryInstantiator(Class<T> cls) {
        if (f26400a == null) {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                try {
                    f26400a = (Unsafe) declaredField.get(null);
                } catch (IllegalAccessException e) {
                    throw new ObjenesisException(e);
                }
            } catch (NoSuchFieldException e2) {
                throw new ObjenesisException(e2);
            }
        }
        this.f26401b = cls;
    }

    @Override // p617h0.p620b.p621a.ObjectInstantiator
    public T newInstance() {
        try {
            Class<T> cls = this.f26401b;
            return cls.cast(f26400a.allocateInstance(cls));
        } catch (InstantiationException e) {
            throw new ObjenesisException(e);
        }
    }
}
