package p007b.p008a.p021f.p022h;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewChipDefaultBinding.java */
/* renamed from: b.a.f.h.a, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewChipDefaultBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f623a;

    /* renamed from: b */
    @NonNull
    public final ImageView f624b;

    /* renamed from: c */
    @NonNull
    public final TextView f625c;

    public ViewChipDefaultBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f623a = relativeLayout;
        this.f624b = imageView;
        this.f625c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f623a;
    }
}
