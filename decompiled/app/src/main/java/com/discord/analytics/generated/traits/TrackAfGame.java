package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackAfGame.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfGame {
    private final Long gameId = null;
    private final CharSequence gameName = null;
    private final Boolean afNews = null;
    private final CharSequence gamePlatform = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfGame)) {
            return false;
        }
        TrackAfGame trackAfGame = (TrackAfGame) other;
        return Intrinsics3.areEqual(this.gameId, trackAfGame.gameId) && Intrinsics3.areEqual(this.gameName, trackAfGame.gameName) && Intrinsics3.areEqual(this.afNews, trackAfGame.afNews) && Intrinsics3.areEqual(this.gamePlatform, trackAfGame.gamePlatform);
    }

    public int hashCode() {
        Long l = this.gameId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.afNews;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gamePlatform;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackAfGame(gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", afNews=");
        sbM833U.append(this.afNews);
        sbM833U.append(", gamePlatform=");
        return outline.m817E(sbM833U, this.gamePlatform, ")");
    }
}
