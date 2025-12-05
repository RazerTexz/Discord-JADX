package p007b.p008a.p041q.p042k0;

import android.media.AudioManager;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: DiscordAudioManager.kt */
/* renamed from: b.a.q.k0.e, reason: use source file name */
/* loaded from: classes.dex */
public final class DiscordAudioManager2 implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: j */
    public final /* synthetic */ DiscordAudioManager f1658j;

    public DiscordAudioManager2(DiscordAudioManager discordAudioManager) {
        this.f1658j = discordAudioManager;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        AnimatableValueParser.m501b1("DiscordAudioManager", "[AudioFocus] new focus: " + i);
        if (i == -3 || i == -2) {
            this.f1658j.m8489i(false);
        } else {
            if (i != 1) {
                return;
            }
            this.f1658j.m8489i(true);
            this.f1658j.m8492l();
        }
    }
}
