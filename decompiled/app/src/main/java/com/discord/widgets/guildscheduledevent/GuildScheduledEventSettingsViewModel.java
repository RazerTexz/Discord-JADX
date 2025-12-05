package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: GuildScheduledEventSettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class GuildScheduledEventSettingsViewModel extends AppViewModel<ViewState> {
    public static final int SAMPLE_USER_COUNT = 1;

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    public enum DateError {
        INVALID_VIEW_STATE,
        START_DATE_IN_PAST,
        END_DATE_IN_PAST,
        END_DATE_BEFORE_START_DATE
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: GuildScheduledEventSettingsViewModel.kt */
        public static final /* data */ class Initialized extends ViewState {
            private final GuildScheduledEventModel eventModel;
            private final GuildScheduledEvent existingEvent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(GuildScheduledEventModel guildScheduledEventModel, GuildScheduledEvent guildScheduledEvent) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "eventModel");
                this.eventModel = guildScheduledEventModel;
                this.existingEvent = guildScheduledEvent;
            }

            public static /* synthetic */ Initialized copy$default(Initialized initialized, GuildScheduledEventModel guildScheduledEventModel, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildScheduledEventModel = initialized.eventModel;
                }
                if ((i & 2) != 0) {
                    guildScheduledEvent = initialized.existingEvent;
                }
                return initialized.copy(guildScheduledEventModel, guildScheduledEvent);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            /* renamed from: component2, reason: from getter */
            public final GuildScheduledEvent getExistingEvent() {
                return this.existingEvent;
            }

            public final Initialized copy(GuildScheduledEventModel eventModel, GuildScheduledEvent existingEvent) {
                Intrinsics3.checkNotNullParameter(eventModel, "eventModel");
                return new Initialized(eventModel, existingEvent);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return Intrinsics3.areEqual(this.eventModel, initialized.eventModel) && Intrinsics3.areEqual(this.existingEvent, initialized.existingEvent);
            }

            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            public final GuildScheduledEvent getExistingEvent() {
                return this.existingEvent;
            }

            public int hashCode() {
                GuildScheduledEventModel guildScheduledEventModel = this.eventModel;
                int iHashCode = (guildScheduledEventModel != null ? guildScheduledEventModel.hashCode() : 0) * 31;
                GuildScheduledEvent guildScheduledEvent = this.existingEvent;
                return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Initialized(eventModel=");
                sbM833U.append(this.eventModel);
                sbM833U.append(", existingEvent=");
                sbM833U.append(this.existingEvent);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* compiled from: GuildScheduledEventSettingsViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setDescription$1 */
    public static final class C88251 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ String $description;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88251(String str) {
            super(1);
            this.$description = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, null, null, null, this.$description, null, null, null, null, 7935, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setEndDate$1 */
    public static final class C88261 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDateTime2 $newEndDate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88261(GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2) {
            super(1);
            this.$newEndDate = guildScheduledEventPickerDateTime2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, null, this.$newEndDate, null, null, null, null, null, null, 8127, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setEndTime$1 */
    public static final class C88271 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDateTime3 $newEndTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88271(GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3) {
            super(1);
            this.$newEndTime = guildScheduledEventPickerDateTime3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, null, null, this.$newEndTime, null, null, null, null, null, 8063, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setStartDate$1 */
    public static final class C88281 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDateTime2 $newStartDate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88281(GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2) {
            super(1);
            this.$newStartDate = guildScheduledEventPickerDateTime2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, this.$newStartDate, null, null, null, null, null, null, null, null, 8175, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setStartTime$1 */
    public static final class C88291 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDateTime3 $newStartTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88291(GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3) {
            super(1);
            this.$newStartTime = guildScheduledEventPickerDateTime3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, this.$newStartTime, null, null, null, null, null, null, null, 8159, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setTopic$1 */
    public static final class C88301 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ String $topic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88301(String str) {
            super(1);
            this.$topic = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, this.$topic, null, null, null, null, null, null, null, null, null, null, null, 8189, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$toggleBroadcastToDirectoryChannel$1 */
    public static final class C88311 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ boolean $associateToHubs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88311(boolean z2) {
            super(1);
            this.$associateToHubs = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(this.$associateToHubs), 4095, null);
        }
    }

    public /* synthetic */ GuildScheduledEventSettingsViewModel(long j, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l2, String str, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, guildScheduledEventEntityType, l2, str, (i & 32) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    private final Unit updateEventModel(Function1<? super GuildScheduledEventModel, GuildScheduledEventModel> updateEventModel) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized == null) {
            return null;
        }
        updateViewState(ViewState.Initialized.copy$default(initialized, updateEventModel.invoke(initialized.getEventModel()), null, 2, null));
        return Unit.f27425a;
    }

    public final boolean hasEndTimeChanged(ViewState.Initialized viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (viewState.getExistingEvent() == null) {
            return true;
        }
        if (viewState.getEventModel().getEndDate() == null || viewState.getEventModel().getEndTime() == null) {
            return viewState.getExistingEvent().getScheduledEndTime() == null;
        }
        long millis = GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getEndDate(), viewState.getEventModel().getEndTime());
        UtcDateTime scheduledEndTime = viewState.getExistingEvent().getScheduledEndTime();
        Long lValueOf = scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null;
        return lValueOf == null || millis != lValueOf.longValue();
    }

    public final boolean hasStartTimeChanged(ViewState.Initialized viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        return viewState.getExistingEvent() == null || GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime()) != viewState.getExistingEvent().getScheduledStartTime().getDateTimeMillis();
    }

    public final boolean isDateInFuture(GuildScheduledEventPickerDateTime2 date, GuildScheduledEventPickerDateTime3 time) {
        return date == null || time == null || GuildScheduledEventPickerDateTime.INSTANCE.toMillis(date, time) >= ClockFactory.get().currentTimeMillis();
    }

    public final boolean isNextButtonEnabled() {
        GuildScheduledEventModel eventModel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized == null || (eventModel = initialized.getEventModel()) == null) {
            return false;
        }
        String name = eventModel.getName();
        if (name == null || name.length() == 0) {
            return false;
        }
        return (eventModel.getEntityType() == GuildScheduledEventEntityType.EXTERNAL && (eventModel.getEndDate() == null || eventModel.getEndTime() == null)) ? false : true;
    }

    public final boolean isStartDateBeforeEndDate(GuildScheduledEventPickerDateTime2 startDate, GuildScheduledEventPickerDateTime3 startTime, GuildScheduledEventPickerDateTime2 endDate, GuildScheduledEventPickerDateTime3 endTime) {
        Intrinsics3.checkNotNullParameter(startDate, "startDate");
        Intrinsics3.checkNotNullParameter(startTime, "startTime");
        if (endDate == null || endTime == null) {
            return endDate == null || endDate.toMillis() >= startDate.toMillis();
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        return guildScheduledEventPickerDateTime.toMillis(endDate, endTime) > guildScheduledEventPickerDateTime.toMillis(startDate, startTime);
    }

    public final Unit setDescription(String description) {
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return updateEventModel(new C88251(description));
    }

    public final DateError setEndDate(int year, int month, int dayOfMonth) {
        if (updateEventModel(new C88261(new GuildScheduledEventPickerDateTime2(year, month, dayOfMonth))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setEndTime(int hourOfDay, int minute) {
        if (updateEventModel(new C88271(new GuildScheduledEventPickerDateTime3(hourOfDay, minute, 0))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setStartDate(int year, int month, int dayOfMonth) {
        if (updateEventModel(new C88281(new GuildScheduledEventPickerDateTime2(year, month, dayOfMonth))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setStartTime(int hourOfDay, int minute) {
        if (updateEventModel(new C88291(new GuildScheduledEventPickerDateTime3(hourOfDay, minute, 0))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final Unit setTopic(String topic) {
        Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        return updateEventModel(new C88301(topic));
    }

    public final Unit toggleBroadcastToDirectoryChannel(boolean associateToHubs) {
        return updateEventModel(new C88311(associateToHubs));
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public GuildScheduledEventSettingsViewModel(long r22, java.lang.Long r24, com.discord.api.guildscheduledevent.GuildScheduledEventEntityType r25, java.lang.Long r26, java.lang.String r27, com.discord.stores.StoreGuildScheduledEvents r28) {
        /*
            r21 = this;
            r0 = r21
            r12 = r25
            r5 = r27
            r1 = r28
            java.lang.String r2 = "entityType"
            p507d0.p592z.p594d.Intrinsics3.checkNotNullParameter(r12, r2)
            java.lang.String r2 = "guildScheduledEventsStore"
            p507d0.p592z.p594d.Intrinsics3.checkNotNullParameter(r1, r2)
            r2 = 0
            r15 = 1
            r0.<init>(r2, r15, r2)
            if (r24 == 0) goto L26
            long r3 = r24.longValue()
            java.lang.Long r6 = java.lang.Long.valueOf(r22)
            com.discord.api.guildscheduledevent.GuildScheduledEvent r1 = r1.findEventFromStore(r3, r6)
            goto L27
        L26:
            r1 = r2
        L27:
            if (r1 == 0) goto L57
            com.discord.widgets.guildscheduledevent.GuildScheduledEventModel r18 = com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2.toModel(r1)
            if (r18 == 0) goto L57
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata$Companion r13 = com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata.INSTANCE
            com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata r13 = r13.m7992a(r12, r5)
            r14 = 0
            r16 = 0
            r19 = 1
            r15 = r16
            r16 = 6651(0x19fb, float:9.32E-42)
            r17 = 0
            r20 = r1
            r1 = r18
            r5 = r26
            r0 = r12
            r12 = r25
            com.discord.widgets.guildscheduledevent.GuildScheduledEventModel r2 = com.discord.widgets.guildscheduledevent.GuildScheduledEventModel.copy$default(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L5c
        L57:
            r20 = r1
            r0 = r12
            r19 = 1
        L5c:
            com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDateTime r1 = com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDateTime.INSTANCE
            kotlin.Pair r3 = r1.generateAppropriateStartDateTime()
            com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$ViewState$Initialized r12 = new com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$ViewState$Initialized
            if (r2 == 0) goto L68
            r0 = r12
            goto L9c
        L68:
            com.discord.widgets.guildscheduledevent.GuildScheduledEventModel r18 = new com.discord.widgets.guildscheduledevent.GuildScheduledEventModel
            r1 = r18
            r4 = 0
            r6 = 0
            java.lang.Object r2 = r3.getFirst()
            r7 = r2
            com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDate r7 = (com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDateTime2) r7
            java.lang.Object r2 = r3.getSecond()
            r8 = r2
            com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerTime r8 = (com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDateTime3) r8
            r9 = 0
            r10 = 0
            r11 = 0
            com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata$Companion r2 = com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata.INSTANCE
            r3 = r27
            com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata r13 = r2.m7992a(r0, r3)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r19)
            r15 = 0
            r16 = 4096(0x1000, float:5.74E-42)
            r17 = 0
            r2 = r22
            r5 = r26
            r0 = r12
            r12 = r25
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r2 = r18
        L9c:
            r1 = r20
            r0.<init>(r2, r1)
            r1 = r21
            r1.updateViewState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel.<init>(long, java.lang.Long, com.discord.api.guildscheduledevent.GuildScheduledEventEntityType, java.lang.Long, java.lang.String, com.discord.stores.StoreGuildScheduledEvents):void");
    }

    public final boolean isStartDateBeforeEndDate(ViewState.Initialized viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        return isStartDateBeforeEndDate(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime(), viewState.getEventModel().getEndDate(), viewState.getEventModel().getEndTime());
    }
}
