package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.typing.TypingDot;

/* compiled from: TypingDotsViewBinding.java */
/* renamed from: b.a.i.t1, reason: use source file name */
/* loaded from: classes.dex */
public final class TypingDotsViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1239a;

    /* renamed from: b */
    @NonNull
    public final TypingDot f1240b;

    /* renamed from: c */
    @NonNull
    public final TypingDot f1241c;

    /* renamed from: d */
    @NonNull
    public final TypingDot f1242d;

    public TypingDotsViewBinding(@NonNull View view, @NonNull TypingDot typingDot, @NonNull TypingDot typingDot2, @NonNull TypingDot typingDot3) {
        this.f1239a = view;
        this.f1240b = typingDot;
        this.f1241c = typingDot2;
        this.f1242d = typingDot3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1239a;
    }
}
