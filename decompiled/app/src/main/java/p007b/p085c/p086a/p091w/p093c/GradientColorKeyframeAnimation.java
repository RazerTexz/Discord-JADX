package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p095y.p097l.GradientColor;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: GradientColorKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.d, reason: use source file name */
/* loaded from: classes.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {

    /* renamed from: i */
    public final GradientColor f2610i;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).f2317b;
        int length = gradientColor != null ? gradientColor.f2745b.length : 0;
        this.f2610i = new GradientColor(new float[length], new int[length]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* renamed from: f */
    public Object mo728f(Keyframe keyframe, float f) {
        GradientColor gradientColor = this.f2610i;
        GradientColor gradientColor2 = (GradientColor) keyframe.f2317b;
        GradientColor gradientColor3 = (GradientColor) keyframe.f2318c;
        Objects.requireNonNull(gradientColor);
        if (gradientColor2.f2745b.length != gradientColor3.f2745b.length) {
            StringBuilder sbM833U = outline.m833U("Cannot interpolate between gradients. Lengths vary (");
            sbM833U.append(gradientColor2.f2745b.length);
            sbM833U.append(" vs ");
            throw new IllegalArgumentException(outline.m814B(sbM833U, gradientColor3.f2745b.length, ")"));
        }
        for (int i = 0; i < gradientColor2.f2745b.length; i++) {
            gradientColor.f2744a[i] = MiscUtils.m655e(gradientColor2.f2744a[i], gradientColor3.f2744a[i], f);
            gradientColor.f2745b[i] = AnimatableValueParser.m528i0(f, gradientColor2.f2745b[i], gradientColor3.f2745b[i]);
        }
        return this.f2610i;
    }
}
