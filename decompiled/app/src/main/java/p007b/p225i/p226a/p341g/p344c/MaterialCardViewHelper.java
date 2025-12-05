package p007b.p225i.p226a.p341g.p344c;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.C10817R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* compiled from: MaterialCardViewHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: b.i.a.g.c.a, reason: use source file name */
/* loaded from: classes3.dex */
public class MaterialCardViewHelper {

    /* renamed from: a */
    public static final int[] f11557a = {R.attr.state_checked};

    /* renamed from: b */
    public static final double f11558b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c */
    @NonNull
    public final MaterialCardView f11559c;

    /* renamed from: e */
    @NonNull
    public final MaterialShapeDrawable f11561e;

    /* renamed from: f */
    @NonNull
    public final MaterialShapeDrawable f11562f;

    /* renamed from: g */
    @Dimension
    public int f11563g;

    /* renamed from: h */
    @Dimension
    public int f11564h;

    /* renamed from: i */
    @Dimension
    public int f11565i;

    /* renamed from: j */
    @Nullable
    public Drawable f11566j;

    /* renamed from: k */
    @Nullable
    public Drawable f11567k;

    /* renamed from: l */
    @Nullable
    public ColorStateList f11568l;

    /* renamed from: m */
    @Nullable
    public ColorStateList f11569m;

    /* renamed from: n */
    @Nullable
    public ShapeAppearanceModel f11570n;

    /* renamed from: o */
    @Nullable
    public ColorStateList f11571o;

    /* renamed from: p */
    @Nullable
    public Drawable f11572p;

    /* renamed from: q */
    @Nullable
    public LayerDrawable f11573q;

    /* renamed from: r */
    @Nullable
    public MaterialShapeDrawable f11574r;

    /* renamed from: s */
    @Nullable
    public MaterialShapeDrawable f11575s;

    /* renamed from: u */
    public boolean f11577u;

    /* renamed from: d */
    @NonNull
    public final Rect f11560d = new Rect();

    /* renamed from: t */
    public boolean f11576t = false;

    /* compiled from: MaterialCardViewHelper.java */
    /* renamed from: b.i.a.g.c.a$a */
    public class a extends InsetDrawable {
        public a(MaterialCardViewHelper materialCardViewHelper, Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i, @StyleRes int i2) {
        this.f11559c = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i, i2);
        this.f11561e = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, C10817R.styleable.CardView, i, C10817R.style.CardView);
        int i3 = C10817R.styleable.CardView_cardCornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            builder.setAllCornerSizes(typedArrayObtainStyledAttributes.getDimension(i3, 0.0f));
        }
        this.f11562f = new MaterialShapeDrawable();
        m6051h(builder.build());
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final float m6044a() {
        return Math.max(Math.max(m6045b(this.f11570n.getTopLeftCorner(), this.f11561e.getTopLeftCornerResolvedSize()), m6045b(this.f11570n.getTopRightCorner(), this.f11561e.getTopRightCornerResolvedSize())), Math.max(m6045b(this.f11570n.getBottomRightCorner(), this.f11561e.getBottomRightCornerResolvedSize()), m6045b(this.f11570n.getBottomLeftCorner(), this.f11561e.getBottomLeftCornerResolvedSize())));
    }

    /* renamed from: b */
    public final float m6045b(CornerTreatment cornerTreatment, float f) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - f11558b) * f);
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    /* renamed from: c */
    public final float m6046c() {
        return this.f11559c.getMaxCardElevation() + (m6053j() ? m6044a() : 0.0f);
    }

    /* renamed from: d */
    public final float m6047d() {
        return (this.f11559c.getMaxCardElevation() * 1.5f) + (m6053j() ? m6044a() : 0.0f);
    }

    @NonNull
    /* renamed from: e */
    public final Drawable m6048e() {
        Drawable rippleDrawable;
        if (this.f11572p == null) {
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.f11575s = new MaterialShapeDrawable(this.f11570n);
                rippleDrawable = new RippleDrawable(this.f11568l, null, this.f11575s);
            } else {
                StateListDrawable stateListDrawable = new StateListDrawable();
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f11570n);
                this.f11574r = materialShapeDrawable;
                materialShapeDrawable.setFillColor(this.f11568l);
                stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.f11574r);
                rippleDrawable = stateListDrawable;
            }
            this.f11572p = rippleDrawable;
        }
        if (this.f11573q == null) {
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            Drawable drawable = this.f11567k;
            if (drawable != null) {
                stateListDrawable2.addState(f11557a, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f11572p, this.f11562f, stateListDrawable2});
            this.f11573q = layerDrawable;
            layerDrawable.setId(2, C10817R.id.mtrl_card_checked_layer_id);
        }
        return this.f11573q;
    }

    @NonNull
    /* renamed from: f */
    public final Drawable m6049f(Drawable drawable) {
        int iCeil;
        int i;
        if (this.f11559c.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil(m6047d());
            iCeil = (int) Math.ceil(m6046c());
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new a(this, drawable, iCeil, i, iCeil, i);
    }

    /* renamed from: g */
    public void m6050g(@Nullable Drawable drawable) {
        this.f11567k = drawable;
        if (drawable != null) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
            this.f11567k = drawableWrap;
            DrawableCompat.setTintList(drawableWrap, this.f11569m);
        }
        if (this.f11573q != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.f11567k;
            if (drawable2 != null) {
                stateListDrawable.addState(f11557a, drawable2);
            }
            this.f11573q.setDrawableByLayerId(C10817R.id.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    /* renamed from: h */
    public void m6051h(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f11570n = shapeAppearanceModel;
        this.f11561e.setShapeAppearanceModel(shapeAppearanceModel);
        this.f11561e.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable = this.f11562f;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f11575s;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.f11574r;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* renamed from: i */
    public final boolean m6052i() {
        return this.f11559c.getPreventCornerOverlap() && !this.f11561e.isRoundRect();
    }

    /* renamed from: j */
    public final boolean m6053j() {
        return this.f11559c.getPreventCornerOverlap() && this.f11561e.isRoundRect() && this.f11559c.getUseCompatPadding();
    }

    /* renamed from: k */
    public void m6054k() {
        float cardViewRadius = 0.0f;
        float fM6044a = m6052i() || m6053j() ? m6044a() : 0.0f;
        if (this.f11559c.getPreventCornerOverlap() && this.f11559c.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - f11558b) * this.f11559c.getCardViewRadius());
        }
        int i = (int) (fM6044a - cardViewRadius);
        MaterialCardView materialCardView = this.f11559c;
        Rect rect = this.f11560d;
        materialCardView.setAncestorContentPadding(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
    }

    /* renamed from: l */
    public void m6055l() {
        if (!this.f11576t) {
            this.f11559c.setBackgroundInternal(m6049f(this.f11561e));
        }
        this.f11559c.setForeground(m6049f(this.f11566j));
    }

    /* renamed from: m */
    public final void m6056m() {
        Drawable drawable;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.f11572p) != null) {
            ((RippleDrawable) drawable).setColor(this.f11568l);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.f11574r;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.f11568l);
        }
    }

    /* renamed from: n */
    public void m6057n() {
        this.f11562f.setStroke(this.f11565i, this.f11571o);
    }
}
