package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: VolumeSliderViewBinding.java */
/* renamed from: b.a.i.l4, reason: use source file name */
/* loaded from: classes.dex */
public final class VolumeSliderViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1031a;

    /* renamed from: b */
    @NonNull
    public final ImageView f1032b;

    /* renamed from: c */
    @NonNull
    public final ImageView f1033c;

    /* renamed from: d */
    @NonNull
    public final SeekBar f1034d;

    public VolumeSliderViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull SeekBar seekBar) {
        this.f1031a = view;
        this.f1032b = imageView;
        this.f1033c = imageView2;
        this.f1034d = seekBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1031a;
    }
}
