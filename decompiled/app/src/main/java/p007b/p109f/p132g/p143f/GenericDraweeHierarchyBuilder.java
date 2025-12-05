package p007b.p109f.p132g.p143f;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p109f.p132g.p142e.C1785s;
import p007b.p109f.p132g.p142e.C1786t;

/* compiled from: GenericDraweeHierarchyBuilder.java */
/* renamed from: b.f.g.f.a, reason: use source file name */
/* loaded from: classes.dex */
public class GenericDraweeHierarchyBuilder {

    /* renamed from: a */
    public static final ScalingUtils$ScaleType f3451a;

    /* renamed from: b */
    public static final ScalingUtils$ScaleType f3452b;

    /* renamed from: c */
    public Resources f3453c;

    /* renamed from: d */
    public int f3454d = 300;

    /* renamed from: e */
    public float f3455e = 0.0f;

    /* renamed from: f */
    public Drawable f3456f = null;

    /* renamed from: g */
    public ScalingUtils$ScaleType f3457g;

    /* renamed from: h */
    public Drawable f3458h;

    /* renamed from: i */
    public ScalingUtils$ScaleType f3459i;

    /* renamed from: j */
    public Drawable f3460j;

    /* renamed from: k */
    public ScalingUtils$ScaleType f3461k;

    /* renamed from: l */
    public Drawable f3462l;

    /* renamed from: m */
    public ScalingUtils$ScaleType f3463m;

    /* renamed from: n */
    public ScalingUtils$ScaleType f3464n;

    /* renamed from: o */
    public Drawable f3465o;

    /* renamed from: p */
    public List<Drawable> f3466p;

    /* renamed from: q */
    public Drawable f3467q;

    /* renamed from: r */
    public RoundingParams f3468r;

    static {
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
        f3451a = C1786t.f3444l;
        f3452b = C1785s.f3443l;
    }

    public GenericDraweeHierarchyBuilder(Resources resources) {
        this.f3453c = resources;
        ScalingUtils$ScaleType scalingUtils$ScaleType = f3451a;
        this.f3457g = scalingUtils$ScaleType;
        this.f3458h = null;
        this.f3459i = scalingUtils$ScaleType;
        this.f3460j = null;
        this.f3461k = scalingUtils$ScaleType;
        this.f3462l = null;
        this.f3463m = scalingUtils$ScaleType;
        this.f3464n = f3452b;
        this.f3465o = null;
        this.f3466p = null;
        this.f3467q = null;
        this.f3468r = null;
    }

    /* renamed from: a */
    public GenericDraweeHierarchy m1122a() {
        List<Drawable> list = this.f3466p;
        if (list != null) {
            Iterator<Drawable> it = list.iterator();
            while (it.hasNext()) {
                Objects.requireNonNull(it.next());
            }
        }
        return new GenericDraweeHierarchy(this);
    }

    /* renamed from: b */
    public GenericDraweeHierarchyBuilder m1123b(Drawable drawable) {
        if (drawable == null) {
            this.f3466p = null;
        } else {
            this.f3466p = Arrays.asList(drawable);
        }
        return this;
    }
}
