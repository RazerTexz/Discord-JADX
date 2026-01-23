package p007b.p008a.p041q.p042k0;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.rtcconnection.enums.ScoAudioState;
import p007b.p008a.p041q.p043l0.WiredHeadsetState;

/* JADX INFO: renamed from: b.a.q.k0.h, reason: use source file name */
/* JADX INFO: compiled from: OnAudioManagerBroadcastListener.kt */
/* JADX INFO: loaded from: classes.dex */
@MainThread
public interface OnAudioManagerBroadcastListener {
    /* JADX INFO: renamed from: a */
    void mo281a(Context context, boolean z2);

    /* JADX INFO: renamed from: b */
    void mo282b(Context context, ScoAudioState.C5637b c5637b);

    /* JADX INFO: renamed from: c */
    void mo283c(Context context);

    /* JADX INFO: renamed from: d */
    void mo284d(Context context, boolean z2);

    /* JADX INFO: renamed from: e */
    void mo285e(Context context, WiredHeadsetState wiredHeadsetState);
}
