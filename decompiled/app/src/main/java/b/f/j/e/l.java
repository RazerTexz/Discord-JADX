package b.f.j.e;

import b.f.j.e.j;
import com.facebook.common.internal.Supplier;
import java.util.Objects;

/* compiled from: ImagePipelineExperiments.java */
/* loaded from: classes.dex */
public class l {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final d f575b;
    public final boolean c;
    public final Supplier<Boolean> d;
    public boolean e;
    public final boolean f;
    public final int g;

    /* compiled from: ImagePipelineExperiments.java */
    public static class b {
        public final j.a a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f576b;
        public Supplier<Boolean> c = new b.f.d.d.k(Boolean.FALSE);

        public b(j.a aVar) {
            this.a = aVar;
        }
    }

    /* compiled from: ImagePipelineExperiments.java */
    public static class c implements d {
    }

    /* compiled from: ImagePipelineExperiments.java */
    public interface d {
    }

    public l(b bVar, a aVar) {
        Objects.requireNonNull(bVar);
        this.a = 2048;
        this.f575b = new c();
        this.c = bVar.f576b;
        this.d = bVar.c;
        this.e = true;
        this.f = true;
        this.g = 20;
    }
}
