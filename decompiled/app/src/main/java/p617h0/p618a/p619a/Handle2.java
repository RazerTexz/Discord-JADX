package p617h0.p618a.p619a;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: Handle.java */
/* renamed from: h0.a.a.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class Handle2 {

    /* renamed from: a */
    public final int f26237a;

    /* renamed from: b */
    public final String f26238b;

    /* renamed from: c */
    public final String f26239c;

    /* renamed from: d */
    public final String f26240d;

    /* renamed from: e */
    public final boolean f26241e;

    public Handle2(int i, String str, String str2, String str3, boolean z2) {
        this.f26237a = i;
        this.f26238b = str;
        this.f26239c = str2;
        this.f26240d = str3;
        this.f26241e = z2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle2)) {
            return false;
        }
        Handle2 handle2 = (Handle2) obj;
        return this.f26237a == handle2.f26237a && this.f26241e == handle2.f26241e && this.f26238b.equals(handle2.f26238b) && this.f26239c.equals(handle2.f26239c) && this.f26240d.equals(handle2.f26240d);
    }

    public int hashCode() {
        return (this.f26240d.hashCode() * this.f26239c.hashCode() * this.f26238b.hashCode()) + this.f26237a + (this.f26241e ? 64 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f26238b);
        sb.append('.');
        sb.append(this.f26239c);
        sb.append(this.f26240d);
        sb.append(" (");
        sb.append(this.f26237a);
        return outline.m820H(sb, this.f26241e ? " itf" : "", ')');
    }
}
