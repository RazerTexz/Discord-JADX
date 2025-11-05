package b.g.a.b.q;

import java.util.HashSet;

/* compiled from: DupDetector.java */
/* loaded from: classes3.dex */
public class a {
    public final Object a;

    /* renamed from: b, reason: collision with root package name */
    public String f670b;
    public String c;
    public HashSet<String> d;

    public a(Object obj) {
        this.a = obj;
    }

    public a a() {
        return new a(this.a);
    }
}
