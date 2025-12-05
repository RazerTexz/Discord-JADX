package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: ViewPhoneOrEmailInputBinding.java */
/* renamed from: b.a.i.u2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPhoneOrEmailInputBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1286a;

    /* renamed from: b */
    @NonNull
    public final TextInputLayout f1287b;

    /* renamed from: c */
    @NonNull
    public final TextInputEditText f1288c;

    /* renamed from: d */
    @NonNull
    public final TextInputLayout f1289d;

    public ViewPhoneOrEmailInputBinding(@NonNull View view, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout2) {
        this.f1286a = view;
        this.f1287b = textInputLayout;
        this.f1288c = textInputEditText;
        this.f1289d = textInputLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1286a;
    }
}
