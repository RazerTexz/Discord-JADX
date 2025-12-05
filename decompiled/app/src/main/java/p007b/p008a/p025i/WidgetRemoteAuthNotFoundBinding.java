package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetRemoteAuthNotFoundBinding.java */
/* renamed from: b.a.i.v5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetRemoteAuthNotFoundBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1326a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f1327b;

    public WidgetRemoteAuthNotFoundBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton) {
        this.f1326a = linearLayout;
        this.f1327b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1326a;
    }
}
