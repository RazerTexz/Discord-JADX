package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.GuildEventPromptListViewBinding;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: GuildEventPromptListView.kt */
/* loaded from: classes2.dex */
public final class GuildEventPromptListView extends LinearLayout {
    private final GuildEventPromptListViewBinding binding;

    /* compiled from: GuildEventPromptListView.kt */
    public static final /* data */ class ScheduledEventData {
        private final GuildScheduledEvent guildScheduledEvent;
        private final Function0<Unit> onScheduledEventClick;

        public ScheduledEventData(GuildScheduledEvent guildScheduledEvent, Function0<Unit> function0) {
            m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            m.checkNotNullParameter(function0, "onScheduledEventClick");
            this.guildScheduledEvent = guildScheduledEvent;
            this.onScheduledEventClick = function0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScheduledEventData copy$default(ScheduledEventData scheduledEventData, GuildScheduledEvent guildScheduledEvent, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                guildScheduledEvent = scheduledEventData.guildScheduledEvent;
            }
            if ((i & 2) != 0) {
                function0 = scheduledEventData.onScheduledEventClick;
            }
            return scheduledEventData.copy(guildScheduledEvent, function0);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final Function0<Unit> component2() {
            return this.onScheduledEventClick;
        }

        public final ScheduledEventData copy(GuildScheduledEvent guildScheduledEvent, Function0<Unit> onScheduledEventClick) {
            m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            m.checkNotNullParameter(onScheduledEventClick, "onScheduledEventClick");
            return new ScheduledEventData(guildScheduledEvent, onScheduledEventClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduledEventData)) {
                return false;
            }
            ScheduledEventData scheduledEventData = (ScheduledEventData) other;
            return m.areEqual(this.guildScheduledEvent, scheduledEventData.guildScheduledEvent) && m.areEqual(this.onScheduledEventClick, scheduledEventData.onScheduledEventClick);
        }

        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final Function0<Unit> getOnScheduledEventClick() {
            return this.onScheduledEventClick;
        }

        public int hashCode() {
            GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
            int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
            Function0<Unit> function0 = this.onScheduledEventClick;
            return iHashCode + (function0 != null ? function0.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ScheduledEventData(guildScheduledEvent=");
            sbU.append(this.guildScheduledEvent);
            sbU.append(", onScheduledEventClick=");
            sbU.append(this.onScheduledEventClick);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configure$default(GuildEventPromptListView guildEventPromptListView, ScheduledEventData scheduledEventData, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            scheduledEventData = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        guildEventPromptListView.configure(scheduledEventData, function0, function02);
    }

    public final void configure(ScheduledEventData scheduledEventData, Function0<Unit> onCreateEventClick, Function0<Unit> onStartStageClick) {
        GuildEventPromptView guildEventPromptView = this.binding.d;
        guildEventPromptView.setVisibility(onStartStageClick != null ? 0 : 8);
        String string = guildEventPromptView.getContext().getString(R.string.stage_channel_start_title);
        m.checkNotNullExpressionValue(string, "context.getString(R.stri…tage_channel_start_title)");
        String string2 = guildEventPromptView.getContext().getString(R.string.stage_channel_start_subtitle);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_channel_start_subtitle)");
        guildEventPromptView.configure(R.drawable.ic_channel_stage_24dp, R.color.status_green_600, string, string2);
        guildEventPromptView.setOnClickListener(new GuildEventPromptListView$configure$$inlined$apply$lambda$1(onStartStageClick));
        GuildEventPromptView guildEventPromptView2 = this.binding.f2116b;
        guildEventPromptView2.setVisibility(onCreateEventClick != null ? 0 : 8);
        String string3 = guildEventPromptView2.getContext().getString(R.string.schedule_event);
        m.checkNotNullExpressionValue(string3, "context.getString(R.string.schedule_event)");
        String string4 = guildEventPromptView2.getContext().getString(R.string.schedule_event_description);
        m.checkNotNullExpressionValue(string4, "context.getString(R.stri…hedule_event_description)");
        guildEventPromptView2.configure(R.drawable.ic_event_20dp, R.color.brand_new_500, string3, string4);
        guildEventPromptView2.setOnClickListener(new GuildEventPromptListView$configure$$inlined$apply$lambda$2(onCreateEventClick));
        GuildEventPromptView guildEventPromptView3 = this.binding.c;
        guildEventPromptView3.setVisibility(scheduledEventData != null ? 0 : 8);
        if (scheduledEventData != null) {
            GuildScheduledEvent guildScheduledEvent = scheduledEventData.getGuildScheduledEvent();
            String name = guildScheduledEvent.getName();
            Context context = guildEventPromptView3.getContext();
            m.checkNotNullExpressionValue(context, "context");
            guildEventPromptView3.configure(R.drawable.ic_event_20dp, R.color.status_green_600, name, GuildScheduledEventUtilitiesKt.getEventStartingTimeString(guildScheduledEvent, context));
            guildEventPromptView3.setOnClickListener(new GuildEventPromptListView$configure$$inlined$apply$lambda$3(scheduledEventData));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }
}
