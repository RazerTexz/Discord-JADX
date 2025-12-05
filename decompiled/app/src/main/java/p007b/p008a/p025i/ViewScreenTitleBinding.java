package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewScreenTitleBinding.java */
/* renamed from: b.a.i.e3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewScreenTitleBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f810a;

    /* renamed from: b */
    @NonNull
    public final TextView f811b;

    /* renamed from: c */
    @NonNull
    public final TextView f812c;

    public ViewScreenTitleBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f810a = linearLayout;
        this.f811b = textView;
        this.f812c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f810a;
    }
}
