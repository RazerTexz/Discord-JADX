package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.VoiceUserView;

/* JADX INFO: renamed from: b.a.i.z0, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuVoiceMembersItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayMenuVoiceMembersItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final VoiceUserView f1433a;

    public OverlayMenuVoiceMembersItemBinding(@NonNull VoiceUserView voiceUserView) {
        this.f1433a = voiceUserView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1433a;
    }
}
