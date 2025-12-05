package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallBlurredGridView;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallGridView;

/* compiled from: WidgetCallFullscreenPrivateCallBinding.java */
/* renamed from: b.a.i.q4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetCallFullscreenPrivateCallBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f1151a;

    /* renamed from: b */
    @NonNull
    public final PrivateCallBlurredGridView f1152b;

    /* renamed from: c */
    @NonNull
    public final TextView f1153c;

    /* renamed from: d */
    @NonNull
    public final RelativeLayout f1154d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f1155e;

    /* renamed from: f */
    @NonNull
    public final PrivateCallGridView f1156f;

    /* renamed from: g */
    @NonNull
    public final TextView f1157g;

    /* renamed from: h */
    @NonNull
    public final TextView f1158h;

    /* renamed from: i */
    @NonNull
    public final TextView f1159i;

    public WidgetCallFullscreenPrivateCallBinding(@NonNull RelativeLayout relativeLayout, @NonNull PrivateCallBlurredGridView privateCallBlurredGridView, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout, @NonNull PrivateCallGridView privateCallGridView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f1151a = relativeLayout;
        this.f1152b = privateCallBlurredGridView;
        this.f1153c = textView;
        this.f1154d = relativeLayout2;
        this.f1155e = linearLayout;
        this.f1156f = privateCallGridView;
        this.f1157g = textView2;
        this.f1158h = textView3;
        this.f1159i = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1151a;
    }
}
