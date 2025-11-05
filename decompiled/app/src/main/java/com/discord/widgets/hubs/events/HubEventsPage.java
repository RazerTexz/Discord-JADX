package com.discord.widgets.hubs.events;

import b.d.b.a.a;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.analytics.Traits;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubEventsPageAdapter.kt */
/* loaded from: classes2.dex */
public abstract class HubEventsPage {
    public static final int ENTRY = 2;
    public static final int FOOTER = 1;
    public static final int HEADER = 0;
    private final int viewType;

    /* compiled from: WidgetHubEventsPageAdapter.kt */
    public static final /* data */ class Event extends HubEventsPage {
        private final HubGuildScheduledEventData guildScheduledEventData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(HubGuildScheduledEventData hubGuildScheduledEventData) {
            super(2, null);
            m.checkNotNullParameter(hubGuildScheduledEventData, "guildScheduledEventData");
            this.guildScheduledEventData = hubGuildScheduledEventData;
        }

        public static /* synthetic */ Event copy$default(Event event, HubGuildScheduledEventData hubGuildScheduledEventData, int i, Object obj) {
            if ((i & 1) != 0) {
                hubGuildScheduledEventData = event.guildScheduledEventData;
            }
            return event.copy(hubGuildScheduledEventData);
        }

        /* renamed from: component1, reason: from getter */
        public final HubGuildScheduledEventData getGuildScheduledEventData() {
            return this.guildScheduledEventData;
        }

        public final Event copy(HubGuildScheduledEventData guildScheduledEventData) {
            m.checkNotNullParameter(guildScheduledEventData, "guildScheduledEventData");
            return new Event(guildScheduledEventData);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Event) && m.areEqual(this.guildScheduledEventData, ((Event) other).guildScheduledEventData);
            }
            return true;
        }

        public final HubGuildScheduledEventData getGuildScheduledEventData() {
            return this.guildScheduledEventData;
        }

        public int hashCode() {
            HubGuildScheduledEventData hubGuildScheduledEventData = this.guildScheduledEventData;
            if (hubGuildScheduledEventData != null) {
                return hubGuildScheduledEventData.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("Event(guildScheduledEventData=");
            sbU.append(this.guildScheduledEventData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetHubEventsPageAdapter.kt */
    public static final /* data */ class Footer extends HubEventsPage {
        private final RestCallState<List<DirectoryEntryEvent>> eventsAsync;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Footer(RestCallState<? extends List<DirectoryEntryEvent>> restCallState) {
            super(1, null);
            m.checkNotNullParameter(restCallState, "eventsAsync");
            this.eventsAsync = restCallState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Footer copy$default(Footer footer, RestCallState restCallState, int i, Object obj) {
            if ((i & 1) != 0) {
                restCallState = footer.eventsAsync;
            }
            return footer.copy(restCallState);
        }

        public final RestCallState<List<DirectoryEntryEvent>> component1() {
            return this.eventsAsync;
        }

        public final Footer copy(RestCallState<? extends List<DirectoryEntryEvent>> eventsAsync) {
            m.checkNotNullParameter(eventsAsync, "eventsAsync");
            return new Footer(eventsAsync);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Footer) && m.areEqual(this.eventsAsync, ((Footer) other).eventsAsync);
            }
            return true;
        }

        public final RestCallState<List<DirectoryEntryEvent>> getEventsAsync() {
            return this.eventsAsync;
        }

        public int hashCode() {
            RestCallState<List<DirectoryEntryEvent>> restCallState = this.eventsAsync;
            if (restCallState != null) {
                return restCallState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("Footer(eventsAsync=");
            sbU.append(this.eventsAsync);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetHubEventsPageAdapter.kt */
    public static final class Header extends HubEventsPage {
        public static final Header INSTANCE = new Header();

        private Header() {
            super(0, null);
        }
    }

    private HubEventsPage(int i) {
        this.viewType = i;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ HubEventsPage(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
