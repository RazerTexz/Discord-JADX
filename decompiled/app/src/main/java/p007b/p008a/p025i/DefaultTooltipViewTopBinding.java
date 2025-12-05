package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: DefaultTooltipViewTopBinding.java */
/* renamed from: b.a.i.j, reason: use source file name */
/* loaded from: classes.dex */
public final class DefaultTooltipViewTopBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f964a;

    /* renamed from: b */
    @NonNull
    public final TextView f965b;

    public DefaultTooltipViewTopBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.f964a = constraintLayout;
        this.f965b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f964a;
    }
}
