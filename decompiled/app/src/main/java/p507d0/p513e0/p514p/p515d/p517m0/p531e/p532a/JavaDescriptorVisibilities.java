package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.HashMap;
import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.JavaVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.JavaVisibilities2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.JavaVisibilities3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue;

/* compiled from: JavaDescriptorVisibilities.java */
/* renamed from: d0.e0.p.d.m0.e.a.w, reason: use source file name */
/* loaded from: classes3.dex */
public class JavaDescriptorVisibilities {

    /* renamed from: a */
    public static final DescriptorVisibility2 f23525a;

    /* renamed from: b */
    public static final DescriptorVisibility2 f23526b;

    /* renamed from: c */
    public static final DescriptorVisibility2 f23527c;

    /* renamed from: d */
    public static final Map<Visibility2, DescriptorVisibility2> f23528d;

    /* compiled from: JavaDescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.e.a.w$a */
    public static class a extends DescriptorVisibility {
        public a(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9524a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9524a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.m9522c(declarationDescriptorWithVisibility, declarationDescriptor);
            }
            m9524a(1);
            throw null;
        }
    }

    /* compiled from: JavaDescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.e.a.w$b */
    public static class b extends DescriptorVisibility {
        public b(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9525a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9525a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.m9521b(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            }
            m9525a(1);
            throw null;
        }
    }

    /* compiled from: JavaDescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.e.a.w$c */
    public static class c extends DescriptorVisibility {
        public c(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9526a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9526a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.m9521b(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            }
            m9526a(1);
            throw null;
        }
    }

    static {
        a aVar = new a(JavaVisibilities.f23006c);
        f23525a = aVar;
        b bVar = new b(JavaVisibilities3.f23008c);
        f23526b = bVar;
        c cVar = new c(JavaVisibilities2.f23007c);
        f23527c = cVar;
        f23528d = new HashMap();
        m9523d(aVar);
        m9523d(bVar);
        m9523d(cVar);
    }

    /* renamed from: a */
    public static /* synthetic */ void m9520a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* renamed from: b */
    public static boolean m9521b(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            m9520a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
            m9520a(1);
            throw null;
        }
        if (m9522c(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        }
        return DescriptorVisibilities.f23085c.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
    }

    /* renamed from: c */
    public static boolean m9522c(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            m9520a(2);
            throw null;
        }
        if (declarationDescriptor2 == null) {
            m9520a(3);
            throw null;
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor2, PackageFragmentDescriptor.class, false);
        return (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) ? false : true;
    }

    /* renamed from: d */
    public static void m9523d(DescriptorVisibility2 descriptorVisibility2) {
        f23528d.put(descriptorVisibility2.getDelegate(), descriptorVisibility2);
    }

    public static DescriptorVisibility2 toDescriptorVisibility(Visibility2 visibility2) {
        if (visibility2 == null) {
            m9520a(4);
            throw null;
        }
        DescriptorVisibility2 descriptorVisibility2 = f23528d.get(visibility2);
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        DescriptorVisibility2 descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(visibility2);
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        m9520a(5);
        throw null;
    }
}
