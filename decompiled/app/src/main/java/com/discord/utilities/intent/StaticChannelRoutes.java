package com.discord.utilities.intent;

import a0.a.a.b;
import android.net.Uri;
import b.a.d.m0.a;
import d0.g;
import d0.g0.s;
import d0.t.u;
import d0.z.d.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: StaticChannelRoutes.kt */
/* loaded from: classes2.dex */
public enum StaticChannelRoutes {
    ROLE_SUBSCRIPTIONS("role-subscriptions");

    private final String route;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy routeToName$delegate = g.lazy(StaticChannelRoutes$Companion$routeToName$2.INSTANCE);

    /* compiled from: StaticChannelRoutes.kt */
    public static final class Companion {
        private Companion() {
        }

        private final StaticChannelRoutes fromRoute(String route) {
            return getRouteToName().get(route);
        }

        private final Map<String, StaticChannelRoutes> getRouteToName() {
            Lazy lazyAccess$getRouteToName$cp = StaticChannelRoutes.access$getRouteToName$cp();
            Companion companion = StaticChannelRoutes.INSTANCE;
            return (Map) lazyAccess$getRouteToName$cp.getValue();
        }

        public final WithGuild extractStaticRoute(Uri uri) {
            String path;
            StaticChannelRoutes staticChannelRoutesFromRoute;
            Long longOrNull;
            m.checkNotNullParameter(uri, "$this$extractStaticRoute");
            if ((uri.getHost() == null || IntentUtils.INSTANCE.isHttpDomainUrl(uri)) && (path = uri.getPath()) != null) {
                a aVar = a.G;
                Regex regex = a.u;
                m.checkNotNullExpressionValue(path, "path");
                MatchResult matchResultMatchEntire = regex.matchEntire(path);
                if (matchResultMatchEntire != null && (staticChannelRoutesFromRoute = fromRoute((String) u.getOrNull(matchResultMatchEntire.getGroupValues(), 2))) != null) {
                    String str = (String) u.getOrNull(matchResultMatchEntire.getGroupValues(), 1);
                    return new WithGuild(staticChannelRoutesFromRoute, (str == null || (longOrNull = s.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue());
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StaticChannelRoutes.kt */
    public static final /* data */ class WithGuild {
        private final long guildId;
        private final StaticChannelRoutes route;

        public WithGuild(StaticChannelRoutes staticChannelRoutes, long j) {
            m.checkNotNullParameter(staticChannelRoutes, "route");
            this.route = staticChannelRoutes;
            this.guildId = j;
        }

        public static /* synthetic */ WithGuild copy$default(WithGuild withGuild, StaticChannelRoutes staticChannelRoutes, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                staticChannelRoutes = withGuild.route;
            }
            if ((i & 2) != 0) {
                j = withGuild.guildId;
            }
            return withGuild.copy(staticChannelRoutes, j);
        }

        /* renamed from: component1, reason: from getter */
        public final StaticChannelRoutes getRoute() {
            return this.route;
        }

        /* renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final WithGuild copy(StaticChannelRoutes route, long guildId) {
            m.checkNotNullParameter(route, "route");
            return new WithGuild(route, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WithGuild)) {
                return false;
            }
            WithGuild withGuild = (WithGuild) other;
            return m.areEqual(this.route, withGuild.route) && this.guildId == withGuild.guildId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final StaticChannelRoutes getRoute() {
            return this.route;
        }

        public int hashCode() {
            StaticChannelRoutes staticChannelRoutes = this.route;
            return b.a(this.guildId) + ((staticChannelRoutes != null ? staticChannelRoutes.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("WithGuild(route=");
            sbU.append(this.route);
            sbU.append(", guildId=");
            return b.d.b.a.a.C(sbU, this.guildId, ")");
        }
    }

    StaticChannelRoutes(String str) {
        this.route = str;
    }

    public static final /* synthetic */ Lazy access$getRouteToName$cp() {
        return routeToName$delegate;
    }

    public final String getRoute() {
        return this.route;
    }
}
