package com.discord.views.calls;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.VolumeSliderViewBinding;
import p007b.p008a.p062y.OnSeekBarChangeListenerAdapter;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: VolumeSliderView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VolumeSliderView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final VolumeSliderViewBinding binding;

    /* JADX INFO: renamed from: com.discord.views.calls.VolumeSliderView$a */
    /* JADX INFO: compiled from: VolumeSliderView.kt */
    public static final class C7111a extends OnSeekBarChangeListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function2 f19260a;

        public C7111a(Function2 function2) {
            this.f19260a = function2;
        }

        @Override // p007b.p008a.p062y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            this.f19260a.invoke(Float.valueOf(i), Boolean.valueOf(z2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VolumeSliderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.volume_slider_view, this);
        int i = C5419R.id.volume_slider_max_vol;
        ImageView imageView = (ImageView) findViewById(C5419R.id.volume_slider_max_vol);
        if (imageView != null) {
            i = C5419R.id.volume_slider_min_vol;
            ImageView imageView2 = (ImageView) findViewById(C5419R.id.volume_slider_min_vol);
            if (imageView2 != null) {
                i = C5419R.id.volume_slider_seek_bar;
                SeekBar seekBar = (SeekBar) findViewById(C5419R.id.volume_slider_seek_bar);
                if (seekBar != null) {
                    VolumeSliderViewBinding volumeSliderViewBinding = new VolumeSliderViewBinding(this, imageView, imageView2, seekBar);
                    Intrinsics3.checkNotNullExpressionValue(volumeSliderViewBinding, "VolumeSliderViewBinding.…ater.from(context), this)");
                    this.binding = volumeSliderViewBinding;
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.VolumeSliderView, 0, 0);
                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.VolumeSliderView, 0, 0)");
                        int i2 = typedArrayObtainStyledAttributes.getInt(1, 100);
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
                        if (resourceId != -1) {
                            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.volumeSliderMinVol");
                            ColorCompat2.tintWithColor(imageView2, ColorCompat.getColor(getContext(), resourceId));
                            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.volumeSliderMaxVol");
                            ColorCompat2.tintWithColor(imageView, ColorCompat.getColor(getContext(), resourceId));
                        }
                        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
                        seekBar.setMax(i2);
                        typedArrayObtainStyledAttributes.recycle();
                        return;
                    }
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setOnVolumeChange(Function2<? super Float, ? super Boolean, Unit> onVolumeChanged) {
        Intrinsics3.checkNotNullParameter(onVolumeChanged, "onVolumeChanged");
        this.binding.f1034d.setOnSeekBarChangeListener(new C7111a(onVolumeChanged));
    }
}
