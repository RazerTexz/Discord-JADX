package p007b.p109f.p161j.p170e;

import com.facebook.common.internal.Supplier;
import java.util.Objects;
import p007b.p109f.p115d.p119d.Suppliers;
import p007b.p109f.p161j.p170e.ImagePipelineConfig2;

/* compiled from: ImagePipelineExperiments.java */
/* renamed from: b.f.j.e.l, reason: use source file name */
/* loaded from: classes.dex */
public class ImagePipelineExperiments {

    /* renamed from: a */
    public final int f3778a;

    /* renamed from: b */
    public final d f3779b;

    /* renamed from: c */
    public final boolean f3780c;

    /* renamed from: d */
    public final Supplier<Boolean> f3781d;

    /* renamed from: e */
    public boolean f3782e;

    /* renamed from: f */
    public final boolean f3783f;

    /* renamed from: g */
    public final int f3784g;

    /* compiled from: ImagePipelineExperiments.java */
    /* renamed from: b.f.j.e.l$b */
    public static class b {

        /* renamed from: a */
        public final ImagePipelineConfig2.a f3785a;

        /* renamed from: b */
        public boolean f3786b;

        /* renamed from: c */
        public Supplier<Boolean> f3787c = new Suppliers(Boolean.FALSE);

        public b(ImagePipelineConfig2.a aVar) {
            this.f3785a = aVar;
        }
    }

    /* compiled from: ImagePipelineExperiments.java */
    /* renamed from: b.f.j.e.l$c */
    public static class c implements d {
    }

    /* compiled from: ImagePipelineExperiments.java */
    /* renamed from: b.f.j.e.l$d */
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
