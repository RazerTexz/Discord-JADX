package p007b.p008a.p062y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.discord.C5419R;
import com.discord.views.OverlayMenuBubbleDialog;
import com.discord.views.VoiceUserView;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.OverlayMenuVoiceMembersItemBinding;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: OverlayMenuBubbleDialog.kt */
/* renamed from: b.a.y.n, reason: use source file name */
/* loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog2 extends Lambda implements Function2<LayoutInflater, ViewGroup, OverlayMenuBubbleDialog.C7081a> {

    /* renamed from: j */
    public static final OverlayMenuBubbleDialog2 f2050j = new OverlayMenuBubbleDialog2();

    public OverlayMenuBubbleDialog2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public OverlayMenuBubbleDialog.C7081a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics3.checkNotNullParameter(layoutInflater2, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(C5419R.layout.overlay_menu_voice_members_item, viewGroup2, false);
        Objects.requireNonNull(viewInflate, "rootView");
        OverlayMenuVoiceMembersItemBinding overlayMenuVoiceMembersItemBinding = new OverlayMenuVoiceMembersItemBinding((VoiceUserView) viewInflate);
        Intrinsics3.checkNotNullExpressionValue(overlayMenuVoiceMembersItemBinding, "OverlayMenuVoiceMembersI…tInflater, parent, false)");
        return new OverlayMenuBubbleDialog.C7081a(overlayMenuVoiceMembersItemBinding);
    }
}
