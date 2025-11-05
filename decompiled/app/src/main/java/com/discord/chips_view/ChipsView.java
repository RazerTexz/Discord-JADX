package com.discord.chips_view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.f.a;
import b.a.f.d;
import b.a.f.e;
import b.a.f.f;
import b.a.f.g;
import com.discord.chips_view.ChipsView.a;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ChipsView.kt */
/* loaded from: classes.dex */
public final class ChipsView<K, V extends a> extends ScrollView implements d.a {
    public static final /* synthetic */ int j = 0;

    /* renamed from: A, reason: from kotlin metadata */
    public final b.a.f.d mEditText;

    /* renamed from: B, reason: from kotlin metadata */
    public b.a.f.e mRootChipsLayout;

    /* renamed from: C, reason: from kotlin metadata */
    public final LinkedHashMap<K, b.a.f.a<K, V>> mChipList;

    /* renamed from: D, reason: from kotlin metadata */
    public Object mCurrentEditTextSpan;

    /* renamed from: E, reason: from kotlin metadata */
    public Function1<? super V, Unit> chipAddedListener;

    /* renamed from: F, reason: from kotlin metadata */
    public Function1<? super V, Unit> chipDeletedListener;

    /* renamed from: G, reason: from kotlin metadata */
    public Function1<? super CharSequence, Unit> textChangedListener;

    /* renamed from: k, reason: from kotlin metadata */
    public int mChipsBgResId;

    /* renamed from: l, reason: from kotlin metadata */
    public int mMaxHeight;

    /* renamed from: m, reason: from kotlin metadata */
    public int mVerticalSpacingPx;

    /* renamed from: n, reason: from kotlin metadata */
    public int mChipHeightPx;

    /* renamed from: o, reason: from kotlin metadata */
    public int mChipsColor;

    /* renamed from: p, reason: from kotlin metadata */
    public int mChipsColorClicked;

    /* renamed from: q, reason: from kotlin metadata */
    public int mChipsBgColor;

    /* renamed from: r, reason: from kotlin metadata */
    public int mChipsBgColorClicked;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public int mChipsTextColor;

    /* renamed from: t, reason: from kotlin metadata */
    public int mChipsTextColorClicked;

    /* renamed from: u, reason: from kotlin metadata */
    public int mChipsSearchTextColor;

    /* renamed from: v, reason: from kotlin metadata */
    public float mChipsSearchTextSize;

    /* renamed from: w, reason: from kotlin metadata */
    public int mChipsHintRes;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public int mChipLayout;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public float mDensity;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final RelativeLayout mChipsContainer;

    /* compiled from: ChipsView.kt */
    public interface a {
        String getDisplayString();
    }

    /* compiled from: ChipsView.kt */
    public final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            m.checkNotNullParameter(editable, "s");
            Function1<CharSequence, Unit> textChangedListener = ChipsView.this.getTextChangedListener();
            if (textChangedListener != null) {
                textChangedListener.invoke(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            m.checkNotNullParameter(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            m.checkNotNullParameter(charSequence, "s");
        }
    }

    /* compiled from: ChipsView.kt */
    public final class c extends InputConnectionWrapper {
        public c(InputConnection inputConnection) {
            super(inputConnection, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i) {
            m.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            return super.commitText(charSequence, i);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            return (ChipsView.this.mEditText.length() == 0 && i == 1 && i2 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            m.checkNotNullParameter(keyEvent, "event");
            if (ChipsView.this.mEditText.length() != 0 || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                return super.sendKeyEvent(keyEvent);
            }
            ChipsView chipsView = ChipsView.this;
            if (chipsView.mChipList.size() > 0) {
                try {
                    Iterator<Map.Entry<K, b.a.f.a<K, V>>> it = chipsView.mChipList.entrySet().iterator();
                    b.a.f.a<K, V> value = null;
                    while (it.hasNext()) {
                        value = it.next().getValue();
                    }
                    if (value != null) {
                        m.checkNotNullParameter(value, "chip");
                        chipsView.f(value);
                        if (value.k) {
                            chipsView.e(value);
                        } else {
                            value.k = true;
                            chipsView.c(false);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    Log.e("ChipsView", "Out of bounds", e);
                }
            }
            return true;
        }
    }

    /* compiled from: ChipsView.kt */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChipsView.this.fullScroll(130);
        }
    }

    /* compiled from: ChipsView.kt */
    public static final class e implements Runnable {
        public final /* synthetic */ boolean k;

        public e(boolean z2) {
            this.k = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChipsView chipsView = ChipsView.this;
            boolean z2 = this.k;
            int i = ChipsView.j;
            chipsView.c(z2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        this.mChipList = new LinkedHashMap<>();
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        this.mDensity = resources.getDisplayMetrics().density;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.mChipsContainer = relativeLayout;
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        relativeLayout.addView(linearLayout);
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        b.a.f.d dVar = new b.a.f.d(context2, this);
        this.mEditText = dVar;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.c.ChipsView, 0, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…tyleable.ChipsView, 0, 0)");
        try {
            this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.ChipsView_cv_max_height, -1);
            this.mVerticalSpacingPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.ChipsView_cv_vertical_spacing, (int) (1 * this.mDensity));
            this.mChipHeightPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.ChipsView_cv_height, (int) (24 * this.mDensity));
            this.mChipsColor = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_color, ContextCompat.getColor(context, android.R.color.darker_gray));
            this.mChipsColorClicked = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_color_clicked, ContextCompat.getColor(context, android.R.color.white));
            this.mChipsBgColor = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_bg_color, ContextCompat.getColor(context, android.R.color.white));
            this.mChipsBgResId = typedArrayObtainStyledAttributes.getResourceId(R.c.ChipsView_cv_chip_bg_res, 0);
            this.mChipsBgColorClicked = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_bg_color_clicked, ContextCompat.getColor(context, android.R.color.holo_blue_dark));
            this.mChipsTextColor = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsTextColorClicked = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_text_color_clicked, -1);
            this.mChipsHintRes = typedArrayObtainStyledAttributes.getResourceId(R.c.ChipsView_cv_hint, 0);
            typedArrayObtainStyledAttributes.getResourceId(R.c.ChipsView_cv_icon_placeholder, 0);
            this.mChipsSearchTextColor = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_search_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsSearchTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.ChipsView_cv_search_text_size, 49);
            this.mChipLayout = typedArrayObtainStyledAttributes.getResourceId(R.c.ChipsView_cv_chip_layout, R.b.view_chip_default);
            typedArrayObtainStyledAttributes.recycle();
            int i = this.mChipHeightPx + this.mVerticalSpacingPx;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            float f = 4;
            layoutParams.leftMargin = (int) (this.mDensity * f);
            layoutParams.addRule(12, -1);
            dVar.setLayoutParams(layoutParams);
            dVar.setPadding(0, 0, 0, this.mVerticalSpacingPx);
            dVar.setBackgroundColor(Color.argb(0, 0, 0, 0));
            dVar.setImeOptions(268435456);
            dVar.setInputType(1);
            dVar.setTextColor(this.mChipsSearchTextColor);
            dVar.setTextSize(0, this.mChipsSearchTextSize);
            relativeLayout.addView(dVar);
            Context context3 = getContext();
            m.checkNotNullExpressionValue(context3, "context");
            b.a.f.e eVar = new b.a.f.e(context3, i);
            eVar.setOrientation(1);
            eVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            eVar.setPadding(0, (int) (f * this.mDensity), 0, 0);
            this.mRootChipsLayout = eVar;
            relativeLayout.addView(eVar);
            relativeLayout.setOnClickListener(new g(this));
            dVar.addTextChangedListener(new b());
            dVar.setOnFocusChangeListener(new f(this));
            c(false);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // b.a.f.d.a
    public InputConnection a(InputConnection target) {
        return new c(target);
    }

    public final void b(String displayName, String imageContentDescription, K key, V data) {
        if (this.mChipList.containsKey(key)) {
            return;
        }
        this.mEditText.setText("");
        b.a.f.a<K, V> aVar = new b.a.f.a<>(displayName, imageContentDescription, key, data, new a.C0031a(this.mChipsBgColorClicked, this.mDensity, this.mChipsBgResId, this.mChipsBgColor, this.mChipsTextColor, this.mChipsTextColorClicked, this.mChipsColorClicked, this.mChipsColor, this.mChipHeightPx, this.mChipLayout), this);
        Editable text = this.mEditText.getText();
        if (text != null) {
            Object obj = this.mCurrentEditTextSpan;
            if (obj != null) {
                text.removeSpan(obj);
            }
            text.setSpan(this.mCurrentEditTextSpan, 0, 0, 17);
        }
        this.mEditText.setText(text);
        this.mChipList.put(key, aVar);
        Function1<? super V, Unit> function1 = this.chipAddedListener;
        if (function1 != null) {
            function1.invoke((Object) aVar.o);
        }
        c(true);
        post(new d());
    }

    public final void c(boolean moveCursor) {
        TextView textView;
        RelativeLayout relativeLayout;
        Drawable background;
        TextView textView2;
        RelativeLayout relativeLayout2;
        Drawable background2;
        TextView textView3;
        TextView textView4;
        ImageView imageView;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        b.a.f.e eVar = this.mRootChipsLayout;
        e.a aVar = null;
        if (eVar != null) {
            Collection<b.a.f.a<K, V>> collectionValues = this.mChipList.values();
            m.checkNotNullExpressionValue(collectionValues, "mChipList.values");
            m.checkNotNullParameter(collectionValues, "chips");
            Iterator<LinearLayout> it = eVar.j.iterator();
            while (it.hasNext()) {
                it.next().removeAllViews();
            }
            eVar.j.clear();
            eVar.removeAllViews();
            int width = eVar.getWidth();
            if (width != 0) {
                LinearLayout linearLayoutA = eVar.a();
                int i = 0;
                int i2 = 0;
                for (b.a.f.a<K, V> aVar2 : collectionValues) {
                    if (aVar2.j == null) {
                        View viewInflate = LayoutInflater.from(aVar2.q.getContext()).inflate(R.b.view_chip_default, (ViewGroup) null, false);
                        int i3 = R.a.chip_image;
                        ImageView imageView2 = (ImageView) viewInflate.findViewById(i3);
                        if (imageView2 != null) {
                            i3 = R.a.chip_text;
                            TextView textView5 = (TextView) viewInflate.findViewById(i3);
                            if (textView5 != null) {
                                aVar2.j = new b.a.f.h.a((RelativeLayout) viewInflate, imageView2, textView5);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, aVar2.p.f);
                                b.a.f.h.a aVar3 = aVar2.j;
                                if (aVar3 != null && (relativeLayout4 = aVar3.a) != null) {
                                    relativeLayout4.setLayoutParams(layoutParams);
                                }
                                b.a.f.h.a aVar4 = aVar2.j;
                                if (aVar4 != null && (relativeLayout3 = aVar4.a) != null) {
                                    relativeLayout3.setBackgroundResource(aVar2.p.f66b);
                                    relativeLayout3.post(new b.a.f.b(relativeLayout3, aVar2));
                                    relativeLayout3.setOnClickListener(aVar2);
                                }
                                b.a.f.h.a aVar5 = aVar2.j;
                                if (aVar5 != null && (imageView = aVar5.f67b) != null) {
                                    imageView.setOnClickListener(aVar2);
                                    m.checkNotNullExpressionValue(imageView, "it");
                                    imageView.setContentDescription(aVar2.m);
                                }
                                b.a.f.h.a aVar6 = aVar2.j;
                                if (aVar6 != null && (textView4 = aVar6.c) != null) {
                                    textView4.setTextColor(aVar2.p.d);
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i3)));
                    }
                    b.a.f.h.a aVar7 = aVar2.j;
                    if (aVar7 != null && (textView3 = aVar7.c) != null) {
                        textView3.setText(aVar2.l);
                    }
                    if (aVar2.k) {
                        b.a.f.h.a aVar8 = aVar2.j;
                        if (aVar8 != null && (relativeLayout2 = aVar8.a) != null && (background2 = relativeLayout2.getBackground()) != null) {
                            background2.setColorFilter(aVar2.p.a, PorterDuff.Mode.SRC_ATOP);
                        }
                        b.a.f.h.a aVar9 = aVar2.j;
                        if (aVar9 != null && (textView2 = aVar9.c) != null) {
                            textView2.setTextColor(aVar2.p.e);
                        }
                    } else {
                        b.a.f.h.a aVar10 = aVar2.j;
                        if (aVar10 != null && (relativeLayout = aVar10.a) != null && (background = relativeLayout.getBackground()) != null) {
                            background.setColorFilter(aVar2.p.c, PorterDuff.Mode.SRC_ATOP);
                        }
                        b.a.f.h.a aVar11 = aVar2.j;
                        if (aVar11 != null && (textView = aVar11.c) != null) {
                            textView.setTextColor(aVar2.p.d);
                        }
                    }
                    b.a.f.h.a aVar12 = aVar2.j;
                    RelativeLayout relativeLayout5 = aVar12 != null ? aVar12.a : null;
                    m.checkNotNull(relativeLayout5);
                    relativeLayout5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (relativeLayout5.getMeasuredWidth() + i > width) {
                        i2++;
                        linearLayoutA = eVar.a();
                        i = 0;
                    }
                    int measuredWidth = relativeLayout5.getMeasuredWidth();
                    ViewGroup.LayoutParams layoutParams2 = relativeLayout5.getLayoutParams();
                    Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    i += measuredWidth + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    linearLayoutA.addView(relativeLayout5);
                }
                if (width - i < width * 0.15f) {
                    i2++;
                    eVar.a();
                    i = 0;
                }
                aVar = new e.a(i2, i);
            }
        }
        if (this.mChipList.isEmpty()) {
            int i4 = this.mChipsHintRes;
            if (i4 != 0) {
                this.mEditText.setHint(i4);
            }
        } else {
            this.mEditText.setHint("");
        }
        if (aVar == null) {
            post(new e(moveCursor));
            return;
        }
        int i5 = aVar.a;
        Editable text = this.mEditText.getText();
        Object obj = this.mCurrentEditTextSpan;
        if (obj != null && text != null) {
            text.removeSpan(obj);
        }
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard(i5, 0);
        this.mCurrentEditTextSpan = standard;
        if (text != null) {
            text.setSpan(standard, 0, 0, 17);
        }
        this.mEditText.setText(text);
        if (moveCursor) {
            b.a.f.d dVar = this.mEditText;
            dVar.setSelection(dVar.length());
        }
    }

    public final void d(Collection<?> pruneData) {
        m.checkNotNullParameter(pruneData, "pruneData");
        Iterator<Map.Entry<K, b.a.f.a<K, V>>> it = this.mChipList.entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (!u.contains(pruneData, it.next().getKey())) {
                it.remove();
                z2 = true;
            }
        }
        if (z2) {
            c(true);
        }
    }

    public final void e(b.a.f.a<K, V> chip) {
        this.mChipList.remove(chip.n);
        Function1<? super V, Unit> function1 = this.chipDeletedListener;
        if (function1 != null) {
            function1.invoke((Object) chip.o);
        }
        c(true);
    }

    public final void f(b.a.f.a<?, ?> rootChip) {
        for (b.a.f.a<K, V> aVar : this.mChipList.values()) {
            if (aVar != rootChip) {
                aVar.k = false;
            }
        }
        c(false);
    }

    public final Function1<V, Unit> getChipAddedListener() {
        return this.chipAddedListener;
    }

    public final Function1<V, Unit> getChipDeletedListener() {
        return this.chipDeletedListener;
    }

    public final String getText() {
        return String.valueOf(this.mEditText.getText());
    }

    public final Function1<CharSequence, Unit> getTextChangedListener() {
        return this.textChangedListener;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, Integer.MIN_VALUE));
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        return true;
    }

    public final void setChipAddedListener(Function1<? super V, Unit> function1) {
        this.chipAddedListener = function1;
    }

    public final void setChipDeletedListener(Function1<? super V, Unit> function1) {
        this.chipDeletedListener = function1;
    }

    public final void setText(String str) {
        m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.mEditText.setText(str);
    }

    public final void setTextChangedListener(Function1<? super CharSequence, Unit> function1) {
        this.textChangedListener = function1;
    }
}
