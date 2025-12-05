package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

/* compiled from: MultiValuePropPremiumUpsellDialogBinding.java */
/* renamed from: b.a.i.w0, reason: use source file name */
/* loaded from: classes.dex */
public final class MultiValuePropPremiumUpsellDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f1332a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f1333b;

    /* renamed from: c */
    @NonNull
    public final TabLayout f1334c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f1335d;

    /* renamed from: e */
    @NonNull
    public final MaterialButton f1336e;

    /* renamed from: f */
    @NonNull
    public final ViewPager2 f1337f;

    public MultiValuePropPremiumUpsellDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull View view, @NonNull TabLayout tabLayout, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull ViewPager2 viewPager2) {
        this.f1332a = relativeLayout;
        this.f1333b = materialButton;
        this.f1334c = tabLayout;
        this.f1335d = materialButton2;
        this.f1336e = materialButton3;
        this.f1337f = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1332a;
    }
}
