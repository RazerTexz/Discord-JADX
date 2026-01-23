package p007b.p225i.p408d.p410q;

import java.lang.reflect.Modifier;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.d.q.w, reason: use source file name */
/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UnsafeAllocator5 {
    /* JADX INFO: renamed from: a */
    public static void m6872a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder sbM833U = outline.m833U("Interface can't be instantiated! Interface name: ");
            sbM833U.append(cls.getName());
            throw new UnsupportedOperationException(sbM833U.toString());
        }
        if (Modifier.isAbstract(modifiers)) {
            StringBuilder sbM833U2 = outline.m833U("Abstract class can't be instantiated! Class name: ");
            sbM833U2.append(cls.getName());
            throw new UnsupportedOperationException(sbM833U2.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract <T> T mo6871b(Class<T> cls) throws Exception;
}
