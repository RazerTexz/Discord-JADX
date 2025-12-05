package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetRemoteAuthSuccessBinding.java */
/* renamed from: b.a.i.x5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetRemoteAuthSuccessBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1386a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f1387b;

    public WidgetRemoteAuthSuccessBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton) {
        this.f1386a = linearLayout;
        this.f1387b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1386a;
    }
}
