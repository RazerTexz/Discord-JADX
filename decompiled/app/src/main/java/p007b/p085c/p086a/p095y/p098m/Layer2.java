package p007b.p085c.p086a.p095y.p098m;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableTextFrame;
import p007b.p085c.p086a.p095y.p096k.AnimatableTextProperties;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p097l.ContentModel2;
import p007b.p085c.p086a.p095y.p097l.Mask;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.y.m.e, reason: use source file name */
/* JADX INFO: compiled from: Layer.java */
/* JADX INFO: loaded from: classes.dex */
public class Layer2 {

    /* JADX INFO: renamed from: a */
    public final List<ContentModel2> f2868a;

    /* JADX INFO: renamed from: b */
    public final LottieComposition f2869b;

    /* JADX INFO: renamed from: c */
    public final String f2870c;

    /* JADX INFO: renamed from: d */
    public final long f2871d;

    /* JADX INFO: renamed from: e */
    public final a f2872e;

    /* JADX INFO: renamed from: f */
    public final long f2873f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public final String f2874g;

    /* JADX INFO: renamed from: h */
    public final List<Mask> f2875h;

    /* JADX INFO: renamed from: i */
    public final AnimatableTransform f2876i;

    /* JADX INFO: renamed from: j */
    public final int f2877j;

    /* JADX INFO: renamed from: k */
    public final int f2878k;

    /* JADX INFO: renamed from: l */
    public final int f2879l;

    /* JADX INFO: renamed from: m */
    public final float f2880m;

    /* JADX INFO: renamed from: n */
    public final float f2881n;

    /* JADX INFO: renamed from: o */
    public final int f2882o;

    /* JADX INFO: renamed from: p */
    public final int f2883p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public final AnimatableTextFrame f2884q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public final AnimatableTextProperties f2885r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public final AnimatableFloatValue f2886s;

    /* JADX INFO: renamed from: t */
    public final List<Keyframe<Float>> f2887t;

    /* JADX INFO: renamed from: u */
    public final int f2888u;

    /* JADX INFO: renamed from: v */
    public final boolean f2889v;

    /* JADX INFO: renamed from: b.c.a.y.m.e$a */
    /* JADX INFO: compiled from: Layer.java */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Lb/c/a/y/l/b;>;Lb/c/a/d;Ljava/lang/String;JLb/c/a/y/m/e$a;JLjava/lang/String;Ljava/util/List<Lb/c/a/y/l/f;>;Lb/c/a/y/k/l;IIIFFIILb/c/a/y/k/j;Lb/c/a/y/k/k;Ljava/util/List<Lb/c/a/c0/a<Ljava/lang/Float;>;>;Ljava/lang/Object;Lb/c/a/y/k/b;Z)V */
    public Layer2(List list, LottieComposition lottieComposition, String str, long j, a aVar, long j2, @Nullable String str2, List list2, AnimatableTransform animatableTransform, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable AnimatableTextFrame animatableTextFrame, @Nullable AnimatableTextProperties animatableTextProperties, List list3, int i6, @Nullable AnimatableFloatValue animatableFloatValue, boolean z2) {
        this.f2868a = list;
        this.f2869b = lottieComposition;
        this.f2870c = str;
        this.f2871d = j;
        this.f2872e = aVar;
        this.f2873f = j2;
        this.f2874g = str2;
        this.f2875h = list2;
        this.f2876i = animatableTransform;
        this.f2877j = i;
        this.f2878k = i2;
        this.f2879l = i3;
        this.f2880m = f;
        this.f2881n = f2;
        this.f2882o = i4;
        this.f2883p = i5;
        this.f2884q = animatableTextFrame;
        this.f2885r = animatableTextProperties;
        this.f2887t = list3;
        this.f2888u = i6;
        this.f2886s = animatableFloatValue;
        this.f2889v = z2;
    }

    /* JADX INFO: renamed from: a */
    public String m788a(String str) {
        StringBuilder sbM833U = outline.m833U(str);
        sbM833U.append(this.f2870c);
        sbM833U.append("\n");
        Layer2 layer2M673e = this.f2869b.m673e(this.f2873f);
        if (layer2M673e != null) {
            sbM833U.append("\t\tParents: ");
            sbM833U.append(layer2M673e.f2870c);
            Layer2 layer2M673e2 = this.f2869b.m673e(layer2M673e.f2873f);
            while (layer2M673e2 != null) {
                sbM833U.append("->");
                sbM833U.append(layer2M673e2.f2870c);
                layer2M673e2 = this.f2869b.m673e(layer2M673e2.f2873f);
            }
            sbM833U.append(str);
            sbM833U.append("\n");
        }
        if (!this.f2875h.isEmpty()) {
            sbM833U.append(str);
            sbM833U.append("\tMasks: ");
            sbM833U.append(this.f2875h.size());
            sbM833U.append("\n");
        }
        if (this.f2877j != 0 && this.f2878k != 0) {
            sbM833U.append(str);
            sbM833U.append("\tBackground: ");
            sbM833U.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(this.f2877j), Integer.valueOf(this.f2878k), Integer.valueOf(this.f2879l)));
        }
        if (!this.f2868a.isEmpty()) {
            sbM833U.append(str);
            sbM833U.append("\tShapes:\n");
            for (ContentModel2 contentModel2 : this.f2868a) {
                sbM833U.append(str);
                sbM833U.append("\t\t");
                sbM833U.append(contentModel2);
                sbM833U.append("\n");
            }
        }
        return sbM833U.toString();
    }

    public String toString() {
        return m788a("");
    }
}
