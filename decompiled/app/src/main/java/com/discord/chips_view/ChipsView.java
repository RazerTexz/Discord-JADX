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
import com.discord.chips_view.ChipsView.InterfaceC5465a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p021f.Chip3;
import p007b.p008a.p021f.ChipsEditText;
import p007b.p008a.p021f.ChipsVerticalLinearLayout;
import p007b.p008a.p021f.ChipsView2;
import p007b.p008a.p021f.ChipsView3;
import p007b.p008a.p021f.ViewOnClickListenerC0895a;
import p007b.p008a.p021f.p022h.ViewChipDefaultBinding;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipsView<K, V extends InterfaceC5465a> extends ScrollView implements ChipsEditText.a {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f14975j = 0;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final ChipsEditText mEditText;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public ChipsVerticalLinearLayout mRootChipsLayout;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public final LinkedHashMap<K, ViewOnClickListenerC0895a<K, V>> mChipList;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public Object mCurrentEditTextSpan;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public Function1<? super V, Unit> chipAddedListener;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public Function1<? super V, Unit> chipDeletedListener;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    public Function1<? super CharSequence, Unit> textChangedListener;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int mChipsBgResId;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int mMaxHeight;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int mVerticalSpacingPx;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int mChipHeightPx;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int mChipsColor;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public int mChipsColorClicked;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public int mChipsBgColor;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public int mChipsBgColorClicked;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public int mChipsTextColor;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public int mChipsTextColorClicked;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public int mChipsSearchTextColor;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public float mChipsSearchTextSize;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public int mChipsHintRes;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public int mChipLayout;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public float mDensity;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public final RelativeLayout mChipsContainer;

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$a */
    /* JADX INFO: compiled from: ChipsView.kt */
    public interface InterfaceC5465a {
        String getDisplayString();
    }

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$b */
    /* JADX INFO: compiled from: ChipsView.kt */
    public final class C5466b implements TextWatcher {
        public C5466b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "s");
            Function1<CharSequence, Unit> textChangedListener = ChipsView.this.getTextChangedListener();
            if (textChangedListener != null) {
                textChangedListener.invoke(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics3.checkNotNullParameter(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics3.checkNotNullParameter(charSequence, "s");
        }
    }

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$c */
    /* JADX INFO: compiled from: ChipsView.kt */
    public final class C5467c extends InputConnectionWrapper {
        public C5467c(InputConnection inputConnection) {
            super(inputConnection, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i) {
            Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            return super.commitText(charSequence, i);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            return (ChipsView.this.mEditText.length() == 0 && i == 1 && i2 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(keyEvent, "event");
            if (ChipsView.this.mEditText.length() != 0 || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                return super.sendKeyEvent(keyEvent);
            }
            ChipsView chipsView = ChipsView.this;
            if (chipsView.mChipList.size() > 0) {
                try {
                    Iterator<Map.Entry<K, ViewOnClickListenerC0895a<K, V>>> it = chipsView.mChipList.entrySet().iterator();
                    ViewOnClickListenerC0895a<K, V> value = null;
                    while (it.hasNext()) {
                        value = it.next().getValue();
                    }
                    if (value != null) {
                        Intrinsics3.checkNotNullParameter(value, "chip");
                        chipsView.m8380f(value);
                        if (value.f602k) {
                            chipsView.m8379e(value);
                        } else {
                            value.f602k = true;
                            chipsView.m8377c(false);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    Log.e("ChipsView", "Out of bounds", e);
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$d */
    /* JADX INFO: compiled from: ChipsView.kt */
    public static final class RunnableC5468d implements Runnable {
        public RunnableC5468d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChipsView.this.fullScroll(130);
        }
    }

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$e */
    /* JADX INFO: compiled from: ChipsView.kt */
    public static final class RunnableC5469e implements Runnable {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f15003k;

        public RunnableC5469e(boolean z2) {
            this.f15003k = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChipsView chipsView = ChipsView.this;
            boolean z2 = this.f15003k;
            int i = ChipsView.f14975j;
            chipsView.m8377c(z2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.mChipList = new LinkedHashMap<>();
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
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
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        ChipsEditText chipsEditText = new ChipsEditText(context2, this);
        this.mEditText = chipsEditText;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C5470R.c.ChipsView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…tyleable.ChipsView, 0, 0)");
        try {
            this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5470R.c.ChipsView_cv_max_height, -1);
            this.mVerticalSpacingPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5470R.c.ChipsView_cv_vertical_spacing, (int) (1 * this.mDensity));
            this.mChipHeightPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5470R.c.ChipsView_cv_height, (int) (24 * this.mDensity));
            this.mChipsColor = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_color, ContextCompat.getColor(context, android.R.color.darker_gray));
            this.mChipsColorClicked = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_color_clicked, ContextCompat.getColor(context, android.R.color.white));
            this.mChipsBgColor = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_bg_color, ContextCompat.getColor(context, android.R.color.white));
            this.mChipsBgResId = typedArrayObtainStyledAttributes.getResourceId(C5470R.c.ChipsView_cv_chip_bg_res, 0);
            this.mChipsBgColorClicked = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_bg_color_clicked, ContextCompat.getColor(context, android.R.color.holo_blue_dark));
            this.mChipsTextColor = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsTextColorClicked = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_text_color_clicked, -1);
            this.mChipsHintRes = typedArrayObtainStyledAttributes.getResourceId(C5470R.c.ChipsView_cv_hint, 0);
            typedArrayObtainStyledAttributes.getResourceId(C5470R.c.ChipsView_cv_icon_placeholder, 0);
            this.mChipsSearchTextColor = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_search_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsSearchTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5470R.c.ChipsView_cv_search_text_size, 49);
            this.mChipLayout = typedArrayObtainStyledAttributes.getResourceId(C5470R.c.ChipsView_cv_chip_layout, C5470R.b.view_chip_default);
            typedArrayObtainStyledAttributes.recycle();
            int i = this.mChipHeightPx + this.mVerticalSpacingPx;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            float f = 4;
            layoutParams.leftMargin = (int) (this.mDensity * f);
            layoutParams.addRule(12, -1);
            chipsEditText.setLayoutParams(layoutParams);
            chipsEditText.setPadding(0, 0, 0, this.mVerticalSpacingPx);
            chipsEditText.setBackgroundColor(Color.argb(0, 0, 0, 0));
            chipsEditText.setImeOptions(268435456);
            chipsEditText.setInputType(1);
            chipsEditText.setTextColor(this.mChipsSearchTextColor);
            chipsEditText.setTextSize(0, this.mChipsSearchTextSize);
            relativeLayout.addView(chipsEditText);
            Context context3 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context3, "context");
            ChipsVerticalLinearLayout chipsVerticalLinearLayout = new ChipsVerticalLinearLayout(context3, i);
            chipsVerticalLinearLayout.setOrientation(1);
            chipsVerticalLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            chipsVerticalLinearLayout.setPadding(0, (int) (f * this.mDensity), 0, 0);
            this.mRootChipsLayout = chipsVerticalLinearLayout;
            relativeLayout.addView(chipsVerticalLinearLayout);
            relativeLayout.setOnClickListener(new ChipsView3(this));
            chipsEditText.addTextChangedListener(new C5466b());
            chipsEditText.setOnFocusChangeListener(new ChipsView2(this));
            m8377c(false);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // p007b.p008a.p021f.ChipsEditText.a
    /* JADX INFO: renamed from: a */
    public InputConnection mo187a(InputConnection target) {
        return new C5467c(target);
    }

    /* JADX INFO: renamed from: b */
    public final void m8376b(String displayName, String imageContentDescription, K key, V data) {
        if (this.mChipList.containsKey(key)) {
            return;
        }
        this.mEditText.setText("");
        ViewOnClickListenerC0895a<K, V> viewOnClickListenerC0895a = new ViewOnClickListenerC0895a<>(displayName, imageContentDescription, key, data, new ViewOnClickListenerC0895a.a(this.mChipsBgColorClicked, this.mDensity, this.mChipsBgResId, this.mChipsBgColor, this.mChipsTextColor, this.mChipsTextColorClicked, this.mChipsColorClicked, this.mChipsColor, this.mChipHeightPx, this.mChipLayout), this);
        Editable text = this.mEditText.getText();
        if (text != null) {
            Object obj = this.mCurrentEditTextSpan;
            if (obj != null) {
                text.removeSpan(obj);
            }
            text.setSpan(this.mCurrentEditTextSpan, 0, 0, 17);
        }
        this.mEditText.setText(text);
        this.mChipList.put(key, viewOnClickListenerC0895a);
        Function1<? super V, Unit> function1 = this.chipAddedListener;
        if (function1 != null) {
            function1.invoke((Object) viewOnClickListenerC0895a.f606o);
        }
        m8377c(true);
        post(new RunnableC5468d());
    }

    /* JADX INFO: renamed from: c */
    public final void m8377c(boolean moveCursor) {
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
        ChipsVerticalLinearLayout chipsVerticalLinearLayout = this.mRootChipsLayout;
        ChipsVerticalLinearLayout.a aVar = null;
        if (chipsVerticalLinearLayout != null) {
            Collection<ViewOnClickListenerC0895a<K, V>> collectionValues = this.mChipList.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "mChipList.values");
            Intrinsics3.checkNotNullParameter(collectionValues, "chips");
            Iterator<LinearLayout> it = chipsVerticalLinearLayout.f618j.iterator();
            while (it.hasNext()) {
                it.next().removeAllViews();
            }
            chipsVerticalLinearLayout.f618j.clear();
            chipsVerticalLinearLayout.removeAllViews();
            int width = chipsVerticalLinearLayout.getWidth();
            if (width != 0) {
                LinearLayout linearLayoutM188a = chipsVerticalLinearLayout.m188a();
                int i = 0;
                int i2 = 0;
                for (ViewOnClickListenerC0895a<K, V> viewOnClickListenerC0895a : collectionValues) {
                    if (viewOnClickListenerC0895a.f601j == null) {
                        View viewInflate = LayoutInflater.from(viewOnClickListenerC0895a.f608q.getContext()).inflate(C5470R.b.view_chip_default, (ViewGroup) null, false);
                        int i3 = C5470R.a.chip_image;
                        ImageView imageView2 = (ImageView) viewInflate.findViewById(i3);
                        if (imageView2 != null) {
                            i3 = C5470R.a.chip_text;
                            TextView textView5 = (TextView) viewInflate.findViewById(i3);
                            if (textView5 != null) {
                                viewOnClickListenerC0895a.f601j = new ViewChipDefaultBinding((RelativeLayout) viewInflate, imageView2, textView5);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, viewOnClickListenerC0895a.f607p.f614f);
                                ViewChipDefaultBinding viewChipDefaultBinding = viewOnClickListenerC0895a.f601j;
                                if (viewChipDefaultBinding != null && (relativeLayout4 = viewChipDefaultBinding.f623a) != null) {
                                    relativeLayout4.setLayoutParams(layoutParams);
                                }
                                ViewChipDefaultBinding viewChipDefaultBinding2 = viewOnClickListenerC0895a.f601j;
                                if (viewChipDefaultBinding2 != null && (relativeLayout3 = viewChipDefaultBinding2.f623a) != null) {
                                    relativeLayout3.setBackgroundResource(viewOnClickListenerC0895a.f607p.f610b);
                                    relativeLayout3.post(new Chip3(relativeLayout3, viewOnClickListenerC0895a));
                                    relativeLayout3.setOnClickListener(viewOnClickListenerC0895a);
                                }
                                ViewChipDefaultBinding viewChipDefaultBinding3 = viewOnClickListenerC0895a.f601j;
                                if (viewChipDefaultBinding3 != null && (imageView = viewChipDefaultBinding3.f624b) != null) {
                                    imageView.setOnClickListener(viewOnClickListenerC0895a);
                                    Intrinsics3.checkNotNullExpressionValue(imageView, "it");
                                    imageView.setContentDescription(viewOnClickListenerC0895a.f604m);
                                }
                                ViewChipDefaultBinding viewChipDefaultBinding4 = viewOnClickListenerC0895a.f601j;
                                if (viewChipDefaultBinding4 != null && (textView4 = viewChipDefaultBinding4.f625c) != null) {
                                    textView4.setTextColor(viewOnClickListenerC0895a.f607p.f612d);
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i3)));
                    }
                    ViewChipDefaultBinding viewChipDefaultBinding5 = viewOnClickListenerC0895a.f601j;
                    if (viewChipDefaultBinding5 != null && (textView3 = viewChipDefaultBinding5.f625c) != null) {
                        textView3.setText(viewOnClickListenerC0895a.f603l);
                    }
                    if (viewOnClickListenerC0895a.f602k) {
                        ViewChipDefaultBinding viewChipDefaultBinding6 = viewOnClickListenerC0895a.f601j;
                        if (viewChipDefaultBinding6 != null && (relativeLayout2 = viewChipDefaultBinding6.f623a) != null && (background2 = relativeLayout2.getBackground()) != null) {
                            background2.setColorFilter(viewOnClickListenerC0895a.f607p.f609a, PorterDuff.Mode.SRC_ATOP);
                        }
                        ViewChipDefaultBinding viewChipDefaultBinding7 = viewOnClickListenerC0895a.f601j;
                        if (viewChipDefaultBinding7 != null && (textView2 = viewChipDefaultBinding7.f625c) != null) {
                            textView2.setTextColor(viewOnClickListenerC0895a.f607p.f613e);
                        }
                    } else {
                        ViewChipDefaultBinding viewChipDefaultBinding8 = viewOnClickListenerC0895a.f601j;
                        if (viewChipDefaultBinding8 != null && (relativeLayout = viewChipDefaultBinding8.f623a) != null && (background = relativeLayout.getBackground()) != null) {
                            background.setColorFilter(viewOnClickListenerC0895a.f607p.f611c, PorterDuff.Mode.SRC_ATOP);
                        }
                        ViewChipDefaultBinding viewChipDefaultBinding9 = viewOnClickListenerC0895a.f601j;
                        if (viewChipDefaultBinding9 != null && (textView = viewChipDefaultBinding9.f625c) != null) {
                            textView.setTextColor(viewOnClickListenerC0895a.f607p.f612d);
                        }
                    }
                    ViewChipDefaultBinding viewChipDefaultBinding10 = viewOnClickListenerC0895a.f601j;
                    RelativeLayout relativeLayout5 = viewChipDefaultBinding10 != null ? viewChipDefaultBinding10.f623a : null;
                    Intrinsics3.checkNotNull(relativeLayout5);
                    relativeLayout5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (relativeLayout5.getMeasuredWidth() + i > width) {
                        i2++;
                        linearLayoutM188a = chipsVerticalLinearLayout.m188a();
                        i = 0;
                    }
                    int measuredWidth = relativeLayout5.getMeasuredWidth();
                    ViewGroup.LayoutParams layoutParams2 = relativeLayout5.getLayoutParams();
                    Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    i += measuredWidth + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    linearLayoutM188a.addView(relativeLayout5);
                }
                if (width - i < width * 0.15f) {
                    i2++;
                    chipsVerticalLinearLayout.m188a();
                    i = 0;
                }
                aVar = new ChipsVerticalLinearLayout.a(i2, i);
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
            post(new RunnableC5469e(moveCursor));
            return;
        }
        int i5 = aVar.f620a;
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
            ChipsEditText chipsEditText = this.mEditText;
            chipsEditText.setSelection(chipsEditText.length());
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m8378d(Collection<?> pruneData) {
        Intrinsics3.checkNotNullParameter(pruneData, "pruneData");
        Iterator<Map.Entry<K, ViewOnClickListenerC0895a<K, V>>> it = this.mChipList.entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (!_Collections.contains(pruneData, it.next().getKey())) {
                it.remove();
                z2 = true;
            }
        }
        if (z2) {
            m8377c(true);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m8379e(ViewOnClickListenerC0895a<K, V> chip) {
        this.mChipList.remove(chip.f605n);
        Function1<? super V, Unit> function1 = this.chipDeletedListener;
        if (function1 != null) {
            function1.invoke((Object) chip.f606o);
        }
        m8377c(true);
    }

    /* JADX INFO: renamed from: f */
    public final void m8380f(ViewOnClickListenerC0895a<?, ?> rootChip) {
        for (ViewOnClickListenerC0895a<K, V> viewOnClickListenerC0895a : this.mChipList.values()) {
            if (viewOnClickListenerC0895a != rootChip) {
                viewOnClickListenerC0895a.f602k = false;
            }
        }
        m8377c(false);
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
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.mEditText.setText(str);
    }

    public final void setTextChangedListener(Function1<? super CharSequence, Unit> function1) {
        this.textChangedListener = function1;
    }
}
