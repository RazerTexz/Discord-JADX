package p007b.p109f.p161j.p170e;

import com.facebook.common.internal.Supplier;
import java.util.Objects;
import p007b.p109f.p115d.p119d.Suppliers;
import p007b.p109f.p161j.p170e.ImagePipelineConfig2;

/* JADX INFO: renamed from: b.f.j.e.l, reason: use source file name */
/* JADX INFO: compiled from: ImagePipelineExperiments.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePipelineExperiments {

    /* JADX INFO: renamed from: a */
    public final int f3778a;

    /* JADX INFO: renamed from: b */
    public final d f3779b;

    /* JADX INFO: renamed from: c */
    public final boolean f3780c;

    /* JADX INFO: renamed from: d */
    public final Supplier<Boolean> f3781d;

    /* JADX INFO: renamed from: e */
    public boolean f3782e;

    /* JADX INFO: renamed from: f */
    public final boolean f3783f;

    /* JADX INFO: renamed from: g */
    public final int f3784g;

    /* JADX INFO: renamed from: b.f.j.e.l$b */
    /* JADX INFO: compiled from: ImagePipelineExperiments.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public final ImagePipelineConfig2.a f3785a;

        /* JADX INFO: renamed from: b */
        public boolean f3786b;

        /* JADX INFO: renamed from: c */
        public Supplier<Boolean> f3787c = new Suppliers(Boolean.FALSE);

        public b(ImagePipelineConfig2.a aVar) {
            this.f3785a = aVar;
        }
    }

    /* JADX INFO: renamed from: b.f.j.e.l$c */
    /* JADX INFO: compiled from: ImagePipelineExperiments.java */
    public static class c implements d {
    }

    /* JADX INFO: renamed from: b.f.j.e.l$d */
    /* JADX INFO: compiled from: ImagePipelineExperiments.java */
    public interface d {
    }

    public ImagePipelineExperiments(b bVar, a aVar) {
        Objects.requireNonNull(bVar);
        this.f3778a = 2048;
        this.f3779b = new c();
        this.f3780c = bVar.f3786b;
        this.f3781d = bVar.f3787c;
        this.f3782e = true;
        this.f3783f = true;
        this.f3784g = 20;
    }
}
