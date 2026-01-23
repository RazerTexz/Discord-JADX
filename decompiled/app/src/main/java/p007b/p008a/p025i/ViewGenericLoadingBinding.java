package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.j2, reason: use source file name */
/* JADX INFO: compiled from: ViewGenericLoadingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGenericLoadingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f972a;

    public ViewGenericLoadingBinding(@NonNull FrameLayout frameLayout) {
        this.f972a = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f972a;
    }
}
