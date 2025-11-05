package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: GifSearchEmptyStateTextBoxViewBinding.java */
/* loaded from: classes.dex */
public final class q implements ViewBinding {

    @NonNull
    public final TextView a;

    public q(@NonNull TextView textView) {
        this.a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
