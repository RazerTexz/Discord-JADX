package b.i.a.g.j;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: ClearTextEndIconDelegate.java */
/* loaded from: classes3.dex */
public class a extends m {
    public final TextWatcher d;
    public final View.OnFocusChangeListener e;
    public final TextInputLayout.OnEditTextAttachedListener f;
    public final TextInputLayout.OnEndIconChangedListener g;
    public AnimatorSet h;
    public ValueAnimator i;

    /* compiled from: ClearTextEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.a$a, reason: collision with other inner class name */
    public class C0125a implements TextWatcher {
        public C0125a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (a.this.a.getSuffixText() != null) {
                return;
            }
            a.this.d(editable.length() > 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            a.this.d((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z2);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class c implements TextInputLayout.OnEditTextAttachedListener {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            boolean z2 = true;
            if (editText.hasFocus()) {
                if (!(editText.getText().length() > 0)) {
                }
            } else {
                z2 = false;
            }
            textInputLayout.setEndIconVisible(z2);
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.e);
            editText.removeTextChangedListener(a.this.d);
            editText.addTextChangedListener(a.this.d);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class d implements TextInputLayout.OnEndIconChangedListener {

        /* compiled from: ClearTextEndIconDelegate.java */
        /* renamed from: b.i.a.g.j.a$d$a, reason: collision with other inner class name */
        public class RunnableC0126a implements Runnable {
            public final /* synthetic */ EditText j;

            public RunnableC0126a(EditText editText) {
                this.j = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.j.removeTextChangedListener(a.this.d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 2) {
                return;
            }
            editText.post(new RunnableC0126a(editText));
            if (editText.getOnFocusChangeListener() == a.this.e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.refreshEndIconDrawableState();
        }
    }

    public a(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new C0125a();
        this.e = new b();
        this.f = new c();
        this.g = new d();
    }

    @Override // b.i.a.g.j.m
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f1626b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.addOnEditTextAttachedListener(this.f);
        this.a.addOnEndIconChangedListener(this.g);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new b.i.a.g.j.e(this));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new b.i.a.g.j.d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.h.addListener(new b.i.a.g.j.b(this));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new b.i.a.g.j.d(this));
        this.i = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new b.i.a.g.j.c(this));
    }

    @Override // b.i.a.g.j.m
    public void c(boolean z2) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        d(z2);
    }

    public final void d(boolean z2) {
        boolean z3 = this.a.isEndIconVisible() == z2;
        if (z2 && !this.h.isRunning()) {
            this.i.cancel();
            this.h.start();
            if (z3) {
                this.h.end();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        this.h.cancel();
        this.i.start();
        if (z3) {
            this.i.end();
        }
    }
}
