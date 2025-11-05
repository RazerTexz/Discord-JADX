package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.k;
import d0.e0.p.d.m0.f.x;
import d0.e0.p.d.m0.i.h;

/* compiled from: Flags.java */
/* loaded from: classes3.dex */
public class b {
    public static final C0555b A;
    public static final C0555b B;
    public static final C0555b C;
    public static final C0555b D;
    public static final C0555b E;
    public static final C0555b F;
    public static final C0555b G;
    public static final C0555b H;
    public static final C0555b I;
    public static final C0555b J;
    public static final C0555b K;
    public static final C0555b L;
    public static final C0555b M;
    public static final C0555b a = d.booleanFirst();

    /* renamed from: b, reason: collision with root package name */
    public static final C0555b f3412b;
    public static final d<x> c;
    public static final d<k> d;
    public static final d<c.EnumC0550c> e;
    public static final C0555b f;
    public static final C0555b g;
    public static final C0555b h;
    public static final C0555b i;
    public static final C0555b j;
    public static final C0555b k;
    public static final C0555b l;
    public static final C0555b m;
    public static final d<d0.e0.p.d.m0.f.j> n;
    public static final C0555b o;
    public static final C0555b p;
    public static final C0555b q;
    public static final C0555b r;

    /* renamed from: s, reason: collision with root package name */
    public static final C0555b f3413s;
    public static final C0555b t;
    public static final C0555b u;
    public static final C0555b v;
    public static final C0555b w;

    /* renamed from: x, reason: collision with root package name */
    public static final C0555b f3414x;

    /* renamed from: y, reason: collision with root package name */
    public static final C0555b f3415y;

    /* renamed from: z, reason: collision with root package name */
    public static final C0555b f3416z;

    /* compiled from: Flags.java */
    /* renamed from: d0.e0.p.d.m0.f.z.b$b, reason: collision with other inner class name */
    public static class C0555b extends d<Boolean> {
        public C0555b(int i) {
            super(i, 1, null);
        }

        @Override // d0.e0.p.d.m0.f.z.b.d
        public /* bridge */ /* synthetic */ Boolean get(int i) {
            return get(i);
        }

        @Override // d0.e0.p.d.m0.f.z.b.d
        public /* bridge */ /* synthetic */ int toFlags(Boolean bool) {
            return toFlags2(bool);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d0.e0.p.d.m0.f.z.b.d
        public Boolean get(int i) {
            Boolean boolValueOf = Boolean.valueOf((i & (1 << this.a)) != 0);
            if (boolValueOf != null) {
                return boolValueOf;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        /* renamed from: toFlags, reason: avoid collision after fix types in other method */
        public int toFlags2(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* compiled from: Flags.java */
    public static class c<E extends h.a> extends d<E> {
        public final E[] c;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(int i, E[] eArr) {
            int i2 = 1;
            if (eArr == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
            }
            int length = eArr.length - 1;
            if (length != 0) {
                for (int i3 = 31; i3 >= 0; i3--) {
                    if (((1 << i3) & length) != 0) {
                        i2 = 1 + i3;
                    }
                }
                StringBuilder sbU = b.d.b.a.a.U("Empty enum: ");
                sbU.append(eArr.getClass());
                throw new IllegalStateException(sbU.toString());
            }
            super(i, i2, null);
            this.c = eArr;
        }

        @Override // d0.e0.p.d.m0.f.z.b.d
        public /* bridge */ /* synthetic */ Object get(int i) {
            return get(i);
        }

        @Override // d0.e0.p.d.m0.f.z.b.d
        public /* bridge */ /* synthetic */ int toFlags(Object obj) {
            return toFlags((c<E>) obj);
        }

        @Override // d0.e0.p.d.m0.f.z.b.d
        public E get(int i) {
            int i2 = (1 << this.f3417b) - 1;
            int i3 = this.a;
            int i4 = (i & (i2 << i3)) >> i3;
            for (E e : this.c) {
                if (e.getNumber() == i4) {
                    return e;
                }
            }
            return null;
        }

        public int toFlags(E e) {
            return e.getNumber() << this.a;
        }
    }

    /* compiled from: Flags.java */
    public static abstract class d<E> {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3417b;

        public d(int i, int i2, a aVar) {
            this.a = i;
            this.f3417b = i2;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Ld0/e0/p/d/m0/i/h$a;>(Ld0/e0/p/d/m0/f/z/b$d<*>;[TE;)Ld0/e0/p/d/m0/f/z/b$d<TE;>; */
        public static d after(d dVar, h.a[] aVarArr) {
            return new c(dVar.a + dVar.f3417b, aVarArr);
        }

        public static C0555b booleanAfter(d<?> dVar) {
            return new C0555b(dVar.a + dVar.f3417b);
        }

        public static C0555b booleanFirst() {
            return new C0555b(0);
        }

        public abstract E get(int i);

        public abstract int toFlags(E e);
    }

    static {
        C0555b c0555bBooleanFirst = d.booleanFirst();
        f3412b = c0555bBooleanFirst;
        d<x> dVarAfter = d.after(c0555bBooleanFirst, x.values());
        c = dVarAfter;
        d<k> dVarAfter2 = d.after(dVarAfter, k.values());
        d = dVarAfter2;
        d<c.EnumC0550c> dVarAfter3 = d.after(dVarAfter2, c.EnumC0550c.values());
        e = dVarAfter3;
        C0555b c0555bBooleanAfter = d.booleanAfter(dVarAfter3);
        f = c0555bBooleanAfter;
        C0555b c0555bBooleanAfter2 = d.booleanAfter(c0555bBooleanAfter);
        g = c0555bBooleanAfter2;
        C0555b c0555bBooleanAfter3 = d.booleanAfter(c0555bBooleanAfter2);
        h = c0555bBooleanAfter3;
        C0555b c0555bBooleanAfter4 = d.booleanAfter(c0555bBooleanAfter3);
        i = c0555bBooleanAfter4;
        C0555b c0555bBooleanAfter5 = d.booleanAfter(c0555bBooleanAfter4);
        j = c0555bBooleanAfter5;
        k = d.booleanAfter(c0555bBooleanAfter5);
        C0555b c0555bBooleanAfter6 = d.booleanAfter(dVarAfter);
        l = c0555bBooleanAfter6;
        m = d.booleanAfter(c0555bBooleanAfter6);
        d<d0.e0.p.d.m0.f.j> dVarAfter4 = d.after(dVarAfter2, d0.e0.p.d.m0.f.j.values());
        n = dVarAfter4;
        C0555b c0555bBooleanAfter7 = d.booleanAfter(dVarAfter4);
        o = c0555bBooleanAfter7;
        C0555b c0555bBooleanAfter8 = d.booleanAfter(c0555bBooleanAfter7);
        p = c0555bBooleanAfter8;
        C0555b c0555bBooleanAfter9 = d.booleanAfter(c0555bBooleanAfter8);
        q = c0555bBooleanAfter9;
        C0555b c0555bBooleanAfter10 = d.booleanAfter(c0555bBooleanAfter9);
        r = c0555bBooleanAfter10;
        C0555b c0555bBooleanAfter11 = d.booleanAfter(c0555bBooleanAfter10);
        f3413s = c0555bBooleanAfter11;
        C0555b c0555bBooleanAfter12 = d.booleanAfter(c0555bBooleanAfter11);
        t = c0555bBooleanAfter12;
        C0555b c0555bBooleanAfter13 = d.booleanAfter(c0555bBooleanAfter12);
        u = c0555bBooleanAfter13;
        v = d.booleanAfter(c0555bBooleanAfter13);
        C0555b c0555bBooleanAfter14 = d.booleanAfter(dVarAfter4);
        w = c0555bBooleanAfter14;
        C0555b c0555bBooleanAfter15 = d.booleanAfter(c0555bBooleanAfter14);
        f3414x = c0555bBooleanAfter15;
        C0555b c0555bBooleanAfter16 = d.booleanAfter(c0555bBooleanAfter15);
        f3415y = c0555bBooleanAfter16;
        C0555b c0555bBooleanAfter17 = d.booleanAfter(c0555bBooleanAfter16);
        f3416z = c0555bBooleanAfter17;
        C0555b c0555bBooleanAfter18 = d.booleanAfter(c0555bBooleanAfter17);
        A = c0555bBooleanAfter18;
        C0555b c0555bBooleanAfter19 = d.booleanAfter(c0555bBooleanAfter18);
        B = c0555bBooleanAfter19;
        C0555b c0555bBooleanAfter20 = d.booleanAfter(c0555bBooleanAfter19);
        C = c0555bBooleanAfter20;
        C0555b c0555bBooleanAfter21 = d.booleanAfter(c0555bBooleanAfter20);
        D = c0555bBooleanAfter21;
        E = d.booleanAfter(c0555bBooleanAfter21);
        C0555b c0555bBooleanAfter22 = d.booleanAfter(c0555bBooleanFirst);
        F = c0555bBooleanAfter22;
        C0555b c0555bBooleanAfter23 = d.booleanAfter(c0555bBooleanAfter22);
        G = c0555bBooleanAfter23;
        H = d.booleanAfter(c0555bBooleanAfter23);
        C0555b c0555bBooleanAfter24 = d.booleanAfter(dVarAfter2);
        I = c0555bBooleanAfter24;
        C0555b c0555bBooleanAfter25 = d.booleanAfter(c0555bBooleanAfter24);
        J = c0555bBooleanAfter25;
        K = d.booleanAfter(c0555bBooleanAfter25);
        C0555b c0555bBooleanFirst2 = d.booleanFirst();
        L = c0555bBooleanFirst2;
        d.booleanAfter(c0555bBooleanFirst2);
        M = d.booleanFirst();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1) {
            objArr[0] = "modality";
        } else if (i2 == 2) {
            objArr[0] = "kind";
        } else if (i2 != 5) {
            if (i2 == 6) {
                objArr[0] = "memberKind";
            } else if (i2 != 8) {
                if (i2 != 9) {
                    if (i2 != 11) {
                        objArr[0] = "visibility";
                    }
                }
            }
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i2) {
            case 3:
                objArr[2] = "getConstructorFlags";
                break;
            case 4:
            case 5:
            case 6:
                objArr[2] = "getFunctionFlags";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "getPropertyFlags";
                break;
            case 10:
            case 11:
                objArr[2] = "getAccessorFlags";
                break;
            default:
                objArr[2] = "getClassFlags";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static int getAccessorFlags(boolean z2, x xVar, k kVar, boolean z3, boolean z4, boolean z5) {
        if (xVar == null) {
            a(10);
            throw null;
        }
        if (kVar != null) {
            return f3412b.toFlags2(Boolean.valueOf(z2)) | d.toFlags(kVar) | c.toFlags(xVar) | I.toFlags2(Boolean.valueOf(z3)) | J.toFlags2(Boolean.valueOf(z4)) | K.toFlags2(Boolean.valueOf(z5));
        }
        a(11);
        throw null;
    }
}
