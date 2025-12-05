package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;

/* compiled from: ViewCodeVerificationBinding.java */
/* renamed from: b.a.i.e2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewCodeVerificationBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FlexboxLayout f808a;

    /* renamed from: b */
    @NonNull
    public final FlexboxLayout f809b;

    public ViewCodeVerificationBinding(@NonNull FlexboxLayout flexboxLayout, @NonNull FlexboxLayout flexboxLayout2) {
        this.f808a = flexboxLayout;
        this.f809b = flexboxLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f808a;
    }
}
