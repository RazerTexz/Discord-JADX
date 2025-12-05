package co.discord.media_engine;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: VoiceQuality.kt */
/* renamed from: co.discord.media_engine.Duration, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class VoiceQuality2 {
    private int connected;
    private int listening;
    private int participation;
    private int speaking;

    public VoiceQuality2(int i, int i2, int i3, int i4) {
        this.listening = i;
        this.speaking = i2;
        this.participation = i3;
        this.connected = i4;
    }

    public static /* synthetic */ VoiceQuality2 copy$default(VoiceQuality2 voiceQuality2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = voiceQuality2.listening;
        }
        if ((i5 & 2) != 0) {
            i2 = voiceQuality2.speaking;
        }
        if ((i5 & 4) != 0) {
            i3 = voiceQuality2.participation;
        }
        if ((i5 & 8) != 0) {
            i4 = voiceQuality2.connected;
        }
        return voiceQuality2.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getListening() {
        return this.listening;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSpeaking() {
        return this.speaking;
    }

    /* renamed from: component3, reason: from getter */
    public final int getParticipation() {
        return this.participation;
    }

    /* renamed from: component4, reason: from getter */
    public final int getConnected() {
        return this.connected;
    }

    public final VoiceQuality2 copy(int listening, int speaking, int participation, int connected) {
        return new VoiceQuality2(listening, speaking, participation, connected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality2)) {
            return false;
        }
        VoiceQuality2 voiceQuality2 = (VoiceQuality2) other;
        return this.listening == voiceQuality2.listening && this.speaking == voiceQuality2.speaking && this.participation == voiceQuality2.participation && this.connected == voiceQuality2.connected;
    }

    public final int getConnected() {
        return this.connected;
    }

    public final int getListening() {
        return this.listening;
    }

    public final int getParticipation() {
        return this.participation;
    }

    public final int getSpeaking() {
        return this.speaking;
    }

    public int hashCode() {
        return (((((this.listening * 31) + this.speaking) * 31) + this.participation) * 31) + this.connected;
    }

    public final void setConnected(int i) {
        this.connected = i;
    }

    public final void setListening(int i) {
        this.listening = i;
    }

    public final void setParticipation(int i) {
        this.participation = i;
    }

    public final void setSpeaking(int i) {
        this.speaking = i;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Duration(listening=");
        sbM833U.append(this.listening);
        sbM833U.append(", speaking=");
        sbM833U.append(this.speaking);
        sbM833U.append(", participation=");
        sbM833U.append(this.participation);
        sbM833U.append(", connected=");
        return outline.m814B(sbM833U, this.connected, ")");
    }
}
