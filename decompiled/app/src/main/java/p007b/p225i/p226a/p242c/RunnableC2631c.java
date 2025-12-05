package p007b.p225i.p226a.p242c;

import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.AudioFocusManager;
import p007b.p225i.p226a.p242c.p263t2.AudioAttributes;

/* compiled from: lambda */
/* renamed from: b.i.a.c.c */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2631c implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ AudioFocusManager.a f6163j;

    /* renamed from: k */
    public final /* synthetic */ int f6164k;

    public /* synthetic */ RunnableC2631c(AudioFocusManager.a aVar, int i) {
        this.f6163j = aVar;
        this.f6164k = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioFocusManager.a aVar = this.f6163j;
        int i = this.f6164k;
        AudioFocusManager audioFocusManager = AudioFocusManager.this;
        Objects.requireNonNull(audioFocusManager);
        if (i == -3 || i == -2) {
            if (i != -2) {
                AudioAttributes audioAttributes = audioFocusManager.f7661d;
                if (!(audioAttributes != null && audioAttributes.f7780k == 1)) {
                    audioFocusManager.m3463d(3);
                    return;
                }
            }
            audioFocusManager.m3461b(0);
            audioFocusManager.m3463d(2);
            return;
        }
        if (i == -1) {
            audioFocusManager.m3461b(-1);
            audioFocusManager.m3460a();
        } else if (i != 1) {
            outline.m852g0(38, "Unknown focus change type: ", i, "AudioFocusManager");
        } else {
            audioFocusManager.m3463d(1);
            audioFocusManager.m3461b(1);
        }
    }
}
