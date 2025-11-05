package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;

/* compiled from: ViewCodeVerificationBinding.java */
/* loaded from: classes.dex */
public final class e2 implements ViewBinding {

    @NonNull
    public final FlexboxLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f104b;

    public e2(@NonNull FlexboxLayout flexboxLayout, @NonNull FlexboxLayout flexboxLayout2) {
        this.a = flexboxLayout;
        this.f104b = flexboxLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
