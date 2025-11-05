package com.discord.utilities.lazy.requester;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: GuildMemberRequestManager.kt */
/* loaded from: classes2.dex */
public final class GuildMemberRequestManager {
    private final Function2<Long, Long, Boolean> guildMemberExists;
    private final HashMap<Long, GuildMemberRequestState> guildRequestStates;
    private final Function2<Long, List<Long>, Unit> onFlush;

    /* compiled from: GuildMemberRequestManager.kt */
    public final class GuildMemberRequestState {
        private final long guildId;
        private final Function1<Long, Boolean> guildMemberExists;
        private final HashSet<Long> pendingRequests;
        private final HashSet<Long> sentRequests;
        public final /* synthetic */ GuildMemberRequestManager this$0;
        private final HashSet<Long> unacknowledgedRequests;

        /* JADX WARN: Multi-variable type inference failed */
        public GuildMemberRequestState(GuildMemberRequestManager guildMemberRequestManager, long j, Function1<? super Long, Boolean> function1) {
            m.checkNotNullParameter(function1, "guildMemberExists");
            this.this$0 = guildMemberRequestManager;
            this.guildId = j;
            this.guildMemberExists = function1;
            this.pendingRequests = new HashSet<>();
            this.sentRequests = new HashSet<>();
            this.unacknowledgedRequests = new HashSet<>();
        }

        public final void acknowledge(long userId) {
            this.unacknowledgedRequests.remove(Long.valueOf(userId));
            this.pendingRequests.remove(Long.valueOf(userId));
        }

        public final void flushRequests() {
            HashSet hashSet = new HashSet();
            Iterator<Long> it = this.pendingRequests.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                Function1<Long, Boolean> function1 = this.guildMemberExists;
                m.checkNotNullExpressionValue(next, "userId");
                if (!function1.invoke(next).booleanValue()) {
                    this.unacknowledgedRequests.add(next);
                    this.sentRequests.add(next);
                    hashSet.add(next);
                }
            }
            if (!hashSet.isEmpty()) {
                GuildMemberRequestManager.access$getOnFlush$p(this.this$0).invoke(Long.valueOf(this.guildId), u.toList(hashSet));
            }
            this.pendingRequests.clear();
        }

        public final HashSet<Long> getPendingRequests() {
            return this.pendingRequests;
        }

        public final HashSet<Long> getSentRequests() {
            return this.sentRequests;
        }

        public final HashSet<Long> getUnacknowledgedRequests() {
            return this.unacknowledgedRequests;
        }

        public final boolean request(long userId) {
            if (this.sentRequests.contains(Long.valueOf(userId)) || this.pendingRequests.contains(Long.valueOf(userId)) || this.guildMemberExists.invoke(Long.valueOf(userId)).booleanValue()) {
                return false;
            }
            this.pendingRequests.add(Long.valueOf(userId));
            return true;
        }

        public final boolean requestUnacknowledged() {
            if (this.unacknowledgedRequests.isEmpty()) {
                return false;
            }
            Iterator<Long> it = this.unacknowledgedRequests.iterator();
            m.checkNotNullExpressionValue(it, "unacknowledgedRequests.iterator()");
            while (it.hasNext()) {
                Long next = it.next();
                m.checkNotNullExpressionValue(next, "iter.next()");
                long jLongValue = next.longValue();
                if (this.guildMemberExists.invoke(Long.valueOf(jLongValue)).booleanValue()) {
                    it.remove();
                } else {
                    this.pendingRequests.add(Long.valueOf(jLongValue));
                }
            }
            return !this.pendingRequests.isEmpty();
        }
    }

    /* compiled from: GuildMemberRequestManager.kt */
    /* renamed from: com.discord.utilities.lazy.requester.GuildMemberRequestManager$getGuildRequestState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        public final boolean invoke(long j) {
            return ((Boolean) GuildMemberRequestManager.access$getGuildMemberExists$p(GuildMemberRequestManager.this).invoke(Long.valueOf(this.$guildId), Long.valueOf(j))).booleanValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberRequestManager(Function2<? super Long, ? super Long, Boolean> function2, Function2<? super Long, ? super List<Long>, Unit> function22) {
        m.checkNotNullParameter(function2, "guildMemberExists");
        m.checkNotNullParameter(function22, "onFlush");
        this.guildMemberExists = function2;
        this.onFlush = function22;
        this.guildRequestStates = new HashMap<>();
    }

    public static final /* synthetic */ Function2 access$getGuildMemberExists$p(GuildMemberRequestManager guildMemberRequestManager) {
        return guildMemberRequestManager.guildMemberExists;
    }

    public static final /* synthetic */ Function2 access$getOnFlush$p(GuildMemberRequestManager guildMemberRequestManager) {
        return guildMemberRequestManager.onFlush;
    }

    private final GuildMemberRequestState getGuildRequestState(long guildId) {
        GuildMemberRequestState guildMemberRequestState = this.guildRequestStates.get(Long.valueOf(guildId));
        if (guildMemberRequestState != null) {
            return guildMemberRequestState;
        }
        GuildMemberRequestState guildMemberRequestState2 = new GuildMemberRequestState(this, guildId, new AnonymousClass1(guildId));
        this.guildRequestStates.put(Long.valueOf(guildId), guildMemberRequestState2);
        return guildMemberRequestState2;
    }

    public final void acknowledge(long guildId, long userId) {
        getGuildRequestState(guildId).acknowledge(userId);
    }

    public final void flush() {
        Iterator<GuildMemberRequestState> it = this.guildRequestStates.values().iterator();
        while (it.hasNext()) {
            it.next().flushRequests();
        }
    }

    public final void queueRequest(long guildId, long userId) {
        getGuildRequestState(guildId).request(userId);
    }

    public final void requestUnacknowledged() {
        Collection<GuildMemberRequestState> collectionValues = this.guildRequestStates.values();
        m.checkNotNullExpressionValue(collectionValues, "guildRequestStates.values");
        int i = 0;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((GuildMemberRequestState) it.next()).requestUnacknowledged() && (i = i + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
        }
        if (i > 0) {
            flush();
        }
    }

    public final void reset() {
        this.guildRequestStates.clear();
    }
}
