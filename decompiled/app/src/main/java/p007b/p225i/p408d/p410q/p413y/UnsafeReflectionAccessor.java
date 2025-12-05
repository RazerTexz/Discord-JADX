package p007b.p225i.p408d.p410q.p413y;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: UnsafeReflectionAccessor.java */
/* renamed from: b.i.d.q.y.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class UnsafeReflectionAccessor extends ReflectionAccessor {

    /* renamed from: b */
    public static Class f13149b;

    /* renamed from: c */
    public final Object f13150c;

    /* renamed from: d */
    public final Field f13151d;

    public UnsafeReflectionAccessor() {
        Object obj;
        Field declaredField = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f13149b = cls;
            Field declaredField2 = cls.getDeclaredField("theUnsafe");
            declaredField2.setAccessible(true);
            obj = declaredField2.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.f13150c = obj;
        try {
            declaredField = AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused2) {
        }
        this.f13151d = declaredField;
    }

    @Override // p007b.p225i.p408d.p410q.p413y.ReflectionAccessor
    /* renamed from: a */
    public void mo6912a(AccessibleObject accessibleObject) {
        boolean z2 = false;
        if (this.f13150c != null && this.f13151d != null) {
            try {
                f13149b.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f13150c, accessibleObject, Long.valueOf(((Long) f13149b.getMethod("objectFieldOffset", Field.class).invoke(this.f13150c, this.f13151d)).longValue()), Boolean.TRUE);
                z2 = true;
            } catch (Exception unused) {
            }
        }
        if (z2) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }
}
