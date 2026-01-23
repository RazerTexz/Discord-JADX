package p007b.p225i.p226a.p341g.p351j;

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
import com.google.android.material.C10817R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.i.a.g.j.a, reason: use source file name */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClearTextEndIconDelegate extends EndIconDelegate {

    /* JADX INFO: renamed from: d */
    public final TextWatcher f11771d;

    /* JADX INFO: renamed from: e */
    public final View.OnFocusChangeListener f11772e;

    /* JADX INFO: renamed from: f */
    public final TextInputLayout.OnEditTextAttachedListener f11773f;

    /* JADX INFO: renamed from: g */
    public final TextInputLayout.OnEndIconChangedListener f11774g;

    /* JADX INFO: renamed from: h */
    public AnimatorSet f11775h;

    /* JADX INFO: renamed from: i */
    public ValueAnimator f11776i;

    /* JADX INFO: renamed from: b.i.a.g.j.a$a */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (ClearTextEndIconDelegate.this.f11819a.getSuffixText() != null) {
                return;
            }
            ClearTextEndIconDelegate.this.m6148d(editable.length() > 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.a$b */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            ClearTextEndIconDelegate.this.m6148d((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z2);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.a$c */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
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
            editText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.f11772e);
            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.f11771d);
            editText.addTextChangedListener(ClearTextEndIconDelegate.this.f11771d);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.a$d */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class d implements TextInputLayout.OnEndIconChangedListener {

        /* JADX INFO: renamed from: b.i.a.g.j.a$d$a */
        /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ EditText f11781j;

            public a(EditText editText) {
                this.f11781j = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11781j.removeTextChangedListener(ClearTextEndIconDelegate.this.f11771d);
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
            editText.post(new a(editText));
            if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.f11772e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.a$e */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = ClearTextEndIconDelegate.this.f11819a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            ClearTextEndIconDelegate.this.f11819a.refreshEndIconDrawableState();
        }
    }

    public ClearTextEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f11771d = new a();
        this.f11772e = new b();
        this.f11773f = new c();
        this.f11774g = new d();
    }

    @Override // p007b.p225i.p226a.p341g.p351j.EndIconDelegate
    /* JADX INFO: renamed from: a */
    public void mo6146a() {
        this.f11819a.setEndIconDrawable(AppCompatResources.getDrawable(this.f11820b, C10817R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f11819a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(C10817R.string.clear_text_end_icon_content_description));
        this.f11819a.setEndIconOnClickListener(new e());
        this.f11819a.addOnEditTextAttachedListener(this.f11773f);
        this.f11819a.addOnEndIconChangedListener(this.f11774g);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ClearTextEndIconDelegate5(this));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new ClearTextEndIconDelegate4(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f11775h = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f11775h.addListener(new ClearTextEndIconDelegate2(this));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new ClearTextEndIconDelegate4(this));
        this.f11776i = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new ClearTextEndIconDelegate3(this));
    }

    @Override // p007b.p225i.p226a.p341g.p351j.EndIconDelegate
    /* JADX INFO: renamed from: c */
    public void mo6147c(boolean z2) {
        if (this.f11819a.getSuffixText() == null) {
            return;
        }
        m6148d(z2);
    }

    /* JADX INFO: renamed from: d */
    public final void m6148d(boolean z2) {
        boolean z3 = this.f11819a.isEndIconVisible() == z2;
        if (z2 && !this.f11775h.isRunning()) {
            this.f11776i.cancel();
            this.f11775h.start();
            if (z3) {
                this.f11775h.end();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        this.f11775h.cancel();
        this.f11776i.start();
        if (z3) {
            this.f11776i.end();
        }
    }
}
