package p007b.p109f.p161j.p183r;

import java.util.Objects;

/* compiled from: FrescoSystrace.java */
/* renamed from: b.f.j.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FrescoSystrace {

    /* renamed from: a */
    public static volatile a f4266a;

    /* compiled from: FrescoSystrace.java */
    /* renamed from: b.f.j.r.b$a */
    public interface a {
    }

    /* renamed from: a */
    public static a m1526a() {
        if (f4266a == null) {
            synchronized (FrescoSystrace.class) {
                if (f4266a == null) {
                    f4266a = new DefaultFrescoSystrace();
                }
            }
        }
        return f4266a;
    }

    /* renamed from: b */
    public static boolean m1527b() {
        Objects.requireNonNull(m1526a());
        return false;
    }
}
