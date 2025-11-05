package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;

/* compiled from: WidgetHomePanelCenterBinding.java */
/* loaded from: classes.dex */
public final class i5 implements ViewBinding {

    @NonNull
    public final RoundedRelativeLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FragmentContainerView f136b;

    @NonNull
    public final j5 c;

    @NonNull
    public final FragmentContainerView d;

    public i5(@NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull j5 j5Var, @NonNull FragmentContainerView fragmentContainerView2) {
        this.a = roundedRelativeLayout;
        this.f136b = fragmentContainerView;
        this.c = j5Var;
        this.d = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
