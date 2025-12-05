package p007b.p225i.p226a.p341g.p351j;

import android.R;
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
import com.google.android.material.C10817R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* renamed from: b.i.a.g.j.h, reason: use source file name */
/* loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate extends EndIconDelegate {

    /* renamed from: d */
    public final TextWatcher f11791d;

    /* renamed from: e */
    public final View.OnFocusChangeListener f11792e;

    /* renamed from: f */
    public final TextInputLayout.AccessibilityDelegate f11793f;

    /* renamed from: g */
    public final TextInputLayout.OnEditTextAttachedListener f11794g;

    /* renamed from: h */
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.OnEndIconChangedListener f11795h;

    /* renamed from: i */
    public boolean f11796i;

    /* renamed from: j */
    public boolean f11797j;

    /* renamed from: k */
    public long f11798k;

    /* renamed from: l */
    public StateListDrawable f11799l;

    /* renamed from: m */
    public MaterialShapeDrawable f11800m;

    /* renamed from: n */
    @Nullable
    public AccessibilityManager f11801n;

    /* renamed from: o */
    public ValueAnimator f11802o;

    /* renamed from: p */
    public ValueAnimator f11803p;

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.h$a */
    public class a extends TextWatcherAdapter {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* renamed from: b.i.a.g.j.h$a$a, reason: collision with other inner class name */
        public class RunnableC13229a implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ AutoCompleteTextView f11805j;

            public RunnableC13229a(AutoCompleteTextView autoCompleteTextView) {
                this.f11805j = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.f11805j.isPopupShowing();
                DropdownMenuEndIconDelegate.m6152f(DropdownMenuEndIconDelegate.this, zIsPopupShowing);
                DropdownMenuEndIconDelegate.this.f11796i = zIsPopupShowing;
            }
        }

        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewM6150d = DropdownMenuEndIconDelegate.m6150d(DropdownMenuEndIconDelegate.this.f11819a.getEditText());
            if (DropdownMenuEndIconDelegate.this.f11801n.isTouchExplorationEnabled() && DropdownMenuEndIconDelegate.m6151e(autoCompleteTextViewM6150d) && !DropdownMenuEndIconDelegate.this.f11821c.hasFocus()) {
                autoCompleteTextViewM6150d.dismissDropDown();
            }
            autoCompleteTextViewM6150d.post(new RunnableC13229a(autoCompleteTextViewM6150d));
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.h$b */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            DropdownMenuEndIconDelegate.this.f11819a.setEndIconActivated(z2);
            if (z2) {
                return;
            }
            DropdownMenuEndIconDelegate.m6152f(DropdownMenuEndIconDelegate.this, false);
            DropdownMenuEndIconDelegate.this.f11796i = false;
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.h$c */
    public class c extends TextInputLayout.AccessibilityDelegate {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DropdownMenuEndIconDelegate.m6151e(DropdownMenuEndIconDelegate.this.f11819a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewM6150d = DropdownMenuEndIconDelegate.m6150d(DropdownMenuEndIconDelegate.this.f11819a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && DropdownMenuEndIconDelegate.this.f11801n.isTouchExplorationEnabled() && !DropdownMenuEndIconDelegate.m6151e(DropdownMenuEndIconDelegate.this.f11819a.getEditText())) {
                DropdownMenuEndIconDelegate.m6153g(DropdownMenuEndIconDelegate.this, autoCompleteTextViewM6150d);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.h$d */
    public class d implements TextInputLayout.OnEditTextAttachedListener {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewM6150d = DropdownMenuEndIconDelegate.m6150d(textInputLayout.getEditText());
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            int boxBackgroundMode = dropdownMenuEndIconDelegate.f11819a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextViewM6150d.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.f11800m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextViewM6150d.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.f11799l);
            }
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
            Objects.requireNonNull(dropdownMenuEndIconDelegate2);
            if (!(autoCompleteTextViewM6150d.getKeyListener() != null)) {
                int boxBackgroundMode2 = dropdownMenuEndIconDelegate2.f11819a.getBoxBackgroundMode();
                MaterialShapeDrawable boxBackground = dropdownMenuEndIconDelegate2.f11819a.getBoxBackground();
                int color = MaterialColors.getColor(autoCompleteTextViewM6150d, C10817R.attr.colorControlHighlight);
                int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int color2 = MaterialColors.getColor(autoCompleteTextViewM6150d, C10817R.attr.colorSurface);
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    int iLayer = MaterialColors.layer(color, color2, 0.1f);
                    materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{iLayer, 0}));
                    materialShapeDrawable.setTint(color2);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iLayer, color2});
                    MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    materialShapeDrawable2.setTint(-1);
                    ViewCompat.setBackground(autoCompleteTextViewM6150d, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = dropdownMenuEndIconDelegate2.f11819a.getBoxBackgroundColor();
                    ViewCompat.setBackground(autoCompleteTextViewM6150d, new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(color, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                }
            }
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate3 = DropdownMenuEndIconDelegate.this;
            Objects.requireNonNull(dropdownMenuEndIconDelegate3);
            autoCompleteTextViewM6150d.setOnTouchListener(new DropdownMenuEndIconDelegate3(dropdownMenuEndIconDelegate3, autoCompleteTextViewM6150d));
            autoCompleteTextViewM6150d.setOnFocusChangeListener(dropdownMenuEndIconDelegate3.f11792e);
            autoCompleteTextViewM6150d.setOnDismissListener(new DropdownMenuEndIconDelegate4(dropdownMenuEndIconDelegate3));
            autoCompleteTextViewM6150d.setThreshold(0);
            autoCompleteTextViewM6150d.removeTextChangedListener(DropdownMenuEndIconDelegate.this.f11791d);
            autoCompleteTextViewM6150d.addTextChangedListener(DropdownMenuEndIconDelegate.this.f11791d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!(autoCompleteTextViewM6150d.getKeyListener() != null)) {
                ViewCompat.setImportantForAccessibility(DropdownMenuEndIconDelegate.this.f11821c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.this.f11793f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.h$e */
    public class e implements TextInputLayout.OnEndIconChangedListener {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* renamed from: b.i.a.g.j.h$e$a */
        public class a implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ AutoCompleteTextView f11811j;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.f11811j = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11811j.removeTextChangedListener(DropdownMenuEndIconDelegate.this.f11791d);
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
            if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.f11792e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            autoCompleteTextView.setOnDismissListener(null);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.h$f */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DropdownMenuEndIconDelegate.m6153g(DropdownMenuEndIconDelegate.this, (AutoCompleteTextView) DropdownMenuEndIconDelegate.this.f11819a.getEditText());
        }
    }

    public DropdownMenuEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f11791d = new a();
        this.f11792e = new b();
        this.f11793f = new c(this.f11819a);
        this.f11794g = new d();
        this.f11795h = new e();
        this.f11796i = false;
        this.f11797j = false;
        this.f11798k = RecyclerView.FOREVER_NS;
    }

    /* renamed from: d */
    public static AutoCompleteTextView m6150d(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* renamed from: e */
    public static boolean m6151e(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* renamed from: f */
    public static void m6152f(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, boolean z2) {
        if (dropdownMenuEndIconDelegate.f11797j != z2) {
            dropdownMenuEndIconDelegate.f11797j = z2;
            dropdownMenuEndIconDelegate.f11803p.cancel();
            dropdownMenuEndIconDelegate.f11802o.start();
        }
    }

    /* renamed from: g */
    public static void m6153g(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(dropdownMenuEndIconDelegate);
        if (autoCompleteTextView == null) {
            return;
        }
        if (dropdownMenuEndIconDelegate.m6156i()) {
            dropdownMenuEndIconDelegate.f11796i = false;
        }
        if (dropdownMenuEndIconDelegate.f11796i) {
            dropdownMenuEndIconDelegate.f11796i = false;
            return;
        }
        boolean z2 = dropdownMenuEndIconDelegate.f11797j;
        boolean z3 = !z2;
        if (z2 != z3) {
            dropdownMenuEndIconDelegate.f11797j = z3;
            dropdownMenuEndIconDelegate.f11803p.cancel();
            dropdownMenuEndIconDelegate.f11802o.start();
        }
        if (!dropdownMenuEndIconDelegate.f11797j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // p007b.p225i.p226a.p341g.p351j.EndIconDelegate
    /* renamed from: a */
    public void mo6146a() throws Resources.NotFoundException {
        float dimensionPixelOffset = this.f11820b.getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f11820b.getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f11820b.getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable materialShapeDrawableM6155h = m6155h(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable materialShapeDrawableM6155h2 = m6155h(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f11800m = materialShapeDrawableM6155h;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f11799l = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, materialShapeDrawableM6155h);
        this.f11799l.addState(new int[0], materialShapeDrawableM6155h2);
        this.f11819a.setEndIconDrawable(AppCompatResources.getDrawable(this.f11820b, C10817R.drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.f11819a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(C10817R.string.exposed_dropdown_menu_content_description));
        this.f11819a.setEndIconOnClickListener(new f());
        this.f11819a.addOnEditTextAttachedListener(this.f11794g);
        this.f11819a.addOnEndIconChangedListener(this.f11795h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new DropdownMenuEndIconDelegate2(this));
        this.f11803p = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new DropdownMenuEndIconDelegate2(this));
        this.f11802o = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new DropdownMenuEndIconDelegate5(this));
        this.f11801n = (AccessibilityManager) this.f11820b.getSystemService("accessibility");
    }

    @Override // p007b.p225i.p226a.p341g.p351j.EndIconDelegate
    /* renamed from: b */
    public boolean mo6154b(int i) {
        return i != 0;
    }

    /* renamed from: h */
    public final MaterialShapeDrawable m6155h(float f2, float f3, float f4, int i) {
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder().setTopLeftCornerSize(f2).setTopRightCornerSize(f2).setBottomLeftCornerSize(f3).setBottomRightCornerSize(f3).build();
        MaterialShapeDrawable materialShapeDrawableCreateWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.f11820b, f4);
        materialShapeDrawableCreateWithElevationOverlay.setShapeAppearanceModel(shapeAppearanceModelBuild);
        materialShapeDrawableCreateWithElevationOverlay.setPadding(0, i, 0, i);
        return materialShapeDrawableCreateWithElevationOverlay;
    }

    /* renamed from: i */
    public final boolean m6156i() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f11798k;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }
}
