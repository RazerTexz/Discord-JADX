package com.discord.utilities.intent;

import android.net.Uri;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.p019m0.RoutingPatterns;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: StaticChannelRoutes.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum StaticChannelRoutes {
    ROLE_SUBSCRIPTIONS("role-subscriptions");

    private final String route;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy routeToName$delegate = LazyJVM.lazy(StaticChannelRoutes2.INSTANCE);

    /* JADX INFO: compiled from: StaticChannelRoutes.kt */
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
            Intrinsics3.checkNotNullParameter(uri, "$this$extractStaticRoute");
            if ((uri.getHost() == null || IntentUtils.INSTANCE.isHttpDomainUrl(uri)) && (path = uri.getPath()) != null) {
                RoutingPatterns routingPatterns = RoutingPatterns.f538G;
                Regex regex = RoutingPatterns.f559u;
                Intrinsics3.checkNotNullExpressionValue(path, "path");
                MatchResult matchResultMatchEntire = regex.matchEntire(path);
                if (matchResultMatchEntire != null && (staticChannelRoutesFromRoute = fromRoute((String) _Collections.getOrNull(matchResultMatchEntire.getGroupValues(), 2))) != null) {
                    String str = (String) _Collections.getOrNull(matchResultMatchEntire.getGroupValues(), 1);
                    return new WithGuild(staticChannelRoutesFromRoute, (str == null || (longOrNull = StringNumberConversions.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue());
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StaticChannelRoutes.kt */
    public static final /* data */ class WithGuild {
        private final long guildId;
        private final StaticChannelRoutes route;

        public WithGuild(StaticChannelRoutes staticChannelRoutes, long j) {
            Intrinsics3.checkNotNullParameter(staticChannelRoutes, "route");
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

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StaticChannelRoutes getRoute() {
            return this.route;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final WithGuild copy(StaticChannelRoutes route, long guildId) {
            Intrinsics3.checkNotNullParameter(route, "route");
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
            return Intrinsics3.areEqual(this.route, withGuild.route) && this.guildId == withGuild.guildId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final StaticChannelRoutes getRoute() {
            return this.route;
        }

        public int hashCode() {
            StaticChannelRoutes staticChannelRoutes = this.route;
            return C0002b.m3a(this.guildId) + ((staticChannelRoutes != null ? staticChannelRoutes.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("WithGuild(route=");
            sbM833U.append(this.route);
            sbM833U.append(", guildId=");
            return outline.m815C(sbM833U, this.guildId, ")");
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
