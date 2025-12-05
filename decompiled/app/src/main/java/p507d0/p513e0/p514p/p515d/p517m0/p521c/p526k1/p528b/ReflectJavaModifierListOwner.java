package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.Modifier;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.JavaVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.JavaVisibilities2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.JavaVisibilities3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectJavaModifierListOwner.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.t, reason: use source file name */
/* loaded from: classes3.dex */
public interface ReflectJavaModifierListOwner extends InterfaceC11586s {

    /* compiled from: ReflectJavaModifierListOwner.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.t$a */
    public static final class a {
        public static Visibility2 getVisibility(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaModifierListOwner, "this");
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            return Modifier.isPublic(modifiers) ? Visibilities.h.f22703c : Modifier.isPrivate(modifiers) ? Visibilities.e.f22700c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? JavaVisibilities3.f23008c : JavaVisibilities2.f23007c : JavaVisibilities.f23006c;
        }

        public static boolean isAbstract(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaModifierListOwner, "this");
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isFinal(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaModifierListOwner, "this");
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isStatic(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaModifierListOwner, "this");
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }
    }

    int getModifiers();
}
