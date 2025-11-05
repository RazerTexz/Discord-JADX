package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import b.a.i.p3;
import b.a.i.q3;
import b.a.i.r3;
import b.a.i.s3;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action0;
import rx.functions.Action1;

/* compiled from: CheckedSetting.kt */
/* loaded from: classes2.dex */
public final class CheckedSetting extends RelativeLayout implements Checkable {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public Action1<Boolean> checkedListener;

    /* renamed from: l, reason: from kotlin metadata */
    public b binding;

    /* compiled from: CheckedSetting.kt */
    public enum ViewType {
        CHECK,
        RADIO,
        SWITCH;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ViewType[] VALUES = values();

        /* compiled from: CheckedSetting.kt */
        /* renamed from: com.discord.views.CheckedSetting$ViewType$a, reason: from kotlin metadata */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        public static final /* synthetic */ ViewType[] access$getVALUES$cp() {
            return VALUES;
        }
    }

    /* compiled from: java-style lambda group */
    /* loaded from: classes.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                CheckedSetting.a((CheckedSetting) this.k).c().setChecked(true);
            } else {
                if (i != 1) {
                    throw null;
                }
                CheckedSetting.a((CheckedSetting) this.k).c().setChecked(true ^ CheckedSetting.a((CheckedSetting) this.k).c().isChecked());
            }
        }
    }

    /* compiled from: CheckedSetting.kt */
    public interface b {

        /* compiled from: CheckedSetting.kt */
        public static final class a extends c {
            public final ConstraintLayout e;
            public final MaterialCheckBox f;

            /* JADX WARN: Illegal instructions before constructor call */
            public a(p3 p3Var) {
                m.checkNotNullParameter(p3Var, "binding");
                ConstraintLayout constraintLayout = p3Var.c;
                m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
                super(constraintLayout, null, 2);
                ConstraintLayout constraintLayout2 = p3Var.c;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
                this.e = constraintLayout2;
                MaterialCheckBox materialCheckBox = p3Var.f180b;
                m.checkNotNullExpressionValue(materialCheckBox, "binding.settingButton");
                this.f = materialCheckBox;
            }

            @Override // com.discord.views.CheckedSetting.b
            public View b() {
                return this.e;
            }

            @Override // com.discord.views.CheckedSetting.b
            public CompoundButton c() {
                return this.f;
            }
        }

        /* compiled from: CheckedSetting.kt */
        /* renamed from: com.discord.views.CheckedSetting$b$b, reason: collision with other inner class name */
        public static final class C0351b extends c {
            public final ConstraintLayout e;
            public final MaterialRadioButton f;

            /* JADX WARN: Illegal instructions before constructor call */
            public C0351b(q3 q3Var) {
                m.checkNotNullParameter(q3Var, "binding");
                ConstraintLayout constraintLayout = q3Var.c;
                m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
                super(constraintLayout, null, 2);
                ConstraintLayout constraintLayout2 = q3Var.c;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
                this.e = constraintLayout2;
                MaterialRadioButton materialRadioButton = q3Var.f186b;
                m.checkNotNullExpressionValue(materialRadioButton, "binding.settingButton");
                this.f = materialRadioButton;
            }

            @Override // com.discord.views.CheckedSetting.b
            public View b() {
                return this.e;
            }

            @Override // com.discord.views.CheckedSetting.b
            public CompoundButton c() {
                return this.f;
            }
        }

        /* compiled from: CheckedSetting.kt */
        public static abstract class c implements b {
            public final TextView a;

            /* renamed from: b, reason: collision with root package name */
            public final TextView f2824b;
            public final LinkifiedTextView c;
            public final ImageView d;

            public c(ViewGroup viewGroup, r3 r3Var, int i) {
                r3 r3Var2;
                if ((i & 2) != 0) {
                    int i2 = R.id.setting_drawable_left;
                    ImageView imageView = (ImageView) viewGroup.findViewById(R.id.setting_drawable_left);
                    if (imageView != null) {
                        i2 = R.id.setting_label;
                        TextView textView = (TextView) viewGroup.findViewById(R.id.setting_label);
                        if (textView != null) {
                            i2 = R.id.setting_subtext;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewGroup.findViewById(R.id.setting_subtext);
                            if (linkifiedTextView != null) {
                                i2 = R.id.setting_tag;
                                TextView textView2 = (TextView) viewGroup.findViewById(R.id.setting_tag);
                                if (textView2 != null) {
                                    r3Var2 = new r3(viewGroup, imageView, textView, linkifiedTextView, textView2);
                                    m.checkNotNullExpressionValue(r3Var2, "ViewSettingSharedBinding.bind(container)");
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i2)));
                }
                r3Var2 = null;
                m.checkNotNullParameter(viewGroup, "container");
                m.checkNotNullParameter(r3Var2, "binding");
                TextView textView3 = r3Var2.c;
                m.checkNotNullExpressionValue(textView3, "binding.settingLabel");
                this.a = textView3;
                TextView textView4 = r3Var2.e;
                m.checkNotNullExpressionValue(textView4, "binding.settingTag");
                this.f2824b = textView4;
                LinkifiedTextView linkifiedTextView2 = r3Var2.d;
                m.checkNotNullExpressionValue(linkifiedTextView2, "binding.settingSubtext");
                this.c = linkifiedTextView2;
                ImageView imageView2 = r3Var2.f192b;
                m.checkNotNullExpressionValue(imageView2, "binding.settingDrawableLeft");
                this.d = imageView2;
            }

            @Override // com.discord.views.CheckedSetting.b
            public TextView a() {
                return this.a;
            }

            @Override // com.discord.views.CheckedSetting.b
            public ImageView d() {
                return this.d;
            }

            @Override // com.discord.views.CheckedSetting.b
            public TextView e() {
                return this.f2824b;
            }

            @Override // com.discord.views.CheckedSetting.b
            public TextView f() {
                return this.c;
            }
        }

        /* compiled from: CheckedSetting.kt */
        public static final class d extends c {
            public final ConstraintLayout e;
            public final SwitchMaterial f;

            /* JADX WARN: Illegal instructions before constructor call */
            public d(s3 s3Var) {
                m.checkNotNullParameter(s3Var, "binding");
                ConstraintLayout constraintLayout = s3Var.c;
                m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
                super(constraintLayout, null, 2);
                ConstraintLayout constraintLayout2 = s3Var.c;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
                this.e = constraintLayout2;
                SwitchMaterial switchMaterial = s3Var.f198b;
                m.checkNotNullExpressionValue(switchMaterial, "binding.settingButton");
                this.f = switchMaterial;
            }

            @Override // com.discord.views.CheckedSetting.b
            public View b() {
                return this.e;
            }

            @Override // com.discord.views.CheckedSetting.b
            public CompoundButton c() {
                return this.f;
            }
        }

        TextView a();

        View b();

        CompoundButton c();

        ImageView d();

        TextView e();

        TextView f();
    }

    /* compiled from: CheckedSetting.kt */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CharSequence k;

        public c(CharSequence charSequence) {
            this.k = charSequence;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.k != null) {
                b.a.d.m.h(CheckedSetting.this.getContext(), this.k, 0, null, 12);
            }
        }
    }

    /* compiled from: CheckedSetting.kt */
    public static final class d extends AccessibilityDelegateCompat {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewType f2825b;

        public d(ViewType viewType) {
            this.f2825b = viewType;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            m.checkNotNullParameter(view, "host");
            m.checkNotNullParameter(accessibilityEvent, "event");
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckedSetting.this.isChecked());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i;
            m.checkNotNullParameter(view, "host");
            m.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(true);
            accessibilityNodeInfoCompat.setChecked(CheckedSetting.this.isChecked());
            Resources resources = view.getResources();
            int iOrdinal = this.f2825b.ordinal();
            if (iOrdinal == 0) {
                i = R.string.a11y_role_checkbox;
            } else if (iOrdinal == 1) {
                i = R.string.a11y_role_radio_button;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.string.a11y_role_switch;
            }
            accessibilityNodeInfoCompat.setRoleDescription(resources.getString(i));
        }
    }

    /* compiled from: CheckedSetting.kt */
    public static final class e implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ Action1 a;

        public e(Action1 action1) {
            this.a = action1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            Action1 action1 = this.a;
            if (action1 != null) {
                action1.call(Boolean.valueOf(z2));
            }
        }
    }

    /* compiled from: CheckedSetting.kt */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ Action0 j;

        public f(Action0 action0) {
            this.j = action0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.j.call();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckedSetting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        if (attributeSet == null) {
            f(ViewType.CHECK);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.CheckedSetting, 0, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.CheckedSetting, 0, 0)");
        try {
            int i = typedArrayObtainStyledAttributes.getInt(15, ViewType.CHECK.ordinal());
            Objects.requireNonNull(ViewType.INSTANCE);
            f(ViewType.access$getVALUES$cp()[i]);
            b bVar = this.binding;
            if (bVar == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            int paddingLeft = bVar.b().getPaddingLeft();
            b bVar2 = this.binding;
            if (bVar2 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            int paddingTop = bVar2.b().getPaddingTop();
            int dimension = (int) typedArrayObtainStyledAttributes.getDimension(6, paddingLeft);
            int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(7, paddingTop);
            b bVar3 = this.binding;
            if (bVar3 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            bVar3.b().setPadding(dimension, dimension2, dimension, dimension2);
            float dimension3 = typedArrayObtainStyledAttributes.getDimension(14, -1.0f);
            float f2 = 0;
            if (dimension3 > f2) {
                b bVar4 = this.binding;
                if (bVar4 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar4.a().setTextSize(0, dimension3);
            }
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(12);
            if (colorStateList != null) {
                b bVar5 = this.binding;
                if (bVar5 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar5.a().setTextColor(colorStateList);
            }
            b bVar6 = this.binding;
            if (bVar6 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            TextView textViewA = bVar6.a();
            String string = typedArrayObtainStyledAttributes.getString(11);
            textViewA.setText(string != null ? b.a.k.b.l(string, new Object[0], null, 2) : null);
            b bVar7 = this.binding;
            if (bVar7 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageViewD = bVar7.d();
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(3);
            imageViewD.setVisibility(drawable != null ? 0 : 8);
            imageViewD.setImageDrawable(drawable);
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(4);
            if (colorStateList2 != null) {
                imageViewD.setImageTintList(colorStateList2);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(13, -1);
            if (resourceId != -1) {
                b bVar8 = this.binding;
                if (bVar8 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar8.a().setTypeface(ResourcesCompat.getFont(getContext(), resourceId));
            }
            String string2 = typedArrayObtainStyledAttributes.getString(8);
            CharSequence charSequenceL = string2 != null ? b.a.k.b.l(string2, new Object[0], null, 2) : null;
            if (charSequenceL == null || charSequenceL.length() == 0) {
                b bVar9 = this.binding;
                if (bVar9 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar9.f().setVisibility(8);
            } else {
                b bVar10 = this.binding;
                if (bVar10 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar10.f().setText(charSequenceL);
                b bVar11 = this.binding;
                if (bVar11 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar11.f().setVisibility(0);
            }
            float dimension4 = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
            if (dimension4 > f2) {
                b bVar12 = this.binding;
                if (bVar12 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar12.f().setTextSize(0, dimension4);
            }
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(9);
            if (colorStateList3 != null) {
                b bVar13 = this.binding;
                if (bVar13 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar13.f().setTextColor(colorStateList3);
            }
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(0);
            if (drawable2 != null) {
                setBackground(drawable2);
            } else {
                setBackgroundResource(R.drawable.drawable_bg_settings_item_white);
            }
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(1);
            if (colorStateList4 != null) {
                setBackgroundTintList(colorStateList4);
            }
            Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(2);
            if (drawable3 != null) {
                b bVar14 = this.binding;
                if (bVar14 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                bVar14.b().setBackground(drawable3);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static final /* synthetic */ b a(CheckedSetting checkedSetting) {
        b bVar = checkedSetting.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        return bVar;
    }

    public static /* synthetic */ void d(CheckedSetting checkedSetting, CharSequence charSequence, int i) {
        int i2 = i & 1;
        checkedSetting.c(null);
    }

    public static /* synthetic */ void i(CheckedSetting checkedSetting, CharSequence charSequence, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        checkedSetting.h(charSequence, z2);
    }

    public final void b(@StringRes int disabledToastRes) {
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        c(b.a.k.b.h(context, disabledToastRes, new Object[0], null, 4));
    }

    public final void c(CharSequence disabledToastText) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.b().setOnClickListener(new c(disabledToastText));
        setAlpha(0.3f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        m.checkNotNullParameter(container, "container");
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        m.checkNotNullParameter(container, "container");
        dispatchFreezeSelfOnly(container);
    }

    public final void e(View.OnClickListener listener) {
        m.checkNotNullParameter(listener, "listener");
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.b().setOnClickListener(listener);
        setAlpha(1.0f);
    }

    public final void f(ViewType viewType) {
        b aVar;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int iOrdinal = viewType.ordinal();
        int i = R.id.setting_button;
        if (iOrdinal == 0) {
            layoutInflaterFrom.inflate(R.layout.view_setting_check, this);
            MaterialCheckBox materialCheckBox = (MaterialCheckBox) findViewById(R.id.setting_button);
            if (materialCheckBox != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.setting_container);
                if (constraintLayout != null) {
                    p3 p3Var = new p3(this, materialCheckBox, constraintLayout);
                    m.checkNotNullExpressionValue(p3Var, "ViewSettingCheckBinding.…ate(layoutInflater, this)");
                    m.checkNotNullParameter(p3Var, "binding");
                    aVar = new b.a(p3Var);
                } else {
                    i = R.id.setting_container;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        }
        if (iOrdinal == 1) {
            layoutInflaterFrom.inflate(R.layout.view_setting_radio, this);
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) findViewById(R.id.setting_button);
            if (materialRadioButton != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.setting_container);
                if (constraintLayout2 != null) {
                    q3 q3Var = new q3(this, materialRadioButton, constraintLayout2);
                    m.checkNotNullExpressionValue(q3Var, "ViewSettingRadioBinding.…ate(layoutInflater, this)");
                    m.checkNotNullParameter(q3Var, "binding");
                    aVar = new b.C0351b(q3Var);
                } else {
                    i = R.id.setting_container;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        layoutInflaterFrom.inflate(R.layout.view_setting_switch, this);
        SwitchMaterial switchMaterial = (SwitchMaterial) findViewById(R.id.setting_button);
        if (switchMaterial != null) {
            ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById(R.id.setting_container);
            if (constraintLayout3 != null) {
                s3 s3Var = new s3(this, switchMaterial, constraintLayout3);
                m.checkNotNullExpressionValue(s3Var, "ViewSettingSwitchBinding…ate(layoutInflater, this)");
                m.checkNotNullParameter(s3Var, "binding");
                aVar = new b.d(s3Var);
            } else {
                i = R.id.setting_container;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        this.binding = aVar;
        if (viewType == ViewType.RADIO) {
            aVar.b().setOnClickListener(new a(0, this));
        } else {
            aVar.b().setOnClickListener(new a(1, this));
        }
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        ViewCompat.setAccessibilityDelegate(bVar.b(), new d(viewType));
    }

    public final void g(boolean checked, boolean reportChange) {
        if (reportChange) {
            b bVar = this.binding;
            if (bVar == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            bVar.c().setChecked(checked);
            return;
        }
        b bVar2 = this.binding;
        if (bVar2 == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar2.c().setOnCheckedChangeListener(null);
        b bVar3 = this.binding;
        if (bVar3 == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar3.c().setChecked(checked);
        setOnCheckedListener(this.checkedListener);
    }

    public final void h(CharSequence text, boolean containsClickables) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.f().setText(text);
        b bVar2 = this.binding;
        if (bVar2 == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar2.f().setVisibility(text == null || text.length() == 0 ? 8 : 0);
        if (containsClickables) {
            b bVar3 = this.binding;
            if (bVar3 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            bVar3.f().setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        return bVar.c().isChecked();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Parcelable parcelable;
        m.checkNotNullParameter(state, "state");
        if (state instanceof Bundle) {
            b bVar = this.binding;
            if (bVar == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            Bundle bundle = (Bundle) state;
            bVar.c().setChecked(bundle.getBoolean("STATE_CHECKED"));
            parcelable = bundle.getParcelable("STATE_SUPER");
        } else {
            parcelable = null;
        }
        if (parcelable != null) {
            state = parcelable;
        }
        super.onRestoreInstanceState(state);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("STATE_SUPER", super.onSaveInstanceState());
        bundle.putBoolean("STATE_CHECKED", isChecked());
        return bundle;
    }

    public final void setButtonAlpha(float alpha) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.c().setAlpha(alpha);
    }

    public final void setButtonVisibility(boolean isVisible) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.c().setVisibility(isVisible ? 0 : 8);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        g(checked, false);
    }

    public final void setLabelTagText(@StringRes int resId) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.e().setText(resId);
    }

    public final void setLabelTagVisibility(boolean isVisible) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.e().setVisibility(isVisible ? 0 : 8);
    }

    public final void setOnCheckedListener(Action1<Boolean> checkedListener) {
        this.checkedListener = checkedListener;
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.c().setOnCheckedChangeListener(new e(checkedListener));
    }

    public final void setSubtext(CharSequence charSequence) {
        h(charSequence, false);
    }

    public final void setSubtextColor(@ColorInt int color) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.f().setTextColor(color);
    }

    public final void setSubtextOnClickListener(Action0 listener) {
        m.checkNotNullParameter(listener, "listener");
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.f().setOnClickListener(new f(listener));
    }

    public final void setText(CharSequence text) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.a().setText(text);
    }

    public final void setTextColor(@ColorInt int color) {
        b bVar = this.binding;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        bVar.a().setTextColor(color);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (this.binding == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        g(!r0.c().isChecked(), false);
    }
}
