package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;

/* compiled from: SearchInputViewBinding.java */
/* renamed from: b.a.i.j1, reason: use source file name */
/* loaded from: classes.dex */
public final class SearchInputViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f969a;

    /* renamed from: b */
    @NonNull
    public final ImageView f970b;

    /* renamed from: c */
    @NonNull
    public final TextInputEditText f971c;

    public SearchInputViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextInputEditText textInputEditText) {
        this.f969a = view;
        this.f970b = imageView;
        this.f971c = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f969a;
    }
}
