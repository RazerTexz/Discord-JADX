package p007b.p225i.p408d.p410q;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: b.i.d.q.f */
/* loaded from: classes3.dex */
public class C4921f<T> implements ObjectConstructor<T> {

    /* renamed from: a */
    public final UnsafeAllocator5 f13112a;

    /* renamed from: b */
    public final /* synthetic */ Class f13113b;

    /* renamed from: c */
    public final /* synthetic */ Type f13114c;

    public C4921f(C4922g c4922g, Class cls, Type type) {
        UnsafeAllocator5 unsafeAllocator4;
        this.f13113b = cls;
        this.f13114c = type;
        try {
            Class<?> cls2 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafeAllocator4 = new UnsafeAllocator(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    unsafeAllocator4 = new UnsafeAllocator2(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    unsafeAllocator4 = new UnsafeAllocator3(declaredMethod3);
                }
            } catch (Exception unused3) {
                unsafeAllocator4 = new UnsafeAllocator4();
            }
        }
        this.f13112a = unsafeAllocator4;
    }

    @Override // p007b.p225i.p408d.p410q.ObjectConstructor
    /* renamed from: a */
    public T mo6869a() {
        try {
            return (T) this.f13112a.mo6871b(this.f13113b);
        } catch (Exception e) {
            StringBuilder sbM833U = outline.m833U("Unable to invoke no-args constructor for ");
            sbM833U.append(this.f13114c);
            sbM833U.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(sbM833U.toString(), e);
        }
    }
}
