package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetMusicRichPresenceBinding.java */
/* renamed from: b.a.i.s5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetMusicRichPresenceBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1219a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f1220b;

    /* renamed from: c */
    @NonNull
    public final TextView f1221c;

    /* renamed from: d */
    @NonNull
    public final TextView f1222d;

    /* renamed from: e */
    @NonNull
    public final SimpleDraweeView f1223e;

    /* renamed from: f */
    @NonNull
    public final SimpleDraweeView f1224f;

    /* renamed from: g */
    @NonNull
    public final TextView f1225g;

    /* renamed from: h */
    @NonNull
    public final TextView f1226h;

    /* renamed from: i */
    @NonNull
    public final MaterialButton f1227i;

    /* renamed from: j */
    @NonNull
    public final SeekBar f1228j;

    /* renamed from: k */
    @NonNull
    public final TextView f1229k;

    /* renamed from: l */
    @NonNull
    public final TextView f1230l;

    public WidgetMusicRichPresenceBinding(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton, @NonNull SeekBar seekBar, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.f1219a = linearLayout;
        this.f1220b = linearLayout2;
        this.f1221c = textView;
        this.f1222d = textView2;
        this.f1223e = simpleDraweeView;
        this.f1224f = simpleDraweeView2;
        this.f1225g = textView3;
        this.f1226h = textView4;
        this.f1227i = materialButton;
        this.f1228j = seekBar;
        this.f1229k = textView5;
        this.f1230l = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1219a;
    }
}
