package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: DefaultTooltipViewBottomBinding.java */
/* renamed from: b.a.i.i, reason: use source file name */
/* loaded from: classes.dex */
public final class DefaultTooltipViewBottomBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f935a;

    /* renamed from: b */
    @NonNull
    public final TextView f936b;

    public DefaultTooltipViewBottomBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.f935a = constraintLayout;
        this.f936b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f935a;
    }
}
