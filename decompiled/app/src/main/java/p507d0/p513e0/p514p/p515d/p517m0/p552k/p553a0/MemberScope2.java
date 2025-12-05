package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MemberScope.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class MemberScope2 {

    /* renamed from: a */
    public static final a f24339a;

    /* renamed from: b */
    public static int f24340b;

    /* renamed from: c */
    public static final int f24341c;

    /* renamed from: d */
    public static final int f24342d;

    /* renamed from: e */
    public static final int f24343e;

    /* renamed from: f */
    public static final int f24344f;

    /* renamed from: g */
    public static final int f24345g;

    /* renamed from: h */
    public static final int f24346h;

    /* renamed from: i */
    public static final int f24347i;

    /* renamed from: j */
    public static final int f24348j;

    /* renamed from: k */
    public static final int f24349k;

    /* renamed from: l */
    public static final int f24350l;

    /* renamed from: m */
    public static final MemberScope2 f24351m;

    /* renamed from: n */
    public static final MemberScope2 f24352n;

    /* renamed from: o */
    public static final MemberScope2 f24353o;

    /* renamed from: p */
    public static final MemberScope2 f24354p;

    /* renamed from: q */
    public static final MemberScope2 f24355q;

    /* renamed from: r */
    public static final List<a.C13327a> f24356r;

    /* renamed from: s */
    public static final List<a.C13327a> f24357s;

    /* renamed from: t */
    public final List<MemberScope> f24358t;

    /* renamed from: u */
    public final int f24359u;

    /* compiled from: MemberScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.d$a */
    public static final class a {

        /* compiled from: MemberScope.kt */
        /* renamed from: d0.e0.p.d.m0.k.a0.d$a$a, reason: collision with other inner class name */
        public static final class C13327a {

            /* renamed from: a */
            public final int f24360a;

            /* renamed from: b */
            public final String f24361b;

            public C13327a(int i, String str) {
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.f24360a = i;
                this.f24361b = str;
            }

            public final int getMask() {
                return this.f24360a;
            }

            public final String getName() {
                return this.f24361b;
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$nextMask(a aVar) {
            Objects.requireNonNull(aVar);
            int iAccess$getNextMaskValue$cp = MemberScope2.access$getNextMaskValue$cp();
            MemberScope2.access$setNextMaskValue$cp(MemberScope2.access$getNextMaskValue$cp() << 1);
            return iAccess$getNextMaskValue$cp;
        }

        public final int getALL_KINDS_MASK() {
            return MemberScope2.access$getALL_KINDS_MASK$cp();
        }

        public final int getCALLABLES_MASK() {
            return MemberScope2.access$getCALLABLES_MASK$cp();
        }

        public final int getCLASSIFIERS_MASK() {
            return MemberScope2.access$getCLASSIFIERS_MASK$cp();
        }

        public final int getFUNCTIONS_MASK() {
            return MemberScope2.access$getFUNCTIONS_MASK$cp();
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return MemberScope2.access$getNON_SINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getPACKAGES_MASK() {
            return MemberScope2.access$getPACKAGES_MASK$cp();
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return MemberScope2.access$getSINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getTYPE_ALIASES_MASK() {
            return MemberScope2.access$getTYPE_ALIASES_MASK$cp();
        }

        public final int getVALUES_MASK() {
            return MemberScope2.access$getVALUES_MASK$cp();
        }

        public final int getVARIABLES_MASK() {
            return MemberScope2.access$getVARIABLES_MASK$cp();
        }
    }

    static {
        a.C13327a c13327a;
        a.C13327a c13327a2;
        a aVar = new a(null);
        f24339a = aVar;
        f24340b = 1;
        f24341c = a.access$nextMask(aVar);
        f24342d = a.access$nextMask(aVar);
        f24343e = a.access$nextMask(aVar);
        f24344f = a.access$nextMask(aVar);
        f24345g = a.access$nextMask(aVar);
        f24346h = a.access$nextMask(aVar);
        f24347i = a.access$nextMask(aVar) - 1;
        f24348j = aVar.getNON_SINGLETON_CLASSIFIERS_MASK() | aVar.getSINGLETON_CLASSIFIERS_MASK() | aVar.getTYPE_ALIASES_MASK();
        f24349k = aVar.getSINGLETON_CLASSIFIERS_MASK() | aVar.getFUNCTIONS_MASK() | aVar.getVARIABLES_MASK();
        f24350l = aVar.getFUNCTIONS_MASK() | aVar.getVARIABLES_MASK();
        f24351m = new MemberScope2(aVar.getALL_KINDS_MASK(), null, 2, null);
        f24352n = new MemberScope2(aVar.getCALLABLES_MASK(), null, 2, null);
        new MemberScope2(aVar.getNON_SINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        new MemberScope2(aVar.getSINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        new MemberScope2(aVar.getTYPE_ALIASES_MASK(), null, 2, null);
        f24353o = new MemberScope2(aVar.getCLASSIFIERS_MASK(), null, 2, null);
        new MemberScope2(aVar.getPACKAGES_MASK(), null, 2, null);
        f24354p = new MemberScope2(aVar.getFUNCTIONS_MASK(), null, 2, null);
        f24355q = new MemberScope2(aVar.getVARIABLES_MASK(), null, 2, null);
        new MemberScope2(aVar.getVALUES_MASK(), null, 2, null);
        Field[] fields = MemberScope2.class.getFields();
        Intrinsics3.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            MemberScope2 memberScope2 = obj instanceof MemberScope2 ? (MemberScope2) obj : null;
            if (memberScope2 != null) {
                int kindMask = memberScope2.getKindMask();
                String name = field2.getName();
                Intrinsics3.checkNotNullExpressionValue(name, "field.name");
                c13327a2 = new a.C13327a(kindMask, name);
            } else {
                c13327a2 = null;
            }
            if (c13327a2 != null) {
                arrayList2.add(c13327a2);
            }
        }
        f24356r = arrayList2;
        Field[] fields2 = MemberScope2.class.getFields();
        Intrinsics3.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (Intrinsics3.areEqual(((Field) obj2).getType(), Integer.TYPE)) {
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
                Intrinsics3.checkNotNullExpressionValue(name2, "field.name");
                c13327a = new a.C13327a(iIntValue, name2);
            } else {
                c13327a = null;
            }
            if (c13327a != null) {
                arrayList5.add(c13327a);
            }
        }
        f24357s = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MemberScope2(int i, List<? extends MemberScope> list) {
        Intrinsics3.checkNotNullParameter(list, "excludes");
        this.f24358t = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i &= ~((MemberScope) it.next()).getFullyExcludedDescriptorKinds();
        }
        this.f24359u = i;
    }

    public static final /* synthetic */ int access$getALL_KINDS_MASK$cp() {
        return f24347i;
    }

    public static final /* synthetic */ int access$getCALLABLES_MASK$cp() {
        return f24350l;
    }

    public static final /* synthetic */ int access$getCLASSIFIERS_MASK$cp() {
        return f24348j;
    }

    public static final /* synthetic */ int access$getFUNCTIONS_MASK$cp() {
        return f24345g;
    }

    public static final /* synthetic */ int access$getNON_SINGLETON_CLASSIFIERS_MASK$cp() {
        return f24341c;
    }

    public static final /* synthetic */ int access$getNextMaskValue$cp() {
        return f24340b;
    }

    public static final /* synthetic */ int access$getPACKAGES_MASK$cp() {
        return f24344f;
    }

    public static final /* synthetic */ int access$getSINGLETON_CLASSIFIERS_MASK$cp() {
        return f24342d;
    }

    public static final /* synthetic */ int access$getTYPE_ALIASES_MASK$cp() {
        return f24343e;
    }

    public static final /* synthetic */ int access$getVALUES_MASK$cp() {
        return f24349k;
    }

    public static final /* synthetic */ int access$getVARIABLES_MASK$cp() {
        return f24346h;
    }

    public static final /* synthetic */ void access$setNextMaskValue$cp(int i) {
        f24340b = i;
    }

    public final boolean acceptsKinds(int i) {
        return (i & this.f24359u) != 0;
    }

    public final List<MemberScope> getExcludes() {
        return this.f24358t;
    }

    public final int getKindMask() {
        return this.f24359u;
    }

    public final MemberScope2 restrictedToKindsOrNull(int i) {
        int i2 = i & this.f24359u;
        if (i2 == 0) {
            return null;
        }
        return new MemberScope2(i2, this.f24358t);
    }

    public String toString() {
        Object next;
        Iterator<T> it = f24356r.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((a.C13327a) next).getMask() == getKindMask()) {
                break;
            }
        }
        a.C13327a c13327a = (a.C13327a) next;
        String name = c13327a == null ? null : c13327a.getName();
        if (name == null) {
            List<a.C13327a> list = f24357s;
            ArrayList arrayList = new ArrayList();
            for (a.C13327a c13327a2 : list) {
                String name2 = acceptsKinds(c13327a2.getMask()) ? c13327a2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = _Collections.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder sbM837Y = outline.m837Y("DescriptorKindFilter(", name, ", ");
        sbM837Y.append(this.f24358t);
        sbM837Y.append(')');
        return sbM837Y.toString();
    }

    public /* synthetic */ MemberScope2(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? Collections2.emptyList() : list);
    }
}
