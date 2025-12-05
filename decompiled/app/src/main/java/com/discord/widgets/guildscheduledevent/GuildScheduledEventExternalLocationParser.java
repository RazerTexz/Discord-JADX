package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildScheduledEventExternalLocationParser.kt */
/* loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy PARSER$delegate = LazyJVM.lazy(GuildScheduledEventExternalLocationParser2.INSTANCE);
    private Cache cache = new Cache("", "");

    /* compiled from: GuildScheduledEventExternalLocationParser.kt */
    public static final /* data */ class Cache {
        private final String location;
        private final CharSequence output;

        public Cache(String str, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            Intrinsics3.checkNotNullParameter(charSequence, "output");
            this.location = str;
            this.output = charSequence;
        }

        public static /* synthetic */ Cache copy$default(Cache cache, String str, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cache.location;
            }
            if ((i & 2) != 0) {
                charSequence = cache.output;
            }
            return cache.copy(str, charSequence);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLocation() {
            return this.location;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getOutput() {
            return this.output;
        }

        public final Cache copy(String location, CharSequence output) {
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            Intrinsics3.checkNotNullParameter(output, "output");
            return new Cache(location, output);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cache)) {
                return false;
            }
            Cache cache = (Cache) other;
            return Intrinsics3.areEqual(this.location, cache.location) && Intrinsics3.areEqual(this.output, cache.output);
        }

        public final String getLocation() {
            return this.location;
        }

        public final CharSequence getOutput() {
            return this.output;
        }

        public int hashCode() {
            String str = this.location;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            CharSequence charSequence = this.output;
            return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Cache(location=");
            sbM833U.append(this.location);
            sbM833U.append(", output=");
            return outline.m817E(sbM833U, this.output, ")");
        }
    }

    /* compiled from: GuildScheduledEventExternalLocationParser.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Parser access$getPARSER$p(Companion companion) {
            return companion.getPARSER();
        }

        private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getPARSER() {
            Lazy lazyAccess$getPARSER$cp = GuildScheduledEventExternalLocationParser.access$getPARSER$cp();
            Companion companion = GuildScheduledEventExternalLocationParser.INSTANCE;
            return (Parser) lazyAccess$getPARSER$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Lazy access$getPARSER$cp() {
        return PARSER$delegate;
    }

    private final CharSequence parse(Context context, String location) {
        if (Intrinsics3.areEqual(this.cache.getLocation(), location)) {
            return this.cache.getOutput();
        }
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(Parser.parse$default(Companion.access$getPARSER$p(INSTANCE), location, MessageParseState.INSTANCE.getInitialState(), null, 4, null), new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, null, null, null, 16376, null));
        this.cache = new Cache(location, draweeSpanStringBuilderRender);
        return draweeSpanStringBuilderRender;
    }

    public final CharSequence getTextFromLocation(Context context, GuildScheduledEventLocationInfo locationInfo) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(locationInfo, "locationInfo");
        if (locationInfo instanceof GuildScheduledEventLocationInfo.ChannelLocation) {
            return locationInfo.getLocationName();
        }
        if (locationInfo instanceof GuildScheduledEventLocationInfo.ExternalLocation) {
            return parse(context, locationInfo.getLocationName());
        }
        throw new NoWhenBranchMatchedException();
    }
}
