package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p132g.p142e.ArrayDrawable;
import p007b.p109f.p132g.p142e.C1792z;
import p007b.p109f.p132g.p142e.DrawableParent;
import p007b.p109f.p132g.p142e.FadeDrawable;
import p007b.p109f.p132g.p142e.ForwardingDrawable;
import p007b.p109f.p132g.p142e.MatrixDrawable;
import p007b.p109f.p132g.p142e.Rounded;
import p007b.p109f.p132g.p142e.RoundedCornersDrawable;
import p007b.p109f.p132g.p142e.ScaleTypeDrawable;
import p007b.p109f.p132g.p143f.GenericDraweeHierarchyBuilder;
import p007b.p109f.p132g.p143f.RootDrawable;
import p007b.p109f.p132g.p143f.RoundingParams;
import p007b.p109f.p132g.p143f.WrappingUtils;
import p007b.p109f.p132g.p145h.SettableDraweeHierarchy;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: loaded from: classes.dex */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {

    /* JADX INFO: renamed from: a */
    public final Drawable f19506a;

    /* JADX INFO: renamed from: b */
    public final Resources f19507b;

    /* JADX INFO: renamed from: c */
    public RoundingParams f19508c;

    /* JADX INFO: renamed from: d */
    public final RootDrawable f19509d;

    /* JADX INFO: renamed from: e */
    public final FadeDrawable f19510e;

    /* JADX INFO: renamed from: f */
    public final ForwardingDrawable f19511f;

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.f19506a = colorDrawable;
        FrescoSystrace.m1527b();
        this.f19507b = genericDraweeHierarchyBuilder.f3453c;
        this.f19508c = genericDraweeHierarchyBuilder.f3468r;
        ForwardingDrawable forwardingDrawable = new ForwardingDrawable(colorDrawable);
        this.f19511f = forwardingDrawable;
        List<Drawable> list = genericDraweeHierarchyBuilder.f3466p;
        int size = list != null ? list.size() : 1;
        int i2 = (size == 0 ? 1 : size) + (genericDraweeHierarchyBuilder.f3467q != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[i2 + 6];
        drawableArr[0] = m8671g(genericDraweeHierarchyBuilder.f3465o, null);
        drawableArr[1] = m8671g(genericDraweeHierarchyBuilder.f3456f, genericDraweeHierarchyBuilder.f3457g);
        ScalingUtils$ScaleType scalingUtils$ScaleType = genericDraweeHierarchyBuilder.f3464n;
        forwardingDrawable.setColorFilter(null);
        drawableArr[2] = WrappingUtils.m1130e(forwardingDrawable, scalingUtils$ScaleType, null);
        drawableArr[3] = m8671g(genericDraweeHierarchyBuilder.f3462l, genericDraweeHierarchyBuilder.f3463m);
        drawableArr[4] = m8671g(genericDraweeHierarchyBuilder.f3458h, genericDraweeHierarchyBuilder.f3459i);
        drawableArr[5] = m8671g(genericDraweeHierarchyBuilder.f3460j, genericDraweeHierarchyBuilder.f3461k);
        if (i2 > 0) {
            List<Drawable> list2 = genericDraweeHierarchyBuilder.f3466p;
            if (list2 != null) {
                Iterator<Drawable> it = list2.iterator();
                i = 0;
                while (it.hasNext()) {
                    drawableArr[i + 6] = m8671g(it.next(), null);
                    i++;
                }
            } else {
                i = 1;
            }
            Drawable drawable = genericDraweeHierarchyBuilder.f3467q;
            if (drawable != null) {
                drawableArr[i + 6] = m8671g(drawable, null);
            }
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr, false, 2);
        this.f19510e = fadeDrawable;
        fadeDrawable.f3355w = genericDraweeHierarchyBuilder.f3454d;
        if (fadeDrawable.f3354v == 1) {
            fadeDrawable.f3354v = 0;
        }
        RootDrawable rootDrawable = new RootDrawable(WrappingUtils.m1129d(fadeDrawable, this.f19508c));
        this.f19509d = rootDrawable;
        rootDrawable.mutate();
        m8677m();
        FrescoSystrace.m1527b();
    }

    @Override // p007b.p109f.p132g.p145h.SettableDraweeHierarchy
    /* JADX INFO: renamed from: a */
    public void mo1131a(Drawable drawable) {
        RootDrawable rootDrawable = this.f19509d;
        rootDrawable.f3469n = drawable;
        rootDrawable.invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p145h.SettableDraweeHierarchy
    /* JADX INFO: renamed from: b */
    public void mo1132b(Throwable th) {
        this.f19510e.m1098e();
        m8673i();
        if (this.f19510e.m1093a(4) != null) {
            m8672h(4);
        } else {
            m8672h(1);
        }
        this.f19510e.m1099f();
    }

    @Override // p007b.p109f.p132g.p145h.SettableDraweeHierarchy
    /* JADX INFO: renamed from: c */
    public void mo1133c(Throwable th) {
        this.f19510e.m1098e();
        m8673i();
        if (this.f19510e.m1093a(5) != null) {
            m8672h(5);
        } else {
            m8672h(1);
        }
        this.f19510e.m1099f();
    }

    @Override // p007b.p109f.p132g.p145h.SettableDraweeHierarchy
    /* JADX INFO: renamed from: d */
    public void mo1134d(float f, boolean z2) {
        if (this.f19510e.m1093a(3) == null) {
            return;
        }
        this.f19510e.m1098e();
        m8682r(f);
        if (z2) {
            this.f19510e.m1100g();
        }
        this.f19510e.m1099f();
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    /* JADX INFO: renamed from: e */
    public Drawable mo8670e() {
        return this.f19509d;
    }

    @Override // p007b.p109f.p132g.p145h.SettableDraweeHierarchy
    /* JADX INFO: renamed from: f */
    public void mo1135f(Drawable drawable, float f, boolean z2) {
        Drawable drawableM1128c = WrappingUtils.m1128c(drawable, this.f19508c, this.f19507b);
        drawableM1128c.mutate();
        this.f19511f.mo1104o(drawableM1128c);
        this.f19510e.m1098e();
        m8673i();
        m8672h(2);
        m8682r(f);
        if (z2) {
            this.f19510e.m1100g();
        }
        this.f19510e.m1099f();
    }

    /* JADX INFO: renamed from: g */
    public final Drawable m8671g(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        return WrappingUtils.m1130e(WrappingUtils.m1128c(drawable, this.f19508c, this.f19507b), scalingUtils$ScaleType, null);
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Rect getBounds() {
        return this.f19509d.getBounds();
    }

    /* JADX INFO: renamed from: h */
    public final void m8672h(int i) {
        if (i >= 0) {
            FadeDrawable fadeDrawable = this.f19510e;
            fadeDrawable.f3354v = 0;
            fadeDrawable.f3345B[i] = true;
            fadeDrawable.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m8673i() {
        m8674j(1);
        m8674j(2);
        m8674j(3);
        m8674j(4);
        m8674j(5);
    }

    /* JADX INFO: renamed from: j */
    public final void m8674j(int i) {
        if (i >= 0) {
            FadeDrawable fadeDrawable = this.f19510e;
            fadeDrawable.f3354v = 0;
            fadeDrawable.f3345B[i] = false;
            fadeDrawable.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: k */
    public final DrawableParent m8675k(int i) {
        FadeDrawable fadeDrawable = this.f19510e;
        Objects.requireNonNull(fadeDrawable);
        AnimatableValueParser.m527i(Boolean.valueOf(i >= 0));
        AnimatableValueParser.m527i(Boolean.valueOf(i < fadeDrawable.f3329m.length));
        DrawableParent[] drawableParentArr = fadeDrawable.f3329m;
        if (drawableParentArr[i] == null) {
            drawableParentArr[i] = new ArrayDrawable(fadeDrawable, i);
        }
        DrawableParent drawableParent = drawableParentArr[i];
        if (drawableParent.mo1091l() instanceof MatrixDrawable) {
            drawableParent = (MatrixDrawable) drawableParent.mo1091l();
        }
        return drawableParent.mo1091l() instanceof ScaleTypeDrawable ? (ScaleTypeDrawable) drawableParent.mo1091l() : drawableParent;
    }

    /* JADX INFO: renamed from: l */
    public final ScaleTypeDrawable m8676l(int i) {
        DrawableParent drawableParentM8675k = m8675k(i);
        if (drawableParentM8675k instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawableParentM8675k;
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
        Drawable drawableM1130e = WrappingUtils.m1130e(drawableParentM8675k.mo1090g(WrappingUtils.f3479a), C1792z.f3450l, null);
        drawableParentM8675k.mo1090g(drawableM1130e);
        AnimatableValueParser.m591y(drawableM1130e, "Parent has no child drawable!");
        return (ScaleTypeDrawable) drawableM1130e;
    }

    /* JADX INFO: renamed from: m */
    public final void m8677m() {
        FadeDrawable fadeDrawable = this.f19510e;
        if (fadeDrawable != null) {
            fadeDrawable.m1098e();
            FadeDrawable fadeDrawable2 = this.f19510e;
            fadeDrawable2.f3354v = 0;
            Arrays.fill(fadeDrawable2.f3345B, true);
            fadeDrawable2.invalidateSelf();
            m8673i();
            m8672h(1);
            this.f19510e.m1100g();
            this.f19510e.m1099f();
        }
    }

    /* JADX INFO: renamed from: n */
    public void m8678n(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        Objects.requireNonNull(scalingUtils$ScaleType);
        m8676l(2).m1120r(scalingUtils$ScaleType);
    }

    /* JADX INFO: renamed from: o */
    public final void m8679o(int i, Drawable drawable) {
        if (drawable == null) {
            this.f19510e.m1095c(i, null);
        } else {
            m8675k(i).mo1090g(WrappingUtils.m1128c(drawable, this.f19508c, this.f19507b));
        }
    }

    /* JADX INFO: renamed from: p */
    public void m8680p(int i) {
        m8679o(1, this.f19507b.getDrawable(i));
    }

    /* JADX INFO: renamed from: q */
    public void m8681q(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        m8679o(1, drawable);
        m8676l(1).m1120r(scalingUtils$ScaleType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: r */
    public final void m8682r(float f) {
        Drawable drawableM1093a = this.f19510e.m1093a(3);
        if (drawableM1093a == 0) {
            return;
        }
        if (f >= 0.999f) {
            if (drawableM1093a instanceof Animatable) {
                ((Animatable) drawableM1093a).stop();
            }
            m8674j(3);
        } else {
            if (drawableM1093a instanceof Animatable) {
                ((Animatable) drawableM1093a).start();
            }
            m8672h(3);
        }
        drawableM1093a.setLevel(Math.round(f * 10000.0f));
    }

    @Override // p007b.p109f.p132g.p145h.SettableDraweeHierarchy
    public void reset() {
        this.f19511f.mo1104o(this.f19506a);
        m8677m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: s */
    public void m8683s(RoundingParams roundingParams) {
        this.f19508c = roundingParams;
        RootDrawable rootDrawable = this.f19509d;
        Drawable drawable = WrappingUtils.f3479a;
        Drawable drawable2 = rootDrawable.f3360k;
        if (roundingParams == null || roundingParams.f3471a != 1) {
            if (drawable2 instanceof RoundedCornersDrawable) {
                Drawable drawable3 = WrappingUtils.f3479a;
                rootDrawable.mo1104o(((RoundedCornersDrawable) drawable2).mo1104o(drawable3));
                drawable3.setCallback(null);
            }
        } else if (drawable2 instanceof RoundedCornersDrawable) {
            RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable2;
            WrappingUtils.m1127b(roundedCornersDrawable, roundingParams);
            roundedCornersDrawable.f3403x = roundingParams.f3474d;
            roundedCornersDrawable.invalidateSelf();
        } else {
            rootDrawable.mo1104o(WrappingUtils.m1129d(rootDrawable.mo1104o(WrappingUtils.f3479a), roundingParams));
        }
        for (int i = 0; i < this.f19510e.f3328l.length; i++) {
            DrawableParent drawableParentM8675k = m8675k(i);
            RoundingParams roundingParams2 = this.f19508c;
            Resources resources = this.f19507b;
            while (true) {
                Object objMo1091l = drawableParentM8675k.mo1091l();
                if (objMo1091l == drawableParentM8675k || !(objMo1091l instanceof DrawableParent)) {
                    break;
                } else {
                    drawableParentM8675k = (DrawableParent) objMo1091l;
                }
            }
            Drawable drawableMo1091l = drawableParentM8675k.mo1091l();
            if (roundingParams2 == null || roundingParams2.f3471a != 2) {
                if (drawableMo1091l instanceof Rounded) {
                    Rounded rounded = (Rounded) drawableMo1091l;
                    rounded.mo1107c(false);
                    rounded.mo1111j(0.0f);
                    rounded.mo1106a(0, 0.0f);
                    rounded.mo1110i(0.0f);
                    rounded.mo1109f(false);
                    rounded.mo1108e(false);
                }
            } else if (drawableMo1091l instanceof Rounded) {
                WrappingUtils.m1127b((Rounded) drawableMo1091l, roundingParams2);
            } else if (drawableMo1091l != 0) {
                drawableParentM8675k.mo1090g(WrappingUtils.f3479a);
                drawableParentM8675k.mo1090g(WrappingUtils.m1126a(drawableMo1091l, roundingParams2, resources));
            }
        }
    }
}
