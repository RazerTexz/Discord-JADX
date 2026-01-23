package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.x5, reason: use source file name */
/* JADX INFO: compiled from: WidgetRemoteAuthSuccessBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetRemoteAuthSuccessBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1386a;

    /* JADX INFO: renamed from: b */
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
