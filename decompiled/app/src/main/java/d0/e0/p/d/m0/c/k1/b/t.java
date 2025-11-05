package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.e1;
import d0.e0.p.d.m0.c.f1;
import java.lang.reflect.Modifier;

/* compiled from: ReflectJavaModifierListOwner.kt */
/* loaded from: classes3.dex */
public interface t extends d0.e0.p.d.m0.e.a.k0.s {

    /* compiled from: ReflectJavaModifierListOwner.kt */
    public static final class a {
        public static f1 getVisibility(t tVar) {
            d0.z.d.m.checkNotNullParameter(tVar, "this");
            int modifiers = tVar.getModifiers();
            return Modifier.isPublic(modifiers) ? e1.h.c : Modifier.isPrivate(modifiers) ? e1.e.c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? d0.e0.p.d.m0.c.j1.c.c : d0.e0.p.d.m0.c.j1.b.c : d0.e0.p.d.m0.c.j1.a.c;
        }

        public static boolean isAbstract(t tVar) {
            d0.z.d.m.checkNotNullParameter(tVar, "this");
            return Modifier.isAbstract(tVar.getModifiers());
        }

        public static boolean isFinal(t tVar) {
            d0.z.d.m.checkNotNullParameter(tVar, "this");
            return Modifier.isFinal(tVar.getModifiers());
        }

        public static boolean isStatic(t tVar) {
            d0.z.d.m.checkNotNullParameter(tVar, "this");
            return Modifier.isStatic(tVar.getModifiers());
        }
    }

    int getModifiers();
}
