package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewMobileReportBlockUserBinding.java */
/* renamed from: b.a.i.o2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewMobileReportBlockUserBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1102a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f1103b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f1104c;

    /* renamed from: d */
    @NonNull
    public final TextView f1105d;

    public ViewMobileReportBlockUserBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1102a = linearLayout;
        this.f1103b = simpleDraweeView;
        this.f1104c = materialButton;
        this.f1105d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1102a;
    }
}
