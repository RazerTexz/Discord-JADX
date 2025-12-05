package p007b.p225i.p226a.p341g.p351j;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.C10817R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: PasswordToggleEndIconDelegate.java */
/* renamed from: b.i.a.g.j.p, reason: use source file name */
/* loaded from: classes3.dex */
public class PasswordToggleEndIconDelegate extends EndIconDelegate {

    /* renamed from: d */
    public final TextWatcher f11848d;

    /* renamed from: e */
    public final TextInputLayout.OnEditTextAttachedListener f11849e;

    /* renamed from: f */
    public final TextInputLayout.OnEndIconChangedListener f11850f;

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.p$a */
    public class a extends TextWatcherAdapter {
        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PasswordToggleEndIconDelegate.this.f11821c.setChecked(!PasswordToggleEndIconDelegate.m6169d(r1));
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.p$b */
    public class b implements TextInputLayout.OnEditTextAttachedListener {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            PasswordToggleEndIconDelegate.this.f11821c.setChecked(!PasswordToggleEndIconDelegate.m6169d(r4));
            editText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.f11848d);
            editText.addTextChangedListener(PasswordToggleEndIconDelegate.this.f11848d);
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.p$c */
    public class c implements TextInputLayout.OnEndIconChangedListener {

        /* compiled from: PasswordToggleEndIconDelegate.java */
        /* renamed from: b.i.a.g.j.p$c$a */
        public class a implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ EditText f11854j;

            public a(EditText editText) {
                this.f11854j = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11854j.removeTextChangedListener(PasswordToggleEndIconDelegate.this.f11848d);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* renamed from: b.i.a.g.j.p$d */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = PasswordToggleEndIconDelegate.this.f11819a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (PasswordToggleEndIconDelegate.m6169d(PasswordToggleEndIconDelegate.this)) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            PasswordToggleEndIconDelegate.this.f11819a.refreshEndIconDrawableState();
        }
    }

    public PasswordToggleEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f11848d = new a();
        this.f11849e = new b();
        this.f11850f = new c();
    }

    /* renamed from: d */
    public static boolean m6169d(PasswordToggleEndIconDelegate passwordToggleEndIconDelegate) {
        EditText editText = passwordToggleEndIconDelegate.f11819a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // p007b.p225i.p226a.p341g.p351j.EndIconDelegate
    /* renamed from: a */
    public void mo6146a() {
        this.f11819a.setEndIconDrawable(AppCompatResources.getDrawable(this.f11820b, C10817R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f11819a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(C10817R.string.password_toggle_content_description));
        this.f11819a.setEndIconOnClickListener(new d());
        this.f11819a.addOnEditTextAttachedListener(this.f11849e);
        this.f11819a.addOnEndIconChangedListener(this.f11850f);
        EditText editText = this.f11819a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
