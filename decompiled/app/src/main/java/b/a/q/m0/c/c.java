package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: MediaEngineConnectionLegacy.kt */
/* loaded from: classes.dex */
public final class c implements Connection.UserSpeakingStatusChangedCallback {
    public final /* synthetic */ e a;

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends d0.z.d.o implements Function0<Unit> {
        public final /* synthetic */ boolean $isUserSpeakingNow;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, boolean z2) {
            super(0);
            this.$userId = j;
            this.$isUserSpeakingNow = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            e eVar = c.this.a;
            long j = this.$userId;
            boolean z2 = this.$isUserSpeakingNow;
            Integer num = eVar.d.get(Long.valueOf(j));
            eVar.y(new g(j, num != null ? num.intValue() : 0, z2));
            return Unit.a;
        }
    }

    public c(e eVar) {
        this.a = eVar;
    }

    @Override // co.discord.media_engine.Connection.UserSpeakingStatusChangedCallback
    public void onUserSpeakingStatusChanged(long j, boolean z2, boolean z3) {
        e.x(this.a, new a(j, z2));
    }
}
