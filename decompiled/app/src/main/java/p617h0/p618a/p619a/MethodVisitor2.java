package p617h0.p618a.p619a;

/* compiled from: MethodVisitor.java */
/* renamed from: h0.a.a.q, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class MethodVisitor2 {

    /* renamed from: a */
    public final int f26262a;

    /* renamed from: b */
    public MethodVisitor2 f26263b;

    public MethodVisitor2(int i) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.f26262a = i;
        this.f26263b = null;
    }

    /* renamed from: a */
    public abstract AnnotationWriter2 mo10593a(String str, boolean z2);

    /* renamed from: b */
    public abstract void mo10594b(int i, String str, String str2, String str3);

    /* renamed from: c */
    public abstract void mo10595c(int i, int i2, Object[] objArr, int i3, Object[] objArr2);

    /* renamed from: d */
    public abstract void mo10596d(int i, int i2);

    /* renamed from: e */
    public abstract void mo10597e(int i);

    /* renamed from: f */
    public abstract AnnotationWriter2 mo10598f(int i, TypePath2 typePath2, String str, boolean z2);

    /* renamed from: g */
    public abstract void mo10599g(int i, int i2);

    /* renamed from: h */
    public abstract void mo10600h(int i, Label2 label2);

    /* renamed from: i */
    public abstract void mo10601i(Label2 label2);

    /* renamed from: j */
    public abstract void mo10602j(Object obj);

    /* renamed from: k */
    public abstract void mo10603k(int i, Label2 label2);

    /* renamed from: l */
    public abstract void mo10604l(String str, String str2, String str3, Label2 label2, Label2 label22, int i);

    /* renamed from: m */
    public abstract AnnotationWriter2 mo10605m(int i, TypePath2 typePath2, Label2[] label2Arr, Label2[] label2Arr2, int[] iArr, String str, boolean z2);

    /* renamed from: n */
    public abstract void mo10606n(int i, int i2);

    @Deprecated
    /* renamed from: o */
    public void m10607o(int i, String str, String str2, String str3) {
        if (this.f26262a >= 327680) {
            mo10608p(i, str, str2, str3, i == 185);
            return;
        }
        MethodVisitor2 methodVisitor2 = this.f26263b;
        if (methodVisitor2 != null) {
            methodVisitor2.m10607o(i, str, str2, str3);
        }
    }

    /* renamed from: p */
    public abstract void mo10608p(int i, String str, String str2, String str3, boolean z2);

    /* renamed from: q */
    public abstract void mo10609q(int i, int i2, Label2 label2, Label2... label2Arr);

    /* renamed from: r */
    public abstract AnnotationWriter2 mo10610r(int i, TypePath2 typePath2, String str, boolean z2);

    /* renamed from: s */
    public abstract void mo10611s(int i, String str);

    /* renamed from: t */
    public abstract void mo10612t(int i, int i2);
}
