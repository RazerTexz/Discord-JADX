package com.discord.widgets.media;

import b.a.d.AppViewModel;
import kotlin.Unit;

/* compiled from: WidgetMediaViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetMediaViewModel extends AppViewModel<Unit> {
    private long currentPlayerPositionMs;
    private boolean isPlaying;
    private boolean showCoverFrame;

    public WidgetMediaViewModel() {
        super(null, 1, null);
        this.isPlaying = true;
        this.showCoverFrame = true;
    }

    public final long getCurrentPlayerPositionMs() {
        return this.currentPlayerPositionMs;
    }

    public final boolean getShowCoverFrame() {
        return this.showCoverFrame;
    }

    /* renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final void setCurrentPlayerPositionMs(long j) {
        this.currentPlayerPositionMs = j;
    }

    public final void setPlaying(boolean z2) {
        this.isPlaying = z2;
    }

    public final void setShowCoverFrame(boolean z2) {
        this.showCoverFrame = z2;
    }
}
