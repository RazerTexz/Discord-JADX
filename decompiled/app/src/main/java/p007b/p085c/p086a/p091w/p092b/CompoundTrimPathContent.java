package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p091w.p093c.FloatKeyframeAnimation;

/* JADX INFO: renamed from: b.c.a.w.b.b, reason: use source file name */
/* JADX INFO: compiled from: CompoundTrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class CompoundTrimPathContent {

    /* JADX INFO: renamed from: a */
    public List<TrimPathContent> f2481a = new ArrayList();

    /* JADX INFO: renamed from: a */
    public void m715a(Path path) {
        for (int size = this.f2481a.size() - 1; size >= 0; size--) {
            TrimPathContent trimPathContent = this.f2481a.get(size);
            PathMeasure pathMeasure = Utils.f2309a;
            if (trimPathContent != null && !trimPathContent.f2590a) {
                Utils.m657a(path, ((FloatKeyframeAnimation) trimPathContent.f2593d).m739j() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.f2594e).m739j() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.f2595f).m739j() / 360.0f);
            }
        }
    }
}
