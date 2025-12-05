package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: SparkleViewBinding.java */
/* renamed from: b.a.i.q1, reason: use source file name */
/* loaded from: classes.dex */
public final class SparkleViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1144a;

    /* renamed from: b */
    @NonNull
    public final ImageView f1145b;

    public SparkleViewBinding(@NonNull View view, @NonNull ImageView imageView) {
        this.f1144a = view;
        this.f1145b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1144a;
    }
}
