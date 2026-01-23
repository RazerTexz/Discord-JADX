package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.stages.SpeakersAdapter2;

/* JADX INFO: renamed from: b.a.i.v3, reason: use source file name */
/* JADX INFO: compiled from: ViewStageCardSpeakersBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewStageCardSpeakersBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1318a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SpeakersAdapter2 f1319b;

    public ViewStageCardSpeakersBinding(@NonNull View view, @NonNull SpeakersAdapter2 speakersAdapter2) {
        this.f1318a = view;
        this.f1319b = speakersAdapter2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1318a;
    }
}
