package p007b.p195g.p196a.p205c.p219i0;

import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.i0.u, reason: use source file name */
/* JADX INFO: compiled from: TypeKey.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeKey {

    /* JADX INFO: renamed from: a */
    public int f4987a;

    /* JADX INFO: renamed from: b */
    public Class<?> f4988b;

    /* JADX INFO: renamed from: c */
    public JavaType f4989c;

    /* JADX INFO: renamed from: d */
    public boolean f4990d;

    public TypeKey() {
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != TypeKey.class) {
            return false;
        }
        TypeKey typeKey = (TypeKey) obj;
        if (typeKey.f4990d != this.f4990d) {
            return false;
        }
        Class<?> cls = this.f4988b;
        return cls != null ? typeKey.f4988b == cls : this.f4989c.equals(typeKey.f4989c);
    }

    public final int hashCode() {
        return this.f4987a;
    }

    public final String toString() {
        if (this.f4988b != null) {
            StringBuilder sbM833U = outline.m833U("{class: ");
            outline.m860k0(this.f4988b, sbM833U, ", typed? ");
            return outline.m827O(sbM833U, this.f4990d, "}");
        }
        StringBuilder sbM833U2 = outline.m833U("{type: ");
        sbM833U2.append(this.f4989c);
        sbM833U2.append(", typed? ");
        return outline.m827O(sbM833U2, this.f4990d, "}");
    }

    public TypeKey(Class<?> cls, boolean z2) {
        this.f4988b = cls;
        this.f4989c = null;
        this.f4990d = z2;
        this.f4987a = z2 ? cls.getName().hashCode() + 1 : cls.getName().hashCode();
    }

    public TypeKey(JavaType javaType, boolean z2) {
        int i;
        this.f4989c = javaType;
        this.f4988b = null;
        this.f4990d = z2;
        if (z2) {
            i = javaType._hash - 2;
        } else {
            i = javaType._hash - 1;
        }
        this.f4987a = i;
    }
}
