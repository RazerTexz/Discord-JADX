package p007b.p008a.p025i;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewLoadingButtonBinding.java */
/* renamed from: b.a.i.n2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewLoadingButtonBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1074a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f1075b;

    /* renamed from: c */
    @NonNull
    public final ProgressBar f1076c;

    public ViewLoadingButtonBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull ProgressBar progressBar) {
        this.f1074a = view;
        this.f1075b = materialButton;
        this.f1076c = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1074a;
    }
}
