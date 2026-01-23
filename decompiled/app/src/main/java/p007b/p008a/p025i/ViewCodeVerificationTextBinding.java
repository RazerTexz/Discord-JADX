package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.g2, reason: use source file name */
/* JADX INFO: compiled from: ViewCodeVerificationTextBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewCodeVerificationTextBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f866a;

    public ViewCodeVerificationTextBinding(@NonNull TextView textView) {
        this.f866a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f866a;
    }
}
