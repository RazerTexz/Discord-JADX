package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* compiled from: WidgetChatInputStickerSuggestionsBinding.java */
/* renamed from: b.a.i.x4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChatInputStickerSuggestionsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1380a;

    /* renamed from: b */
    @NonNull
    public final StickerView f1381b;

    /* renamed from: c */
    @NonNull
    public final StickerView f1382c;

    /* renamed from: d */
    @NonNull
    public final StickerView f1383d;

    /* renamed from: e */
    @NonNull
    public final StickerView f1384e;

    /* renamed from: f */
    @NonNull
    public final ImageView f1385f;

    public WidgetChatInputStickerSuggestionsBinding(@NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull StickerView stickerView2, @NonNull StickerView stickerView3, @NonNull StickerView stickerView4, @NonNull ImageView imageView) {
        this.f1380a = linearLayout;
        this.f1381b = stickerView;
        this.f1382c = stickerView2;
        this.f1383d = stickerView3;
        this.f1384e = stickerView4;
        this.f1385f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1380a;
    }
}
