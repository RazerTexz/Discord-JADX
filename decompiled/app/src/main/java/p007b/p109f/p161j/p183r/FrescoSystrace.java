package p007b.p109f.p161j.p183r;

import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.r.b, reason: use source file name */
/* JADX INFO: compiled from: FrescoSystrace.java */
/* JADX INFO: loaded from: classes3.dex */
public class FrescoSystrace {

    /* JADX INFO: renamed from: a */
    public static volatile a f4266a;

    /* JADX INFO: renamed from: b.f.j.r.b$a */
    /* JADX INFO: compiled from: FrescoSystrace.java */
    public interface a {
    }

    /* JADX INFO: renamed from: a */
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

    /* JADX INFO: renamed from: b */
    public static boolean m1527b() {
        Objects.requireNonNull(m1526a());
        return false;
    }
}
