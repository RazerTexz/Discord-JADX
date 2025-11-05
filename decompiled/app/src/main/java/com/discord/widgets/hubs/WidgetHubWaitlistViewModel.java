package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubWaitlistViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetHubWaitlistViewModel extends d0<HubWaitlistState> {
    private final String email;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubWaitlistViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlistViewModel$joinWaitlist$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RestCallState<? extends WaitlistSignup>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends WaitlistSignup> restCallState) {
            invoke2((RestCallState<WaitlistSignup>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<WaitlistSignup> restCallState) {
            m.checkNotNullParameter(restCallState, "async");
            HubWaitlistState hubWaitlistStateAccess$getViewState$p = WidgetHubWaitlistViewModel.access$getViewState$p(WidgetHubWaitlistViewModel.this);
            if (hubWaitlistStateAccess$getViewState$p != null) {
                WidgetHubWaitlistViewModel.access$updateViewState(WidgetHubWaitlistViewModel.this, hubWaitlistStateAccess$getViewState$p.copy(restCallState));
            }
        }
    }

    public /* synthetic */ WidgetHubWaitlistViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ HubWaitlistState access$getViewState$p(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel) {
        return widgetHubWaitlistViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel, HubWaitlistState hubWaitlistState) {
        widgetHubWaitlistViewModel.updateViewState(hubWaitlistState);
    }

    public final String getEmail() {
        return this.email;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinWaitlist(String school) {
        m.checkNotNullParameter(school, "school");
        RestCallStateKt.executeRequest(this.restAPI.joinHubWaitlist(new RestAPIParams.HubWaitlist(this.email, school)), new AnonymousClass1());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlistViewModel(String str, RestAPI restAPI) {
        super(new HubWaitlistState(null, 1, null));
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.restAPI = restAPI;
    }
}
