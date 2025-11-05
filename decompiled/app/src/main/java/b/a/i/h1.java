package b.a.i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ReactionQuickAddBinding.java */
/* loaded from: classes.dex */
public final class h1 implements ViewBinding {

    @NonNull
    public final ImageView a;

    public h1(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.a = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
