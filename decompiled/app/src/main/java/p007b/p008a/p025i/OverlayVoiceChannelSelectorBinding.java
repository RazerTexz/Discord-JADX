package p007b.p008a.p025i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: OverlayVoiceChannelSelectorBinding.java */
/* renamed from: b.a.i.b1, reason: use source file name */
/* loaded from: classes.dex */
public final class OverlayVoiceChannelSelectorBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CardView f696a;

    /* renamed from: b */
    @NonNull
    public final ImageView f697b;

    /* renamed from: c */
    @NonNull
    public final CardView f698c;

    /* renamed from: d */
    @NonNull
    public final TextView f699d;

    /* renamed from: e */
    @NonNull
    public final TextInputLayout f700e;

    /* renamed from: f */
    @NonNull
    public final RecyclerView f701f;

    public OverlayVoiceChannelSelectorBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView2) {
        this.f696a = cardView;
        this.f697b = imageView;
        this.f698c = cardView2;
        this.f699d = textView;
        this.f700e = textInputLayout;
        this.f701f = recyclerView;
    }

    @NonNull
    /* renamed from: a */
    public static OverlayVoiceChannelSelectorBinding m196a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.overlay_voice_channel_selector, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.close;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.close);
        if (imageView != null) {
            CardView cardView = (CardView) viewInflate;
            i = C5419R.id.empty_results;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.empty_results);
            if (textView != null) {
                i = C5419R.id.overlay_channel_search;
                TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(C5419R.id.overlay_channel_search);
                if (textInputLayout != null) {
                    i = C5419R.id.results_rv;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C5419R.id.results_rv);
                    if (recyclerView != null) {
                        i = C5419R.id.test;
                        TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.test);
                        if (textView2 != null) {
                            return new OverlayVoiceChannelSelectorBinding(cardView, imageView, cardView, textView, textInputLayout, recyclerView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f696a;
    }
}
