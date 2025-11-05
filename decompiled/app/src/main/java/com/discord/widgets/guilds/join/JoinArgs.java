package com.discord.widgets.guilds.join;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.guild.Guild;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Subscription;

/* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* loaded from: classes2.dex */
public final /* data */ class JoinArgs extends CaptchaArgs {
    private final Long directoryChannelId;
    private final Class<?> errorClass;
    private final Function1<Error, Unit> errorHandler;
    private final long guildId;
    private final boolean isLurker;
    private final Function1<Guild, Unit> onNext;
    private final String sessionId;
    private final Function1<Subscription, Unit> subscriptionHandler;

    public /* synthetic */ JoinArgs(long j, boolean z2, String str, Long l, Class cls, Function1 function1, Function1 function12, Function1 function13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z2, str, l, cls, (i & 32) != 0 ? null : function1, (i & 64) != 0 ? null : function12, function13);
    }

    public static /* synthetic */ JoinArgs copy$default(JoinArgs joinArgs, long j, boolean z2, String str, Long l, Class cls, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
        return joinArgs.copy((i & 1) != 0 ? joinArgs.guildId : j, (i & 2) != 0 ? joinArgs.isLurker : z2, (i & 4) != 0 ? joinArgs.sessionId : str, (i & 8) != 0 ? joinArgs.directoryChannelId : l, (i & 16) != 0 ? joinArgs.errorClass : cls, (i & 32) != 0 ? joinArgs.subscriptionHandler : function1, (i & 64) != 0 ? joinArgs.errorHandler : function12, (i & 128) != 0 ? joinArgs.onNext : function13);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsLurker() {
        return this.isLurker;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final Class<?> component5() {
        return this.errorClass;
    }

    public final Function1<Subscription, Unit> component6() {
        return this.subscriptionHandler;
    }

    public final Function1<Error, Unit> component7() {
        return this.errorHandler;
    }

    public final Function1<Guild, Unit> component8() {
        return this.onNext;
    }

    public final JoinArgs copy(long guildId, boolean isLurker, String sessionId, Long directoryChannelId, Class<?> errorClass, Function1<? super Subscription, Unit> subscriptionHandler, Function1<? super Error, Unit> errorHandler, Function1<? super Guild, Unit> onNext) {
        m.checkNotNullParameter(errorClass, "errorClass");
        m.checkNotNullParameter(onNext, "onNext");
        return new JoinArgs(guildId, isLurker, sessionId, directoryChannelId, errorClass, subscriptionHandler, errorHandler, onNext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinArgs)) {
            return false;
        }
        JoinArgs joinArgs = (JoinArgs) other;
        return this.guildId == joinArgs.guildId && this.isLurker == joinArgs.isLurker && m.areEqual(this.sessionId, joinArgs.sessionId) && m.areEqual(this.directoryChannelId, joinArgs.directoryChannelId) && m.areEqual(this.errorClass, joinArgs.errorClass) && m.areEqual(this.subscriptionHandler, joinArgs.subscriptionHandler) && m.areEqual(this.errorHandler, joinArgs.errorHandler) && m.areEqual(this.onNext, joinArgs.onNext);
    }

    public final Long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final Class<?> getErrorClass() {
        return this.errorClass;
    }

    public final Function1<Error, Unit> getErrorHandler() {
        return this.errorHandler;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final Function1<Guild, Unit> getOnNext() {
        return this.onNext;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final Function1<Subscription, Unit> getSubscriptionHandler() {
        return this.subscriptionHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        boolean z2 = this.isLurker;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iA + i) * 31;
        String str = this.sessionId;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.directoryChannelId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Class<?> cls = this.errorClass;
        int iHashCode3 = (iHashCode2 + (cls != null ? cls.hashCode() : 0)) * 31;
        Function1<Subscription, Unit> function1 = this.subscriptionHandler;
        int iHashCode4 = (iHashCode3 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Function1<Error, Unit> function12 = this.errorHandler;
        int iHashCode5 = (iHashCode4 + (function12 != null ? function12.hashCode() : 0)) * 31;
        Function1<Guild, Unit> function13 = this.onNext;
        return iHashCode5 + (function13 != null ? function13.hashCode() : 0);
    }

    public final boolean isLurker() {
        return this.isLurker;
    }

    public String toString() {
        StringBuilder sbU = a.U("JoinArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", isLurker=");
        sbU.append(this.isLurker);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", errorClass=");
        sbU.append(this.errorClass);
        sbU.append(", subscriptionHandler=");
        sbU.append(this.subscriptionHandler);
        sbU.append(", errorHandler=");
        sbU.append(this.errorHandler);
        sbU.append(", onNext=");
        sbU.append(this.onNext);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JoinArgs(long j, boolean z2, String str, Long l, Class<?> cls, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function12, Function1<? super Guild, Unit> function13) {
        super(null);
        m.checkNotNullParameter(cls, "errorClass");
        m.checkNotNullParameter(function13, "onNext");
        this.guildId = j;
        this.isLurker = z2;
        this.sessionId = str;
        this.directoryChannelId = l;
        this.errorClass = cls;
        this.subscriptionHandler = function1;
        this.errorHandler = function12;
        this.onNext = function13;
    }
}
