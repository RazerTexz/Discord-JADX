package com.discord.rtcconnection.enums;

import android.content.Intent;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ScoAudioState.kt */
/* loaded from: classes.dex */
public enum ScoAudioState {
    Disconnected(0),
    Connected(1),
    Connecting(2),
    Error(-1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: ScoAudioState.kt */
    /* renamed from: com.discord.rtcconnection.enums.ScoAudioState$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ScoAudioState a(int i) {
            ScoAudioState[] scoAudioStateArrValues = ScoAudioState.values();
            for (int i2 = 0; i2 < 4; i2++) {
                ScoAudioState scoAudioState = scoAudioStateArrValues[i2];
                if (scoAudioState.getValue() == i) {
                    return scoAudioState;
                }
            }
            return null;
        }

        public final b b(Intent intent) {
            m.checkNotNullParameter(intent, "intent");
            if (!m.areEqual(intent.getAction(), "android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            ScoAudioState scoAudioStateA = a(intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0));
            m.checkNotNull(scoAudioStateA);
            ScoAudioState scoAudioStateA2 = a(intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", 0));
            m.checkNotNull(scoAudioStateA2);
            return new b(scoAudioStateA, scoAudioStateA2);
        }
    }

    /* compiled from: ScoAudioState.kt */
    public static final class b {
        public final ScoAudioState a;

        /* renamed from: b, reason: collision with root package name */
        public final ScoAudioState f2792b;

        public b(ScoAudioState scoAudioState, ScoAudioState scoAudioState2) {
            m.checkNotNullParameter(scoAudioState, "current");
            m.checkNotNullParameter(scoAudioState2, "previous");
            this.a = scoAudioState;
            this.f2792b = scoAudioState2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.areEqual(this.a, bVar.a) && m.areEqual(this.f2792b, bVar.f2792b);
        }

        public int hashCode() {
            ScoAudioState scoAudioState = this.a;
            int iHashCode = (scoAudioState != null ? scoAudioState.hashCode() : 0) * 31;
            ScoAudioState scoAudioState2 = this.f2792b;
            return iHashCode + (scoAudioState2 != null ? scoAudioState2.hashCode() : 0);
        }

        public String toString() {
            if (this.f2792b == ScoAudioState.Error) {
                return String.valueOf(this.a);
            }
            StringBuilder sbU = a.U("Update(");
            sbU.append(this.f2792b);
            sbU.append(" -> ");
            sbU.append(this.a);
            sbU.append(')');
            return sbU.toString();
        }
    }

    ScoAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
