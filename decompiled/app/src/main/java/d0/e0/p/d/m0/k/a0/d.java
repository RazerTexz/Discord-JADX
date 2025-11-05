package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.u;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MemberScope.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final a a;

    /* renamed from: b, reason: collision with root package name */
    public static int f3453b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final d m;
    public static final d n;
    public static final d o;
    public static final d p;
    public static final d q;
    public static final List<a.C0563a> r;

    /* renamed from: s, reason: collision with root package name */
    public static final List<a.C0563a> f3454s;
    public final List<c> t;
    public final int u;

    /* compiled from: MemberScope.kt */
    public static final class a {

        /* compiled from: MemberScope.kt */
        /* renamed from: d0.e0.p.d.m0.k.a0.d$a$a, reason: collision with other inner class name */
        public static final class C0563a {
            public final int a;

            /* renamed from: b, reason: collision with root package name */
            public final String f3455b;

            public C0563a(int i, String str) {
                d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.a = i;
                this.f3455b = str;
            }

            public final int getMask() {
                return this.a;
            }

            public final String getName() {
                return this.f3455b;
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$nextMask(a aVar) {
            Objects.requireNonNull(aVar);
            int iAccess$getNextMaskValue$cp = d.access$getNextMaskValue$cp();
            d.access$setNextMaskValue$cp(d.access$getNextMaskValue$cp() << 1);
            return iAccess$getNextMaskValue$cp;
        }

        public final int getALL_KINDS_MASK() {
            return d.access$getALL_KINDS_MASK$cp();
        }

        public final int getCALLABLES_MASK() {
            return d.access$getCALLABLES_MASK$cp();
        }

        public final int getCLASSIFIERS_MASK() {
            return d.access$getCLASSIFIERS_MASK$cp();
        }

        public final int getFUNCTIONS_MASK() {
            return d.access$getFUNCTIONS_MASK$cp();
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return d.access$getNON_SINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getPACKAGES_MASK() {
            return d.access$getPACKAGES_MASK$cp();
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return d.access$getSINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getTYPE_ALIASES_MASK() {
            return d.access$getTYPE_ALIASES_MASK$cp();
        }

        public final int getVALUES_MASK() {
            return d.access$getVALUES_MASK$cp();
        }

        public final int getVARIABLES_MASK() {
            return d.access$getVARIABLES_MASK$cp();
        }
    }

    static {
        a.C0563a c0563a;
        a.C0563a c0563a2;
        a aVar = new a(null);
        a = aVar;
        f3453b = 1;
        c = a.access$nextMask(aVar);
        d = a.access$nextMask(aVar);
        e = a.access$nextMask(aVar);
        f = a.access$nextMask(aVar);
        g = a.access$nextMask(aVar);
        h = a.access$nextMask(aVar);
        i = a.access$nextMask(aVar) - 1;
        j = aVar.getNON_SINGLETON_CLASSIFIERS_MASK() | aVar.getSINGLETON_CLASSIFIERS_MASK() | aVar.getTYPE_ALIASES_MASK();
        k = aVar.getSINGLETON_CLASSIFIERS_MASK() | aVar.getFUNCTIONS_MASK() | aVar.getVARIABLES_MASK();
        l = aVar.getFUNCTIONS_MASK() | aVar.getVARIABLES_MASK();
        m = new d(aVar.getALL_KINDS_MASK(), null, 2, null);
        n = new d(aVar.getCALLABLES_MASK(), null, 2, null);
        new d(aVar.getNON_SINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        new d(aVar.getSINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        new d(aVar.getTYPE_ALIASES_MASK(), null, 2, null);
        o = new d(aVar.getCLASSIFIERS_MASK(), null, 2, null);
        new d(aVar.getPACKAGES_MASK(), null, 2, null);
        p = new d(aVar.getFUNCTIONS_MASK(), null, 2, null);
        q = new d(aVar.getVARIABLES_MASK(), null, 2, null);
        new d(aVar.getVALUES_MASK(), null, 2, null);
        Field[] fields = d.class.getFields();
        d0.z.d.m.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int kindMask = dVar.getKindMask();
                String name = field2.getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "field.name");
                c0563a2 = new a.C0563a(kindMask, name);
            } else {
                c0563a2 = null;
            }
            if (c0563a2 != null) {
                arrayList2.add(c0563a2);
            }
        }
        r = arrayList2;
        Field[] fields2 = d.class.getFields();
        d0.z.d.m.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (d0.z.d.m.areEqual(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                d0.z.d.m.checkNotNullExpressionValue(name2, "field.name");
                c0563a = new a.C0563a(iIntValue, name2);
            } else {
                c0563a = null;
            }
            if (c0563a != null) {
                arrayList5.add(c0563a);
            }
        }
        f3454s = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i2, List<? extends c> list) {
        d0.z.d.m.checkNotNullParameter(list, "excludes");
        this.t = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i2 &= ~((c) it.next()).getFullyExcludedDescriptorKinds();
        }
        this.u = i2;
    }

    public static final /* synthetic */ int access$getALL_KINDS_MASK$cp() {
        return i;
    }

    public static final /* synthetic */ int access$getCALLABLES_MASK$cp() {
        return l;
    }

    public static final /* synthetic */ int access$getCLASSIFIERS_MASK$cp() {
        return j;
    }

    public static final /* synthetic */ int access$getFUNCTIONS_MASK$cp() {
        return g;
    }

    public static final /* synthetic */ int access$getNON_SINGLETON_CLASSIFIERS_MASK$cp() {
        return c;
    }

    public static final /* synthetic */ int access$getNextMaskValue$cp() {
        return f3453b;
    }

    public static final /* synthetic */ int access$getPACKAGES_MASK$cp() {
        return f;
    }

    public static final /* synthetic */ int access$getSINGLETON_CLASSIFIERS_MASK$cp() {
        return d;
    }

    public static final /* synthetic */ int access$getTYPE_ALIASES_MASK$cp() {
        return e;
    }

    public static final /* synthetic */ int access$getVALUES_MASK$cp() {
        return k;
    }

    public static final /* synthetic */ int access$getVARIABLES_MASK$cp() {
        return h;
    }

    public static final /* synthetic */ void access$setNextMaskValue$cp(int i2) {
        f3453b = i2;
    }

    public final boolean acceptsKinds(int i2) {
        return (i2 & this.u) != 0;
    }

    public final List<c> getExcludes() {
        return this.t;
    }

    public final int getKindMask() {
        return this.u;
    }

    public final d restrictedToKindsOrNull(int i2) {
        int i3 = i2 & this.u;
        if (i3 == 0) {
            return null;
        }
        return new d(i3, this.t);
    }

    public String toString() {
        Object next;
        Iterator<T> it = r.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((a.C0563a) next).getMask() == getKindMask()) {
                break;
            }
        }
        a.C0563a c0563a = (a.C0563a) next;
        String name = c0563a == null ? null : c0563a.getName();
        if (name == null) {
            List<a.C0563a> list = f3454s;
            ArrayList arrayList = new ArrayList();
            for (a.C0563a c0563a2 : list) {
                String name2 = acceptsKinds(c0563a2.getMask()) ? c0563a2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = u.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder sbY = b.d.b.a.a.Y("DescriptorKindFilter(", name, ", ");
        sbY.append(this.t);
        sbY.append(')');
        return sbY.toString();
    }

    public /* synthetic */ d(int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? d0.t.n.emptyList() : list);
    }
}
