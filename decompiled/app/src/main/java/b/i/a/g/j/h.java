package b.i.a.g.j;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes3.dex */
public class h extends m {
    public final TextWatcher d;
    public final View.OnFocusChangeListener e;
    public final TextInputLayout.AccessibilityDelegate f;
    public final TextInputLayout.OnEditTextAttachedListener g;

    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.OnEndIconChangedListener h;
    public boolean i;
    public boolean j;
    public long k;
    public StateListDrawable l;
    public MaterialShapeDrawable m;

    @Nullable
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class a extends TextWatcherAdapter {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* renamed from: b.i.a.g.j.h$a$a, reason: collision with other inner class name */
        public class RunnableC0127a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView j;

            public RunnableC0127a(AutoCompleteTextView autoCompleteTextView) {
                this.j = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.j.isPopupShowing();
                h.f(h.this, zIsPopupShowing);
                h.this.i = zIsPopupShowing;
            }
        }

        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewD = h.d(h.this.a.getEditText());
            if (h.this.n.isTouchExplorationEnabled() && h.e(autoCompleteTextViewD) && !h.this.c.hasFocus()) {
                autoCompleteTextViewD.dismissDropDown();
            }
            autoCompleteTextViewD.post(new RunnableC0127a(autoCompleteTextViewD));
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            h.this.a.setEndIconActivated(z2);
            if (z2) {
                return;
            }
            h.f(h.this, false);
            h.this.i = false;
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class c extends TextInputLayout.AccessibilityDelegate {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!h.e(h.this.a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewD = h.d(h.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.n.isTouchExplorationEnabled() && !h.e(h.this.a.getEditText())) {
                h.g(h.this, autoCompleteTextViewD);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class d implements TextInputLayout.OnEditTextAttachedListener {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewD = h.d(textInputLayout.getEditText());
            h hVar = h.this;
            int boxBackgroundMode = hVar.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextViewD.setDropDownBackgroundDrawable(hVar.m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextViewD.setDropDownBackgroundDrawable(hVar.l);
            }
            h hVar2 = h.this;
            Objects.requireNonNull(hVar2);
            if (!(autoCompleteTextViewD.getKeyListener() != null)) {
                int boxBackgroundMode2 = hVar2.a.getBoxBackgroundMode();
                MaterialShapeDrawable boxBackground = hVar2.a.getBoxBackground();
                int color = MaterialColors.getColor(autoCompleteTextViewD, R.attr.colorControlHighlight);
                int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int color2 = MaterialColors.getColor(autoCompleteTextViewD, R.attr.colorSurface);
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    int iLayer = MaterialColors.layer(color, color2, 0.1f);
                    materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{iLayer, 0}));
                    materialShapeDrawable.setTint(color2);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iLayer, color2});
                    MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    materialShapeDrawable2.setTint(-1);
                    ViewCompat.setBackground(autoCompleteTextViewD, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = hVar2.a.getBoxBackgroundColor();
                    ViewCompat.setBackground(autoCompleteTextViewD, new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(color, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                }
            }
            h hVar3 = h.this;
            Objects.requireNonNull(hVar3);
            autoCompleteTextViewD.setOnTouchListener(new j(hVar3, autoCompleteTextViewD));
            autoCompleteTextViewD.setOnFocusChangeListener(hVar3.e);
            autoCompleteTextViewD.setOnDismissListener(new k(hVar3));
            autoCompleteTextViewD.setThreshold(0);
            autoCompleteTextViewD.removeTextChangedListener(h.this.d);
            autoCompleteTextViewD.addTextChangedListener(h.this.d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!(autoCompleteTextViewD.getKeyListener() != null)) {
                ViewCompat.setImportantForAccessibility(h.this.c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(h.this.f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class e implements TextInputLayout.OnEndIconChangedListener {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView j;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.j = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.j.removeTextChangedListener(h.this.d);
            }
        }

        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == h.this.e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            autoCompleteTextView.setOnDismissListener(null);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.g(h.this, (AutoCompleteTextView) h.this.a.getEditText());
        }
    }

    public h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a();
        this.e = new b();
        this.f = new c(this.a);
        this.g = new d();
        this.h = new e();
        this.i = false;
        this.j = false;
        this.k = RecyclerView.FOREVER_NS;
    }

    public static AutoCompleteTextView d(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean e(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static void f(h hVar, boolean z2) {
        if (hVar.j != z2) {
            hVar.j = z2;
            hVar.p.cancel();
            hVar.o.start();
        }
    }

    public static void g(h hVar, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(hVar);
        if (autoCompleteTextView == null) {
            return;
        }
        if (hVar.i()) {
            hVar.i = false;
        }
        if (hVar.i) {
            hVar.i = false;
            return;
        }
        boolean z2 = hVar.j;
        boolean z3 = !z2;
        if (z2 != z3) {
            hVar.j = z3;
            hVar.p.cancel();
            hVar.o.start();
        }
        if (!hVar.j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // b.i.a.g.j.m
    public void a() throws Resources.NotFoundException {
        float dimensionPixelOffset = this.f1626b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f1626b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f1626b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable materialShapeDrawableH = h(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable materialShapeDrawableH2 = h(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = materialShapeDrawableH;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, materialShapeDrawableH);
        this.l.addState(new int[0], materialShapeDrawableH2);
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f1626b, R.drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new f());
        this.a.addOnEditTextAttachedListener(this.g);
        this.a.addOnEndIconChangedListener(this.h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new i(this));
        this.p = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new i(this));
        this.o = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new l(this));
        this.n = (AccessibilityManager) this.f1626b.getSystemService("accessibility");
    }

    @Override // b.i.a.g.j.m
    public boolean b(int i) {
        return i != 0;
    }

    public final MaterialShapeDrawable h(float f2, float f3, float f4, int i) {
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder().setTopLeftCornerSize(f2).setTopRightCornerSize(f2).setBottomLeftCornerSize(f3).setBottomRightCornerSize(f3).build();
        MaterialShapeDrawable materialShapeDrawableCreateWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.f1626b, f4);
        materialShapeDrawableCreateWithElevationOverlay.setShapeAppearanceModel(shapeAppearanceModelBuild);
        materialShapeDrawableCreateWithElevationOverlay.setPadding(0, i, 0, i);
        return materialShapeDrawableCreateWithElevationOverlay;
    }

    public final boolean i() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }
}
