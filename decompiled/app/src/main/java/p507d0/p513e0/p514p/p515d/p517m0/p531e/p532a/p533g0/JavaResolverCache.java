package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11579l;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;

/* compiled from: JavaResolverCache.java */
/* renamed from: d0.e0.p.d.m0.e.a.g0.g, reason: use source file name */
/* loaded from: classes3.dex */
public interface JavaResolverCache {

    /* renamed from: a */
    public static final JavaResolverCache f23244a = new a();

    /* compiled from: JavaResolverCache.java */
    /* renamed from: d0.e0.p.d.m0.e.a.g0.g$a */
    public static class a implements JavaResolverCache {
        /* renamed from: a */
        public static /* synthetic */ void m9453a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public ClassDescriptor getClassResolvedFromSource(FqName fqName) {
            if (fqName != null) {
                return null;
            }
            m9453a(0);
            throw null;
        }

        public void recordClass(InterfaceC11574g interfaceC11574g, ClassDescriptor classDescriptor) {
            if (interfaceC11574g == null) {
                m9453a(7);
                throw null;
            }
            if (classDescriptor != null) {
                return;
            }
            m9453a(8);
            throw null;
        }

        public void recordConstructor(InterfaceC11579l interfaceC11579l, ConstructorDescriptor constructorDescriptor) {
            if (interfaceC11579l == null) {
                m9453a(3);
                throw null;
            }
            if (constructorDescriptor != null) {
                return;
            }
            m9453a(4);
            throw null;
        }

        public void recordField(InterfaceC11581n interfaceC11581n, PropertyDescriptor propertyDescriptor) {
            if (interfaceC11581n == null) {
                m9453a(5);
                throw null;
            }
            if (propertyDescriptor != null) {
                return;
            }
            m9453a(6);
            throw null;
        }

        public void recordMethod(InterfaceC11584q interfaceC11584q, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            if (interfaceC11584q == null) {
                m9453a(1);
                throw null;
            }
            if (simpleFunctionDescriptor != null) {
                return;
            }
            m9453a(2);
            throw null;
        }
    }
}
