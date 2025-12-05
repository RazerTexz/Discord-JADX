package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.views.LoadingButton;
import com.discord.views.steps.StepsProgressIndicatorView;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewStepsBinding.java */
/* renamed from: b.a.i.y3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewStepsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f1417a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f1418b;

    /* renamed from: c */
    @NonNull
    public final TextView f1419c;

    /* renamed from: d */
    @NonNull
    public final ImageView f1420d;

    /* renamed from: e */
    @NonNull
    public final LoadingButton f1421e;

    /* renamed from: f */
    @NonNull
    public final MaterialButton f1422f;

    /* renamed from: g */
    @NonNull
    public final StepsProgressIndicatorView f1423g;

    /* renamed from: h */
    @NonNull
    public final TextView f1424h;

    /* renamed from: i */
    @NonNull
    public final ViewPager2 f1425i;

    public ViewStepsBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LoadingButton loadingButton, @NonNull MaterialButton materialButton, @NonNull StepsProgressIndicatorView stepsProgressIndicatorView, @NonNull TextView textView2, @NonNull ViewPager2 viewPager2) {
        this.f1417a = relativeLayout;
        this.f1418b = linearLayout;
        this.f1419c = textView;
        this.f1420d = imageView;
        this.f1421e = loadingButton;
        this.f1422f = materialButton;
        this.f1423g = stepsProgressIndicatorView;
        this.f1424h = textView2;
        this.f1425i = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1417a;
    }
}
