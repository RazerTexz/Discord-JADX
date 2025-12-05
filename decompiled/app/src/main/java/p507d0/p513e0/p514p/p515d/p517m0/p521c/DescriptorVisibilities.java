package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.TypeAliasConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ImplicitClassReceiver2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.SuperCallReceiverValue;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.dynamicTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.ModuleVisibilityHelper;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Sets5;

/* compiled from: DescriptorVisibilities.java */
/* renamed from: d0.e0.p.d.m0.c.t, reason: use source file name */
/* loaded from: classes3.dex */
public class DescriptorVisibilities {

    /* renamed from: a */
    public static final DescriptorVisibility2 f23083a;

    /* renamed from: b */
    public static final DescriptorVisibility2 f23084b;

    /* renamed from: c */
    public static final DescriptorVisibility2 f23085c;

    /* renamed from: d */
    public static final DescriptorVisibility2 f23086d;

    /* renamed from: e */
    public static final DescriptorVisibility2 f23087e;

    /* renamed from: f */
    public static final DescriptorVisibility2 f23088f;

    /* renamed from: g */
    public static final DescriptorVisibility2 f23089g;

    /* renamed from: h */
    public static final DescriptorVisibility2 f23090h;

    /* renamed from: i */
    public static final DescriptorVisibility2 f23091i;

    /* renamed from: j */
    public static final Map<DescriptorVisibility2, Integer> f23092j;

    /* renamed from: k */
    public static final DescriptorVisibility2 f23093k;

    /* renamed from: l */
    public static final ReceiverValue f23094l;

    /* renamed from: m */
    public static final ReceiverValue f23095m;

    /* renamed from: n */
    @Deprecated
    public static final ReceiverValue f23096n;

    /* renamed from: o */
    public static final ModuleVisibilityHelper f23097o;

    /* renamed from: p */
    public static final Map<Visibility2, DescriptorVisibility2> f23098p;

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$a */
    public static class a implements ReceiverValue {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$b */
    public static class b implements ReceiverValue {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$c */
    public static class c implements ReceiverValue {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$d */
    public static class d extends DescriptorVisibility {
        public d(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9439a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "what";
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [d0.e0.p.d.m0.c.m, d0.e0.p.d.m0.c.q] */
        /* JADX WARN: Type inference failed for: r5v2, types: [d0.e0.p.d.m0.c.m] */
        /* JADX WARN: Type inference failed for: r5v3, types: [d0.e0.p.d.m0.c.m] */
        /* JADX WARN: Type inference failed for: r5v4, types: [d0.e0.p.d.m0.c.m] */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == 0) {
                m9439a(1);
                throw null;
            }
            if (declarationDescriptor == null) {
                m9439a(2);
                throw null;
            }
            if (DescriptorUtils.isTopLevelDeclaration(declarationDescriptorWithVisibility)) {
                if (declarationDescriptor == null) {
                    m9439a(0);
                    throw null;
                }
                if (DescriptorUtils.getContainingSourceFile(declarationDescriptor) != InterfaceC11469v0.f23100a) {
                    return DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor);
                }
            }
            if (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) {
                ClassifierDescriptorWithTypeParameters containingDeclaration = ((ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                if (DescriptorUtils.isSealedClass(containingDeclaration) && DescriptorUtils.isTopLevelDeclaration(containingDeclaration) && (declarationDescriptor instanceof ConstructorDescriptor) && DescriptorUtils.isTopLevelDeclaration(declarationDescriptor.getContainingDeclaration()) && DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor)) {
                    return true;
                }
            }
            while (declarationDescriptorWithVisibility != 0) {
                declarationDescriptorWithVisibility = declarationDescriptorWithVisibility.getContainingDeclaration();
                if (((declarationDescriptorWithVisibility instanceof ClassDescriptor) && !DescriptorUtils.isCompanionObject(declarationDescriptorWithVisibility)) || (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor)) {
                    break;
                }
            }
            if (declarationDescriptorWithVisibility == 0) {
                return false;
            }
            while (declarationDescriptor != null) {
                if (declarationDescriptorWithVisibility == declarationDescriptor) {
                    return true;
                }
                if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                    return (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) && declarationDescriptorWithVisibility.getFqName().equals(((PackageFragmentDescriptor) declarationDescriptor).getFqName()) && DescriptorUtils.areInSameModule(declarationDescriptor, declarationDescriptorWithVisibility);
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$e */
    public static class e extends DescriptorVisibility {
        public e(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9440a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor parentOfType;
            if (declarationDescriptorWithVisibility == null) {
                m9440a(0);
                throw null;
            }
            if (declarationDescriptor == null) {
                m9440a(1);
                throw null;
            }
            if (DescriptorVisibilities.f23083a.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor)) {
                if (receiverValue == DescriptorVisibilities.f23095m) {
                    return true;
                }
                if (receiverValue != DescriptorVisibilities.f23094l && (parentOfType = DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class)) != null && (receiverValue instanceof ImplicitClassReceiver2)) {
                    return ((ImplicitClassReceiver2) receiverValue).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                }
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$f */
    public static class f extends DescriptorVisibility {
        public f(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9441a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            ClassDescriptor classDescriptor;
            boolean z2 = false;
            if (declarationDescriptorWithVisibility == null) {
                m9441a(0);
                throw null;
            }
            if (declarationDescriptor == null) {
                m9441a(1);
                throw null;
            }
            ClassDescriptor classDescriptor2 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class);
            ClassDescriptor classDescriptor3 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, ClassDescriptor.class, false);
            if (classDescriptor3 == null) {
                return false;
            }
            if (classDescriptor2 != null && DescriptorUtils.isCompanionObject(classDescriptor2) && (classDescriptor = (ClassDescriptor) DescriptorUtils.getParentOfType(classDescriptor2, ClassDescriptor.class)) != null && DescriptorUtils.isSubclass(classDescriptor3, classDescriptor)) {
                return true;
            }
            DeclarationDescriptorWithVisibility declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration = DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility);
            ClassDescriptor classDescriptor4 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration, ClassDescriptor.class);
            if (classDescriptor4 == null) {
                return false;
            }
            if (DescriptorUtils.isSubclass(classDescriptor3, classDescriptor4)) {
                if (declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration == null) {
                    m9441a(2);
                    throw null;
                }
                if (receiverValue != DescriptorVisibilities.f23096n) {
                    if ((declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration instanceof CallableMemberDescriptor) && !(declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration instanceof ConstructorDescriptor) && receiverValue != DescriptorVisibilities.f23095m) {
                        if (receiverValue != DescriptorVisibilities.f23094l && receiverValue != null) {
                            KotlinType thisType = receiverValue instanceof SuperCallReceiverValue ? ((SuperCallReceiverValue) receiverValue).getThisType() : receiverValue.getType();
                            if (DescriptorUtils.isSubtypeOfClass(thisType, classDescriptor3) || dynamicTypes2.isDynamic(thisType)) {
                                z2 = true;
                            }
                        }
                    }
                }
                if (z2) {
                    return true;
                }
            }
            return isVisible(receiverValue, declarationDescriptorWithVisibility, classDescriptor3.getContainingDeclaration());
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$g */
    public static class g extends DescriptorVisibility {
        public g(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9442a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9442a(0);
                throw null;
            }
            if (declarationDescriptor == null) {
                m9442a(1);
                throw null;
            }
            if (DescriptorUtils.getContainingModule(declarationDescriptor).shouldSeeInternalsOf(DescriptorUtils.getContainingModule(declarationDescriptorWithVisibility))) {
                return DescriptorVisibilities.f23097o.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$h */
    public static class h extends DescriptorVisibility {
        public h(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9443a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9443a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return true;
            }
            m9443a(1);
            throw null;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$i */
    public static class i extends DescriptorVisibility {
        public i(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9444a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9444a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
            m9444a(1);
            throw null;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$j */
    public static class j extends DescriptorVisibility {
        public j(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9445a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9445a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                throw new IllegalStateException("Visibility is unknown yet");
            }
            m9445a(1);
            throw null;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$k */
    public static class k extends DescriptorVisibility {
        public k(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9446a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9446a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return false;
            }
            m9446a(1);
            throw null;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* renamed from: d0.e0.p.d.m0.c.t$l */
    public static class l extends DescriptorVisibility {
        public l(Visibility2 visibility2) {
            super(visibility2);
        }

        /* renamed from: a */
        public static /* synthetic */ void m9447a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                m9447a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return false;
            }
            m9447a(1);
            throw null;
        }
    }

    static {
        d dVar = new d(Visibilities.e.f22700c);
        f23083a = dVar;
        e eVar = new e(Visibilities.f.f22701c);
        f23084b = eVar;
        f fVar = new f(Visibilities.g.f22702c);
        f23085c = fVar;
        g gVar = new g(Visibilities.b.f22697c);
        f23086d = gVar;
        h hVar = new h(Visibilities.h.f22703c);
        f23087e = hVar;
        i iVar = new i(Visibilities.d.f22699c);
        f23088f = iVar;
        j jVar = new j(Visibilities.a.f22696c);
        f23089g = jVar;
        k kVar = new k(Visibilities.c.f22698c);
        f23090h = kVar;
        l lVar = new l(Visibilities.i.f22704c);
        f23091i = lVar;
        Collections.unmodifiableSet(Sets5.setOf((Object[]) new DescriptorVisibility2[]{dVar, eVar, gVar, iVar}));
        HashMap mapNewHashMapWithExpectedSize = collections.newHashMapWithExpectedSize(4);
        mapNewHashMapWithExpectedSize.put(eVar, 0);
        mapNewHashMapWithExpectedSize.put(dVar, 0);
        mapNewHashMapWithExpectedSize.put(gVar, 1);
        mapNewHashMapWithExpectedSize.put(fVar, 1);
        mapNewHashMapWithExpectedSize.put(hVar, 2);
        f23092j = Collections.unmodifiableMap(mapNewHashMapWithExpectedSize);
        f23093k = hVar;
        f23094l = new a();
        f23095m = new b();
        f23096n = new c();
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        f23097o = it.hasNext() ? (ModuleVisibilityHelper) it.next() : ModuleVisibilityHelper.a.f24915a;
        f23098p = new HashMap();
        m9438b(dVar);
        m9438b(eVar);
        m9438b(fVar);
        m9438b(gVar);
        m9438b(hVar);
        m9438b(iVar);
        m9438b(jVar);
        m9438b(kVar);
        m9438b(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void m9437a(int i2) {
        String str = i2 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 16 ? 3 : 2];
        if (i2 != 1 && i2 != 3 && i2 != 5 && i2 != 7) {
            switch (i2) {
                case 9:
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        } else {
            objArr[0] = "from";
        }
        if (i2 != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i2) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 == 16) {
            throw new IllegalStateException(str2);
        }
    }

    /* renamed from: b */
    public static void m9438b(DescriptorVisibility2 descriptorVisibility2) {
        f23098p.put(descriptorVisibility2.getDelegate(), descriptorVisibility2);
    }

    public static Integer compare(DescriptorVisibility2 descriptorVisibility2, DescriptorVisibility2 descriptorVisibility22) {
        if (descriptorVisibility2 == null) {
            m9437a(12);
            throw null;
        }
        if (descriptorVisibility22 == null) {
            m9437a(13);
            throw null;
        }
        Integer numCompareTo = descriptorVisibility2.compareTo(descriptorVisibility22);
        if (numCompareTo != null) {
            return numCompareTo;
        }
        Integer numCompareTo2 = descriptorVisibility22.compareTo(descriptorVisibility2);
        if (numCompareTo2 != null) {
            return Integer.valueOf(-numCompareTo2.intValue());
        }
        return null;
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptorWithVisibility declarationDescriptorWithVisibilityFindInvisibleMember;
        if (declarationDescriptorWithVisibility == null) {
            m9437a(8);
            throw null;
        }
        if (declarationDescriptor == null) {
            m9437a(9);
            throw null;
        }
        for (DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal(); declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != f23088f; declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class)) {
            if (!declarationDescriptorWithVisibility2.getVisibility().isVisible(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor)) {
                return declarationDescriptorWithVisibility2;
            }
        }
        if (!(declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) || (declarationDescriptorWithVisibilityFindInvisibleMember = findInvisibleMember(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor)) == null) {
            return null;
        }
        return declarationDescriptorWithVisibilityFindInvisibleMember;
    }

    public static boolean inSameFile(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            m9437a(6);
            throw null;
        }
        if (declarationDescriptor2 == null) {
            m9437a(7);
            throw null;
        }
        InterfaceC11469v0 containingSourceFile = DescriptorUtils.getContainingSourceFile(declarationDescriptor2);
        if (containingSourceFile != InterfaceC11469v0.f23100a) {
            return containingSourceFile.equals(DescriptorUtils.getContainingSourceFile(declarationDescriptor));
        }
        return false;
    }

    public static boolean isPrivate(DescriptorVisibility2 descriptorVisibility2) {
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2 == f23083a || descriptorVisibility2 == f23084b;
        }
        m9437a(14);
        throw null;
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            m9437a(2);
            throw null;
        }
        if (declarationDescriptor != null) {
            return findInvisibleMember(f23095m, declarationDescriptorWithVisibility, declarationDescriptor) == null;
        }
        m9437a(3);
        throw null;
    }

    public static DescriptorVisibility2 toDescriptorVisibility(Visibility2 visibility2) {
        if (visibility2 == null) {
            m9437a(15);
            throw null;
        }
        DescriptorVisibility2 descriptorVisibility2 = f23098p.get(visibility2);
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + visibility2);
    }
}
