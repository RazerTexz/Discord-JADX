package p007b.p085c.p086a.p095y.p097l;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.MergePathsContent;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.y.l.g, reason: use source file name */
/* JADX INFO: compiled from: MergePaths.java */
/* JADX INFO: loaded from: classes.dex */
public class MergePaths implements ContentModel2 {

    /* JADX INFO: renamed from: a */
    public final String f2771a;

    /* JADX INFO: renamed from: b */
    public final a f2772b;

    /* JADX INFO: renamed from: c */
    public final boolean f2773c;

    /* JADX INFO: renamed from: b.c.a.y.l.g$a */
    /* JADX INFO: compiled from: MergePaths.java */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS
    }

    public MergePaths(String str, a aVar, boolean z2) {
        this.f2771a = str;
        this.f2772b = aVar;
        this.f2773c = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    @Nullable
    /* JADX INFO: renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        if (lottieDrawable.f2382w) {
            return new MergePathsContent(this);
        }
        Logger2.m640b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("MergePaths{mode=");
        sbM833U.append(this.f2772b);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
